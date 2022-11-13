package com.randou_tech.common.operation;

import com.randou_tech.common.request.HttpClient;
import com.randou_tech.common.request.HttpResult;
import com.randou_tech.common.utils.Util;
import com.randou_tech.constants.RdConstants;
import com.randou_tech.request.WebServiceRequest;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.config.RequestConfig;

/**
 * The type Operation.
 */
public class operation {

    /**
     * 请求免登地址
     *
     * @param request the request
     * @param rc      the rc
     * @return HttpResult http result
     */
    public static HttpResult freeLoginDst(WebServiceRequest request, RequestConfig rc) {
        String url = String.format("%s%s", RdConstants.DOMAIN_API, request.getUri());
        Map<String,String> params = request.getParameter();
        Map<String, String> headers = new HashMap<>();
        headers.put("user-agent", Util.getUa());

        return HttpClient.doGet(url, params, headers, rc);
    }
}
