package com.fly.heart.dao;

import com.fly.heart.bean.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Timestamp;
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

    User findUserByNameAndPassword(String name,String password);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update User u set u.lastLoginTime = :lastLoginTime where u.id = :id")
    int updateLastLoginTimeByUserId(@Param("lastLoginTime")Timestamp timestamp,@Param("id")long id);
}
