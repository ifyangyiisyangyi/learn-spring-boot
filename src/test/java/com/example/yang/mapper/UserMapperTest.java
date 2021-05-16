package com.example.yang.mapper;

import com.example.yang.mapper.UserMapper;
import com.example.yang.pojo.User;
import com.example.yang.utils.MybatisUtils;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;

import java.util.List;

public class UserMapperTest {
//    @Test
//    public void test() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = userDao.getUserList();
//        for (User user : userList) {
//            System.out.println(user);
//        }
//        // 关闭sqlsession
//        sqlSession.close();
//    }
//
//    @Test
//    public void getUserById() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = mapper.getUserById("1");
//        System.out.println(user);
//        sqlSession.close();
//    }
//
//    //增删改需要提交事务
//    @Test
//    public void addUser() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.addUser(new User("4", "bb", "123"));
//        sqlSession.commit();
//        sqlSession.close();
//    }
//
//    @Test
//    public void updateUser() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.updateUser(new User("2", "阿兰", "456"));
//        sqlSession.commit();
//        sqlSession.close();
//    }
//
//    @Test
//    public void deleteUser() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.deleteUser("3");
//        sqlSession.commit();
//        sqlSession.close();
//    }
//
//    @Test
//    // 模糊查询
//    public void getUserLike(){
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = mapper.getUserLike("%阿%");
//        for (User user : userList) {
//            System.out.println(user);
//        }
//        sqlSession.close();
//    }

}

