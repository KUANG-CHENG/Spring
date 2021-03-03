package com.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

// 后置通知
public class AfterLog implements AfterReturningAdvice {

    //method : 要执行的目标对象的方法
    @Override
    public void afterReturning(Object returnValue,Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("执行了" + method.getName()+"方法, 返回值："+returnValue);
    }
}
