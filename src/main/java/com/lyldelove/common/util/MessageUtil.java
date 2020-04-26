package com.lyldelove.common.util;

import com.lyldelove.base.spring.SpringContext;
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
     * @param code
     * @param args
     * @return
     */
    public static String message(String code, Object... args) {
        MessageSource messageSource = SpringContext.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
