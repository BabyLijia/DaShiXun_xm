package com.example.asus.jouyuejiache_dashixun1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.bean.jiaxiaoCar.ScoolCar;

import java.util.List;

public class Shouye_Recycl_ScoolCar extends RecyclerView.Adapter<Shouye_Recycl_ScoolCar.ViewHolder> {
    private List<ScoolCar> mScoolCarList;
    private Context context;

    public Shouye_Recycl_ScoolCar(List<ScoolCar> mScoolCarList, Context context) {
        this.mScoolCarList = mScoolCarList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recycl_scool, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mtv_name1.setText(mScoolCarList.get(position).getName());
        holder.mtv_ground1.setText(mScoolCarList.get(position).getGround());
        holder.mtv_registered1.setText(mScoolCarList.get(position).getRegistered());
        holder.mimg_beifangScool.setImageResource(mScoolCarList.get(position).getImg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.getData(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == mScoolCarList ? 0 : mScoolCarList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView mimg_beifangScool;
        public TextView mtv_name1;
        public TextView mtv_name2;
        public TextView mtv_name3;
        public TextView mtv_registered1;
        public TextView mtv_ground1;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mimg_beifangScool = (ImageView) rootView.findViewById(R.id.mimg_beifangScool);
            this.mtv_name1 = (TextView) rootView.findViewById(R.id.mtv_name1);
            this.mtv_name2 = (TextView) rootView.findViewById(R.id.mtv_name2);
            this.mtv_name3 = (TextView) rootView.findViewById(R.id.mtv_name3);
            this.mtv_registered1 = (TextView) rootView.findViewById(R.id.mtv_registered1);
            this.mtv_ground1 = (TextView) rootView.findViewById(R.id.mtv_ground1);
        }
    }

    MyCallback callback;

    public interface MyCallback {
        void getData(int id);
    }

    public void setCallback(MyCallback callback) {
        this.callback = callback;
    }
}
