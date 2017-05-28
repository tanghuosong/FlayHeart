package com.flay.heart.controller.impl;

import com.flay.heart.bean.User;
import com.flay.heart.controller.UserController;
import com.flay.heart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Controller
public class UserControllerImpl implements UserController{

    public UserControllerImpl(){
        System.out.println("进入-----UserControllerImpl");
    }

    @Autowired
    UserService userService ;

    @Override
    public List<User> getAll() {
        return  userService.getAllUser();
    }

    @Override
    public Map<String, Object> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userService.getUserById(id);
    }
}
