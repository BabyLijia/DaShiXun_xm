package com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp;

import com.example.asus.jouyuejiache_dashixun1.base.BaseModel;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homecallback.MyCallBack_KeEr;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homecallback.SheQu_ZX;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homecallback.Toutiao_gduo;

import okhttp3.ResponseBody;

/**
* Created by TMVPHelper on 2018/06/30
*/
public class HomePresenter extends HomeContract.Presenter{

    @Override
    public void getPostData(String string) {
        myModel.getPostData(string,new BaseModel.MyCallBack() {
            @Override
            public void onSucces(ResponseBody homeBean) {
                myView.getPostData(homeBean);
            }

            @Override
            public void onFulie(String msg) {
            }
        });
    }

    @Override
    public void getKeErDataP(String string) {
        myModel.getKeErDataM(string, new MyCallBack_KeEr() {
            @Override
            public void onSucces(KeerBean keerBean) {
                myView.getKeErDataV(keerBean);
            }

            @Override
            public void onFulie(String msg) {

            }
        });
    }

    @Override
    public void getShequ_ZxDataP(String string) {
        myModel.getShequ_ZxDataM(string, new SheQu_ZX() {
            @Override
            public <T> void onSucces(T t) {
                myView.getShequ_ZxDataV(t);
            }

            @Override
            public void onFulie(String msg) {
                myView.getShequ_ZxDataV(msg);
            }
        });
    }

    @Override
    public void getToutiao_gdDataP(String string) {
        myModel.getToutiao_gdDataM(string, new Toutiao_gduo() {
            @Override
            public <T> void onSucces(T t) {
                myView.getShequ_ZxDataV(t);
            }

            @Override
            public void onFulie(String msg) {
                myView.getShequ_ZxDataV(msg);
            }
        });
    }
}