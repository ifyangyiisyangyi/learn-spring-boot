package com.example.yang.mapper;


import com.example.yang.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectUserById(int id);
    User selectUserByName(String name);
    int insertUser(User user);
}
