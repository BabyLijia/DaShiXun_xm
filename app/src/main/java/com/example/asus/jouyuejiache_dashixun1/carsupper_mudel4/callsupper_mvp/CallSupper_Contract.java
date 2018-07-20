package com.example.asus.jouyuejiache_dashixun1.carsupper_mudel4.callsupper_mvp;

import com.example.asus.jouyuejiache_dashixun1.base.BaseModel;
import com.example.asus.jouyuejiache_dashixun1.base.BasePresenter;
import com.example.asus.jouyuejiache_dashixun1.base.BaseView;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.CarSupperBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.car_you1.HuaChengCar1;
import com.example.asus.jouyuejiache_dashixun1.carsupper_mudel4.carsupper_callback.MyCarSupper_Callback;
import com.example.asus.jouyuejiache_dashixun1.carsupper_mudel4.carsupper_callback.MyCarSupper_you_Callback;

public class CallSupper_Contract {

    public interface View extends BaseView {
        //首页汽车超市
        void getCarSupper_zuoV(CarSupperBean carSupperBean);
        void getCarSupper_youV(HuaChengCar1 huaChengCar1);
    }

    public interface Model extends BaseModel {
        //首页汽车超市
        void getCarSupper_zuoM(String string,MyCarSupper_Callback myCarSupper_callback);
        void getCarSupper_youM(String string,MyCarSupper_you_Callback myCarSupper_you_callback);

    }

    public abstract static class Presenter extends BasePresenter<Model, View> {
        //首页汽车超市
        public abstract void  getCarSupper_zuoP(String url);
        public abstract void  getCarSupper_you(String url);

    }
}
