package com.zbq.library.util;


import com.zbq.annotation.aspect.TimeLog;

/**
 * Created by zhongbingqi on 2018/3/15.
 */
public class InstanceUtil {

    /**
     * 通过实例工厂去实例化相应类
     *
     * @param <T> 返回实例的泛型类型
     * @return
     */
    @TimeLog
    public static <T> T getInstance(Class clazz) {
        try {
            return (T) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
