package com.example.asus.jouyuejiache_dashixun1.fragment.fragment_jiakao;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.KeErShiPing_Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.expert2_jiakaozj.ke_er.KeEr_YuYinActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.expert2_jiakaozj.ke_er.StudyCar_Activity;
import com.example.asus.jouyuejiache_dashixun1.adapter.LVKeEr_adapter;
import com.example.asus.jouyuejiache_dashixun1.adapter.Recycl_LVKeEr_adapter;
import com.example.asus.jouyuejiache_dashixun1.base.BaseFragment;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.ResultListBean;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeContract;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeModel;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomePresenter;

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
public class TwoFragment extends BaseFragment<HomePresenter,HomeModel> implements HomeContract.View{


    @BindView(R.id.mkeer)
    TextView mkeer;
    @BindView(R.id.mjiaot)
    TextView mjiaot;
    @BindView(R.id.mkaoshi)
    TextView mkaoshi;
    @BindView(R.id.wifi)
    LinearLayout wifi;
    @BindView(R.id.mlv1_Two)
    RecyclerView mlv1Two;
    @BindView(R.id.m_dianjisp)
    TextView mDianjisp;
    @BindView(R.id.mimg_dianji01)
    ImageView mimgDianji01;
    @BindView(R.id.mimg_dianji02)
    ImageView mimgDianji02;
    @BindView(R.id.mimg_dianji03)
    ImageView mimgDianji03;
    @BindView(R.id.mimg_taban)
    ImageView mimgTaban;
    @BindView(R.id.mimg_jiashutb)
    ImageView mimgJiashutb;
    @BindView(R.id.mimg_dianji1)
    ImageView mimgDianji1;
    @BindView(R.id.mimg_dianji2)
    ImageView mimgDianji2;
    @BindView(R.id.mimg_dianji3)
    ImageView mimgDianji3;
    @BindView(R.id.mimg_taban4)
    ImageView mimgTaban4;
    @BindView(R.id.mimg_jiashutb5)
    ImageView mimgJiashutb5;
    Unbinder unbinder;
    private List<ResultListBean> resultList;
    private Recycl_LVKeEr_adapter recycl_lvKeEr_adapter;
    private Intent intent;

    @Override
    protected void initData() {
        myPresenter.getKeErDataP("https://api.dyhoa.com/dapi/v4/exam/videoNew?terminal=1601&sign=acf52e50f770088f0aec15972b816190&carType=1&mid=21671&signature=07b34a1ecc75726a920c0862cdab4e6f2ac0fff2&course=2&version=3.6.8.9&phone=18201222438&timestamp=1530752184&schoolCode=0&cityId=110000&os=1501&nonceStr=6d584275cddaca779560a6c0a46ac90a");
    }

    @Override
    protected void initView(View inflate) {
        unbinder = ButterKnife.bind(this, inflate);
    }

    @Override
    public int getfragmentLayoutId() {
        return R.layout.fragment_two;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    public String URL_KERKG="http://api.dyhoa.com/dweixin/h5/extlink/course2/kg/xiaoche2.html";
    public String URL_AQD="https://www.dyhoa.com/misc/20180308/skill/course2/anquandai.html?t=1531965858363";
    public String URL_DHKG="https://www.dyhoa.com/misc/20180308/skill/course2/dianhuokaiguan.html?t=1531966267460";
    public String URL_FXP="https://www.dyhoa.com/misc/20180308/skill/course2/fangxiangpan.html?t=1531966295924";
    public String URL_ZDTB="https://www.dyhoa.com/misc/20180308/skill/course2/zhidongtaban.html?t=1531966390852";
    public String URL_JSTB="https://www.dyhoa.com/misc/20180308/skill/course2/jiasutaban.html?t=1531966415100";
    public String URL_LHQ="https://www.dyhoa.com/misc/20180308/skill/course2/liheqi.html?t=1531966456271";
    public String URL_ZCZD="https://www.dyhoa.com/misc/20180308/skill/course2/zhuchezidong.html?t=1531966515268";
    public String URL_ZYTZ="https://www.dyhoa.com/misc/20180308/skill/course2/zuoqitiaozheng.html?t=1531966532029";
    public String URL_HSJ="https://www.dyhoa.com/misc/20180308/skill/course2/houshijing.html?t=1531966532029";
    public String URL_JYJQ="https://www.dyhoa.com/misc/20180308/skill/course2/jingyanjiqiao.html?t=1531966532029";

    @OnClick({R.id.mkeer, R.id.mjiaot, R.id.mkaoshi, R.id.wifi, R.id.m_dianjisp, R.id.mimg_dianji01, R.id.mimg_dianji02, R.id.mimg_dianji03, R.id.mimg_taban, R.id.mimg_jiashutb, R.id.mimg_dianji1, R.id.mimg_dianji2, R.id.mimg_dianji3, R.id.mimg_taban4, R.id.mimg_jiashutb5})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mkeer:
                intent = new Intent(getActivity(), StudyCar_Activity.class);
                intent.putExtra("url",URL_KERKG);
                startActivity(intent);
                break;
            case R.id.mjiaot:
                break;
            case R.id.mkaoshi:
                break;
            case R.id.wifi:
                intent = new Intent(getActivity(), KeEr_YuYinActivity.class);
                startActivity(intent);
                break;
            case R.id.m_dianjisp:
                String s = mDianjisp.getText().toString();
                if(s.equals("收起")){
                    recycl_lvKeEr_adapter.setA(3);
                    mDianjisp.setText("查看全部18个视频");
                    recycl_lvKeEr_adapter.notifyDataSetChanged();
                }else {
                    recycl_lvKeEr_adapter.setA(resultList.size());
                    mDianjisp.setText("收起");
                    recycl_lvKeEr_adapter.notifyDataSetChanged();
                }
                break;
            //学车技巧
            case R.id.mimg_dianji01:
                this.intent = new Intent(getActivity(), StudyCar_Activity.class);
                this.intent.putExtra("url",URL_AQD);
                startActivity(this.intent);
                break;
            case R.id.mimg_dianji02:
                this.intent = new Intent(getActivity(), StudyCar_Activity.class);
                this.intent.putExtra("url",URL_DHKG);
                startActivity(this.intent);
                break;
            case R.id.mimg_dianji03:
                this.intent = new Intent(getActivity(), StudyCar_Activity.class);
                this.intent.putExtra("url",URL_FXP);
                startActivity(this.intent);
                break;
            case R.id.mimg_taban:
                this.intent = new Intent(getActivity(), StudyCar_Activity.class);
                this.intent.putExtra("url",URL_ZDTB);
                startActivity(this.intent);
                break;
            case R.id.mimg_jiashutb:
                this.intent = new Intent(getActivity(), StudyCar_Activity.class);
                this.intent.putExtra("url",URL_JSTB);
                startActivity(this.intent);
                break;
            case R.id.mimg_dianji1:
                this.intent = new Intent(getActivity(), StudyCar_Activity.class);
                this.intent.putExtra("url",URL_LHQ);
                startActivity(this.intent);
                break;
            case R.id.mimg_dianji2:
                this.intent = new Intent(getActivity(), StudyCar_Activity.class);
                this.intent.putExtra("url",URL_ZCZD);
                startActivity(this.intent);
                break;
            case R.id.mimg_dianji3:
                this.intent = new Intent(getActivity(), StudyCar_Activity.class);
                this.intent.putExtra("url",URL_ZYTZ);
                startActivity(this.intent);
                break;
            case R.id.mimg_taban4:
                this.intent = new Intent(getActivity(), StudyCar_Activity.class);
                this.intent.putExtra("url",URL_HSJ);
                startActivity(this.intent);
                break;
            case R.id.mimg_jiashutb5:
                this.intent = new Intent(getActivity(), StudyCar_Activity.class);
                this.intent.putExtra("url",URL_JYJQ);
                startActivity(this.intent);
                break;
        }
    }

    @Override
    public void getPostData(ResponseBody homeBean) {

    }

    @Override
    public void getKeErDataV(KeerBean keerBean) {
        resultList = keerBean.getResultList();
        Log.e("TAG",keerBean.getMessage());
        mlv1Two.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycl_lvKeEr_adapter = new Recycl_LVKeEr_adapter(resultList, getActivity());
        mlv1Two.setAdapter(recycl_lvKeEr_adapter);
        recycl_lvKeEr_adapter.setMyCallBack(new Recycl_LVKeEr_adapter.MyCallBack() {
            @Override
            public void getData(int id) {
                String voideUrl = resultList.get(id).getVoideUrl();
                String title = resultList.get(id).getTitle();
                Intent intent = new Intent(getActivity(), KeErShiPing_Activity.class);
                intent.putExtra("voideurl",voideUrl);
                intent.putExtra("title",title);
                startActivity(intent);
            }
        });

    }

    @Override
    public <T> void getShequ_ZxDataV(T t) {

    }
}
