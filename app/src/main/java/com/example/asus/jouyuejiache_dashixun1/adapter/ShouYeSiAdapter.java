package com.example.asus.jouyuejiache_dashixun1.adapter;

import android.content.Context;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2018/7/5.
 * (～￣▽￣)～ 嘛哩嘛哩哄
 */

public class ShouYeSiAdapter extends RecyclerView.Adapter<ShouYeSiAdapter.ViewHolder1> {
    private JSONArray jsonArray;
    private Context context;
    private ShouYeAdapter shouYeAdapter;
    DianJi dianJi;

    public void setDianJi(DianJi dianJi) {
        this.dianJi = dianJi;
    }

    private ShouYeSiAdapter(JSONArray jsonArray, Context context) {
        this.jsonArray = jsonArray;
        this.context = context;
    }

    public static ShouYeSiAdapter getshouyesi(JSONArray jsonArray, Context context) {
        return new ShouYeSiAdapter(jsonArray, context);
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.shouyisi, null);
        return new ViewHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 holder, final int position) {
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            holder.jiaoxiaoName.setText(jsonObject.getString("name"));
            Glide.with(context).load(jsonObject.getString("icon2")).into(holder.si_img);
            holder.diqv.setText(jsonObject.getString("area_name"));
            holder.jiage.setText("￥"+jsonObject.getDouble("price"));
            holder.baoming.setText(jsonObject.getInt("enrollNum")+"人已报名");
            holder.jvli.setText(jsonObject.getString("distance"));
            JSONArray feature = jsonObject.getJSONArray("feature");
            Log.e("TAG",feature.length()+"");
            if(feature.length()==3){
                holder.biaoqian1.setText(feature.getString(0));
                holder.biaoqian2.setText(feature.getString(1));
                holder.biaoqian3.setText(feature.getString(2));
                holder.biaoqian2.setBackgroundResource(R.drawable.siyuanjiao);
                holder.biaoqian3.setBackgroundResource(R.drawable.siyuanjiao);
            }else if(feature.length()==2){
                holder.biaoqian1.setText(feature.getString(0));
                holder.biaoqian2.setText(feature.getString(1));
                holder.biaoqian3.setBackgroundResource(R.drawable.sibeijing);
                holder.biaoqian2.setBackgroundResource(R.drawable.siyuanjiao);
            }else if(feature.length()==1){
                holder.biaoqian1.setText(feature.getString(0));
                holder.biaoqian2.setBackgroundResource(R.drawable.sibeijing);
                holder.biaoqian3.setBackgroundResource(R.drawable.sibeijing);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dianJi.dianji(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView si_img;
        public TextView jiaoxiaoName;
        public TextView diqv;
        public TextView jiage;
        public TextView baoming;
        public TextView jvli;
        public TextView biaoqian1;
        public TextView biaoqian2;
        public TextView biaoqian3;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.si_img = (ImageView) rootView.findViewById(R.id.si_img);
            this.jiaoxiaoName = (TextView) rootView.findViewById(R.id.jiaoxiaoName);
            this.diqv = (TextView) rootView.findViewById(R.id.diqv);
            this.jiage = (TextView) rootView.findViewById(R.id.jiage);
            this.baoming = (TextView) rootView.findViewById(R.id.baoming);
            this.jvli = (TextView) rootView.findViewById(R.id.jvli);
            this.biaoqian1 = (TextView) rootView.findViewById(R.id.biaoqian1);
            this.biaoqian2 = (TextView) rootView.findViewById(R.id.biaoqian2);
            this.biaoqian3 = (TextView) rootView.findViewById(R.id.biaoqian3);
        }

    }
    public interface DianJi{
        void dianji(int id);
    }
}
