/**
  * Oilguns.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title oilguns表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:09:56
 */
public class Oilguns implements Serializable {
    /**
     * @Fields id 
     */
    private Long id;

    /**
     * @Fields uts 
     */
    private Date uts;

    /**
     * @Fields name 
     */
    private String name;

    /**
     * @Fields taskId 
     */
    private String taskId;

    /**
     * @Fields sensorId 
     */
    private String sensorId;

    /**
     * @Fields oilGunId 
     */
    private String oilGunId;

    /**
     * @Fields oilGunRect 
     */
    private String oilGunRect;

    /**
     * @Fields additionalInfos 
     */
    private String additionalInfos;

    /**
     * @Fields status 
     */
    private Short status;

    /**
     * @Fields threshold 
     */
    private Float threshold;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:oilguns.id
     *
     * @return oilguns.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:oilguns.id
     *
     * @param id the value for oilguns.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:oilguns.uts
     *
     * @return oilguns.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:oilguns.uts
     *
     * @param uts the value for oilguns.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:oilguns.name
     *
     * @return oilguns.name, 
     */
    public String getName() {
        return name;
    }

    /**
     * 设置  字段:oilguns.name
     *
     * @param name the value for oilguns.name, 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取  字段:oilguns.task_id
     *
     * @return oilguns.task_id, 
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置  字段:oilguns.task_id
     *
     * @param taskId the value for oilguns.task_id, 
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * 获取  字段:oilguns.sensor_id
     *
     * @return oilguns.sensor_id, 
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * 设置  字段:oilguns.sensor_id
     *
     * @param sensorId the value for oilguns.sensor_id, 
     */
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * 获取  字段:oilguns.oil_gun_id
     *
     * @return oilguns.oil_gun_id, 
     */
    public String getOilGunId() {
        return oilGunId;
    }

    /**
     * 设置  字段:oilguns.oil_gun_id
     *
     * @param oilGunId the value for oilguns.oil_gun_id, 
     */
    public void setOilGunId(String oilGunId) {
        this.oilGunId = oilGunId;
    }

    /**
     * 获取  字段:oilguns.oil_gun_rect
     *
     * @return oilguns.oil_gun_rect, 
     */
    public String getOilGunRect() {
        return oilGunRect;
    }

    /**
     * 设置  字段:oilguns.oil_gun_rect
     *
     * @param oilGunRect the value for oilguns.oil_gun_rect, 
     */
    public void setOilGunRect(String oilGunRect) {
        this.oilGunRect = oilGunRect;
    }

    /**
     * 获取  字段:oilguns.additional_infos
     *
     * @return oilguns.additional_infos, 
     */
    public String getAdditionalInfos() {
        return additionalInfos;
    }

    /**
     * 设置  字段:oilguns.additional_infos
     *
     * @param additionalInfos the value for oilguns.additional_infos, 
     */
    public void setAdditionalInfos(String additionalInfos) {
        this.additionalInfos = additionalInfos;
    }

    /**
     * 获取  字段:oilguns.status
     *
     * @return oilguns.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:oilguns.status
     *
     * @param status the value for oilguns.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取  字段:oilguns.threshold
     *
     * @return oilguns.threshold, 
     */
    public Float getThreshold() {
        return threshold;
    }

    /**
     * 设置  字段:oilguns.threshold
     *
     * @param threshold the value for oilguns.threshold, 
     */
    public void setThreshold(Float threshold) {
        this.threshold = threshold;
    }
}