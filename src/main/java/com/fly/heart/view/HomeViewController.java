package com.fly.heart.view;

import com.fly.heart.bean.User;
import com.fly.heart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by tanghuosong 2017/5/29
 * description: 前台页面控制器
 **/
@RequestMapping(value = "/")
@Controller
public class HomeViewController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index.html",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(ModelAndView modelAndView){
        User user = userService.getUserById(1L);
        modelAndView = new ModelAndView();
        modelAndView.addObject(user);
        return modelAndView;
    }


    @RequestMapping(value = "/home/login.html",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView login(ModelAndView modelAndView){
        return modelAndView;
    }

}

