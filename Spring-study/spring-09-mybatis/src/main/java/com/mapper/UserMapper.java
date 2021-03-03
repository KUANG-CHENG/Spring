package com.mapper;

import com.pojo.User;

import java.util.List;

public interface UserMapper {

    // 查询表中所有数据
    public List<User> selectUser();
}
