package com.example.asus.jouyuejiache_dashixun1.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.fragment.CommunityFragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.ExpertFragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.First_shouyeFragment;
import com.example.asus.jouyuejiache_dashixun1.fragment.MyFragment;
import com.example.asus.jouyuejiache_dashixun1.mudel.home.homeview.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class First_shouyeActivity extends AppCompatActivity {

    @BindView(R.id.bottom_tab_bar)
    com.hjm.bottomtabbar.BottomTabBar bottomTabBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_shouye);
        ButterKnife.bind(this);
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(70, 70)
                .setFontSize(20)
                .setChangeColor(Color.BLUE, Color.GRAY)
                .addTabItem("首页", R.drawable.home_select, R.drawable.home_default, HomeFragment.class)
                .addTabItem("驾考专家", R.drawable.test_select , R.drawable.test_default, ExpertFragment.class)
                .addTabItem("社区", R.drawable.shequ_select, R.drawable.shequ_default, CommunityFragment.class)
                .addTabItem("我的", R.drawable.mine_select, R.drawable.my_default, MyFragment.class)
                .isShowDivider(false);
    }
}
