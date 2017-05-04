package com.liumeng.net.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liumeng.net.R;
import com.liumeng.net.bean.AndroidBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/5/3
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class AndroidListAdapter extends RecyclerView.Adapter {
    OnItemClickListener onItemClickListener;
    private List<AndroidBean> androidBeanList;

    public List<AndroidBean> getAndroidBeanList() {
        return androidBeanList;
    }

    public void setAndroidBeanList(List<AndroidBean> androidBeanList) {
        this.androidBeanList = androidBeanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_android, parent, false);
        return new ViewHolderAndroid(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolderAndroid viewHolderAndroid = (ViewHolderAndroid) holder;
        viewHolderAndroid.itemAndroidDes.setText(androidBeanList.get(position).getDesc());
        viewHolderAndroid.itemAndroidTime.setText(androidBeanList.get(position).getPublishedAt());
        viewHolderAndroid.itemAndroidVia.setText(androidBeanList.get(position).getWho());
        viewHolderAndroid.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (androidBeanList != null) return androidBeanList.size();
        return 0;

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public interface OnItemClickListener {
        void onItemClick(Integer position);
    }

    public class ViewHolderAndroid extends RecyclerView.ViewHolder {

        @BindView(R.id.item_android_des)
        TextView itemAndroidDes;
        @BindView(R.id.item_android_time)
        TextView itemAndroidTime;
        @BindView(R.id.item_android_via)
        TextView itemAndroidVia;
        @BindView(R.id.item)
        CardView cardView;


        public ViewHolderAndroid(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
