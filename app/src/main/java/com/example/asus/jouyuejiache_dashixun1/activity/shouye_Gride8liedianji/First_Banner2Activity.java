package com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.asus.jouyuejiache_dashixun1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class First_Banner2Activity extends AppCompatActivity {


    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_fenxiang)
    ImageView imgFenxiang;
    @BindView(R.id.WebView)
    android.webkit.WebView WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__baoming_);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        WebSettings settings = WebView.getSettings();
        settings.setJavaScriptEnabled(true);
        WebView.getSettings().setUseWideViewPort(true);
        WebView.getSettings().setLoadWithOverviewMode(true);
        WebView.loadUrl("https://api.dyhoa.com/dapi/v4/redirect?id=1264");
        WebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
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
