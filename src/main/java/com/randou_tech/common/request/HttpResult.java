package com.randou_tech.common.request;


public class HttpResult {
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 返回数据
     */
    private String stringEntity;

//    private Map<String, String> data;

    public HttpResult() {
    }

    /**
     * http请求返回对象
     *
     * @param status       返回状态
     * @param stringEntity 返回数据
     */
    public HttpResult(Integer status, String stringEntity) {
        this.status = status;
        this.stringEntity = stringEntity;
    }

    /**
     * 判断返回码是否正常
     * @return boolean
     */
    public boolean isSuc() {
        return status / 100 % 10 == 2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStringEntity() {
        return stringEntity;
    }

    public void setStringEntity(String stringEntity) {
        this.stringEntity = stringEntity;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "status=" + status +
                ", stringEntity='" + stringEntity + '\'' +
                '}';
    }
}
