package com.liumeng.net.volley.listener;

import com.android.volley.Response;
import com.liumeng.net.bean.AndroidBean;

import java.util.List;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/5/3
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public interface AndroidListener extends Response.ErrorListener{
    void androidList(List<AndroidBean> androidBeanList);
}
