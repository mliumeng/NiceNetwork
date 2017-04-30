package com.liumeng.net.view.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.transition.Fade;
import android.view.MenuItem;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.liumeng.net.MainActivity;
import com.liumeng.net.R;
import com.liumeng.net.app.BaseApplication;
import com.liumeng.net.app.BaseFragment;
import com.liumeng.net.utils.DetailsTransition;
import com.liumeng.net.utils.ImageCache;

import butterknife.BindView;

import static com.liumeng.net.constant.Constant.KEY_BEAUT_BIG;

/**
 * ***************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/30
 * 创建人：刘蒙(H)
 * 功能：
 * *****************************************************
 */


public class BeautBigFragment extends BaseFragment {
    @BindView(R.id.beaut_big)
    ImageView ivBrautBig;
    private String imgUrl;

    @Override
    public int setCreateView() {
        return R.layout.fragment_beaut_big;
    }

    @Override
    protected void initData() {
        // 转场动画
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(new DetailsTransition());
            setEnterTransition(new Fade());
            setExitTransition(new Fade());
            setSharedElementReturnTransition(new DetailsTransition());
        }
        Bundle arguments = getArguments();
        imgUrl = arguments.getString(KEY_BEAUT_BIG, "");

        ImageLoader imageLoader = new ImageLoader(BaseApplication.getVolleyRequestQueue(), ImageCache.getInstance());
        ImageLoader.ImageListener imageListener = imageLoader.getImageListener(ivBrautBig, R.drawable.side_nav_bar, R.drawable.side_nav_bar);
        imageLoader.get(imgUrl, imageListener);
//        startPostponedEnterTransition();
    }


    @Override
    protected void initView() {
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        if (actionBar == null) System.out.println("avtion bar nulllllllllllll");
        else {
            //actionBar.setDisplayHomeAsUpEnabled(true);

        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                System.out.println("backkkkkkkkkkkkkkkkkk");
                getActivity().onBackPressed();
                break;
        }
        return true;

    }

    @Override
    protected void initEvent() {


    }
}
