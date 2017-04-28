package com.liumeng.net.volley.listener;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.liumeng.net.bean.BeautBean;
import com.liumeng.net.bean.BeautListBean;
import com.liumeng.net.constant.Constant;

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
        switch (requestType) {
            case Constant.REQUEST_TYPE_STRING:
                AnalysisJSON((String) response);
                break;
        }

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
        }
    }

    /**
     * 处理Beaut
     *
     * @param jsonObject json
     */
    public void setBeaut(String jsonObject) {
        Gson gson = new Gson();
        BeautListBean beautListBean = gson.fromJson(jsonObject, BeautListBean.class);
        List<BeautBean> results = beautListBean.getResults();
        beautListener.beautList(results);
    }


    public void setBeautListener(BeautListener beautListener) {
        this.beautListener = beautListener;
    }
}
