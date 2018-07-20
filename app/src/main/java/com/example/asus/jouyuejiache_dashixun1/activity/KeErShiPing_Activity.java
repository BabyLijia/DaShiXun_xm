package com.example.asus.jouyuejiache_dashixun1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class KeErShiPing_Activity extends AppCompatActivity {

    @BindView(R.id.mimg_back)
    ImageView mimgBack;
    @BindView(R.id.mtitle)
    TextView mtitle;
    @BindView(R.id.mvideoplayer)
    JZVideoPlayerStandard mvideoplayer;
    @BindView(R.id.mtitle2)
    TextView mtitle2;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.mtime)
    TextView mtime;
    @BindView(R.id.mxiazai_stop)
    TextView mxiazaiStop;
    @BindView(R.id.mWebview)
    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke_er_shi_ping_);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String voideurl = intent.getStringExtra("voideurl");
        String title = intent.getStringExtra("title");

        mtitle.setText(title);
        mtitle2.setText(title);
        mvideoplayer.setUp(voideurl
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, title);

    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @OnClick({R.id.mtime, R.id.mxiazai_stop,R.id.mimg_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mimg_back:
                finish();
                break;
            case R.id.mtime:
                break;
            case R.id.mxiazai_stop:
                break;
        }
    }
}
