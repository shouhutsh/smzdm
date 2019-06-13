package cn.edu.zzti.pi.smzdm.task;

import cn.edu.zzti.pi.smzdm.model.*;
import cn.edu.zzti.pi.smzdm.service.ConfigService;
import cn.edu.zzti.pi.smzdm.service.MailService;
import cn.edu.zzti.pi.smzdm.service.UserService;
import cn.edu.zzti.pi.smzdm.service.filter.FilterProxy;
import cn.edu.zzti.pi.smzdm.utils.*;
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
import java.util.concurrent.ConcurrentHashMap;

/**
 * 定时任务
 */
@Component
public class ScheduledTasks {

    Logger logger = LoggerFactory.getLogger(getClass());

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
    private static volatile Map<UserModel, List<ArticleModel>> CACHE = new ConcurrentHashMap<>();

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
    @Scheduled(fixedRate = Constants.TASK_SMZDM_CRAWL_FIXED_RATE)
    public void crawlContentForSmzdmTask() {
        try {
            logger.info("开始定时抓取SMZDM任务！");
            Long start = DateUtils.getTimestamp();
            Long end = DateUtils.getTimestamp(DateUtils.addDay(DateUtils.getNow(), -1));

            Map<UserModel, List<ArticleModel>> map = doCrawlContent(start, end);
            for (Map.Entry<UserModel, List<ArticleModel>> e : map.entrySet()) {
                List<ArticleModel> articles = CollectionUtils.unique(e.getValue(), Comparator.comparing(ArticleModel::getArticleId));
                CACHE.put(e.getKey(), articles);
//                sendMail(e.getKey(), articles);
            }
        } catch (Exception e) {
            logger.error("定时抓取SMZDM任务失败！", e);
        }
    }

    /**
     * SMZDM签到
     */
    @Scheduled(fixedRate = Constants.TASK_SMZDM_CHECKIN_FIXED_RATE)
    public void smzdmCheckin() {
        try {
            for (UserModel user : userService.selectAllUsers()) {
                logger.info("为用户{}自动签到！", user.getName());
                ConfigModel config = configService.getUserConfig(user);
                if (StringUtils.isEmpty(config.getSmzdmName()) || StringUtils.isEmpty(config.getSmzdmPassword())) {
                    continue;
                }

                boolean success = smzdmCheckin(config.getSmzdmName(), config.getSmzdmPassword());
                if (success) {
                    logger.info("用户{}自动签到成功！", user.getName());
                } else {
                    logger.warn("用户{}自动签到失败！", user.getName());
                }
            }
        } catch (Exception e) {
            logger.error("自动签到失败！", e);
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
            String url = String.format(Constants.ARTICLES_URL, timesort);

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
                        CollectionUtils.put(map, user, article);
                    }
                }
            }
        }
        return map;
    }

    /**
     * smzdm自动签到
     * @param name
     * @param password
     * @return
     */
    private boolean smzdmCheckin(String name, String password) {
        try {
            Session session = Sender.buildSession();

            HttpRequestBase req = Sender.buildGetRequest(Constants.SMZDM_URL);
            setHeader(req);
            session.send(req);

            Map<String, String> map = new HashMap<>();
            map.put("username", name);
            map.put("password", password);

            req = Sender.buildPostRequest(Constants.LOGIN_URL, map);
            setHeader(req);
            JSONObject json = JSONObject.parseObject(session.send(req));
            logger.info("登陆接收到的报文：{}", json);

            req = Sender.buildGetRequest(Constants.CHECKIN_URL);
            setHeader(req);
            json = JSONObject.parseObject(session.send(req));
            logger.info("签到接收到的报文：{}", json);
            return json.getIntValue("error_code") == 0;
        } catch (Exception e) {
            logger.error("SMZDM自动签到失败！", e);
            return false;
        }
    }

    private static void setHeader(HttpRequestBase request) {
        request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:20.0) Gecko/20100101 Firefox/20.0");
        request.setHeader("Host", "zhiyou.smzdm.com");
        request.setHeader("Referer", "http://www.smzdm.com/");
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
        mail.setTo(config.getEmail().split(","));
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
