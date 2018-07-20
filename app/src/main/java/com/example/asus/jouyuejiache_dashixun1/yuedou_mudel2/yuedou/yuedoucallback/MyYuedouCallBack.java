package com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoucallback;

import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.SuperLVBean;

public interface MyYuedouCallBack {
    void onSucces(SuperLVBean superLVBean);
    void onFulie(String msg);
}
