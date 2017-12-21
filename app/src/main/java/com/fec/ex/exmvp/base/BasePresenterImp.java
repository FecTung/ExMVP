package com.fec.ex.exmvp.base;

/**
 * Created by Fe2Cu on 12.17.2017
 * github: https://www.github.com/fectung
 * Email : fectung@live.com
 */

/**
 * 代理对象的基础实现
 * @param <T> 视图接口对象（view）具体业务继承自IBaseView
 * @param <V>
 */
public class BasePresenterImp<T extends IBaseView, V> implements IBasePresenter<V> {
    public IBaseView iView;

    public BasePresenterImp(T iView) {
        this.iView = iView;
    }

    @Override
    public void beforeRequest(int requestTag) {
        iView.showProgress(requestTag);
    }

    @Override
    public void requestError(Throwable e, int requestTag) {
        iView.loadDataError(e, requestTag);
    }

    @Override
    public void requestComplete(int requestTag) {
        iView.hideProgress(requestTag);
    }

    @Override
    public void requestSuccess(V callback, int requestTag) {
        iView.loadDataSuccess(callback, requestTag);
    }
}
