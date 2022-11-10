package com.randou_tech.event;

/**
 * 订单详情
 */
public class RedeemDetail {
    public String product_type;
    public String product_name;
    public String product_from;
    public boolean need_review;
    public String shipping_address;
    public String shipping_receiver;
    public String shipping_receiver_phone;

    @Override
    public String toString() {
        return "RedeemDetail{" +
            "product_type='" + product_type + '\'' +
            ", product_name='" + product_name + '\'' +
            ", product_from='" + product_from + '\'' +
            ", need_review=" + need_review +
            ", shipping_address='" + shipping_address + '\'' +
            ", shipping_receiver='" + shipping_receiver + '\'' +
            ", shipping_receiver_phone='" + shipping_receiver_phone + '\'' +
            '}';
    }
}
