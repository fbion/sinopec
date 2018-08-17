/**
  * UserFuncRolesMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.model.UserFuncRoles;
import java.util.List;

public interface UserFuncRolesMapper {
    /**
     *  根据主键删除数据库的记录:user_func_roles
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录:user_func_roles
     *
     * @param record
     */
    int insert(UserFuncRoles record);

    /**
     *  根据指定主键获取一条数据库记录:user_func_roles
     *
     * @param id
     */
    UserFuncRoles selectByPrimaryKey(Long id);

    /**
     * :user_func_roles
     */
    List<UserFuncRoles> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:user_func_roles
     *
     * @param record
     */
    int updateByPrimaryKey(UserFuncRoles record);
}