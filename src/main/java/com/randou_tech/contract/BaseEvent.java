package com.randou_tech.contract;

import com.randou_tech.RdException;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 事件
 */
public abstract class BaseEvent {

    /**
     * The Request.
     */
    public HttpServletRequest request;

    /**
     * The param
     */
    public Map<String, String> param;


    /**
     * Instantiates a new Base event.
     *
     * @param request the request
     */
    protected BaseEvent(HttpServletRequest request) {
        this.request = request;
        parse();
    }

    protected BaseEvent(Map<String, String> param) {
        this.param = param;
        parse();
    }

    protected String getParam(String key) {
        if (null != request) {
            return request.getParameter(key);
        }

        return param.get(key);
    }

    /**
     * Parse.
     *
     * @throws RdException the rd exception
     */
    public abstract void parse() throws RdException;
}
