package com.lyldelove.service.impl.system;

import com.lyldelove.dao.system.SysUserMapper;
import com.lyldelove.dto.system.User;
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
     * @param loginName
     * @return
     */
    @Override
    public User selectUserByLoginName(String loginName) {
        return sysUserMapper.selectUserByLoginName(loginName);
    }

    /**
     * 根据用户手机号码查询用户
     * @param mobilePhoneNumber
     * @return
     */
    @Override
    public User selectUserByMobilePhoneNumber(String mobilePhoneNumber) {
        return sysUserMapper.selectUserByMobilePhoneNumber(mobilePhoneNumber);
    }

    /**
     * 根据用户邮箱查询用户
     * @param email
     * @return
     */
    @Override
    public User selectUserByEmail(String email) {
        return sysUserMapper.selectUserByEmail(email);
    }
}
