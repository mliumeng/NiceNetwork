package com.liumeng.net.view.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.liumeng.net.R;
import com.liumeng.net.adapter.AndroidListAdapter;
import com.liumeng.net.app.BaseFragment;
import com.liumeng.net.bean.AndroidBean;
import com.liumeng.net.view.activity.DetailActivity;
import com.liumeng.net.volley.VolleyUtils;
import com.liumeng.net.volley.listener.AndroidListener;

import java.util.List;

import butterknife.BindView;

import static com.liumeng.net.constant.Constant.KEY_DETAIL_URL;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/5/3
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class AndroidFragment extends BaseFragment implements AndroidListener, SwipeRefreshLayout.OnRefreshListener, AndroidListAdapter.OnItemClickListener {
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.super_swipe_refresh)
    SwipeRefreshLayout superSwipeRefresh;
    AndroidListAdapter androidListAdapter;

    @Override
    public int setCreateView() {
        return R.layout.fragment_layout_android;
    }

    @Override
    protected void initData() {
        androidListAdapter = new AndroidListAdapter();
        androidListAdapter.setOnItemClickListener(this);
        VolleyUtils.getAndroid(this);
    }

    @Override
    protected void initView() {
        superSwipeRefresh.setOnRefreshListener(this);
        recycleView.setAdapter(androidListAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void androidList(List<AndroidBean> androidBeanList) {
        androidListAdapter.setAndroidBeanList(androidBeanList);
        androidListAdapter.notifyDataSetChanged();
        stopSwipeRefresh();
    }

    private void stopSwipeRefresh() {
        if (superSwipeRefresh == null) return;
        boolean refreshing = superSwipeRefresh.isRefreshing();
        if (refreshing) superSwipeRefresh.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        // TODO: 2017/5/3  下拉刷新
        VolleyUtils.getAndroid(this);
    }

    @Override
    public void onItemClick(Integer position) {
        AndroidBean androidBean = androidListAdapter.getAndroidBeanList().get(position);
        System.out.println("================= onItemClick ======================");
        Bundle bundle = new Bundle();
        bundle.putString(KEY_DETAIL_URL,androidBean.getUrl());
        toActivity(DetailActivity.class,bundle);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        stopSwipeRefresh();
    }
}
