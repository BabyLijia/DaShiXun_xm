package com.example.asus.jouyuejiache_dashixun1.activity.expert2_jiakaozj.ke_er;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StudyCar_Activity extends AppCompatActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.WebView)
    android.webkit.WebView WebView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_car_);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        initData();
    }

    private void initData() {
        WebSettings settings = WebView.getSettings();
        settings.setJavaScriptEnabled(true);
        WebView.getSettings().setUseWideViewPort(true);
        WebView.getSettings().setLoadWithOverviewMode(true);
        WebView.loadUrl(url);
        WebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
    @OnClick(R.id.img_back)
    public void onClick() {
        finish();
    }
}
