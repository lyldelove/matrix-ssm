package com.lyldelove.base.util;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(ThreadUtil.class);

}
