package com.lyldelove.service.intf.system;

import com.lyldelove.dto.system.User;

public interface UserService {

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
