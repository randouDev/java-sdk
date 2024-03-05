package com.randou_tech.event;

public class GoodsSimpleInfo {
    public String product_no;
    public String product_name;

    public GoodsSimpleInfo(String product_no, String product_name) {
        this.product_no = product_no;
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "GoodsSimpleInfo{" +
                "product_no='" + product_no + '\'' +
                ", product_name='" + product_name + '\'' +
                '}';
    }
}
