package com.dao;

import com.pojo.User;
import java.util.List;

public interface UserMapper {

    // 查询所有用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    // 插入
    int addUser(User user);

    // 更新
    int updateUser(User user);

    // 删除
    int deleteUser(int id);

}
