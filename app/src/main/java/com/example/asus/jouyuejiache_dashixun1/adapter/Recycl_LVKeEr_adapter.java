package com.example.asus.jouyuejiache_dashixun1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.ResultListBean;

import java.util.List;

public class Recycl_LVKeEr_adapter extends RecyclerView.Adapter<Recycl_LVKeEr_adapter.ViewHolder> {
    private List<ResultListBean> mkeerBeans;
    private Context context;

    int a = 3;

    public void setA(int a) {
        this.a = a;
    }

    public Recycl_LVKeEr_adapter(List<ResultListBean> keerBeans, Context context) {
        this.mkeerBeans = keerBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_keer_adapter, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(mkeerBeans.get(position).getImageUrl()).into(holder.mimg_shiping);
        holder.mtv_name.setText(mkeerBeans.get(position).getTitle());
        holder.mtv_ground.setText(mkeerBeans.get(position).getVideoDescp());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCallBack.getData(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return a;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView mimg_shiping;
        public TextView mtv_name;
        public TextView mtv_ground;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mimg_shiping = (ImageView) rootView.findViewById(R.id.mimg_shiping);
            this.mtv_name = (TextView) rootView.findViewById(R.id.mtv_name);
            this.mtv_ground = (TextView) rootView.findViewById(R.id.mtv_ground);
        }
    }
    MyCallBack myCallBack;

    public interface MyCallBack {
        void getData(int id);
    }

    public void setMyCallBack(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }
}
