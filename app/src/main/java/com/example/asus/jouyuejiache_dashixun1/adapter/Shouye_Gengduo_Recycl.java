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
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_toutiao_genduo.ResultListBean;

import java.util.List;

public class Shouye_Gengduo_Recycl extends RecyclerView.Adapter<Shouye_Gengduo_Recycl.ViewHolder> {
    private List<ResultListBean> resultList;
    private Context context;

    public void setMyCallBack_gd(MyCallBack_gd myCallBack_gd) {
        this.myCallBack_gd = myCallBack_gd;
    }

    public Shouye_Gengduo_Recycl(List<ResultListBean> resultList, Context context) {
        this.resultList = resultList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rectycl_gengduo, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(resultList.get(position).getIcon()).into(holder.mimg_beifangScool);
        holder.mtv_time.setText(resultList.get(position).getUpdate_time());
        holder.mtv_name.setText(resultList.get(position).getTitle());
        holder.dianzan.setText(resultList.get(position).getDianzan()+"");
        holder.yangjing.setText(resultList.get(position).getHits()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCallBack_gd.getData(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return null==resultList?0:resultList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView mimg_beifangScool;
        public TextView mtv_name;
        public TextView mtv_time;
        public TextView dianzan;
        public ImageView img_yangjing;
        public TextView yangjing;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mimg_beifangScool = (ImageView) rootView.findViewById(R.id.mimg_beifangScool);
            this.mtv_name = (TextView) rootView.findViewById(R.id.mtv_name);
            this.mtv_time = (TextView) rootView.findViewById(R.id.mtv_time);
            this.dianzan = (TextView) rootView.findViewById(R.id.dianzan);
            this.img_yangjing = (ImageView) rootView.findViewById(R.id.img_yangjing);
            this.yangjing = (TextView) rootView.findViewById(R.id.yangjing);
        }
    }
    MyCallBack_gd myCallBack_gd;

    public interface MyCallBack_gd {
        void getData(int id);
    }

}
