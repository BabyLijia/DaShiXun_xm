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
import com.example.asus.jouyuejiache_dashixun1.bean.pingtai.Platform_yous;

import java.util.List;

public class Shouye_Recycl_Youshi extends RecyclerView.Adapter<Shouye_Recycl_Youshi.ViewHolder> {
    private List<Platform_yous> mPlatformList;
    private Context context;

    public Shouye_Recycl_Youshi(List<Platform_yous> mPlatformList, Context context) {
        this.mPlatformList = mPlatformList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recycl_youshi, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mmassege.setText(mPlatformList.get(position).getMassege());
        holder.mtitle.setText(mPlatformList.get(position).getTitle());
        holder.mimg_youshi.setImageResource(mPlatformList.get(position).getImg());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.getData();
            }
        });
    }

    @Override
    public int getItemCount() {
        return null==mPlatformList?0:mPlatformList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView mtitle;
        public TextView mmassege;
        private ImageView mimg_youshi;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mtitle = (TextView) rootView.findViewById(R.id.mtitle);
            this.mmassege = (TextView) rootView.findViewById(R.id.mmassege);
            this.mimg_youshi=(ImageView)rootView.findViewById(R.id.mimg_youshi);
        }

    }
    MyCallback callback;

    public interface MyCallback {
        void getData();
    }

    public void setCallback(MyCallback callback) {
        this.callback = callback;
    }
}
