/**
  * Sensors.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-30
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title public.sensors表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-30 14:38:04
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="Sensors")
public class Sensors implements Serializable {
    /**
     * @Fields sensorId 
     */
    @ApiModelProperty(value = "")
    private String sensorId;

    /**
     * @Fields id 
     */
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * @Fields uts 
     */
    @ApiModelProperty(value = "")
    private Date uts;

    /**
     * @Fields repoId 
     */
    @ApiModelProperty(value = "")
    private String repoId;

    /**
     * @Fields sensorName 
     */
    @ApiModelProperty(value = "")
    private String sensorName;

    /**
     * @Fields sensorSn 
     */
    @ApiModelProperty(value = "")
    private String sensorSn;

    /**
     * @Fields userId 
     */
    @ApiModelProperty(value = "")
    private String userId;

    /**
     * @Fields longitude 
     */
    @ApiModelProperty(value = "")
    private Long longitude;

    /**
     * @Fields latitude 
     */
    @ApiModelProperty(value = "")
    private Long latitude;

    /**
     * @Fields type 1:普通摄像机，2:抓拍机，3:离线视频，4:离线图片
     */
    @ApiModelProperty(value = "1:普通摄像机，2:抓拍机，3:离线视频，4:离线图片")
    private Short type;

    /**
     * @Fields ip 
     */
    @ApiModelProperty(value = "")
    private String ip;

    /**
     * @Fields port 
     */
    @ApiModelProperty(value = "")
    private String port;

    /**
     * @Fields url 
     */
    @ApiModelProperty(value = "")
    private String url;

    /**
     * @Fields renderedurl 
     */
    @ApiModelProperty(value = "")
    private String renderedurl;

    /**
     * @Fields rtmpurl 
     */
    @ApiModelProperty(value = "")
    private String rtmpurl;

    /**
     * @Fields liveActive 
     */
    @ApiModelProperty(value = "")
    private Boolean liveActive;

    /**
     * @Fields dataActive 
     */
    @ApiModelProperty(value = "")
    private Boolean dataActive;

    /**
     * @Fields comment 
     */
    @ApiModelProperty(value = "")
    private String comment;

    /**
     * @Fields status 
     */
    @ApiModelProperty(value = "")
    private Short status;

    /**
     * @Fields rois 
     */
    @ApiModelProperty(value = "")
    private String rois;

    /**
     * @Fields lanes 
     */
    @ApiModelProperty(value = "")
    private String lanes;

    /**
     * @Fields platformType 平台类型 1:平台设备，2:系统设备
     */
    @ApiModelProperty(value = "平台类型 1:平台设备，2:系统设备")
    private Short platformType;

    /**
     * @Fields groupType 分组类型 1:站外摄像机，2:进站摄像机，3:加油摄像机，4:出站摄像机，5:移动采集
     */
    @ApiModelProperty(value = "分组类型 1:站外摄像机，2:进站摄像机，3:加油摄像机，4:出站摄像机，5:移动采集")
    private Short groupType;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:public.sensors.sensor_id
     *
     * @return public.sensors.sensor_id, 
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * 设置  字段:public.sensors.sensor_id
     *
     * @param sensorId the value for public.sensors.sensor_id, 
     */
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * 获取  字段:public.sensors.id
     *
     * @return public.sensors.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:public.sensors.id
     *
     * @param id the value for public.sensors.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:public.sensors.uts
     *
     * @return public.sensors.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:public.sensors.uts
     *
     * @param uts the value for public.sensors.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:public.sensors.repo_id
     *
     * @return public.sensors.repo_id, 
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * 设置  字段:public.sensors.repo_id
     *
     * @param repoId the value for public.sensors.repo_id, 
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    /**
     * 获取  字段:public.sensors.sensor_name
     *
     * @return public.sensors.sensor_name, 
     */
    public String getSensorName() {
        return sensorName;
    }

    /**
     * 设置  字段:public.sensors.sensor_name
     *
     * @param sensorName the value for public.sensors.sensor_name, 
     */
    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    /**
     * 获取  字段:public.sensors.sensor_sn
     *
     * @return public.sensors.sensor_sn, 
     */
    public String getSensorSn() {
        return sensorSn;
    }

    /**
     * 设置  字段:public.sensors.sensor_sn
     *
     * @param sensorSn the value for public.sensors.sensor_sn, 
     */
    public void setSensorSn(String sensorSn) {
        this.sensorSn = sensorSn;
    }

    /**
     * 获取  字段:public.sensors.user_id
     *
     * @return public.sensors.user_id, 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置  字段:public.sensors.user_id
     *
     * @param userId the value for public.sensors.user_id, 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取  字段:public.sensors.longitude
     *
     * @return public.sensors.longitude, 
     */
    public Long getLongitude() {
        return longitude;
    }

    /**
     * 设置  字段:public.sensors.longitude
     *
     * @param longitude the value for public.sensors.longitude, 
     */
    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取  字段:public.sensors.latitude
     *
     * @return public.sensors.latitude, 
     */
    public Long getLatitude() {
        return latitude;
    }

    /**
     * 设置  字段:public.sensors.latitude
     *
     * @param latitude the value for public.sensors.latitude, 
     */
    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取 1:普通摄像机，2:抓拍机，3:离线视频，4:离线图片 字段:public.sensors.type
     *
     * @return public.sensors.type, 1:普通摄像机，2:抓拍机，3:离线视频，4:离线图片
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置 1:普通摄像机，2:抓拍机，3:离线视频，4:离线图片 字段:public.sensors.type
     *
     * @param type the value for public.sensors.type, 1:普通摄像机，2:抓拍机，3:离线视频，4:离线图片
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取  字段:public.sensors.ip
     *
     * @return public.sensors.ip, 
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置  字段:public.sensors.ip
     *
     * @param ip the value for public.sensors.ip, 
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取  字段:public.sensors.port
     *
     * @return public.sensors.port, 
     */
    public String getPort() {
        return port;
    }

    /**
     * 设置  字段:public.sensors.port
     *
     * @param port the value for public.sensors.port, 
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * 获取  字段:public.sensors.url
     *
     * @return public.sensors.url, 
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置  字段:public.sensors.url
     *
     * @param url the value for public.sensors.url, 
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取  字段:public.sensors.renderedurl
     *
     * @return public.sensors.renderedurl, 
     */
    public String getRenderedurl() {
        return renderedurl;
    }

    /**
     * 设置  字段:public.sensors.renderedurl
     *
     * @param renderedurl the value for public.sensors.renderedurl, 
     */
    public void setRenderedurl(String renderedurl) {
        this.renderedurl = renderedurl;
    }

    /**
     * 获取  字段:public.sensors.rtmpurl
     *
     * @return public.sensors.rtmpurl, 
     */
    public String getRtmpurl() {
        return rtmpurl;
    }

    /**
     * 设置  字段:public.sensors.rtmpurl
     *
     * @param rtmpurl the value for public.sensors.rtmpurl, 
     */
    public void setRtmpurl(String rtmpurl) {
        this.rtmpurl = rtmpurl;
    }

    /**
     * 获取  字段:public.sensors.live_active
     *
     * @return public.sensors.live_active, 
     */
    public Boolean getLiveActive() {
        return liveActive;
    }

    /**
     * 设置  字段:public.sensors.live_active
     *
     * @param liveActive the value for public.sensors.live_active, 
     */
    public void setLiveActive(Boolean liveActive) {
        this.liveActive = liveActive;
    }

    /**
     * 获取  字段:public.sensors.data_active
     *
     * @return public.sensors.data_active, 
     */
    public Boolean getDataActive() {
        return dataActive;
    }

    /**
     * 设置  字段:public.sensors.data_active
     *
     * @param dataActive the value for public.sensors.data_active, 
     */
    public void setDataActive(Boolean dataActive) {
        this.dataActive = dataActive;
    }

    /**
     * 获取  字段:public.sensors.comment
     *
     * @return public.sensors.comment, 
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置  字段:public.sensors.comment
     *
     * @param comment the value for public.sensors.comment, 
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取  字段:public.sensors.status
     *
     * @return public.sensors.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:public.sensors.status
     *
     * @param status the value for public.sensors.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取  字段:public.sensors.rois
     *
     * @return public.sensors.rois, 
     */
    public String getRois() {
        return rois;
    }

    /**
     * 设置  字段:public.sensors.rois
     *
     * @param rois the value for public.sensors.rois, 
     */
    public void setRois(String rois) {
        this.rois = rois;
    }

    /**
     * 获取  字段:public.sensors.lanes
     *
     * @return public.sensors.lanes, 
     */
    public String getLanes() {
        return lanes;
    }

    /**
     * 设置  字段:public.sensors.lanes
     *
     * @param lanes the value for public.sensors.lanes, 
     */
    public void setLanes(String lanes) {
        this.lanes = lanes;
    }

    /**
     * 获取 平台类型 1:平台设备，2:系统设备 字段:public.sensors.platform_type
     *
     * @return public.sensors.platform_type, 平台类型 1:平台设备，2:系统设备
     */
    public Short getPlatformType() {
        return platformType;
    }

    /**
     * 设置 平台类型 1:平台设备，2:系统设备 字段:public.sensors.platform_type
     *
     * @param platformType the value for public.sensors.platform_type, 平台类型 1:平台设备，2:系统设备
     */
    public void setPlatformType(Short platformType) {
        this.platformType = platformType;
    }

    /**
     * 获取 分组类型 1:站外摄像机，2:进站摄像机，3:加油摄像机，4:出站摄像机，5:移动采集 字段:public.sensors.group_type
     *
     * @return public.sensors.group_type, 分组类型 1:站外摄像机，2:进站摄像机，3:加油摄像机，4:出站摄像机，5:移动采集
     */
    public Short getGroupType() {
        return groupType;
    }

    /**
     * 设置 分组类型 1:站外摄像机，2:进站摄像机，3:加油摄像机，4:出站摄像机，5:移动采集 字段:public.sensors.group_type
     *
     * @param groupType the value for public.sensors.group_type, 分组类型 1:站外摄像机，2:进站摄像机，3:加油摄像机，4:出站摄像机，5:移动采集
     */
    public void setGroupType(Short groupType) {
        this.groupType = groupType;
    }
}