package com.fly.heart.service.impl;

import com.fly.heart.bean.User;
import com.fly.heart.dao.UserDao;
import com.fly.heart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public Map<String, Object> getAllUsers() {
        Map<String , Object> map = new HashMap<>();
        List<User> list = userDao.findAll();
        int count = list.size();
        map.put("userList",list);
        map.put("count",count);
        return map;
    }

    @Override
    public User getUserById(Long id) {
        return userDao.findOne(id);
    }
}
