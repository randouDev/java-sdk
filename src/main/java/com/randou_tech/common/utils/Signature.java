package com.randou_tech.common.utils;

import com.randou_tech.RdException;
import com.randou_tech.contract.Credentials;
import com.randou_tech.contract.Signer;
import com.randou_tech.request.WebServiceRequest;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * The type Signature.
 */
public class Signature implements Signer {

    public String build(WebServiceRequest request, Credentials cred) {
        return build(request.getEncryptParameter(), cred);
    }

    public String build(Map<String, String> p, Credentials cred) {
        List<String> keyList = new ArrayList<>(p.keySet());
        Collections.sort(keyList);

        StringBuilder sf = new StringBuilder();
        for (String key : keyList) {
            sf.append(key).append("=").append(p.get(key)).append("&");
        }
        sf.append("app_secret").append("=").append(cred.getAppSecret());

        return DigestUtils.md5Hex(sf.toString().getBytes());
    }

    public boolean verify(Credentials cred, HttpServletRequest request) {
        return verify(cred, getParameterMap(request));
    }


    private Map<String, String> getParameterMap(HttpServletRequest request) {
        Map<?, ?> properties = request.getParameterMap();
        // 返回值Map
        Map<String, String> returnMap = new HashMap<>();
        Iterator<?> entries = properties.entrySet().iterator();
        Map.Entry<?, ?> entry;
        String name;
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry<?, ?>)entries.next();
            name = (String)entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for (String s : values) {
                    value = s + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

    public boolean verify(Credentials cred, Map<String, String> params) {
        if (
            !params.containsKey("appid") || !params.containsKey("timestamp") ||
            !params.containsKey("nonce_str") || !params.containsKey("sign")
        ) {
            throw new RdException("param is not enough");
        }
        if (!cred.getAppId().equals(params.get("appid"))) {
            throw new RdException("check appid fail");
        }
        Map<String, String> m = new HashMap<>();

        for(String key : params.keySet()){
            if(!key.equals("sign")){
                m.put(key, params.get(key));
            }
        }
        String sign = build(m, cred);
        return sign.equals(params.get("sign"));
    }
}
