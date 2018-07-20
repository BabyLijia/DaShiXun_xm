package com.example.asus.jouyuejiache_dashixun1.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.First_LogActivity;
import com.example.asus.jouyuejiache_dashixun1.adapter.MyPagerAdapter;
import com.example.asus.jouyuejiache_dashixun1.fragment.community_fragment_shequ.GaoXiao_Fragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.community_fragment_shequ.GuanZhu_Fragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.community_fragment_shequ.MeiYan_Fragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.community_fragment_shequ.Zhuire_Fragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.community_fragment_shequ.Zhuixin_Fragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.community_fragment_shequ.ZiBao_Fragment;
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
public class CommunityFragment extends Fragment {


    @BindView(R.id.mimg_geren)
    ImageView mimgGeren;
    @BindView(R.id.mimg_gerenjia)
    ImageView mimgGerenjia;
    @BindView(R.id.mimg_xinxi)
    ImageView mimgXinxi;
    @BindView(R.id.mimg_back)
    ImageView mimgBack;
    @BindView(R.id.mimg_juanzi1)
    ImageView mimgJuanzi1;
    @BindView(R.id.mimg_juanzi2)
    ImageView mimgJuanzi2;
    @BindView(R.id.mimg_juanzi3)
    ImageView mimgJuanzi3;
    @BindView(R.id.mimg_juanzi4)
    ImageView mimgJuanzi4;
    @BindView(R.id.mTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    Unbinder unbinder;

    public CommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_community, container, false);
        unbinder = ButterKnife.bind(this, view);
        mTabLayout.setupWithViewPager(mViewPager);
        initData();
        return view;
    }

    private List<Fragment> mFragmentList;
    private List<String> mStringList;

    private void initData() {
        mFragmentList=new ArrayList<>();
        mFragmentList.add(new Zhuixin_Fragment());
        mFragmentList.add(new Zhuire_Fragment());
        mFragmentList.add(new GuanZhu_Fragment());
        mFragmentList.add(new MeiYan_Fragment());
        mFragmentList.add(new GaoXiao_Fragment());
        mFragmentList.add(new ZiBao_Fragment());

        mStringList = new ArrayList<>();
        mStringList.add("最新");
        mStringList.add("最热");
        mStringList.add("关注");
        mStringList.add("美颜");
        mStringList.add("搞笑");
        mStringList.add("自爆");

        // 创建ViewPager适配器
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager(), mFragmentList, mStringList, getActivity());
        mViewPager.setAdapter(myPagerAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mimg_geren, R.id.mimg_gerenjia, R.id.mimg_xinxi, R.id.mimg_back, R.id.mimg_juanzi1, R.id.mimg_juanzi2, R.id.mimg_juanzi3, R.id.mimg_juanzi4, R.id.mTabLayout, R.id.mViewPager})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mimg_geren:
                Intent intent1 = new Intent(getActivity(), First_LogActivity.class);
                startActivity(intent1);
                break;
            case R.id.mimg_gerenjia:
                Intent intent2 = new Intent(getActivity(), First_LogActivity.class);
                startActivity(intent2);
                break;
            case R.id.mimg_xinxi:
                Intent intent3 = new Intent(getActivity(), First_LogActivity.class);
                startActivity(intent3);
                break;
            case R.id.mimg_back:
                break;
            case R.id.mimg_juanzi1:
                break;
            case R.id.mimg_juanzi2:
                break;
            case R.id.mimg_juanzi3:
                break;
            case R.id.mimg_juanzi4:
                break;
        }
    }
}
