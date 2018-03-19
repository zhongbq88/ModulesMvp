package com.zbq.library.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zbq.library.R;
import com.zbq.library.util.MPermissionUtils;

public abstract class DataBindingActivity<B extends ViewDataBinding> extends AppCompatActivity {
    protected Toolbar toolbar;
    public Context mContext;
    public B mViewBinding;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = getLayoutInflater().inflate(this.getLayoutId(), null, false);
        mViewBinding = DataBindingUtil.bind(rootView);
        this.setContentView(getLayoutId(), rootView);
        ARouter.getInstance().inject(this);
        mContext = this;
        initPresenter();
        initToolBar();
        initView();
    }

    protected void initPresenter() {
    }

    private void initToolBar() {
        toolbar =  findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void setContentView(int layoutResID, View rootView) {
        //boolean isNotSwipeBack = layoutResID == R.layout.activity_main || layoutResID == R.layout.activity_flash;
        //super.setContentView(isNotSwipeBack ? rootView : getContainer(rootView));
        super.setContentView(rootView);
    }

    /*private View getContainer(View rootView) {
        rootView.setBackgroundColor(getResources().getColor(R.color.alpha_white));
        View container = getLayoutInflater().inflate(R.layout.activity_base, null, false);
        SwipeBackLayout swipeBackLayout = (SwipeBackLayout) container.findViewById(R.id.swipeBackLayout);
        View ivShadow = container.findViewById(R.id.iv_shadow);
        swipeBackLayout.addView(rootView);
        swipeBackLayout.setOnScroll((fs) -> ivShadow.setAlpha(1 - fs));
        return container;
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (-1 != getMenuId()) getMenuInflater().inflate(getMenuId(), menu);
        return true;
    }

    public int getMenuId() {
        return -1;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public abstract int getLayoutId();

    public void initView(){

    }
}
