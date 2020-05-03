package com.lyldelove.base.system;

public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS(0),

    /**
     * 警告
     */
    WARN(301),

    /**
     * 错误
     */
    ERROR(500);

    private final int value;

    ResultCode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
