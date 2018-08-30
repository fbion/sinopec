/**
  * MobileCollectTask.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-29
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title public.mobile_collect_task表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-29 19:43:33
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="MobileCollectTask")
public class MobileCollectTask implements Serializable {
    /**
     * @Fields id 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * @Fields collectRepoId 采集的设备id
     */
    @ApiModelProperty(value = "采集的设备id")
    private String collectRepoId;

    /**
     * @Fields oilStationRepoId 油站id
     */
    @ApiModelProperty(value = "油站id")
    private String oilStationRepoId;

    /**
     * @Fields collectStartTime 采集开始时间
     */
    @ApiModelProperty(value = "采集开始时间")
    private Date collectStartTime;

    /**
     * @Fields collectEndTime 采集结束时间
     */
    @ApiModelProperty(value = "采集结束时间")
    private Date collectEndTime;

    /**
     * @Fields type 分析类型（1.进/出站流量2.站外流量3全部）
     */
    @ApiModelProperty(value = "分析类型（1.进/出站流量2.站外流量3全部）")
    private Short type;

    /**
     * @Fields uts 添加时间戳
     */
    @ApiModelProperty(value = "添加时间戳")
    private Date uts;

    /**
     * @Fields ts 时间戳
     */
    @ApiModelProperty(value = "时间戳")
    private Long ts;

    /**
     * @Fields userId 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * @Fields taskStatus 任务类型(1.正在分析,2.分析完成)
     */
    @ApiModelProperty(value = "任务类型(1.正在分析,2.分析完成)")
    private Short taskStatus;

    /**
     * @Fields status 状态(1正常   4 删除)
     */
    @ApiModelProperty(value = "状态(1正常   4 删除)")
    private Short status;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 主键 字段:public.mobile_collect_task.id
     *
     * @return public.mobile_collect_task.id, 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键 字段:public.mobile_collect_task.id
     *
     * @param id the value for public.mobile_collect_task.id, 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 采集的设备id 字段:public.mobile_collect_task.collect_repo_id
     *
     * @return public.mobile_collect_task.collect_repo_id, 采集的设备id
     */
    public String getCollectRepoId() {
        return collectRepoId;
    }

    /**
     * 设置 采集的设备id 字段:public.mobile_collect_task.collect_repo_id
     *
     * @param collectRepoId the value for public.mobile_collect_task.collect_repo_id, 采集的设备id
     */
    public void setCollectRepoId(String collectRepoId) {
        this.collectRepoId = collectRepoId;
    }

    /**
     * 获取 油站id 字段:public.mobile_collect_task.oil_station_repo_id
     *
     * @return public.mobile_collect_task.oil_station_repo_id, 油站id
     */
    public String getOilStationRepoId() {
        return oilStationRepoId;
    }

    /**
     * 设置 油站id 字段:public.mobile_collect_task.oil_station_repo_id
     *
     * @param oilStationRepoId the value for public.mobile_collect_task.oil_station_repo_id, 油站id
     */
    public void setOilStationRepoId(String oilStationRepoId) {
        this.oilStationRepoId = oilStationRepoId;
    }

    /**
     * 获取 采集开始时间 字段:public.mobile_collect_task.collect_start_time
     *
     * @return public.mobile_collect_task.collect_start_time, 采集开始时间
     */
    public Date getCollectStartTime() {
        return collectStartTime;
    }

    /**
     * 设置 采集开始时间 字段:public.mobile_collect_task.collect_start_time
     *
     * @param collectStartTime the value for public.mobile_collect_task.collect_start_time, 采集开始时间
     */
    public void setCollectStartTime(Date collectStartTime) {
        this.collectStartTime = collectStartTime;
    }

    /**
     * 获取 采集结束时间 字段:public.mobile_collect_task.collect_end_time
     *
     * @return public.mobile_collect_task.collect_end_time, 采集结束时间
     */
    public Date getCollectEndTime() {
        return collectEndTime;
    }

    /**
     * 设置 采集结束时间 字段:public.mobile_collect_task.collect_end_time
     *
     * @param collectEndTime the value for public.mobile_collect_task.collect_end_time, 采集结束时间
     */
    public void setCollectEndTime(Date collectEndTime) {
        this.collectEndTime = collectEndTime;
    }

    /**
     * 获取 分析类型（1.进/出站流量2.站外流量3全部） 字段:public.mobile_collect_task.type
     *
     * @return public.mobile_collect_task.type, 分析类型（1.进/出站流量2.站外流量3全部）
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置 分析类型（1.进/出站流量2.站外流量3全部） 字段:public.mobile_collect_task.type
     *
     * @param type the value for public.mobile_collect_task.type, 分析类型（1.进/出站流量2.站外流量3全部）
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取 添加时间戳 字段:public.mobile_collect_task.uts
     *
     * @return public.mobile_collect_task.uts, 添加时间戳
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置 添加时间戳 字段:public.mobile_collect_task.uts
     *
     * @param uts the value for public.mobile_collect_task.uts, 添加时间戳
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取 时间戳 字段:public.mobile_collect_task.ts
     *
     * @return public.mobile_collect_task.ts, 时间戳
     */
    public Long getTs() {
        return ts;
    }

    /**
     * 设置 时间戳 字段:public.mobile_collect_task.ts
     *
     * @param ts the value for public.mobile_collect_task.ts, 时间戳
     */
    public void setTs(Long ts) {
        this.ts = ts;
    }

    /**
     * 获取 用户id 字段:public.mobile_collect_task.user_id
     *
     * @return public.mobile_collect_task.user_id, 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置 用户id 字段:public.mobile_collect_task.user_id
     *
     * @param userId the value for public.mobile_collect_task.user_id, 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 任务类型(1.正在分析,2.分析完成) 字段:public.mobile_collect_task.task_status
     *
     * @return public.mobile_collect_task.task_status, 任务类型(1.正在分析,2.分析完成)
     */
    public Short getTaskStatus() {
        return taskStatus;
    }

    /**
     * 设置 任务类型(1.正在分析,2.分析完成) 字段:public.mobile_collect_task.task_status
     *
     * @param taskStatus the value for public.mobile_collect_task.task_status, 任务类型(1.正在分析,2.分析完成)
     */
    public void setTaskStatus(Short taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * 获取 状态(1正常   4 删除) 字段:public.mobile_collect_task.status
     *
     * @return public.mobile_collect_task.status, 状态(1正常   4 删除)
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置 状态(1正常   4 删除) 字段:public.mobile_collect_task.status
     *
     * @param status the value for public.mobile_collect_task.status, 状态(1正常   4 删除)
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}