/**
  * CollectResultFlow.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-29
  */
package com.sensenets.sinopec.buiness.model.two;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title public.collect_result_flow表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-29 16:48:21
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="CollectResultFlow")
public class CollectResultFlow implements Serializable {
    /**
     * @Fields id 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * @Fields collectTaskId 采集任务id
     */
    @ApiModelProperty(value = "采集任务id")
    private Long collectTaskId;

    /**
     * @Fields mobRepId 移动采集组织机构id
     */
    @ApiModelProperty(value = "移动采集组织机构id")
    private Long mobRepId;

    /**
     * @Fields stationRepId 油站组织机构id
     */
    @ApiModelProperty(value = "油站组织机构id")
    private Long stationRepId;

    /**
     * @Fields dataHour 小时（yyyyMMddhh）
     */
    @ApiModelProperty(value = "小时（yyyyMMddhh）")
    private Integer dataHour;

    /**
     * @Fields dataDay 天（yyyyMMdd）
     */
    @ApiModelProperty(value = "天（yyyyMMdd）")
    private Integer dataDay;

    /**
     * @Fields collectInCount 采集进出数据量
     */
    @ApiModelProperty(value = "采集进出数据量")
    private Integer collectInCount;

    /**
     * @Fields stationInCount 油站进出数据量
     */
    @ApiModelProperty(value = "油站进出数据量")
    private Integer stationInCount;

    /**
     * @Fields collectOutCount 采集站外数据量
     */
    @ApiModelProperty(value = "采集站外数据量")
    private Integer collectOutCount;

    /**
     * @Fields stationOutCount 油站站外数据量
     */
    @ApiModelProperty(value = "油站站外数据量")
    private Integer stationOutCount;

    /**
     * @Fields uts 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    private Date uts;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 主键 字段:public.collect_result_flow.id
     *
     * @return public.collect_result_flow.id, 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键 字段:public.collect_result_flow.id
     *
     * @param id the value for public.collect_result_flow.id, 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 采集任务id 字段:public.collect_result_flow.collect_task_id
     *
     * @return public.collect_result_flow.collect_task_id, 采集任务id
     */
    public Long getCollectTaskId() {
        return collectTaskId;
    }

    /**
     * 设置 采集任务id 字段:public.collect_result_flow.collect_task_id
     *
     * @param collectTaskId the value for public.collect_result_flow.collect_task_id, 采集任务id
     */
    public void setCollectTaskId(Long collectTaskId) {
        this.collectTaskId = collectTaskId;
    }

    /**
     * 获取 移动采集组织机构id 字段:public.collect_result_flow.mob_rep_id
     *
     * @return public.collect_result_flow.mob_rep_id, 移动采集组织机构id
     */
    public Long getMobRepId() {
        return mobRepId;
    }

    /**
     * 设置 移动采集组织机构id 字段:public.collect_result_flow.mob_rep_id
     *
     * @param mobRepId the value for public.collect_result_flow.mob_rep_id, 移动采集组织机构id
     */
    public void setMobRepId(Long mobRepId) {
        this.mobRepId = mobRepId;
    }

    /**
     * 获取 油站组织机构id 字段:public.collect_result_flow.station_rep_id
     *
     * @return public.collect_result_flow.station_rep_id, 油站组织机构id
     */
    public Long getStationRepId() {
        return stationRepId;
    }

    /**
     * 设置 油站组织机构id 字段:public.collect_result_flow.station_rep_id
     *
     * @param stationRepId the value for public.collect_result_flow.station_rep_id, 油站组织机构id
     */
    public void setStationRepId(Long stationRepId) {
        this.stationRepId = stationRepId;
    }

    /**
     * 获取 小时（yyyyMMddhh） 字段:public.collect_result_flow.data_hour
     *
     * @return public.collect_result_flow.data_hour, 小时（yyyyMMddhh）
     */
    public Integer getDataHour() {
        return dataHour;
    }

    /**
     * 设置 小时（yyyyMMddhh） 字段:public.collect_result_flow.data_hour
     *
     * @param dataHour the value for public.collect_result_flow.data_hour, 小时（yyyyMMddhh）
     */
    public void setDataHour(Integer dataHour) {
        this.dataHour = dataHour;
    }

    /**
     * 获取 天（yyyyMMdd） 字段:public.collect_result_flow.data_day
     *
     * @return public.collect_result_flow.data_day, 天（yyyyMMdd）
     */
    public Integer getDataDay() {
        return dataDay;
    }

    /**
     * 设置 天（yyyyMMdd） 字段:public.collect_result_flow.data_day
     *
     * @param dataDay the value for public.collect_result_flow.data_day, 天（yyyyMMdd）
     */
    public void setDataDay(Integer dataDay) {
        this.dataDay = dataDay;
    }

    /**
     * 获取 采集进出数据量 字段:public.collect_result_flow.collect_in_count
     *
     * @return public.collect_result_flow.collect_in_count, 采集进出数据量
     */
    public Integer getCollectInCount() {
        return collectInCount;
    }

    /**
     * 设置 采集进出数据量 字段:public.collect_result_flow.collect_in_count
     *
     * @param collectInCount the value for public.collect_result_flow.collect_in_count, 采集进出数据量
     */
    public void setCollectInCount(Integer collectInCount) {
        this.collectInCount = collectInCount;
    }

    /**
     * 获取 油站进出数据量 字段:public.collect_result_flow.station_in_count
     *
     * @return public.collect_result_flow.station_in_count, 油站进出数据量
     */
    public Integer getStationInCount() {
        return stationInCount;
    }

    /**
     * 设置 油站进出数据量 字段:public.collect_result_flow.station_in_count
     *
     * @param stationInCount the value for public.collect_result_flow.station_in_count, 油站进出数据量
     */
    public void setStationInCount(Integer stationInCount) {
        this.stationInCount = stationInCount;
    }

    /**
     * 获取 采集站外数据量 字段:public.collect_result_flow.collect_out_count
     *
     * @return public.collect_result_flow.collect_out_count, 采集站外数据量
     */
    public Integer getCollectOutCount() {
        return collectOutCount;
    }

    /**
     * 设置 采集站外数据量 字段:public.collect_result_flow.collect_out_count
     *
     * @param collectOutCount the value for public.collect_result_flow.collect_out_count, 采集站外数据量
     */
    public void setCollectOutCount(Integer collectOutCount) {
        this.collectOutCount = collectOutCount;
    }

    /**
     * 获取 油站站外数据量 字段:public.collect_result_flow.station_out_count
     *
     * @return public.collect_result_flow.station_out_count, 油站站外数据量
     */
    public Integer getStationOutCount() {
        return stationOutCount;
    }

    /**
     * 设置 油站站外数据量 字段:public.collect_result_flow.station_out_count
     *
     * @param stationOutCount the value for public.collect_result_flow.station_out_count, 油站站外数据量
     */
    public void setStationOutCount(Integer stationOutCount) {
        this.stationOutCount = stationOutCount;
    }

    /**
     * 获取 添加时间 字段:public.collect_result_flow.uts
     *
     * @return public.collect_result_flow.uts, 添加时间
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置 添加时间 字段:public.collect_result_flow.uts
     *
     * @param uts the value for public.collect_result_flow.uts, 添加时间
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }
}