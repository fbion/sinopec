/**
  * ReposMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import com.sensenets.sinopec.buiness.model.one.Repos;

public interface ReposMapper {
    /**
     *  根据主键删除数据库的记录:repos
     *
     * @param repoId
     */
    int deleteByPrimaryKey(String repoId);

    /**
     *  新写入数据库记录:repos
     *
     * @param record
     */
    int insert(Repos record);

    /**
     *  根据指定主键获取一条数据库记录:repos
     *
     * @param repoId
     */
    Repos selectByPrimaryKey(String repoId);

    /**
     * :repos
     */
    List<Repos> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:repos
     *
     * @param record
     */
    int updateByPrimaryKey(Repos record);
}