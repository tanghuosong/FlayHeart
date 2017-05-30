package com.fly.heart.service.impl;

import com.fly.heart.bean.Manager;
import com.fly.heart.dao.ManagerDao;
import com.fly.heart.service.ManagerService;
import com.fly.heart.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * created by tanghuosong 2017/5/30
 * description:
 **/
@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    ManagerDao managerDao;
    @Autowired
    HttpSession session ;


    @Override
    public Map<String, Object> managerLogin(String name, String password) {
        Message message = new Message();
        Map<String,Object> map = new HashMap<>();
        Manager manager = null;
        if(null == name || "".equals(name) || null == password || "".equals(password)){
            message.setSuccess(false);
            message.setContent("请输入管理员账号和密码！");
        }else{
            try{
                manager = managerDao.findManagerByNameAndPassword(name, password);
                if(null ==manager){
                    message.setContent("账号或密码错误！");
                    message.setSuccess(false);
                }else{
                    session.setAttribute("manager",manager);
                    message.setContent("登录成功！");
                    message.setSuccess(true);
                }
            }catch (Exception e){
                message.setSuccess(false);
                message.setContent("系统异常，登录失败:"+e.getMessage());
            }
        }
        map.put("message",message);
        map.put("manager",manager);
        return map;
    }
}
