package com.lyldelove.dao.system;

import com.lyldelove.dto.system.User;
import com.lyldelove.entity.system.SysUser;

public interface SysUserMapper {

    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKey(SysUser record);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User selectUserByLoginName(String username);
}