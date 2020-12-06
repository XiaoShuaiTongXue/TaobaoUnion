package com.shuai.taobaounion.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private final Retrofit mRetrofit;
    private static RetrofitManager ourInstance = new RetrofitManager();

    public static RetrofitManager getInstance(){
        return ourInstance;
    }
    private RetrofitManager(){
        mRetrofit = new Retrofit
                .Builder()
                .baseUrl(Constant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit(){
        return mRetrofit;
    }
}
