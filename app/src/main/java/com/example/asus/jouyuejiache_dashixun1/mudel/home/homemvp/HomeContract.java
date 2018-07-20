package com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp;

import com.example.asus.jouyuejiache_dashixun1.base.BaseModel;
import com.example.asus.jouyuejiache_dashixun1.base.BasePresenter;
import com.example.asus.jouyuejiache_dashixun1.base.BaseView;
import com.example.asus.jouyuejiache_dashixun1.bean.SheQu_Zhuixing.ZhuiXinBean;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homecallback.MyCallBack_KeEr;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homecallback.SheQu_ZX;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homecallback.Toutiao_gduo;

import okhttp3.ResponseBody;

public class HomeContract {

  public  interface View extends BaseView {
      void getPostData(ResponseBody homeBean);
      //1.科目二的数据请求View
      void getKeErDataV(KeerBean keerBean);
      //2社区最新数据 ,九悦头条——更多
     <T> void getShequ_ZxDataV(T t);
   }

    public interface Model extends BaseModel {
        void getPostData(String string,MyCallBack callBack);
        //1.科目二的数据请求Model
        void getKeErDataM(String string,MyCallBack_KeEr myCallBack_keEr);
        //2社区最新数据
        void getShequ_ZxDataM(String string,SheQu_ZX myCallBack_keEr);
        //九悦头条——更多
        void getToutiao_gdDataM(String string,Toutiao_gduo myCallBack_gd);
    }

    public abstract static class Presenter extends BasePresenter<Model, View> {
       public abstract void getPostData(String string);
       //1.科目二的数据请求Presenter
        public abstract void getKeErDataP(String string);
        //2社区最新数据
        public abstract void getShequ_ZxDataP(String string);
        //九悦头条——更多
        public abstract void getToutiao_gdDataP(String string);
    }

}