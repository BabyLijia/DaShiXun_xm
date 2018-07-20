package com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp;

import android.util.Log;

import com.example.asus.jouyuejiache_dashixun1.base.BaseModel;
import com.example.asus.jouyuejiache_dashixun1.bean.SheQuBean;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_toutiao_genduo.ResultListBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_toutiao_genduo.Shouye_Tt_gengduo;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homecallback.MyCallBack_KeEr;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homecallback.SheQu_ZX;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homecallback.Toutiao_gduo;
import com.example.asus.jouyuejiache_dashixun1.service.ApiService;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static com.example.asus.jouyuejiache_dashixun1.base.BaseModel.RETROFIT_MESSAGE;

/**
* Created by TMVPHelper on 2018/06/30
*/
public class HomeModel implements HomeContract.Model{

    private final ApiService apiService;

    public HomeModel() {
        apiService = RETROFIT_MESSAGE.budler().create(ApiService.class);
    }

    @Override
    public void getPostData(String string,final BaseModel.MyCallBack callBack) {
        apiService.getPostData(string)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody homeBean) {
                        callBack.onSucces(homeBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        callBack.onFulie(throwable.getMessage());
                    }
                });
    }

    @Override
    public void getKeErDataM(String string, final MyCallBack_KeEr myCallBack_keEr) {
        apiService.getKeErData(string)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<KeerBean>() {
                    @Override
                    public void call(KeerBean keerBean) {
                        myCallBack_keEr.onSucces(keerBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        myCallBack_keEr.onFulie(throwable.getMessage());
                    }
                });
    }

    @Override
    public void getShequ_ZxDataM(String string, final SheQu_ZX myCallBack_keEr) {
        apiService.getSheQuZuiXin(string)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody sheQuBean) {
                        try {
                            String string1 = sheQuBean.string();

                            myCallBack_keEr.onSucces(string1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        myCallBack_keEr.onFulie(throwable.getMessage());
                    }
                });
    }

    @Override
    public void getToutiao_gdDataM(String string, final Toutiao_gduo myCallBack_gd) {
        apiService.gettoutiao_Gd(string)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Shouye_Tt_gengduo>() {
                    @Override
                    public void call(Shouye_Tt_gengduo resultListBean) {
                        myCallBack_gd.onSucces(resultListBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        myCallBack_gd.onFulie(throwable.getMessage());
                    }
                });
    }

}