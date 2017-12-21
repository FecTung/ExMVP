package com.fec.ex.exmvp.model;

import android.content.Context;

import com.fec.ex.exmvp.base.BaseModel;
import com.fec.ex.exmvp.base.IBasePresenter;
import com.fec.ex.exmvp.service.PhoneNumInfoService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Fe2Cu on 12.17.2017
 * github: https://www.github.com/fectung
 * Email : fectung@live.com
 */
public class PhoneModelImp extends BaseModel {
    private Context context;
    private PhoneNumInfoService phoneNumInfoService;

    public PhoneModelImp(Context context) {
        this.context = context;
        this.phoneNumInfoService = retrofitManager.getService();
    }

    public void loadPhoneNumInfo(String phoneNum, final IBasePresenter<PhoneNumInfo> callback, final int requestTag) {
        phoneNumInfoService.getInfo("phone.get", phoneNum, "10003", "b59bc3ef6191eb9f747dd4e83c99f2a4", "json")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PhoneNumInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        callback.beforeRequest(requestTag);
                    }

                    @Override
                    public void onNext(PhoneNumInfo phoneNumInfo) {

                        if (null != phoneNumInfo && phoneNumInfo.getSuccess().equals("1")) {
                            callback.requestSuccess(phoneNumInfo, requestTag);
                        } else if (null != phoneNumInfo && phoneNumInfo.getSuccess().equals("0")) {
                            callback.requestError(new Exception(phoneNumInfo.getMsg()), requestTag);
                        } else {
                            callback.requestError(new Exception("获取数据失败！"), requestTag);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.requestError(e, requestTag);
                    }

                    @Override
                    public void onComplete() {
                        callback.requestComplete(requestTag);
                    }
                });
    }
}
