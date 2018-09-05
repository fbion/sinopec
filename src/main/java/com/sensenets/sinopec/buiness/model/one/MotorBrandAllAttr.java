/**
  * MotorBrandAllAttr.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-05
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;

/**
 * @Title public.motor_brand_all_attr表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-09-05 15:00:34
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value ="MotorBrandAllAttr")
public class MotorBrandAllAttr implements Serializable {
    /**
     * @Fields id 
     */
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * @Fields brandId 
     */
    @ApiModelProperty(value = "")
    private Integer brandId;

    /**
     * @Fields brandName 
     */
    @ApiModelProperty(value = "")
    private String brandName;

    /**
     * @Fields subBrandId 
     */
    @ApiModelProperty(value = "")
    private Integer subBrandId;

    /**
     * @Fields subBrandName 
     */
    @ApiModelProperty(value = "")
    private String subBrandName;

    /**
     * @Fields yearId 
     */
    @ApiModelProperty(value = "")
    private Integer yearId;

    /**
     * @Fields yearName 
     */
    @ApiModelProperty(value = "")
    private String yearName;

    /**
     * @Fields engineFuel 
     */
    @ApiModelProperty(value = "")
    private Short engineFuel;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:public.motor_brand_all_attr.id
     *
     * @return public.motor_brand_all_attr.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:public.motor_brand_all_attr.id
     *
     * @param id the value for public.motor_brand_all_attr.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:public.motor_brand_all_attr.brand_id
     *
     * @return public.motor_brand_all_attr.brand_id, 
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * 设置  字段:public.motor_brand_all_attr.brand_id
     *
     * @param brandId the value for public.motor_brand_all_attr.brand_id, 
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取  字段:public.motor_brand_all_attr.brand_name
     *
     * @return public.motor_brand_all_attr.brand_name, 
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置  字段:public.motor_brand_all_attr.brand_name
     *
     * @param brandName the value for public.motor_brand_all_attr.brand_name, 
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * 获取  字段:public.motor_brand_all_attr.sub_brand_id
     *
     * @return public.motor_brand_all_attr.sub_brand_id, 
     */
    public Integer getSubBrandId() {
        return subBrandId;
    }

    /**
     * 设置  字段:public.motor_brand_all_attr.sub_brand_id
     *
     * @param subBrandId the value for public.motor_brand_all_attr.sub_brand_id, 
     */
    public void setSubBrandId(Integer subBrandId) {
        this.subBrandId = subBrandId;
    }

    /**
     * 获取  字段:public.motor_brand_all_attr.sub_brand_name
     *
     * @return public.motor_brand_all_attr.sub_brand_name, 
     */
    public String getSubBrandName() {
        return subBrandName;
    }

    /**
     * 设置  字段:public.motor_brand_all_attr.sub_brand_name
     *
     * @param subBrandName the value for public.motor_brand_all_attr.sub_brand_name, 
     */
    public void setSubBrandName(String subBrandName) {
        this.subBrandName = subBrandName;
    }

    /**
     * 获取  字段:public.motor_brand_all_attr.year_id
     *
     * @return public.motor_brand_all_attr.year_id, 
     */
    public Integer getYearId() {
        return yearId;
    }

    /**
     * 设置  字段:public.motor_brand_all_attr.year_id
     *
     * @param yearId the value for public.motor_brand_all_attr.year_id, 
     */
    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    /**
     * 获取  字段:public.motor_brand_all_attr.year_name
     *
     * @return public.motor_brand_all_attr.year_name, 
     */
    public String getYearName() {
        return yearName;
    }

    /**
     * 设置  字段:public.motor_brand_all_attr.year_name
     *
     * @param yearName the value for public.motor_brand_all_attr.year_name, 
     */
    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    /**
     * 获取  字段:public.motor_brand_all_attr.engine_fuel
     *
     * @return public.motor_brand_all_attr.engine_fuel, 
     */
    public Short getEngineFuel() {
        return engineFuel;
    }

    /**
     * 设置  字段:public.motor_brand_all_attr.engine_fuel
     *
     * @param engineFuel the value for public.motor_brand_all_attr.engine_fuel, 
     */
    public void setEngineFuel(Short engineFuel) {
        this.engineFuel = engineFuel;
    }
}