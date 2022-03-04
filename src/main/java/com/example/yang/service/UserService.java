package com.example.yang.service;

import com.example.yang.mapper.UserMapper;
import com.example.yang.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    public boolean login(User user) throws IOException {
        String username = user.getUsername();
        String password = user.getPassword();
        User user1 = userMapper.selectUserByName(username);
        if(user1 == null) {
            log.info("用户不存在");
            return false;
        }else {
            if(user1.getPassword().equals(password)){
                return true;
            }else {
                log.info("密码不符");
                return false;
            }
        }
    }

    public boolean register(User user) {
        if(userMapper.selectUserByName(user.getUsername()) != null) {
            log.info("用户名已存在");
            return false;
        }else {
            Integer x = userMapper.insertUser(user);
            System.out.println("x的值:" + x);
            if(x > 0) {
                return true;
            }else {
                return false;
            }
        }

    }

}
