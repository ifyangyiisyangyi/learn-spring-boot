package com.example.yang.conrtrollers.User;

import com.example.yang.pojo.Linkage;
import com.example.yang.pojo.User;
import com.example.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public boolean login(@RequestBody User user){
        return userService.login(user);
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public boolean register(@RequestBody User user){
        return userService.register(user);
    }
}

