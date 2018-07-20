package com.example.asus.jouyuejiache_dashixun1.message;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitMessage {
   public Retrofit retrofit;

    public Retrofit budler() {
        initRetrofit();
        return retrofit;
    }

    private void initRetrofit() {
        retrofit=new Retrofit.Builder().baseUrl("https://api.yunxuekeji.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
