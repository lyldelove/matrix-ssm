package com.lyldelove.entity.system;

import com.lyldelove.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * sys_config
 * @author 
 */
@Getter
@Setter
public class SysConfig extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 参数ID
     */
    private Long configId;

    /**
     * 参数名
     */
    private String configName;

    /**
     * 参数键名
     */
    private String configKey;

    /**
     * 参数键值
     */
    private String configValue;

    /**
     * 参数类型 系统内置（Y是 N否）
     */
    private String configType;
}