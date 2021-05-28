package com.example.yang.service;

import com.example.yang.pojo.User;

import java.util.List;

public interface UserService {
    // 添加用户
    Boolean addUser(User user);

    User searchUser(String id);
}
