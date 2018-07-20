package com.example.asus.jouyuejiache_dashixun1.mudel.home.homeview;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.First_LogActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.city_dinwei.First_DingWeiActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_jiaxiaoxq.Shouye_XiangqinActivity;
import com.example.asus.jouyuejiache_dashixun1.adapter.ShouYeAdapter;
import com.example.asus.jouyuejiache_dashixun1.base.BaseFragment;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeContract;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeModel;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomePresenter;
import com.example.asus.jouyuejiache_dashixun1.utils.BaseUtils;
import com.example.asus.jouyuejiache_dashixun1.utils.ChengShiQieHuan;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.ResponseBody;

public class HomeFragment extends BaseFragment<HomePresenter, HomeModel> implements HomeContract.View {
    @BindView(R.id.xuanzedizhi)
    Button xuanzedizhi;
    @BindView(R.id.lingdang)
    ImageView lingdang;
    Unbinder unbinder;
    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private ShouYeAdapter shouYeAdapter;
    private JSONObject result;
    ChengShiQieHuan chengShiQieHuan = BaseUtils.getcsqh();
    private List<String> xianging = new ArrayList<>();
    private List<String> banci = new ArrayList<>();
    private String data1;

    @Override
    protected void initData() {
        //初始化详情json
        //海驾
        xianging.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=a0872cc5b5ca4cc25076f3d868e1bdf8&version=3.6.8.9&sign=d7e1160b7ca01a69bcf3dc0edfd320d1&timestamp=1531328372&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=163&mid=&signature=6618819c87ccd326d7dad0287d0adbfaedf1b0e3");
        banci.add("https://api.dyhoa.com/dapi/v4/course/getCourseList?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=b052e2e0c0ad1b2d5036bd56e27d061c&version=3.6.8.9&sign=44c7ec999573a828991869fab4f16d06&timestamp=1531328372&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=163&mid=&signature=4828e9abcdb9ad969219684d7001c113ace24221");
        //远大
        xianging.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=8396b14c5dff55d13eea57487bf8ed26&version=3.6.8.9&sign=71a5635aa69f5eeb2bea3eb5d253aa63&timestamp=1531328539&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=162&mid=&signature=bec7b226d38e0ae9ba2b45810857828006ee43a2");
        banci.add("https://api.dyhoa.com/dapi/v4/course/getCourseList?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=2156795824e042092b04e970977114cd&version=3.6.8.9&sign=e8b35b4faf7fa43373feb5846296ad74&timestamp=1531328539&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=162&mid=&signature=c916d19c104a3bcf8e3961448c5407938550921b");
        //龙泉
        xianging.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=52d2752b150f9c35ccb6869cbf074e48&version=3.6.8.9&sign=8499212761b4c20a1083670bb71c5382&timestamp=1531328646&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=164&mid=&signature=c872eb5d662c98914f7aaac245481b8dce486343");
        banci.add("https://api.dyhoa.com/dapi/v4/course/getCourseList?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=48259990138bc03361556fb3f94c5d45&version=3.6.8.9&sign=7146f13508ab99fa134847fc6d1f029f&timestamp=1531328646&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=164&mid=&signature=ca6d6aa12f389ad57c9d94ef98dba39ab6db2321");
        //远方
        xianging.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=922073b18844540f8fe447c3e93a25b7&version=3.6.8.9&sign=403ebd4d33346764a64742acde9a1fce&timestamp=1531328152&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=154&mid=&signature=f67774791dad667555a32a08b2b09b5143fc0280");
        banci.add("https://api.dyhoa.com/dapi/v4/course/getCourseList?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=0950ca92a4dcf426067cfd2246bb5ff3&version=3.6.8.9&sign=6b549eaa2c1563c8f5b1040513cd129b&timestamp=1531328152&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=154&mid=&signature=b74eec58d890485af70179e8a3609a71c1e73c37");
        //驰安
        xianging.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=d54e99a6c03704e95e6965532dec148b&version=3.6.8.9&sign=43709d12dfdfefd8fc9c69f5f49b4c7b&timestamp=1531327381&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=148&mid=&signature=3f0b558d69376e178f9997fcbe95d2625102a398");
        banci.add("https://api.dyhoa.com/dapi/v4/course/getCourseList?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=3d387d2612f9027154ed3b99a7427da1&version=3.6.8.9&sign=0182ec93461121932cc66451f4179a3e&timestamp=1531327381&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=148&mid=&signature=7e62bad97f8ee14d710e7d15f66e4646a327b85e");
        //京顺
        xianging.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=484a231d05ee0b8331980daf4c1749fb&version=3.6.8.9&sign=3ad3d6731edc2a0e0ba07c32b7d8e513&timestamp=1531328796&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=171&mid=&signature=b561ea59575c3067ef6540acc617e4a5b524cb66");
        banci.add("https://api.dyhoa.com/dapi/v4/course/getCourseList?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=8e7991af8afa942dc572950e01177da5&version=3.6.8.9&sign=12594f146b59d5db98412bb44ce26340&timestamp=1531328796&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=171&mid=&signature=83acdddc7af01ade341c3d86fb626c5666373ef1");
        //北方
        xianging.add("https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=27ed0fb950b856b06e1273989422e7d3&version=3.6.8.9&sign=fcf8f1f989a48c42c8346d6c3d1e0f75&timestamp=1531328713&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=188&mid=&signature=e103837547c9fb1848962d9de1ad861083ac6bc4");
        banci.add("https://api.dyhoa.com/dapi/v4/course/getCourseList?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=4671aeaf49c792689533b00664a5c3ef&version=3.6.8.9&sign=0644ff5cc2a7c77c55fb12248642f8c0&timestamp=1531328713&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=188&mid=&signature=daf9039bcf48a611290f789e687399fe1b78b29f");
        data1 = "https://api.dyhoa.com/dapi/v4?sign=590ddc1db805a8fd09d2e9cb3589786c&timestamp=1530632976&os=1501&phone=&terminal=1601&imei=863254010682473&nonceStr=0801b20e08c3242125d512808cd74302&signature=05b5332118fc38eb168fcfdafd5fbafdef57381a&mobile=&version=3.6.8.9";
        String s = xuanzedizhi.getText().toString();
        data1 = chengShiQieHuan.getData(s);
        if(data1.equals("a")){
            myPresenter.getPostData("https://api.dyhoa.com/dapi/v4?sign=590ddc1db805a8fd09d2e9cb3589786c&timestamp=1530632976&os=1501&phone=&terminal=1601&imei=863254010682473&nonceStr=0801b20e08c3242125d512808cd74302&signature=05b5332118fc38eb168fcfdafd5fbafdef57381a&mobile=&version=3.6.8.9");
        }else{
            myPresenter.getPostData(data1);
        }

//            //提示去选择城市并跳转到选择城市页面
//            final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//            builder.setTitle("提示");
//            builder.setMessage("该城市暂未开通,请选择其他城市");
//            builder.setPositiveButton("去选择", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Intent intent = new Intent(getActivity(), First_DingWeiActivity.class);
//                    startActivity(intent);
//                }
//            });
//            builder.create();
//            builder.show();
    }

    @OnClick(R.id.xuanzedizhi)
    public void onViewClicked() {
        startActivityForResult(new Intent(getContext(), First_DingWeiActivity.class), 1);
    }

    @Override
    protected void initView(View inflate) {
        unbinder = ButterKnife.bind(this, inflate);
        refreshLayout.setRefreshHeader(new MaterialHeader(getContext()).setShowBezierWave(true));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                Toast.makeText(getContext(), "又加载一次", Toast.LENGTH_SHORT).show();
                String s = xuanzedizhi.getText().toString();
                data1 = chengShiQieHuan.getData(s);
                if (!data1.equals("a")) {
                    myPresenter.getPostData(data1);
                }

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefresh();
                        refreshlayout.finishRefresh(3000);
                    }
                }, 3000);
            }
        });
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        xuanzedizhi.setText("广元市");
        lingdang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), First_LogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int getfragmentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void getPostData(ResponseBody homeBean) {
        try {
            String bena = homeBean.string();
            JSONObject jsonObject = new JSONObject(bena);
            result = jsonObject.getJSONObject("result");
            FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
            shouYeAdapter = new ShouYeAdapter(supportFragmentManager, result, getActivity());
            rlv.setAdapter(shouYeAdapter);
            shouYeAdapter.setXianShiAmi(new ShouYeAdapter.XianShiAmi() {
                @Override
                public void xianShi(int id) {
                    Intent intent = new Intent(getActivity(), Shouye_XiangqinActivity.class);
                    intent.putExtra("xiangqing", xianging.get(id));
                    intent.putExtra("banci", banci.get(id));
                    startActivity(intent);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getKeErDataV(KeerBean keerBean) {

    }

    @Override
    public <T> void getShequ_ZxDataV(T t) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1 && resultCode == 0 && data != null) {
            String name = data.getStringExtra("name");
            xuanzedizhi.setText(name);
            data1 = chengShiQieHuan.getData(name);
            if (!data1.equals("a")) {
                myPresenter.getPostData("https://api.dyhoa.com/" + data1);
            } else {
              /*  //提示去选择城市并跳转到选择城市页面
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示");
                builder.setMessage("该城市暂未开通,请选择其他城市");
                builder.setPositiveButton("去选择", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), First_DingWeiActivity.class);
                        startActivity(intent);
                    }
                });
                builder.create().cancel();*/
               // builder.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
