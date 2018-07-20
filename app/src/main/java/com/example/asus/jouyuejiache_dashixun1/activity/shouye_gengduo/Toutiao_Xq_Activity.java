package com.example.asus.jouyuejiache_dashixun1.activity.shouye_gengduo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.asus.jouyuejiache_dashixun1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Toutiao_Xq_Activity extends AppCompatActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_fenxiang)
    ImageView imgFenxiang;
    @BindView(R.id.WebView)
    android.webkit.WebView WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toutiao_);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        WebSettings settings = WebView.getSettings();
        settings.setJavaScriptEnabled(true);
        WebView.getSettings().setUseWideViewPort(true);
        WebView.getSettings().setLoadWithOverviewMode(true);
        WebView.loadUrl(url);
        WebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @OnClick({R.id.img_back, R.id.img_fenxiang})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_fenxiang:
                break;
        }
    }
}
