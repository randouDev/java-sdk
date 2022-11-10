package com.randou_tech.contract;

import com.randou_tech.RdException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;

/**
 * 事件
 */
public abstract class BaseEvent {
    public HttpServletRequest request;

    protected BaseEvent(HttpServletRequest request) {
        this.request = request;
        parse();
    }

    public abstract void parse() throws RdException;
}
