package com.randou_tech;

import com.randou_tech.contract.Credentials;

/**
 * 密钥
 */
public class ClientCredentials implements Credentials {
    final private String appId;
    final private String appSecret;

    @Override
    public String getAppId() {
        return appId;
    }

    @Override
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * create cred
     *
     * @param appId
     * @param appSecret
     */
    ClientCredentials(String appId, String appSecret) {
       this.appId=appId;
       this.appSecret=appSecret;
    }
}
