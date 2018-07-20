package com.example.asus.jouyuejiache_dashixun1.fragment.community_fragment_shequ;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.adapter.SheQu_Recycl;
import com.example.asus.jouyuejiache_dashixun1.base.BaseFragment;
import com.example.asus.jouyuejiache_dashixun1.bean.SheQuBean;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeContract;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeModel;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.ResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeiYan_Fragment extends BaseFragment<HomePresenter, HomeModel> implements HomeContract.View {

    @BindView(R.id.mRecyclz)
    RecyclerView mRecyclz;
    Unbinder unbinder;


    @Override
    protected void initData() {
        myPresenter.getShequ_ZxDataP("https://api.dyhoa.com/dapi/v4/bbs/articleList?nextPage=1&terminal=1601&sign=520d98a9f3b8acb2a131cd582ee41ab4&mid=21671&signature=095758aba59c07c91f42204bdfc2d36c18e93150&pageSize=20&version=3.6.8.9&phone=18201222438&timestamp=1530782737&type=3&os=1501&nonceStr=2cb6b10338a7fc4117a80da24b582060");

    }

    @Override
    protected void initView(View inflate) {
        unbinder = ButterKnife.bind(this, inflate);
        mRecyclz.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public int getfragmentLayoutId() {
        return R.layout.fragment_zhuixin_;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getPostData(ResponseBody homeBean) {

    }

    @Override
    public void getKeErDataV(KeerBean keerBean) {

    }

    @Override
    public <T> void getShequ_ZxDataV(T t) {
        String s = (String) t;
        try {
            JSONObject s1 = new JSONObject(s);
            JSONArray resultList = s1.getJSONArray("resultList");
            SheQu_Recycl sheQu_recycl = new SheQu_Recycl(resultList, getActivity());
            mRecyclz.setAdapter(sheQu_recycl);
            sheQu_recycl.setMyCallBack(new SheQu_Recycl.MyCallBack() {
                @Override
                public void getData(int id) {


                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
