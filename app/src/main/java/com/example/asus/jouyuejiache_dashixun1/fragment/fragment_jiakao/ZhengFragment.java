package com.example.asus.jouyuejiache_dashixun1.fragment.fragment_jiakao;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhengFragment extends Fragment {


    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.mbt_time)
    Button mbtTime;
    @BindView(R.id.mbt_jiazhao)
    Button mbtJiazhao;
    @BindView(R.id.mbt_yishi)
    Button mbtYishi;
    @BindView(R.id.mbt_huanz)
    Button mbtHuanz;
    @BindView(R.id.mbt_zyshixiang)
    Button mbtZyshixiang;
    @BindView(R.id.mbt_xshiz)
    Button mbtXshiz;
    @BindView(R.id.mbt_stop)
    Button mbtStop;
    @BindView(R.id.mbt_jiqiao)
    Button mbtJiqiao;
    Unbinder unbinder;

    public ZhengFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zheng, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mbt_time, R.id.mbt_jiazhao, R.id.mbt_yishi, R.id.mbt_huanz, R.id.mbt_zyshixiang, R.id.mbt_xshiz, R.id.mbt_stop, R.id.mbt_jiqiao})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mbt_time:
                break;
            case R.id.mbt_jiazhao:
                break;
            case R.id.mbt_yishi:
                break;
            case R.id.mbt_huanz:
                break;
            case R.id.mbt_zyshixiang:
                break;
            case R.id.mbt_xshiz:
                break;
            case R.id.mbt_stop:
                break;
            case R.id.mbt_jiqiao:
                break;
        }
    }
}
