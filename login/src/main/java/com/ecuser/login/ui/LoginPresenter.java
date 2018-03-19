package com.ecuser.login.ui;

import com.zbq.annotation.aspect.EventBusRegister;
import com.zbq.annotation.aspect.EventBusUnRegister;
import com.zbq.library.event.EventTags;
import com.zbq.library.event.Subscriber;

/**
 * Created by ZhongBingQi on 2018/3/19.
 */

public class LoginPresenter extends LoginContract.Presenter{

    @EventBusRegister
    @Override
    public void onAttached() {

    }

    @Override
    public void login(String name, String pass) {
        mView.loginSuccess(name, pass);
    }

    @Subscriber(tag = EventTags.ON_USER_LOGIN)
    public void onLogin(String user) {
        mView.showMsg(user + " 用户登录成功! ");
    }

    @EventBusUnRegister
    @Override
    public void onDetached() {
        super.onDetached();
    }
}
