package com.randou_tech;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.randou_tech.common.request.HttpResult;
import com.randou_tech.constants.RdConstants;
import com.randou_tech.contract.Client;
import com.randou_tech.contract.Credentials;
import com.randou_tech.contract.Signer;
import com.randou_tech.event.*;
import com.randou_tech.model.FreeLogin;
import com.randou_tech.model.Order;
import com.randou_tech.request.FreeLoginDstRequest;
import com.randou_tech.common.operation.operation;
import com.randou_tech.request.order.OrderReviewRequest;
import com.randou_tech.request.order.OrderShippingCancelRequest;
import com.randou_tech.request.order.OrderShippingRequest;
import com.randou_tech.result.Result;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.client.config.RequestConfig;

/**
 * The type Rd client.
 */
final public class RdClient implements Client {
    /* The default credentials provider */
    private Credentials creds;

    private Signer signature;

    private RequestConfig rc;

    private Boolean debug = false;


    /**
     * Instantiates a new Rd client.
     *
     * @param creds     the creds
     * @param signature the signature
     * @param rc        the rc
     */
    public RdClient(Credentials creds, Signer signature, RequestConfig rc) {
        this.creds = creds;
        this.signature = signature;
        this.rc = rc;
    }

    /**
     * Instantiates a new Rd client.
     *
     * @param creds     the creds
     * @param signature the signature
     */
    public RdClient(Credentials creds, Signer signature) {
        this(creds, signature, null);
    }

    /**
     * get dest url
     * @return
     */
    private String getUrl() {
        return debug ? RdConstants.DEBUG_DOMAIN_API : RdConstants.DOMAIN_API;
    }

    /**
     * switch env
     * @param debug
     * @return
     */
    public RdClient setDebug(Boolean debug) {
        this.debug = debug;
        return this;
    }



    @Override
    public void switchCredentials(Credentials creds) {
        this.creds = creds;
    }

    /**
     * 获取免登地址
     *
     * @param request the request
     * @return free login dst request
     * @throws RdException the rd exception
     */
    public Result<FreeLogin> getFreeLoginDstRequest(FreeLoginDstRequest request) throws RdException {
        request.setAppid(creds.getAppId());
        request.setSign(signature.build(request, creds));
        request.setUrl(getUrl());

        HttpResult r = operation.assamble(request, rc);
        if (!r.isSuc()) {
            return JSONObject.parseObject(r.getStringEntity(), new TypeReference<Result<FreeLogin>>(){});
        }
        return new Result<FreeLogin>().setData(JSONObject.parseObject(r.getStringEntity(), FreeLogin.class));
    }


    /**
     * 获取签名
     *
     * @param request
     * @return String
     */
    private String getSignature(FreeLoginDstRequest request) {
        request.setAppid(creds.getAppId());
        return signature.build(request, creds);
    }

    /**
     * 解析预扣信息
     *
     * @param request the request
     * @return with holding event
     */
    public WithHoldingEvent withHolding(HttpServletRequest request) {
        if (!signature.verify(creds, request)) {
            throw new RdException("verify fail");
        }
        return new WithHoldingEvent(request);
    }

    /**
     * 解析预扣通知
     *
     * @param request the request
     * @return credits notify event
     */
    public CreditsNotifyEvent creditsNotify(HttpServletRequest request) {
        if (!signature.verify(creds, request)) {
            throw new RdException("verify fail");
        }
        return new CreditsNotifyEvent(request);
    }

    /**
     * 解析加积分信息
     *
     * @param request the request
     * @return credits issue event
     */
    public CreditsIssueEvent creditsIssue(HttpServletRequest request) {
        if (!signature.verify(creds, request)) {
            throw new RdException("verify fail");
        }
        return new CreditsIssueEvent(request);
    }

    /**
     * 商品快递发货
     *
     * @param request
     * @return
     * @throws RdException
     */
    public Result<Order> orderShipping(OrderShippingRequest request) throws RdException {
        request.setAppid(creds.getAppId());
        request.setSign(signature.build(request, creds));
        request.setUrl(getUrl());

        HttpResult r = operation.assamble(request, rc);
        if (!r.isSuc()) {
            return JSONObject.parseObject(r.getStringEntity(), new TypeReference<Result<Order>>() {
            });
        }
        return new Result<Order>().setData(JSONObject.parseObject(r.getStringEntity(), Order.class));
    }

    /**
     * 商品审核
     *
     * @param request
     * @return
     * @throws RdException
     */
    public Result<Order> orderReview(OrderReviewRequest request) throws RdException {
        request.setAppid(creds.getAppId());
        request.setSign(signature.build(request, creds));
        request.setUrl(getUrl());

        HttpResult r = operation.assamble(request, rc);
        if (!r.isSuc()) {
            return JSONObject.parseObject(r.getStringEntity(), new TypeReference<Result<Order>>() {
            });
        }
        return new Result<Order>().setData(JSONObject.parseObject(r.getStringEntity(), Order.class));
    }

    /**
     * 商品取消发货
     *
     * @param request
     * @return
     * @throws RdException
     */
    public Result<Order> orderShippingCancel(OrderShippingCancelRequest request) throws RdException {
        request.setAppid(creds.getAppId());
        request.setSign(signature.build(request, creds));
        request.setUrl(getUrl());

        HttpResult r = operation.assamble(request, rc);
        if (!r.isSuc()) {
            return JSONObject.parseObject(r.getStringEntity(), new TypeReference<Result<Order>>() {
            });
        }
        return new Result<Order>().setData(JSONObject.parseObject(r.getStringEntity(), Order.class));
    }

    /**
     * 解析商品直冲事件
     *
     * @param request
     * @return
     */
    public GoodsChargeEvent charge(HttpServletRequest request) {
        if (!signature.verify(creds, request)) {
            throw new RdException("verify fail");
        }
        return new GoodsChargeEvent(request);
    }

    /**
     * 解析直冲商品结果查询事件
     *
     * @param request
     * @return
     */
    public GoodsChargeQueryEvent chargeQuery(HttpServletRequest request) {
        if (!signature.verify(creds, request)) {
            throw new RdException("verify fail");
        }
        return new GoodsChargeQueryEvent(request);
    }


    /**
     * 解析积分明细查询事件
     *
     * @param request
     * @return
     */
    public QueryCreditsListEvent queryCreditsList(HttpServletRequest request) {
        if (!signature.verify(creds, request)) {
            throw new RdException("verify fail");
        }
        return new QueryCreditsListEvent(request);
    }


    /**
     * 解析抽奖通知
     *
     * @param request
     * @return DrawingPrizeEvent
     */
    public DrawingPrizeEvent drawingGameSubscription(HttpServletRequest request) {
        if (!signature.verify(creds, request)) {
            throw new RdException("verify fail");
        }
        return new DrawingPrizeEvent(request);
    }
}
