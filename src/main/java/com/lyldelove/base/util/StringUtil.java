package com.lyldelove.base.util;


import org.springframework.util.StringUtils;

/**
 * 字符串工具类
 * 目前使用的是Spring框架，因此使用org.springframework.util.StringUtils工具类，并根据自身需求扩展
 * 如果不是使用的Spring框架，可以使用org.apache.commons.lang3.StringUtils工具类，再根据自身需求扩展
 */
public class StringUtil extends StringUtils {

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