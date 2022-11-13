package com.randou_tech.model;

/**
 * The type Free login.
 */
public class FreeLogin {

    /**
     * 免登地址
     */
    public String url;

    /**
     * Gets dst.
     *
     * @return the dst
     */
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
