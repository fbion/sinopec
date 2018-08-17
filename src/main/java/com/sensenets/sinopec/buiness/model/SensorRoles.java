/**
  * SensorRoles.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title sensor_roles表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:11:23
 */
public class SensorRoles implements Serializable {
    /**
     * @Fields sensorRoleId 
     */
    private String sensorRoleId;

    /**
     * @Fields uts 
     */
    private Date uts;

    /**
     * @Fields sensorRoleName 
     */
    private String sensorRoleName;

    /**
     * @Fields status 
     */
    private Short status;

    /**
     * @Fields comment 
     */
    private String comment;

    /**
     * @Fields createUser 创建人
     */
    private String createUser;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:sensor_roles.sensor_role_id
     *
     * @return sensor_roles.sensor_role_id, 
     */
    public String getSensorRoleId() {
        return sensorRoleId;
    }

    /**
     * 设置  字段:sensor_roles.sensor_role_id
     *
     * @param sensorRoleId the value for sensor_roles.sensor_role_id, 
     */
    public void setSensorRoleId(String sensorRoleId) {
        this.sensorRoleId = sensorRoleId;
    }

    /**
     * 获取  字段:sensor_roles.uts
     *
     * @return sensor_roles.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:sensor_roles.uts
     *
     * @param uts the value for sensor_roles.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:sensor_roles.sensor_role_name
     *
     * @return sensor_roles.sensor_role_name, 
     */
    public String getSensorRoleName() {
        return sensorRoleName;
    }

    /**
     * 设置  字段:sensor_roles.sensor_role_name
     *
     * @param sensorRoleName the value for sensor_roles.sensor_role_name, 
     */
    public void setSensorRoleName(String sensorRoleName) {
        this.sensorRoleName = sensorRoleName;
    }

    /**
     * 获取  字段:sensor_roles.status
     *
     * @return sensor_roles.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:sensor_roles.status
     *
     * @param status the value for sensor_roles.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取  字段:sensor_roles.comment
     *
     * @return sensor_roles.comment, 
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置  字段:sensor_roles.comment
     *
     * @param comment the value for sensor_roles.comment, 
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取 创建人 字段:sensor_roles.create_user
     *
     * @return sensor_roles.create_user, 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置 创建人 字段:sensor_roles.create_user
     *
     * @param createUser the value for sensor_roles.create_user, 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}