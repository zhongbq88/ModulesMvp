package com.ecuser.modulesapp.main;


import com.zbq.library.base.BasePresenter;
import com.zbq.library.base.BaseView;

/**
 * Created by zhongbingqi on 2018/3/15.
 */
public interface MainContract {

    interface View extends BaseView {

    }

    abstract class Presenter extends BasePresenter<View> {

    }

}
