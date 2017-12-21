package com.fec.ex.exmvp.base;

/**
 * Created by Fe2Cu on 12.17.2017
 * github: https://www.github.com/fectung
 * Email : fectung@live.com
 */
public interface IBasePresenter<T> {

    /**
     * 请求之前
     * @param requestTag 请求标识
     */
    public void beforeRequest(int requestTag);

    /**
     * 请求失败
     * @param e 错误原因
     * @param requestTag 请求标识
     */
    public void requestError(Throwable e, int requestTag);

    /**
     * 请求完成
     * @param requestTag 请求标识
     */
    public void requestComplete(int requestTag);

    /**
     * 请求成功
     * @param callback 返回的相应数据
     * @param requestTag 请求标识
     */
    public void requestSuccess(T callback, int requestTag);
}
