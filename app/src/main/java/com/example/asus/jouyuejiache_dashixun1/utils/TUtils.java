package com.example.asus.jouyuejiache_dashixun1.utils;

import java.lang.reflect.ParameterizedType;

public class TUtils {
    public static <T>T getT(Object o,int a){
        try {
            return ((Class<T>)(((ParameterizedType)(o.getClass().getGenericSuperclass())).getActualTypeArguments()[a])).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
