/**
  * SensorRoleSensors.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title sensor_role_sensors表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:10:29
 */
public class SensorRoleSensors implements Serializable {
    /**
     * @Fields id 
     */
    private Long id;

    /**
     * @Fields uts 
     */
    private Date uts;

    /**
     * @Fields sensorRoleId 
     */
    private String sensorRoleId;

    /**
     * @Fields sensorId 
     */
    private String sensorId;

    /**
     * @Fields status 
     */
    private Short status;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:sensor_role_sensors.id
     *
     * @return sensor_role_sensors.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:sensor_role_sensors.id
     *
     * @param id the value for sensor_role_sensors.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:sensor_role_sensors.uts
     *
     * @return sensor_role_sensors.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:sensor_role_sensors.uts
     *
     * @param uts the value for sensor_role_sensors.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:sensor_role_sensors.sensor_role_id
     *
     * @return sensor_role_sensors.sensor_role_id, 
     */
    public String getSensorRoleId() {
        return sensorRoleId;
    }

    /**
     * 设置  字段:sensor_role_sensors.sensor_role_id
     *
     * @param sensorRoleId the value for sensor_role_sensors.sensor_role_id, 
     */
    public void setSensorRoleId(String sensorRoleId) {
        this.sensorRoleId = sensorRoleId;
    }

    /**
     * 获取  字段:sensor_role_sensors.sensor_id
     *
     * @return sensor_role_sensors.sensor_id, 
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * 设置  字段:sensor_role_sensors.sensor_id
     *
     * @param sensorId the value for sensor_role_sensors.sensor_id, 
     */
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * 获取  字段:sensor_role_sensors.status
     *
     * @return sensor_role_sensors.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:sensor_role_sensors.status
     *
     * @param status the value for sensor_role_sensors.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}