/**
  * SensorsMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.model.Sensors;
import java.util.List;

public interface SensorsMapper {
    /**
     *  根据主键删除数据库的记录:sensors
     *
     * @param sensorId
     */
    int deleteByPrimaryKey(String sensorId);

    /**
     *  新写入数据库记录:sensors
     *
     * @param record
     */
    int insert(Sensors record);

    /**
     *  根据指定主键获取一条数据库记录:sensors
     *
     * @param sensorId
     */
    Sensors selectByPrimaryKey(String sensorId);

    /**
     * :sensors
     */
    List<Sensors> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:sensors
     *
     * @param record
     */
    int updateByPrimaryKey(Sensors record);
}