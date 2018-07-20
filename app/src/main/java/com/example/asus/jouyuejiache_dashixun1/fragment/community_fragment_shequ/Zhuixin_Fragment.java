package com.example.asus.jouyuejiache_dashixun1.fragment.community_fragment_shequ;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.First_LogActivity;
import com.example.asus.jouyuejiache_dashixun1.adapter.SheQu_Recycl;
import com.example.asus.jouyuejiache_dashixun1.base.BaseFragment;
import com.example.asus.jouyuejiache_dashixun1.bean.SheQuBean;
import com.example.asus.jouyuejiache_dashixun1.bean.SheQu_Zhuixing.ResultListBean;
import com.example.asus.jouyuejiache_dashixun1.bean.SheQu_Zhuixing.ZhuiXinBean;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeContract;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeModel;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomePresenter;

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
public class Zhuixin_Fragment extends BaseFragment<HomePresenter, HomeModel> implements HomeContract.View {

    @BindView(R.id.mRecyclz)
    RecyclerView mRecyclz;
    Unbinder unbinder;

    public Zhuixin_Fragment() {
        // Required empty public constructor
    }

    @Override
    protected void initData() {
        myPresenter.getShequ_ZxDataP("https://api.dyhoa.com/dapi/v4/bbs/articleList?nextPage=1&terminal=1601&sign=b37c6323cb1960b2e2ce292647f12c2e&mid=21671&signature=1190f025ba715af00d27cd89545f7b08a44ed08f&pageSize=20&version=3.6.8.9&phone=18201222438&timestamp=1530782460&type=2&os=1501&nonceStr=70117ee3c0b15a2950f1e82a215e812b");

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
        //将不确定T强转成String类型
        String s = (String) t;
        try {
            //外层如是{}就newJsonobject,里层是数组[]需用对象变量 . getJsonArray获取到对象内的集合
            JSONObject s1 = new JSONObject(s);
            JSONArray resultList = s1.getJSONArray("resultList");
            //将Json解析出来的数据传入适配器当中
            SheQu_Recycl sheQu_recycl = new SheQu_Recycl(resultList, getActivity());
            mRecyclz.setAdapter(sheQu_recycl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
