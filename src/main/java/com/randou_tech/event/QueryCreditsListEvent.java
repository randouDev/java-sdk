package com.randou_tech.event;

import com.randou_tech.RdException;
import com.randou_tech.contract.BaseEvent;

import javax.servlet.http.HttpServletRequest;

/**
 * 积分明细查询事件
 */
public class QueryCreditsListEvent extends BaseEvent {
    public String uid;
    public String mall_no;
    public Integer page;
    public Integer pageSize;


    public QueryCreditsListEvent(HttpServletRequest request) {
        super(request);
    }


    public void parse() throws RdException {
        this.uid = request.getParameter("uid");
        this.mall_no = request.getParameter("mall_no");
        this.page = Integer.valueOf(request.getParameter("page"));
        this.pageSize = Integer.valueOf(request.getParameter("pageSize"));
    }

    @Override
    public String toString() {
        return "QueryCreditsListEvent{" +
                "uid='" + uid + '\'' +
                ", mall_no='" + mall_no + '\'' +
                ", page='" + page + '\'' +
                ", pageSize='" + pageSize + '\'' +
                '}';
    }
}
