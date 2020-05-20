package com.lyldelove.dao.system;

import com.lyldelove.dto.system.User;
import com.lyldelove.entity.system.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {

    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKey(SysUser record);

    /**
     * 根据用户名查询用户
     * @param loginName
     * @return
     */
    User selectUserByLoginName(String loginName);

    /**
     * 根据用户手机号码查询用户
     * @param mobilePhoneNumber
     * @return
     */
    User selectUserByMobilePhoneNumber(String mobilePhoneNumber);

    /**
     * 根据用户邮箱查询用户
     * @param email
     * @return
     */
    User selectUserByEmail(String email);
}