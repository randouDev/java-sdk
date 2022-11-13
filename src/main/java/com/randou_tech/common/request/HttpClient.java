package com.randou_tech.common.request;

import com.randou_tech.RdException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * The type Http client.
 */
public class HttpClient {

    /**
     * Http客户端
     */
    public static final CloseableHttpClient httpClient;

    /**
     * 配置类
     */
    private static final HttpConfig HTTP_CLIENT_CONFIG;

    /**
     * 编码方式
     */
    private static final String ENCODING = "utf-8";

    /**
     * 请求配置
     */
    private static final RequestConfig request_config;

    static {
        // 配置类
        HTTP_CLIENT_CONFIG = new HttpConfig();

        // 配置请求参数，请求时常，连接时长，读取数据时长
        request_config = RequestConfig.custom()
                .setConnectTimeout(HTTP_CLIENT_CONFIG.getConnectTimeout())
                .setConnectionRequestTimeout(HTTP_CLIENT_CONFIG.getConnectionRequestTimeout())
                .setSocketTimeout(HTTP_CLIENT_CONFIG.getSocketTimeout())
                .build();

        // 配置连接池关联
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(HTTP_CLIENT_CONFIG.getMaxTotal());
        connectionManager.setDefaultMaxPerRoute(HTTP_CLIENT_CONFIG.getMaxPreRoute());

        // 初始化客户端
        httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(request_config)
                .evictExpiredConnections()
                .evictIdleConnections(HTTP_CLIENT_CONFIG.getConnectionTimeToLive(), TimeUnit.SECONDS)
                .build();
    }

    /**
     * 不允许在外部实例化
     */
    private HttpClient() {

    }


    /**
     * GET请求 1.支持不带参数的请求 2.支持参数拼接在URl中的请求
     *
     * @param url 请求地址
     * @return 返回值 http result
     */
    public static HttpResult doGet(String url) {
        return doGet(url, null, null, null);
    }

    /**
     * 带有参数的GET请求
     *
     * @param url    请求地址
     * @param params 请求参数
     * @return 返回值 http result
     */
    public static HttpResult doGet(String url, Map<String, String> params) {
        return doGet(url, params, null, null);
    }

    /**
     * Get 请求：指定请求头，请求参数
     *
     * @param url     请求地址
     * @param params  请求参数
     * @param headers 请求头参数
     * @param rc      the rc
     * @return HttpResult http result
     */
    public static HttpResult doGet(String url, Map<String, String> params, Map<String, String> headers, RequestConfig rc) {
        try {
            // 创建访问对象地址
            URIBuilder uriBuilder = new URIBuilder(url);
            if (params != null && !params.isEmpty()) {
                // 构建在URL中的请求参数
                Set<? extends Map.Entry<?, ?>> entrySet = params.entrySet();
                for (Map.Entry<?, ?> entry : entrySet) {
                    uriBuilder.addParameter((String) entry.getKey(), String.valueOf(entry.getValue()));
                }
            }

            HttpGet httpGet = new HttpGet(uriBuilder.build().toString());
            if (null != rc) {
                httpGet.setConfig(rc);
            }
            // 封装请求头
            packageHeader(headers, httpGet);

            return execute(httpGet);
        } catch (Exception e) {
            throw new RdException("request executed fail", e);
        }
    }

    /**
     * 执行请求
     *
     * @param request the request
     * @return HttpResult http result
     */
    public static HttpResult execute(HttpRequestBase request) {
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            // 构建返回实体
            return new HttpResult(response.getStatusLine().getStatusCode(),
                    EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            throw new RdException("request executed fail", e);
        }
    }

    /**
     * 将请求参数处理为 NameValuePair
     *
     * @param params 请求参数Map
     * @return
     */
    public static List<NameValuePair> convertParams2NVPS(Map<String, Object> params) {
        if (!params.isEmpty()) {
            List<NameValuePair> parameters = new ArrayList<>();
            params.forEach((key, value) -> parameters.add(new BasicNameValuePair(key, String.valueOf(value))));
            return parameters;
        }
        return Collections.emptyList();
    }

    /**
     * 封装请求头
     *
     * @param headers    请求头参数列表
     * @param httpMethod 请求方式
     */
    public static void packageHeader(Map<String, String> headers, HttpRequestBase httpMethod) {
//        if (MapUtils.isNotEmpty(headers)) {
        if(headers != null && !headers.isEmpty()) {
            Set<Map.Entry<String, String>> entrySet = headers.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                // 设置请求头到 HttpRequestBase 对象中
                httpMethod.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * 封装请求参数
     *
     * @param params
     * @param httpMethod
     * @throws UnsupportedEncodingException 不支持字符编码异常
     */
    private static void packageParam(Map<String, Object> params, HttpEntityEnclosingRequest httpMethod)
            throws UnsupportedEncodingException {

        if (!params.isEmpty()) {
            List<NameValuePair> nameValuePairs = convertParams2NVPS(params);
            httpMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs, ENCODING));
        }
    }
}
