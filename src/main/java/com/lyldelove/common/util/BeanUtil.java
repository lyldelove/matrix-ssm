package com.lyldelove.common.util;

/**
 * @author lyldelove
 * @title BeanUtil Bean工具类，基于Spring BeanUtils
 * @date 2020/5/29 6:22
 */
public class BeanUtil extends org.springframework.beans.BeanUtils {

    /**
     * 调用Spring BeanUtils方法复制Bean的属性
     * @param dest
     * @param src
     */
    public static void copyBeanProp(Object dest, Object src) {
        try {
            copyProperties(src, dest);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
