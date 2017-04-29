package com.liumeng.net.utils;

import android.graphics.Bitmap;

import com.android.volley.toolbox.ImageLoader;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/29
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class ImageCache implements ImageLoader.ImageCache {
    static ImageCache imageCache;

    public static ImageCache getInstance() {
        if (imageCache == null) {
            synchronized (ImageCache.class) {
                if (imageCache == null) {
                    return new ImageCache();
                }
            }
        }
        return imageCache;
    }

    @Override
    public Bitmap getBitmap(String url) {
        return null;
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {

    }
}
