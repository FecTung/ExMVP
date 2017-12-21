package com.fec.ex.exmvp.base;

import android.view.View;

/**
 * Created by Fe2Cu on 12.17.2017
 * github: https://www.github.com/fectung
 * Email : fectung@live.com
 */
public interface IBaseView<T> {

    /**
     * 显示获取进度
     * @param requestTag 请求标识
     */
    public void showProgress(int requestTag);

    /**
     * 隐藏获取进度
     * @param requestTag 请求标识
     */
    public void hideProgress(int requestTag);

    /**
     * 加载成功时的数据
     * @param data 返回的数据
     * @param requestTag 请求标识
     */
    public void loadDataSuccess(T data, int requestTag);

    /**
     * 加载失败时的错误
     * @param e 错误原因
     * @param requestTag 请求标识
     */
    public void loadDataError(Throwable e, int requestTag);

}
