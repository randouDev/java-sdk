package com.randou_tech.contract;

import com.randou_tech.request.WebServiceRequest;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface Signer {

    String build(WebServiceRequest request, Credentials cred);

    String build(Map<String, String> p, Credentials cred);

    boolean verify(Credentials cred, HttpServletRequest request);

    boolean verify(Credentials cred, Map<String, String> params);

}
