package com.lyldelove.service.impl.system;

import com.lyldelove.common.util.StringUtil;
import com.lyldelove.dao.system.SysConfigMapper;
import com.lyldelove.entity.system.SysConfig;
import com.lyldelove.service.intf.system.ConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lyldelove
 * @title ConfigServiceImpl 系统配置
 * @date 2020/6/3 7:07
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public String selectConfigValueByKey(String configKey) {
        SysConfig sysConfig = new SysConfig();
        sysConfig.setConfigKey(configKey);

        SysConfig result = sysConfigMapper.selectConfig(sysConfig);
        return StringUtil.isNotNull(result) ? result.getConfigValue() : "";
    }
}
