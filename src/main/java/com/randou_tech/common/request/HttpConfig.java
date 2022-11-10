package com.randou_tech.common.request;

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

    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxPreRoute() {
        return maxPreRoute;
    }

    public void setMaxPreRoute(int maxPreRoute) {
        this.maxPreRoute = maxPreRoute;
    }

    public long getConnectionTimeToLive() {
        return connectionTimeToLive;
    }

    public void setConnectionTimeToLive(long connectionTimeToLive) {
        this.connectionTimeToLive = connectionTimeToLive;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public boolean isRequestSentRetryEnabled() {
        return requestSentRetryEnabled;
    }

    public void setRequestSentRetryEnabled(boolean requestSentRetryEnabled) {
        this.requestSentRetryEnabled = requestSentRetryEnabled;
    }
}
