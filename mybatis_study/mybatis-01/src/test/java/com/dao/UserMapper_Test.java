package com.dao;

import com.pojo.User;

import com.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapper_Test {

    @Test
    public void getUserList() {
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(4);
        System.out.println(user);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserLike("李");
        for(User user : userList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void addUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int num = userMapper.addUser(new User(4,"kuangcheng","123456"));
        System.out.println(num);

        // 提交事物
        sqlSession.commit();

        // 查询所有事物
        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();

    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 创建 map
        Map map = new HashMap();
        map.put("Userid", 12);
        map.put("Username", "cat");
        map.put("Userpwd", "1234595");

        int num = userMapper.addUser2(map);
        System.out.println(num);

        // 提交事物
        sqlSession.commit();
        // 关闭 sqlSession
        sqlSession.close();

    }

    @Test
    public void updateUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int num = userMapper.updateUser(new User(4,"kc","88888888"));
        System.out.println(num);

        // 提交事物
        sqlSession.commit();

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int num = userMapper.deleteUser(52);
        System.out.println(num);

        // 提交事物
        sqlSession.commit();

        //关闭SqlSession
        sqlSession.close();
    }


}
