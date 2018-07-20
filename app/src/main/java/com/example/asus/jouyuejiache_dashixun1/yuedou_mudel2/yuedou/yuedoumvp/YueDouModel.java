package com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoumvp;

import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.SuperLVBean;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.likalijuan.LiKaLiJuanBean;
import com.example.asus.jouyuejiache_dashixun1.service.ApiService;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoucallback.MyYuedouCallBack;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoucallback.MyYuedou_youCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by TMVPHelper on 2018/07/13
 */
public class YueDouModel implements YueDouContract.Model {

    private final ApiService apiService;

    public YueDouModel() {
        apiService = RETROFIT_MESSAGE.budler().create(ApiService.class);
    }

    @Override
    public void getSuper_zuoM(String string, final MyYuedouCallBack myYuedouCallBack) {
        apiService.getSuper(string).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SuperLVBean>() {
                    @Override
                    public void call(SuperLVBean superLVBean) {
                        myYuedouCallBack.onSucces(superLVBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        myYuedouCallBack.onFulie(throwable.getMessage());
                    }
                });
    }

    @Override
    public void getSuper_youM(String string, final MyYuedou_youCallback myYuedou_youCallback) {
        //通过apiservice
        apiService.getLiJuan(string)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<LiKaLiJuanBean>() {
                    @Override
                    public void call(LiKaLiJuanBean liKaLiJuanBean) {
                        myYuedou_youCallback.onSucces(liKaLiJuanBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        myYuedou_youCallback.onFulie(throwable.getMessage());
                    }
                });
    }
}