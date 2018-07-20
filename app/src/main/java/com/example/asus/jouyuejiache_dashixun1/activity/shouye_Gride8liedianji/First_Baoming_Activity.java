package com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.asus.jouyuejiache_dashixun1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class First_Baoming_Activity extends AppCompatActivity {

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
        WebView.loadUrl("https://api.dyhoa.com/dweixin/h5/22/index.html?t=1530638182197");
        WebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl("https://api.dyhoa.com/dweixin/h5/22/index.html?t=1530638182197");
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
