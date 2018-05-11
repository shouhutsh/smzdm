package cn.edu.zzti.pi.smzdm.task;

import cn.edu.zzti.pi.smzdm.model.ArticleModel;
import cn.edu.zzti.pi.smzdm.model.ConfigModel;
import cn.edu.zzti.pi.smzdm.model.MailModel;
import cn.edu.zzti.pi.smzdm.model.UserModel;
import cn.edu.zzti.pi.smzdm.service.ConfigService;
import cn.edu.zzti.pi.smzdm.service.MailService;
import cn.edu.zzti.pi.smzdm.service.UserService;
import cn.edu.zzti.pi.smzdm.service.filter.FilterProxy;
import cn.edu.zzti.pi.smzdm.utils.DateUtils;
import cn.edu.zzti.pi.smzdm.utils.MapUtils;
import cn.edu.zzti.pi.smzdm.utils.Sender;
import com.alibaba.fastjson.JSONObject;
import freemarker.template.Configuration;
import org.apache.http.client.methods.HttpRequestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.*;

/**
 * 定时任务
 */
@Component
public class ScheduledTasks {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * SMZDM 数据列表接口，timesort 类时间戳（timestamp / 10）
     */
    private static final String URL_TEMPLATE = "https://m.smzdm.com/ajax_home_list_show?timesort=%s";

    @Value("${spring.mail.username}")
    private String fromEMail;

    @Autowired
    private MailService mailService;
    @Autowired
    private FilterProxy filterProxy;
    @Autowired
    private UserService userService;
    @Autowired
    private ConfigService configService;
    @Autowired
    private Configuration freemarkerConfig;

    // 简单为Controller提供一个视图
    private static volatile Map<UserModel, List<ArticleModel>> CACHE;

    public List<ArticleModel> getArticleModels(String userName) {
        if (null != userName && CACHE != null) {
            for (Map.Entry<UserModel, List<ArticleModel>> e : CACHE.entrySet()) {
                if (e.getKey().getName().equals(userName)) {
                    return e.getValue();
                }
            }
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * 定时抓取SMZDM内容
     */
    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void crawlContentForSmzdmTask() {
        try {
            logger.info("开始定时抓取SMZDM任务！");
            Long start = DateUtils.getTimestamp();
            Long end = DateUtils.getTimestamp(DateUtils.addDay(DateUtils.getNow(), -1));

            Map<UserModel, List<ArticleModel>> map = doCrawlContent(start, end);
            CACHE = map;
            logger.info("抓取数据完成，准备发送用户邮件！");
            for (Map.Entry<UserModel, List<ArticleModel>> e : map.entrySet()) {
                // 数据列表对 评论数 逆序排序
                e.getValue().sort(Comparator.comparing(ArticleModel::getArticleComment).reversed());
                sendMail(e.getKey(), e.getValue());
            }
        } catch (Exception e) {
            logger.error("定时抓取SMZDM任务失败！", e);
        }
    }

    /**
     * 抓取时间区间内的消息，并归档
     *
     * @param startTimestamp
     * @param endTimestamp
     * @return
     * @throws Exception
     */
    private Map<UserModel, List<ArticleModel>> doCrawlContent(Long startTimestamp, Long endTimestamp) throws Exception {
        if (null == startTimestamp) {
            startTimestamp = DateUtils.getTimestamp();
        }
        if (null == endTimestamp) {
            endTimestamp = DateUtils.getTimestamp(DateUtils.addDay(DateUtils.getNow(), -1));
        }

        logger.info(String.format("抓取时间区间：start=%s，end=%s", new Date(startTimestamp), new Date(endTimestamp)));
        Map<UserModel, List<ArticleModel>> map = new HashMap<>();

        long timesort = getTimesort(startTimestamp);
        while (timesort > getTimesort(endTimestamp)) {
            String url = String.format(URL_TEMPLATE, timesort);

            HttpRequestBase request = Sender.buildGetRequest(url);
            request.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            request.setHeader("Host", "m.smzdm.com");
            request.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

            List<UserModel> userModels = userService.selectAllUsers();

            JSONObject json = JSONObject.parseObject(Sender.send(request));
            List<ArticleModel> articleModels = JSONObject.parseArray(json.getString("data"), ArticleModel.class);
            for (ArticleModel article : articleModels) {
                timesort = Long.valueOf(article.getTimesort());

                for (UserModel user : userModels) {
                    ConfigModel config = configService.getUserConfig(user);
                    if (filterProxy.isWorth(config, article)) {
                        MapUtils.put(map, user, article);
                    }
                }
            }
        }
        return map;
    }

    /**
     * 根据送入时间戳生成 timesort
     * @param time
     * @return
     */
    private long getTimesort(Long time) {
        return time / 10;
    }

    /**
     * 根据用户信息配置，发送邮件
     *
     * @param user
     * @param worthArticles
     * @return
     * @throws Exception
     */
    private boolean sendMail(UserModel user, List<ArticleModel> worthArticles) throws Exception {
        ConfigModel config = configService.getUserConfig(user);
        if (!DateUtils.currentHourInRange(config.getEnableStartHour(), config.getEnableEndHour())) {
            logger.warn(String.format("不在用户%s(%s)发送时间区间！", user.getId(), user.getName()));
            return false;
        }

        logger.info(String.format("准备为用户%s(%s)发送邮件！", user.getId(), user.getName()));
        Map<String, Object> model = new HashMap<>();
        model.put("worthAtircles", worthArticles);
        String text = buildContent("smzdm_worth_articles.ftl", model);

        MailModel mail = new MailModel();
        mail.setFrom(fromEMail);
        mail.setTo(new String[]{config.getEmail()});
        mail.setSubject("什么值得买");
        mail.setText(text);
        return mailService.sendMail(mail);
    }

    /**
     * 使用FreeMarker填充模板
     * @param template
     * @param model
     * @return
     * @throws Exception
     */
    private String buildContent(String template, Map<String, Object> model) throws Exception {
        return FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfig.getTemplate(template), model);
    }
}
