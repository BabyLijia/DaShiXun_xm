package com.example.asus.jouyuejiache_dashixun1.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.fragment.ExpertFragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.fragment_jiakao.TwoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrivingActivity extends AppCompatActivity {

    @BindView(R.id.mToolbar)
    Toolbar mToolbar;
    @BindView(R.id.mimg_lsj)
    ImageView mimgLsj;
    @BindView(R.id.mimg_no)
    ImageView mimgNo;
    @BindView(R.id.mimg_yes)
    ImageView mimgYes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving);
        ButterKnife.bind(this);
        mToolbar.setNavigationIcon(R.drawable.arrow_left_appcolor);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.mimg_lsj, R.id.mimg_no, R.id.mimg_yes})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mimg_lsj:
                break;
            case R.id.mimg_no:
                Intent intent = new Intent(DrivingActivity.this, StudytimeActivity.class);
                startActivity(intent);
                break;
            case R.id.mimg_yes:
                Intent intent1 = new Intent(DrivingActivity.this, BangDingCarActivity.class);
                intent1.putExtra("user",1);
                startActivity(intent1);
                break;
        }
    }
}
