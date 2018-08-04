package cn.edu.zzti.pi.smzdm.controller;

import cn.edu.zzti.pi.smzdm.task.ScheduledTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
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
    public ModelAndView smzdm(@RequestParam String name) {
        Map<String, Object> model = new HashMap<>();
        model.put("worthAtircles", scheduledTasks.getArticleModels(name));
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
}
