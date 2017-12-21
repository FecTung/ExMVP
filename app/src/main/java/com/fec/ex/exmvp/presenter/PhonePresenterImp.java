package com.fec.ex.exmvp.presenter;

import android.content.Context;

import com.fec.ex.exmvp.base.BasePresenterImp;
import com.fec.ex.exmvp.model.PhoneModelImp;
import com.fec.ex.exmvp.model.PhoneNumInfo;
import com.fec.ex.exmvp.view.PhoneNumInfoView;

/**
 * Created by Fe2Cu on 12.18.2017
 * github: https://www.github.com/fectung
 * Email : fectung@live.com
 */
public class PhonePresenterImp extends BasePresenterImp<PhoneNumInfoView, PhoneNumInfo> {
    private Context mContext;
    private PhoneModelImp phoneModel;

    public PhonePresenterImp(PhoneNumInfoView iView, Context mContext) {
        super(iView);
        this.mContext = mContext;
        phoneModel = new PhoneModelImp(mContext);
    }

    public void getPhoneNumInfo(String phoneNum, int requestTag) {
        phoneModel.loadPhoneNumInfo(phoneNum, this, requestTag);
    }
}
