/**
  * SourcesMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.model.Sources;
import java.util.List;

public interface SourcesMapper {
    /**
     *  根据主键删除数据库的记录:sources
     *
     * @param sourceId
     */
    int deleteByPrimaryKey(String sourceId);

    /**
     *  新写入数据库记录:sources
     *
     * @param record
     */
    int insert(Sources record);

    /**
     *  根据指定主键获取一条数据库记录:sources
     *
     * @param sourceId
     */
    Sources selectByPrimaryKey(String sourceId);

    /**
     * :sources
     */
    List<Sources> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:sources
     *
     * @param record
     */
    int updateByPrimaryKey(Sources record);
}