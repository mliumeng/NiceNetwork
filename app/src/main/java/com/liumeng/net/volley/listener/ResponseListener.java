package com.liumeng.net.volley.listener;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liumeng.net.bean.AndroidBean;
import com.liumeng.net.bean.BaseBean;
import com.liumeng.net.bean.BeautBean;
import com.liumeng.net.constant.Constant;

import java.lang.reflect.Type;
import java.util.List;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/28
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class ResponseListener implements Response.Listener {
    private int requestType = 1;
    private int contentType = 1;
    private BeautListener beautListener;
    private AndroidListener androidListener;

    public ResponseListener() {
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    @Override
    public void onResponse(Object response) {
        AnalysisJSON((String) response);

    }

    /**
     * 解析json
     *
     * @param jsonObject json
     */
    private void AnalysisJSON(String jsonObject) {
        switch (getContentType()) {
            case Constant.CONTENT_TYPE_BEAUT:
                setBeaut(jsonObject);
                break;
            case Constant.CONTENT_TYPE_ANDROID:
                setAndroid(jsonObject);
                break;
        }
    }

    /**
     * 处理Android
     *
     * @param jsonObject json string
     */
    private void setAndroid(String jsonObject) {
        Gson gson = new Gson();
        Type type = new TypeToken<BaseBean<AndroidBean>>() {
        }.getType();
        BaseBean<AndroidBean> data = gson.fromJson(jsonObject, type);
        List<AndroidBean> results = data.getResults();
        androidListener.androidList(results);
    }

    /**
     * 处理Beaut
     *
     * @param jsonObject json
     */
    public void setBeaut(String jsonObject) {
        Gson gson = new Gson();
        Type type = new TypeToken<BaseBean<BeautBean>>() {
        }.getType();
        BaseBean<BeautBean> data = gson.fromJson(jsonObject, type);
        List<BeautBean> results = data.getResults();
        beautListener.beautList(results);
    }


    public void setBeautListener(BeautListener beautListener) {
        this.beautListener = beautListener;
    }

    public void setAndroidListener(AndroidListener androidListener) {
        this.androidListener = androidListener;
    }
}
