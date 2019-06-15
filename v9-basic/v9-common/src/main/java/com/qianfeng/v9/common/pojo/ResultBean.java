package com.qianfeng.v9.common.pojo;

/**
 * @author
 * @Date ${Date}
 */
public class ResultBean<T> {

    private String statusCode;

    private T date;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public ResultBean(String statusCode, T date) {
        this.statusCode = statusCode;
        this.date = date;
    }

    public ResultBean() {
    }
}
