package com.randou_tech.model;

public class FreeLogin {
    /**
     * 免登地址
     */
    public String url;

    public String getDst()
    {
        return url;
    }

    @Override
    public String toString() {
        return "FreeLogin{" +
            "url='" + url + '\'' +
            '}';
    }
}
