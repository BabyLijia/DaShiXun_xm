package com.example.asus.jouyuejiache_dashixun1.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.adapter.KeErGv;
import com.example.asus.jouyuejiache_dashixun1.bean.KeErDiBu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {
    @BindView(R.id.wode_shezhe)
    ImageView wodeShezhe;
    @BindView(R.id.wode_tongzhi)
    ImageView wodeTongzhi;
    @BindView(R.id.baoming_wode)
    LinearLayout baomingWode;
    @BindView(R.id.qianbao)
    LinearLayout qianbao;
    @BindView(R.id.qian)
    TextView qian;
    @BindView(R.id.wode_yue)
    LinearLayout wodeYue;
    @BindView(R.id.quan)
    TextView quan;
    @BindView(R.id.daijinquan)
    LinearLayout daijinquan;
    @BindView(R.id.dou)
    TextView dou;
    @BindView(R.id.yuedou)
    LinearLayout yuedou;
    @BindView(R.id.wo_rlv)
    RecyclerView woRlv;
    Unbinder unbinder;
    private List<KeErDiBu> lists = new ArrayList<>();

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_my, container, false);
        unbinder = ButterKnife.bind(this, inflate);

        woRlv.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        if (lists.size() == 0) {
            lists.add(new KeErDiBu(R.drawable.image_yuedou_mission_new, "领悦豆"));
            lists.add(new KeErDiBu(R.drawable.image_question_bank_new, "我的题库"));
            lists.add(new KeErDiBu(R.drawable.switch_school_img, "切换驾校"));
            lists.add(new KeErDiBu(R.drawable.image_my_st_new, "绑定驾校"));
            lists.add(new KeErDiBu(R.drawable.image_group_registration_new, "团购报名"));
            lists.add(new KeErDiBu(R.drawable.image_account_security_new, "账户安全"));
            lists.add(new KeErDiBu(R.drawable.image_contact_customer_new, "联系客服"));
            lists.add(new KeErDiBu(R.drawable.image_feedback_new, "意见反馈"));
            lists.add(new KeErDiBu(R.drawable.image_about_us_new, "关系我们"));
            lists.add(new KeErDiBu(R.drawable.image_share_app_new, "分享App"));
        }
        KeErGv keErGv = new KeErGv(lists,getActivity());
        woRlv.setAdapter(keErGv);

        return inflate;
    }
    @OnClick({R.id.wode_shezhe, R.id.wode_tongzhi, R.id.baoming_wode, R.id.qianbao, R.id.wode_yue, R.id.daijinquan, R.id.yuedou})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wode_shezhe:
                break;
            case R.id.wode_tongzhi:
                break;
            case R.id.baoming_wode:
                break;
            case R.id.qianbao:
                break;
            case R.id.wode_yue:
                break;
            case R.id.daijinquan:
                break;
            case R.id.yuedou:
                break;
        }
    }
}
