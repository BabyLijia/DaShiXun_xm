package com.example.asus.jouyuejiache_dashixun1.activity.expert2_jiakaozj.ke_er;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.jouyuejiache_dashixun1.R;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KeEr_YuYinActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_daoche)
    TextView tvDaoche;
    @BindView(R.id.tv_qibu)
    TextView tvQibu;
    @BindView(R.id.tv_stopcar)
    TextView tvStopcar;
    @BindView(R.id.tv_zhanwan)
    TextView tvZhanwan;
    @BindView(R.id.tv_quxian)
    TextView tvQuxian;
    @BindView(R.id.tv_danbian)
    TextView tvDanbian;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke_er__yu_yin);
        ButterKnife.bind(this);
        textToSpeech = new TextToSpeech(KeEr_YuYinActivity.this, this);
    }

    @OnClick({R.id.img_back, R.id.tv_daoche, R.id.tv_qibu, R.id.tv_stopcar, R.id.tv_zhanwan, R.id.tv_quxian, R.id.tv_danbian})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_daoche:
                initVoice("倒车入库");
                break;
            case R.id.tv_qibu:
                initVoice("上坡起步");
                break;
            case R.id.tv_stopcar:
                initVoice("侧方停车");
                break;
            case R.id.tv_zhanwan:
                initVoice("直角转弯");
                break;
            case R.id.tv_quxian:
                initVoice("曲线行驶");
                break;
            case R.id.tv_danbian:
                initVoice("单边板");
                break;
        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.CHINA);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "数据丢失或不支持", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        textToSpeech.stop(); // 不管是否正在朗读TTS都被打断
        textToSpeech.shutdown(); // 关闭，释放资源
    }

    private void initVoice(String str) {
        if (textToSpeech != null && !textToSpeech.isSpeaking()) {
            textToSpeech.setPitch(0.0f);// 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
            textToSpeech.speak(str,
                    TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}
