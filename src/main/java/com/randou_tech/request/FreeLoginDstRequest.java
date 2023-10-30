package com.randou_tech.request;

import com.randou_tech.RdException;
import com.randou_tech.constants.RdConstants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 免登地址请求对象
 */
public class FreeLoginDstRequest extends WebServiceRequest {

    /**
     * The Uri.
     */
    final protected String uri="autoLogin";
    private String uid = RdConstants.GUEST;
    private Integer credits = 0;
    private Integer grade = 1;
    private String redirect = "/";
    private String mall_no = "";


    /**
     * Instantiates a new Free login dst request.
     */
    public FreeLoginDstRequest() {
        super();
    }


    /**
     * Sets credits.
     *
     * @param credits the credits
     * @return the credits
     */
    public FreeLoginDstRequest setCredits(Integer credits) {
        this.credits = credits;
        return this;
    }

    /**
     * Sets uid.
     *
     * @param uid the uid
     * @return the uid
     */
    public FreeLoginDstRequest setUid(String uid) {
        this.uid = uid;
        return this;
    }

    /**
     * Sets redirect.
     *
     * @param redirect the redirect
     * @return the redirect
     */
    public FreeLoginDstRequest setRedirect(String redirect) {
        this.redirect = redirect;
        return this;
    }

    /**
     * Sets mall no.
     *
     * @param mall_no the mall no
     * @return the mall no
     */
    public FreeLoginDstRequest setMallNo(String mall_no) {
        this.mall_no = mall_no;
        return this;
    }

    /**
     * Sets grade.
     *
     * @param grade the grade
     * @return the grade
     */
    public FreeLoginDstRequest setGrade(Integer grade) {
        this.grade = grade;
        return this;
    }

    /**
     * Sets timestamp str.
     *
     * @param ts the ts
     * @return the timestamp str
     */
    public FreeLoginDstRequest setTimestampStr(String ts) {
        this.timestampStr = ts;
        return this;
    }


    /**
     * Sets nonce str.
     *
     * @param str the str
     * @return the nonce str
     */
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
            throw new RdException("缺少必要参数");
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
