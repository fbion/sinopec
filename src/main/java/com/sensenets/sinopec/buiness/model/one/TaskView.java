/**
  * TaskView.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title task_view表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:16:43
 */
public class TaskView implements Serializable {
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
     * @Fields ts 
     */
    private Long ts;

    /**
     * @Fields sourceId 
     */
    private String sourceId;

    /**
     * @Fields olympusId 
     */
    private String olympusId;

    /**
     * @Fields streamId 
     */
    private String streamId;

    /**
     * @Fields detTypes 
     */
    private String detTypes;

    /**
     * @Fields speed 
     */
    private Integer speed;

    /**
     * @Fields relativeRois 
     */
    private String relativeRois;

    /**
     * @Fields polygonRois 
     */
    private String polygonRois;

    /**
     * @Fields filterThreshold 
     */
    private Double filterThreshold;

    /**
     * @Fields userConfigs 
     */
    private String userConfigs;

    /**
     * @Fields baseTime 
     */
    private Long baseTime;

    /**
     * @Fields startTime 
     */
    private Long startTime;

    /**
     * @Fields terminateTime 
     */
    private Long terminateTime;

    /**
     * @Fields finishTime 
     */
    private Long finishTime;

    /**
     * @Fields switcher 
     */
    private Short switcher;

    /**
     * @Fields taskStatus 
     */
    private Short taskStatus;

    /**
     * @Fields status 
     */
    private Short status;

    /**
     * @Fields snapshot 
     */
    private Integer snapshot;

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
     * @Fields repoName 
     */
    private String repoName;

    /**
     * @Fields sensorId 
     */
    private String sensorId;

    /**
     * @Fields sensorName 
     */
    private String sensorName;

    /**
     * @Fields taskId 
     */
    private String taskId;

    /**
     * @Fields userId 
     */
    private String userId;

    /**
     * @Fields priority 
     */
    private Short priority;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:task_view.id
     *
     * @return task_view.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:task_view.id
     *
     * @param id the value for task_view.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:task_view.uts
     *
     * @return task_view.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:task_view.uts
     *
     * @param uts the value for task_view.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:task_view.name
     *
     * @return task_view.name, 
     */
    public String getName() {
        return name;
    }

    /**
     * 设置  字段:task_view.name
     *
     * @param name the value for task_view.name, 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取  字段:task_view.ts
     *
     * @return task_view.ts, 
     */
    public Long getTs() {
        return ts;
    }

    /**
     * 设置  字段:task_view.ts
     *
     * @param ts the value for task_view.ts, 
     */
    public void setTs(Long ts) {
        this.ts = ts;
    }

    /**
     * 获取  字段:task_view.source_id
     *
     * @return task_view.source_id, 
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置  字段:task_view.source_id
     *
     * @param sourceId the value for task_view.source_id, 
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 获取  字段:task_view.olympus_id
     *
     * @return task_view.olympus_id, 
     */
    public String getOlympusId() {
        return olympusId;
    }

    /**
     * 设置  字段:task_view.olympus_id
     *
     * @param olympusId the value for task_view.olympus_id, 
     */
    public void setOlympusId(String olympusId) {
        this.olympusId = olympusId;
    }

    /**
     * 获取  字段:task_view.stream_id
     *
     * @return task_view.stream_id, 
     */
    public String getStreamId() {
        return streamId;
    }

    /**
     * 设置  字段:task_view.stream_id
     *
     * @param streamId the value for task_view.stream_id, 
     */
    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    /**
     * 获取  字段:task_view.det_types
     *
     * @return task_view.det_types, 
     */
    public String getDetTypes() {
        return detTypes;
    }

    /**
     * 设置  字段:task_view.det_types
     *
     * @param detTypes the value for task_view.det_types, 
     */
    public void setDetTypes(String detTypes) {
        this.detTypes = detTypes;
    }

    /**
     * 获取  字段:task_view.speed
     *
     * @return task_view.speed, 
     */
    public Integer getSpeed() {
        return speed;
    }

    /**
     * 设置  字段:task_view.speed
     *
     * @param speed the value for task_view.speed, 
     */
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    /**
     * 获取  字段:task_view.relative_rois
     *
     * @return task_view.relative_rois, 
     */
    public String getRelativeRois() {
        return relativeRois;
    }

    /**
     * 设置  字段:task_view.relative_rois
     *
     * @param relativeRois the value for task_view.relative_rois, 
     */
    public void setRelativeRois(String relativeRois) {
        this.relativeRois = relativeRois;
    }

    /**
     * 获取  字段:task_view.polygon_rois
     *
     * @return task_view.polygon_rois, 
     */
    public String getPolygonRois() {
        return polygonRois;
    }

    /**
     * 设置  字段:task_view.polygon_rois
     *
     * @param polygonRois the value for task_view.polygon_rois, 
     */
    public void setPolygonRois(String polygonRois) {
        this.polygonRois = polygonRois;
    }

    /**
     * 获取  字段:task_view.filter_threshold
     *
     * @return task_view.filter_threshold, 
     */
    public Double getFilterThreshold() {
        return filterThreshold;
    }

    /**
     * 设置  字段:task_view.filter_threshold
     *
     * @param filterThreshold the value for task_view.filter_threshold, 
     */
    public void setFilterThreshold(Double filterThreshold) {
        this.filterThreshold = filterThreshold;
    }

    /**
     * 获取  字段:task_view.user_configs
     *
     * @return task_view.user_configs, 
     */
    public String getUserConfigs() {
        return userConfigs;
    }

    /**
     * 设置  字段:task_view.user_configs
     *
     * @param userConfigs the value for task_view.user_configs, 
     */
    public void setUserConfigs(String userConfigs) {
        this.userConfigs = userConfigs;
    }

    /**
     * 获取  字段:task_view.base_time
     *
     * @return task_view.base_time, 
     */
    public Long getBaseTime() {
        return baseTime;
    }

    /**
     * 设置  字段:task_view.base_time
     *
     * @param baseTime the value for task_view.base_time, 
     */
    public void setBaseTime(Long baseTime) {
        this.baseTime = baseTime;
    }

    /**
     * 获取  字段:task_view.start_time
     *
     * @return task_view.start_time, 
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * 设置  字段:task_view.start_time
     *
     * @param startTime the value for task_view.start_time, 
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取  字段:task_view.terminate_time
     *
     * @return task_view.terminate_time, 
     */
    public Long getTerminateTime() {
        return terminateTime;
    }

    /**
     * 设置  字段:task_view.terminate_time
     *
     * @param terminateTime the value for task_view.terminate_time, 
     */
    public void setTerminateTime(Long terminateTime) {
        this.terminateTime = terminateTime;
    }

    /**
     * 获取  字段:task_view.finish_time
     *
     * @return task_view.finish_time, 
     */
    public Long getFinishTime() {
        return finishTime;
    }

    /**
     * 设置  字段:task_view.finish_time
     *
     * @param finishTime the value for task_view.finish_time, 
     */
    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取  字段:task_view.switcher
     *
     * @return task_view.switcher, 
     */
    public Short getSwitcher() {
        return switcher;
    }

    /**
     * 设置  字段:task_view.switcher
     *
     * @param switcher the value for task_view.switcher, 
     */
    public void setSwitcher(Short switcher) {
        this.switcher = switcher;
    }

    /**
     * 获取  字段:task_view.task_status
     *
     * @return task_view.task_status, 
     */
    public Short getTaskStatus() {
        return taskStatus;
    }

    /**
     * 设置  字段:task_view.task_status
     *
     * @param taskStatus the value for task_view.task_status, 
     */
    public void setTaskStatus(Short taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * 获取  字段:task_view.status
     *
     * @return task_view.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:task_view.status
     *
     * @param status the value for task_view.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取  字段:task_view.snapshot
     *
     * @return task_view.snapshot, 
     */
    public Integer getSnapshot() {
        return snapshot;
    }

    /**
     * 设置  字段:task_view.snapshot
     *
     * @param snapshot the value for task_view.snapshot, 
     */
    public void setSnapshot(Integer snapshot) {
        this.snapshot = snapshot;
    }

    /**
     * 获取  字段:task_view.type
     *
     * @return task_view.type, 
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置  字段:task_view.type
     *
     * @param type the value for task_view.type, 
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取  字段:task_view.uri
     *
     * @return task_view.uri, 
     */
    public String getUri() {
        return uri;
    }

    /**
     * 设置  字段:task_view.uri
     *
     * @param uri the value for task_view.uri, 
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 获取  字段:task_view.repo_id
     *
     * @return task_view.repo_id, 
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * 设置  字段:task_view.repo_id
     *
     * @param repoId the value for task_view.repo_id, 
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    /**
     * 获取  字段:task_view.repo_name
     *
     * @return task_view.repo_name, 
     */
    public String getRepoName() {
        return repoName;
    }

    /**
     * 设置  字段:task_view.repo_name
     *
     * @param repoName the value for task_view.repo_name, 
     */
    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    /**
     * 获取  字段:task_view.sensor_id
     *
     * @return task_view.sensor_id, 
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * 设置  字段:task_view.sensor_id
     *
     * @param sensorId the value for task_view.sensor_id, 
     */
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * 获取  字段:task_view.sensor_name
     *
     * @return task_view.sensor_name, 
     */
    public String getSensorName() {
        return sensorName;
    }

    /**
     * 设置  字段:task_view.sensor_name
     *
     * @param sensorName the value for task_view.sensor_name, 
     */
    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    /**
     * 获取  字段:task_view.task_id
     *
     * @return task_view.task_id, 
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置  字段:task_view.task_id
     *
     * @param taskId the value for task_view.task_id, 
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * 获取  字段:task_view.user_id
     *
     * @return task_view.user_id, 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置  字段:task_view.user_id
     *
     * @param userId the value for task_view.user_id, 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取  字段:task_view.priority
     *
     * @return task_view.priority, 
     */
    public Short getPriority() {
        return priority;
    }

    /**
     * 设置  字段:task_view.priority
     *
     * @param priority the value for task_view.priority, 
     */
    public void setPriority(Short priority) {
        this.priority = priority;
    }
}