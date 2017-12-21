package com.fec.ex.exmvp.helper;

import com.fec.ex.exmvp.service.PhoneNumInfoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fe2Cu on 12.17.2017
 * github: https://www.github.com/fectung
 * Email : fectung@live.com
 */
public class RetrofitManager {

    public static final String BASE_URL = "http://api.k780.com:88";

    private PhoneNumInfoService phoneNumInfoService;

    public static RetrofitManager builder(){
        return new RetrofitManager();
    }

    public PhoneNumInfoService getService(){
        return phoneNumInfoService;
    }

    private RetrofitManager(){
        Gson gson =
                new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd hh:mm:ss")
                        .create();

        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
        phoneNumInfoService = retrofit.create(PhoneNumInfoService.class);
    }

}
