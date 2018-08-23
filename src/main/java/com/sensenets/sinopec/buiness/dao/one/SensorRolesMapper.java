/**
  * SensorRolesMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import com.sensenets.sinopec.buiness.model.one.SensorRoles;

public interface SensorRolesMapper {
    /**
     *  根据主键删除数据库的记录:sensor_roles
     *
     * @param sensorRoleId
     */
    int deleteByPrimaryKey(String sensorRoleId);

    /**
     *  新写入数据库记录:sensor_roles
     *
     * @param record
     */
    int insert(SensorRoles record);

    /**
     *  根据指定主键获取一条数据库记录:sensor_roles
     *
     * @param sensorRoleId
     */
    SensorRoles selectByPrimaryKey(String sensorRoleId);

    /**
     * :sensor_roles
     */
    List<SensorRoles> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:sensor_roles
     *
     * @param record
     */
    int updateByPrimaryKey(SensorRoles record);
}