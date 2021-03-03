package com.demo02;

public class UserProxy implements UserService{
    UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        System.out.println("add......");
    }

    @Override
    public void delete() {
        log("delete");
        System.out.println("delete......");

    }

    @Override
    public void update() {
        log("update");
        System.out.println("update......");
    }

    @Override
    public void query() {
        log("query");
        System.out.println("query......");
    }

    public void log(String msg){
        System.out.println("[DEBUG] 使用了 "+ msg + "方法");
    }
}
