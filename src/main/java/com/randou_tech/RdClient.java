package com.randou_tech;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.randou_tech.common.request.HttpResult;
import com.randou_tech.contract.Client;
import com.randou_tech.contract.Credentials;
import com.randou_tech.contract.Signer;
import com.randou_tech.event.CreditsIssueEvent;
import com.randou_tech.event.CreditsNotifyEvent;
import com.randou_tech.event.WithHoldingEvent;
import com.randou_tech.model.FreeLogin;
import com.randou_tech.request.FreeLoginDstRequest;
import com.randou_tech.common.operation.operation;
import com.randou_tech.result.Result;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.client.config.RequestConfig;

final public class RdClient implements Client {

    private String base_url = "https://openapi.randou-tech.com";
    private String base_url_debug = "http://openapi.test.randou-tech.cn";
    private Boolean debug = false;

    /* The default credentials provider */
    private Credentials creds;

    private Signer signature;

    private RequestConfig rc;

    public RdClient(Credentials creds, Signer signature, RequestConfig rc) {
        this.creds = creds;
        this.signature = signature;
        this.rc = rc;
    }

    public RdClient(Credentials creds, Signer signature) {
        this(creds, signature, null);
    }


    public void setDebug(Boolean debug) {
        this.debug = debug;
    }


    @Override
    public void switchCredentials(Credentials creds) {
        this.creds = creds;
    }

    /**
     * 获取免登地址
     *
     * @param request
     * @return
     * @throws RdException
     */
    public Result<FreeLogin> getFreeLoginDstRequest(FreeLoginDstRequest request) throws RdException {
        request.setAppid(creds.getAppId());
        request.setSign(signature.build(request, creds));

        HttpResult r = operation.freeLoginDst(request, rc);
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
     * @param request
     * @return
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
     * @param request
     * @return
     */
    public CreditsNotifyEvent creditsNotify(HttpServletRequest request) {
        if (!signature.verify(creds, request)) {
            throw new RdException("verify fail");
        }
        return new CreditsNotifyEvent(request);
    }

    /**
     * 解析加积分信息
     * @param request
     * @return
     */
    public CreditsIssueEvent creditsIssue(HttpServletRequest request) {
        if (!signature.verify(creds, request)) {
            throw new RdException("verify fail");
        }
        return new CreditsIssueEvent(request);
    }
}
