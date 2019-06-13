package cn.edu.zzti.pi.smzdm.controller;

import cn.edu.zzti.pi.smzdm.model.ArticleModel;
import cn.edu.zzti.pi.smzdm.model.UserModel;
import cn.edu.zzti.pi.smzdm.task.ScheduledTasks;
import cn.edu.zzti.pi.smzdm.utils.CollectionUtils;
import cn.edu.zzti.pi.smzdm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private ScheduledTasks scheduledTasks;

    @RequestMapping("/")
    public String index() {
        return "redirect:/smzdm?name=Qi";
    }

    @RequestMapping("/smzdm")
    public ModelAndView smzdm(
            @RequestParam String name,
            @RequestParam(defaultValue = "DEFAULT") String sort) {
        List<ArticleModel> list = scheduledTasks.getArticleModels(name);
        SortType.valueOf(sort).sort(list);

        Map<String, Object> model = new HashMap<>();
        model.put("worthAtircles", list);
        return new ModelAndView("smzdm_worth_articles", model);
    }

    @RequestMapping("/donation")
    public String donation() {
        return "donation";
    }

    @RequestMapping("/red_package")
    public String redPackage() {
        return "red_package";
    }

    private enum SortType {
        // 数据列表对 评论数 逆序排序
        DEFAULT{
            @Override
            public void sort(List<ArticleModel> list) {
                list.sort((o1, o2) -> {
                    return -StringUtils.parse2Integer(o1.getArticleComment()).compareTo(StringUtils.parse2Integer(o2.getArticleComment()));
                });
            }
        },
        // 时间新旧排序
        NEWEST{
            @Override
            public void sort(List<ArticleModel> list) {
                list.sort((o1, o2) -> {
                    return -StringUtils.parse2Long(o1.getTimesort()).compareTo(StringUtils.parse2Long(o2.getTimesort()));
                });
            }
        },
        // 热度（单位时间评论最多）
        HOTTEST{
            @Override
            public void sort(List<ArticleModel> list) {
                long now = System.currentTimeMillis();
                list.sort((o1, o2) -> {
                    Float comment1 = Float.parseFloat(o1.getArticleComment());
                    Float postTime1 = new Float(now - StringUtils.parse2Long(o1.getTimesort()) * 10);

                    Float comment2 = Float.parseFloat(o2.getArticleComment());
                    Float postTime2 = new Float(now - StringUtils.parse2Long(o2.getTimesort()) * 10);

                    return -Float.valueOf(comment1 / postTime1).compareTo(Float.valueOf(comment2 / postTime2));
                });
            }
        }
        ;

        public abstract void sort(List<ArticleModel> list);
    }
}
