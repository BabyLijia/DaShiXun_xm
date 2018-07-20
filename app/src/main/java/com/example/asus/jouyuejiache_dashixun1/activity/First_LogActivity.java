package com.example.asus.jouyuejiache_dashixun1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.adapter.MyPagerAdapter;
import com.example.asus.jouyuejiache_dashixun1.fragment.shouye_log_fragment.Jouyue_logFragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.shouye_log_fragment.Shouji_logFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class First_LogActivity extends AppCompatActivity {

    @BindView(R.id.mlog_Toolbar)
    Toolbar mlogToolbar;
    @BindView(R.id.mshouye_regste)
    TextView mshouyeRegste;
    @BindView(R.id.mlog_Tablayout)
    TabLayout mlogTablayout;
    @BindView(R.id.mviewPager)
    ViewPager mviewPager;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> mstrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__log);
        ButterKnife.bind(this);
        mlogTablayout.setupWithViewPager(mviewPager);
        mlogToolbar.setNavigationIcon(R.drawable.back);
        mlogToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();
    }

    private void initData() {
        fragments = new ArrayList<>();
        fragments.add(new Jouyue_logFragment());
        fragments.add(new Shouji_logFragment());

        mstrings = new ArrayList<>();
        mstrings.add("九月账号登录");
        mstrings.add("手机快捷登录");


        // 创建ViewPager适配器
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments, mstrings, this);
        mviewPager.setAdapter(myPagerAdapter);
    }

    @OnClick(R.id.mshouye_regste)
    public void onClick() {
        Intent intent = new Intent(First_LogActivity.this, Fist_RejsterActivity.class);
        startActivity(intent);
    }
}
