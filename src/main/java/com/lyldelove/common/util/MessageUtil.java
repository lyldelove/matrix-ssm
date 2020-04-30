package com.lyldelove.common.util;

import com.lyldelove.common.spring.SpringContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author lyldelove
 * @title MessageUtil 处理国际化
 * @date 2020/4/27 6:43
 */
public class MessageUtil {

    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     * @param code 消息键
     * @param args 可以填充到对应的消息中，如"{0}", "{1,date}", "{2,time}"
     * @return String
     */
    public static String message(String code, Object... args) {
        MessageSource messageSource = SpringContext.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
