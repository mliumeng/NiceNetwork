package com.liumeng.net.view.fragment;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.liumeng.net.R;
import com.liumeng.net.app.BaseFragment;
import com.liumeng.net.constant.Constant;

import butterknife.BindView;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/5/3
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class DetailFragment extends BaseFragment {
    @BindView(R.id.web_detail)
    WebView webDetail;
    private String url;

    @Override
    public int setCreateView() {
        return R.layout.fragment_layout_detail;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            url = arguments.getString(Constant.KEY_DETAIL_URL);
        }
    }

    @Override
    protected void initView() {
        webDetail.loadUrl(url);
        webDetail.setWebViewClient(new MyWebViewClient());


    }

    @Override
    protected void initEvent() {

    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
