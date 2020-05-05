package com.lyldelove.base.system;

import com.lyldelove.common.util.StringUtil;
import java.util.HashMap;

public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    private static final String CODE_TAG = "code";

    private static final String MSG_TAG = "msg";

    private static final String DATA_TAG = "data";

    private static final String OPERATE_SUCCESS = "操作成功";

    private static final String OPERATE_ERROR = "操作失败";

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
     * @return Result
     */
    public static Result success() {
        return Result.success(OPERATE_SUCCESS);
    }

    /**
     * 成功
     * @param msg 成功信息
     * @return Result
     */
    public static Result success(String msg) {
        return Result.success(msg, null);
    }

    /**
     * 成功
     * @param data 数据对象
     * @return Result
     */
    public static Result success(Object data) {
        return Result.success(OPERATE_SUCCESS, data);
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

    /**
     * 警告
     * @param msg 警告信息
     * @return Result
     */
    public static Result warn(String msg) {
        return Result.warn(msg, null);
    }

    /**
     * 警告
     * @param msg 警告信息
     * @param data 数据对象
     * @return Result
     */
    public static Result warn(String msg, Object data) {
        return new Result(ResultCode.WARN, msg, data);
    }

    /**
     * 错误
     * @return Result
     */
    public static Result error() {
        return Result.error(OPERATE_ERROR);
    }

    /**
     * 错误
     * @param msg 错误信息
     * @return Result
     */
    public static Result error(String msg) {
        return Result.error(msg, null);
    }

    /**
     * 错误
     * @param data 错误对象
     * @return Result
     */
    public static Result error(Object data) {
        return Result.error(OPERATE_ERROR, data);
    }

    /**
     * 错误
     * @param msg 错误信息
     * @param data 数据对象
     * @return Result
     */
    public static Result error(String msg, Object data) {
        return new Result(ResultCode.ERROR, msg, data);
    }
}
