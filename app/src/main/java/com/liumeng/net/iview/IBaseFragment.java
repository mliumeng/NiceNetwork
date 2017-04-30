package com.liumeng.net.iview;

import android.os.Bundle;
import android.view.View;

import com.liumeng.net.app.IBaseView;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/29
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public interface IBaseFragment extends IBaseView {
    int setCreateView();

    void toFragment(String tag);

    void toFragment(String tag, Bundle bundle);

    void toFragment(String tag, Bundle bundle, boolean canBack);

    void toFragment(String tag, Bundle bundle, boolean canBack, View view);
}
