package com.randou_tech.common.request;

/**
 * The type Http config.
 */
class HttpConfig {
    /**
     * 返回从连接管理器请求连接时使用的超时时间（以毫秒为单位）。
     * 默认值： 5s
     */
    private int connectionRequestTimeout = 5000;

    /**
     * 连接超时：连接一个url的连接等待时间
     * 默认值： 5s
     */
    private int connectTimeout = 5000;

    /**
     * 读取数据超时
     * 默认值： 10s
     */
    private int socketTimeout = 10000;

    /**
     * 客户端总并行链接最大数
     */
    private int maxTotal = 10;

    /**
     * 客户端每个路由最高链接最大数
     */
    private int maxPreRoute = 2;

    /**
     * 连接存活时长：秒
     */
    private long connectionTimeToLive = 60;

    /**
     * 重试尝试最大次数
     * 默认为3
     */
    private int retryCount = 3;

    /**
     * 非幂等请求是否可以重试
     * 默认不开启
     */
    private boolean requestSentRetryEnabled = false;

    /**
     * Gets connection request timeout.
     *
     * @return the connection request timeout
     */
    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    /**
     * Sets connection request timeout.
     *
     * @param connectionRequestTimeout the connection request timeout
     */
    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    /**
     * Gets connect timeout.
     *
     * @return the connect timeout
     */
    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Sets connect timeout.
     *
     * @param connectTimeout the connect timeout
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    /**
     * Gets socket timeout.
     *
     * @return the socket timeout
     */
    public int getSocketTimeout() {
        return socketTimeout;
    }

    /**
     * Sets socket timeout.
     *
     * @param socketTimeout the socket timeout
     */
    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    /**
     * Gets max total.
     *
     * @return the max total
     */
    public int getMaxTotal() {
        return maxTotal;
    }

    /**
     * Sets max total.
     *
     * @param maxTotal the max total
     */
    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    /**
     * Gets max pre route.
     *
     * @return the max pre route
     */
    public int getMaxPreRoute() {
        return maxPreRoute;
    }

    /**
     * Sets max pre route.
     *
     * @param maxPreRoute the max pre route
     */
    public void setMaxPreRoute(int maxPreRoute) {
        this.maxPreRoute = maxPreRoute;
    }

    /**
     * Gets connection time to live.
     *
     * @return the connection time to live
     */
    public long getConnectionTimeToLive() {
        return connectionTimeToLive;
    }

    /**
     * Sets connection time to live.
     *
     * @param connectionTimeToLive the connection time to live
     */
    public void setConnectionTimeToLive(long connectionTimeToLive) {
        this.connectionTimeToLive = connectionTimeToLive;
    }

    /**
     * Gets retry count.
     *
     * @return the retry count
     */
    public int getRetryCount() {
        return retryCount;
    }

    /**
     * Sets retry count.
     *
     * @param retryCount the retry count
     */
    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    /**
     * Is request sent retry enabled boolean.
     *
     * @return the boolean
     */
    public boolean isRequestSentRetryEnabled() {
        return requestSentRetryEnabled;
    }

    /**
     * Sets request sent retry enabled.
     *
     * @param requestSentRetryEnabled the request sent retry enabled
     */
    public void setRequestSentRetryEnabled(boolean requestSentRetryEnabled) {
        this.requestSentRetryEnabled = requestSentRetryEnabled;
    }
}
