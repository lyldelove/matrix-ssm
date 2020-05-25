package com.lyldelove.service.intf.system;

import com.lyldelove.entity.system.SysUser;

public interface UserService {

    /**
     * 根据用户名查询用户
     * @param loginName
     * @return
     */
    SysUser selectUserByLoginName(String loginName);

    /**
     * 根据用户手机号码查询用户
     * @param mobilePhoneNumber
     * @return
     */
    SysUser selectUserByMobilePhoneNumber(String mobilePhoneNumber);

    /**
     * 根据用户邮箱查询用户
     * @param email
     * @return
     */
    SysUser selectUserByEmail(String email);

    /**
     * 更新用户信息
     * @param sysUser
     */
    void updateUserInfo(SysUser sysUser);
}
