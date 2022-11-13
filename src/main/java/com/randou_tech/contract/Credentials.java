package com.randou_tech.contract;

/**
 * The interface Credentials.
 */
public interface Credentials {

    /**
     * Returns the appid for this credentials.
     *
     * @return the app id
     */
    public String getAppId();

    /**
     * Returns the app access key for this credentials.
     *
     * @return the app secret
     */
    public String getAppSecret();
}
