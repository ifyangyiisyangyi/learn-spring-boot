package com.example.yang.conrtrollers;

import com.example.yang.pojo.User;
import com.example.yang.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class AddUser {
    @Resource
    UserService UserService;

    @RequestMapping(value = "/addUser", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public User addUser(@RequestParam(value = "id", required = true) String id,
                        @RequestParam(value = "name", required = true) String name,
                        @RequestParam(value = "password", required = true) String password) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        UserService.addUser(user);
        return user;
    }

    @GetMapping(value = "/searchUser")
    public User searchUser(@RequestParam(value = "id") String id) {
        User user = new User();
        user = UserService.searchUser(id);
        return user;
    }
}
