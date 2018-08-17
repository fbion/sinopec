/**
  * SensorRoleSensorsMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.model.SensorRoleSensors;
import java.util.List;

public interface SensorRoleSensorsMapper {
    /**
     *  根据主键删除数据库的记录:sensor_role_sensors
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录:sensor_role_sensors
     *
     * @param record
     */
    int insert(SensorRoleSensors record);

    /**
     *  根据指定主键获取一条数据库记录:sensor_role_sensors
     *
     * @param id
     */
    SensorRoleSensors selectByPrimaryKey(Long id);

    /**
     * :sensor_role_sensors
     */
    List<SensorRoleSensors> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:sensor_role_sensors
     *
     * @param record
     */
    int updateByPrimaryKey(SensorRoleSensors record);
}