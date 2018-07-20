package com.example.asus.jouyuejiache_dashixun1.base;

public class BasePresenter<M, V> {
    //初始化M,V 将model和View注入p层
    public M myModel;
    public V myView;
    public void getMV(M m,V v){
        myModel=m;
        myView=v;
    }
}
