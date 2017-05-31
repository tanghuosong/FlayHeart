package com.fly.heart.service;

import com.fly.heart.utils.Message;
import org.springframework.stereotype.Service;

/**
 * created by tanghuosong 2017/5/30
 * description:
 **/
@Service
public interface ManagerService {

    Message managerLogin(String name, String password);
}
