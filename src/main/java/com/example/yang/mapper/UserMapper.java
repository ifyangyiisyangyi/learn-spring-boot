package com.example.yang.mapper;

import com.example.yang.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(String id);

    //insert一个用户，使用包装类
    // TODO: 2021/5/11  
    Integer addUser(User user);

    // update
    Integer updateUser(User id);

    // delete
    Integer deleteUser(String id);

    // 模糊查询
    List<User> getUserLike(String value);
}