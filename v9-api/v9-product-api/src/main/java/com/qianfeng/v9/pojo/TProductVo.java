package com.qianfeng.v9.pojo;

import com.qianfeng.v9.entity.TProduct;

import java.io.Serializable;

/**
 * @author
 * @Date ${Date}
 */

public class TProductVo implements Serializable{
    private TProduct product;
    private String productDesc;

    public TProduct getProduct() {
        return product;
    }

    public void setProduct(TProduct product) {
        this.product = product;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public TProductVo(TProduct product, String productDesc) {
        this.product = product;
        this.productDesc = productDesc;
    }

    public TProductVo() {
    }

    @Override
    public String toString() {
        return "TProductVo{" +
                "product=" + product +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }
}
