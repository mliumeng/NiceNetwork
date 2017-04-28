package com.liumeng.net.volley.listener;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/28
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class ErrorListener implements Response.ErrorListener {
    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println("出错了！" + error);
    }
}
