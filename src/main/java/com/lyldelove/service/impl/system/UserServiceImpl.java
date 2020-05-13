package com.lyldelove.service.impl.system;

import com.lyldelove.dao.system.SysUserMapper;
import com.lyldelove.entity.system.SysUser;
import com.lyldelove.service.intf.system.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lyldelove
 * @title UserServiceImpl
 * @date 2020/5/14 6:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    @Override
    public SysUser selectUserByLoginName(String username) {
        return sysUserMapper.selectUserByLoginName(username);
    }
}
