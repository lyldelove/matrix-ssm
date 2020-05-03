package com.lyldelove.base.system;

import com.lyldelove.common.util.StringUtil;
import java.util.HashMap;

public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    private static final String CODE_TAG = "code";

    private static final String MSG_TAG = "msg";

    private static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的Result对象, 表示一个空消息
     */
    public Result() {

    }

    /**
     * 初始化一个新创建的Result对象
     * @param code 状态码
     * @param msg 返回内容
     */
    public Result(ResultCode code, String msg) {
        super.put(CODE_TAG, code.value());
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的Result对象
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public Result(ResultCode code, String msg, Object data) {
        super.put(CODE_TAG, code.value());
        super.put(MSG_TAG, msg);
        if (StringUtil.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 成功
     * @param msg 成功信息
     * @param data 数据对象
     * @return Result
     */
    public static Result success(String msg, Object data) {
        return new Result(ResultCode.SUCCESS, msg, data);
    }
}
