package com.example.asus.jouyuejiache_dashixun1.fragment.fragment_jiakao;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FourFragment extends Fragment {


    @BindView(R.id.mimg1)
    RelativeLayout mimg1;
    @BindView(R.id.keyi)
    TextView keyi;
    @BindView(R.id.jiaot)
    TextView jiaot;
    @BindView(R.id.dati)
    TextView dati;
    @BindView(R.id.mimg2)
    ImageView mimg2;
    @BindView(R.id.mimg3)
    ImageView mimg3;
    Unbinder unbinder;
    @BindView(R.id.mimg_dianji1)
    ImageView mimgDianji1;
    @BindView(R.id.mimg_dianji2)
    ImageView mimgDianji2;
    @BindView(R.id.mimg_dianji3)
    ImageView mimgDianji3;
    @BindView(R.id.mimg_dianji4)
    ImageView mimgDianji4;
    @BindView(R.id.mimg_dianji01)
    ImageView mimgDianji01;
    @BindView(R.id.mimg_dianji02)
    ImageView mimgDianji02;
    @BindView(R.id.mimg_dianji03)
    ImageView mimgDianji03;
    @BindView(R.id.mimg_dianji04)
    ImageView mimgDianji04;

    public FourFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mimg1, R.id.keyi, R.id.jiaot, R.id.dati, R.id.mimg2,
            R.id.mimg_dianji1, R.id.mimg_dianji2, R.id.mimg_dianji3, R.id.mimg_dianji4,
            R.id.mimg_dianji01, R.id.mimg_dianji02, R.id.mimg_dianji03, R.id.mimg_dianji04,R.id.mimg3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mimg1:
                break;
            case R.id.keyi:
                break;
            case R.id.jiaot:
                break;
            case R.id.dati:
                break;
            case R.id.mimg2:
                break;
            case R.id.mimg3:
                break;
            case R.id.mimg_dianji1:
                break;
            case R.id.mimg_dianji2:
                break;
            case R.id.mimg_dianji3:
                break;
            case R.id.mimg_dianji4:
                break;
            case R.id.mimg_dianji01:
                break;
            case R.id.mimg_dianji02:
                break;
            case R.id.mimg_dianji03:
                break;
            case R.id.mimg_dianji04:
                break;
        }
    }
}
