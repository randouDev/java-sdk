package com.randou_tech.event;

import com.alibaba.fastjson.JSONObject;
import com.randou_tech.RdException;
import com.randou_tech.constants.RdConstants;
import com.randou_tech.contract.BaseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 * 积分预扣事件
 */
public class WithHoldingEvent extends BaseEvent {
    public String uid;
    public String mall_no;
    public Integer credits;
    public String orderNo;
    public Date created_at;
    public String type;
    public String description;
    public Integer subsidy_fee;
    public String ip;
    public RedeemDetail redeem_detail;

    public WithHoldingEvent(HttpServletRequest request) {
        super(request);
    }


    public void parse() throws RdException {
        this.uid = request.getParameter("uid");
        this.mall_no = request.getParameter("mall_no");
        this.credits = Integer.valueOf(request.getParameter("credits"));
        this.orderNo = request.getParameter("orderNo");
        this.type = request.getParameter("type");
        this.description = request.getParameter("description");
        this.subsidy_fee = Integer.valueOf(request.getParameter("subsidy_fee"));
        this.ip = request.getParameter("ip");

        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        try {
            this.created_at = formatter.parse(request.getParameter("created_at"));
        } catch (ParseException e) {
            throw new RdException("parse created_at fail");
        }

        if (this.type.equals(RdConstants.WITHHOLDING_TYPE_REDEEM)) {
//            解析json
            this.redeem_detail = JSONObject.parseObject(request.getParameter("redeem_detail"), RedeemDetail.class);
        }
    }

    @Override
    public String toString() {
        return "WithHoldingEvent{" +
            "uid='" + uid + '\'' +
            ", mall_no='" + mall_no + '\'' +
            ", credits=" + credits +
            ", orderNo='" + orderNo + '\'' +
            ", created_at='" + created_at.toString() + '\'' +
            ", type='" + type + '\'' +
            ", description='" + description + '\'' +
            ", subsidy_fee=" + subsidy_fee +
            ", ip='" + ip + '\'' +
            ", redeem_detail=" + redeem_detail.toString() +
            '}';
    }
}
