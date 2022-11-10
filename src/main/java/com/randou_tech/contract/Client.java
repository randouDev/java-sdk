package com.randou_tech.contract;

public interface Client {
    /**
     * Switches to another users with specified credentials
     *
     * @param creds
     *            the credential to switch to。
     */
    public void switchCredentials(Credentials creds);



}
