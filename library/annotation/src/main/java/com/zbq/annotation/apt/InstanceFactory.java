package com.zbq.annotation.apt;


/**
 * Created by zhongbingqi on 2018/3/15.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface InstanceFactory {
}


