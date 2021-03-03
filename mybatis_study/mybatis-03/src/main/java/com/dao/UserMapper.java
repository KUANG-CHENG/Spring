package com.dao;

import com.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 查询所有用户
    List<User> getUserList();

    // 使用 Limit 实现分页查询
    List<User> getUserLimit(Map<String, Integer> map);

    // 使用 RowBounds 实现分页
    List<User> getUserRowBounds();

    //根据ID查询用户
    User getUserById(int id);

    // 模糊查询
    List<User> getUserLike(String value);

    // 使用map添加用户
    int addUser2(Map<String, Object> map);

    // 插入
    int addUser(User user);

    // 更新
    int updateUser(User user);

    // 删除
    int deleteUser(int id);

}
