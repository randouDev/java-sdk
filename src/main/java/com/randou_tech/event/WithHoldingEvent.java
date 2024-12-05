package com.randou_tech.event;

import com.alibaba.fastjson.JSONObject;
import com.randou_tech.RdException;
import com.randou_tech.constants.RdConstants;
import com.randou_tech.contract.BaseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 积分预扣事件
 */
public class WithHoldingEvent extends BaseEvent {

    /**
     * The Uid.
     */
    public String uid;
    /**
     * The Mall no.
     */
    public String mall_no;
    /**
     * The Credits.
     */
    public Integer credits;
    /**
     * The Order no.
     */
    public String orderNo;
    /**
     * The Created at.
     */
    public Date created_at;
    /**
     * The Type.
     */
    public String type;
    /**
     * The Description.
     */
    public String description;
    /**
     * The Ip.
     */
    public String ip;
    /**
     * The Redeem detail.
     */
    public RedeemDetail redeem_detail;
    /**
     * The drawing game detail.
     */
    public DrawingGameDetail drawinggame_detail;
    /**
     * The link game detail.
     */
    public LinkGameDetail linkgame_detail;

    /**
     * Instantiates a new With holding event.
     *
     * @param request the request
     */
    public WithHoldingEvent(HttpServletRequest request) {
        super(request);
    }

    public WithHoldingEvent(Map<String, String> param) {
        super(param);
    }

    public void parse() throws RdException {
        this.uid = getParam("uid");
        this.mall_no = getParam("mall_no");
        this.credits = Integer.valueOf(getParam("credits"));
        this.orderNo = getParam("orderNo");
        this.type = getParam("type");
        this.description = getParam("description");
        this.ip = getParam("ip");

        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        try {
            this.created_at = formatter.parse(getParam("created_at"));
        } catch (ParseException e) {
            throw new RdException("parse created_at fail");
        }

        if (this.type.equals(RdConstants.WITHHOLDING_TYPE_REDEEM)) {
//            解析json
            this.redeem_detail = JSONObject.parseObject(getParam("redeem_detail"), RedeemDetail.class);
        } else if (this.type.equals(RdConstants.WITHHOLDING_TYPE_DRAWINGGAME)) {
            this.drawinggame_detail = JSONObject.parseObject(getParam("drawinggame_detail"), DrawingGameDetail.class);
        } else if (this.type.equals(RdConstants.WITHHOLDING_TYPE_LINKGAME)) {
            this.linkgame_detail = JSONObject.parseObject(getParam("linkgame_detail"), LinkGameDetail.class);
        }
    }

    @Override
    public String toString() {
        return "WithHoldingEvent{" +
            "uid='" + uid + '\'' +
            ", mall_no='" + mall_no + '\'' +
            ", credits=" + credits + '\'' +
            ", orderNo='" + orderNo + '\'' +
            ", created_at='" + created_at.toString() + '\'' +
            ", type='" + type + '\'' +
            ", description='" + description + '\'' +
            ", ip='" + ip + '\'' +
            ", redeem_detail=" + (redeem_detail != null ? redeem_detail.toString() : "null") + '\'' +
            ", drawinggame_detail=" + (drawinggame_detail != null ? drawinggame_detail.toString() : "null") + '\'' +
            ", linkgame_detail=" + (linkgame_detail != null ? linkgame_detail.toString() : "null") + '\'' +
        '}';
    }
}
