package com.example.asus.jouyuejiache_dashixun1.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.city_dinwei.First_DingWeiActivity;
import com.example.asus.jouyuejiache_dashixun1.adapter.MyPagerAdapter;
import com.example.asus.jouyuejiache_dashixun1.fragment.fragment_jiakao.FourFragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.fragment_jiakao.OneFragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.fragment_jiakao.ThreeFragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.fragment_jiakao.TwoFragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.fragment_jiakao.ZhengFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExpertFragment extends Fragment {


    @BindView(R.id.mTablayout)
    TabLayout mTablayout;
    @BindView(R.id.mviewPager)
    ViewPager mviewPager;
    Unbinder unbinder;
    @BindView(R.id.mimg_Ex)
    ImageView mimgEx;
    @BindView(R.id.bjing_tv)
    TextView bjingTv;
    private List<Fragment> fragments;
    private List<String> mstrings;
    private SharedPreferences xiangdao;
    private boolean tu;

    public ExpertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expert, container, false);
        xiangdao = getActivity().getSharedPreferences("xiangdao", 0);
        //默认为false
        tu = xiangdao.getBoolean("tu", false);
        unbinder = ButterKnife.bind(this, view);
        mTablayout.setupWithViewPager(mviewPager);
        //判断驾考专家的向导图首次进来显示，之后隐藏
        if(tu){
            mimgEx.setVisibility(View.GONE);
        }
        initData();
        return view;
    }

    private void initData() {
        // 创建一个集合,装填Fragment
        fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FourFragment());
        fragments.add(new ZhengFragment());

        mstrings = new ArrayList<>();
        mstrings.add("科一");
        mstrings.add("科二");
        mstrings.add("科三");
        mstrings.add("科四");
        mstrings.add("拿证");

        // 创建ViewPager适配器
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager(), fragments, mstrings, getActivity());
        mviewPager.setAdapter(myPagerAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mimg_Ex,R.id.bjing_tv})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mimg_Ex:
                mimgEx.setVisibility(View.GONE);
                xiangdao.edit().putBoolean("tu",true).commit();
                break;
            case R.id.bjing_tv:
                Intent intent = new Intent(getActivity(), First_DingWeiActivity.class);
                startActivity(intent);
                break;
        }
    }
}
