package com.randou_tech.event;

import com.randou_tech.RdException;
import com.randou_tech.contract.BaseEvent;

import javax.servlet.http.HttpServletRequest;

/**
 * 商品直充结果查询事件
 */
public class GoodsChargeQueryEvent extends BaseEvent {
    public String orderNo;
    public String chargeBizNo;


    public GoodsChargeQueryEvent(HttpServletRequest request) {
        super(request);
    }


    public void parse() throws RdException {
        this.orderNo = request.getParameter("orderNo");
        this.chargeBizNo = request.getParameter("chargeBizNo");
    }

    @Override
    public String toString() {
        return "GoodsChargeQueryEvent{" +
                "orderNo='" + orderNo + '\'' +
                ", chargeBizNo='" + chargeBizNo + '\'' +
                '}';
    }
}
