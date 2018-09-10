/**
  * VehicleQueue.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-10
  */
package com.sensenets.sinopec.buiness.model.two;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title public.vehicle_queue表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-09-10 12:48:47
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="VehicleQueue")
public class VehicleQueue implements Serializable {
    /**
     * @Fields id 
     */
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * @Fields bizId 业务主键
     */
    @ApiModelProperty(value = "业务主键")
    private String bizId;

    /**
     * @Fields uts 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    private Date uts;

    /**
     * @Fields queueTime 排队时间(毫秒)
     */
    @ApiModelProperty(value = "排队时间(毫秒)")
    private Long queueTime;

    /**
     * @Fields inSensorId 进站设备id
     */
    @ApiModelProperty(value = "进站设备id")
    private Long inSensorId;

    /**
     * @Fields inSensorName 进站设备名称
     */
    @ApiModelProperty(value = "进站设备名称")
    private String inSensorName;

    /**
     * @Fields inImageId 进站图片id
     */
    @ApiModelProperty(value = "进站图片id")
    private String inImageId;

    /**
     * @Fields inSourceImage 进站原图
     */
    @ApiModelProperty(value = "进站原图")
    private String inSourceImage;

    /**
     * @Fields inFeatureImage 进站特征图
     */
    @ApiModelProperty(value = "进站特征图")
    private String inFeatureImage;

    /**
     * @Fields inTime 进站时间
     */
    @ApiModelProperty(value = "进站时间")
    private Date inTime;

    /**
     * @Fields outSensorId 进站设备id
     */
    @ApiModelProperty(value = "进站设备id")
    private Long outSensorId;

    /**
     * @Fields outSensorName 进站设备名称
     */
    @ApiModelProperty(value = "进站设备名称")
    private String outSensorName;

    /**
     * @Fields outImageId 进站图片id
     */
    @ApiModelProperty(value = "进站图片id")
    private String outImageId;

    /**
     * @Fields outSourceImage 进站原图
     */
    @ApiModelProperty(value = "进站原图")
    private String outSourceImage;

    /**
     * @Fields outFeatureImage 进站特征图
     */
    @ApiModelProperty(value = "进站特征图")
    private String outFeatureImage;

    /**
     * @Fields outTime 进站时间
     */
    @ApiModelProperty(value = "进站时间")
    private Date outTime;

    /**
     * @Fields inBrandId 进站品牌-子品牌-年款
     */
    @ApiModelProperty(value = "进站品牌-子品牌-年款")
    private Short inBrandId;

    /**
     * @Fields inPlateColorId 进站车牌颜色
     */
    @ApiModelProperty(value = "进站车牌颜色")
    private Short inPlateColorId;

    /**
     * @Fields inPlateTypeId 进站车牌类型
     */
    @ApiModelProperty(value = "进站车牌类型")
    private Short inPlateTypeId;

    /**
     * @Fields inAngleId 进站车角度
     */
    @ApiModelProperty(value = "进站车角度")
    private Short inAngleId;

    /**
     * @Fields inColorId 进站车辆颜色
     */
    @ApiModelProperty(value = "进站车辆颜色")
    private Short inColorId;

    /**
     * @Fields inTypeId 进站车辆类型
     */
    @ApiModelProperty(value = "进站车辆类型")
    private Short inTypeId;

    /**
     * @Fields reposId 油站id
     */
    @ApiModelProperty(value = "油站id")
    private Long reposId;

    /**
     * @Fields reposName 油站名称
     */
    @ApiModelProperty(value = "油站名称")
    private String reposName;

    /**
     * @Fields outBrandId 出站品牌-子品牌-年款
     */
    @ApiModelProperty(value = "出站品牌-子品牌-年款")
    private Short outBrandId;

    /**
     * @Fields outPlateColorId 出站车牌颜色
     */
    @ApiModelProperty(value = "出站车牌颜色")
    private Short outPlateColorId;

    /**
     * @Fields outPlateTypeId 出站车牌类型
     */
    @ApiModelProperty(value = "出站车牌类型")
    private Short outPlateTypeId;

    /**
     * @Fields outAngleId 出站车角度
     */
    @ApiModelProperty(value = "出站车角度")
    private Short outAngleId;

    /**
     * @Fields outColorId 出站车辆颜色
     */
    @ApiModelProperty(value = "出站车辆颜色")
    private Short outColorId;

    /**
     * @Fields outTypeId 出站车辆类型
     */
    @ApiModelProperty(value = "出站车辆类型")
    private Short outTypeId;

    /**
     * @Fields oilType 油品类型
     */
    @ApiModelProperty(value = "油品类型")
    private String oilType;

    /**
     * @Fields inSubBrandId 进站子品牌
     */
    @ApiModelProperty(value = "进站子品牌")
    private Short inSubBrandId;

    /**
     * @Fields inModeYearId 进站年款
     */
    @ApiModelProperty(value = "进站年款")
    private Short inModeYearId;

    /**
     * @Fields outSubBrandId 出站子品牌
     */
    @ApiModelProperty(value = "出站子品牌")
    private Short outSubBrandId;

    /**
     * @Fields outModeYearId 出站年款
     */
    @ApiModelProperty(value = "出站年款")
    private Short outModeYearId;

    /**
     * @Fields inPlateText 进站车牌号
     */
    @ApiModelProperty(value = "进站车牌号")
    private String inPlateText;

    /**
     * @Fields outPlateText 出站车牌号
     */
    @ApiModelProperty(value = "出站车牌号")
    private String outPlateText;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:public.vehicle_queue.id
     *
     * @return public.vehicle_queue.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:public.vehicle_queue.id
     *
     * @param id the value for public.vehicle_queue.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 业务主键 字段:public.vehicle_queue.biz_id
     *
     * @return public.vehicle_queue.biz_id, 业务主键
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * 设置 业务主键 字段:public.vehicle_queue.biz_id
     *
     * @param bizId the value for public.vehicle_queue.biz_id, 业务主键
     */
    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    /**
     * 获取 添加时间 字段:public.vehicle_queue.uts
     *
     * @return public.vehicle_queue.uts, 添加时间
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置 添加时间 字段:public.vehicle_queue.uts
     *
     * @param uts the value for public.vehicle_queue.uts, 添加时间
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取 排队时间(毫秒) 字段:public.vehicle_queue.queue_time
     *
     * @return public.vehicle_queue.queue_time, 排队时间(毫秒)
     */
    public Long getQueueTime() {
        return queueTime;
    }

    /**
     * 设置 排队时间(毫秒) 字段:public.vehicle_queue.queue_time
     *
     * @param queueTime the value for public.vehicle_queue.queue_time, 排队时间(毫秒)
     */
    public void setQueueTime(Long queueTime) {
        this.queueTime = queueTime;
    }

    /**
     * 获取 进站设备id 字段:public.vehicle_queue.in_sensor_id
     *
     * @return public.vehicle_queue.in_sensor_id, 进站设备id
     */
    public Long getInSensorId() {
        return inSensorId;
    }

    /**
     * 设置 进站设备id 字段:public.vehicle_queue.in_sensor_id
     *
     * @param inSensorId the value for public.vehicle_queue.in_sensor_id, 进站设备id
     */
    public void setInSensorId(Long inSensorId) {
        this.inSensorId = inSensorId;
    }

    /**
     * 获取 进站设备名称 字段:public.vehicle_queue.in_sensor_name
     *
     * @return public.vehicle_queue.in_sensor_name, 进站设备名称
     */
    public String getInSensorName() {
        return inSensorName;
    }

    /**
     * 设置 进站设备名称 字段:public.vehicle_queue.in_sensor_name
     *
     * @param inSensorName the value for public.vehicle_queue.in_sensor_name, 进站设备名称
     */
    public void setInSensorName(String inSensorName) {
        this.inSensorName = inSensorName;
    }

    /**
     * 获取 进站图片id 字段:public.vehicle_queue.in_image_id
     *
     * @return public.vehicle_queue.in_image_id, 进站图片id
     */
    public String getInImageId() {
        return inImageId;
    }

    /**
     * 设置 进站图片id 字段:public.vehicle_queue.in_image_id
     *
     * @param inImageId the value for public.vehicle_queue.in_image_id, 进站图片id
     */
    public void setInImageId(String inImageId) {
        this.inImageId = inImageId;
    }

    /**
     * 获取 进站原图 字段:public.vehicle_queue.in_source_image
     *
     * @return public.vehicle_queue.in_source_image, 进站原图
     */
    public String getInSourceImage() {
        return inSourceImage;
    }

    /**
     * 设置 进站原图 字段:public.vehicle_queue.in_source_image
     *
     * @param inSourceImage the value for public.vehicle_queue.in_source_image, 进站原图
     */
    public void setInSourceImage(String inSourceImage) {
        this.inSourceImage = inSourceImage;
    }

    /**
     * 获取 进站特征图 字段:public.vehicle_queue.in_feature_image
     *
     * @return public.vehicle_queue.in_feature_image, 进站特征图
     */
    public String getInFeatureImage() {
        return inFeatureImage;
    }

    /**
     * 设置 进站特征图 字段:public.vehicle_queue.in_feature_image
     *
     * @param inFeatureImage the value for public.vehicle_queue.in_feature_image, 进站特征图
     */
    public void setInFeatureImage(String inFeatureImage) {
        this.inFeatureImage = inFeatureImage;
    }

    /**
     * 获取 进站时间 字段:public.vehicle_queue.in_time
     *
     * @return public.vehicle_queue.in_time, 进站时间
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     * 设置 进站时间 字段:public.vehicle_queue.in_time
     *
     * @param inTime the value for public.vehicle_queue.in_time, 进站时间
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    /**
     * 获取 进站设备id 字段:public.vehicle_queue.out_sensor_id
     *
     * @return public.vehicle_queue.out_sensor_id, 进站设备id
     */
    public Long getOutSensorId() {
        return outSensorId;
    }

    /**
     * 设置 进站设备id 字段:public.vehicle_queue.out_sensor_id
     *
     * @param outSensorId the value for public.vehicle_queue.out_sensor_id, 进站设备id
     */
    public void setOutSensorId(Long outSensorId) {
        this.outSensorId = outSensorId;
    }

    /**
     * 获取 进站设备名称 字段:public.vehicle_queue.out_sensor_name
     *
     * @return public.vehicle_queue.out_sensor_name, 进站设备名称
     */
    public String getOutSensorName() {
        return outSensorName;
    }

    /**
     * 设置 进站设备名称 字段:public.vehicle_queue.out_sensor_name
     *
     * @param outSensorName the value for public.vehicle_queue.out_sensor_name, 进站设备名称
     */
    public void setOutSensorName(String outSensorName) {
        this.outSensorName = outSensorName;
    }

    /**
     * 获取 进站图片id 字段:public.vehicle_queue.out_image_id
     *
     * @return public.vehicle_queue.out_image_id, 进站图片id
     */
    public String getOutImageId() {
        return outImageId;
    }

    /**
     * 设置 进站图片id 字段:public.vehicle_queue.out_image_id
     *
     * @param outImageId the value for public.vehicle_queue.out_image_id, 进站图片id
     */
    public void setOutImageId(String outImageId) {
        this.outImageId = outImageId;
    }

    /**
     * 获取 进站原图 字段:public.vehicle_queue.out_source_image
     *
     * @return public.vehicle_queue.out_source_image, 进站原图
     */
    public String getOutSourceImage() {
        return outSourceImage;
    }

    /**
     * 设置 进站原图 字段:public.vehicle_queue.out_source_image
     *
     * @param outSourceImage the value for public.vehicle_queue.out_source_image, 进站原图
     */
    public void setOutSourceImage(String outSourceImage) {
        this.outSourceImage = outSourceImage;
    }

    /**
     * 获取 进站特征图 字段:public.vehicle_queue.out_feature_image
     *
     * @return public.vehicle_queue.out_feature_image, 进站特征图
     */
    public String getOutFeatureImage() {
        return outFeatureImage;
    }

    /**
     * 设置 进站特征图 字段:public.vehicle_queue.out_feature_image
     *
     * @param outFeatureImage the value for public.vehicle_queue.out_feature_image, 进站特征图
     */
    public void setOutFeatureImage(String outFeatureImage) {
        this.outFeatureImage = outFeatureImage;
    }

    /**
     * 获取 进站时间 字段:public.vehicle_queue.out_time
     *
     * @return public.vehicle_queue.out_time, 进站时间
     */
    public Date getOutTime() {
        return outTime;
    }

    /**
     * 设置 进站时间 字段:public.vehicle_queue.out_time
     *
     * @param outTime the value for public.vehicle_queue.out_time, 进站时间
     */
    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    /**
     * 获取 进站品牌-子品牌-年款 字段:public.vehicle_queue.in_brand_id
     *
     * @return public.vehicle_queue.in_brand_id, 进站品牌-子品牌-年款
     */
    public Short getInBrandId() {
        return inBrandId;
    }

    /**
     * 设置 进站品牌-子品牌-年款 字段:public.vehicle_queue.in_brand_id
     *
     * @param inBrandId the value for public.vehicle_queue.in_brand_id, 进站品牌-子品牌-年款
     */
    public void setInBrandId(Short inBrandId) {
        this.inBrandId = inBrandId;
    }

    /**
     * 获取 进站车牌颜色 字段:public.vehicle_queue.in_plate_color_id
     *
     * @return public.vehicle_queue.in_plate_color_id, 进站车牌颜色
     */
    public Short getInPlateColorId() {
        return inPlateColorId;
    }

    /**
     * 设置 进站车牌颜色 字段:public.vehicle_queue.in_plate_color_id
     *
     * @param inPlateColorId the value for public.vehicle_queue.in_plate_color_id, 进站车牌颜色
     */
    public void setInPlateColorId(Short inPlateColorId) {
        this.inPlateColorId = inPlateColorId;
    }

    /**
     * 获取 进站车牌类型 字段:public.vehicle_queue.in_plate_type_id
     *
     * @return public.vehicle_queue.in_plate_type_id, 进站车牌类型
     */
    public Short getInPlateTypeId() {
        return inPlateTypeId;
    }

    /**
     * 设置 进站车牌类型 字段:public.vehicle_queue.in_plate_type_id
     *
     * @param inPlateTypeId the value for public.vehicle_queue.in_plate_type_id, 进站车牌类型
     */
    public void setInPlateTypeId(Short inPlateTypeId) {
        this.inPlateTypeId = inPlateTypeId;
    }

    /**
     * 获取 进站车角度 字段:public.vehicle_queue.in_angle_id
     *
     * @return public.vehicle_queue.in_angle_id, 进站车角度
     */
    public Short getInAngleId() {
        return inAngleId;
    }

    /**
     * 设置 进站车角度 字段:public.vehicle_queue.in_angle_id
     *
     * @param inAngleId the value for public.vehicle_queue.in_angle_id, 进站车角度
     */
    public void setInAngleId(Short inAngleId) {
        this.inAngleId = inAngleId;
    }

    /**
     * 获取 进站车辆颜色 字段:public.vehicle_queue.in_color_id
     *
     * @return public.vehicle_queue.in_color_id, 进站车辆颜色
     */
    public Short getInColorId() {
        return inColorId;
    }

    /**
     * 设置 进站车辆颜色 字段:public.vehicle_queue.in_color_id
     *
     * @param inColorId the value for public.vehicle_queue.in_color_id, 进站车辆颜色
     */
    public void setInColorId(Short inColorId) {
        this.inColorId = inColorId;
    }

    /**
     * 获取 进站车辆类型 字段:public.vehicle_queue.in_type_id
     *
     * @return public.vehicle_queue.in_type_id, 进站车辆类型
     */
    public Short getInTypeId() {
        return inTypeId;
    }

    /**
     * 设置 进站车辆类型 字段:public.vehicle_queue.in_type_id
     *
     * @param inTypeId the value for public.vehicle_queue.in_type_id, 进站车辆类型
     */
    public void setInTypeId(Short inTypeId) {
        this.inTypeId = inTypeId;
    }

    /**
     * 获取 油站id 字段:public.vehicle_queue.repos_id
     *
     * @return public.vehicle_queue.repos_id, 油站id
     */
    public Long getReposId() {
        return reposId;
    }

    /**
     * 设置 油站id 字段:public.vehicle_queue.repos_id
     *
     * @param reposId the value for public.vehicle_queue.repos_id, 油站id
     */
    public void setReposId(Long reposId) {
        this.reposId = reposId;
    }

    /**
     * 获取 油站名称 字段:public.vehicle_queue.repos_name
     *
     * @return public.vehicle_queue.repos_name, 油站名称
     */
    public String getReposName() {
        return reposName;
    }

    /**
     * 设置 油站名称 字段:public.vehicle_queue.repos_name
     *
     * @param reposName the value for public.vehicle_queue.repos_name, 油站名称
     */
    public void setReposName(String reposName) {
        this.reposName = reposName;
    }

    /**
     * 获取 出站品牌-子品牌-年款 字段:public.vehicle_queue.out_brand_id
     *
     * @return public.vehicle_queue.out_brand_id, 出站品牌-子品牌-年款
     */
    public Short getOutBrandId() {
        return outBrandId;
    }

    /**
     * 设置 出站品牌-子品牌-年款 字段:public.vehicle_queue.out_brand_id
     *
     * @param outBrandId the value for public.vehicle_queue.out_brand_id, 出站品牌-子品牌-年款
     */
    public void setOutBrandId(Short outBrandId) {
        this.outBrandId = outBrandId;
    }

    /**
     * 获取 出站车牌颜色 字段:public.vehicle_queue.out_plate_color_id
     *
     * @return public.vehicle_queue.out_plate_color_id, 出站车牌颜色
     */
    public Short getOutPlateColorId() {
        return outPlateColorId;
    }

    /**
     * 设置 出站车牌颜色 字段:public.vehicle_queue.out_plate_color_id
     *
     * @param outPlateColorId the value for public.vehicle_queue.out_plate_color_id, 出站车牌颜色
     */
    public void setOutPlateColorId(Short outPlateColorId) {
        this.outPlateColorId = outPlateColorId;
    }

    /**
     * 获取 出站车牌类型 字段:public.vehicle_queue.out_plate_type_id
     *
     * @return public.vehicle_queue.out_plate_type_id, 出站车牌类型
     */
    public Short getOutPlateTypeId() {
        return outPlateTypeId;
    }

    /**
     * 设置 出站车牌类型 字段:public.vehicle_queue.out_plate_type_id
     *
     * @param outPlateTypeId the value for public.vehicle_queue.out_plate_type_id, 出站车牌类型
     */
    public void setOutPlateTypeId(Short outPlateTypeId) {
        this.outPlateTypeId = outPlateTypeId;
    }

    /**
     * 获取 出站车角度 字段:public.vehicle_queue.out_angle_id
     *
     * @return public.vehicle_queue.out_angle_id, 出站车角度
     */
    public Short getOutAngleId() {
        return outAngleId;
    }

    /**
     * 设置 出站车角度 字段:public.vehicle_queue.out_angle_id
     *
     * @param outAngleId the value for public.vehicle_queue.out_angle_id, 出站车角度
     */
    public void setOutAngleId(Short outAngleId) {
        this.outAngleId = outAngleId;
    }

    /**
     * 获取 出站车辆颜色 字段:public.vehicle_queue.out_color_id
     *
     * @return public.vehicle_queue.out_color_id, 出站车辆颜色
     */
    public Short getOutColorId() {
        return outColorId;
    }

    /**
     * 设置 出站车辆颜色 字段:public.vehicle_queue.out_color_id
     *
     * @param outColorId the value for public.vehicle_queue.out_color_id, 出站车辆颜色
     */
    public void setOutColorId(Short outColorId) {
        this.outColorId = outColorId;
    }

    /**
     * 获取 出站车辆类型 字段:public.vehicle_queue.out_type_id
     *
     * @return public.vehicle_queue.out_type_id, 出站车辆类型
     */
    public Short getOutTypeId() {
        return outTypeId;
    }

    /**
     * 设置 出站车辆类型 字段:public.vehicle_queue.out_type_id
     *
     * @param outTypeId the value for public.vehicle_queue.out_type_id, 出站车辆类型
     */
    public void setOutTypeId(Short outTypeId) {
        this.outTypeId = outTypeId;
    }

    /**
     * 获取 油品类型 字段:public.vehicle_queue.oil_type
     *
     * @return public.vehicle_queue.oil_type, 油品类型
     */
    public String getOilType() {
        return oilType;
    }

    /**
     * 设置 油品类型 字段:public.vehicle_queue.oil_type
     *
     * @param oilType the value for public.vehicle_queue.oil_type, 油品类型
     */
    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    /**
     * 获取 进站子品牌 字段:public.vehicle_queue.in_sub_brand_id
     *
     * @return public.vehicle_queue.in_sub_brand_id, 进站子品牌
     */
    public Short getInSubBrandId() {
        return inSubBrandId;
    }

    /**
     * 设置 进站子品牌 字段:public.vehicle_queue.in_sub_brand_id
     *
     * @param inSubBrandId the value for public.vehicle_queue.in_sub_brand_id, 进站子品牌
     */
    public void setInSubBrandId(Short inSubBrandId) {
        this.inSubBrandId = inSubBrandId;
    }

    /**
     * 获取 进站年款 字段:public.vehicle_queue.in_mode_year_id
     *
     * @return public.vehicle_queue.in_mode_year_id, 进站年款
     */
    public Short getInModeYearId() {
        return inModeYearId;
    }

    /**
     * 设置 进站年款 字段:public.vehicle_queue.in_mode_year_id
     *
     * @param inModeYearId the value for public.vehicle_queue.in_mode_year_id, 进站年款
     */
    public void setInModeYearId(Short inModeYearId) {
        this.inModeYearId = inModeYearId;
    }

    /**
     * 获取 出站子品牌 字段:public.vehicle_queue.out_sub_brand_id
     *
     * @return public.vehicle_queue.out_sub_brand_id, 出站子品牌
     */
    public Short getOutSubBrandId() {
        return outSubBrandId;
    }

    /**
     * 设置 出站子品牌 字段:public.vehicle_queue.out_sub_brand_id
     *
     * @param outSubBrandId the value for public.vehicle_queue.out_sub_brand_id, 出站子品牌
     */
    public void setOutSubBrandId(Short outSubBrandId) {
        this.outSubBrandId = outSubBrandId;
    }

    /**
     * 获取 出站年款 字段:public.vehicle_queue.out_mode_year_id
     *
     * @return public.vehicle_queue.out_mode_year_id, 出站年款
     */
    public Short getOutModeYearId() {
        return outModeYearId;
    }

    /**
     * 设置 出站年款 字段:public.vehicle_queue.out_mode_year_id
     *
     * @param outModeYearId the value for public.vehicle_queue.out_mode_year_id, 出站年款
     */
    public void setOutModeYearId(Short outModeYearId) {
        this.outModeYearId = outModeYearId;
    }

    /**
     * 获取 进站车牌号 字段:public.vehicle_queue.in_plate_text
     *
     * @return public.vehicle_queue.in_plate_text, 进站车牌号
     */
    public String getInPlateText() {
        return inPlateText;
    }

    /**
     * 设置 进站车牌号 字段:public.vehicle_queue.in_plate_text
     *
     * @param inPlateText the value for public.vehicle_queue.in_plate_text, 进站车牌号
     */
    public void setInPlateText(String inPlateText) {
        this.inPlateText = inPlateText;
    }

    /**
     * 获取 出站车牌号 字段:public.vehicle_queue.out_plate_text
     *
     * @return public.vehicle_queue.out_plate_text, 出站车牌号
     */
    public String getOutPlateText() {
        return outPlateText;
    }

    /**
     * 设置 出站车牌号 字段:public.vehicle_queue.out_plate_text
     *
     * @param outPlateText the value for public.vehicle_queue.out_plate_text, 出站车牌号
     */
    public void setOutPlateText(String outPlateText) {
        this.outPlateText = outPlateText;
    }
}