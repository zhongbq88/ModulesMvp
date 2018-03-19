package com.zbq.annotation.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * Created by zhongbingqi on 2018/3/15.
 **/
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface MemoryCache {
}
