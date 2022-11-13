package com.randou_tech.result;

/**
 * The type Result.
 *
 * @param <T> the type parameter
 */
public class Result<T> {

    /**
     * 接口内容对象
     */
    public T data;

    /**
     * Gets data.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * The constant SUCCESS_CODE.
     */
    public static final Integer SUCCESS_CODE = 100000;

    /**
     * Sets data.
     *
     * @param data the data
     * @return the data
     */
    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     * @return the code
     */
    public Result<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    /**
     * Gets error.
     *
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * Sets error.
     *
     * @param error the error
     * @return the error
     */
    public Result<T> setError(String error) {
        this.error = error;
        return this;
    }

    /**
     * The Code.
     */
    public Integer code = 100000;

    /**
     * The Error.
     */
    public String error = "success";

    /**
     * Is suc boolean.
     *
     * @return the boolean
     */
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
