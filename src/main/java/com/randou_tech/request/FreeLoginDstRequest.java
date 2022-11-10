package com.randou_tech.request;

import com.randou_tech.constants.RdConstants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 免登地址请求对象
 */
public class FreeLoginDstRequest extends WebServiceRequest {

    final protected String uri="autoLogin";
    private String uid = RdConstants.GUEST;
    private Integer credits = 0;
    private Integer grade = 1;
    private String redirect = "/";
    private String mall_no = "";


    public FreeLoginDstRequest() {
        super();
    }


    public FreeLoginDstRequest setCredits(Integer credits) {
        this.credits = credits;
        return this;
    }

    public FreeLoginDstRequest setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public FreeLoginDstRequest setRedirect(String redirect) {
        this.redirect = redirect;
        return this;
    }

    public FreeLoginDstRequest setMallNo(String mall_no) {
        this.mall_no = mall_no;
        return this;
    }

    public FreeLoginDstRequest setGrade(Integer grade) {
        this.grade = grade;
        return this;
    }

    public FreeLoginDstRequest setTimestampStr(String ts) {
        this.timestampStr = ts;
        return this;
    }


    public FreeLoginDstRequest setNonceStr(String str) {
        this.nonce_str = str;
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
        if (mall_no.isEmpty()) {
            throw new IllegalArgumentException("缺少必要参数");
        }

        Map<String, String> param = new LinkedHashMap<>();
        param.put("uid",uid);
        param.put("credits", credits.toString());
        param.put("grade", grade.toString());
        param.put("redirect", redirect);
        param.put("mall_no", mall_no);
        param.put("appid", appid);
        param.put("nonce_str", nonce_str);
        param.put("timestamp", timestampStr);

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
