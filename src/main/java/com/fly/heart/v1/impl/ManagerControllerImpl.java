package com.fly.heart.v1.impl;

import com.fly.heart.service.ManagerService;
import com.fly.heart.utils.Message;
import com.fly.heart.v1.ManagerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * created by tanghuosong 2017/5/31
 * description:
 **/
@Controller
public class ManagerControllerImpl implements ManagerController{

    @Autowired
    ManagerService managerService;
    @Override
    public Message managerLogin(String name, String password) {
        return managerService.managerLogin(name,password);
    }
}
