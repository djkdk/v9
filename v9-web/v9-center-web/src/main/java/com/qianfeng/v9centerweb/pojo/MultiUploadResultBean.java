package com.qianfeng.v9centerweb.pojo;

/**
 * @author
 * @Date ${Date}
 */
public class MultiUploadResultBean {

    private String errno;
    private String[] data;

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public MultiUploadResultBean(String errno, String[] data) {
        this.errno = errno;
        this.data = data;
    }

    public MultiUploadResultBean() {
    }
}
