package com.example.asus.jouyuejiache_dashixun1.utils;

/**
 * Created by Administrator on 2018/7/4.
 * (～￣▽￣)～ 嘛哩嘛哩哄
 */

public class BaseUtils {
    public static SharedPreferencesUtil getShareFile(){
        return SharedPreferencesUtil.getInstance(Const.SP_TOURIST);
    }
    public static  ChengShiQieHuan getcsqh(){
        return ChengShiQieHuan.getChengShiQieHuan();
    }
 }
