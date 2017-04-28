package com.liumeng.net.bean;

import java.util.List;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/4/28
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class BeautListBean {

    /**
     * error : false
     * results : [{"_id":"56de2b1b6776592b6192bf46","createdAt":"2016-03-08T09:30:03.578Z","desc":"3.8","publishedAt":"2016-03-08T12:55:59.161Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1f1p77v97xpj20k00zkgpw.jpg","used":true,"who":"张涵宇"}]
     */

    private boolean error;
    private List<BeautBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<BeautBean> getResults() {
        return results;
    }

    public void setResults(List<BeautBean> results) {
        this.results = results;
    }

}
