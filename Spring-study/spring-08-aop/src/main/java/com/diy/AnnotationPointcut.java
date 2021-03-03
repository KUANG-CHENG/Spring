package com.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 切面
@Component(value = "annotationPointcut")
@Aspect
public class AnnotationPointcut {

    @Before("execution(* com.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("方法执行前。。。。。。");
    }

    @After("execution(* com.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("方法执行后。。。。。。");
    }

    @Around("execution(* com.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前。。。。。");

        // 执行目标方法
        Object proceed = jp.proceed();

        System.out.println("环绕后。。。。。");
    }
}
