/**
  * Tasks.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title tasks表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:13:55
 */
public class Tasks implements Serializable {
    /**
     * @Fields taskId 
     */
    private String taskId;

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
     * @Fields filterThreshold 
     */
    private Double filterThreshold;

    /**
     * @Fields snapshot 
     */
    private Integer snapshot;

    /**
     * @Fields priority 低:1, 中:2, 高:3
     */
    private Short priority;

    /**
     * @Fields userId 
     */
    private String userId;

    /**
     * @Fields lanes 
     */
    private String lanes;

    /**
     * @Fields additionalInfos 
     */
    private String additionalInfos;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:tasks.task_id
     *
     * @return tasks.task_id, 
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * 设置  字段:tasks.task_id
     *
     * @param taskId the value for tasks.task_id, 
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * 获取  字段:tasks.id
     *
     * @return tasks.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:tasks.id
     *
     * @param id the value for tasks.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:tasks.uts
     *
     * @return tasks.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:tasks.uts
     *
     * @param uts the value for tasks.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:tasks.name
     *
     * @return tasks.name, 
     */
    public String getName() {
        return name;
    }

    /**
     * 设置  字段:tasks.name
     *
     * @param name the value for tasks.name, 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取  字段:tasks.ts
     *
     * @return tasks.ts, 
     */
    public Long getTs() {
        return ts;
    }

    /**
     * 设置  字段:tasks.ts
     *
     * @param ts the value for tasks.ts, 
     */
    public void setTs(Long ts) {
        this.ts = ts;
    }

    /**
     * 获取  字段:tasks.source_id
     *
     * @return tasks.source_id, 
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置  字段:tasks.source_id
     *
     * @param sourceId the value for tasks.source_id, 
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 获取  字段:tasks.olympus_id
     *
     * @return tasks.olympus_id, 
     */
    public String getOlympusId() {
        return olympusId;
    }

    /**
     * 设置  字段:tasks.olympus_id
     *
     * @param olympusId the value for tasks.olympus_id, 
     */
    public void setOlympusId(String olympusId) {
        this.olympusId = olympusId;
    }

    /**
     * 获取  字段:tasks.stream_id
     *
     * @return tasks.stream_id, 
     */
    public String getStreamId() {
        return streamId;
    }

    /**
     * 设置  字段:tasks.stream_id
     *
     * @param streamId the value for tasks.stream_id, 
     */
    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    /**
     * 获取  字段:tasks.det_types
     *
     * @return tasks.det_types, 
     */
    public String getDetTypes() {
        return detTypes;
    }

    /**
     * 设置  字段:tasks.det_types
     *
     * @param detTypes the value for tasks.det_types, 
     */
    public void setDetTypes(String detTypes) {
        this.detTypes = detTypes;
    }

    /**
     * 获取  字段:tasks.speed
     *
     * @return tasks.speed, 
     */
    public Integer getSpeed() {
        return speed;
    }

    /**
     * 设置  字段:tasks.speed
     *
     * @param speed the value for tasks.speed, 
     */
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    /**
     * 获取  字段:tasks.relative_rois
     *
     * @return tasks.relative_rois, 
     */
    public String getRelativeRois() {
        return relativeRois;
    }

    /**
     * 设置  字段:tasks.relative_rois
     *
     * @param relativeRois the value for tasks.relative_rois, 
     */
    public void setRelativeRois(String relativeRois) {
        this.relativeRois = relativeRois;
    }

    /**
     * 获取  字段:tasks.polygon_rois
     *
     * @return tasks.polygon_rois, 
     */
    public String getPolygonRois() {
        return polygonRois;
    }

    /**
     * 设置  字段:tasks.polygon_rois
     *
     * @param polygonRois the value for tasks.polygon_rois, 
     */
    public void setPolygonRois(String polygonRois) {
        this.polygonRois = polygonRois;
    }

    /**
     * 获取  字段:tasks.user_configs
     *
     * @return tasks.user_configs, 
     */
    public String getUserConfigs() {
        return userConfigs;
    }

    /**
     * 设置  字段:tasks.user_configs
     *
     * @param userConfigs the value for tasks.user_configs, 
     */
    public void setUserConfigs(String userConfigs) {
        this.userConfigs = userConfigs;
    }

    /**
     * 获取  字段:tasks.base_time
     *
     * @return tasks.base_time, 
     */
    public Long getBaseTime() {
        return baseTime;
    }

    /**
     * 设置  字段:tasks.base_time
     *
     * @param baseTime the value for tasks.base_time, 
     */
    public void setBaseTime(Long baseTime) {
        this.baseTime = baseTime;
    }

    /**
     * 获取  字段:tasks.start_time
     *
     * @return tasks.start_time, 
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * 设置  字段:tasks.start_time
     *
     * @param startTime the value for tasks.start_time, 
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取  字段:tasks.terminate_time
     *
     * @return tasks.terminate_time, 
     */
    public Long getTerminateTime() {
        return terminateTime;
    }

    /**
     * 设置  字段:tasks.terminate_time
     *
     * @param terminateTime the value for tasks.terminate_time, 
     */
    public void setTerminateTime(Long terminateTime) {
        this.terminateTime = terminateTime;
    }

    /**
     * 获取  字段:tasks.finish_time
     *
     * @return tasks.finish_time, 
     */
    public Long getFinishTime() {
        return finishTime;
    }

    /**
     * 设置  字段:tasks.finish_time
     *
     * @param finishTime the value for tasks.finish_time, 
     */
    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取  字段:tasks.switcher
     *
     * @return tasks.switcher, 
     */
    public Short getSwitcher() {
        return switcher;
    }

    /**
     * 设置  字段:tasks.switcher
     *
     * @param switcher the value for tasks.switcher, 
     */
    public void setSwitcher(Short switcher) {
        this.switcher = switcher;
    }

    /**
     * 获取  字段:tasks.task_status
     *
     * @return tasks.task_status, 
     */
    public Short getTaskStatus() {
        return taskStatus;
    }

    /**
     * 设置  字段:tasks.task_status
     *
     * @param taskStatus the value for tasks.task_status, 
     */
    public void setTaskStatus(Short taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * 获取  字段:tasks.status
     *
     * @return tasks.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:tasks.status
     *
     * @param status the value for tasks.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取  字段:tasks.filter_threshold
     *
     * @return tasks.filter_threshold, 
     */
    public Double getFilterThreshold() {
        return filterThreshold;
    }

    /**
     * 设置  字段:tasks.filter_threshold
     *
     * @param filterThreshold the value for tasks.filter_threshold, 
     */
    public void setFilterThreshold(Double filterThreshold) {
        this.filterThreshold = filterThreshold;
    }

    /**
     * 获取  字段:tasks.snapshot
     *
     * @return tasks.snapshot, 
     */
    public Integer getSnapshot() {
        return snapshot;
    }

    /**
     * 设置  字段:tasks.snapshot
     *
     * @param snapshot the value for tasks.snapshot, 
     */
    public void setSnapshot(Integer snapshot) {
        this.snapshot = snapshot;
    }

    /**
     * 获取 低:1, 中:2, 高:3 字段:tasks.priority
     *
     * @return tasks.priority, 低:1, 中:2, 高:3
     */
    public Short getPriority() {
        return priority;
    }

    /**
     * 设置 低:1, 中:2, 高:3 字段:tasks.priority
     *
     * @param priority the value for tasks.priority, 低:1, 中:2, 高:3
     */
    public void setPriority(Short priority) {
        this.priority = priority;
    }

    /**
     * 获取  字段:tasks.user_id
     *
     * @return tasks.user_id, 
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置  字段:tasks.user_id
     *
     * @param userId the value for tasks.user_id, 
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取  字段:tasks.lanes
     *
     * @return tasks.lanes, 
     */
    public String getLanes() {
        return lanes;
    }

    /**
     * 设置  字段:tasks.lanes
     *
     * @param lanes the value for tasks.lanes, 
     */
    public void setLanes(String lanes) {
        this.lanes = lanes;
    }

    /**
     * 获取  字段:tasks.additional_infos
     *
     * @return tasks.additional_infos, 
     */
    public String getAdditionalInfos() {
        return additionalInfos;
    }

    /**
     * 设置  字段:tasks.additional_infos
     *
     * @param additionalInfos the value for tasks.additional_infos, 
     */
    public void setAdditionalInfos(String additionalInfos) {
        this.additionalInfos = additionalInfos;
    }
}