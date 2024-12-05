package com.randou_tech.event;

import com.alibaba.fastjson.JSONObject;
import com.randou_tech.RdException;
import com.randou_tech.constants.BooleanConstant;
import com.randou_tech.contract.BaseEvent;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 抽奖事件
 */
public class DrawingPrizeEvent extends BaseEvent {
    public String uid;

    public String mall_no;

    public Integer credits;

    public String serialNo;

    public Date created_at;

    public DrawingGameDetail drawinggame_detail;

    public String hit;

    public String receive;

    public DrawingGamePrize prize;


    public DrawingPrizeEvent(HttpServletRequest request) {
        super(request);
    }

    public DrawingPrizeEvent(Map<String, String> param) {
        super(param);
    }

    public void parse() throws RdException {
        this.uid = getParam("uid");
        this.mall_no = getParam("mall_no");
        this.credits = Integer.valueOf(getParam("credits"));
        this.serialNo = getParam("serialNo");

        String hit = getParam("hit");
        if (!hit.equals(BooleanConstant.NO) && !hit.equals(BooleanConstant.YES)) {
            throw new RdException("hit field is illegal");
        }
        this.hit = hit;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.created_at = formatter.parse(getParam("created_at"));
        } catch (ParseException e) {
            throw new RdException("created_at field is illegal");
        }

        this.drawinggame_detail = JSONObject.parseObject(getParam("drawinggame_detail"), DrawingGameDetail.class);


        if (this.isHit()) {
            String r = getParam("receive");
            if (!r.equals(BooleanConstant.NO) && !r.equals(BooleanConstant.YES)) {
                throw new RdException("prize.receive field is illegal");
            }
            this.receive = r;

            this.prize = JSONObject.parseObject(getParam("prize"), DrawingGamePrize.class);

//            if (this.isReceive() && this.isGoodsPrize()) {
//                String or = getParam("order_result");
//                if (!or.equals("success") && !or.equals("fail")) {
//                    throw new RdException("order_result field is illegal");
//                }
//                this.order_result = or;
//            }
        }
    }

    /**
     * 是否中奖
     *
     * @return Boolean
     */
    public Boolean isHit() {
        return this.hit.equals(BooleanConstant.YES);
    }

    /**
     * 是否领取了奖品
     *
     * @return Boolean
     */
    public Boolean isReceive() {
        if (!this.isHit()) {
            return false;
        }

        return this.receive.equals(BooleanConstant.YES);
    }

    /**
     * 是否积分类奖品
     *
     * @return Boolean
     */
    public Boolean isCreditsPrize() {
        if (!this.isHit()) {
            return false;
        }

        return this.prize.type.equals("CREDITS");
    }


    /**
     * 是否积分类奖品
     *
     * @return Boolean
     */
    public Boolean isGoodsPrize() {
        if (!this.isHit()) {
            return false;
        }

        return this.prize.type.equals("GOODS_MATERIAL") || this.prize.type.equals("GOODS_COUPON") || this.prize.type.equals("GOODS_CHARGE");
    }


    /**
     * 是否积分类奖品
     *
     * @return Boolean
     */
    public Boolean isFreeDrawPrize() {
        if (!this.isHit()) {
            return false;
        }

        return this.prize.type.equals("FREE_DRAW");
    }

    /**
     * 获取商品类奖品的商品
     *
     * @return GoodsSimpleInfo
     */
    public GoodsSimpleInfo getGoodsPrize() {
        if (!this.isReceive() || !this.isGoodsPrize()) {
            return null;
        }

        return this.prize.goods;
    }

    /**
     * 获取积分类奖品的积分数量
     *
     * @return Integer
     */
    public Integer getCreditsGain() {
        if (!this.isReceive() || !this.isCreditsPrize()) {
            return null;
        }

        return this.prize.credits_gain;
    }

    /**
     * 获取奖品
     *
     * @return DrawingGamePrize
     */
    public DrawingGamePrize getPrize() {
        if (!this.isHit()) {
            return null;
        }

        return this.prize;
    }

    /**
     * 商品类奖品是否发放成功
     *
     * @return Boolean
     */
    public Boolean isPrizeGoodsOrderSuccess() {
        if (!this.isReceive() || !this.isGoodsPrize()) {
            return null;
        }

        return this.prize.order_result.equals("success");
    }

    @Override
    public String toString() {
        return "DrawingPrizeEvent{" +
                "uid='" + uid + '\'' +
                ", mall_no='" + mall_no + '\'' +
                ", credits=" + credits +
                ", serialNo='" + serialNo + '\'' +
                ", hit='" + hit + '\'' +
                ", receive='" + receive + '\'' +
                ", created_at='" + created_at.toString() + '\'' +
                ", drawinggame_detail=" + (drawinggame_detail != null ? drawinggame_detail.toString() : "null") +
                ", prize=" + (prize != null ? prize.toString() : "null") + '\'' +
                '}';
    }
}
