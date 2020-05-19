package com.lyldelove.entity.system;

import com.lyldelove.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * sys_dept
 */
@Getter
@Setter
public class SysDept extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 父部门ID
     */
    private Long parentId;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门显示顺序
     */
    private Integer orderNum;

    /**
     * 部门负责人
     */
    private String leader;

    /**
     * 部门电话
     */
    private String phone;

    /**
     * 部门邮箱
     */
    private String email;

    /**
     * 状态，0 正常，1 停用
     */
    private String status;

    /**
     * 删除标识，0 正常，2 删除
     */
    private String deleteFlag;
}