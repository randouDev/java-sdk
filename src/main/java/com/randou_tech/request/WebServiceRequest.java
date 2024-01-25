package com.randou_tech.request;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Map;

/**
 * The type Web service request.
 */
public abstract class WebServiceRequest {

    /**
     * The Appid.
     */
    protected String appid;
    /**
     * The Nonce str.
     */
    protected String nonce_str = RandomStringUtils.randomAlphanumeric(20);
    /**
     * The Timestamp str.
     */
    protected String timestampStr = System.currentTimeMillis() / 1000 + "";
    /**
     * The Sign.
     */
    protected String sign;
    /**
     * The Url str.
     */
    protected String url = "";


    /**
     * Sets sign.
     *
     * @param sign the sign
     */
    public void setSign(String sign)
    {
        this.sign = sign;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return
     */
    public String getUrl() {
        return this.url;
    }


    /**
     * Sets appid.
     *
     * @param appid the appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * Gets parameter.
     *
     * @return the parameter
     */
    public abstract Map<String, String> getParameter();

    /**
     * Gets encrypt parameter.
     *
     * @return the encrypt parameter
     */
    public abstract Map<String, String> getEncryptParameter();


    /**
     * Gets uri.
     *
     * @return the uri
     */
    public abstract String getUri();

    /**
     * Gets uri version.
     *
     * @return the uri version
     */
    public abstract String getUriVersion();

}
