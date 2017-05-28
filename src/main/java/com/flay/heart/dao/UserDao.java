package com.flay.heart.dao;

import com.flay.heart.bean.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/

public interface UserDao extends CrudRepository<User,Long>{

    @Override
    List<User> findAll();

    @Override
    User findOne(Long id);
}
