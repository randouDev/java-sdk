package com.randou_tech;

import com.randou_tech.common.utils.Signature;
import com.randou_tech.contract.Credentials;

public class ClientBuilder {
    /**
     * create default RdClient
     *
     * @param appId
     * @param appSecret
     * @return RdClient
     */
    public static RdClient build(String appId, String appSecret) {
        return new RdClient(getCredentials(appId,appSecret), getDefaultSignature());
    }

    private static Credentials getCredentials(String appId, String appSecret) {
        return new ClientCredentials(appId, appSecret);
    }

    private static Signature getDefaultSignature(){
        return new Signature();
    }
}
