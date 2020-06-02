package com.lyldelove.base.system;

import com.lyldelove.service.intf.system.ConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lyldelove
 * @title ConfigObj 系统参数管理，前端使用@configObj调用对象
 * @date 2020/6/3 6:52
 */
@Service
public class ConfigObj {

    @Resource
    private ConfigService configService;

    /**
     * 根据键名查询参数配置信息
     * @param configKey
     * @return
     */
    public String getValue(String configKey) {
        return configService.selectConfigValueByKey(configKey);
    }
}
