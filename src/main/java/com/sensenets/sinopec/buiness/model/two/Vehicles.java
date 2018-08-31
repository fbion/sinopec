/**
  * Vehicles.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-30
  */
package com.sensenets.sinopec.buiness.model.two;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title public.vehicles表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-30 12:15:18
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="Vehicles")
public class Vehicles implements Serializable {
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
     * @Fields vehicleId 
     */
    @ApiModelProperty(value = "")
    private String vehicleId;

    /**
     * @Fields imageId 
     */
    @ApiModelProperty(value = "")
    private String imageId;

    /**
     * @Fields ts 
     */
    @ApiModelProperty(value = "")
    private Long ts;

    /**
     * @Fields repoId 
     */
    @ApiModelProperty(value = "")
    private String repoId;

    /**
     * @Fields sensorId 
     */
    @ApiModelProperty(value = "")
    private String sensorId;

    /**
     * @Fields confidence 
     */
    @ApiModelProperty(value = "")
    private Float confidence;

    /**
     * @Fields brandId 
     */
    @ApiModelProperty(value = "")
    private Short brandId;

    /**
     * @Fields subBrandId 
     */
    @ApiModelProperty(value = "")
    private Short subBrandId;

    /**
     * @Fields modelYearId 
     */
    @ApiModelProperty(value = "")
    private Short modelYearId;

    /**
     * @Fields typeId 
     */
    @ApiModelProperty(value = "")
    private Short typeId;

    /**
     * @Fields colorId 
     */
    @ApiModelProperty(value = "")
    private Short colorId;

    /**
     * @Fields plateText 
     */
    @ApiModelProperty(value = "")
    private String plateText;

    /**
     * @Fields plateTypeId 
     */
    @ApiModelProperty(value = "")
    private Short plateTypeId;

    /**
     * @Fields plateColorId 
     */
    @ApiModelProperty(value = "")
    private Short plateColorId;

    /**
     * @Fields side 
     */
    @ApiModelProperty(value = "")
    private Short side;

    /**
     * @Fields size 
     */
    @ApiModelProperty(value = "")
    private Short size;

    /**
     * @Fields speed 
     */
    @ApiModelProperty(value = "")
    private Short speed;

    /**
     * @Fields direction 
     */
    @ApiModelProperty(value = "")
    private Short direction;

    /**
     * @Fields symbolInt 
     */
    @ApiModelProperty(value = "")
    private Long symbolInt;

    /**
     * @Fields symbolStr 
     */
    @ApiModelProperty(value = "")
    private String symbolStr;

    /**
     * @Fields illegalInt 
     */
    @ApiModelProperty(value = "")
    private Long illegalInt;

    /**
     * @Fields illegalStr 
     */
    @ApiModelProperty(value = "")
    private String illegalStr;

    /**
     * @Fields coillegalInt 
     */
    @ApiModelProperty(value = "")
    private Long coillegalInt;

    /**
     * @Fields coillegalStr 
     */
    @ApiModelProperty(value = "")
    private String coillegalStr;

    /**
     * @Fields specialInt 
     */
    @ApiModelProperty(value = "")
    private Long specialInt;

    /**
     * @Fields specialStr 
     */
    @ApiModelProperty(value = "")
    private String specialStr;

    /**
     * @Fields driverOnThePhone 
     */
    @ApiModelProperty(value = "")
    private Boolean driverOnThePhone;

    /**
     * @Fields driverWithoutBelt 
     */
    @ApiModelProperty(value = "")
    private Boolean driverWithoutBelt;

    /**
     * @Fields codriverWithoutBelt 
     */
    @ApiModelProperty(value = "")
    private Boolean codriverWithoutBelt;

    /**
     * @Fields content 
     */
    @ApiModelProperty(value = "")
    private String content;

    /**
     * @Fields lane 
     */
    @ApiModelProperty(value = "")
    private String lane;

    /**
     * @Fields faceId 
     */
    @ApiModelProperty(value = "")
    private String faceId;

    /**
     * @Fields oilType 加油量
     */
    @ApiModelProperty(value = "加油量")
    private String oilType;

    /**
     * @Fields oilAmount 
     */
    @ApiModelProperty(value = "")
    private Float oilAmount;

    /**
     * @Fields engineFuel 1：汽油车，2：柴油车
     */
    @ApiModelProperty(value = "1：汽油车，2：柴油车")
    private Short engineFuel;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:public.vehicles.id
     *
     * @return public.vehicles.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:public.vehicles.id
     *
     * @param id the value for public.vehicles.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:public.vehicles.uts
     *
     * @return public.vehicles.uts, 
     */
    public Date getUts() {
        return uts;
    }

    /**
     * 设置  字段:public.vehicles.uts
     *
     * @param uts the value for public.vehicles.uts, 
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * 获取  字段:public.vehicles.vehicle_id
     *
     * @return public.vehicles.vehicle_id, 
     */
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * 设置  字段:public.vehicles.vehicle_id
     *
     * @param vehicleId the value for public.vehicles.vehicle_id, 
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * 获取  字段:public.vehicles.image_id
     *
     * @return public.vehicles.image_id, 
     */
    public String getImageId() {
        return imageId;
    }

    /**
     * 设置  字段:public.vehicles.image_id
     *
     * @param imageId the value for public.vehicles.image_id, 
     */
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    /**
     * 获取  字段:public.vehicles.ts
     *
     * @return public.vehicles.ts, 
     */
    public Long getTs() {
        return ts;
    }

    /**
     * 设置  字段:public.vehicles.ts
     *
     * @param ts the value for public.vehicles.ts, 
     */
    public void setTs(Long ts) {
        this.ts = ts;
    }

    /**
     * 获取  字段:public.vehicles.repo_id
     *
     * @return public.vehicles.repo_id, 
     */
    public String getRepoId() {
        return repoId;
    }

    /**
     * 设置  字段:public.vehicles.repo_id
     *
     * @param repoId the value for public.vehicles.repo_id, 
     */
    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    /**
     * 获取  字段:public.vehicles.sensor_id
     *
     * @return public.vehicles.sensor_id, 
     */
    public String getSensorId() {
        return sensorId;
    }

    /**
     * 设置  字段:public.vehicles.sensor_id
     *
     * @param sensorId the value for public.vehicles.sensor_id, 
     */
    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * 获取  字段:public.vehicles.confidence
     *
     * @return public.vehicles.confidence, 
     */
    public Float getConfidence() {
        return confidence;
    }

    /**
     * 设置  字段:public.vehicles.confidence
     *
     * @param confidence the value for public.vehicles.confidence, 
     */
    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }

    /**
     * 获取  字段:public.vehicles.brand_id
     *
     * @return public.vehicles.brand_id, 
     */
    public Short getBrandId() {
        return brandId;
    }

    /**
     * 设置  字段:public.vehicles.brand_id
     *
     * @param brandId the value for public.vehicles.brand_id, 
     */
    public void setBrandId(Short brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取  字段:public.vehicles.sub_brand_id
     *
     * @return public.vehicles.sub_brand_id, 
     */
    public Short getSubBrandId() {
        return subBrandId;
    }

    /**
     * 设置  字段:public.vehicles.sub_brand_id
     *
     * @param subBrandId the value for public.vehicles.sub_brand_id, 
     */
    public void setSubBrandId(Short subBrandId) {
        this.subBrandId = subBrandId;
    }

    /**
     * 获取  字段:public.vehicles.model_year_id
     *
     * @return public.vehicles.model_year_id, 
     */
    public Short getModelYearId() {
        return modelYearId;
    }

    /**
     * 设置  字段:public.vehicles.model_year_id
     *
     * @param modelYearId the value for public.vehicles.model_year_id, 
     */
    public void setModelYearId(Short modelYearId) {
        this.modelYearId = modelYearId;
    }

    /**
     * 获取  字段:public.vehicles.type_id
     *
     * @return public.vehicles.type_id, 
     */
    public Short getTypeId() {
        return typeId;
    }

    /**
     * 设置  字段:public.vehicles.type_id
     *
     * @param typeId the value for public.vehicles.type_id, 
     */
    public void setTypeId(Short typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取  字段:public.vehicles.color_id
     *
     * @return public.vehicles.color_id, 
     */
    public Short getColorId() {
        return colorId;
    }

    /**
     * 设置  字段:public.vehicles.color_id
     *
     * @param colorId the value for public.vehicles.color_id, 
     */
    public void setColorId(Short colorId) {
        this.colorId = colorId;
    }

    /**
     * 获取  字段:public.vehicles.plate_text
     *
     * @return public.vehicles.plate_text, 
     */
    public String getPlateText() {
        return plateText;
    }

    /**
     * 设置  字段:public.vehicles.plate_text
     *
     * @param plateText the value for public.vehicles.plate_text, 
     */
    public void setPlateText(String plateText) {
        this.plateText = plateText;
    }

    /**
     * 获取  字段:public.vehicles.plate_type_id
     *
     * @return public.vehicles.plate_type_id, 
     */
    public Short getPlateTypeId() {
        return plateTypeId;
    }

    /**
     * 设置  字段:public.vehicles.plate_type_id
     *
     * @param plateTypeId the value for public.vehicles.plate_type_id, 
     */
    public void setPlateTypeId(Short plateTypeId) {
        this.plateTypeId = plateTypeId;
    }

    /**
     * 获取  字段:public.vehicles.plate_color_id
     *
     * @return public.vehicles.plate_color_id, 
     */
    public Short getPlateColorId() {
        return plateColorId;
    }

    /**
     * 设置  字段:public.vehicles.plate_color_id
     *
     * @param plateColorId the value for public.vehicles.plate_color_id, 
     */
    public void setPlateColorId(Short plateColorId) {
        this.plateColorId = plateColorId;
    }

    /**
     * 获取  字段:public.vehicles.side
     *
     * @return public.vehicles.side, 
     */
    public Short getSide() {
        return side;
    }

    /**
     * 设置  字段:public.vehicles.side
     *
     * @param side the value for public.vehicles.side, 
     */
    public void setSide(Short side) {
        this.side = side;
    }

    /**
     * 获取  字段:public.vehicles.size
     *
     * @return public.vehicles.size, 
     */
    public Short getSize() {
        return size;
    }

    /**
     * 设置  字段:public.vehicles.size
     *
     * @param size the value for public.vehicles.size, 
     */
    public void setSize(Short size) {
        this.size = size;
    }

    /**
     * 获取  字段:public.vehicles.speed
     *
     * @return public.vehicles.speed, 
     */
    public Short getSpeed() {
        return speed;
    }

    /**
     * 设置  字段:public.vehicles.speed
     *
     * @param speed the value for public.vehicles.speed, 
     */
    public void setSpeed(Short speed) {
        this.speed = speed;
    }

    /**
     * 获取  字段:public.vehicles.direction
     *
     * @return public.vehicles.direction, 
     */
    public Short getDirection() {
        return direction;
    }

    /**
     * 设置  字段:public.vehicles.direction
     *
     * @param direction the value for public.vehicles.direction, 
     */
    public void setDirection(Short direction) {
        this.direction = direction;
    }

    /**
     * 获取  字段:public.vehicles.symbol_int
     *
     * @return public.vehicles.symbol_int, 
     */
    public Long getSymbolInt() {
        return symbolInt;
    }

    /**
     * 设置  字段:public.vehicles.symbol_int
     *
     * @param symbolInt the value for public.vehicles.symbol_int, 
     */
    public void setSymbolInt(Long symbolInt) {
        this.symbolInt = symbolInt;
    }

    /**
     * 获取  字段:public.vehicles.symbol_str
     *
     * @return public.vehicles.symbol_str, 
     */
    public String getSymbolStr() {
        return symbolStr;
    }

    /**
     * 设置  字段:public.vehicles.symbol_str
     *
     * @param symbolStr the value for public.vehicles.symbol_str, 
     */
    public void setSymbolStr(String symbolStr) {
        this.symbolStr = symbolStr;
    }

    /**
     * 获取  字段:public.vehicles.illegal_int
     *
     * @return public.vehicles.illegal_int, 
     */
    public Long getIllegalInt() {
        return illegalInt;
    }

    /**
     * 设置  字段:public.vehicles.illegal_int
     *
     * @param illegalInt the value for public.vehicles.illegal_int, 
     */
    public void setIllegalInt(Long illegalInt) {
        this.illegalInt = illegalInt;
    }

    /**
     * 获取  字段:public.vehicles.illegal_str
     *
     * @return public.vehicles.illegal_str, 
     */
    public String getIllegalStr() {
        return illegalStr;
    }

    /**
     * 设置  字段:public.vehicles.illegal_str
     *
     * @param illegalStr the value for public.vehicles.illegal_str, 
     */
    public void setIllegalStr(String illegalStr) {
        this.illegalStr = illegalStr;
    }

    /**
     * 获取  字段:public.vehicles.coillegal_int
     *
     * @return public.vehicles.coillegal_int, 
     */
    public Long getCoillegalInt() {
        return coillegalInt;
    }

    /**
     * 设置  字段:public.vehicles.coillegal_int
     *
     * @param coillegalInt the value for public.vehicles.coillegal_int, 
     */
    public void setCoillegalInt(Long coillegalInt) {
        this.coillegalInt = coillegalInt;
    }

    /**
     * 获取  字段:public.vehicles.coillegal_str
     *
     * @return public.vehicles.coillegal_str, 
     */
    public String getCoillegalStr() {
        return coillegalStr;
    }

    /**
     * 设置  字段:public.vehicles.coillegal_str
     *
     * @param coillegalStr the value for public.vehicles.coillegal_str, 
     */
    public void setCoillegalStr(String coillegalStr) {
        this.coillegalStr = coillegalStr;
    }

    /**
     * 获取  字段:public.vehicles.special_int
     *
     * @return public.vehicles.special_int, 
     */
    public Long getSpecialInt() {
        return specialInt;
    }

    /**
     * 设置  字段:public.vehicles.special_int
     *
     * @param specialInt the value for public.vehicles.special_int, 
     */
    public void setSpecialInt(Long specialInt) {
        this.specialInt = specialInt;
    }

    /**
     * 获取  字段:public.vehicles.special_str
     *
     * @return public.vehicles.special_str, 
     */
    public String getSpecialStr() {
        return specialStr;
    }

    /**
     * 设置  字段:public.vehicles.special_str
     *
     * @param specialStr the value for public.vehicles.special_str, 
     */
    public void setSpecialStr(String specialStr) {
        this.specialStr = specialStr;
    }

    /**
     * 获取  字段:public.vehicles.driver_on_the_phone
     *
     * @return public.vehicles.driver_on_the_phone, 
     */
    public Boolean getDriverOnThePhone() {
        return driverOnThePhone;
    }

    /**
     * 设置  字段:public.vehicles.driver_on_the_phone
     *
     * @param driverOnThePhone the value for public.vehicles.driver_on_the_phone, 
     */
    public void setDriverOnThePhone(Boolean driverOnThePhone) {
        this.driverOnThePhone = driverOnThePhone;
    }

    /**
     * 获取  字段:public.vehicles.driver_without_belt
     *
     * @return public.vehicles.driver_without_belt, 
     */
    public Boolean getDriverWithoutBelt() {
        return driverWithoutBelt;
    }

    /**
     * 设置  字段:public.vehicles.driver_without_belt
     *
     * @param driverWithoutBelt the value for public.vehicles.driver_without_belt, 
     */
    public void setDriverWithoutBelt(Boolean driverWithoutBelt) {
        this.driverWithoutBelt = driverWithoutBelt;
    }

    /**
     * 获取  字段:public.vehicles.codriver_without_belt
     *
     * @return public.vehicles.codriver_without_belt, 
     */
    public Boolean getCodriverWithoutBelt() {
        return codriverWithoutBelt;
    }

    /**
     * 设置  字段:public.vehicles.codriver_without_belt
     *
     * @param codriverWithoutBelt the value for public.vehicles.codriver_without_belt, 
     */
    public void setCodriverWithoutBelt(Boolean codriverWithoutBelt) {
        this.codriverWithoutBelt = codriverWithoutBelt;
    }

    /**
     * 获取  字段:public.vehicles.content
     *
     * @return public.vehicles.content, 
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置  字段:public.vehicles.content
     *
     * @param content the value for public.vehicles.content, 
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取  字段:public.vehicles.lane
     *
     * @return public.vehicles.lane, 
     */
    public String getLane() {
        return lane;
    }

    /**
     * 设置  字段:public.vehicles.lane
     *
     * @param lane the value for public.vehicles.lane, 
     */
    public void setLane(String lane) {
        this.lane = lane;
    }

    /**
     * 获取  字段:public.vehicles.face_id
     *
     * @return public.vehicles.face_id, 
     */
    public String getFaceId() {
        return faceId;
    }

    /**
     * 设置  字段:public.vehicles.face_id
     *
     * @param faceId the value for public.vehicles.face_id, 
     */
    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    /**
     * 获取 加油量 字段:public.vehicles.oil_type
     *
     * @return public.vehicles.oil_type, 加油量
     */
    public String getOilType() {
        return oilType;
    }

    /**
     * 设置 加油量 字段:public.vehicles.oil_type
     *
     * @param oilType the value for public.vehicles.oil_type, 加油量
     */
    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    /**
     * 获取  字段:public.vehicles.oil_amount
     *
     * @return public.vehicles.oil_amount, 
     */
    public Float getOilAmount() {
        return oilAmount;
    }

    /**
     * 设置  字段:public.vehicles.oil_amount
     *
     * @param oilAmount the value for public.vehicles.oil_amount, 
     */
    public void setOilAmount(Float oilAmount) {
        this.oilAmount = oilAmount;
    }

    /**
     * 获取 1：汽油车，2：柴油车 字段:public.vehicles.engine_fuel
     *
     * @return public.vehicles.engine_fuel, 1：汽油车，2：柴油车
     */
    public Short getEngineFuel() {
        return engineFuel;
    }

    /**
     * 设置 1：汽油车，2：柴油车 字段:public.vehicles.engine_fuel
     *
     * @param engineFuel the value for public.vehicles.engine_fuel, 1：汽油车，2：柴油车
     */
    public void setEngineFuel(Short engineFuel) {
        this.engineFuel = engineFuel;
    }
}