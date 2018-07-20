package com.example.asus.jouyuejiache_dashixun1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BangDingCarActivity extends AppCompatActivity {

    @BindView(R.id.mjiashi)
    TextView mjiashi;
    @BindView(R.id.m_scar)
    ImageView mScar;
    @BindView(R.id.m_mcar)
    ImageView mMcar;
    @BindView(R.id.m_lcar)
    ImageView mLcar;
    @BindView(R.id.m_xlcar)
    ImageView mXlcar;
    @BindView(R.id.mtv_huan)
    TextView mtvHuan;
    @BindView(R.id.m_tvkaiqi)
    TextView mTvkaiqi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_ding_car);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mjiashi, R.id.m_scar, R.id.m_mcar, R.id.m_lcar, R.id.m_xlcar, R.id.mtv_huan, R.id.m_tvkaiqi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mjiashi:
                break;
            case R.id.m_scar:
                break;
            case R.id.m_mcar:
                break;
            case R.id.m_lcar:
                break;
            case R.id.m_xlcar:
                break;
            case R.id.mtv_huan:
                break;
            case R.id.m_tvkaiqi:
                Intent intent = new Intent(BangDingCarActivity.this, First_shouyeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
