package com.fly.heart.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * created by tanghuosong 2017/5/30
 * description:
 **/
@Service
public interface ManagerService {

    Map<String,Object> managerLogin(String name,String password);
}
