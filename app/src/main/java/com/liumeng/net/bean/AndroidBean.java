package com.liumeng.net.bean;

import android.text.TextUtils;

/**
 * *******************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/30
 * 创建人：刘蒙（H）
 * 功能：
 * *******************************************
 */

public class AndroidBean {

    /**
     * _id : 56cc6d23421aa95caa7079ff
     * createdAt : 2015-05-29T03:13:05.994Z
     * desc : Dribbble上纸飞机刷新效果的实现
     * publishedAt : 2015-05-29T03:36:52.920Z
     * type : Android
     * url : https://github.com/race604/FlyRefresh
     * used : true
     * who : mthli
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        if (!TextUtils.isEmpty(publishedAt)) {
            return publishedAt.substring(0, publishedAt.indexOf("T"));
        }
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
