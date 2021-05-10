package com.example.yang.mapper;

import com.example.yang.mapper.UserMapper;
import com.example.yang.pojo.User;
import com.example.yang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方式一
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList){
            System.out.println(user);
        }
        // 关闭sqlsession
        sqlSession.close();
    }
}

