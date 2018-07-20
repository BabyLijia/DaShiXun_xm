package com.example.asus.jouyuejiache_dashixun1.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.First_LogActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.Jyue_pingtuanActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.city_dinwei.First_DingWeiActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_Banner1_Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_Banner2Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_Banner3Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_Baoming_Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_YDSupperActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_YueKaoActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_gengduo.Gengduo_Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_jiaxiaoxq.Shouye_XiangqinActivity;
import com.example.asus.jouyuejiache_dashixun1.adapter.Shouye_Recycl_Data;
import com.example.asus.jouyuejiache_dashixun1.adapter.Shouye_Recycl_ScoolCar;
import com.example.asus.jouyuejiache_dashixun1.adapter.Shouye_Recycl_Youshi;
import com.example.asus.jouyuejiache_dashixun1.base.BaseFragment;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.bean.jiaxiaoCar.ScoolCar;
import com.example.asus.jouyuejiache_dashixun1.bean.pingtai.Platform_yous;
import com.example.asus.jouyuejiache_dashixun1.bean.zidingyiData.Choice;
import com.example.asus.jouyuejiache_dashixun1.fragment.shouye_log_fragment.Jouyue_logFragment;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeContract;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeModel;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomePresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.ResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class First_shouyeFragment extends BaseFragment<HomePresenter, HomeModel> implements HomeContract.View {

    @BindView(R.id.mToolbar)
    Toolbar mToolbar;
    @BindView(R.id.mimg_down)
    ImageView mimgDown;
    @BindView(R.id.tv_mcar)
    TextView tvMcar;
    @BindView(R.id.mimg_home)
    ImageView mimgHome;
    Unbinder unbinder;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.mRecycl)
    RecyclerView mRecycl;
    @BindView(R.id.mimg_recycl)
    ImageView mimgRecycl;
    @BindView(R.id.mtv_gengduo)
    TextView mtvGengduo;
    @BindView(R.id.mimg_supper)
    ImageView mimgSupper;
    @BindView(R.id.mimg_haipi)
    ImageView mimgHaipi;
    @BindView(R.id.mimg_dinwei)
    ImageView mimgDinwei;
    @BindView(R.id.mRecycl_bejingCar)
    RecyclerView mRecyclBejingCar;
    @BindView(R.id.mRecycl_Pingtaiyou)
    RecyclerView mRecyclPingtaiyou;
    @BindView(R.id.bjing_tv)
    TextView bjingTv;

    private List<Integer> mStrings = new ArrayList<>();
    private List<String> mlist = new ArrayList<>();
    private List<String> mbanci = new ArrayList<>();

    @Override
    protected void initData() {
        //一开始进入首页弹出ProgressDialog进度条在Fragment页面开始刷新数据
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.show(getActivity(), "提示", "正在加载中。。。。", false, true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();


    }

    @Override
    protected void initView(View inflate) {
        unbinder = ButterKnife.bind(this, inflate);
        //首页Fragment第一个Item
        mRecycl.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        initRecyclData1();
        //首页Fragment第二个Item
        mRecyclBejingCar.setLayoutManager(new LinearLayoutManager(getActivity()));
        initDataList();
        initRecyclCarData2();
        //首页Fragment第三个Item
        mRecyclPingtaiyou.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        initRecyclPingTai3();


    }

    private void initRecyclPingTai3() {

    }

    private void initRecyclCarData2() {
    }

    private void initDataList() {
    }

    private void initRecyclData1() {
    }

    @Override
    public int getfragmentLayoutId() {
        return R.layout.fragment_first_shouye;
    }

    @Override
    public void getPostData(ResponseBody homeBean) {
        //轮播
        mStrings.add(R.drawable.quality_home);
        mStrings.add(R.drawable.treasure_home);
        mStrings.add(R.drawable.simple);

        banner.setImages(mStrings).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getActivity(), First_Banner1_Activity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), First_Banner2Activity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), First_Banner3Activity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });

    }

    @Override
    public void getKeErDataV(KeerBean keerBean) {

    }

    @Override
    public <T> void getShequ_ZxDataV(T t) {

    }
}
