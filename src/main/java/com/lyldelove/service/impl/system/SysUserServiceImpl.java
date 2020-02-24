package com.lyldelove.service.impl.system;

import com.lyldelove.dao.system.SysUserMapper;
import com.lyldelove.entity.system.SysUser;
import com.lyldelove.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public void test() {
        SysUser sysUser = sysUserMapper.getUser();
        System.out.println(sysUser.getUserName());
    }
}
