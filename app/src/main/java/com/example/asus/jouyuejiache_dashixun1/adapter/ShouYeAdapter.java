package com.example.asus.jouyuejiache_dashixun1.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.Jyue_pingtuanActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_Banner1_Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_Banner2Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_Banner3Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_CarSupperActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_YDSupperActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_gengduo.Gengduo_Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_gengduo.Toutiao_WebActivity;
import com.example.asus.jouyuejiache_dashixun1.fragment.ditu.DiTuFragment;
import com.example.asus.jouyuejiache_dashixun1.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/4.
 * (～￣▽￣)～ 嘛哩嘛哩哄
 */

public class ShouYeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int LB = 0;
    private int GL = 1;
    private int GD = 2;
    private int JS = 3;
    private int DB = 4;
    private JSONObject jsonObject;
    private Context context;
    XianShiAmi xianShiAmi;
    FragmentManager supportFragmentManager;
    private String gourl;


    public void setXianShiAmi(XianShiAmi xianShiAmi) {
        this.xianShiAmi = xianShiAmi;
    }

    public ShouYeAdapter(FragmentManager supportFragmentManager1, JSONObject jsonObject, Context context) {
        this.jsonObject = jsonObject;
        this.context = context;
        this.supportFragmentManager = supportFragmentManager1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(context);
        switch (viewType) {
            case 0:
                View inflate = from.inflate(R.layout.shouye_adapter_lubo, null);
                return new ViewHolder1(inflate);
            case 1:
                View inflate1 = from.inflate(R.layout.shouye_adapter_gl, null);
                return new ViewHolder2(inflate1);
            case 2:
                View inflate2 = from.inflate(R.layout.shouyeadapter3, null);
                return new ViewHolder3(inflate2);
            case 3:
                View inflate3 = from.inflate(R.layout.shouye_adapter_si, null);
                return new ViewHolder4(inflate3);
            case 4:
                View inflate4 = from.inflate(R.layout.shouyewu, null);
                return new ViewHolder5(inflate4);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ArrayList<String> images = new ArrayList<>();
            if (jsonObject != null) {
                try {
                    JSONArray topList = jsonObject.getJSONArray("topList");
                    for (int i = 0; i < topList.length(); i++) {
                        JSONObject jsonObject = topList.getJSONObject(i);
                        images.add(jsonObject.getString("icon"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            //设置图片加载器
            ((ViewHolder1) holder).banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            ((ViewHolder1) holder).banner.setImages(images);
            //banner设置方法全部调用完毕时最后调用
            ((ViewHolder1) holder).banner.start();
            ((ViewHolder1) holder).banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    switch (position) {
                        case 0:
                            Intent intent = new Intent(context, First_Banner1_Activity.class);
                            context.startActivity(intent);
                            break;
                        case 1:
                            Intent intent1 = new Intent(context, First_Banner2Activity.class);
                            context.startActivity(intent1);
                            break;
                        case 2:
                            Intent intent2 = new Intent(context, First_Banner3Activity.class);
                            context.startActivity(intent2);
                            break;
                    }
                }
            });

        }
        if (holder instanceof ViewHolder2) {
            ((ViewHolder2) holder).rlv.setLayoutManager(new GridLayoutManager(context, 4));
            if (jsonObject != null) {
                try {
                    JSONArray function = jsonObject.getJSONArray("function");
                    ShouYeAdapterGl shouYeAdapterGl = ShouYeAdapterGl.getShouYeAdapterGl(function, context);
                    ((ViewHolder2) holder).rlv.setAdapter(shouYeAdapterGl);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }
        if (holder instanceof ViewHolder3) {
            final ArrayList<String> strings = new ArrayList<>();
            try {
                JSONArray topList = jsonObject.getJSONArray("topLineList");
                for (int i = 0; i < topList.length(); i++) {
                    String title = topList.getJSONObject(i).getString("title");
                    gourl = topList.getJSONObject(i).getString("gourl");
                    strings.add(title);
                    strings.add(gourl);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < strings.size(); i++) {
                TextView textView = new TextView(context);
                textView.setText(strings.get(i));
                ((ViewHolder3) holder).filpper.addView(textView);
            }
            ((ViewHolder3) holder).filpper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Toutiao_WebActivity.class);
                    intent.putExtra("url",gourl);
                    context.startActivity(intent);
                }
            });
            try {
                Glide.with(context).load(jsonObject.getJSONArray("indexImg").getJSONObject(position).getString("index_3")).into(((ViewHolder3) holder).jiuyuezhuanqv);
                Glide.with(context).load(jsonObject.getJSONArray("benefitList").getJSONObject(0).getString("icon")).into(((ViewHolder3) holder).kuailexueche);
                Glide.with(context).load(jsonObject.getJSONArray("indexImg").getJSONObject(position).getString("index_3")).into(((ViewHolder3) holder).jiaxiaozhuanqv);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            final DiTuFragment diTuFragment = new DiTuFragment();
            ((ViewHolder3) holder).ditu.setVisibility(View.GONE);
            supportFragmentManager.beginTransaction().add(R.id.ditu, diTuFragment).show(diTuFragment).commit();
            ((ViewHolder3) holder).dingwei.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    supportFragmentManager.beginTransaction().show(diTuFragment).commit();
                    ((ViewHolder3) holder).dingwei.setVisibility(View.GONE);
                    ((ViewHolder3) holder).yinchang.setVisibility(View.VISIBLE);
                    ((ViewHolder3) holder).ditu.setVisibility(View.VISIBLE);
                }
            });
            ((ViewHolder3) holder).yinchang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    supportFragmentManager.beginTransaction().hide(diTuFragment).commit();
                    ((ViewHolder3) holder).dingwei.setVisibility(View.VISIBLE);
                    ((ViewHolder3) holder).yinchang.setVisibility(View.GONE);
                    ((ViewHolder3) holder).ditu.setVisibility(View.GONE);
                }
            });
            ((ViewHolder3) holder).kuailexueche.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(context, Jyue_pingtuanActivity.class);
                    context.startActivity(intent1);
                }
            });
            ((ViewHolder3) holder).shouye3_gengduo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, Gengduo_Activity.class);
                    context.startActivity(intent);
                }
            });
            ((ViewHolder3) holder).shouyesan_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, First_CarSupperActivity.class);
                    context.startActivity(intent);
                }
            });


        }
        if (holder instanceof ViewHolder4) {
            try {
                JSONArray schoolList = jsonObject.getJSONArray("schoolList");
                ShouYeSiAdapter getshouyesi = ShouYeSiAdapter.getshouyesi(schoolList, context);
                ((ViewHolder4) holder).si_rlv.setLayoutManager(new LinearLayoutManager(context));
                ((ViewHolder4) holder).si_rlv.setAdapter(getshouyesi);
                getshouyesi.setDianJi(new ShouYeSiAdapter.DianJi() {
                    @Override
                    public void dianji(int id) {
                        xianShiAmi.xianShi(id);
                    }
                });

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return LB;
            case 1:
                return GL;
            case 2:
                return GD;
            case 3:
                return JS;
            case 4:
                return DB;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner banner;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.banner = (Banner) rootView.findViewById(R.id.banner);
        }

    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rlv;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rlv = (RecyclerView) rootView.findViewById(R.id.rlv);
        }

    }

    public static class ViewHolder3 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView shouye3_img2;
        public Button shouye3_gengduo;
        public ViewFlipper filpper;
        public LinearLayout ll;
        public ImageView shouyesan_img;
        public ImageView jiuyuezhuanqv;
        public ImageView kuailexueche;
        public ImageView jiaxiaozhuanqv;
        public ImageView dingwei;
        public ImageView yinchang;
        private LinearLayout ditu;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.shouye3_img2 = (ImageView) rootView.findViewById(R.id.shouye3_img2);
            this.shouye3_gengduo = (Button) rootView.findViewById(R.id.shouye3_gengduo);
            this.filpper = (ViewFlipper) rootView.findViewById(R.id.filpper);
            this.ll = (LinearLayout) rootView.findViewById(R.id.ll);
            this.shouyesan_img = (ImageView) rootView.findViewById(R.id.shouyesan_img);
            this.jiuyuezhuanqv = (ImageView) rootView.findViewById(R.id.jiuyuezhuanqv);
            this.kuailexueche = (ImageView) rootView.findViewById(R.id.kuailexueche);
            this.jiaxiaozhuanqv = (ImageView) rootView.findViewById(R.id.jiaxiaozhuanqv);
            this.dingwei = (ImageView) rootView.findViewById(R.id.dingwei);
            this.yinchang = (ImageView) rootView.findViewById(R.id.yinchang);
            this.ditu = (LinearLayout) rootView.findViewById(R.id.ditu);
        }

    }

    public static class ViewHolder4 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView si_rlv;

        public ViewHolder4(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.si_rlv = (RecyclerView) rootView.findViewById(R.id.si_rlv);
        }

    }


    public static class ViewHolder5 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView im;

        public ViewHolder5(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.im = (ImageView) rootView.findViewById(R.id.im);
        }

    }

    public interface XianShiAmi {
        void xianShi(int id);
    }
}
