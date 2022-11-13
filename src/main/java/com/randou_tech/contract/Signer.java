package com.randou_tech.contract;

import com.randou_tech.request.WebServiceRequest;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * The interface Signer.
 */
public interface Signer {

    /**
     * Build string.
     *
     * @param request the request
     * @param cred    the cred
     * @return the string
     */
    String build(WebServiceRequest request, Credentials cred);

    /**
     * Build string.
     *
     * @param p    the p
     * @param cred the cred
     * @return the string
     */
    String build(Map<String, String> p, Credentials cred);

    /**
     * Verify boolean.
     *
     * @param cred    the cred
     * @param request the request
     * @return the boolean
     */
    boolean verify(Credentials cred, HttpServletRequest request);

    /**
     * Verify boolean.
     *
     * @param cred   the cred
     * @param params the params
     * @return the boolean
     */
    boolean verify(Credentials cred, Map<String, String> params);

}
