package com.liumeng.net.view.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.liumeng.net.R;
import com.liumeng.net.adapter.BeautListAdapter;
import com.liumeng.net.app.BaseFragment;
import com.liumeng.net.bean.BeautBean;
import com.liumeng.net.utils.FragmentTag;
import com.liumeng.net.volley.VolleyUtils;
import com.liumeng.net.volley.listener.BeautListener;

import java.util.List;

import butterknife.BindView;

import static com.liumeng.net.constant.Constant.KEY_BEAUT_BIG;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/29
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class BeautFragment extends BaseFragment implements BeautListener, SwipeRefreshLayout.OnRefreshListener, BeautListAdapter.OnItemClickListener {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.super_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;
    private BeautListAdapter beautListAdapter;

    public BeautFragment() {
    }

    @Override
    public int setCreateView() {
        return R.layout.fragment_layout_beauty;
    }


    @Override
    protected void initData() {
        beautListAdapter = new BeautListAdapter();
        VolleyUtils.getBeauty(this);

    }

    @Override
    protected void initView() {

        swipeRefreshLayout.setOnRefreshListener(this);
        //为SwipeRefreshLayout设置刷新时的颜色变化，最多可以设置4种
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    private void initRecycle() {
        if (beautListAdapter == null)
            beautListAdapter = new BeautListAdapter();
        final StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recycleView.setLayoutManager(staggeredGridLayoutManager);
        recycleView.setAdapter(beautListAdapter);
    }

    private int getMaxElem(int[] arr) {
        int size = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] > maxVal)
                maxVal = arr[i];
        }
        return maxVal;
    }

    @Override
    protected void initEvent() {
        if (beautListAdapter != null) beautListAdapter.setItemClickListener(this);
    }


    @Override
    public void beautList(List<BeautBean> beautListBean) {
        if (beautListAdapter == null) {
            initRecycle();
        }
        if (beautListBean != null && beautListBean.size() > 0)
            beautListAdapter.setData(beautListBean);
        initRecycle();
        beautListAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        VolleyUtils.getBeauty(this);
    }

    @Override
    public void onItemClick(View view, BeautBean beautBean) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_BEAUT_BIG, beautBean.getUrl());
        toFragment(FragmentTag.BEAUTY_BIG, bundle, true, view);
    }
}
