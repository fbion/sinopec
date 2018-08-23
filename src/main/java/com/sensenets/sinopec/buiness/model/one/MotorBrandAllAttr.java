/**
  * MotorBrandAllAttr.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.model.one;

import java.io.Serializable;

/**
 * @Title motor_brand_all_attr表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-16 17:09:38
 */
public class MotorBrandAllAttr implements Serializable {
    /**
     * @Fields id 
     */
    private Long id;

    /**
     * @Fields brandId 
     */
    private Integer brandId;

    /**
     * @Fields brandName 
     */
    private String brandName;

    /**
     * @Fields subBrandId 
     */
    private Integer subBrandId;

    /**
     * @Fields subBrandName 
     */
    private String subBrandName;

    /**
     * @Fields yearId 
     */
    private Integer yearId;

    /**
     * @Fields yearName 
     */
    private String yearName;

    /**
     * @Fields engineFuel 
     */
    private Short engineFuel;

    private static final long serialVersionUID = 1L;

    /**
     * 获取  字段:motor_brand_all_attr.id
     *
     * @return motor_brand_all_attr.id, 
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段:motor_brand_all_attr.id
     *
     * @param id the value for motor_brand_all_attr.id, 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段:motor_brand_all_attr.brand_id
     *
     * @return motor_brand_all_attr.brand_id, 
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * 设置  字段:motor_brand_all_attr.brand_id
     *
     * @param brandId the value for motor_brand_all_attr.brand_id, 
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取  字段:motor_brand_all_attr.brand_name
     *
     * @return motor_brand_all_attr.brand_name, 
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置  字段:motor_brand_all_attr.brand_name
     *
     * @param brandName the value for motor_brand_all_attr.brand_name, 
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * 获取  字段:motor_brand_all_attr.sub_brand_id
     *
     * @return motor_brand_all_attr.sub_brand_id, 
     */
    public Integer getSubBrandId() {
        return subBrandId;
    }

    /**
     * 设置  字段:motor_brand_all_attr.sub_brand_id
     *
     * @param subBrandId the value for motor_brand_all_attr.sub_brand_id, 
     */
    public void setSubBrandId(Integer subBrandId) {
        this.subBrandId = subBrandId;
    }

    /**
     * 获取  字段:motor_brand_all_attr.sub_brand_name
     *
     * @return motor_brand_all_attr.sub_brand_name, 
     */
    public String getSubBrandName() {
        return subBrandName;
    }

    /**
     * 设置  字段:motor_brand_all_attr.sub_brand_name
     *
     * @param subBrandName the value for motor_brand_all_attr.sub_brand_name, 
     */
    public void setSubBrandName(String subBrandName) {
        this.subBrandName = subBrandName;
    }

    /**
     * 获取  字段:motor_brand_all_attr.year_id
     *
     * @return motor_brand_all_attr.year_id, 
     */
    public Integer getYearId() {
        return yearId;
    }

    /**
     * 设置  字段:motor_brand_all_attr.year_id
     *
     * @param yearId the value for motor_brand_all_attr.year_id, 
     */
    public void setYearId(Integer yearId) {
        this.yearId = yearId;
    }

    /**
     * 获取  字段:motor_brand_all_attr.year_name
     *
     * @return motor_brand_all_attr.year_name, 
     */
    public String getYearName() {
        return yearName;
    }

    /**
     * 设置  字段:motor_brand_all_attr.year_name
     *
     * @param yearName the value for motor_brand_all_attr.year_name, 
     */
    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    /**
     * 获取  字段:motor_brand_all_attr.engine_fuel
     *
     * @return motor_brand_all_attr.engine_fuel, 
     */
    public Short getEngineFuel() {
        return engineFuel;
    }

    /**
     * 设置  字段:motor_brand_all_attr.engine_fuel
     *
     * @param engineFuel the value for motor_brand_all_attr.engine_fuel, 
     */
    public void setEngineFuel(Short engineFuel) {
        this.engineFuel = engineFuel;
    }
}