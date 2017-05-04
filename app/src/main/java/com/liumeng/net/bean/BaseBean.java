package com.liumeng.net.bean;

import java.util.List;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/5/3
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class BaseBean<T> {
    private boolean error;
    private List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }


}
