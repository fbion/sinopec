/**
  * FuncsMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import com.sensenets.sinopec.buiness.model.one.Funcs;

public interface FuncsMapper {
    /**
     *  根据主键删除数据库的记录:funcs
     *
     * @param funcId
     */
    int deleteByPrimaryKey(String funcId);

    /**
     *  新写入数据库记录:funcs
     *
     * @param record
     */
    int insert(Funcs record);

    /**
     *  根据指定主键获取一条数据库记录:funcs
     *
     * @param funcId
     */
    Funcs selectByPrimaryKey(String funcId);

    /**
     * :funcs
     */
    List<Funcs> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:funcs
     *
     * @param record
     */
    int updateByPrimaryKey(Funcs record);
}