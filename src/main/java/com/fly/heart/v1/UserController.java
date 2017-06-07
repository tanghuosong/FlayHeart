package com.fly.heart.v1;

import com.fly.heart.bean.User;
import com.fly.heart.service.UserService;
import com.fly.heart.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * created by tanghuosong 2017/5/28
 * description: User 控制器
 **/
@RequestMapping(value = "/v1/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService ;

    @RequestMapping( value = "/getAllUser",method = RequestMethod.GET)
    @ResponseBody
    List<User> getAll(){
        return  userService.getAllUser();
    }

    @RequestMapping(value = "/getAllUsers",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
    @ResponseBody
    User getUserById(long id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> userLogin(String name, String password){
        return userService.userLogin(name,password);
    }

    @RequestMapping(value = "/userRegister" ,method = RequestMethod.POST)
    @ResponseBody
    Message userRegister(User user){
        return userService.userRegister(user);
    }

    @RequestMapping(value = "/getAllUserByStateWithPage",method = RequestMethod.GET)
    @ResponseBody
    Page<User> getAllUserByStateWithPage(Long state,Integer pageNum, Integer pageSize){
        return userService.getAllUserByStateWithPage(state,pageNum,pageSize);
    }
}
