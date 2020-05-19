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

    /**
     * 数据范围，1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限
     */
    private String dataScope;

    /**
     * 角色状态，0 正常， 1 停用
     */
    private String status;

    /**
     * 删除标识，0 正常，1 删除
     */
    private String deleteFlag;
}