package com.randou_tech.event;

import com.randou_tech.RdException;
import com.randou_tech.contract.BaseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 * 加积分事件
 */
public class CreditsIssueEvent extends BaseEvent {
    public String uid;
    public String mall_no;
    public Integer credits;
    public String unique_no;
    public Date created_at;
    public String type;
    public String description;
    public String ip;

    public CreditsIssueEvent(HttpServletRequest request) {
        super(request);
    }


    public void parse() throws RdException {
        this.uid = request.getParameter("uid");
        this.mall_no = request.getParameter("mall_no");
        this.credits = Integer.valueOf(request.getParameter("credits"));
        this.unique_no = request.getParameter("unique_no");
        this.type = request.getParameter("type");
        this.description = request.getParameter("description");
        this.ip = request.getParameter("ip");

        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        try {
            this.created_at = formatter.parse(request.getParameter("created_at"));
        } catch (ParseException e) {
            throw new RdException("parse created_at fail");
        }
    }

    @Override
    public String toString() {
        return "CreditsIssueEvent{" +
            "uid='" + uid + '\'' +
            ", mall_no='" + mall_no + '\'' +
            ", credits=" + credits +
            ", unique_no='" + unique_no + '\'' +
            ", created_at=" + created_at +
            ", type='" + type + '\'' +
            ", description='" + description + '\'' +
            ", ip='" + ip + '\'' +
            '}';
    }
}
