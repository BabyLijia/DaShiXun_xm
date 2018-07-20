package com.example.asus.jouyuejiache_dashixun1.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.jouyuejiache_dashixun1.activity.log.App;
import com.example.asus.jouyuejiache_dashixun1.utils.TUtils;


public abstract class BaseFragment<P extends BasePresenter,M extends BaseModel> extends Fragment {
    public P myPresenter;
    private M myModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getfragmentLayoutId(), container, false);
        App.content=getActivity();
        myPresenter= TUtils.getT(this,0);
        myModel=TUtils.getT(this,1);
        if(this instanceof BaseView){
            myPresenter.getMV(myModel,this);
        }
        initView(inflate);

        return inflate;
    }

    //懒加载，在onResume(),或onStart()
    @Override
    public void onStart() {
        initData();
        super.onStart();
    }

    protected abstract void initData();

    protected abstract void initView(View inflate);

    public abstract int getfragmentLayoutId();
}
