/**
  * FuncRoleFuncsMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.model.FuncRoleFuncs;
import java.util.List;

public interface FuncRoleFuncsMapper {
    /**
     *  根据主键删除数据库的记录:func_role_funcs
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录:func_role_funcs
     *
     * @param record
     */
    int insert(FuncRoleFuncs record);

    /**
     *  根据指定主键获取一条数据库记录:func_role_funcs
     *
     * @param id
     */
    FuncRoleFuncs selectByPrimaryKey(Long id);

    /**
     * :func_role_funcs
     */
    List<FuncRoleFuncs> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:func_role_funcs
     *
     * @param record
     */
    int updateByPrimaryKey(FuncRoleFuncs record);
}