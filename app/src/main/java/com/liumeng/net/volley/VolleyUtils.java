package com.liumeng.net.volley;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.liumeng.net.app.BaseApplication;
import com.liumeng.net.constant.Constant;
import com.liumeng.net.volley.listener.BeautListener;
import com.liumeng.net.volley.listener.ErrorListener;
import com.liumeng.net.volley.listener.ResponseListener;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/28
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class VolleyUtils {
    public static void getBeauty(BeautListener beautListener) {
        ResponseListener responseListener = new ResponseListener();
        responseListener.setContentType(Constant.CONTENT_TYPE_BEAUT);
        responseListener.setRequestType(Constant.REQUEST_TYPE_STRING);
        responseListener.setBeautListener(beautListener);
        String url = NetUrl.getGanKApi("%E7%A6%8F%E5%88%A9", 50);
        StringRequest jsObjRequest = new StringRequest
                (Request.Method.GET, url,
                        responseListener,
                        new ErrorListener());
        BaseApplication.getVolleyRequestQueue().add(jsObjRequest);
    }

    public static void getAndroid(BeautListener beautListener) {
        ResponseListener responseListener = new ResponseListener();
        responseListener.setContentType(Constant.CONTENT_TYPE_BEAUT);
        responseListener.setRequestType(Constant.REQUEST_TYPE_STRING);
        responseListener.setBeautListener(beautListener);
        String url = NetUrl.getGanKApi("%E7%A6%8F%E5%88%A9", 50);
        StringRequest jsObjRequest = new StringRequest
                (Request.Method.GET, url,
                        responseListener,
                        new ErrorListener());
        BaseApplication.getVolleyRequestQueue().add(jsObjRequest);
    }


}
