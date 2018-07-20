package com.example.asus.jouyuejiache_dashixun1.activity.expert2_jiakaozj.ke_san;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.expert2_jiakaozj.ke_er.KeEr_YuYinActivity;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KeSan_YuYinActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    @BindView(R.id.mFanHui_3)
    ImageView mFanHui3;
    @BindView(R.id.mBUT_1)
    RadioButton mBUT1;
    @BindView(R.id.mBUT_2)
    RadioButton mBUT2;
    @BindView(R.id.mBUT_3)
    RadioButton mBUT3;
    @BindView(R.id.mBUT_4)
    RadioButton mBUT4;
    @BindView(R.id.mBUT_5)
    RadioButton mBUT5;
    @BindView(R.id.mBUT_6)
    RadioButton mBUT6;
    @BindView(R.id.mBUT_7)
    RadioButton mBUT7;
    @BindView(R.id.mBUT_8)
    RadioButton mBUT8;
    @BindView(R.id.mBUT_9)
    RadioButton mBUT9;
    @BindView(R.id.mBUT_10)
    RadioButton mBUT10;
    @BindView(R.id.mBUT_11)
    RadioButton mBUT11;
    @BindView(R.id.mBUT_12)
    RadioButton mBUT12;
    @BindView(R.id.mBUT_13)
    RadioButton mBUT13;
    @BindView(R.id.mBUT_14)
    RadioButton mBUT14;
    @BindView(R.id.mBUT_15)
    RadioButton mBUT15;
    @BindView(R.id.mBUT_16)
    RadioButton mBUT16;
    @BindView(R.id.mBUT_17)
    RadioButton mBUT17;
    @BindView(R.id.mBUT_18)
    RadioButton mBUT18;
    @BindView(R.id.mBUT_19)
    RadioButton mBUT19;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuyin_ke3);
        ButterKnife.bind(this);
        textToSpeech = new TextToSpeech(KeSan_YuYinActivity.this, this);

    }

    @OnClick({R.id.mFanHui_3, R.id.mBUT_1, R.id.mBUT_2, R.id.mBUT_3, R.id.mBUT_4, R.id.mBUT_5, R.id.mBUT_6, R.id.mBUT_7, R.id.mBUT_8, R.id.mBUT_9, R.id.mBUT_10, R.id.mBUT_11, R.id.mBUT_12, R.id.mBUT_13, R.id.mBUT_14, R.id.mBUT_15, R.id.mBUT_16, R.id.mBUT_17, R.id.mBUT_18, R.id.mBUT_19})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mFanHui_3:
                finish();
                break;
            case R.id.mBUT_1:
                initVoice("绕车一周 检查车俩外观 及安全状况 ，  打开车门前  观察后方交通情况 上车后  请 系好安全带调整座位侧镜，后视镜，打开镜光灯 并关闭警视灯");
                break;
            case R.id.mBUT_2:
                initVoice("请 起步继续完成考试");
                break;
            case R.id.mBUT_3:
                initVoice("前方路口直行");
                break;
            case R.id.mBUT_4:
                initVoice("前方请变更车道");
                break;
            case R.id.mBUT_5:
                initVoice("通过公共汽车站");
                break;
            case R.id.mBUT_6:
                initVoice("通过学校区域");
                break;
            case R.id.mBUT_7:
                initVoice("前方进入直线行驶路段  请保持时速  在35公里左右");
                break;
            case R.id.mBUT_8:
                initVoice("前方路口左转");
                break;
            case R.id.mBUT_9:
                initVoice("前方路口右转");
                break;
            case R.id.mBUT_10:
                initVoice("请 进行加减挡位操作");
                break;
            case R.id.mBUT_11:
                initVoice("与机动车会车");
                break;
            case R.id.mBUT_12:
                initVoice("请 超越前方车辆");
                break;
            case R.id.mBUT_13:
                initVoice("请 减速慢行");
                break;
            case R.id.mBUT_14:
                initVoice("前方路段最低限速40公里每小时");
                break;
            case R.id.mBUT_15:
                initVoice("前方人行横道");
                break;
            case R.id.mBUT_16:
                initVoice("前方人行横道_有行人通过");
                break;
            case R.id.mBUT_17:
                initVoice("前方隧道");
                break;
            case R.id.mBUT_18:
                initVoice("前方请选择合适地点掉头");
                break;
            case R.id.mBUT_19:
                initVoice("请 靠边停车");
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
