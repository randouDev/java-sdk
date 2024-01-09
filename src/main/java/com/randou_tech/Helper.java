package com.randou_tech;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class Helper {
    public static String listToJson(ArrayList<?> list) {
        return JSONObject.toJSONString(list);
    }
}
