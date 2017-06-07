package com.fly.heart.service;

import com.fly.heart.bean.User;
import com.fly.heart.utils.Message;
import org.springframework.data.domain.Page;
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

    Map<String,Object> userLogin(String name,String password);

    Message userRegister(User user);

    Page<User> getAllUserByStateWithPage(Long state, Integer pageNum, Integer pageSize);
}
