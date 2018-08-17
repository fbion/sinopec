/**
  * Sensors.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title sensors表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:11:49
 */
public class Sensors implements Serializable {
    /**
     * @Fields sensorId 
     */
    private String sensorId;

    /**
     * @Fields id 
     */
    private Long id;

    /**
     * @Fields uts 
     */
    private Date uts;

    /**
     * @Fields repoId 
     */
    private String repoId;

    /**
     * @Fields sensorName 
     */
    private String sensorName;

    /**
     * @Fields sensorSn 
     */
    private String sensorSn;

    /**
     * @Fields userId 
     */
    private String userId;

    /**
     * @Fields longitude 
     */
    private Long longitude;

    /**
     * @Fields latitude 
     */
    private Long latitude;

    /**
     * @Fields type 1:普通摄像机，2:抓拍机，3:离线视频，4:离线图片
     */
    private Short type;

    /**
     * @Fields ip 
     */
    private String ip;

    /**
     * @Fields port 
     */
    private String port;

    /**
     * @Fields url 
     */
    private String url;

    /**
     * @Fields renderedurl 
     */
    private String renderedurl;

    /**
     * @Fields rtmpurl 
     */
    private String rtmpurl;

    /**
     * @Fields liveActive 
     */
    private Boolean liveActive;

    /**
     * @Fields dataActive 
     */
    private Boolean dataActive;

    /**
     * @Fields comment 
     */
    private String comment;

    /**
     * @Fields status 
     */
    private Short status;

    /**
     * @Fields rois 
     */
    private String rois;

    /**
     * @Fields lanes 
     */
    private String lanes;

    /**
     * @Fields platformType 平台类型 1:平台设备，2:系统设备
     */
    private Short platformType;

    /**
     * @Fields groupType 分组类型 1:站外摄像机，2:进站摄像机，3:加油摄像机，4:出站摄像机，5:移动采集
     */
    private Short groupType;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:sensors.sensor_id
     *
     * @return sensors.sensor_id, 
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * 设置  字段:sensors.sensor_id
     *
     * @param sensorId the value for sensors.sensor_id, 
     */
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * 获取  字段:sensors.id
     *
     * @return sensors.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:sensors.id
     *
     * @param id the value for sensors.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:sensors.uts
     *
     * @return sensors.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:sensors.uts
     *
     * @param uts the value for sensors.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:sensors.repo_id
     *
     * @return sensors.repo_id, 
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * 设置  字段:sensors.repo_id
     *
     * @param repoId the value for sensors.repo_id, 
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    /**
     * 获取  字段:sensors.sensor_name
     *
     * @return sensors.sensor_name, 
     */
    public String getSensorName() {
        return sensorName;
    }

    /**
     * 设置  字段:sensors.sensor_name
     *
     * @param sensorName the value for sensors.sensor_name, 
     */
    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    /**
     * 获取  字段:sensors.sensor_sn
     *
     * @return sensors.sensor_sn, 
     */
    public String getSensorSn() {
        return sensorSn;
    }

    /**
     * 设置  字段:sensors.sensor_sn
     *
     * @param sensorSn the value for sensors.sensor_sn, 
     */
    public void setSensorSn(String sensorSn) {
        this.sensorSn = sensorSn;
    }

    /**
     * 获取  字段:sensors.user_id
     *
     * @return sensors.user_id, 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置  字段:sensors.user_id
     *
     * @param userId the value for sensors.user_id, 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取  字段:sensors.longitude
     *
     * @return sensors.longitude, 
     */
    public Long getLongitude() {
        return longitude;
    }

    /**
     * 设置  字段:sensors.longitude
     *
     * @param longitude the value for sensors.longitude, 
     */
    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取  字段:sensors.latitude
     *
     * @return sensors.latitude, 
     */
    public Long getLatitude() {
        return latitude;
    }

    /**
     * 设置  字段:sensors.latitude
     *
     * @param latitude the value for sensors.latitude, 
     */
    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取 1:普通摄像机，2:抓拍机，3:离线视频，4:离线图片 字段:sensors.type
     *
     * @return sensors.type, 1:普通摄像机，2:抓拍机，3:离线视频，4:离线图片
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置 1:普通摄像机，2:抓拍机，3:离线视频，4:离线图片 字段:sensors.type
     *
     * @param type the value for sensors.type, 1:普通摄像机，2:抓拍机，3:离线视频，4:离线图片
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取  字段:sensors.ip
     *
     * @return sensors.ip, 
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置  字段:sensors.ip
     *
     * @param ip the value for sensors.ip, 
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取  字段:sensors.port
     *
     * @return sensors.port, 
     */
    public String getPort() {
        return port;
    }

    /**
     * 设置  字段:sensors.port
     *
     * @param port the value for sensors.port, 
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * 获取  字段:sensors.url
     *
     * @return sensors.url, 
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置  字段:sensors.url
     *
     * @param url the value for sensors.url, 
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取  字段:sensors.renderedurl
     *
     * @return sensors.renderedurl, 
     */
    public String getRenderedurl() {
        return renderedurl;
    }

    /**
     * 设置  字段:sensors.renderedurl
     *
     * @param renderedurl the value for sensors.renderedurl, 
     */
    public void setRenderedurl(String renderedurl) {
        this.renderedurl = renderedurl;
    }

    /**
     * 获取  字段:sensors.rtmpurl
     *
     * @return sensors.rtmpurl, 
     */
    public String getRtmpurl() {
        return rtmpurl;
    }

    /**
     * 设置  字段:sensors.rtmpurl
     *
     * @param rtmpurl the value for sensors.rtmpurl, 
     */
    public void setRtmpurl(String rtmpurl) {
        this.rtmpurl = rtmpurl;
    }

    /**
     * 获取  字段:sensors.live_active
     *
     * @return sensors.live_active, 
     */
    public Boolean getLiveActive() {
        return liveActive;
    }

    /**
     * 设置  字段:sensors.live_active
     *
     * @param liveActive the value for sensors.live_active, 
     */
    public void setLiveActive(Boolean liveActive) {
        this.liveActive = liveActive;
    }

    /**
     * 获取  字段:sensors.data_active
     *
     * @return sensors.data_active, 
     */
    public Boolean getDataActive() {
        return dataActive;
    }

    /**
     * 设置  字段:sensors.data_active
     *
     * @param dataActive the value for sensors.data_active, 
     */
    public void setDataActive(Boolean dataActive) {
        this.dataActive = dataActive;
    }

    /**
     * 获取  字段:sensors.comment
     *
     * @return sensors.comment, 
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置  字段:sensors.comment
     *
     * @param comment the value for sensors.comment, 
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取  字段:sensors.status
     *
     * @return sensors.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:sensors.status
     *
     * @param status the value for sensors.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取  字段:sensors.rois
     *
     * @return sensors.rois, 
     */
    public String getRois() {
        return rois;
    }

    /**
     * 设置  字段:sensors.rois
     *
     * @param rois the value for sensors.rois, 
     */
    public void setRois(String rois) {
        this.rois = rois;
    }

    /**
     * 获取  字段:sensors.lanes
     *
     * @return sensors.lanes, 
     */
    public String getLanes() {
        return lanes;
    }

    /**
     * 设置  字段:sensors.lanes
     *
     * @param lanes the value for sensors.lanes, 
     */
    public void setLanes(String lanes) {
        this.lanes = lanes;
    }

    /**
     * 获取 平台类型 1:平台设备，2:系统设备 字段:sensors.platform_type
     *
     * @return sensors.platform_type, 平台类型 1:平台设备，2:系统设备
     */
    public Short getPlatformType() {
        return platformType;
    }

    /**
     * 设置 平台类型 1:平台设备，2:系统设备 字段:sensors.platform_type
     *
     * @param platformType the value for sensors.platform_type, 平台类型 1:平台设备，2:系统设备
     */
    public void setPlatformType(Short platformType) {
        this.platformType = platformType;
    }

    /**
     * 获取 分组类型 1:站外摄像机，2:进站摄像机，3:加油摄像机，4:出站摄像机，5:移动采集 字段:sensors.group_type
     *
     * @return sensors.group_type, 分组类型 1:站外摄像机，2:进站摄像机，3:加油摄像机，4:出站摄像机，5:移动采集
     */
    public Short getGroupType() {
        return groupType;
    }

    /**
     * 设置 分组类型 1:站外摄像机，2:进站摄像机，3:加油摄像机，4:出站摄像机，5:移动采集 字段:sensors.group_type
     *
     * @param groupType the value for sensors.group_type, 分组类型 1:站外摄像机，2:进站摄像机，3:加油摄像机，4:出站摄像机，5:移动采集
     */
    public void setGroupType(Short groupType) {
        this.groupType = groupType;
    }
}