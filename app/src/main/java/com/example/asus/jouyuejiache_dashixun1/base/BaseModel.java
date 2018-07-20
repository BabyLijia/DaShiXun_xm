package com.example.asus.jouyuejiache_dashixun1.base;

import com.example.asus.jouyuejiache_dashixun1.message.RetrofitMessage;

import okhttp3.ResponseBody;

public interface BaseModel {
    //https://api.yunxuekeji.cn/ yunxue_app_api/course/getCourseByTypeAndMore?orderOn=&classtype=031001004&forPeopleType=&format=&price=&pageIndex=1&pageSize=10&classTag=
    RetrofitMessage RETROFIT_MESSAGE=new RetrofitMessage();
    interface MyCallBack {
        void onSucces(ResponseBody homeBean);
        void onFulie(String msg);
    }
}
