package com.ecuser.modulesapp.main;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ecuser.modulesapp.R;
import com.ecuser.modulesapp.databinding.ActivityMainBinding;
import com.zbq.library.base.BaseActivity;
import com.zbq.library.consts.CRouter;

@Route(path = CRouter.MAIN.ROUTE)
public class MainActivity extends BaseActivity<MainPresenter, ActivityMainBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    public void Login(View view){
        ARouter.getInstance().build(CRouter.LOGIN.ROUTE).navigation();
    }
}
