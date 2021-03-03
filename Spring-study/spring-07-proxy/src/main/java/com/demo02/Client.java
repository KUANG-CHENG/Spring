package com.demo02;

public class Client {

    public static void main(String[] args) {

        // 最初的模式
        UserServiceImpl userService = new UserServiceImpl();
        userService.add();

        System.out.println("-----------------------------");

        // 加入动态代理
        UserProxy userProxy = new UserProxy();
        userProxy.setUserService(userService);
        userProxy.add();

    }
}
