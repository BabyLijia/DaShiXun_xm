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
import com.example.asus.jouyuejiache_dashixun1.bean.KeErDiBu;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 * (～￣▽￣)～ 嘛哩嘛哩哄
 */

public class KeErGv extends RecyclerView.Adapter<KeErGv.ViewHolder> {
    private List<KeErDiBu> lists;
    private Context context;

    public KeErGv(List<KeErDiBu> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.keergvadapter, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.gv_img.setImageResource(lists.get(position).getImg());
        holder.gv_tv.setText(lists.get(position).getName());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView gv_img;
        public TextView gv_tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.gv_img = (ImageView) rootView.findViewById(R.id.gv_img);
            this.gv_tv = (TextView) rootView.findViewById(R.id.gv_tv);
        }

    }
}
