package com.example.yang.service;

import com.example.yang.mapper.UserMapper;
import com.example.yang.pojo.User;
import com.example.yang.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> addUser(User user) {
        List<User> users = userMapper.getUserList();
        if(users.isEmpty()) {
            userMapper.addUser(user);
        }
        return users;
    }
}
