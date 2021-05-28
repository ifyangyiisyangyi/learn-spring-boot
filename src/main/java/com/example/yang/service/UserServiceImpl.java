package com.example.yang.service;

import com.example.yang.mapper.UserMapper;
import com.example.yang.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service(value = "UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Boolean addUser(User user) {
        userMapper.addUser(user);

        return true;
    }


    @Override
    public User searchUser(String id) {
        User user = userMapper.getUserById(id);
        return user;
    }
}
