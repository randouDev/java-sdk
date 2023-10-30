package com.randou_tech.request.order;

import com.randou_tech.RdException;
import com.randou_tech.request.WebServiceRequest;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrderShippingRequest extends WebServiceRequest {

    final protected String uri = "order/shipping";

    private String shipping_company = "";
    private String shipping_no = "";
    private String orderNo = "";
    private String bizNo = "";


    public OrderShippingRequest setShippingCompany(String $shipping_company) {
        this.shipping_company = $shipping_company;
        return this;
    }


    public OrderShippingRequest setShippingNo(String $shipping_no) {
        this.shipping_no = $shipping_no;
        return this;
    }

    public OrderShippingRequest setOrderNo(String $orderNo) {
        this.orderNo = $orderNo;
        return this;
    }

    public OrderShippingRequest setBizNo(String $bizNo) {
        this.bizNo = $bizNo;
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
        if (shipping_company.isEmpty() || shipping_no.isEmpty()) {
            throw new RdException("请填写快递公司和快递编号");
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
        param.put("shipping_company", shipping_company);
        param.put("shipping_no", shipping_no);

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
