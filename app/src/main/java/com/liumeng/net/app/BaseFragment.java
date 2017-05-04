package com.liumeng.net.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liumeng.net.R;
import com.liumeng.net.iview.IBaseFragment;
import com.liumeng.net.utils.FragmentTag;

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
    private BaseFragment fragment;

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
    public void toFragment(@NonNull String tag) {
        toFragment(tag, null, true);
    }


    @Override
    public void toFragment(@NonNull String tag, @Nullable Bundle bundle) {
        toFragment(tag, bundle, true);
    }

    @Override
    public void toFragment(@NonNull String tag, @Nullable Bundle bundle, boolean canBack) {
        toFragment(tag, bundle, true, null);
    }

    @Override
    public void toFragment(@NonNull String tag, @Nullable Bundle bundle, boolean canBack, View view) {

        if (fragment != null && fragment.getTag() != null) {
            if (fragment.getTag().equals(tag))
                return;
        }
        BaseFragment from = this;
        fragment = FragmentTag.getFragment(tag);
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
//            setSelectItem(tag);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (view != null)
            fragmentTransaction.addSharedElement(view, getString(R.string.beautTransitionName));
        if (fragment.isAdded()) {
            fragmentTransaction.hide(from).show(fragment);
        } else {
            fragmentTransaction.hide(from).add(R.id.main_frame_layout, fragment).commit(); // 隐藏当前的fragment，add下一个到Activity中
            if (canBack) fragmentTransaction.addToBackStack(tag);
        }
    }

    @Override
    public void toActivity(Class aClass, Bundle bundle) {
        Intent intent = new Intent(getActivity(), aClass);
        if (bundle != null)
            intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }
}
