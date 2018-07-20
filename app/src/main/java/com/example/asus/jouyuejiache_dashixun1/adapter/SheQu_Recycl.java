package com.example.asus.jouyuejiache_dashixun1.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.First_LogActivity;

import org.json.JSONArray;
import org.json.JSONException;

public class SheQu_Recycl extends RecyclerView.Adapter<SheQu_Recycl.ViewHolder> {
    private JSONArray resultList;
    private Context context;
    private final SharedPreferences denglu;

    public SheQu_Recycl(JSONArray mlist, Context context) {
        this.resultList = mlist;
        this.context = context;
        //使用构造将sp获取出来，并传值
        denglu = context.getSharedPreferences("denglu", 0);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_shequ_recycl, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        try {
            Glide.with(context).load(resultList.getJSONObject(position).getString("icon")).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.img_wenwen);
            final int hits = resultList.getJSONObject(position).getInt("hits");
            final int plcount = resultList.getJSONObject(position).getInt("plcount");
            final int sccount = resultList.getJSONObject(position).getInt("sccount");
            holder.dianzan.setText(hits+"");
            holder.time.setText(resultList.getJSONObject(position).getString("crtime"));
            holder.xinxicontent.setText(plcount + "");
            holder.xueche.setText(resultList.getJSONObject(position).getJSONObject("topic").getString("topicname"));
            holder.xueche2.setText(resultList.getJSONObject(position).getString("description"));
            holder.yangjing.setText(resultList.getJSONObject(position).getString("read_num"));
            holder.name.setText(resultList.getJSONObject(position).getString("nickname"));
            holder.name2.setText(resultList.getJSONObject(position).getInt("credit")+"悦豆");
            holder.mtv_xinxin.setText(sccount+"");

            //使用sp获取一个Boolean值用来判断是否有数据，默认为空false
            final boolean zhuangtai = denglu.getBoolean("zhuangtai", false);
            holder.dianzan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //判断状态为true时点击+1并且图片视为选中状态
                    //todo 还未判断再次点击显示未选中状态，列如取消关注
                    if(zhuangtai){
                       holder.dianzan.setText(hits+1+"");
                       Drawable drawableLeft = context.getResources().getDrawable(
                               R.drawable.find_thumbs_up_true);
                        holder.dianzan.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null,null,null);
                   }else{
                       //判断状态为false时(默认的)并且图片视为未选中状态
                       context.startActivity(new Intent(context, First_LogActivity.class));
                       Drawable drawableLeft = context.getResources().getDrawable(
                               R.drawable.find_thumbs_up);
                       holder.dianzan.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null,null,null);
                   }
                }
            });
            holder.xinxicontent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(zhuangtai){
                        //如果点赞为true,那么在原来的基础上加1，并使用TextView 动态设置DrawableLeft
                        holder.xinxicontent.setText(plcount+1+"");
                        Drawable drawableLeft = context.getResources().getDrawable(
                                R.drawable.myschool_message);
                        holder.xinxicontent.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null,null,null);
                    }else{
                        context.startActivity(new Intent(context, First_LogActivity.class));
                        Drawable drawableLeft = context.getResources().getDrawable(
                                R.drawable.find_message_img);
                        holder.xinxicontent.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null,null,null);
                    }
                }
            });
            holder.mtv_xinxin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(zhuangtai){
                        holder.mtv_xinxin.setText(sccount+1+"");
                        Drawable drawableLeft = context.getResources().getDrawable(
                                R.drawable.find_like_img);
                        holder.mtv_xinxin.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null,null,null);
                    }else{
                        context.startActivity(new Intent(context, First_LogActivity.class));
                        Drawable drawableLeft = context.getResources().getDrawable(
                                R.drawable.find_like_img_no);
                        holder.mtv_xinxin.setCompoundDrawablesWithIntrinsicBounds(drawableLeft,null,null,null);
                    }
                }
            });
            holder.mimg_dashang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"打赏",Toast.LENGTH_SHORT).show();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return null == resultList ? 0 : resultList.length();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img_wenwen;
        public TextView yangjing;
        public TextView time;
        public TextView xueche;
        public TextView xueche2;
        public TextView xinxicontent;
        public TextView dianzan;
        public TextView name;
        public TextView name2;
        public TextView mtv_xinxin;
        public ImageView mimg_dashang;
        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_wenwen = (ImageView) rootView.findViewById(R.id.img_wenwen);
            this.yangjing = (TextView) rootView.findViewById(R.id.yangjing);
            this.time = (TextView) rootView.findViewById(R.id.time);
            this.xueche = (TextView) rootView.findViewById(R.id.xueche);
            this.xueche2 = (TextView) rootView.findViewById(R.id.xueche2);
            this.xinxicontent = (TextView) rootView.findViewById(R.id.xinxicontent);
            this.dianzan = (TextView) rootView.findViewById(R.id.dianzan);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.name2 = (TextView) rootView.findViewById(R.id.name2);
            this.mtv_xinxin = (TextView) rootView.findViewById(R.id.mtv_xinxin);
            this.mimg_dashang = (ImageView) rootView.findViewById(R.id.mimg_dashang);
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
