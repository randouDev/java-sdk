package com.randou_tech.contract;

import com.randou_tech.RdException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;

/**
 * 事件
 */
public abstract class BaseEvent {

    /**
     * The Request.
     */
    public HttpServletRequest request;

    /**
     * Instantiates a new Base event.
     *
     * @param request the request
     */
    protected BaseEvent(HttpServletRequest request) {
        this.request = request;
        parse();
    }

    /**
     * Parse.
     *
     * @throws RdException the rd exception
     */
    public abstract void parse() throws RdException;
}
