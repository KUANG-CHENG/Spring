package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    // 根据id号查询
    User selectId(@Param("id") int id);

    // 更新 update
    Integer UpdateUser(User user);
}
