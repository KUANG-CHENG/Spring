package com.spring.testdemo;

import com.spring.config.TxConfig;
import com.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    public static void main(String[] args) {

        // 基于注解方式
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("bea1.xml");
//        UserService userService = context.getBean("userService", UserService.class);
//
//        userService.accountMoney();


         // 基于xml配置文件方式
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("bea2.xml");
//        UserService userService = context.getBean("userService", UserService.class);
//
//        userService.accountMoney();
        // 基于完全注解方式
        ApplicationContext context =
                new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);

        userService.accountMoney();
    }
}
