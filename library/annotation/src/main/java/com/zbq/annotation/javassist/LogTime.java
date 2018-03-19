package com.zbq.annotation.javassist;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhongbingqi on 2018/3/15.
 * 打印方法耗时Log注解，javassisit修改class文件植入代码
 * 功能：自动打印方法的耗时
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface LogTime {
}
