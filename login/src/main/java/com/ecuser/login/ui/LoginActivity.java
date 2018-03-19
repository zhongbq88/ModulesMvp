package com.ecuser.login.ui;

import android.text.TextUtils;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ecuser.login.R;
import com.ecuser.login.databinding.ActivityLoginBinding;
import com.zbq.library.base.BaseActivity;
import com.zbq.library.consts.CRouter;

/**
 * Created by ZhongBingQi on 2018/3/19.
 */
@Route(path = CRouter.LOGIN.ROUTE)
public class LoginActivity  extends BaseActivity<LoginPresenter, ActivityLoginBinding> implements LoginContract.View  {

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        super.initView();
        mViewBinding.tvSign.setOnClickListener(v-> doAction());
    }

    private void doAction() {
        String name = mViewBinding.tlName.getEditText().getText().toString();
        String pass = mViewBinding.tlPass.getEditText().getText().toString();
        String msg = TextUtils.isEmpty(name)? "用户名不能为空!" : TextUtils.isEmpty(pass)? "密码不能为空!" : "";
        if (!TextUtils.isEmpty(msg))
            showMsg(msg);
        else
        mPresenter.login(name, pass);
    }

    @Override
    public void loginSuccess(String name, String pass) {
        ARouter.getInstance().build(CRouter.USER.ROUTE).withCharSequence(CRouter.USER.EXTRA_NAME, name).withCharSequence(CRouter.USER.EXTRA_PASSWORD, pass).navigation();
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
