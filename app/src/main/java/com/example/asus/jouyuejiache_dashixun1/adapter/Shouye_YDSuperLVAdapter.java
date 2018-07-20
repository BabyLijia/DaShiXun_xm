package com.example.asus.jouyuejiache_dashixun1.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.ResultListBean;
import com.umeng.debug.log.D;

import java.util.List;

public class Shouye_YDSuperLVAdapter extends BaseAdapter {
    private List<ResultListBean> resultList;
    private Context context;

    public Shouye_YDSuperLVAdapter(List<ResultListBean> resultList, Context context) {
        this.resultList = resultList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return null == resultList ? 0 : resultList.size();
    }

    @Override
    public Object getItem(int position) {
        return resultList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder=null;
        if(view==null){
            holder=new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.adapter_yuedou_zuolv, null);
            holder.mtv_lv1 = (TextView) view.findViewById(R.id.mtv_lv1);
            holder.view = (View) view.findViewById(R.id.mview);
            holder.mll = (LinearLayout) view.findViewById(R.id.mll);

            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }

        holder.mtv_lv1.setText(resultList.get(position).getName());
        boolean selcted = resultList.get(position).isSelcted();
        if(selcted){
            holder.view.setVisibility(View.VISIBLE);
            holder.mll.setBackgroundColor(context.getResources().getColor(R.color.color_pleasing));
           holder.mtv_lv1.setTextColor(Color.RED);
        }else {
            holder.view.setVisibility(View.INVISIBLE);
            holder.mll.setBackgroundColor(context.getResources().getColor(R.color.color4));
            holder.mtv_lv1.setTextColor(Color.BLACK);
        }
        return view;
    }

    public static class ViewHolder {
        public TextView mtv_lv1;
        public View view;
        public LinearLayout mll;
    }
}
