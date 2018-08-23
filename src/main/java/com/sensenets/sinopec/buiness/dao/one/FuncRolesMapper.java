/**
  * FuncRolesMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import com.sensenets.sinopec.buiness.model.one.FuncRoles;

public interface FuncRolesMapper {
    /**
     *  根据主键删除数据库的记录:func_roles
     *
     * @param funcRoleId
     */
    int deleteByPrimaryKey(String funcRoleId);

    /**
     *  新写入数据库记录:func_roles
     *
     * @param record
     */
    int insert(FuncRoles record);

    /**
     *  根据指定主键获取一条数据库记录:func_roles
     *
     * @param funcRoleId
     */
    FuncRoles selectByPrimaryKey(String funcRoleId);

    /**
     * :func_roles
     */
    List<FuncRoles> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:func_roles
     *
     * @param record
     */
    int updateByPrimaryKey(FuncRoles record);
}