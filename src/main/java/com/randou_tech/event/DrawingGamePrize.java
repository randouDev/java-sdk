package com.randou_tech.event;

public class DrawingGamePrize {
    public String type;

    public String name;

    public String order_result;

    public GoodsSimpleInfo goods;

    public Integer credits_gain;

    public DrawingGamePrize(String type, String name, String order_result, GoodsSimpleInfo goods, Integer credits_gain) {
        this.type = type;
        this.name = name;
        this.order_result = order_result;
        this.goods = goods;
        this.credits_gain = credits_gain;
    }


    @Override
    public String toString() {
        return "DrawingGamePrize{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", order_result='" + order_result + '\'' +
//                ", isCreditsPrize='" + isCreditsPrize + '\'' +
                ", goods='" + (goods != null ? goods.toString() : "null") + '\'' +
                ", credits_gain='" + credits_gain + '\'' +
                '}';
    }
}
