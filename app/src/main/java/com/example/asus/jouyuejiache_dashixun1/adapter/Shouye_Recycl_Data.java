package com.example.asus.jouyuejiache_dashixun1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.bean.zidingyiData.Choice;

import java.util.List;

public class Shouye_Recycl_Data extends RecyclerView.Adapter<Shouye_Recycl_Data.ViewHolder> {
    private List<Choice> mList;
    private Context context;

    public Shouye_Recycl_Data(List<Choice> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_shouye1_recycladapter, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.mname.setText(mList.get(position).getName());
        holder.mimg_adapter.setImageResource(mList.get(position).getImg());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCallBack.getData(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == mList ? 0 : mList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView mimg_adapter;
        public TextView mname;
        public ViewFlipper filpper;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.mimg_adapter = (ImageView) rootView.findViewById(R.id.mimg_adapter);
            this.mname = (TextView) rootView.findViewById(R.id.mname);
            this.filpper = (ViewFlipper) rootView.findViewById(R.id.filpper);

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
