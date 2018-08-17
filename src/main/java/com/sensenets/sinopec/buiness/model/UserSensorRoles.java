/**
  * UserSensorRoles.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title user_sensor_roles表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:14:27
 */
public class UserSensorRoles implements Serializable {
    /**
     * @Fields id 
     */
    private Long id;

    /**
     * @Fields uts 
     */
    private Date uts;

    /**
     * @Fields userId 
     */
    private String userId;

    /**
     * @Fields sensorRoleId 
     */
    private String sensorRoleId;

    /**
     * @Fields status 
     */
    private Short status;

    /**
     * @Fields type 1:分配给用户的,0:用户创建的
     */
    private Short type;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:user_sensor_roles.id
     *
     * @return user_sensor_roles.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:user_sensor_roles.id
     *
     * @param id the value for user_sensor_roles.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:user_sensor_roles.uts
     *
     * @return user_sensor_roles.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:user_sensor_roles.uts
     *
     * @param uts the value for user_sensor_roles.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:user_sensor_roles.user_id
     *
     * @return user_sensor_roles.user_id, 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置  字段:user_sensor_roles.user_id
     *
     * @param userId the value for user_sensor_roles.user_id, 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取  字段:user_sensor_roles.sensor_role_id
     *
     * @return user_sensor_roles.sensor_role_id, 
     */
    public String getSensorRoleId() {
        return sensorRoleId;
    }

    /**
     * 设置  字段:user_sensor_roles.sensor_role_id
     *
     * @param sensorRoleId the value for user_sensor_roles.sensor_role_id, 
     */
    public void setSensorRoleId(String sensorRoleId) {
        this.sensorRoleId = sensorRoleId;
    }

    /**
     * 获取  字段:user_sensor_roles.status
     *
     * @return user_sensor_roles.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:user_sensor_roles.status
     *
     * @param status the value for user_sensor_roles.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取 1:分配给用户的,0:用户创建的 字段:user_sensor_roles.type
     *
     * @return user_sensor_roles.type, 1:分配给用户的,0:用户创建的
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置 1:分配给用户的,0:用户创建的 字段:user_sensor_roles.type
     *
     * @param type the value for user_sensor_roles.type, 1:分配给用户的,0:用户创建的
     */
    public void setType(Short type) {
        this.type = type;
    }
}