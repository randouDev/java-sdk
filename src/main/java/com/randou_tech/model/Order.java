package com.randou_tech.model;

public class Order {
    /**
     * 燃豆订单号
     */
    public String orderNo="";

    /**
     * 开发者订单号
     */
    public String bizNo="";

    public String getOrderNo()
    {
        return orderNo;
    }

    public String getBizNo()
    {
        return bizNo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                "bizNo='" + bizNo + '\'' +
                '}';
    }
}
