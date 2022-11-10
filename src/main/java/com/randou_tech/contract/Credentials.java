package com.randou_tech.contract;

public interface Credentials {
    /**
     * Returns the appid for this credentials.
     */
    public String getAppId();

    /**
     * Returns the app access key for this credentials.
     */
    public String getAppSecret();
}
