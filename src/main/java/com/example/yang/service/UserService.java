package com.example.yang.service;

import com.example.yang.mapper.UserMapper;
import com.example.yang.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

import static com.example.yang.result.ResultCode.USER_LOGIN_FAIL;
import static com.example.yang.result.ResultCode.USER_NOT_EXIST;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    public Integer login(User user) throws IOException {
        String username = user.getUsername();
        String password = user.getPassword();
        User user1 = userMapper.selectUserByName(username);
        if (user1 == null) {
            log.info("用户不存在");
            return USER_NOT_EXIST.getCode();
        } else {
            if (user1.getPassword().equals(password)) {
                return -1;
            } else {
                log.info("用户名或密码错误");
                return USER_LOGIN_FAIL.getCode();
            }
        }
    }

    public boolean register(User user) {
        if (userMapper.selectUserByName(user.getUsername()) != null) {
            log.info("用户名已存在");
            return false;
        } else {
            Integer x = userMapper.insertUser(user);
            System.out.println("x的值:" + x);
            if (x > 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
