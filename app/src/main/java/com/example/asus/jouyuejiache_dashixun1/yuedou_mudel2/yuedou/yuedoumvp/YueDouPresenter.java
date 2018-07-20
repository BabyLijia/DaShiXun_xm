package com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoumvp;

import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.SuperLVBean;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.likalijuan.LiKaLiJuanBean;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoucallback.MyYuedouCallBack;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoucallback.MyYuedou_youCallback;

/**
* Created by TMVPHelper on 2018/07/13
*/
public class YueDouPresenter extends YueDouContract.Presenter{

    @Override
    public void getSuper_zuoP(String url) {
        myModel.getSuper_zuoM(url, new MyYuedouCallBack() {
            @Override
            public void onSucces(SuperLVBean superLVBean) {
                myView.getSuper_zuoV(superLVBean);
            }

            @Override
            public void onFulie(String msg) {

            }
        });
    }

    @Override
    public void getSuper_youP(String url) {
        myModel.getSuper_youM(url, new MyYuedou_youCallback() {
            @Override
            public void onSucces(LiKaLiJuanBean liKaLiJuanBean) {
                myView.getLiJuanV(liKaLiJuanBean);
            }

            @Override
            public void onFulie(String msg) {

            }
        });
    }
}