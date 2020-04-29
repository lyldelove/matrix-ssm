package com.lyldelove.dao.system;

import com.lyldelove.entity.system.SysDept;

public interface SysDeptMapper {
    int deleteByPrimaryKey(Long deptId);

    int insert(SysDept record);

    SysDept selectByPrimaryKey(Long deptId);

    int updateByPrimaryKey(SysDept record);
}