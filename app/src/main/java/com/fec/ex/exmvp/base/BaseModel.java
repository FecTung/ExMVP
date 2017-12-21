package com.fec.ex.exmvp.base;

import com.fec.ex.exmvp.helper.RetrofitManager;

/**
 * Created by Fe2Cu on 12.17.2017
 * github: https://www.github.com/fectung
 * Email : fectung@live.com
 */
public class BaseModel {

    public RetrofitManager retrofitManager;

    public BaseModel() {
        retrofitManager = RetrofitManager.builder();
    }
}
