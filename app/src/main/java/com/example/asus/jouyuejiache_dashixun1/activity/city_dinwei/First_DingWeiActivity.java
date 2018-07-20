package com.example.asus.jouyuejiache_dashixun1.activity.city_dinwei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.asus.jouyuejiache_dashixun1.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class First_DingWeiActivity extends AppCompatActivity {

    @BindView(R.id.med_chengshi)
    EditText medChengshi;
    @BindView(R.id.mtv_beijing)
    TextView mtvBeijing;
    @BindView(R.id.mtv_shijiaz)
    TextView mtvShijiaz;
    @BindView(R.id.mtv_langfang)
    TextView mtvLangfang;
    @BindView(R.id.mtv_huhehaote)
    TextView mtvHuhehaote;
    @BindView(R.id.mtv_nanjing)
    TextView mtvNanjing;
    @BindView(R.id.mtv_wuhan)
    TextView mtvWuhan;
    @BindView(R.id.mtv_kunming)
    TextView mtvKunming;
    @BindView(R.id.mtv_xian)
    TextView mtvXian;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.side_bar)
    SideBar sideBar;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.mtv2_dwzhi)
    TextView mtv2Dwzhi;
    private List<UserBean> list;

    private AMapLocationClient mLocationClient;
    private AMapLocationClientOption mLocationOption;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {

            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
//可在其中解析amapLocation获取相应内容。
                    String city = amapLocation.getCity();
                    //给选择城市定位赋值，定在什么位置text文本就显示什么位置
                    mtv2Dwzhi.setText(city);
                    Log.e("TAG", city);
                } else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + amapLocation.getErrorCode() + ", errInfo:"
                            + amapLocation.getErrorInfo());
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__ding_wei);
        ButterKnife.bind(this);
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);

        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();

        //获取一次定位结果：
        //该方法默认为false。
        mLocationOption.setOnceLocation(true);

        //获取最近3s内精度最高的一次定位结果：
        // 设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(true);

        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);

        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
        initView();
        initData();
    }

    private void initData() {
        list = new ArrayList<>();

        list.add(new UserBean("保定市"));
        list.add(new UserBean("宝鸡市"));
        list.add(new UserBean("北京市"));

        list.add(new UserBean("沧州市"));

        list.add(new UserBean("邯郸市"));
        list.add(new UserBean("衡水市"));
        list.add(new UserBean("呼和浩特市"));

        list.add(new UserBean("济南市"));
        list.add(new UserBean("晋中市"));

        list.add(new UserBean("昆明市"));

        list.add(new UserBean("廊坊市"));

        list.add(new UserBean("南京市"));

        list.add(new UserBean("秦皇岛市"));

        list.add(new UserBean("石家庄市"));
        list.add(new UserBean("上饶市"));

        list.add(new UserBean("太原市"));
        list.add(new UserBean("唐山市"));

        list.add(new UserBean("武汉市"));
        list.add(new UserBean("武威市"));

        list.add(new UserBean("邢台市"));
        list.add(new UserBean("西安市"));

        Collections.sort(list); // 对list进行排序，需要让User实现Comparable接口重写compareTo方法
        SortAdapter adapter = new SortAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = getIntent();
                intent.putExtra("name", list.get(position).getName());
                setResult(0, intent);
                finish();
            }
        });
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        sideBar = (SideBar) findViewById(R.id.side_bar);
        sideBar.setOnStrSelectCallBack(new SideBar.ISideBarSelectCallBack() {

            @Override
            public void onSelectStr(int index, String selectStr) {
                for (int i = 0; i < list.size(); i++) {
                    if (selectStr.equalsIgnoreCase(list.get(i).getFirstLetter())) {
                        listView.setSelection(i); // 选择到首字母出现的位置
                        return;
                    }
                }
            }
        });

    }

    String s;

    @OnClick({R.id.img_back, R.id.mtv_kunming, R.id.mtv_beijing, R.id.mtv_shijiaz, R.id.mtv_langfang, R.id.mtv_huhehaote, R.id.mtv_nanjing, R.id.mtv_wuhan, R.id.mtv_xian})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mtv_beijing:
                s = mtvBeijing.getText().toString();
                dianji(s);
                break;
            case R.id.mtv_shijiaz:
                s = mtvShijiaz.getText().toString();
                dianji(s);
                break;
            case R.id.mtv_langfang:
                s = mtvLangfang.getText().toString();
                dianji(s);
                break;
            case R.id.mtv_huhehaote:
                s = mtvHuhehaote.getText().toString();
                dianji(s);
                break;
            case R.id.mtv_nanjing:
                s = mtvNanjing.getText().toString();
                dianji(s);
                break;
            case R.id.mtv_wuhan:
                s = mtvWuhan.getText().toString();
                dianji(s);
                break;
            case R.id.mtv_xian:
                s = mtvXian.getText().toString();
                dianji(s);
                break;
            case R.id.mtv_kunming:
                s = mtvKunming.getText().toString();
                dianji(s);
                break;
            case R.id.img_back:
                finish();
                break;
        }
    }

    private void dianji(String s) {
        Intent intent = getIntent();
        intent.putExtra("name", s);
        setResult(0, intent);
        finish();
    }
}
