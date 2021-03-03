package com.mapper;

import com.pojo.User;

import java.util.List;

public interface UserMapper {

    // 查询表中所有数据
    public List<User> selectUser();

    // 插入数据
    public int addUser(User user);

    // 删除数据
    public int deleteUser(int  id);
}
