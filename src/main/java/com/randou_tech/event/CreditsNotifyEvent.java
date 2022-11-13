package com.randou_tech.event;

import com.randou_tech.RdException;
import com.randou_tech.contract.BaseEvent;
import javax.servlet.http.HttpServletRequest;

/**
 * 订单结果通知事件
 */
public class CreditsNotifyEvent extends BaseEvent {

    /**
     * The Uid.
     */
    public String uid;
    /**
     * The Mall no.
     */
    public String mall_no;
    /**
     * The Order no.
     */
    public String orderNo;
    /**
     * The Biz no.
     */
    public String bizNo;
    /**
     * The Status.
     */
    public String status;
    /**
     * The Message.
     */
    public String message;

    /**
     * Instantiates a new Credits notify event.
     *
     * @param request the request
     */
    public CreditsNotifyEvent(HttpServletRequest request) {
        super(request);
    }


    public void parse() throws RdException {
        this.uid = request.getParameter("uid");
        this.mall_no = request.getParameter("mall_no");
        this.orderNo = request.getParameter("orderNo");
        this.bizNo = request.getParameter("bizNo");
        this.status = request.getParameter("status");
        this.message = request.getParameter("message");
    }

    @Override
    public String toString() {
        return "CreditsNotifyEvent{" +
            "uid='" + uid + '\'' +
            ", mall_no='" + mall_no + '\'' +
            ", orderNo='" + orderNo + '\'' +
            ", bizNo='" + bizNo + '\'' +
            ", status='" + status + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
