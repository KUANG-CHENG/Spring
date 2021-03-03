package com.mapper;

import com.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> selectUser() {

        User user = new User(56,"小王","256555");

        SqlSession sqlSession = getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 插入数据
        userMapper.addUser(user);
        // 删除数据
        userMapper.deleteUser(5);

        return userMapper.selectUser();

        // 进一步整合
//        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }

    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}