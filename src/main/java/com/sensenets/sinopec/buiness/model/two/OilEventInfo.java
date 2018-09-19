/**
  * OilEventInfo.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-18
  */
package com.sensenets.sinopec.buiness.model.two;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title public.oil_event_info表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-09-18 15:05:46
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="OilEventInfo")
public class OilEventInfo implements Serializable {
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
     * @Fields oilStationId 加油站ID
     */
    @ApiModelProperty(value = "加油站ID")
    private String oilStationId;

    /**
     * @Fields oilGunId 加油枪号
     */
    @ApiModelProperty(value = "加油枪号")
    private String oilGunId;

    /**
     * @Fields liftTimestamp 提抢时间
     */
    @ApiModelProperty(value = "提抢时间")
    private Date liftTimestamp;

    /**
     * @Fields hangTimestamp 挂枪时间
     */
    @ApiModelProperty(value = "挂枪时间")
    private Date hangTimestamp;

    /**
     * @Fields tccNo 流水号
     */
    @ApiModelProperty(value = "流水号")
    private String tccNo;

    /**
     * @Fields oilTypeNum 油品代码
     */
    @ApiModelProperty(value = "油品代码")
    private String oilTypeNum;

    /**
     * @Fields oilCardId 加油卡号
     */
    @ApiModelProperty(value = "加油卡号")
    private String oilCardId;

    /**
     * @Fields limitVehiclePlate 限制车牌号
     */
    @ApiModelProperty(value = "限制车牌号")
    private String limitVehiclePlate;

    /**
     * @Fields vehiclePlate 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String vehiclePlate;

    /**
     * @Fields vehicleBrand 车辆品牌
     */
    @ApiModelProperty(value = "车辆品牌")
    private String vehicleBrand;

    /**
     * @Fields vehicleSubBrand 车辆子品牌
     */
    @ApiModelProperty(value = "车辆子品牌")
    private String vehicleSubBrand;

    /**
     * @Fields vehicleStyle 车款
     */
    @ApiModelProperty(value = "车款")
    private String vehicleStyle;

    /**
     * @Fields vehicleType 车辆类型
     */
    @ApiModelProperty(value = "车辆类型")
    private String vehicleType;

    /**
     * @Fields vehicleColor 车辆颜色
     */
    @ApiModelProperty(value = "车辆颜色")
    private String vehicleColor;

    /**
     * @Fields vehiclePlateTyle 车牌类型
     */
    @ApiModelProperty(value = "车牌类型")
    private String vehiclePlateTyle;

    /**
     * @Fields vehiclePlateColor 车牌颜色
     */
    @ApiModelProperty(value = "车牌颜色")
    private String vehiclePlateColor;

    /**
     * @Fields vehiclePlateImageUrl 车牌图片
     */
    @ApiModelProperty(value = "车牌图片")
    private String vehiclePlateImageUrl;

    /**
     * @Fields additionalInfos 附加信息
     */
    @ApiModelProperty(value = "附加信息")
    private String additionalInfos;

    /**
     * @Fields status 
     */
    @ApiModelProperty(value = "")
    private Short status;

    /**
     * @Fields amount 加油量
     */
    @ApiModelProperty(value = "加油量")
    private Float amount;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:public.oil_event_info.id
     *
     * @return public.oil_event_info.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:public.oil_event_info.id
     *
     * @param id the value for public.oil_event_info.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:public.oil_event_info.uts
     *
     * @return public.oil_event_info.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:public.oil_event_info.uts
     *
     * @param uts the value for public.oil_event_info.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取 加油站ID 字段:public.oil_event_info.oil_station_id
     *
     * @return public.oil_event_info.oil_station_id, 加油站ID
     */
    public String getOilStationId() {
        return oilStationId;
    }

    /**
     * 设置 加油站ID 字段:public.oil_event_info.oil_station_id
     *
     * @param oilStationId the value for public.oil_event_info.oil_station_id, 加油站ID
     */
    public void setOilStationId(String oilStationId) {
        this.oilStationId = oilStationId;
    }

    /**
     * 获取 加油枪号 字段:public.oil_event_info.oil_gun_id
     *
     * @return public.oil_event_info.oil_gun_id, 加油枪号
     */
    public String getOilGunId() {
        return oilGunId;
    }

    /**
     * 设置 加油枪号 字段:public.oil_event_info.oil_gun_id
     *
     * @param oilGunId the value for public.oil_event_info.oil_gun_id, 加油枪号
     */
    public void setOilGunId(String oilGunId) {
        this.oilGunId = oilGunId;
    }

    /**
     * 获取 提抢时间 字段:public.oil_event_info.lift_timestamp
     *
     * @return public.oil_event_info.lift_timestamp, 提抢时间
     */
    public Date getLiftTimestamp() {
        return liftTimestamp;
    }

    /**
     * 设置 提抢时间 字段:public.oil_event_info.lift_timestamp
     *
     * @param liftTimestamp the value for public.oil_event_info.lift_timestamp, 提抢时间
     */
    public void setLiftTimestamp(Date liftTimestamp) {
        this.liftTimestamp = liftTimestamp;
    }

    /**
     * 获取 挂枪时间 字段:public.oil_event_info.hang_timestamp
     *
     * @return public.oil_event_info.hang_timestamp, 挂枪时间
     */
    public Date getHangTimestamp() {
        return hangTimestamp;
    }

    /**
     * 设置 挂枪时间 字段:public.oil_event_info.hang_timestamp
     *
     * @param hangTimestamp the value for public.oil_event_info.hang_timestamp, 挂枪时间
     */
    public void setHangTimestamp(Date hangTimestamp) {
        this.hangTimestamp = hangTimestamp;
    }

    /**
     * 获取 流水号 字段:public.oil_event_info.tcc_no
     *
     * @return public.oil_event_info.tcc_no, 流水号
     */
    public String getTccNo() {
        return tccNo;
    }

    /**
     * 设置 流水号 字段:public.oil_event_info.tcc_no
     *
     * @param tccNo the value for public.oil_event_info.tcc_no, 流水号
     */
    public void setTccNo(String tccNo) {
        this.tccNo = tccNo;
    }

    /**
     * 获取 油品代码 字段:public.oil_event_info.oil_type_num
     *
     * @return public.oil_event_info.oil_type_num, 油品代码
     */
    public String getOilTypeNum() {
        return oilTypeNum;
    }

    /**
     * 设置 油品代码 字段:public.oil_event_info.oil_type_num
     *
     * @param oilTypeNum the value for public.oil_event_info.oil_type_num, 油品代码
     */
    public void setOilTypeNum(String oilTypeNum) {
        this.oilTypeNum = oilTypeNum;
    }

    /**
     * 获取 加油卡号 字段:public.oil_event_info.oil_card_id
     *
     * @return public.oil_event_info.oil_card_id, 加油卡号
     */
    public String getOilCardId() {
        return oilCardId;
    }

    /**
     * 设置 加油卡号 字段:public.oil_event_info.oil_card_id
     *
     * @param oilCardId the value for public.oil_event_info.oil_card_id, 加油卡号
     */
    public void setOilCardId(String oilCardId) {
        this.oilCardId = oilCardId;
    }

    /**
     * 获取 限制车牌号 字段:public.oil_event_info.limit_vehicle_plate
     *
     * @return public.oil_event_info.limit_vehicle_plate, 限制车牌号
     */
    public String getLimitVehiclePlate() {
        return limitVehiclePlate;
    }

    /**
     * 设置 限制车牌号 字段:public.oil_event_info.limit_vehicle_plate
     *
     * @param limitVehiclePlate the value for public.oil_event_info.limit_vehicle_plate, 限制车牌号
     */
    public void setLimitVehiclePlate(String limitVehiclePlate) {
        this.limitVehiclePlate = limitVehiclePlate;
    }

    /**
     * 获取 车牌号 字段:public.oil_event_info.vehicle_plate
     *
     * @return public.oil_event_info.vehicle_plate, 车牌号
     */
    public String getVehiclePlate() {
        return vehiclePlate;
    }

    /**
     * 设置 车牌号 字段:public.oil_event_info.vehicle_plate
     *
     * @param vehiclePlate the value for public.oil_event_info.vehicle_plate, 车牌号
     */
    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    /**
     * 获取 车辆品牌 字段:public.oil_event_info.vehicle_brand
     *
     * @return public.oil_event_info.vehicle_brand, 车辆品牌
     */
    public String getVehicleBrand() {
        return vehicleBrand;
    }

    /**
     * 设置 车辆品牌 字段:public.oil_event_info.vehicle_brand
     *
     * @param vehicleBrand the value for public.oil_event_info.vehicle_brand, 车辆品牌
     */
    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    /**
     * 获取 车辆子品牌 字段:public.oil_event_info.vehicle_sub_brand
     *
     * @return public.oil_event_info.vehicle_sub_brand, 车辆子品牌
     */
    public String getVehicleSubBrand() {
        return vehicleSubBrand;
    }

    /**
     * 设置 车辆子品牌 字段:public.oil_event_info.vehicle_sub_brand
     *
     * @param vehicleSubBrand the value for public.oil_event_info.vehicle_sub_brand, 车辆子品牌
     */
    public void setVehicleSubBrand(String vehicleSubBrand) {
        this.vehicleSubBrand = vehicleSubBrand;
    }

    /**
     * 获取 车款 字段:public.oil_event_info.vehicle_style
     *
     * @return public.oil_event_info.vehicle_style, 车款
     */
    public String getVehicleStyle() {
        return vehicleStyle;
    }

    /**
     * 设置 车款 字段:public.oil_event_info.vehicle_style
     *
     * @param vehicleStyle the value for public.oil_event_info.vehicle_style, 车款
     */
    public void setVehicleStyle(String vehicleStyle) {
        this.vehicleStyle = vehicleStyle;
    }

    /**
     * 获取 车辆类型 字段:public.oil_event_info.vehicle_type
     *
     * @return public.oil_event_info.vehicle_type, 车辆类型
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * 设置 车辆类型 字段:public.oil_event_info.vehicle_type
     *
     * @param vehicleType the value for public.oil_event_info.vehicle_type, 车辆类型
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * 获取 车辆颜色 字段:public.oil_event_info.vehicle_color
     *
     * @return public.oil_event_info.vehicle_color, 车辆颜色
     */
    public String getVehicleColor() {
        return vehicleColor;
    }

    /**
     * 设置 车辆颜色 字段:public.oil_event_info.vehicle_color
     *
     * @param vehicleColor the value for public.oil_event_info.vehicle_color, 车辆颜色
     */
    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    /**
     * 获取 车牌类型 字段:public.oil_event_info.vehicle_plate_tyle
     *
     * @return public.oil_event_info.vehicle_plate_tyle, 车牌类型
     */
    public String getVehiclePlateTyle() {
        return vehiclePlateTyle;
    }

    /**
     * 设置 车牌类型 字段:public.oil_event_info.vehicle_plate_tyle
     *
     * @param vehiclePlateTyle the value for public.oil_event_info.vehicle_plate_tyle, 车牌类型
     */
    public void setVehiclePlateTyle(String vehiclePlateTyle) {
        this.vehiclePlateTyle = vehiclePlateTyle;
    }

    /**
     * 获取 车牌颜色 字段:public.oil_event_info.vehicle_plate_color
     *
     * @return public.oil_event_info.vehicle_plate_color, 车牌颜色
     */
    public String getVehiclePlateColor() {
        return vehiclePlateColor;
    }

    /**
     * 设置 车牌颜色 字段:public.oil_event_info.vehicle_plate_color
     *
     * @param vehiclePlateColor the value for public.oil_event_info.vehicle_plate_color, 车牌颜色
     */
    public void setVehiclePlateColor(String vehiclePlateColor) {
        this.vehiclePlateColor = vehiclePlateColor;
    }

    /**
     * 获取 车牌图片 字段:public.oil_event_info.vehicle_plate_image_url
     *
     * @return public.oil_event_info.vehicle_plate_image_url, 车牌图片
     */
    public String getVehiclePlateImageUrl() {
        return vehiclePlateImageUrl;
    }

    /**
     * 设置 车牌图片 字段:public.oil_event_info.vehicle_plate_image_url
     *
     * @param vehiclePlateImageUrl the value for public.oil_event_info.vehicle_plate_image_url, 车牌图片
     */
    public void setVehiclePlateImageUrl(String vehiclePlateImageUrl) {
        this.vehiclePlateImageUrl = vehiclePlateImageUrl;
    }

    /**
     * 获取 附加信息 字段:public.oil_event_info.additional_infos
     *
     * @return public.oil_event_info.additional_infos, 附加信息
     */
    public String getAdditionalInfos() {
        return additionalInfos;
    }

    /**
     * 设置 附加信息 字段:public.oil_event_info.additional_infos
     *
     * @param additionalInfos the value for public.oil_event_info.additional_infos, 附加信息
     */
    public void setAdditionalInfos(String additionalInfos) {
        this.additionalInfos = additionalInfos;
    }

    /**
     * 获取  字段:public.oil_event_info.status
     *
     * @return public.oil_event_info.status, 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置  字段:public.oil_event_info.status
     *
     * @param status the value for public.oil_event_info.status, 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取 加油量 字段:public.oil_event_info.amount
     *
     * @return public.oil_event_info.amount, 加油量
     */
    public Float getAmount() {
        return amount;
    }

    /**
     * 设置 加油量 字段:public.oil_event_info.amount
     *
     * @param amount the value for public.oil_event_info.amount, 加油量
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }
}