package com.fec.ex.exmvp.service;

import com.fec.ex.exmvp.model.PhoneNumInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Fe2Cu on 12.17.2017
 * github: https://www.github.com/fectung
 * Email : fectung@live.com
 */
public interface PhoneNumInfoService {
    //http://api.k780.com:88/?app=phone.get&phone={phoneNum}&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json
    @GET("/")
    Observable<PhoneNumInfo> getInfo(
            @Query("app") String app,
            @Query("phone") String phone,
            @Query("appkey") String appkey,
            @Query("sign") String sign,
            @Query("format") String format
    );
}
