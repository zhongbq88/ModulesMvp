package com.ecuser.user.ui;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ecuser.user.R;
import com.ecuser.user.databinding.ActivityUserBinding;
import com.zbq.library.base.BaseActivity;
import com.zbq.library.consts.CRouter;
import com.zbq.library.event.EventBus;
import com.zbq.library.event.EventTags;

/**
 * Created by ZhongBingQi on 2018/3/19.
 */
@Route(path = CRouter.USER.ROUTE)
public class UserActivity extends BaseActivity<UserPresenter,ActivityUserBinding> {

    @Autowired(name = CRouter.USER.EXTRA_NAME)
    String name;
    @Autowired(name = CRouter.USER.EXTRA_PASSWORD)
    String pass;

    @Override
    public int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public void initView() {
        super.initView();
        mViewBinding.tvContent.setText("用户名："+name+"\n 密码："+pass);
        EventBus.getDefault().post(name, EventTags.ON_USER_LOGIN);
        mViewBinding.tvSend.setOnClickListener(v->ARouter.getInstance().build(CRouter.MAIN.ROUTE).navigation());
    }
}
