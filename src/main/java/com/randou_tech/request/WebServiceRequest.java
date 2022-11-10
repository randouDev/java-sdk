package com.randou_tech.request;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Map;

public abstract class WebServiceRequest {

    protected String appid;
    protected String nonce_str = RandomStringUtils.randomAlphanumeric(20);
    protected String timestampStr = System.currentTimeMillis() / 1000 + "";
    protected String sign;


    public void setSign(String sign)
    {
        this.sign = sign;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public abstract Map<String, String> getParameter();

    public abstract Map<String, String> getEncryptParameter();


    public abstract String getUri();

    public abstract String getUriVersion();

}
