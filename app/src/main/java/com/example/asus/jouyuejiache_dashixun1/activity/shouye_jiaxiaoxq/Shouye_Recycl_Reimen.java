package com.example.asus.jouyuejiache_dashixun1.activity.shouye_jiaxiaoxq;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.carxq_reimen.ResultListBean;

import java.util.List;

public class Shouye_Recycl_Reimen extends RecyclerView.Adapter<Shouye_Recycl_Reimen.ViewHolder> {
    private Context context;
    private List<ResultListBean> mRmBanZhList;
    private static Shouye_Recycl_Reimen shouye_recycl_reimen;


    public Shouye_Recycl_Reimen(Context context, List<ResultListBean> mRmBanZhList) {
        this.context = context;
        this.mRmBanZhList = mRmBanZhList;
    }

    public static Shouye_Recycl_Reimen getShouye_recycl_reimen(Context context, List<ResultListBean> mRmBanZhList) {
        shouye_recycl_reimen = new Shouye_Recycl_Reimen(context, mRmBanZhList);
        return shouye_recycl_reimen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recycl_reimen, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(mRmBanZhList.get(position).getIcon()).into(holder.mimg_beifangScool);
        holder.tv_manny.setText(mRmBanZhList.get(position).getIndex_price());
        holder.tv_renshu.setText(mRmBanZhList.get(position).getBase_amount()+"");
        holder.mtv_yuyue.setText(mRmBanZhList.get(position).getName());
       /* holder.mtv_bf1.setText(mRmBanZhList.get(0).getFeature());
        holder.mtv_bf2.setText(mRmBanZhList.get(1).getFeature());
        holder.mtv_bf3.setText(mRmBanZhList.get(2).getFeature());*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.getData(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView mimg_beifangScool;
        public TextView tv_manny;
        public TextView tv_renshu;
        public TextView mtv_yuyue;
        public TextView mtv_bf1;
        public TextView mtv_bf2;
        public TextView mtv_bf3;
        public LinearLayout ll5;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mimg_beifangScool = (ImageView) rootView.findViewById(R.id.mimg_beifangScool);
            this.tv_manny = (TextView) rootView.findViewById(R.id.tv_manny);
            this.tv_renshu = (TextView) rootView.findViewById(R.id.tv_renshu);
            this.mtv_yuyue = (TextView) rootView.findViewById(R.id.mtv_yuyue);
            this.mtv_bf1 = (TextView) rootView.findViewById(R.id.mtv_bf1);
            this.mtv_bf2 = (TextView) rootView.findViewById(R.id.mtv_bf2);
            this.mtv_bf3 = (TextView) rootView.findViewById(R.id.mtv_bf3);
            this.ll5 = (LinearLayout) rootView.findViewById(R.id.ll5);
        }
    }
    MyReimCallback callback;

    public interface MyReimCallback {
        void getData(int id);
    }

    public void setCallback(MyReimCallback callback) {
        this.callback = callback;
    }
}
