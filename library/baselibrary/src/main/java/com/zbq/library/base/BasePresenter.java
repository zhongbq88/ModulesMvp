package com.zbq.library.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by zhongbingqi on 2018/3/15.
 */
public abstract class BasePresenter<V> {
    protected V mView;
    protected CompositeDisposable mCompositeSubscription = new CompositeDisposable();

    public void setView(V v) {
        this.mView = v;
        this.onAttached();
    }

    public abstract void onAttached();

    public void onDetached() {
        mCompositeSubscription.dispose();
    }
}
