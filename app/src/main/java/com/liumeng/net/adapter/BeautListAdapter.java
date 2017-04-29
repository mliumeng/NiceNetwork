package com.liumeng.net.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.liumeng.net.R;
import com.liumeng.net.app.BaseApplication;
import com.liumeng.net.bean.BeautBean;
import com.liumeng.net.utils.ImageCache;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/29
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class BeautListAdapter extends RecyclerView.Adapter {
    private List<BeautBean> beautList;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beaut, parent, false);
        return new ViewHolderBeaut(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolderBeaut viewHolder = (ViewHolderBeaut) holder;
        ImageLoader imageLoader = new ImageLoader(BaseApplication.getVolleyRequestQueue(), ImageCache.getInstance());
        ImageListener imageListener = imageLoader.getImageListener(viewHolder.itemImage, R.drawable.side_nav_bar, R.drawable.side_nav_bar);
        imageLoader.get(beautList.get(position).getUrl(), imageListener);
        viewHolder.itemDes.setText(beautList.get(position).getDesc());
        viewHolder.itemPublishedTime.setText(beautList.get(position).getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return beautList.size();
    }

    public List<BeautBean> getData() {
        return beautList;
    }

    public void setData(List<BeautBean> beautList) {
        this.beautList = beautList;
    }

    public class ViewHolderBeaut extends RecyclerView.ViewHolder {


        @BindView(R.id.item_image)
        ImageView itemImage;
        @BindView(R.id.item_des)
        TextView itemDes;
        @BindView(R.id.item_published_time)
        TextView itemPublishedTime;

        public ViewHolderBeaut(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }

    }
}
