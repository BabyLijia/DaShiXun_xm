package com.example.asus.jouyuejiache_dashixun1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.ResultListBean;

import java.util.List;

public class LVKeEr_adapter extends BaseAdapter {
    private List<ResultListBean> mkeerBeans;
    private Context context;

    int a = 3;

    public void setA(int a) {
        this.a = a;
    }

    public LVKeEr_adapter(List<ResultListBean> keerBeans, Context context) {
        this.mkeerBeans = keerBeans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return a;
    }

    @Override
    public Object getItem(int position) {
        return mkeerBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.layout_keer_adapter, null);
            holder.mimg_shiping = (ImageView) view.findViewById(R.id.mimg_shiping);
            holder.mtv_name = (TextView) view.findViewById(R.id.mtv_name);
            holder.mtv_ground = (TextView) view.findViewById(R.id.mtv_ground);
            view.setTag(holder);
        }else {
          holder= (ViewHolder) view.getTag();
        }

        Glide.with(context).load(mkeerBeans.get(position).getImageUrl()).into(holder.mimg_shiping);
        holder.mtv_name.setText(mkeerBeans.get(position).getTitle());
        holder.mtv_ground.setText(mkeerBeans.get(position).getVideoDescp());

        return view;
    }

    public class ViewHolder {
        public ImageView mimg_shiping;
        public TextView mtv_name;
        public TextView mtv_ground;
    }
}
