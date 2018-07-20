package com.example.asus.jouyuejiache_dashixun1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.asus.jouyuejiache_dashixun1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mimg)
    ImageView mimg;
    @BindView(R.id.mtiaoguo)
    Button mtiaoguo;
    private CountDownTimer start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        start = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mtiaoguo.setText("跳转"+millisUntilFinished / 1000 + "(s)");
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, Pleasing_imageActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }

    @OnClick(R.id.mtiaoguo)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mtiaoguo:
                Intent intent = new Intent(MainActivity.this,Pleasing_imageActivity.class);
                startActivity(intent);
                finish();
                start.cancel();
                break;
        }
    }
}
