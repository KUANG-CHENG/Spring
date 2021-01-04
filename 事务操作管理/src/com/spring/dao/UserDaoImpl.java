package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao{

    // 注入jdbcTempleta
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 多钱--lucy转账100给mary
    @Override
    public void addMoney() {
        String sql = "update tb_account set money=money+? where user_name=?";
        int update = jdbcTemplate.update(sql,100,"mary");
        System.out.println(update);
    }

    // 少钱
    @Override
    public void reduceMoney() {
        String sql = "update tb_account set money=money-? where user_name=?";
        int update = jdbcTemplate.update(sql,100,"lucy");
        System.out.println(update);
    }
}
