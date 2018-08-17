/**
  * UserSensorRolesMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.model.UserSensorRoles;
import java.util.List;

public interface UserSensorRolesMapper {
    /**
     *  根据主键删除数据库的记录:user_sensor_roles
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录:user_sensor_roles
     *
     * @param record
     */
    int insert(UserSensorRoles record);

    /**
     *  根据指定主键获取一条数据库记录:user_sensor_roles
     *
     * @param id
     */
    UserSensorRoles selectByPrimaryKey(Long id);

    /**
     * :user_sensor_roles
     */
    List<UserSensorRoles> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:user_sensor_roles
     *
     * @param record
     */
    int updateByPrimaryKey(UserSensorRoles record);
}