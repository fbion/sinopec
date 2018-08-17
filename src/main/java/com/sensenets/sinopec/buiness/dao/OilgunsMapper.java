/**
  * OilgunsMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.model.Oilguns;
import java.util.List;

public interface OilgunsMapper {
    /**
     *  根据主键删除数据库的记录:oilguns
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录:oilguns
     *
     * @param record
     */
    int insert(Oilguns record);

    /**
     *  根据指定主键获取一条数据库记录:oilguns
     *
     * @param id
     */
    Oilguns selectByPrimaryKey(Long id);

    /**
     * :oilguns
     */
    List<Oilguns> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:oilguns
     *
     * @param record
     */
    int updateByPrimaryKey(Oilguns record);
}