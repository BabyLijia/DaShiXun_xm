package com.example.asus.jouyuejiache_dashixun1.carsupper_mudel4.callsupper_mvp;

import com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.CarSupperBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.car_you1.HuaChengCar1;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.likalijuan.LiKaLiJuanBean;
import com.example.asus.jouyuejiache_dashixun1.carsupper_mudel4.carsupper_callback.MyCarSupper_Callback;
import com.example.asus.jouyuejiache_dashixun1.carsupper_mudel4.carsupper_callback.MyCarSupper_you_Callback;
import com.example.asus.jouyuejiache_dashixun1.service.ApiService;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoucallback.MyYuedou_youCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by TMVPHelper on 2018/07/13
 */
public class Callsupper_Model implements CallSupper_Contract.Model {

    private final ApiService apiService;

    public Callsupper_Model() {
        apiService = RETROFIT_MESSAGE.budler().create(ApiService.class);
    }

    @Override
    public void getCarSupper_zuoM(String string, final MyCarSupper_Callback myCarSupper_callback) {
        apiService.getCarSupper_zuo(string).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<CarSupperBean>() {
                    @Override
                    public void call(CarSupperBean carSupperBean) {
                        myCarSupper_callback.onSucces(carSupperBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        myCarSupper_callback.onFulie(throwable.getMessage());
                    }
                });
    }

    @Override
    public void getCarSupper_youM(String string, final MyCarSupper_you_Callback myCarSupper_you_callback) {
        apiService.getCarSupper_you1(string).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HuaChengCar1>() {
                    @Override
                    public void call(HuaChengCar1 huaChengCar1) {
                        myCarSupper_you_callback.onSucces(huaChengCar1);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        myCarSupper_you_callback.onFulie(throwable.getMessage());
                    }
                });
    }
}