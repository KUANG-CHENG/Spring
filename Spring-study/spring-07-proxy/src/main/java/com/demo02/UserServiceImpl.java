package com.demo02;

public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("add......");
    }

    @Override
    public void delete() {
        System.out.println("delete......");
    }

    @Override
    public void update() {
        System.out.println("uodate......");
    }

    @Override
    public void query() {
        System.out.println("query......");
    }
}
