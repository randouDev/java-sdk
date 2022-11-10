package com.randou_tech.result;

public class Result<T> {
    /**
     * 接口内容对象
     */
    public T data;

    public T getData() {
        return data;
    }

    public static final Integer SUCCESS_CODE = 100000;

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public Result<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getError() {
        return error;
    }

    public Result<T> setError(String error) {
        this.error = error;
        return this;
    }

    public Integer code = 100000;

    public String error = "success";

    public boolean isSuc() {
        return SUCCESS_CODE.equals(code);
    }

    @Override
    public String toString() {
        return "Result{" +
            "code=" + code +
            ", error='" + error + '\'' +
            '}';
    }
}
