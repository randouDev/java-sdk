package com.randou_tech.event;

import com.randou_tech.RdException;
import com.randou_tech.contract.BaseEvent;

import javax.servlet.http.HttpServletRequest;

/**
 * 商品直充事件
 */
public class GoodsChargeEvent extends BaseEvent {
    public String uid;
    public String mall_no;
    public String orderNo;
    public String product_no;
    public String description;

    public String bizNo;
    public String account;


    public GoodsChargeEvent(HttpServletRequest request) {
        super(request);
    }


    public void parse() throws RdException {
        this.uid = request.getParameter("uid");
        this.mall_no = request.getParameter("mall_no");
        this.orderNo = request.getParameter("orderNo");
        this.product_no = request.getParameter("product_no");
        this.description = request.getParameter("description");

        String account = request.getParameter("account");
        if (null != account && account.length() > 0) {
            this.account = account;
        }

        String bizNo = request.getParameter("bizNo");
        if (null != bizNo && bizNo.length() > 0) {
            this.bizNo = bizNo;
        }
    }

    /**
     * @return
     */
    public Boolean hasAccount() {
        return null != account;
    }

    /**
     * @return
     */
    public Boolean hasBizNo() {
        return null != bizNo;
    }

    @Override
    public String toString() {
        return "GoodsChargeEvent{" +
                "uid='" + uid + '\'' +
                ", mall_no='" + mall_no + '\'' +
                ", orderNo=" + orderNo +
                ", product_no='" + product_no + '\'' +
                ", description='" + description + '\'' +
                ", bizNo='" + bizNo + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
