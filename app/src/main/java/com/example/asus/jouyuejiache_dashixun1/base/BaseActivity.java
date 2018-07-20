package com.example.asus.jouyuejiache_dashixun1.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.jouyuejiache_dashixun1.activity.log.App;
import com.example.asus.jouyuejiache_dashixun1.utils.TUtils;

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {

    public P mPresenter;
    public M mModel;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(getActivityLayoutId());
        App.content=this;
        mPresenter = TUtils.getT(this, 0);
        mModel = TUtils.getT(this, 1);
        if (this instanceof BaseView) {
            mPresenter.getMV(mModel, this);
        }
        supportFragmentManager = getSupportFragmentManager();
        super.onCreate(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    public abstract int getActivityLayoutId();

    public void addFragment(int fragmentLayout, Fragment fragment) {
        supportFragmentManager.beginTransaction()
                .add(fragmentLayout, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();
    }

    public void removeBackstackFragment(){
        if(supportFragmentManager.getBackStackEntryCount()>1){
            //弹出栈
           supportFragmentManager.popBackStack();
        }else {
            finish();
        }
    }
}
