package com.fly.heart.view;

import com.fly.heart.bean.Manager;
import com.fly.heart.bean.User;
import com.fly.heart.service.ManagerService;
import com.fly.heart.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

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
    ManagerService managerService;

    @RequestMapping(value = "/login.html",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.addObject("manager");
        return modelAndView;
    }

    @RequestMapping(value = "/index.html",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(ModelAndView modelAndView){
        Manager manager = (Manager) session.getAttribute("manager");
        modelAndView = new ModelAndView();
        modelAndView.addObject(manager);
        return modelAndView;
    }

    @RequestMapping(value = "/managerLogin",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView managerLogin(@ModelAttribute Manager manager){
        System.out.println(manager.toString());
        Map<String,Object > map = managerService.managerLogin(manager.getName(),manager.getPassword());
        System.out.println(map.get("manager").toString());
        if(((Message)map.get("message")).isSuccess()){
            return new ModelAndView("/admin/index.html");
        }else{
            ModelAndView modelAndView =new ModelAndView("/admin/login.html");
            modelAndView.addObject(map);
            return modelAndView;
        }
    }
}
