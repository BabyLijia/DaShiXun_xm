package com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.First_LogActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class First_YueKaoActivity extends AppCompatActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.l3)
    LinearLayout l3;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.mbt_yuyue)
    Button mbtYuyue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__yue_kao);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_back, R.id.mbt_yuyue})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.mbt_yuyue:
                Intent intent = new Intent(First_YueKaoActivity.this, First_LogActivity.class);
                startActivity(intent);
                break;
        }
    }
}
