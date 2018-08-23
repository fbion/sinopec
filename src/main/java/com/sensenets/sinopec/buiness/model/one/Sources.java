/**
  * Sources.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title sources表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:13:32
 */
public class Sources implements Serializable {
    /**
     * @Fields sourceId 
     */
    private String sourceId;

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
     * @Fields type 1:离线图片，2:离线视频
     */
    private Short type;

    /**
     * @Fields uri 
     */
    private String uri;

    /**
     * @Fields repoId 
     */
    private String repoId;

    /**
     * @Fields sensorId 
     */
    private String sensorId;

    /**
     * @Fields status 
     */
    private Short status;

    /**
     * @Fields comment 
     */
    private String comment;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:sources.source_id
     *
     * @return sources.source_id, 
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置  字段:sources.source_id
     *
     * @param sourceId the value for sources.source_id, 
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 获取  字段:sources.id
     *
     * @return sources.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:sources.id
     *
     * @param id the value for sources.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:sources.uts
     *
     * @return sources.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:sources.uts
     *
     * @param uts the value for sources.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:sources.name
     *
     * @return sources.name, 
     */
    public String getName() {
        return name;
    }

    /**
     * 设置  字段:sources.name
     *
     * @param name the value for sources.name, 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 1:离线图片，2:离线视频 字段:sources.type
     *
     * @return sources.type, 1:离线图片，2:离线视频
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置 1:离线图片，2:离线视频 字段:sources.type
     *
     * @param type the value for sources.type, 1:离线图片，2:离线视频
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取  字段:sources.uri
     *
     * @return sources.uri, 
     */
    public String getUri() {
        return uri;
    }

    /**
     * 设置  字段:sources.uri
     *
     * @param uri the value for sources.uri, 
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 获取  字段:sources.repo_id
     *
     * @return sources.repo_id, 
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * 设置  字段:sources.repo_id
     *
     * @param repoId the value for sources.repo_id, 
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    /**
     * 获取  字段:sources.sensor_id
     *
     * @return sources.sensor_id, 
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * 设置  字段:sources.sensor_id
     *
     * @param sensorId the value for sources.sensor_id, 
     */
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * 获取  字段:sources.status
     *
     * @return sources.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:sources.status
     *
     * @param status the value for sources.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取  字段:sources.comment
     *
     * @return sources.comment, 
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置  字段:sources.comment
     *
     * @param comment the value for sources.comment, 
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}