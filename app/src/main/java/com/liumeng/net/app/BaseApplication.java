package com.liumeng.net.app;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/28
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class BaseApplication extends Application {
    public static RequestQueue requestQueue;
    static Context context;

    public static RequestQueue getVolleyRequestQueue() {
        return requestQueue;
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }
}
