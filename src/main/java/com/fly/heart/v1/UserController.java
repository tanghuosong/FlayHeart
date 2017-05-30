package com.fly.heart.v1;

import com.fly.heart.bean.User;
import com.fly.heart.utils.Message;
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
public interface UserController {

    @RequestMapping( value = "/getAllUser",method = RequestMethod.GET)
    @ResponseBody
    List<User> getAll();

    @RequestMapping(value = "/getAllUsers",method = RequestMethod.GET)
    @ResponseBody
    Map<String,Object> getAllUsers();

    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
    @ResponseBody
    User getUserById(long id);

    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    @ResponseBody
    Map<String,Object> userLogin(String name, String password);

    @RequestMapping(value = "/userRegister" ,method = RequestMethod.POST)
    @ResponseBody
    Message userRegister(User user);
}
