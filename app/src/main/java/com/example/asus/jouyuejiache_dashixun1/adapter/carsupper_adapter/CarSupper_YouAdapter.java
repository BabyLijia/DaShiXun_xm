package com.example.asus.jouyuejiache_dashixun1.adapter.carsupper_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.adapter.Shouye_Recycl_YDAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class CarSupper_YouAdapter extends XRecyclerView.Adapter<CarSupper_YouAdapter.ViewHolder> {
    private List<com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.car_you1.ListBean> mYoulist;
    private Context context;

    public CarSupper_YouAdapter(List<com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.car_you1.ListBean> mYoulist, Context context) {
        this.mYoulist = mYoulist;
        this.context = context;
    }
    @NonNull
    @Override
    public CarSupper_YouAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xrecycl_ydsuper, null);
        return new CarSupper_YouAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CarSupper_YouAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(mYoulist.get(position).getThumbnail()).into(holder.mimg_beifangScool);
        holder.tv_renshu.setText(mYoulist.get(position).getName());
        holder.dajiang.setText(mYoulist.get(position).getDescription());
        holder.tv_manny.setText(mYoulist.get(position).getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCallBack.getData(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null==mYoulist?0:mYoulist.size();
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
    Shouye_Recycl_YDAdapter.MyCallBack myCallBack;

    public interface MyCallBack {
        void getData(int id);
    }

    public void setMyCallBack(Shouye_Recycl_YDAdapter.MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }

}
