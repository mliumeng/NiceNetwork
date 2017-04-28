package com.liumeng.net.volley;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/28
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class NetUrl {
    public static String baseUrl = "http://gank.io/api/random/data/";

    /**
     * @param type 数据类型 值： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * @param num  数据数目
     * @return api
     */
    public static String getGanKApi(String type, int num) {
        return baseUrl + type + "/" + num;
    }
}
