package com.zbq.library.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.Stack;


/**
 * Created by zhongbingqi on 2018/3/15.
 */

public class BaseApplication extends Application {

    private static BaseApplication mApp;
    public Stack<Activity> store;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        store = new Stack<>();
        registerActivityLifecycleCallbacks(new SwitchBackgroundCallbacks());
        initRouter();
    }

    private void initRouter() {
        ARouter.openLog(); // 开启日志
        ARouter.openDebug(); // 使用InstantRun的时候，需要打开该开关，上线之后关闭，否则有安全风险
        ARouter.printStackTrace(); // 打印日志的时候打印线程堆栈
        ARouter.init(this);
    }

    public static BaseApplication getAppContext() {
        return mApp;
    }


    private class SwitchBackgroundCallbacks implements ActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            store.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            store.remove(activity);
        }
    }

    /**
     * 获取当前的Activity
     *
     * @return
     */
    public Activity getCurActivity() {
        return store.lastElement();
    }
}
