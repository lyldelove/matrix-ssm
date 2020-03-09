package com.lyldelove.base.system;

import com.lyldelove.base.util.other.StringUtils;
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
     * @param type 状态类型
     * @param msg 返回内容
     */
    public Result(ResultType type, String msg)
    {
        super.put(CODE_TAG, type.value());
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的Result对象
     * @param type 状态类型
     * @param msg 返回内容
     * @param data 数据对象
     */
    public Result(ResultType type, String msg, Object data)
    {
        super.put(CODE_TAG, type.value());
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data))
        {
            super.put(DATA_TAG, data);
        }
    }


}
