package com.randou_tech.event;

/**
 * 订单详情
 */
public class DrawingGameDetail {

    /**
     * drawing game title
     */
    public String title;
    /**
     * drawing game uniqueID.
     */
    public String uniqueID;

    @Override
    public String toString() {
        return "DrawingGameDetail{" +
            "title='" + title + '\'' +
            ", uniqueID='" + uniqueID + '\'' +
            '}';
    }
}
