package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 查询所有用户
    @Select("select * from mybatis.user")
    List<User> getUserList();

    // 使用 Limit 实现分页查询
    List<User> getUserLimit(Map<String, Integer> map);

    // 使用 RowBounds 实现分页
    List<User> getUserRowBounds();

    //根据ID查询用户
    @Select("select * from mybatis.user where id = #{id2}")
    User getUserById(@Param("id2") int id);

    // 模糊查询
    List<User> getUserLike(String value);

    // 使用map添加用户
    int addUser2(Map<String, Object> map);

    // 插入
    @Insert("insert into user(id, name, pwd) value (#{id},#{name},#{password})")
    int addUser(User user);

    // 更新
    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
    int updateUser(User user);

    // 删除
    @Delete("delete from user where id=#{id}")
    int deleteUser(int id);

}
