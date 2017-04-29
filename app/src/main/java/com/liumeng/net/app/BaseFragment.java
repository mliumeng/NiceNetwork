package com.liumeng.net.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liumeng.net.iview.IBaseFragment;

import butterknife.ButterKnife;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/29
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public abstract class BaseFragment extends Fragment implements IBaseFragment {
    private View view;// inflater view

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initView();
        initEvent();
    }

    /**
     * 数据相关
     */
    protected abstract void initData();

    /**
     * View相关
     */
    protected abstract void initView();


    /**
     * 事件相关
     */
    protected abstract void initEvent();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (setCreateView() > 0) {
            view = inflater.inflate(setCreateView(), container, false);
        }
        ButterKnife.bind(this, view);
        return view;
    }



    @Override
    public void showToast(String s) {

    }

    @Override
    public void showSnackBar(String msg) {

    }

    @Override
    public void showLoading(boolean isLoading) {

    }


    @Override
    public void toFragment(String tag) {

    }

    @Override
    public void toFragment(String tag, Bundle bundle) {

    }
}
