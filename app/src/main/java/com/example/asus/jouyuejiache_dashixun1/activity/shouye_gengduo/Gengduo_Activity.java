package com.example.asus.jouyuejiache_dashixun1.activity.shouye_gengduo;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.adapter.Shouye_Gengduo_Recycl;
import com.example.asus.jouyuejiache_dashixun1.base.BaseActivity;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_toutiao_genduo.Shouye_Tt_gengduo;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeContract;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeModel;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomePresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;

public class Gengduo_Activity extends BaseActivity<HomePresenter,HomeModel> implements HomeContract.View {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.mgl_img2)
    ImageView mglImg2;
    @BindView(R.id.mgl_img)
    ImageView mglImg;
    @BindView(R.id.mgl_img3)
    ImageView mglImg3;
    @BindView(R.id.mgl_img4)
    ImageView mglImg4;
    @BindView(R.id.XRecycl)
    RecyclerView mRecycl;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private List<com.example.asus.jouyuejiache_dashixun1.bean.shouye_toutiao_genduo.ResultListBean> resultList;

    @Override
    protected void initData() {
        mPresenter.getToutiao_gdDataP("https://api.dyhoa.com/dapi/v4/article/list");
        ButterKnife.bind(this);
        mRecycl.setLayoutManager(new LinearLayoutManager(Gengduo_Activity.this));
        smart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示S刷新失败
            }
        });
        smart.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
        smart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        smart.finishRefresh();
                        refreshlayout.finishRefresh(3000);
                    }
                }, 3000);
            }
        });
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_gengduo_;
    }

    @OnClick({R.id.img_back, R.id.mgl_img2, R.id.mgl_img, R.id.mgl_img3, R.id.mgl_img4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.mgl_img2:
                break;
            case R.id.mgl_img:
                break;
            case R.id.mgl_img3:
                break;
            case R.id.mgl_img4:
                break;
        }
    }

    @Override
    public void getPostData(ResponseBody homeBean) {

    }

    @Override
    public void getKeErDataV(KeerBean keerBean) {

    }

    @Override
    public <T> void getShequ_ZxDataV(T t) {
        Shouye_Tt_gengduo shouye_tt_gengduo= (Shouye_Tt_gengduo) t;
        Log.e("TAg_1111111",shouye_tt_gengduo.getCode()+"");
        resultList = shouye_tt_gengduo.getResultList();
        Shouye_Gengduo_Recycl shouye_gengduo_recycl = new Shouye_Gengduo_Recycl(resultList, Gengduo_Activity.this);
        mRecycl.setAdapter(shouye_gengduo_recycl);
        shouye_gengduo_recycl.setMyCallBack_gd(new Shouye_Gengduo_Recycl.MyCallBack_gd() {
            @Override
            public void getData(int id) {
                String gourl = resultList.get(id).getGourl();
                Intent intent = new Intent(Gengduo_Activity.this, Toutiao_Xq_Activity.class);
                intent.putExtra("url",gourl);
                startActivity(intent);
            }
        });

    }
}
