package com.fly.heart.dao;

import com.fly.heart.bean.Manager;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * created by tanghuosong 2017/5/30
 * description:
 **/
public interface ManagerDao extends CrudRepository<Manager,Long> {


    Manager findManagerByNameAndPassword(String name,String password );

    List<Manager> findAll();

}
