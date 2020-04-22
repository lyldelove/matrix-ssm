package com.lyldelove.base.util;

import com.google.protobuf.ServiceException;
import com.lyldelove.base.system.HttpResult;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lyldelove
 * @title HttpUtil Http请求工具类，基于HttpClient进行封装
 * @date 2020/4/18 9:21
 */
public class HttpUtil {
    /**
     * 编码格式。发送编码格式统一用UTF-8
     */
    private static final String ENCODING = "UTF-8";

    /**
     * 设置连接超时时间，单位毫秒。
     */
    private static final int CONNECT_TIMEOUT = 6000;

    /**
     * 请求获取数据的超时时间(即响应时间)，单位毫秒。
     */
    private static final int SOCKET_TIMEOUT = 6000;

    /**
     * 连接池管理器
     */
    private static PoolingHttpClientConnectionManager connectionManager;

    /**
     * 请求配置
     */
    private static RequestConfig requestConfig;

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(ThreadUtil.class);

    static {
        // 设置连接池
        connectionManager = new PoolingHttpClientConnectionManager();

        // 设置连接池大小
        connectionManager.setMaxTotal(100);

        connectionManager.setDefaultMaxPerRoute(connectionManager.getMaxTotal());

        // Validate connections after 1 sec of inactivity
        connectionManager.setValidateAfterInactivity(1000);

        // 设置连接超时，读取超时，从连接池获取连接实例的超时
        requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).setConnectionRequestTimeout(CONNECT_TIMEOUT).build();
    }

    /**
     * Http Get请求，无headers 无params
     * @param url 请求地址
     * @return HttpResult
     */
    public static HttpResult sendGet(String url) {
        return sendGet(url, null);
    }

    /**
     * Http Get请求，无params
     * @param url 请求地址
     * @param params 请求参数
     * @return HttpResult
     */
    public static HttpResult sendGet(String url, Map<String, String> params) {
        return sendGet(url, null, params);
    }

    /**
     * Http Get请求
     * @param url 请求地址
     * @param headers 请求头
     * @param params 请求参数
     * @return HttpResult
     */
    public static HttpResult sendGet(String url, Map<String, String> headers, Map<String, String> params) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        HttpResult httpResult = null;

        try {

            httpClient = getHttpClient(url);

            URI uri = handleGetParams(url, params);

            // 创建http对象
            HttpGet httpGet = new HttpGet(uri);

            //处理请求头
            handleHeaders(httpGet, headers);

            httpResponse = httpClient.execute(httpGet);

            httpResult = handleResponse(httpResponse);

        } catch (GeneralSecurityException e) {
            logger.error("调用HttpUtil.sendGet SSL连接发生GeneralSecurityException, url=" + url, e);
        } catch (URISyntaxException e) {
            logger.error("调用HttpUtil.sendGet 处理参数发生URISyntaxException, url=" + url, e);
        } catch (ClientProtocolException e) {
            logger.error("调用HttpUtil.sendGet 发送请求发生ClientProtocolException, url=" + url, e);
        } catch (IOException e) {
            logger.error("调用HttpUtil.sendGet 发送请求发生IOException, url=" + url, e);
        } finally {
            try {
                release(httpResponse, httpClient);
            } catch (IOException e) {
                logger.error("调用HttpUtil.sendGet 释放资源发生IOException, url=" + url, e);
            }
        }

        return httpResult;
    }

    /**
     * Http Post请求，无headers 无params
     * @param url 请求地址
     * @return HttpResult
     */
    public static HttpResult sendPost(String url) {
        return sendPost(url, null);
    }

    /**
     * Http Post请求，无params
     * @param url 请求地址
     * @param params 请求参数
     * @return HttpResult
     */
    public static HttpResult sendPost(String url, Map<String, String> params) {
        return sendPost(url, null, params);
    }

    /**
     * Http Post请求
     * @param url 请求地址
     * @param headers 请求头
     * @param params 请求参数
     * @return HttpResult
     */
    public static HttpResult sendPost(String url, Map<String, String> headers, Map<String, String> params) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse httpResponse = null;
        HttpResult httpResult = null;

        try {

            httpClient = getHttpClient(url);

            // 创建http对象
            HttpPost httpPost = new HttpPost(url);

            //处理请求参数
            handlePostParams(httpPost, params);

            //处理请求头
            handleHeaders(httpPost, headers);

            httpResponse = httpClient.execute(httpPost);

            httpResult = handleResponse(httpResponse);

        } catch (GeneralSecurityException e) {
            logger.error("调用HttpUtil.sendPost SSL连接发生GeneralSecurityException, url=" + url, e);
        } catch (UnsupportedEncodingException e) {
            logger.error("调用HttpUtil.sendPost 处理参数时发生UnsupportedEncodingException, url=" + url, e);
        } catch (ClientProtocolException e) {
            logger.error("调用HttpUtil.sendPost 发送请求发生ClientProtocolException, url=" + url, e);
        } catch (IOException e) {
            logger.error("调用HttpUtil.sendPost 发送请求发生IOException, url=" + url, e);
        } finally {
            try {
                release(httpResponse, httpClient);
            } catch (IOException e) {
                logger.error("调用HttpUtil.sendGet 释放资源发生IOException, url=" + url, e);
            }
        }

        return httpResult;
    }

    /**
     * 根据请求的方式获取不同的HttpClient
     * @param url 请求地址
     * @return HttpClient
     * @throws GeneralSecurityException GeneralSecurityException
     */
    private static CloseableHttpClient getHttpClient(String url) throws GeneralSecurityException {
        if (url.startsWith("https")) {
            // 处理https请求，处理SSL
            return HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig).build();
        } else {
            return HttpClients.createDefault();
        }
    }

    /**
     * 处理Get请求参数
     * @param url 请求地址
     * @param params 请求参数
     * @return URI
     * @throws URISyntaxException URISyntaxException
     */
    private static URI handleGetParams(String url, Map<String, String> params) throws URISyntaxException {

        URIBuilder builder = new URIBuilder(url);

        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.setParameter(entry.getKey(), entry.getValue());
            }
        }

        return builder.build();
    }

    /**
     * 处理Post请求参数
     * @param httpMethod HttpEntityEnclosingRequestBase
     * @param params 请求参数
     * @throws UnsupportedEncodingException UnsupportedEncodingException
     */
    private static void handlePostParams(HttpEntityEnclosingRequestBase httpMethod, Map<String, String> params) throws UnsupportedEncodingException {
        if (params != null) {
            List<NameValuePair> nvps = new ArrayList<>();

            for (Map.Entry<String, String> entry : params.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            // 设置到请求的http对象中
            httpMethod.setEntity(new UrlEncodedFormEntity(nvps, ENCODING));
        }
    }

    /**
     * 处理请求的请求头
     * @param httpMethod HttpRequestBase
     * @param headers 请求头
     */
    private static void handleHeaders(HttpRequestBase httpMethod, Map<String, String> headers) {

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                // 设置到请求头到HttpRequestBase对象中
                httpMethod.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * 处理请求响应response
     * @param response HttpResponse
     * @return HttpResult
     * @throws IOException IOException
     */
    private static HttpResult handleResponse(HttpResponse response) throws IOException {

        if (response != null && response.getStatusLine() != null) {

            String content = "";

            if (response.getEntity() != null) {
                content = EntityUtils.toString(response.getEntity(), ENCODING);
            }
            return new HttpResult(response.getStatusLine().getStatusCode(), content);
        }
        return new HttpResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    /**
     * 是否资源
     * @param httpResponse CloseableHttpResponse
     * @param httpClient CloseableHttpClient
     * @throws IOException IOException
     */
    private static void release(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) throws IOException {
        if (httpResponse != null) {
            httpResponse.close();
        }
        if (httpClient != null) {
            httpClient.close();
        }
    }

    /**
     * 创建SSL安全连接
     * @return SSLConnectionSocketFactory
     */
    private static SSLConnectionSocketFactory createSSLConnSocketFactory() throws GeneralSecurityException {
        SSLConnectionSocketFactory sslsf = null;

        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        }).build();

        sslsf = new SSLConnectionSocketFactory(sslContext, new HostnameVerifier() {

            @Override
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
        });

        return sslsf;
    }

}
