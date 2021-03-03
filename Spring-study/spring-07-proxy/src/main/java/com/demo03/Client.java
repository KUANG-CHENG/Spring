package com.demo03;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        // 真实角色
        Host host = new Host();

        // 代理角色：现在没有
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        // 通过调用程序处理角色 -- 向代理角色传入真实角色
        pih.setRent(host);

        // 创建代理对象
        Rent proxy = (Rent) pih.getProxy();

        proxy.rent();
    }
}
