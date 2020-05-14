package com.lyldelove.entity.system;

import com.lyldelove.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * sys_role
 * @author 
 */
@Getter
@Setter
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色权限字符串
     */
    private String roleKey;

    /**
     * 显示顺序
     */
    private Integer roleSort;

    private String dataScope;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 删除标识，0 正常，1 删除
     */
    private String deleteFlag;
}