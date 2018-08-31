/**
  * VehiclesCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-30
  */
package com.sensenets.sinopec.buiness.model.two;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title public.vehicles表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-30 12:15:18
 */
public class VehiclesCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     *  构造查询条件:public.vehicles
     */
    public VehiclesCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *  设置排序字段:public.vehicles
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *  获取排序字段:public.vehicles
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *  设置过滤重复数据:public.vehicles
     *
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *  是否过滤重复数据:public.vehicles
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *  获取当前的查询条件实例:public.vehicles
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * :public.vehicles
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * :public.vehicles
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *  创建一个查询条件:public.vehicles
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *  内部构建查询条件对象:public.vehicles
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *  清除查询条件:public.vehicles
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * @Title public.vehicles表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-30 12:15:18
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUtsIsNull() {
            addCriterion("uts is null");
            return (Criteria) this;
        }

        public Criteria andUtsIsNotNull() {
            addCriterion("uts is not null");
            return (Criteria) this;
        }

        public Criteria andUtsEqualTo(Date value) {
            addCriterion("uts =", value, "uts");
            return (Criteria) this;
        }

        public Criteria andUtsNotEqualTo(Date value) {
            addCriterion("uts <>", value, "uts");
            return (Criteria) this;
        }

        public Criteria andUtsGreaterThan(Date value) {
            addCriterion("uts >", value, "uts");
            return (Criteria) this;
        }

        public Criteria andUtsGreaterThanOrEqualTo(Date value) {
            addCriterion("uts >=", value, "uts");
            return (Criteria) this;
        }

        public Criteria andUtsLessThan(Date value) {
            addCriterion("uts <", value, "uts");
            return (Criteria) this;
        }

        public Criteria andUtsLessThanOrEqualTo(Date value) {
            addCriterion("uts <=", value, "uts");
            return (Criteria) this;
        }

        public Criteria andUtsIn(List<Date> values) {
            addCriterion("uts in", values, "uts");
            return (Criteria) this;
        }

        public Criteria andUtsNotIn(List<Date> values) {
            addCriterion("uts not in", values, "uts");
            return (Criteria) this;
        }

        public Criteria andUtsBetween(Date value1, Date value2) {
            addCriterion("uts between", value1, value2, "uts");
            return (Criteria) this;
        }

        public Criteria andUtsNotBetween(Date value1, Date value2) {
            addCriterion("uts not between", value1, value2, "uts");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIsNull() {
            addCriterion("vehicle_id is null");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIsNotNull() {
            addCriterion("vehicle_id is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleIdEqualTo(String value) {
            addCriterion("vehicle_id =", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotEqualTo(String value) {
            addCriterion("vehicle_id <>", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdGreaterThan(String value) {
            addCriterion("vehicle_id >", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_id >=", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLessThan(String value) {
            addCriterion("vehicle_id <", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLessThanOrEqualTo(String value) {
            addCriterion("vehicle_id <=", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdLike(String value) {
            addCriterion("vehicle_id like", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotLike(String value) {
            addCriterion("vehicle_id not like", value, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdIn(List<String> values) {
            addCriterion("vehicle_id in", values, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotIn(List<String> values) {
            addCriterion("vehicle_id not in", values, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdBetween(String value1, String value2) {
            addCriterion("vehicle_id between", value1, value2, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andVehicleIdNotBetween(String value1, String value2) {
            addCriterion("vehicle_id not between", value1, value2, "vehicleId");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(String value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(String value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(String value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(String value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(String value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLike(String value) {
            addCriterion("image_id like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotLike(String value) {
            addCriterion("image_id not like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<String> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<String> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(String value1, String value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(String value1, String value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andTsIsNull() {
            addCriterion("ts is null");
            return (Criteria) this;
        }

        public Criteria andTsIsNotNull() {
            addCriterion("ts is not null");
            return (Criteria) this;
        }

        public Criteria andTsEqualTo(Long value) {
            addCriterion("ts =", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotEqualTo(Long value) {
            addCriterion("ts <>", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsGreaterThan(Long value) {
            addCriterion("ts >", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsGreaterThanOrEqualTo(Long value) {
            addCriterion("ts >=", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLessThan(Long value) {
            addCriterion("ts <", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLessThanOrEqualTo(Long value) {
            addCriterion("ts <=", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsIn(List<Long> values) {
            addCriterion("ts in", values, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotIn(List<Long> values) {
            addCriterion("ts not in", values, "ts");
            return (Criteria) this;
        }

        public Criteria andTsBetween(Long value1, Long value2) {
            addCriterion("ts between", value1, value2, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotBetween(Long value1, Long value2) {
            addCriterion("ts not between", value1, value2, "ts");
            return (Criteria) this;
        }

        public Criteria andRepoIdIsNull() {
            addCriterion("repo_id is null");
            return (Criteria) this;
        }

        public Criteria andRepoIdIsNotNull() {
            addCriterion("repo_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepoIdEqualTo(String value) {
            addCriterion("repo_id =", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdNotEqualTo(String value) {
            addCriterion("repo_id <>", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdGreaterThan(String value) {
            addCriterion("repo_id >", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdGreaterThanOrEqualTo(String value) {
            addCriterion("repo_id >=", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdLessThan(String value) {
            addCriterion("repo_id <", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdLessThanOrEqualTo(String value) {
            addCriterion("repo_id <=", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdLike(String value) {
            addCriterion("repo_id like", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdNotLike(String value) {
            addCriterion("repo_id not like", value, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdIn(List<String> values) {
            addCriterion("repo_id in", values, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdNotIn(List<String> values) {
            addCriterion("repo_id not in", values, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdBetween(String value1, String value2) {
            addCriterion("repo_id between", value1, value2, "repoId");
            return (Criteria) this;
        }

        public Criteria andRepoIdNotBetween(String value1, String value2) {
            addCriterion("repo_id not between", value1, value2, "repoId");
            return (Criteria) this;
        }

        public Criteria andSensorIdIsNull() {
            addCriterion("sensor_id is null");
            return (Criteria) this;
        }

        public Criteria andSensorIdIsNotNull() {
            addCriterion("sensor_id is not null");
            return (Criteria) this;
        }

        public Criteria andSensorIdEqualTo(String value) {
            addCriterion("sensor_id =", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotEqualTo(String value) {
            addCriterion("sensor_id <>", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdGreaterThan(String value) {
            addCriterion("sensor_id >", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_id >=", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLessThan(String value) {
            addCriterion("sensor_id <", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLessThanOrEqualTo(String value) {
            addCriterion("sensor_id <=", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLike(String value) {
            addCriterion("sensor_id like", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotLike(String value) {
            addCriterion("sensor_id not like", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdIn(List<String> values) {
            addCriterion("sensor_id in", values, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotIn(List<String> values) {
            addCriterion("sensor_id not in", values, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdBetween(String value1, String value2) {
            addCriterion("sensor_id between", value1, value2, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotBetween(String value1, String value2) {
            addCriterion("sensor_id not between", value1, value2, "sensorId");
            return (Criteria) this;
        }

        public Criteria andConfidenceIsNull() {
            addCriterion("confidence is null");
            return (Criteria) this;
        }

        public Criteria andConfidenceIsNotNull() {
            addCriterion("confidence is not null");
            return (Criteria) this;
        }

        public Criteria andConfidenceEqualTo(Float value) {
            addCriterion("confidence =", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotEqualTo(Float value) {
            addCriterion("confidence <>", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceGreaterThan(Float value) {
            addCriterion("confidence >", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceGreaterThanOrEqualTo(Float value) {
            addCriterion("confidence >=", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceLessThan(Float value) {
            addCriterion("confidence <", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceLessThanOrEqualTo(Float value) {
            addCriterion("confidence <=", value, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceIn(List<Float> values) {
            addCriterion("confidence in", values, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotIn(List<Float> values) {
            addCriterion("confidence not in", values, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceBetween(Float value1, Float value2) {
            addCriterion("confidence between", value1, value2, "confidence");
            return (Criteria) this;
        }

        public Criteria andConfidenceNotBetween(Float value1, Float value2) {
            addCriterion("confidence not between", value1, value2, "confidence");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Short value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Short value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Short value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Short value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Short value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Short value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Short> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Short> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Short value1, Short value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Short value1, Short value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdIsNull() {
            addCriterion("sub_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdIsNotNull() {
            addCriterion("sub_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdEqualTo(Short value) {
            addCriterion("sub_brand_id =", value, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdNotEqualTo(Short value) {
            addCriterion("sub_brand_id <>", value, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdGreaterThan(Short value) {
            addCriterion("sub_brand_id >", value, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdGreaterThanOrEqualTo(Short value) {
            addCriterion("sub_brand_id >=", value, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdLessThan(Short value) {
            addCriterion("sub_brand_id <", value, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdLessThanOrEqualTo(Short value) {
            addCriterion("sub_brand_id <=", value, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdIn(List<Short> values) {
            addCriterion("sub_brand_id in", values, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdNotIn(List<Short> values) {
            addCriterion("sub_brand_id not in", values, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdBetween(Short value1, Short value2) {
            addCriterion("sub_brand_id between", value1, value2, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdNotBetween(Short value1, Short value2) {
            addCriterion("sub_brand_id not between", value1, value2, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andModelYearIdIsNull() {
            addCriterion("model_year_id is null");
            return (Criteria) this;
        }

        public Criteria andModelYearIdIsNotNull() {
            addCriterion("model_year_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelYearIdEqualTo(Short value) {
            addCriterion("model_year_id =", value, "modelYearId");
            return (Criteria) this;
        }

        public Criteria andModelYearIdNotEqualTo(Short value) {
            addCriterion("model_year_id <>", value, "modelYearId");
            return (Criteria) this;
        }

        public Criteria andModelYearIdGreaterThan(Short value) {
            addCriterion("model_year_id >", value, "modelYearId");
            return (Criteria) this;
        }

        public Criteria andModelYearIdGreaterThanOrEqualTo(Short value) {
            addCriterion("model_year_id >=", value, "modelYearId");
            return (Criteria) this;
        }

        public Criteria andModelYearIdLessThan(Short value) {
            addCriterion("model_year_id <", value, "modelYearId");
            return (Criteria) this;
        }

        public Criteria andModelYearIdLessThanOrEqualTo(Short value) {
            addCriterion("model_year_id <=", value, "modelYearId");
            return (Criteria) this;
        }

        public Criteria andModelYearIdIn(List<Short> values) {
            addCriterion("model_year_id in", values, "modelYearId");
            return (Criteria) this;
        }

        public Criteria andModelYearIdNotIn(List<Short> values) {
            addCriterion("model_year_id not in", values, "modelYearId");
            return (Criteria) this;
        }

        public Criteria andModelYearIdBetween(Short value1, Short value2) {
            addCriterion("model_year_id between", value1, value2, "modelYearId");
            return (Criteria) this;
        }

        public Criteria andModelYearIdNotBetween(Short value1, Short value2) {
            addCriterion("model_year_id not between", value1, value2, "modelYearId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Short value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Short value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Short value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Short value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Short value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Short value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Short> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Short> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Short value1, Short value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Short value1, Short value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andColorIdIsNull() {
            addCriterion("color_id is null");
            return (Criteria) this;
        }

        public Criteria andColorIdIsNotNull() {
            addCriterion("color_id is not null");
            return (Criteria) this;
        }

        public Criteria andColorIdEqualTo(Short value) {
            addCriterion("color_id =", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotEqualTo(Short value) {
            addCriterion("color_id <>", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdGreaterThan(Short value) {
            addCriterion("color_id >", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdGreaterThanOrEqualTo(Short value) {
            addCriterion("color_id >=", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLessThan(Short value) {
            addCriterion("color_id <", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLessThanOrEqualTo(Short value) {
            addCriterion("color_id <=", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdIn(List<Short> values) {
            addCriterion("color_id in", values, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotIn(List<Short> values) {
            addCriterion("color_id not in", values, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdBetween(Short value1, Short value2) {
            addCriterion("color_id between", value1, value2, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotBetween(Short value1, Short value2) {
            addCriterion("color_id not between", value1, value2, "colorId");
            return (Criteria) this;
        }

        public Criteria andPlateTextIsNull() {
            addCriterion("plate_text is null");
            return (Criteria) this;
        }

        public Criteria andPlateTextIsNotNull() {
            addCriterion("plate_text is not null");
            return (Criteria) this;
        }

        public Criteria andPlateTextEqualTo(String value) {
            addCriterion("plate_text =", value, "plateText");
            return (Criteria) this;
        }

        public Criteria andPlateTextNotEqualTo(String value) {
            addCriterion("plate_text <>", value, "plateText");
            return (Criteria) this;
        }

        public Criteria andPlateTextGreaterThan(String value) {
            addCriterion("plate_text >", value, "plateText");
            return (Criteria) this;
        }

        public Criteria andPlateTextGreaterThanOrEqualTo(String value) {
            addCriterion("plate_text >=", value, "plateText");
            return (Criteria) this;
        }

        public Criteria andPlateTextLessThan(String value) {
            addCriterion("plate_text <", value, "plateText");
            return (Criteria) this;
        }

        public Criteria andPlateTextLessThanOrEqualTo(String value) {
            addCriterion("plate_text <=", value, "plateText");
            return (Criteria) this;
        }

        public Criteria andPlateTextLike(String value) {
            addCriterion("plate_text like", value, "plateText");
            return (Criteria) this;
        }

        public Criteria andPlateTextNotLike(String value) {
            addCriterion("plate_text not like", value, "plateText");
            return (Criteria) this;
        }

        public Criteria andPlateTextIn(List<String> values) {
            addCriterion("plate_text in", values, "plateText");
            return (Criteria) this;
        }

        public Criteria andPlateTextNotIn(List<String> values) {
            addCriterion("plate_text not in", values, "plateText");
            return (Criteria) this;
        }

        public Criteria andPlateTextBetween(String value1, String value2) {
            addCriterion("plate_text between", value1, value2, "plateText");
            return (Criteria) this;
        }

        public Criteria andPlateTextNotBetween(String value1, String value2) {
            addCriterion("plate_text not between", value1, value2, "plateText");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIdIsNull() {
            addCriterion("plate_type_id is null");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIdIsNotNull() {
            addCriterion("plate_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIdEqualTo(Short value) {
            addCriterion("plate_type_id =", value, "plateTypeId");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIdNotEqualTo(Short value) {
            addCriterion("plate_type_id <>", value, "plateTypeId");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIdGreaterThan(Short value) {
            addCriterion("plate_type_id >", value, "plateTypeId");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIdGreaterThanOrEqualTo(Short value) {
            addCriterion("plate_type_id >=", value, "plateTypeId");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIdLessThan(Short value) {
            addCriterion("plate_type_id <", value, "plateTypeId");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIdLessThanOrEqualTo(Short value) {
            addCriterion("plate_type_id <=", value, "plateTypeId");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIdIn(List<Short> values) {
            addCriterion("plate_type_id in", values, "plateTypeId");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIdNotIn(List<Short> values) {
            addCriterion("plate_type_id not in", values, "plateTypeId");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIdBetween(Short value1, Short value2) {
            addCriterion("plate_type_id between", value1, value2, "plateTypeId");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIdNotBetween(Short value1, Short value2) {
            addCriterion("plate_type_id not between", value1, value2, "plateTypeId");
            return (Criteria) this;
        }

        public Criteria andPlateColorIdIsNull() {
            addCriterion("plate_color_id is null");
            return (Criteria) this;
        }

        public Criteria andPlateColorIdIsNotNull() {
            addCriterion("plate_color_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlateColorIdEqualTo(Short value) {
            addCriterion("plate_color_id =", value, "plateColorId");
            return (Criteria) this;
        }

        public Criteria andPlateColorIdNotEqualTo(Short value) {
            addCriterion("plate_color_id <>", value, "plateColorId");
            return (Criteria) this;
        }

        public Criteria andPlateColorIdGreaterThan(Short value) {
            addCriterion("plate_color_id >", value, "plateColorId");
            return (Criteria) this;
        }

        public Criteria andPlateColorIdGreaterThanOrEqualTo(Short value) {
            addCriterion("plate_color_id >=", value, "plateColorId");
            return (Criteria) this;
        }

        public Criteria andPlateColorIdLessThan(Short value) {
            addCriterion("plate_color_id <", value, "plateColorId");
            return (Criteria) this;
        }

        public Criteria andPlateColorIdLessThanOrEqualTo(Short value) {
            addCriterion("plate_color_id <=", value, "plateColorId");
            return (Criteria) this;
        }

        public Criteria andPlateColorIdIn(List<Short> values) {
            addCriterion("plate_color_id in", values, "plateColorId");
            return (Criteria) this;
        }

        public Criteria andPlateColorIdNotIn(List<Short> values) {
            addCriterion("plate_color_id not in", values, "plateColorId");
            return (Criteria) this;
        }

        public Criteria andPlateColorIdBetween(Short value1, Short value2) {
            addCriterion("plate_color_id between", value1, value2, "plateColorId");
            return (Criteria) this;
        }

        public Criteria andPlateColorIdNotBetween(Short value1, Short value2) {
            addCriterion("plate_color_id not between", value1, value2, "plateColorId");
            return (Criteria) this;
        }

        public Criteria andSideIsNull() {
            addCriterion("side is null");
            return (Criteria) this;
        }

        public Criteria andSideIsNotNull() {
            addCriterion("side is not null");
            return (Criteria) this;
        }

        public Criteria andSideEqualTo(Short value) {
            addCriterion("side =", value, "side");
            return (Criteria) this;
        }

        public Criteria andSideNotEqualTo(Short value) {
            addCriterion("side <>", value, "side");
            return (Criteria) this;
        }

        public Criteria andSideGreaterThan(Short value) {
            addCriterion("side >", value, "side");
            return (Criteria) this;
        }

        public Criteria andSideGreaterThanOrEqualTo(Short value) {
            addCriterion("side >=", value, "side");
            return (Criteria) this;
        }

        public Criteria andSideLessThan(Short value) {
            addCriterion("side <", value, "side");
            return (Criteria) this;
        }

        public Criteria andSideLessThanOrEqualTo(Short value) {
            addCriterion("side <=", value, "side");
            return (Criteria) this;
        }

        public Criteria andSideIn(List<Short> values) {
            addCriterion("side in", values, "side");
            return (Criteria) this;
        }

        public Criteria andSideNotIn(List<Short> values) {
            addCriterion("side not in", values, "side");
            return (Criteria) this;
        }

        public Criteria andSideBetween(Short value1, Short value2) {
            addCriterion("side between", value1, value2, "side");
            return (Criteria) this;
        }

        public Criteria andSideNotBetween(Short value1, Short value2) {
            addCriterion("side not between", value1, value2, "side");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Short value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Short value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Short value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Short value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Short value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Short value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Short> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Short> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Short value1, Short value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Short value1, Short value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNull() {
            addCriterion("speed is null");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNotNull() {
            addCriterion("speed is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedEqualTo(Short value) {
            addCriterion("speed =", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotEqualTo(Short value) {
            addCriterion("speed <>", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThan(Short value) {
            addCriterion("speed >", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThanOrEqualTo(Short value) {
            addCriterion("speed >=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThan(Short value) {
            addCriterion("speed <", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThanOrEqualTo(Short value) {
            addCriterion("speed <=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedIn(List<Short> values) {
            addCriterion("speed in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotIn(List<Short> values) {
            addCriterion("speed not in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedBetween(Short value1, Short value2) {
            addCriterion("speed between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotBetween(Short value1, Short value2) {
            addCriterion("speed not between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(Short value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(Short value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(Short value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(Short value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(Short value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(Short value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<Short> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<Short> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(Short value1, Short value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(Short value1, Short value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andSymbolIntIsNull() {
            addCriterion("symbol_int is null");
            return (Criteria) this;
        }

        public Criteria andSymbolIntIsNotNull() {
            addCriterion("symbol_int is not null");
            return (Criteria) this;
        }

        public Criteria andSymbolIntEqualTo(Long value) {
            addCriterion("symbol_int =", value, "symbolInt");
            return (Criteria) this;
        }

        public Criteria andSymbolIntNotEqualTo(Long value) {
            addCriterion("symbol_int <>", value, "symbolInt");
            return (Criteria) this;
        }

        public Criteria andSymbolIntGreaterThan(Long value) {
            addCriterion("symbol_int >", value, "symbolInt");
            return (Criteria) this;
        }

        public Criteria andSymbolIntGreaterThanOrEqualTo(Long value) {
            addCriterion("symbol_int >=", value, "symbolInt");
            return (Criteria) this;
        }

        public Criteria andSymbolIntLessThan(Long value) {
            addCriterion("symbol_int <", value, "symbolInt");
            return (Criteria) this;
        }

        public Criteria andSymbolIntLessThanOrEqualTo(Long value) {
            addCriterion("symbol_int <=", value, "symbolInt");
            return (Criteria) this;
        }

        public Criteria andSymbolIntIn(List<Long> values) {
            addCriterion("symbol_int in", values, "symbolInt");
            return (Criteria) this;
        }

        public Criteria andSymbolIntNotIn(List<Long> values) {
            addCriterion("symbol_int not in", values, "symbolInt");
            return (Criteria) this;
        }

        public Criteria andSymbolIntBetween(Long value1, Long value2) {
            addCriterion("symbol_int between", value1, value2, "symbolInt");
            return (Criteria) this;
        }

        public Criteria andSymbolIntNotBetween(Long value1, Long value2) {
            addCriterion("symbol_int not between", value1, value2, "symbolInt");
            return (Criteria) this;
        }

        public Criteria andSymbolStrIsNull() {
            addCriterion("symbol_str is null");
            return (Criteria) this;
        }

        public Criteria andSymbolStrIsNotNull() {
            addCriterion("symbol_str is not null");
            return (Criteria) this;
        }

        public Criteria andSymbolStrEqualTo(String value) {
            addCriterion("symbol_str =", value, "symbolStr");
            return (Criteria) this;
        }

        public Criteria andSymbolStrNotEqualTo(String value) {
            addCriterion("symbol_str <>", value, "symbolStr");
            return (Criteria) this;
        }

        public Criteria andSymbolStrGreaterThan(String value) {
            addCriterion("symbol_str >", value, "symbolStr");
            return (Criteria) this;
        }

        public Criteria andSymbolStrGreaterThanOrEqualTo(String value) {
            addCriterion("symbol_str >=", value, "symbolStr");
            return (Criteria) this;
        }

        public Criteria andSymbolStrLessThan(String value) {
            addCriterion("symbol_str <", value, "symbolStr");
            return (Criteria) this;
        }

        public Criteria andSymbolStrLessThanOrEqualTo(String value) {
            addCriterion("symbol_str <=", value, "symbolStr");
            return (Criteria) this;
        }

        public Criteria andSymbolStrLike(String value) {
            addCriterion("symbol_str like", value, "symbolStr");
            return (Criteria) this;
        }

        public Criteria andSymbolStrNotLike(String value) {
            addCriterion("symbol_str not like", value, "symbolStr");
            return (Criteria) this;
        }

        public Criteria andSymbolStrIn(List<String> values) {
            addCriterion("symbol_str in", values, "symbolStr");
            return (Criteria) this;
        }

        public Criteria andSymbolStrNotIn(List<String> values) {
            addCriterion("symbol_str not in", values, "symbolStr");
            return (Criteria) this;
        }

        public Criteria andSymbolStrBetween(String value1, String value2) {
            addCriterion("symbol_str between", value1, value2, "symbolStr");
            return (Criteria) this;
        }

        public Criteria andSymbolStrNotBetween(String value1, String value2) {
            addCriterion("symbol_str not between", value1, value2, "symbolStr");
            return (Criteria) this;
        }

        public Criteria andIllegalIntIsNull() {
            addCriterion("illegal_int is null");
            return (Criteria) this;
        }

        public Criteria andIllegalIntIsNotNull() {
            addCriterion("illegal_int is not null");
            return (Criteria) this;
        }

        public Criteria andIllegalIntEqualTo(Long value) {
            addCriterion("illegal_int =", value, "illegalInt");
            return (Criteria) this;
        }

        public Criteria andIllegalIntNotEqualTo(Long value) {
            addCriterion("illegal_int <>", value, "illegalInt");
            return (Criteria) this;
        }

        public Criteria andIllegalIntGreaterThan(Long value) {
            addCriterion("illegal_int >", value, "illegalInt");
            return (Criteria) this;
        }

        public Criteria andIllegalIntGreaterThanOrEqualTo(Long value) {
            addCriterion("illegal_int >=", value, "illegalInt");
            return (Criteria) this;
        }

        public Criteria andIllegalIntLessThan(Long value) {
            addCriterion("illegal_int <", value, "illegalInt");
            return (Criteria) this;
        }

        public Criteria andIllegalIntLessThanOrEqualTo(Long value) {
            addCriterion("illegal_int <=", value, "illegalInt");
            return (Criteria) this;
        }

        public Criteria andIllegalIntIn(List<Long> values) {
            addCriterion("illegal_int in", values, "illegalInt");
            return (Criteria) this;
        }

        public Criteria andIllegalIntNotIn(List<Long> values) {
            addCriterion("illegal_int not in", values, "illegalInt");
            return (Criteria) this;
        }

        public Criteria andIllegalIntBetween(Long value1, Long value2) {
            addCriterion("illegal_int between", value1, value2, "illegalInt");
            return (Criteria) this;
        }

        public Criteria andIllegalIntNotBetween(Long value1, Long value2) {
            addCriterion("illegal_int not between", value1, value2, "illegalInt");
            return (Criteria) this;
        }

        public Criteria andIllegalStrIsNull() {
            addCriterion("illegal_str is null");
            return (Criteria) this;
        }

        public Criteria andIllegalStrIsNotNull() {
            addCriterion("illegal_str is not null");
            return (Criteria) this;
        }

        public Criteria andIllegalStrEqualTo(String value) {
            addCriterion("illegal_str =", value, "illegalStr");
            return (Criteria) this;
        }

        public Criteria andIllegalStrNotEqualTo(String value) {
            addCriterion("illegal_str <>", value, "illegalStr");
            return (Criteria) this;
        }

        public Criteria andIllegalStrGreaterThan(String value) {
            addCriterion("illegal_str >", value, "illegalStr");
            return (Criteria) this;
        }

        public Criteria andIllegalStrGreaterThanOrEqualTo(String value) {
            addCriterion("illegal_str >=", value, "illegalStr");
            return (Criteria) this;
        }

        public Criteria andIllegalStrLessThan(String value) {
            addCriterion("illegal_str <", value, "illegalStr");
            return (Criteria) this;
        }

        public Criteria andIllegalStrLessThanOrEqualTo(String value) {
            addCriterion("illegal_str <=", value, "illegalStr");
            return (Criteria) this;
        }

        public Criteria andIllegalStrLike(String value) {
            addCriterion("illegal_str like", value, "illegalStr");
            return (Criteria) this;
        }

        public Criteria andIllegalStrNotLike(String value) {
            addCriterion("illegal_str not like", value, "illegalStr");
            return (Criteria) this;
        }

        public Criteria andIllegalStrIn(List<String> values) {
            addCriterion("illegal_str in", values, "illegalStr");
            return (Criteria) this;
        }

        public Criteria andIllegalStrNotIn(List<String> values) {
            addCriterion("illegal_str not in", values, "illegalStr");
            return (Criteria) this;
        }

        public Criteria andIllegalStrBetween(String value1, String value2) {
            addCriterion("illegal_str between", value1, value2, "illegalStr");
            return (Criteria) this;
        }

        public Criteria andIllegalStrNotBetween(String value1, String value2) {
            addCriterion("illegal_str not between", value1, value2, "illegalStr");
            return (Criteria) this;
        }

        public Criteria andCoillegalIntIsNull() {
            addCriterion("coillegal_int is null");
            return (Criteria) this;
        }

        public Criteria andCoillegalIntIsNotNull() {
            addCriterion("coillegal_int is not null");
            return (Criteria) this;
        }

        public Criteria andCoillegalIntEqualTo(Long value) {
            addCriterion("coillegal_int =", value, "coillegalInt");
            return (Criteria) this;
        }

        public Criteria andCoillegalIntNotEqualTo(Long value) {
            addCriterion("coillegal_int <>", value, "coillegalInt");
            return (Criteria) this;
        }

        public Criteria andCoillegalIntGreaterThan(Long value) {
            addCriterion("coillegal_int >", value, "coillegalInt");
            return (Criteria) this;
        }

        public Criteria andCoillegalIntGreaterThanOrEqualTo(Long value) {
            addCriterion("coillegal_int >=", value, "coillegalInt");
            return (Criteria) this;
        }

        public Criteria andCoillegalIntLessThan(Long value) {
            addCriterion("coillegal_int <", value, "coillegalInt");
            return (Criteria) this;
        }

        public Criteria andCoillegalIntLessThanOrEqualTo(Long value) {
            addCriterion("coillegal_int <=", value, "coillegalInt");
            return (Criteria) this;
        }

        public Criteria andCoillegalIntIn(List<Long> values) {
            addCriterion("coillegal_int in", values, "coillegalInt");
            return (Criteria) this;
        }

        public Criteria andCoillegalIntNotIn(List<Long> values) {
            addCriterion("coillegal_int not in", values, "coillegalInt");
            return (Criteria) this;
        }

        public Criteria andCoillegalIntBetween(Long value1, Long value2) {
            addCriterion("coillegal_int between", value1, value2, "coillegalInt");
            return (Criteria) this;
        }

        public Criteria andCoillegalIntNotBetween(Long value1, Long value2) {
            addCriterion("coillegal_int not between", value1, value2, "coillegalInt");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrIsNull() {
            addCriterion("coillegal_str is null");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrIsNotNull() {
            addCriterion("coillegal_str is not null");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrEqualTo(String value) {
            addCriterion("coillegal_str =", value, "coillegalStr");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrNotEqualTo(String value) {
            addCriterion("coillegal_str <>", value, "coillegalStr");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrGreaterThan(String value) {
            addCriterion("coillegal_str >", value, "coillegalStr");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrGreaterThanOrEqualTo(String value) {
            addCriterion("coillegal_str >=", value, "coillegalStr");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrLessThan(String value) {
            addCriterion("coillegal_str <", value, "coillegalStr");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrLessThanOrEqualTo(String value) {
            addCriterion("coillegal_str <=", value, "coillegalStr");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrLike(String value) {
            addCriterion("coillegal_str like", value, "coillegalStr");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrNotLike(String value) {
            addCriterion("coillegal_str not like", value, "coillegalStr");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrIn(List<String> values) {
            addCriterion("coillegal_str in", values, "coillegalStr");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrNotIn(List<String> values) {
            addCriterion("coillegal_str not in", values, "coillegalStr");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrBetween(String value1, String value2) {
            addCriterion("coillegal_str between", value1, value2, "coillegalStr");
            return (Criteria) this;
        }

        public Criteria andCoillegalStrNotBetween(String value1, String value2) {
            addCriterion("coillegal_str not between", value1, value2, "coillegalStr");
            return (Criteria) this;
        }

        public Criteria andSpecialIntIsNull() {
            addCriterion("special_int is null");
            return (Criteria) this;
        }

        public Criteria andSpecialIntIsNotNull() {
            addCriterion("special_int is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialIntEqualTo(Long value) {
            addCriterion("special_int =", value, "specialInt");
            return (Criteria) this;
        }

        public Criteria andSpecialIntNotEqualTo(Long value) {
            addCriterion("special_int <>", value, "specialInt");
            return (Criteria) this;
        }

        public Criteria andSpecialIntGreaterThan(Long value) {
            addCriterion("special_int >", value, "specialInt");
            return (Criteria) this;
        }

        public Criteria andSpecialIntGreaterThanOrEqualTo(Long value) {
            addCriterion("special_int >=", value, "specialInt");
            return (Criteria) this;
        }

        public Criteria andSpecialIntLessThan(Long value) {
            addCriterion("special_int <", value, "specialInt");
            return (Criteria) this;
        }

        public Criteria andSpecialIntLessThanOrEqualTo(Long value) {
            addCriterion("special_int <=", value, "specialInt");
            return (Criteria) this;
        }

        public Criteria andSpecialIntIn(List<Long> values) {
            addCriterion("special_int in", values, "specialInt");
            return (Criteria) this;
        }

        public Criteria andSpecialIntNotIn(List<Long> values) {
            addCriterion("special_int not in", values, "specialInt");
            return (Criteria) this;
        }

        public Criteria andSpecialIntBetween(Long value1, Long value2) {
            addCriterion("special_int between", value1, value2, "specialInt");
            return (Criteria) this;
        }

        public Criteria andSpecialIntNotBetween(Long value1, Long value2) {
            addCriterion("special_int not between", value1, value2, "specialInt");
            return (Criteria) this;
        }

        public Criteria andSpecialStrIsNull() {
            addCriterion("special_str is null");
            return (Criteria) this;
        }

        public Criteria andSpecialStrIsNotNull() {
            addCriterion("special_str is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialStrEqualTo(String value) {
            addCriterion("special_str =", value, "specialStr");
            return (Criteria) this;
        }

        public Criteria andSpecialStrNotEqualTo(String value) {
            addCriterion("special_str <>", value, "specialStr");
            return (Criteria) this;
        }

        public Criteria andSpecialStrGreaterThan(String value) {
            addCriterion("special_str >", value, "specialStr");
            return (Criteria) this;
        }

        public Criteria andSpecialStrGreaterThanOrEqualTo(String value) {
            addCriterion("special_str >=", value, "specialStr");
            return (Criteria) this;
        }

        public Criteria andSpecialStrLessThan(String value) {
            addCriterion("special_str <", value, "specialStr");
            return (Criteria) this;
        }

        public Criteria andSpecialStrLessThanOrEqualTo(String value) {
            addCriterion("special_str <=", value, "specialStr");
            return (Criteria) this;
        }

        public Criteria andSpecialStrLike(String value) {
            addCriterion("special_str like", value, "specialStr");
            return (Criteria) this;
        }

        public Criteria andSpecialStrNotLike(String value) {
            addCriterion("special_str not like", value, "specialStr");
            return (Criteria) this;
        }

        public Criteria andSpecialStrIn(List<String> values) {
            addCriterion("special_str in", values, "specialStr");
            return (Criteria) this;
        }

        public Criteria andSpecialStrNotIn(List<String> values) {
            addCriterion("special_str not in", values, "specialStr");
            return (Criteria) this;
        }

        public Criteria andSpecialStrBetween(String value1, String value2) {
            addCriterion("special_str between", value1, value2, "specialStr");
            return (Criteria) this;
        }

        public Criteria andSpecialStrNotBetween(String value1, String value2) {
            addCriterion("special_str not between", value1, value2, "specialStr");
            return (Criteria) this;
        }

        public Criteria andDriverOnThePhoneIsNull() {
            addCriterion("driver_on_the_phone is null");
            return (Criteria) this;
        }

        public Criteria andDriverOnThePhoneIsNotNull() {
            addCriterion("driver_on_the_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDriverOnThePhoneEqualTo(Boolean value) {
            addCriterion("driver_on_the_phone =", value, "driverOnThePhone");
            return (Criteria) this;
        }

        public Criteria andDriverOnThePhoneNotEqualTo(Boolean value) {
            addCriterion("driver_on_the_phone <>", value, "driverOnThePhone");
            return (Criteria) this;
        }

        public Criteria andDriverOnThePhoneGreaterThan(Boolean value) {
            addCriterion("driver_on_the_phone >", value, "driverOnThePhone");
            return (Criteria) this;
        }

        public Criteria andDriverOnThePhoneGreaterThanOrEqualTo(Boolean value) {
            addCriterion("driver_on_the_phone >=", value, "driverOnThePhone");
            return (Criteria) this;
        }

        public Criteria andDriverOnThePhoneLessThan(Boolean value) {
            addCriterion("driver_on_the_phone <", value, "driverOnThePhone");
            return (Criteria) this;
        }

        public Criteria andDriverOnThePhoneLessThanOrEqualTo(Boolean value) {
            addCriterion("driver_on_the_phone <=", value, "driverOnThePhone");
            return (Criteria) this;
        }

        public Criteria andDriverOnThePhoneIn(List<Boolean> values) {
            addCriterion("driver_on_the_phone in", values, "driverOnThePhone");
            return (Criteria) this;
        }

        public Criteria andDriverOnThePhoneNotIn(List<Boolean> values) {
            addCriterion("driver_on_the_phone not in", values, "driverOnThePhone");
            return (Criteria) this;
        }

        public Criteria andDriverOnThePhoneBetween(Boolean value1, Boolean value2) {
            addCriterion("driver_on_the_phone between", value1, value2, "driverOnThePhone");
            return (Criteria) this;
        }

        public Criteria andDriverOnThePhoneNotBetween(Boolean value1, Boolean value2) {
            addCriterion("driver_on_the_phone not between", value1, value2, "driverOnThePhone");
            return (Criteria) this;
        }

        public Criteria andDriverWithoutBeltIsNull() {
            addCriterion("driver_without_belt is null");
            return (Criteria) this;
        }

        public Criteria andDriverWithoutBeltIsNotNull() {
            addCriterion("driver_without_belt is not null");
            return (Criteria) this;
        }

        public Criteria andDriverWithoutBeltEqualTo(Boolean value) {
            addCriterion("driver_without_belt =", value, "driverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andDriverWithoutBeltNotEqualTo(Boolean value) {
            addCriterion("driver_without_belt <>", value, "driverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andDriverWithoutBeltGreaterThan(Boolean value) {
            addCriterion("driver_without_belt >", value, "driverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andDriverWithoutBeltGreaterThanOrEqualTo(Boolean value) {
            addCriterion("driver_without_belt >=", value, "driverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andDriverWithoutBeltLessThan(Boolean value) {
            addCriterion("driver_without_belt <", value, "driverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andDriverWithoutBeltLessThanOrEqualTo(Boolean value) {
            addCriterion("driver_without_belt <=", value, "driverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andDriverWithoutBeltIn(List<Boolean> values) {
            addCriterion("driver_without_belt in", values, "driverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andDriverWithoutBeltNotIn(List<Boolean> values) {
            addCriterion("driver_without_belt not in", values, "driverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andDriverWithoutBeltBetween(Boolean value1, Boolean value2) {
            addCriterion("driver_without_belt between", value1, value2, "driverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andDriverWithoutBeltNotBetween(Boolean value1, Boolean value2) {
            addCriterion("driver_without_belt not between", value1, value2, "driverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andCodriverWithoutBeltIsNull() {
            addCriterion("codriver_without_belt is null");
            return (Criteria) this;
        }

        public Criteria andCodriverWithoutBeltIsNotNull() {
            addCriterion("codriver_without_belt is not null");
            return (Criteria) this;
        }

        public Criteria andCodriverWithoutBeltEqualTo(Boolean value) {
            addCriterion("codriver_without_belt =", value, "codriverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andCodriverWithoutBeltNotEqualTo(Boolean value) {
            addCriterion("codriver_without_belt <>", value, "codriverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andCodriverWithoutBeltGreaterThan(Boolean value) {
            addCriterion("codriver_without_belt >", value, "codriverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andCodriverWithoutBeltGreaterThanOrEqualTo(Boolean value) {
            addCriterion("codriver_without_belt >=", value, "codriverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andCodriverWithoutBeltLessThan(Boolean value) {
            addCriterion("codriver_without_belt <", value, "codriverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andCodriverWithoutBeltLessThanOrEqualTo(Boolean value) {
            addCriterion("codriver_without_belt <=", value, "codriverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andCodriverWithoutBeltIn(List<Boolean> values) {
            addCriterion("codriver_without_belt in", values, "codriverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andCodriverWithoutBeltNotIn(List<Boolean> values) {
            addCriterion("codriver_without_belt not in", values, "codriverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andCodriverWithoutBeltBetween(Boolean value1, Boolean value2) {
            addCriterion("codriver_without_belt between", value1, value2, "codriverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andCodriverWithoutBeltNotBetween(Boolean value1, Boolean value2) {
            addCriterion("codriver_without_belt not between", value1, value2, "codriverWithoutBelt");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andLaneIsNull() {
            addCriterion("lane is null");
            return (Criteria) this;
        }

        public Criteria andLaneIsNotNull() {
            addCriterion("lane is not null");
            return (Criteria) this;
        }

        public Criteria andLaneEqualTo(String value) {
            addCriterion("lane =", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneNotEqualTo(String value) {
            addCriterion("lane <>", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneGreaterThan(String value) {
            addCriterion("lane >", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneGreaterThanOrEqualTo(String value) {
            addCriterion("lane >=", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneLessThan(String value) {
            addCriterion("lane <", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneLessThanOrEqualTo(String value) {
            addCriterion("lane <=", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneLike(String value) {
            addCriterion("lane like", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneNotLike(String value) {
            addCriterion("lane not like", value, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneIn(List<String> values) {
            addCriterion("lane in", values, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneNotIn(List<String> values) {
            addCriterion("lane not in", values, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneBetween(String value1, String value2) {
            addCriterion("lane between", value1, value2, "lane");
            return (Criteria) this;
        }

        public Criteria andLaneNotBetween(String value1, String value2) {
            addCriterion("lane not between", value1, value2, "lane");
            return (Criteria) this;
        }

        public Criteria andFaceIdIsNull() {
            addCriterion("face_id is null");
            return (Criteria) this;
        }

        public Criteria andFaceIdIsNotNull() {
            addCriterion("face_id is not null");
            return (Criteria) this;
        }

        public Criteria andFaceIdEqualTo(String value) {
            addCriterion("face_id =", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdNotEqualTo(String value) {
            addCriterion("face_id <>", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdGreaterThan(String value) {
            addCriterion("face_id >", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdGreaterThanOrEqualTo(String value) {
            addCriterion("face_id >=", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdLessThan(String value) {
            addCriterion("face_id <", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdLessThanOrEqualTo(String value) {
            addCriterion("face_id <=", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdLike(String value) {
            addCriterion("face_id like", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdNotLike(String value) {
            addCriterion("face_id not like", value, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdIn(List<String> values) {
            addCriterion("face_id in", values, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdNotIn(List<String> values) {
            addCriterion("face_id not in", values, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdBetween(String value1, String value2) {
            addCriterion("face_id between", value1, value2, "faceId");
            return (Criteria) this;
        }

        public Criteria andFaceIdNotBetween(String value1, String value2) {
            addCriterion("face_id not between", value1, value2, "faceId");
            return (Criteria) this;
        }

        public Criteria andOilTypeIsNull() {
            addCriterion("oil_type is null");
            return (Criteria) this;
        }

        public Criteria andOilTypeIsNotNull() {
            addCriterion("oil_type is not null");
            return (Criteria) this;
        }

        public Criteria andOilTypeEqualTo(String value) {
            addCriterion("oil_type =", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeNotEqualTo(String value) {
            addCriterion("oil_type <>", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeGreaterThan(String value) {
            addCriterion("oil_type >", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeGreaterThanOrEqualTo(String value) {
            addCriterion("oil_type >=", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeLessThan(String value) {
            addCriterion("oil_type <", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeLessThanOrEqualTo(String value) {
            addCriterion("oil_type <=", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeLike(String value) {
            addCriterion("oil_type like", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeNotLike(String value) {
            addCriterion("oil_type not like", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeIn(List<String> values) {
            addCriterion("oil_type in", values, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeNotIn(List<String> values) {
            addCriterion("oil_type not in", values, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeBetween(String value1, String value2) {
            addCriterion("oil_type between", value1, value2, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeNotBetween(String value1, String value2) {
            addCriterion("oil_type not between", value1, value2, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilAmountIsNull() {
            addCriterion("oil_amount is null");
            return (Criteria) this;
        }

        public Criteria andOilAmountIsNotNull() {
            addCriterion("oil_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOilAmountEqualTo(Float value) {
            addCriterion("oil_amount =", value, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountNotEqualTo(Float value) {
            addCriterion("oil_amount <>", value, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountGreaterThan(Float value) {
            addCriterion("oil_amount >", value, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("oil_amount >=", value, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountLessThan(Float value) {
            addCriterion("oil_amount <", value, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountLessThanOrEqualTo(Float value) {
            addCriterion("oil_amount <=", value, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountIn(List<Float> values) {
            addCriterion("oil_amount in", values, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountNotIn(List<Float> values) {
            addCriterion("oil_amount not in", values, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountBetween(Float value1, Float value2) {
            addCriterion("oil_amount between", value1, value2, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountNotBetween(Float value1, Float value2) {
            addCriterion("oil_amount not between", value1, value2, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andEngineFuelIsNull() {
            addCriterion("engine_fuel is null");
            return (Criteria) this;
        }

        public Criteria andEngineFuelIsNotNull() {
            addCriterion("engine_fuel is not null");
            return (Criteria) this;
        }

        public Criteria andEngineFuelEqualTo(Short value) {
            addCriterion("engine_fuel =", value, "engineFuel");
            return (Criteria) this;
        }

        public Criteria andEngineFuelNotEqualTo(Short value) {
            addCriterion("engine_fuel <>", value, "engineFuel");
            return (Criteria) this;
        }

        public Criteria andEngineFuelGreaterThan(Short value) {
            addCriterion("engine_fuel >", value, "engineFuel");
            return (Criteria) this;
        }

        public Criteria andEngineFuelGreaterThanOrEqualTo(Short value) {
            addCriterion("engine_fuel >=", value, "engineFuel");
            return (Criteria) this;
        }

        public Criteria andEngineFuelLessThan(Short value) {
            addCriterion("engine_fuel <", value, "engineFuel");
            return (Criteria) this;
        }

        public Criteria andEngineFuelLessThanOrEqualTo(Short value) {
            addCriterion("engine_fuel <=", value, "engineFuel");
            return (Criteria) this;
        }

        public Criteria andEngineFuelIn(List<Short> values) {
            addCriterion("engine_fuel in", values, "engineFuel");
            return (Criteria) this;
        }

        public Criteria andEngineFuelNotIn(List<Short> values) {
            addCriterion("engine_fuel not in", values, "engineFuel");
            return (Criteria) this;
        }

        public Criteria andEngineFuelBetween(Short value1, Short value2) {
            addCriterion("engine_fuel between", value1, value2, "engineFuel");
            return (Criteria) this;
        }

        public Criteria andEngineFuelNotBetween(Short value1, Short value2) {
            addCriterion("engine_fuel not between", value1, value2, "engineFuel");
            return (Criteria) this;
        }
    }

    /**
     * @Title public.vehicles表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-30 12:15:18
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @Title public.vehicles表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-30 12:15:18
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}