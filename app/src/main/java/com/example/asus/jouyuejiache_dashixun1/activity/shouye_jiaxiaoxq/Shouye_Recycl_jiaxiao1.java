package com.example.asus.jouyuejiache_dashixun1.activity.shouye_jiaxiaoxq;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.ResultBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.carxq_reimen.ResultListBean;

import java.util.List;

public class Shouye_Recycl_jiaxiao1 extends RecyclerView.Adapter<Shouye_Recycl_jiaxiao1.ViewHolder> {

    private ResultBean mXqresult;
    private List<ResultListBean> mRmBanZhList;
    private Context context;

    public Shouye_Recycl_jiaxiao1(ResultBean mXqresult, List<ResultListBean> mRmBanZhList, Context context) {
        this.mXqresult = mXqresult;
        this.mRmBanZhList = mRmBanZhList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recycl_car_xiangqin, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //开始绑定set详情数据
        Glide.with(context).load(mXqresult.getSchoolImgList().get(position).getUrl()).into(holder.mimg_jiax);
        holder.mtv_juli.setText(mXqresult.getRange());
        holder.mtv_name.setText(mXqresult.getName());
        holder.mtv_baoming.setText(mXqresult.getEnrollNum()+"");
        holder.mtv_url.setText(mXqresult.getAddress());
        holder.mtv_xunlianc.setText(mXqresult.getNum());
        Glide.with(context).load(mXqresult.getLocation().getLocationImg().get(0)).into(holder.mimg_beifangScool);
        holder.mtv_carshool2.setText(mXqresult.getLocation().getName());
        holder.mtv_url2.setText(mXqresult.getLocation().getAddress());
        holder.mtv_juli2.setText(mXqresult.getLocation().getDistance());
      /*  holder.mtv_bf1.setText(mXqresult.getFeature().get(0));
        holder.mtv_bf2.setText(mXqresult.getFeature().get(1));
        holder.mtv_bf3.setText(mXqresult.getFeature().get(2));*/
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                callback.getData(position);
//            }
//        });


        //热门班制适配器详情嵌套热门
        holder.mlv.setLayoutManager(new LinearLayoutManager(context));
        Shouye_Recycl_Reimen shouye_recycl_reimen = Shouye_Recycl_Reimen.getShouye_recycl_reimen(context, mRmBanZhList);
        holder.mlv.setAdapter(shouye_recycl_reimen);

        shouye_recycl_reimen.setCallback(new Shouye_Recycl_Reimen.MyReimCallback() {
            @Override
            public void getData(int id) {
                callback.getData(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }


    MyCallback callback;

    public interface MyCallback {
        void getData(int id);
    }

    public void setCallback(MyCallback callback) {
        this.callback = callback;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView mimg_jiax;
        public TextView mtv_juli;
        public TextView mtv_name;
        public TextView mtv_baoming;
        public TextView mtv_guanzhu;
        public TextView mtv_url;
        public TextView mtv_bf1;
        public TextView mtv_bf2;
        public TextView mtv_bf3;
        public RecyclerView mlv;
        public TextView changdi;
        public TextView jiantou2;
        public TextView mtv_xunlianc;
        public ImageView mimg_beifangScool;
        public TextView mtv_carshool2;
        public TextView mtv_url2;
        public TextView mtv_juli2;
        public TextView jianjie;
        public TextView tv_message;
        public TextView mtv_gengduo;
        public TextView pingjia;
        public TextView jiantou;
        public TextView mtv_pinglun;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mimg_jiax = (ImageView) rootView.findViewById(R.id.mimg_jiax);
            this.mtv_juli = (TextView) rootView.findViewById(R.id.mtv_juli);
            this.mtv_name = (TextView) rootView.findViewById(R.id.mtv_name);
            this.mtv_baoming = (TextView) rootView.findViewById(R.id.mtv_baoming);
            this.mtv_guanzhu = (TextView) rootView.findViewById(R.id.mtv_guanzhu);
            this.mtv_url = (TextView) rootView.findViewById(R.id.mtv_url);
            this.mtv_bf1 = (TextView) rootView.findViewById(R.id.mtv_bf1);
            this.mtv_bf2 = (TextView) rootView.findViewById(R.id.mtv_bf2);
            this.mtv_bf3 = (TextView) rootView.findViewById(R.id.mtv_bf3);
            this.mlv = (RecyclerView) rootView.findViewById(R.id.mlv);
            this.changdi = (TextView) rootView.findViewById(R.id.changdi);
            this.jiantou2 = (TextView) rootView.findViewById(R.id.jiantou2);
            this.mtv_xunlianc = (TextView) rootView.findViewById(R.id.mtv_xunlianc);
            this.mimg_beifangScool = (ImageView) rootView.findViewById(R.id.mimg_beifangScool);
            this.mtv_carshool2 = (TextView) rootView.findViewById(R.id.mtv_carshool2);
            this.mtv_url2 = (TextView) rootView.findViewById(R.id.mtv_url2);
            this.mtv_juli2 = (TextView) rootView.findViewById(R.id.mtv_juli2);
            this.jianjie = (TextView) rootView.findViewById(R.id.jianjie);
            this.tv_message = (TextView) rootView.findViewById(R.id.tv_message);
            this.mtv_gengduo = (TextView) rootView.findViewById(R.id.mtv_gengduo);
            this.pingjia = (TextView) rootView.findViewById(R.id.pingjia);
            this.jiantou = (TextView) rootView.findViewById(R.id.jiantou);
            this.mtv_pinglun = (TextView) rootView.findViewById(R.id.mtv_pinglun);
        }

    }
}
