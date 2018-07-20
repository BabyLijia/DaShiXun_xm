package com.example.asus.jouyuejiache_dashixun1.activity.shouye_jiaxiaoxq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_Baoming_Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_YDSupperActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_jiaxiaoxq.reimen_bz.ReiMen_ZCLX3Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_jiaxiaoxq.reimen_bz.Reimen_Quanguo2Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_jiaxiaoxq.reimen_bz.Reimen_Zhengchang1Activity;
import com.example.asus.jouyuejiache_dashixun1.base.BaseActivity;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.ResultBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.Xq_CarBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.carxq_reimen.ResultListBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.carxq_reimen.RmBanZhiBean;
import com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carmvp.CarContract;
import com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carmvp.CarModel;
import com.example.asus.jouyuejiache_dashixun1.car_xqmudel3.car.carmvp.CarPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Shouye_XiangqinActivity extends BaseActivity<CarPresenter,CarModel> implements CarContract.View {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_fenxiang)
    ImageView imgFenxiang;
    @BindView(R.id.mRecycl_jiaoxiao_xq)
    RecyclerView mRecyclJiaoxiaoXq;
    private String area_name;
    private String message;
    private ResultBean result;
    private String s;
    private String xiangqing;
    private String banci;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        xiangqing = intent.getStringExtra("xiangqing");
        banci = intent.getStringExtra("banci");
        ButterKnife.bind(this);
        mRecyclJiaoxiaoXq.setLayoutManager(new LinearLayoutManager(Shouye_XiangqinActivity.this));
        mPresenter.getCarDataP(xiangqing);
        //initDataList();
    }
    private List<String> mlist=new ArrayList<>();
    private void initDataList() {
        mlist.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=27ed0fb950b856b06e1273989422e7d3&version=3.6.8.9&sign=fcf8f1f989a48c42c8346d6c3d1e0f75&timestamp=1531328713&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=188&mid=&signature=e103837547c9fb1848962d9de1ad861083ac6bc4");
        mlist.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=8396b14c5dff55d13eea57487bf8ed26&version=3.6.8.9&sign=71a5635aa69f5eeb2bea3eb5d253aa63&timestamp=1531328539&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=162&mid=&signature=bec7b226d38e0ae9ba2b45810857828006ee43a2");
        mlist.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=a0872cc5b5ca4cc25076f3d868e1bdf8&version=3.6.8.9&sign=d7e1160b7ca01a69bcf3dc0edfd320d1&timestamp=1531328372&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=163&mid=&signature=6618819c87ccd326d7dad0287d0adbfaedf1b0e3");
        mlist.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=52d2752b150f9c35ccb6869cbf074e48&version=3.6.8.9&sign=8499212761b4c20a1083670bb71c5382&timestamp=1531328646&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=164&mid=&signature=c872eb5d662c98914f7aaac245481b8dce486343");
        mlist.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=484a231d05ee0b8331980daf4c1749fb&version=3.6.8.9&sign=3ad3d6731edc2a0e0ba07c32b7d8e513&timestamp=1531328796&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=171&mid=&signature=b561ea59575c3067ef6540acc617e4a5b524cb66");
        mlist.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=922073b18844540f8fe447c3e93a25b7&version=3.6.8.9&sign=403ebd4d33346764a64742acde9a1fce&timestamp=1531328152&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=154&mid=&signature=f67774791dad667555a32a08b2b09b5143fc0280");
        mlist.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=d54e99a6c03704e95e6965532dec148b&version=3.6.8.9&sign=43709d12dfdfefd8fc9c69f5f49b4c7b&timestamp=1531327381&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=148&mid=&signature=3f0b558d69376e178f9997fcbe95d2625102a398");
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_shouye__xiangqin;
    }

    @OnClick({R.id.img_back, R.id.img_fenxiang,R.id.mRecycl_jiaoxiao_xq})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_fenxiang:
                break;
        }
    }

    @Override
    public void getCarDataV(Xq_CarBean xq_carBean) {
        result = xq_carBean.getResult();
        area_name = xq_carBean.getResult().getArea_name();
        mPresenter.getRmDataP(banci);
    }

    @Override
    public void getBanzhiDataV(RmBanZhiBean rmBanZhiBean) {
        final List<ResultListBean> resultList = rmBanZhiBean.getResultList();
        message = rmBanZhiBean.getMessage();
        Log.e("TAGname", message);
        Log.e("TAGname", area_name);
        //在最后一个请求的方法里写适配器，以防第二次请求的数据报null
        Shouye_Recycl_jiaxiao1 shouye_recycl_jiaxiao1 = new Shouye_Recycl_jiaxiao1(result,resultList,Shouye_XiangqinActivity.this);
        mRecyclJiaoxiaoXq.setAdapter(shouye_recycl_jiaxiao1);
        shouye_recycl_jiaxiao1.setCallback(new Shouye_Recycl_jiaxiao1.MyCallback() {
            @Override
            public void getData(int id) {
                double longitude = resultList.get(id).getLongitude();
                double latitude = resultList.get(id).getLatitude();
                int id1 = resultList.get(id).getId();
              //  http://api.dyhoa.com/dh5/courseDetail?courseId=" + resultListBean.getId() + "&longitude=" + resultListBean.getLongitude() + "&latitude=" + resultListBean.getLatitude()
                Intent intent = new Intent(Shouye_XiangqinActivity.this, Reimen_Zhengchang1Activity.class);
                intent.putExtra("url","http://api.dyhoa.com/dh5/courseDetail?courseId="+id1+"&longitude="+longitude+"&latitude="+latitude);
                startActivity(intent);
            }
        });
    }
}
