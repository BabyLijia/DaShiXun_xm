package com.example.asus.jouyuejiache_dashixun1.carsupper_mudel4.callsupper_mvp;

import com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.CarSupperBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.car_you1.HuaChengCar1;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.SuperLVBean;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.likalijuan.LiKaLiJuanBean;
import com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carmvp.CarContract;
import com.example.asus.jouyuejiache_dashixun1.carsupper_mudel4.carsupper_callback.MyCarSupper_Callback;
import com.example.asus.jouyuejiache_dashixun1.carsupper_mudel4.carsupper_callback.MyCarSupper_you_Callback;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoucallback.MyYuedouCallBack;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoucallback.MyYuedou_youCallback;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoumvp.YueDouContract;

/**
* Created by TMVPHelper on 2018/07/13
*/
public class CallSupper_Presenter extends CallSupper_Contract.Presenter{

    @Override
    public void getCarSupper_zuoP(String url) {
        myModel.getCarSupper_zuoM(url, new MyCarSupper_Callback() {
            @Override
            public void onSucces(CarSupperBean carSupperBean) {
                myView.getCarSupper_zuoV(carSupperBean);
            }

            @Override
            public void onFulie(String msg) {

            }
        });
    }

    @Override
    public void getCarSupper_you(String url) {
        myModel.getCarSupper_youM(url, new MyCarSupper_you_Callback() {
            @Override
            public void onSucces(HuaChengCar1 huaChengCar1) {
                myView.getCarSupper_youV(huaChengCar1);
            }

            @Override
            public void onFulie(String msg) {

            }
        });
    }
}