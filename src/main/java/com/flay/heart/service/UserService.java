package com.flay.heart.service;

import com.flay.heart.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Service
public interface UserService {

    List<User> getAllUser();

    Map<String, Object> getAllUsers();

    User getUserById(Long id);
}
