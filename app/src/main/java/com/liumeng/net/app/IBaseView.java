package com.liumeng.net.app;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/29
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public interface IBaseView {
    void showToast(String s);

    void showSnackBar(String msg);

    void showLoading(boolean isLoading);
}
