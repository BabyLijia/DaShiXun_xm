package com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carmvp;

import com.example.asus.jouyuejiache_dashixun1.base.BaseModel;
import com.example.asus.jouyuejiache_dashixun1.base.BasePresenter;
import com.example.asus.jouyuejiache_dashixun1.base.BaseView;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.Xq_CarBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.carxq_reimen.RmBanZhiBean;
import com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carcallback.MyCar_CallBack;
import com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carcallback.MyReimen_CallBack;

public class CarContract {

    public interface View extends BaseView{
        //首页驾校详情
        void getCarDataV(Xq_CarBean xq_carBean);
        //热门班制
        void getBanzhiDataV(RmBanZhiBean rmBanZhiBean);

    }

    public interface Model extends BaseModel{

        //首页驾校详情
        void getCarDataM(String string,MyCar_CallBack myCar_callBack);
        //热门班制
        void getBanzhiDataM(String string,MyReimen_CallBack myReimen_callBack);

    }

    public abstract static class Presnter extends BasePresenter<Model,View>{

        //首页驾校详情
        public abstract void getCarDataP(String url);
        public abstract void getRmDataP(String url);
    }
}
