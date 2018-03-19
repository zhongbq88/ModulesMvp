package com.zbq.library.aop;


import com.zbq.library.event.EventBus;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 *
 * 功能：自动实现注册
 *
 * Created by zhongbingqi on 2018/3/15.
 */
@Aspect
public class EventBusRegisterAspect {

    @Pointcut("execution(@com.zbq.annotation.aspect.EventBusRegister * *(..))")//方法切入点
    public void methodRegister() {
    }

    @Pointcut("execution(@com.zbq.annotation.aspect.EventBusRegister *.new(..))")//构造器切入点
    public void constructorRegister() {
    }

    @Pointcut("execution(@com.zbq.annotation.aspect.EventBusUnRegister * *(..))")//方法切入点
    public void methodUnRegister() {
    }

    @Pointcut("execution(@com.zbq.annotation.aspect.EventBusUnRegister *.new(..))")//构造器切入点
    public void constructorUnRegister() {
    }

    /**
     * 前置方法,在目标方法执行前执行
     * @param joinPoint 封装了代理方法信息的对象,若用不到则可以忽略不写
     */
    @Before("methodUnRegister() || constructorUnRegister()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("Test methodUnRegister()");
        EventBus.getDefault().unregister(joinPoint.getThis());
    }

    /**
     * 后置方法,在目标方法执行后执行
     * @param joinPoint 封装了代理方法信息的对象,若用不到则可以忽略不写
     */
    @After("methodRegister() || constructorRegister()")
    public void afterMethod(JoinPoint joinPoint){
        System.out.println("Test methodRegister()");
        EventBus.getDefault().register(joinPoint.getThis());
    }
}