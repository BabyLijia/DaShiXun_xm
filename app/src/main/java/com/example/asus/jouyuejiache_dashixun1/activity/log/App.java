package com.example.asus.jouyuejiache_dashixun1.activity.log;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class App extends Application{
    public static Context content;
    @Override
    public void onCreate() {
        content=this;
        super.onCreate();
        UMConfigure.init(this,"5a12384aa40fa3551f0001d1"
                ,"umeng", UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
       // PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
    }
}