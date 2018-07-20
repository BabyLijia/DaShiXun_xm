package com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carmvp;

import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.Xq_CarBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.carxq_reimen.RmBanZhiBean;
import com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carcallback.MyCar_CallBack;
import com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carcallback.MyReimen_CallBack;
import com.example.asus.jouyuejiache_dashixun1.service.ApiService;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class CarModel implements CarContract.Model {
    private ApiService apiService;

    public CarModel() {
        apiService = RETROFIT_MESSAGE.budler().create(ApiService.class);
    }

    @Override
    public void getCarDataM(String string, final MyCar_CallBack myCar_callBack) {
        apiService.getCarXq(string)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Xq_CarBean>() {
                    @Override
                    public void call(Xq_CarBean xq_carBean) {
                        myCar_callBack.onSucces(xq_carBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        myCar_callBack.onFulie(throwable.getMessage());
                    }
                });
    }

    @Override
    public void getBanzhiDataM(String string, final MyReimen_CallBack myReimen_callBack) {
        apiService.getCar_Rm(string)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<RmBanZhiBean>() {
                    @Override
                    public void call(RmBanZhiBean rmBanZhiBean) {
                        myReimen_callBack.onSucces(rmBanZhiBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        myReimen_callBack.onFulie(throwable.getMessage());
                    }
                });
    }
}
