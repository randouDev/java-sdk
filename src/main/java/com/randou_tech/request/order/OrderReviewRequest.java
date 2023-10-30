package com.randou_tech.request.order;

import com.randou_tech.RdException;
import com.randou_tech.constants.OrderReviewConstants;
import com.randou_tech.request.WebServiceRequest;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrderReviewRequest extends WebServiceRequest {

    final protected String uri = "order/review";

    private String orderNo = "";
    private String bizNo = "";
    private Integer pass;
    private Integer reasonDisplay = 1;
    private Integer reasonType = 1;
    private String reasonDetail = "";

    public OrderReviewRequest setOrderNo(String $orderNo) {
        this.orderNo = $orderNo;
        return this;
    }

    public OrderReviewRequest setBizNo(String $bizNo) {
        this.bizNo = $bizNo;
        return this;
    }

    public OrderReviewRequest pass() {
        this.pass = OrderReviewConstants.PASS;
        return this;
    }

    public OrderReviewRequest unPass() {
        this.pass = OrderReviewConstants.UNPASS;
        return this;
    }


    public OrderReviewRequest setReasonDisplay(Integer reasonDisplay) {
        this.reasonDisplay = reasonDisplay;
        return this;
    }

    public OrderReviewRequest setReasonType(Integer reasonType) {
        this.reasonType = reasonType;
        return this;
    }

    public OrderReviewRequest setReasonDetail(String reason) {
        this.reasonDetail = reason;
        return this;
    }

    @Override
    public Map<String, String> getParameter() {
        Map<String, String> p = this.getEncryptParameter();
        p.put("sign", sign);

        return p;
    }

    @Override
    public Map<String, String> getEncryptParameter() {
        if (orderNo.isEmpty() && bizNo.isEmpty()) {
            throw new RdException("请至少传入一个订单号");
        }
        if (null == pass) {
            throw new RdException("请选择审核结果");
        }

        Map<String, String> param = new LinkedHashMap<>();
        param.put("appid", appid);
        param.put("nonce_str", nonce_str);
        param.put("timestamp", timestampStr);

        if (!orderNo.isEmpty()) {
            param.put("orderNo", orderNo);
        }
        if (!bizNo.isEmpty()) {
            param.put("bizNo", bizNo);
        }
        param.put("pass", pass.toString());

        if (pass.equals(OrderReviewConstants.UNPASS)) {
            param.put("reason_type", reasonType.toString());
            param.put("reason_display", reasonDisplay.toString());
            param.put("reason_detail", reasonDetail);
        }

        return param;
    }

    @Override
    public String getUri() {
        return String.format("/%s/%s", getUriVersion(), uri);
    }

    @Override
    public String getUriVersion() {
        return "v1";
    }
}
