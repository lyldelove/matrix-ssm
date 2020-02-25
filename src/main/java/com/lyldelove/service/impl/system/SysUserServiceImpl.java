package com.lyldelove.service.impl.system;

import com.lyldelove.dao.system.SysUserMapper;
import com.lyldelove.entity.system.SysUser;
import com.lyldelove.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUser() {
        SysUser sysUser = sysUserMapper.getUser();
        return sysUser;
    }

}
