package com.fly.heart.view;

import com.fly.heart.bean.Manager;
import com.fly.heart.bean.Topic;
import com.fly.heart.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * created by tanghuosong 2017/5/29
 * description: 后台页面控制器
 **/

@RequestMapping(value = "/admin")
@Controller
public class ManagerViewController {

    @Autowired
    HttpSession session;
    @Autowired
    TopicService topicService;

    @RequestMapping(value = "/login.html",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView login(ModelAndView modelAndView){
        return modelAndView;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(ModelAndView modelAndView){
        Manager manager = (Manager) session.getAttribute("manager");
        modelAndView = new ModelAndView();
        modelAndView.addObject(manager);
        return modelAndView;
    }

    @RequestMapping(value = "/allUsers",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView allUsers(ModelAndView modelAndView){
        return modelAndView;
    }
    @RequestMapping(value = "/allTopics",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView allTopics(ModelAndView modelAndView){
        return modelAndView;
    }

}
