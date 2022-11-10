package com.randou_tech.common.utils;

import com.randou_tech.constants.RdConstants;

public class Util {
    /**
     * system info for ua
     * @return
     */
    public static String getUa() {
        return String.format("Randou JAVA SDK/%s (%s/%s/%s;%s)", RdConstants.VERSION,System.getProperty("os.name"), System.getProperty("os.version"), System.getProperty("os.arch"), System.getProperty("java.version"));
    }
}
