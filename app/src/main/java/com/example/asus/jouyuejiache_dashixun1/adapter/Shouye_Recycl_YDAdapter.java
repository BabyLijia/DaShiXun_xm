package com.example.asus.jouyuejiache_dashixun1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.likalijuan.ListBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class Shouye_Recycl_YDAdapter extends XRecyclerView.Adapter<Shouye_Recycl_YDAdapter.ViewHolder> {
    private List<ListBean> mlistBeans;
    private Context context;

    public Shouye_Recycl_YDAdapter(List<ListBean> listBeans, Context context) {
        this.mlistBeans = listBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xrecycl_ydsuper, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(mlistBeans.get(position).getThumbnail()).into(holder.mimg_beifangScool);
        holder.tv_renshu.setText(mlistBeans.get(position).getName());
        holder.dajiang.setText(mlistBeans.get(position).getDescription());
        holder.tv_manny.setText(mlistBeans.get(position).getPtag());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCallBack.getData(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null==mlistBeans?0:mlistBeans.size();
    }

    public static class ViewHolder extends XRecyclerView.ViewHolder{
        public View rootView;
        public ImageView mimg_beifangScool;
        public TextView tv_renshu;
        public TextView dajiang;
        public TextView tv_manny;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mimg_beifangScool = (ImageView) rootView.findViewById(R.id.mimg_beifangScool);
            this.tv_renshu = (TextView) rootView.findViewById(R.id.tv_renshu);
            this.dajiang = (TextView) rootView.findViewById(R.id.dajiang);
            this.tv_manny = (TextView) rootView.findViewById(R.id.tv_manny);
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
