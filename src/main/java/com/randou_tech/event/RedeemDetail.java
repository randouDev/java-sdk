package com.randou_tech.event;

/**
 * 订单详情
 */
public class RedeemDetail {

    /**
     * The Product type.
     */
    public String product_type;
    /**
     * The Product name.
     */
    public String product_name;
    /**
     * The Product no.
     */
    public String product_no;
    /**
     * The Product from.
     */
    public String product_from;
    /**
     * The Need review.
     */
    public boolean need_review;
    /**
     * The Subsidy fee.
     */
    public Integer subsidy_fee;
    /**
     * The User fee.
     */
    public Integer user_fee;
    /**
     * The Shipping fee.
     */
    public Integer shipping_fee;
    /**
     * The Charge account.
     */
    public String charge_account;
    /**
     * The Shipping address.
     */
    public String shipping_address;
    /**
     * The Shipping receiver.
     */
    public String shipping_receiver;
    /**
     * The Shipping receiver phone.
     */
    public String shipping_receiver_phone;

    @Override
    public String toString() {
        return "RedeemDetail{" +
            "product_type='" + product_type + '\'' +
            ", product_name='" + product_name + '\'' +
            ", product_from='" + product_from + '\'' +
            ", charge_account='" + charge_account + '\'' +
            ", product_no='" + product_no + '\'' +
            ", need_review=" + need_review + '\'' +
            ", subsidy_fee=" + subsidy_fee + '\'' +
            ", user_fee=" + user_fee + '\'' +
            ", shipping_fee=" + shipping_fee + '\'' +
            ", shipping_address='" + shipping_address + '\'' +
            ", shipping_receiver='" + shipping_receiver + '\'' +
            ", shipping_receiver_phone='" + shipping_receiver_phone + '\'' +
            '}';
    }
}
