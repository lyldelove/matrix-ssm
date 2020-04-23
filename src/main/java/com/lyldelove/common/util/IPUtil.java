package com.lyldelove.common.util;

import com.alibaba.fastjson.JSONObject;
import com.lyldelove.base.system.HttpResult;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import static sun.net.util.IPAddressUtil.textToNumericFormatV4;

/**
 * @author lyldelove
 * @title IPUtil IP相关工具类
 * @date 2020/4/18 8:57
 */
public class IPUtil {

    private static final Logger log = LoggerFactory.getLogger(IPUtil.class);

    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    /**
     * 工具IP获取实际的地址
     * @param ip IP
     * @return 地址
     */
    public static String getRealAddressByIP(String ip) {
        String address = "XX XX";

        // 内网不查询
        if (IPUtil.internalIp(ip)) {
            return "内网IP";
        }

        HttpResult httpResult = HttpUtil.sendPost(IP_URL, new HashMap<String, String>(){{put("ip", ip);}});

        if(httpResult.getCode() != HttpStatus.SC_OK) {
            log.error("获取地理位置异常 {}", ip);
            return address;
        }

        JSONObject obj = JSONObject.parseObject(httpResult.getContent());
        JSONObject data = obj.getObject("data", JSONObject.class);
        String region = data.getString("region");
        String city = data.getString("city");
        address = region + " " + city;

        return address;
    }

    /**
     * 判断IP是否为内网IP
     * @param ip ip
     * @return boolean
     */
    public static boolean internalIp(String ip) {
        byte[] addr = textToNumericFormatV4(ip);
        return internalIp(addr) || "127.0.0.1".equals(ip);
    }

    /**
     * 判断IP地址是否为内网地址具体实现
     * tcp/ip协议中，专门保留了三个IP地址区域作为私有地址，其地址范围如下：
     * 10.0.0.0/8：10.0.0.0～10.255.255.255
     * 172.16.0.0/12：172.16.0.0～172.31.255.255
     * 192.168.0.0/16：192.168.0.0～192.168.255.255
     * @param addr byte[]
     * @return boolean
     */
    private static boolean internalIp(byte[] addr) {
        if (StringUtil.isNull(addr) || addr.length < 2) {
            return true;
        }
        final byte b0 = addr[0];
        final byte b1 = addr[1];
        // 10.x.x.x/8
        final byte SECTION_1 = 0x0A;
        // 172.16.x.x/12
        final byte SECTION_2 = (byte) 0xAC;
        final byte SECTION_3 = (byte) 0x10;
        final byte SECTION_4 = (byte) 0x1F;
        // 192.168.x.x/16
        final byte SECTION_5 = (byte) 0xC0;
        final byte SECTION_6 = (byte) 0xA8;
        switch (b0) {
            case SECTION_1:
                return true;
            case SECTION_2:
                if (b1 >= SECTION_3 && b1 <= SECTION_4) {
                    return true;
                }
            case SECTION_5:
                switch (b1) {
                    case SECTION_6:
                        return true;
                }
            default:
                return false;
        }
    }
}
