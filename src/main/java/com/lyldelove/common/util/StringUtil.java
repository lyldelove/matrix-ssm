package com.lyldelove.common.util;


import org.springframework.util.StringUtils;

/**
 * 字符串工具类
 * 目前使用的是Spring框架，因此使用org.springframework.util.StringUtils工具类，并根据自身需求扩展
 * 如果不是使用的Spring框架，可以使用org.apache.commons.lang3.StringUtils工具类，再根据自身需求扩展
 */
public class StringUtil extends StringUtils {

    /**
     * 手机号码正则表达式匹配
     */
    public static final String MOBILE_PHONE_NUMBER_PATTERN = "^0{0,1}(13[0-9]|15[0-9]|14[0-9]|18[0-9])[0-9]{8}$";

    /**
     * 邮箱正则表达式匹配
     */
    public static final String EMAIL_PATTERN = "^((([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+(\\.([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+)*)|((\\x22)((((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(([\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x7f]|\\x21|[\\x23-\\x5b]|[\\x5d-\\x7e]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(\\\\([\\x01-\\x09\\x0b\\x0c\\x0d-\\x7f]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF]))))*(((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(\\x22)))@((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?";

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

    /**
     * 使用[]格式化拼接字符
     * @param args
     * @return
     */
    public static String formatWithBlock(String... args) {
        String result = "";

        for (String arg : args) {
            result += "[" + (isNull(arg) ? "" : arg) + "]";
        }

        return result;
    }

    /**
     * 是否匹配电话号码
     * @return
     */
    public static boolean isMobilePhoneNumber(String mobilePhoneNumber) {
        return mobilePhoneNumber.matches(MOBILE_PHONE_NUMBER_PATTERN);
    }

    /**
     * 是否匹配电话号码
     * @return
     */
    public static boolean isEmail(String email) {
        return email.matches(EMAIL_PATTERN);
    }

}