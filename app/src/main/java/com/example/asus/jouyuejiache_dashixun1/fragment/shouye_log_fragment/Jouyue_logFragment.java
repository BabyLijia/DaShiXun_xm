package com.example.asus.jouyuejiache_dashixun1.fragment.shouye_log_fragment;


import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Jouyue_logFragment extends Fragment implements UMAuthListener {

    @BindView(R.id.med_phone)
    EditText medPhone;
    @BindView(R.id.med_psw)
    EditText medPsw;
    @BindView(R.id.mPassWord)
    TextView mPassWord;
    @BindView(R.id.mlog_jouyue)
    Button mlogJouyue;
    @BindView(R.id.mimg_qq)
    ImageView mimgQq;
    @BindView(R.id.mimg_weixin)
    ImageView mimgWeixin;
    Unbinder unbinder;
    private SharedPreferences denglu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jouyue_log, container, false);
        unbinder = ButterKnife.bind(this, view);
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(getActivity(), mPermissionList, 123);
        }
        denglu = getActivity().getSharedPreferences("denglu", 0);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    String ss = "[1][3,5,8,7][0-9]{9}";
    String psw = "[0-9a-zA-Z]{6,16}";

    @OnClick({R.id.med_phone, R.id.med_psw, R.id.mPassWord, R.id.mlog_jouyue, R.id.mimg_qq, R.id.mimg_weixin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mPassWord:
                break;
            case R.id.mlog_jouyue:
                if (medPhone.getText().toString().matches(ss) && medPsw.getText().toString().matches(psw)) {
                    //sp文件获取出来的数据设置为true，并且提交数据，且杀死当前页面
                    denglu.edit().putBoolean("zhuangtai", true).commit();
                    Toast.makeText(getContext(), "登录成功", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                } else {
                    Toast.makeText(getContext(), "登录失败", Toast.LENGTH_SHORT).show();
                }
                break;
            //todo 第三方登录，与分享
            case R.id.mimg_qq:
                UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), SHARE_MEDIA.QQ, this);
                break;
            case R.id.mimg_weixin:
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(getActivity()).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

    }

    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {

    }
}
