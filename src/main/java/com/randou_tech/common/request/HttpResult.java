package com.randou_tech.common.request;


/**
 * The type Http result.
 */
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

    /**
     * Instantiates a new Http result.
     */
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
     *
     * @return boolean boolean
     */
    public boolean isSuc() {
        return status / 100 % 10 == 2;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Gets string entity.
     *
     * @return the string entity
     */
    public String getStringEntity() {
        return stringEntity;
    }

    /**
     * Sets string entity.
     *
     * @param stringEntity the string entity
     */
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
