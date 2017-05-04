package com.liumeng.net.utils;


import com.liumeng.net.app.BaseFragment;
import com.liumeng.net.view.fragment.AndroidFragment;
import com.liumeng.net.view.fragment.BeautBigFragment;
import com.liumeng.net.view.fragment.BeautFragment;
import com.liumeng.net.view.fragment.DetailFragment;

/**
 * ****************************************************
 * Created by Moppo on 16/6/12.
 * *****************************************************
 */
public class FragmentTag {
    public static final String ANDROID = "ANDROID";
    public static final String DETAIL = "DETAIL";
    public static final String IOS = "IOS";
    public static final String WEB = "WEB";
    public static final String BEAUTY = "BEAUTY";
    public static final String BEAUTY_BIG = "BEAUTY_BIG";
    public static final String TAGS = "TAGS";


    public static BaseFragment getFragment(String tag) {
        switch (tag) {
            case ANDROID:
                return new AndroidFragment();
            case IOS:
                break;
            case WEB:
                break;
            case BEAUTY:
                return new BeautFragment();
            case BEAUTY_BIG:
                return new BeautBigFragment();
            case DETAIL:
                return new DetailFragment();
        }
        return null;
    }
}