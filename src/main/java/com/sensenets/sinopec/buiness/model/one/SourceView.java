/**
  * SourceView.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title source_view表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:16:17
 */
public class SourceView implements Serializable {
    /**
     * @Fields id 
     */
    private Long id;

    /**
     * @Fields uts 
     */
    private Date uts;

    /**
     * @Fields sourceId 
     */
    private String sourceId;

    /**
     * @Fields name 
     */
    private String name;

    /**
     * @Fields type 
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
     * @Fields repoName 
     */
    private String repoName;

    /**
     * @Fields sensorName 
     */
    private String sensorName;

    /**
     * @Fields comment 
     */
    private String comment;

    /**
     * @Fields sourceComment 
     */
    private String sourceComment;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:source_view.id
     *
     * @return source_view.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:source_view.id
     *
     * @param id the value for source_view.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:source_view.uts
     *
     * @return source_view.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:source_view.uts
     *
     * @param uts the value for source_view.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:source_view.source_id
     *
     * @return source_view.source_id, 
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置  字段:source_view.source_id
     *
     * @param sourceId the value for source_view.source_id, 
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 获取  字段:source_view.name
     *
     * @return source_view.name, 
     */
    public String getName() {
        return name;
    }

    /**
     * 设置  字段:source_view.name
     *
     * @param name the value for source_view.name, 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取  字段:source_view.type
     *
     * @return source_view.type, 
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置  字段:source_view.type
     *
     * @param type the value for source_view.type, 
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取  字段:source_view.uri
     *
     * @return source_view.uri, 
     */
    public String getUri() {
        return uri;
    }

    /**
     * 设置  字段:source_view.uri
     *
     * @param uri the value for source_view.uri, 
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 获取  字段:source_view.repo_id
     *
     * @return source_view.repo_id, 
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * 设置  字段:source_view.repo_id
     *
     * @param repoId the value for source_view.repo_id, 
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    /**
     * 获取  字段:source_view.sensor_id
     *
     * @return source_view.sensor_id, 
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * 设置  字段:source_view.sensor_id
     *
     * @param sensorId the value for source_view.sensor_id, 
     */
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * 获取  字段:source_view.status
     *
     * @return source_view.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:source_view.status
     *
     * @param status the value for source_view.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取  字段:source_view.repo_name
     *
     * @return source_view.repo_name, 
     */
    public String getRepoName() {
        return repoName;
    }

    /**
     * 设置  字段:source_view.repo_name
     *
     * @param repoName the value for source_view.repo_name, 
     */
    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    /**
     * 获取  字段:source_view.sensor_name
     *
     * @return source_view.sensor_name, 
     */
    public String getSensorName() {
        return sensorName;
    }

    /**
     * 设置  字段:source_view.sensor_name
     *
     * @param sensorName the value for source_view.sensor_name, 
     */
    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    /**
     * 获取  字段:source_view.comment
     *
     * @return source_view.comment, 
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置  字段:source_view.comment
     *
     * @param comment the value for source_view.comment, 
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取  字段:source_view.source_comment
     *
     * @return source_view.source_comment, 
     */
    public String getSourceComment() {
        return sourceComment;
    }

    /**
     * 设置  字段:source_view.source_comment
     *
     * @param sourceComment the value for source_view.source_comment, 
     */
    public void setSourceComment(String sourceComment) {
        this.sourceComment = sourceComment;
    }
}