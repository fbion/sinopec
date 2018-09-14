/**
  * VehicleQueueAnalysis.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-14
  */
package com.sensenets.sinopec.buiness.model.two;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title public.vehicle_queue_analysis表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-09-14 16:28:28
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="VehicleQueueAnalysis")
public class VehicleQueueAnalysis implements Serializable {
    /**
     * @Fields id 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * @Fields dataDay 天yyyyMMdd
     */
    @ApiModelProperty(value = "天yyyyMMdd")
    private Integer dataDay;

    /**
     * @Fields reposId 油站id
     */
    @ApiModelProperty(value = "油站id")
    private String reposId;

    /**
     * @Fields vehicleType 车辆类型
     */
    @ApiModelProperty(value = "车辆类型")
    private Short vehicleType;

    /**
     * @Fields oilType 油品类型(1.汽油 2.柴油)
     */
    @ApiModelProperty(value = "油品类型(1.汽油 2.柴油)")
    private String oilType;

    /**
     * @Fields bizId 业务id
     */
    @ApiModelProperty(value = "业务id")
    private String bizId;

    /**
     * @Fields dataHour 小时yyyyMMddHH
     */
    @ApiModelProperty(value = "小时yyyyMMddHH")
    private Integer dataHour;

    /**
     * @Fields time5 排队时间0-5分钟
     */
    @ApiModelProperty(value = "排队时间0-5分钟")
    private Long time5;

    /**
     * @Fields time10 排队时间5-10分钟
     */
    @ApiModelProperty(value = "排队时间5-10分钟")
    private Long time10;

    /**
     * @Fields time15 排队时间10-15分钟
     */
    @ApiModelProperty(value = "排队时间10-15分钟")
    private Long time15;

    /**
     * @Fields time20 排队时间15-20分钟
     */
    @ApiModelProperty(value = "排队时间15-20分钟")
    private Long time20;

    /**
     * @Fields time25 排队时间20分钟以上
     */
    @ApiModelProperty(value = "排队时间20分钟以上")
    private Long time25;

    /**
     * @Fields uts 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    private Date uts;

    private static final long serialVersionUID = 1L;

    /**
     * 获取 主键 字段:public.vehicle_queue_analysis.id
     *
     * @return public.vehicle_queue_analysis.id, 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键 字段:public.vehicle_queue_analysis.id
     *
     * @param id the value for public.vehicle_queue_analysis.id, 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 天yyyyMMdd 字段:public.vehicle_queue_analysis.data_day
     *
     * @return public.vehicle_queue_analysis.data_day, 天yyyyMMdd
     */
    public Integer getDataDay() {
        return dataDay;
    }

    /**
     * 设置 天yyyyMMdd 字段:public.vehicle_queue_analysis.data_day
     *
     * @param dataDay the value for public.vehicle_queue_analysis.data_day, 天yyyyMMdd
     */
    public void setDataDay(Integer dataDay) {
        this.dataDay = dataDay;
    }

    /**
     * 获取 油站id 字段:public.vehicle_queue_analysis.repos_id
     *
     * @return public.vehicle_queue_analysis.repos_id, 油站id
     */
    public String getReposId() {
        return reposId;
    }

    /**
     * 设置 油站id 字段:public.vehicle_queue_analysis.repos_id
     *
     * @param reposId the value for public.vehicle_queue_analysis.repos_id, 油站id
     */
    public void setReposId(String reposId) {
        this.reposId = reposId;
    }

    /**
     * 获取 车辆类型 字段:public.vehicle_queue_analysis.vehicle_type
     *
     * @return public.vehicle_queue_analysis.vehicle_type, 车辆类型
     */
    public Short getVehicleType() {
        return vehicleType;
    }

    /**
     * 设置 车辆类型 字段:public.vehicle_queue_analysis.vehicle_type
     *
     * @param vehicleType the value for public.vehicle_queue_analysis.vehicle_type, 车辆类型
     */
    public void setVehicleType(Short vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * 获取 油品类型(1.汽油 2.柴油) 字段:public.vehicle_queue_analysis.oil_type
     *
     * @return public.vehicle_queue_analysis.oil_type, 油品类型(1.汽油 2.柴油)
     */
    public String getOilType() {
        return oilType;
    }

    /**
     * 设置 油品类型(1.汽油 2.柴油) 字段:public.vehicle_queue_analysis.oil_type
     *
     * @param oilType the value for public.vehicle_queue_analysis.oil_type, 油品类型(1.汽油 2.柴油)
     */
    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    /**
     * 获取 业务id 字段:public.vehicle_queue_analysis.biz_id
     *
     * @return public.vehicle_queue_analysis.biz_id, 业务id
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * 设置 业务id 字段:public.vehicle_queue_analysis.biz_id
     *
     * @param bizId the value for public.vehicle_queue_analysis.biz_id, 业务id
     */
    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    /**
     * 获取 小时yyyyMMddHH 字段:public.vehicle_queue_analysis.data_hour
     *
     * @return public.vehicle_queue_analysis.data_hour, 小时yyyyMMddHH
     */
    public Integer getDataHour() {
        return dataHour;
    }

    /**
     * 设置 小时yyyyMMddHH 字段:public.vehicle_queue_analysis.data_hour
     *
     * @param dataHour the value for public.vehicle_queue_analysis.data_hour, 小时yyyyMMddHH
     */
    public void setDataHour(Integer dataHour) {
        this.dataHour = dataHour;
    }

    /**
     * 获取 排队时间0-5分钟 字段:public.vehicle_queue_analysis.time5
     *
     * @return public.vehicle_queue_analysis.time5, 排队时间0-5分钟
     */
    public Long getTime5() {
        return time5;
    }

    /**
     * 设置 排队时间0-5分钟 字段:public.vehicle_queue_analysis.time5
     *
     * @param time5 the value for public.vehicle_queue_analysis.time5, 排队时间0-5分钟
     */
    public void setTime5(Long time5) {
        this.time5 = time5;
    }

    /**
     * 获取 排队时间5-10分钟 字段:public.vehicle_queue_analysis.time10
     *
     * @return public.vehicle_queue_analysis.time10, 排队时间5-10分钟
     */
    public Long getTime10() {
        return time10;
    }

    /**
     * 设置 排队时间5-10分钟 字段:public.vehicle_queue_analysis.time10
     *
     * @param time10 the value for public.vehicle_queue_analysis.time10, 排队时间5-10分钟
     */
    public void setTime10(Long time10) {
        this.time10 = time10;
    }

    /**
     * 获取 排队时间10-15分钟 字段:public.vehicle_queue_analysis.time15
     *
     * @return public.vehicle_queue_analysis.time15, 排队时间10-15分钟
     */
    public Long getTime15() {
        return time15;
    }

    /**
     * 设置 排队时间10-15分钟 字段:public.vehicle_queue_analysis.time15
     *
     * @param time15 the value for public.vehicle_queue_analysis.time15, 排队时间10-15分钟
     */
    public void setTime15(Long time15) {
        this.time15 = time15;
    }

    /**
     * 获取 排队时间15-20分钟 字段:public.vehicle_queue_analysis.time20
     *
     * @return public.vehicle_queue_analysis.time20, 排队时间15-20分钟
     */
    public Long getTime20() {
        return time20;
    }

    /**
     * 设置 排队时间15-20分钟 字段:public.vehicle_queue_analysis.time20
     *
     * @param time20 the value for public.vehicle_queue_analysis.time20, 排队时间15-20分钟
     */
    public void setTime20(Long time20) {
        this.time20 = time20;
    }

    /**
     * 获取 排队时间20分钟以上 字段:public.vehicle_queue_analysis.time25
     *
     * @return public.vehicle_queue_analysis.time25, 排队时间20分钟以上
     */
    public Long getTime25() {
        return time25;
    }

    /**
     * 设置 排队时间20分钟以上 字段:public.vehicle_queue_analysis.time25
     *
     * @param time25 the value for public.vehicle_queue_analysis.time25, 排队时间20分钟以上
     */
    public void setTime25(Long time25) {
        this.time25 = time25;
    }

    /**
     * 获取 添加时间 字段:public.vehicle_queue_analysis.uts
     *
     * @return public.vehicle_queue_analysis.uts, 添加时间
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置 添加时间 字段:public.vehicle_queue_analysis.uts
     *
     * @param uts the value for public.vehicle_queue_analysis.uts, 添加时间
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }
}