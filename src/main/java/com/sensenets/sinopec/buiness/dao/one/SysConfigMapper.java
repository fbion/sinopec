/**
  * SysConfigMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import com.sensenets.sinopec.buiness.model.one.SysConfig;

public interface SysConfigMapper {
    /**
     *  根据主键删除数据库的记录:sys_config
     *
     * @param id
     */
    int deleteByPrimaryKey(Short id);

    /**
     *  新写入数据库记录:sys_config
     *
     * @param record
     */
    int insert(SysConfig record);

    /**
     *  根据指定主键获取一条数据库记录:sys_config
     *
     * @param id
     */
    SysConfig selectByPrimaryKey(Short id);

    /**
     * :sys_config
     */
    List<SysConfig> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:sys_config
     *
     * @param record
     */
    int updateByPrimaryKey(SysConfig record);
}