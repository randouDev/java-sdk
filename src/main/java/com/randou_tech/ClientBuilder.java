package com.randou_tech;

import com.randou_tech.common.utils.Signature;
import com.randou_tech.contract.Credentials;

/**
 * The type Client builder.
 */
public class ClientBuilder {


    /**
     * Build rd client.
     *
     * @param appId     the app id
     * @param appSecret the app secret
     * @return the rd client
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
