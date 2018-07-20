package com.example.asus.jouyuejiache_dashixun1.fragment.shouye_log_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.asus.jouyuejiache_dashixun1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Shouji_logFragment extends Fragment {


    @BindView(R.id.med_phone)
    EditText medPhone;
    @BindView(R.id.med_yzpsw)
    EditText medYzpsw;
    @BindView(R.id.ll_log2)
    RelativeLayout llLog2;
    @BindView(R.id.mlog_shouji)
    Button mlogShouji;
    @BindView(R.id.mimg_qq)
    ImageView mimgQq;
    @BindView(R.id.mimg_weixin)
    ImageView mimgWeixin;
    Unbinder unbinder;

    public Shouji_logFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shouji_log, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.med_phone, R.id.med_yzpsw, R.id.mlog_shouji, R.id.mimg_qq, R.id.mimg_weixin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.med_phone:
                break;
            case R.id.med_yzpsw:
                break;
            case R.id.mlog_shouji:
                break;
            case R.id.mimg_qq:
                break;
            case R.id.mimg_weixin:
                break;
        }
    }
}
