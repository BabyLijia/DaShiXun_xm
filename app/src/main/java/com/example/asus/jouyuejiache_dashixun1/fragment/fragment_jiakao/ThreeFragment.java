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
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.KeErShiPing_Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.expert2_jiakaozj.ke_san.KeSan_YuYinActivity;
import com.example.asus.jouyuejiache_dashixun1.adapter.Recycl_LVKeEr_adapter;
import com.example.asus.jouyuejiache_dashixun1.base.BaseFragment;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.ResultListBean;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeContract;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomeModel;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homemvp.HomePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.ResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends BaseFragment<HomePresenter, HomeModel> implements HomeContract.View {

    Unbinder unbinder;
    @BindView(R.id.mkeer1)
    TextView mkeer1;
    @BindView(R.id.mjiaot1)
    TextView mjiaot1;
    @BindView(R.id.mkaoshi1)
    TextView mkaoshi1;
    @BindView(R.id.ll_jiakao1)
    LinearLayout llJiakao1;
    @BindView(R.id.mimg_dengguang1)
    ImageView mimgDengguang1;
    @BindView(R.id.mimg_yuying1)
    ImageView mimgYuying1;
    @BindView(R.id.wifi1)
    LinearLayout wifi1;
    @BindView(R.id.xian1)
    TextView xian1;
    @BindView(R.id.mtv_shiping1)
    TextView mtvShiping1;
    @BindView(R.id.mlv1_Two1)
    RecyclerView mlv1Two1;
    @BindView(R.id.m_dianjisp1)
    TextView mDianjisp1;
    @BindView(R.id.xian21)
    TextView xian21;
    @BindView(R.id.study1)
    TextView study1;
    @BindView(R.id.mimg_dianji011)
    ImageView mimgDianji011;
    @BindView(R.id.mimg_dianji021)
    ImageView mimgDianji021;
    @BindView(R.id.mimg_dianji031)
    ImageView mimgDianji031;
    @BindView(R.id.mimg_taban1)
    ImageView mimgTaban1;
    @BindView(R.id.mimg_jiashutb1)
    ImageView mimgJiashutb1;
    @BindView(R.id.mll31)
    LinearLayout mll31;
    private List<ResultListBean> resultList;
    private Recycl_LVKeEr_adapter recycl_lvKeEr_adapter;

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
        return R.layout.fragment_threee;
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
        resultList = keerBean.getResultList();
        Log.e("TAG", keerBean.getMessage());
        mlv1Two1.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycl_lvKeEr_adapter = new Recycl_LVKeEr_adapter(resultList, getActivity());
        mlv1Two1.setAdapter(recycl_lvKeEr_adapter);
        recycl_lvKeEr_adapter.setMyCallBack(new Recycl_LVKeEr_adapter.MyCallBack() {
            @Override
            public void getData(int id) {
                String voideUrl = resultList.get(id).getVoideUrl();
                String title = resultList.get(id).getTitle();
                Intent intent = new Intent(getActivity(), KeErShiPing_Activity.class);
                intent.putExtra("voideurl", voideUrl);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
    }

    @Override
    public <T> void getShequ_ZxDataV(T t) {

    }

    @OnClick({R.id.mkeer1, R.id.mjiaot1, R.id.mkaoshi1, R.id.mimg_dengguang1, R.id.mimg_yuying1, R.id.m_dianjisp1, R.id.mimg_dianji011, R.id.mimg_dianji021, R.id.mimg_dianji031, R.id.mimg_taban1, R.id.mimg_jiashutb1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mkeer1:
                break;
            case R.id.mjiaot1:
                break;
            case R.id.mkaoshi1:
                break;
            case R.id.mimg_dengguang1:
                break;
            case R.id.mimg_yuying1:
                Intent intent = new Intent(getActivity(), KeSan_YuYinActivity.class);
                startActivity(intent);
                break;
            case R.id.m_dianjisp1:
                String s = mDianjisp1.getText().toString();
                if(s.equals("收起")){
                    recycl_lvKeEr_adapter.setA(3);
                    mDianjisp1.setText("查看全部18个视频");
                    recycl_lvKeEr_adapter.notifyDataSetChanged();
                }else {
                    recycl_lvKeEr_adapter.setA(resultList.size());
                    mDianjisp1.setText("收起");
                    recycl_lvKeEr_adapter.notifyDataSetChanged();
                }
                break;
            case R.id.mimg_dianji011:
                break;
            case R.id.mimg_dianji021:
                break;
            case R.id.mimg_dianji031:
                break;
            case R.id.mimg_taban1:
                break;
            case R.id.mimg_jiashutb1:
                break;
        }
    }
}
