package com.randou_tech.event;

/**
 * 订单详情
 */
public class LinkGameDetail {

    /**
     * link game title
     */
    public String title;
    /**
     * link game uniqueID.
     */
    public String uniqueID;

    @Override
    public String toString() {
        return "LinkGameDetail{" +
            "title='" + title + '\'' +
            ", uniqueID='" + uniqueID + '\'' +
            '}';
    }
}
