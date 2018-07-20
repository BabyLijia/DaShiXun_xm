package com.example.asus.jouyuejiache_dashixun1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Pleasing_imageActivity extends AppCompatActivity {

    @BindView(R.id.mimg_pleasing)
    ImageView mimgPleasing;
    @BindView(R.id.set_tv)
    TextView setTv;
    @BindView(R.id.mll)
    LinearLayout mll;
    @BindView(R.id.bt_mgfs)
    Button btMgfs;
    @BindView(R.id.bt_mbfm)
    Button btMbfm;
    @BindView(R.id.mll2)
    LinearLayout mll2;
    @BindView(R.id.bt_mn)
    Button btMn;
    @BindView(R.id.bt_msmk)
    Button btMsmk;
    @BindView(R.id.mll3)
    LinearLayout mll3;
    @BindView(R.id.bt_mbdg)
    Button btMbdg;
    @BindView(R.id.bt_manger)
    Button btManger;
    @BindView(R.id.mll4)
    LinearLayout mll4;
    @BindView(R.id.bt_mjz)
    Button btMjz;
    @BindView(R.id.bt_run)
    Button btRun;
    @BindView(R.id.mll5)
    LinearLayout mll5;
    @BindView(R.id.mnext)
    Button mnext;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pleasing_image);
        ButterKnife.bind(this);
        animation = AnimationUtils.loadAnimation(this, R.anim.suofang);

    }

    @OnClick({R.id.mnext, R.id.bt_mgfs, R.id.bt_mbfm, R.id.bt_mn, R.id.bt_msmk, R.id.bt_mbdg, R.id.bt_manger, R.id.bt_mjz, R.id.bt_run})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_mgfs:
                noXuanZhong();
                xuanZhong(btMgfs);
                mimgPleasing.setImageResource(R.drawable.guide_01);
                mimgPleasing.startAnimation(animation);
                break;
            case R.id.bt_mbfm:
                noXuanZhong();
                xuanZhong(btMbfm);
                mimgPleasing.setImageResource(R.drawable.guide_02);
                mimgPleasing.startAnimation(animation);
                break;
            case R.id.bt_mn:
                noXuanZhong();
                xuanZhong(btMn);
                mimgPleasing.setImageResource(R.drawable.guide_03);
                mimgPleasing.startAnimation(animation);
                break;
            case R.id.bt_msmk:
                noXuanZhong();
                xuanZhong(btMsmk);
                mimgPleasing.setImageResource(R.drawable.guide_04);
                mimgPleasing.startAnimation(animation);
                break;
            case R.id.bt_mbdg:
                noXuanZhong();
                xuanZhong(btMbdg);
                mimgPleasing.setImageResource(R.drawable.guide_05);
                mimgPleasing.startAnimation(animation);
                break;
            case R.id.bt_manger:
                noXuanZhong();
                xuanZhong(btManger);
                mimgPleasing.setImageResource(R.drawable.guide_06);
                mimgPleasing.startAnimation(animation);
                break;
            case R.id.bt_mjz:
                noXuanZhong();
                xuanZhong(btMjz);
                mimgPleasing.setImageResource(R.drawable.guide_07);
                mimgPleasing.startAnimation(animation);
                break;
            case R.id.bt_run:
                noXuanZhong();
                xuanZhong(btRun);
                mimgPleasing.setImageResource(R.drawable.guide_08);
                mimgPleasing.startAnimation(animation);
                break;
            case R.id.mnext:
                Intent intent = new Intent(Pleasing_imageActivity.this, DrivingActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void xuanZhong(Button btMgfs) {
        btMgfs.setTextColor(getResources().getColor(R.color.colorPrimary));
        btMgfs.setBackgroundResource(R.drawable.guide_selected);
        btMgfs.setClickable(false);
    }

    private void noXuanZhong() {
        btMgfs.setBackgroundResource(R.drawable.gerenxx);
        btMbfm.setBackgroundResource(R.drawable.gerenxx);
        btMn.setBackgroundResource(R.drawable.gerenxx);
        btMsmk.setBackgroundResource(R.drawable.gerenxx);
        btMbdg.setBackgroundResource(R.drawable.gerenxx);
        btManger.setBackgroundResource(R.drawable.gerenxx);
        btMjz.setBackgroundResource(R.drawable.gerenxx);
        btRun.setBackgroundResource(R.drawable.gerenxx);

        btMgfs.setTextColor(getResources().getColor(R.color.color_plea));
        btMbfm.setTextColor(getResources().getColor(R.color.color_plea));
        btMn.setTextColor(getResources().getColor(R.color.color_plea));
        btMsmk.setTextColor(getResources().getColor(R.color.color_plea));
        btMbdg.setTextColor(getResources().getColor(R.color.color_plea));
        btManger.setTextColor(getResources().getColor(R.color.color_plea));
        btMjz.setTextColor(getResources().getColor(R.color.color_plea));
        btRun.setTextColor(getResources().getColor(R.color.color_plea));

        btMgfs.setClickable(true);
        btMbfm.setClickable(true);
        btMn.setClickable(true);
        btMsmk.setClickable(true);
        btMbdg.setClickable(true);
        btManger.setClickable(true);
        btMjz.setClickable(true);
        btRun.setClickable(true);
    }
}
