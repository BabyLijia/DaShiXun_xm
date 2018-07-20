package com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoumvp;

import com.example.asus.jouyuejiache_dashixun1.base.BaseModel;
import com.example.asus.jouyuejiache_dashixun1.base.BasePresenter;
import com.example.asus.jouyuejiache_dashixun1.base.BaseView;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.SuperLVBean;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.likalijuan.LiKaLiJuanBean;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoucallback.MyYuedouCallBack;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoucallback.MyYuedou_youCallback;

public class YueDouContract {

    public interface View extends BaseView {
        //首页社区悦豆商成
        void getSuper_zuoV(SuperLVBean superLVBean);
        void getLiJuanV(LiKaLiJuanBean liKaLiJuanBean);
    }

    public interface Model extends BaseModel {
        //社区悦豆商成
        void getSuper_zuoM(String string,MyYuedouCallBack myYuedouCallBack);
        void getSuper_youM(String string,MyYuedou_youCallback myYuedou_youCallback);

    }

    public abstract static class Presenter extends BasePresenter<Model, View> {
        //社区悦豆商成
        public abstract void  getSuper_zuoP(String url);
        public abstract void  getSuper_youP(String url);

    }
}