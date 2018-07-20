package com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carmvp;

import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.Xq_CarBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.carxq_reimen.RmBanZhiBean;
import com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carcallback.MyCar_CallBack;
import com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carcallback.MyReimen_CallBack;

public class CarPresenter extends CarContract.Presnter {
    @Override
    public void getCarDataP(String url) {
        myModel.getCarDataM(url, new MyCar_CallBack() {
            @Override
            public void onSucces(Xq_CarBean xq_carBean) {
                myView.getCarDataV(xq_carBean);
            }

            @Override
            public void onFulie(String msg) {

            }
        });
    }

    @Override
    public void getRmDataP(String url) {
        myModel.getBanzhiDataM(url, new MyReimen_CallBack() {
            @Override
            public void onSucces(RmBanZhiBean rmBanZhiBean) {
                myView.getBanzhiDataV(rmBanZhiBean);
            }

            @Override
            public void onFulie(String msg) {

            }
        });
    }
}
