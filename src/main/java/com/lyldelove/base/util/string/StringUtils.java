package com.lyldelove.base.util.string;


/**
 * 字符串工具类
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 判断一个对象是否为空
     * @param object 需要判断的对象
     * @return true-空 false-非空
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * 判断一个对象是否非空
     * @param object 需要判断的对象
     * @return true-非空 false-空
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }
}