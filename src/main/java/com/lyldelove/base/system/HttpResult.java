package com.lyldelove.base.system;

import lombok.*;

/**
 * @author lyldelove
 * @title HttpResult 发送http请求的返回结果
 * @date 2020/4/22 6:18
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class HttpResult {

    /**
     * 响应状态码
     */
    @NonNull
    private int code;

    /**
     * 响应数据
     */
    private String content;
}
