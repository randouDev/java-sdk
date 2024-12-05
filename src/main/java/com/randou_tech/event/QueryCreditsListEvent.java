package com.randou_tech.event;

import com.randou_tech.RdException;
import com.randou_tech.contract.BaseEvent;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    public QueryCreditsListEvent(Map<String, String> param) {
        super(param);
    }

    public void parse() throws RdException {
        this.uid = getParam("uid");
        this.mall_no = getParam("mall_no");
        this.page = Integer.valueOf(getParam("page"));
        this.pageSize = Integer.valueOf(getParam("pageSize"));
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
