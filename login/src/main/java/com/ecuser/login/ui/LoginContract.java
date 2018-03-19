package com.ecuser.login.ui;

import com.zbq.library.base.BasePresenter;
import com.zbq.library.base.BaseView;

/**
 * Created by ZhongBingQi on 2018/3/19.
 */

public interface LoginContract {
    interface View extends BaseView {
        void loginSuccess( String name,  String pass);
        void showMsg(String msg);
    }

    abstract class Presenter extends BasePresenter<View>{

        abstract void login(String name , String pass);

        @Override
        public void onDetached() {
            super.onDetached();
        }
    }
}
