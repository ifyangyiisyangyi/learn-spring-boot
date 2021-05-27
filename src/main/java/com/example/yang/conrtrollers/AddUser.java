package com.example.yang.conrtrollers;

import com.example.yang.pojo.User;
import com.example.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/user")
public class AddUser {
    @Resource
    UserService UserServiceImpl;
    @RequestMapping(value = "/addUser", method = {RequestMethod.POST,RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public User addUser(@RequestParam(value = "id", required = true) String id,
                        @RequestParam(value = "name", required = true) String name,
                        @RequestParam(value = "password", required = true) String password){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        UserServiceImpl.addUser(user);
        return null;
    }
}
