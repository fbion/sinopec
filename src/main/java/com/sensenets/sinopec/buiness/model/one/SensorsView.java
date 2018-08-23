/**
  * SensorsView.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title sensors_view表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:15:44
 */
public class SensorsView implements Serializable {
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
     * @Fields sensorId 
     */
    private String sensorId;

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
     * @Fields type 
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
     * @Fields repoName 
     */
    private String repoName;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:sensors_view.id
     *
     * @return sensors_view.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:sensors_view.id
     *
     * @param id the value for sensors_view.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:sensors_view.uts
     *
     * @return sensors_view.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:sensors_view.uts
     *
     * @param uts the value for sensors_view.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:sensors_view.repo_id
     *
     * @return sensors_view.repo_id, 
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * 设置  字段:sensors_view.repo_id
     *
     * @param repoId the value for sensors_view.repo_id, 
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    /**
     * 获取  字段:sensors_view.sensor_id
     *
     * @return sensors_view.sensor_id, 
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * 设置  字段:sensors_view.sensor_id
     *
     * @param sensorId the value for sensors_view.sensor_id, 
     */
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * 获取  字段:sensors_view.sensor_name
     *
     * @return sensors_view.sensor_name, 
     */
    public String getSensorName() {
        return sensorName;
    }

    /**
     * 设置  字段:sensors_view.sensor_name
     *
     * @param sensorName the value for sensors_view.sensor_name, 
     */
    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    /**
     * 获取  字段:sensors_view.sensor_sn
     *
     * @return sensors_view.sensor_sn, 
     */
    public String getSensorSn() {
        return sensorSn;
    }

    /**
     * 设置  字段:sensors_view.sensor_sn
     *
     * @param sensorSn the value for sensors_view.sensor_sn, 
     */
    public void setSensorSn(String sensorSn) {
        this.sensorSn = sensorSn;
    }

    /**
     * 获取  字段:sensors_view.user_id
     *
     * @return sensors_view.user_id, 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置  字段:sensors_view.user_id
     *
     * @param userId the value for sensors_view.user_id, 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取  字段:sensors_view.longitude
     *
     * @return sensors_view.longitude, 
     */
    public Long getLongitude() {
        return longitude;
    }

    /**
     * 设置  字段:sensors_view.longitude
     *
     * @param longitude the value for sensors_view.longitude, 
     */
    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取  字段:sensors_view.latitude
     *
     * @return sensors_view.latitude, 
     */
    public Long getLatitude() {
        return latitude;
    }

    /**
     * 设置  字段:sensors_view.latitude
     *
     * @param latitude the value for sensors_view.latitude, 
     */
    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    /**
     * 获取  字段:sensors_view.type
     *
     * @return sensors_view.type, 
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置  字段:sensors_view.type
     *
     * @param type the value for sensors_view.type, 
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取  字段:sensors_view.ip
     *
     * @return sensors_view.ip, 
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置  字段:sensors_view.ip
     *
     * @param ip the value for sensors_view.ip, 
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取  字段:sensors_view.port
     *
     * @return sensors_view.port, 
     */
    public String getPort() {
        return port;
    }

    /**
     * 设置  字段:sensors_view.port
     *
     * @param port the value for sensors_view.port, 
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * 获取  字段:sensors_view.url
     *
     * @return sensors_view.url, 
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置  字段:sensors_view.url
     *
     * @param url the value for sensors_view.url, 
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取  字段:sensors_view.renderedurl
     *
     * @return sensors_view.renderedurl, 
     */
    public String getRenderedurl() {
        return renderedurl;
    }

    /**
     * 设置  字段:sensors_view.renderedurl
     *
     * @param renderedurl the value for sensors_view.renderedurl, 
     */
    public void setRenderedurl(String renderedurl) {
        this.renderedurl = renderedurl;
    }

    /**
     * 获取  字段:sensors_view.rtmpurl
     *
     * @return sensors_view.rtmpurl, 
     */
    public String getRtmpurl() {
        return rtmpurl;
    }

    /**
     * 设置  字段:sensors_view.rtmpurl
     *
     * @param rtmpurl the value for sensors_view.rtmpurl, 
     */
    public void setRtmpurl(String rtmpurl) {
        this.rtmpurl = rtmpurl;
    }

    /**
     * 获取  字段:sensors_view.live_active
     *
     * @return sensors_view.live_active, 
     */
    public Boolean getLiveActive() {
        return liveActive;
    }

    /**
     * 设置  字段:sensors_view.live_active
     *
     * @param liveActive the value for sensors_view.live_active, 
     */
    public void setLiveActive(Boolean liveActive) {
        this.liveActive = liveActive;
    }

    /**
     * 获取  字段:sensors_view.data_active
     *
     * @return sensors_view.data_active, 
     */
    public Boolean getDataActive() {
        return dataActive;
    }

    /**
     * 设置  字段:sensors_view.data_active
     *
     * @param dataActive the value for sensors_view.data_active, 
     */
    public void setDataActive(Boolean dataActive) {
        this.dataActive = dataActive;
    }

    /**
     * 获取  字段:sensors_view.comment
     *
     * @return sensors_view.comment, 
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置  字段:sensors_view.comment
     *
     * @param comment the value for sensors_view.comment, 
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取  字段:sensors_view.status
     *
     * @return sensors_view.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:sensors_view.status
     *
     * @param status the value for sensors_view.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取  字段:sensors_view.rois
     *
     * @return sensors_view.rois, 
     */
    public String getRois() {
        return rois;
    }

    /**
     * 设置  字段:sensors_view.rois
     *
     * @param rois the value for sensors_view.rois, 
     */
    public void setRois(String rois) {
        this.rois = rois;
    }

    /**
     * 获取  字段:sensors_view.repo_name
     *
     * @return sensors_view.repo_name, 
     */
    public String getRepoName() {
        return repoName;
    }

    /**
     * 设置  字段:sensors_view.repo_name
     *
     * @param repoName the value for sensors_view.repo_name, 
     */
    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }
}