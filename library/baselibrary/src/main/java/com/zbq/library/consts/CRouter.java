package com.zbq.library.consts;

/**
 * Created by ZhongBingQi on 2018/3/16.
 */

public interface CRouter {

    interface USER{
        String ROUTE = "/user/userActivity";
        String EXTRA_NAME = "name";
        String EXTRA_PASSWORD = "pass";
    }
    interface LOGIN{
        String ROUTE = "/login/loginActivity";
    }
    interface MAIN{
        String ROUTE = "/main/mainActivity";
    }
}
