package com.example.asus.jouyuejiache_dashixun1.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.First_LogActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_Baoming_Activity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_YDSupperActivity;
import com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji.First_YueKaoActivity;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Administrator on 2018/7/4.
 * (～￣▽￣)～ 嘛哩嘛哩哄
 */

public class ShouYeAdapterGl extends RecyclerView.Adapter<ShouYeAdapterGl.ViewHolder1> {
    private ShouYeAdapterGl shouYeAdapterGl;
    private JSONArray jsonArray;
    private Context context;

    private ShouYeAdapterGl(JSONArray jsonArray, Context context) {
        this.jsonArray = jsonArray;
        this.context = context;
    }

    public static ShouYeAdapterGl getShouYeAdapterGl(JSONArray jsonArray, Context context) {
        return new ShouYeAdapterGl(jsonArray, context);
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.shouyeadaptergl, null);
        return new ViewHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 holder, int position) {

        try {
            final String name = jsonArray.getJSONObject(position).getString("name");
            Glide.with(context).load(jsonArray.getJSONObject(position).getString("icon")).into(holder.gl_img);
            holder.gl_text.setText(jsonArray.getJSONObject(position).getString("name"));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("TAG_yuedou",name);
                    switch (name) {
                        case "悦豆商城":
                            Intent intent = new Intent(context, First_YDSupperActivity.class);
                            context.startActivity(intent);
                            break;
                        case "报名须知":
                            Intent intent1 = new Intent(context, First_Baoming_Activity.class);
                            context.startActivity(intent1);
                            break;
                        case "学车流程":
                            Intent intent2 = new Intent(context, First_Baoming_Activity.class);
                            context.startActivity(intent2);
                            break;
                        case "预约培训":
                            Intent intent3 = new Intent(context, First_LogActivity.class);
                            context.startActivity(intent3);
                            break;
                        case "自主约考":
                            Intent intent4 = new Intent(context, First_YueKaoActivity.class);
                            context.startActivity(intent4);
                            break;
                        case "学车总监":
                            Intent intent5 = new Intent(context, First_LogActivity.class);
                            context.startActivity(intent5);
                            break;
                        case "金融超市":
                            Intent intent6 = new Intent(context, First_LogActivity.class);
                            context.startActivity(intent6);
                            break;
                        case "学车进度":
                            Intent intent7 = new Intent(context, First_LogActivity.class);
                            context.startActivity(intent7);
                            break;

                    }
                }
            });


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView gl_img;
        public TextView gl_text;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.gl_img = (ImageView) rootView.findViewById(R.id.gl_img);
            this.gl_text = (TextView) rootView.findViewById(R.id.gl_text);
        }

    }
}
