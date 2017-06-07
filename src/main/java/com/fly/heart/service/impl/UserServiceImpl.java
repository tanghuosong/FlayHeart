package com.fly.heart.service.impl;

import com.fly.heart.bean.User;
import com.fly.heart.dao.UserDao;
import com.fly.heart.service.UserService;
import com.fly.heart.utils.Message;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by tanghuosong 2017/5/28
 * description:
 **/
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    HttpSession session;
    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public Page<User> getAllUserByStateWithPage(Long state, Integer pageNum, Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(pageNum-1,pageSize,sort);
        Page<User> page ;
        switch (state.intValue()){
            case 0:
                page = userDao.findAll(pageable);
                break;
            default:
                page = userDao.findAllByState(state,pageable);
                break;
        }
        for(User u : page.getContent()){
            u.setPassword("");
        }
        return page;
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

    @Override
    public Map<String,Object> userLogin(String name, String password) {
        Map<String, Object> map = new HashMap<>();
        Message message = new Message();
        User user = null;
        if(null == name || "".equals(name) || null == password || "".equals(password)){
            message.setContent("用户名、密码不能为空！");
            message.setSuccess(false);
        }else{
            user = userDao.findUserByNameAndPassword(name,password);
            if(user != null){
                // 更新最后登录时间
                int result = userDao.updateLastLoginTimeByUserId(new Timestamp(System.currentTimeMillis()),user.getId());
                if(result ==1){
                    message.setContent("登录成功！");
                    message.setSuccess(true);
                    logger.info("用户["+user.getName()+"]登录了！");
                    session.setAttribute("user",user);
                }
            }else{
                message.setContent("用户名或密码错误！");
                message.setSuccess(false);
            }
        }
        map.put("message",message);
        map.put("user",user);
        return map;
    }

    @Override
    public Message userRegister(User user) {
        Message message = new Message();

        if(null == user.getName() || "".equals(user.getName())){
            message.setSuccess(false);
            message.setContent("用户名不能为空！");
            return message;
        }else if(null == user.getPassword() || "".equals(user.getPassword())){
            message.setSuccess(false);
            message.setContent("密码不能为空！");
            return message;
        }else if(null == user.getPhone() || "".equals(user.getPhone())){
            message.setSuccess(false);
            message.setContent("手机号不为空！");
            return message;
        }else if(null == user.getEmail() || "".equals(user.getEmail())){
            message.setSuccess(false);
            message.setContent("邮箱不能为空！");
            return message;
        }else if(null == user.getSex() || "".equals(user.getSex())){
            message.setSuccess(false);
            message.setContent("请选择性别！");
            return message;
        }else{
            try{
                user.setState(100L);
                user.setStateDisplay("正常");
                user.setFocusCount(0L);
                user.setRegisterTime(new Timestamp(System.currentTimeMillis()));
                user.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
                User u = userDao.save(user);
                if(u != null){
                    message.setSuccess(true);
                    message.setContent("注册成功！");
                }else{
                    message.setContent("注册失败，请检查");
                    message.setSuccess(false);
                }
            }catch (Exception e){
                message.setContent("系统异常，注册失败:"+e.getMessage());
                message.setSuccess(false);
                e.printStackTrace();
            }
        }
        return message;
    }
}
