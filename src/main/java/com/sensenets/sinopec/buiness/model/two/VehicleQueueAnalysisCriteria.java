/**
  * VehicleQueueAnalysisCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-14
  */
package com.sensenets.sinopec.buiness.model.two;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title public.vehicle_queue_analysis表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-09-14 16:28:28
 */
public class VehicleQueueAnalysisCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     *  构造查询条件:public.vehicle_queue_analysis
     */
    public VehicleQueueAnalysisCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *  设置排序字段:public.vehicle_queue_analysis
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *  获取排序字段:public.vehicle_queue_analysis
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *  设置过滤重复数据:public.vehicle_queue_analysis
     *
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *  是否过滤重复数据:public.vehicle_queue_analysis
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *  获取当前的查询条件实例:public.vehicle_queue_analysis
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * :public.vehicle_queue_analysis
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * :public.vehicle_queue_analysis
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *  创建一个查询条件:public.vehicle_queue_analysis
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *  内部构建查询条件对象:public.vehicle_queue_analysis
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *  清除查询条件:public.vehicle_queue_analysis
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
     * @Title public.vehicle_queue_analysis表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-14 16:28:28
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

        public Criteria andDataDayIsNull() {
            addCriterion("data_day is null");
            return (Criteria) this;
        }

        public Criteria andDataDayIsNotNull() {
            addCriterion("data_day is not null");
            return (Criteria) this;
        }

        public Criteria andDataDayEqualTo(Integer value) {
            addCriterion("data_day =", value, "dataDay");
            return (Criteria) this;
        }

        public Criteria andDataDayNotEqualTo(Integer value) {
            addCriterion("data_day <>", value, "dataDay");
            return (Criteria) this;
        }

        public Criteria andDataDayGreaterThan(Integer value) {
            addCriterion("data_day >", value, "dataDay");
            return (Criteria) this;
        }

        public Criteria andDataDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_day >=", value, "dataDay");
            return (Criteria) this;
        }

        public Criteria andDataDayLessThan(Integer value) {
            addCriterion("data_day <", value, "dataDay");
            return (Criteria) this;
        }

        public Criteria andDataDayLessThanOrEqualTo(Integer value) {
            addCriterion("data_day <=", value, "dataDay");
            return (Criteria) this;
        }

        public Criteria andDataDayIn(List<Integer> values) {
            addCriterion("data_day in", values, "dataDay");
            return (Criteria) this;
        }

        public Criteria andDataDayNotIn(List<Integer> values) {
            addCriterion("data_day not in", values, "dataDay");
            return (Criteria) this;
        }

        public Criteria andDataDayBetween(Integer value1, Integer value2) {
            addCriterion("data_day between", value1, value2, "dataDay");
            return (Criteria) this;
        }

        public Criteria andDataDayNotBetween(Integer value1, Integer value2) {
            addCriterion("data_day not between", value1, value2, "dataDay");
            return (Criteria) this;
        }

        public Criteria andReposIdIsNull() {
            addCriterion("repos_id is null");
            return (Criteria) this;
        }

        public Criteria andReposIdIsNotNull() {
            addCriterion("repos_id is not null");
            return (Criteria) this;
        }

        public Criteria andReposIdEqualTo(String value) {
            addCriterion("repos_id =", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdNotEqualTo(String value) {
            addCriterion("repos_id <>", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdGreaterThan(String value) {
            addCriterion("repos_id >", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdGreaterThanOrEqualTo(String value) {
            addCriterion("repos_id >=", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdLessThan(String value) {
            addCriterion("repos_id <", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdLessThanOrEqualTo(String value) {
            addCriterion("repos_id <=", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdLike(String value) {
            addCriterion("repos_id like", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdNotLike(String value) {
            addCriterion("repos_id not like", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdIn(List<String> values) {
            addCriterion("repos_id in", values, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdNotIn(List<String> values) {
            addCriterion("repos_id not in", values, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdBetween(String value1, String value2) {
            addCriterion("repos_id between", value1, value2, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdNotBetween(String value1, String value2) {
            addCriterion("repos_id not between", value1, value2, "reposId");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIsNull() {
            addCriterion("vehicle_type is null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIsNotNull() {
            addCriterion("vehicle_type is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeEqualTo(Short value) {
            addCriterion("vehicle_type =", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotEqualTo(Short value) {
            addCriterion("vehicle_type <>", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeGreaterThan(Short value) {
            addCriterion("vehicle_type >", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("vehicle_type >=", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLessThan(Short value) {
            addCriterion("vehicle_type <", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLessThanOrEqualTo(Short value) {
            addCriterion("vehicle_type <=", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIn(List<Short> values) {
            addCriterion("vehicle_type in", values, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotIn(List<Short> values) {
            addCriterion("vehicle_type not in", values, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeBetween(Short value1, Short value2) {
            addCriterion("vehicle_type between", value1, value2, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotBetween(Short value1, Short value2) {
            addCriterion("vehicle_type not between", value1, value2, "vehicleType");
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

        public Criteria andBizIdIsNull() {
            addCriterion("biz_id is null");
            return (Criteria) this;
        }

        public Criteria andBizIdIsNotNull() {
            addCriterion("biz_id is not null");
            return (Criteria) this;
        }

        public Criteria andBizIdEqualTo(String value) {
            addCriterion("biz_id =", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotEqualTo(String value) {
            addCriterion("biz_id <>", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThan(String value) {
            addCriterion("biz_id >", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThanOrEqualTo(String value) {
            addCriterion("biz_id >=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThan(String value) {
            addCriterion("biz_id <", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThanOrEqualTo(String value) {
            addCriterion("biz_id <=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLike(String value) {
            addCriterion("biz_id like", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotLike(String value) {
            addCriterion("biz_id not like", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdIn(List<String> values) {
            addCriterion("biz_id in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotIn(List<String> values) {
            addCriterion("biz_id not in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdBetween(String value1, String value2) {
            addCriterion("biz_id between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotBetween(String value1, String value2) {
            addCriterion("biz_id not between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andDataHourIsNull() {
            addCriterion("data_hour is null");
            return (Criteria) this;
        }

        public Criteria andDataHourIsNotNull() {
            addCriterion("data_hour is not null");
            return (Criteria) this;
        }

        public Criteria andDataHourEqualTo(Integer value) {
            addCriterion("data_hour =", value, "dataHour");
            return (Criteria) this;
        }

        public Criteria andDataHourNotEqualTo(Integer value) {
            addCriterion("data_hour <>", value, "dataHour");
            return (Criteria) this;
        }

        public Criteria andDataHourGreaterThan(Integer value) {
            addCriterion("data_hour >", value, "dataHour");
            return (Criteria) this;
        }

        public Criteria andDataHourGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_hour >=", value, "dataHour");
            return (Criteria) this;
        }

        public Criteria andDataHourLessThan(Integer value) {
            addCriterion("data_hour <", value, "dataHour");
            return (Criteria) this;
        }

        public Criteria andDataHourLessThanOrEqualTo(Integer value) {
            addCriterion("data_hour <=", value, "dataHour");
            return (Criteria) this;
        }

        public Criteria andDataHourIn(List<Integer> values) {
            addCriterion("data_hour in", values, "dataHour");
            return (Criteria) this;
        }

        public Criteria andDataHourNotIn(List<Integer> values) {
            addCriterion("data_hour not in", values, "dataHour");
            return (Criteria) this;
        }

        public Criteria andDataHourBetween(Integer value1, Integer value2) {
            addCriterion("data_hour between", value1, value2, "dataHour");
            return (Criteria) this;
        }

        public Criteria andDataHourNotBetween(Integer value1, Integer value2) {
            addCriterion("data_hour not between", value1, value2, "dataHour");
            return (Criteria) this;
        }

        public Criteria andTime5IsNull() {
            addCriterion("time5 is null");
            return (Criteria) this;
        }

        public Criteria andTime5IsNotNull() {
            addCriterion("time5 is not null");
            return (Criteria) this;
        }

        public Criteria andTime5EqualTo(Long value) {
            addCriterion("time5 =", value, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5NotEqualTo(Long value) {
            addCriterion("time5 <>", value, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5GreaterThan(Long value) {
            addCriterion("time5 >", value, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5GreaterThanOrEqualTo(Long value) {
            addCriterion("time5 >=", value, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5LessThan(Long value) {
            addCriterion("time5 <", value, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5LessThanOrEqualTo(Long value) {
            addCriterion("time5 <=", value, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5In(List<Long> values) {
            addCriterion("time5 in", values, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5NotIn(List<Long> values) {
            addCriterion("time5 not in", values, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5Between(Long value1, Long value2) {
            addCriterion("time5 between", value1, value2, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5NotBetween(Long value1, Long value2) {
            addCriterion("time5 not between", value1, value2, "time5");
            return (Criteria) this;
        }

        public Criteria andTime10IsNull() {
            addCriterion("time10 is null");
            return (Criteria) this;
        }

        public Criteria andTime10IsNotNull() {
            addCriterion("time10 is not null");
            return (Criteria) this;
        }

        public Criteria andTime10EqualTo(Long value) {
            addCriterion("time10 =", value, "time10");
            return (Criteria) this;
        }

        public Criteria andTime10NotEqualTo(Long value) {
            addCriterion("time10 <>", value, "time10");
            return (Criteria) this;
        }

        public Criteria andTime10GreaterThan(Long value) {
            addCriterion("time10 >", value, "time10");
            return (Criteria) this;
        }

        public Criteria andTime10GreaterThanOrEqualTo(Long value) {
            addCriterion("time10 >=", value, "time10");
            return (Criteria) this;
        }

        public Criteria andTime10LessThan(Long value) {
            addCriterion("time10 <", value, "time10");
            return (Criteria) this;
        }

        public Criteria andTime10LessThanOrEqualTo(Long value) {
            addCriterion("time10 <=", value, "time10");
            return (Criteria) this;
        }

        public Criteria andTime10In(List<Long> values) {
            addCriterion("time10 in", values, "time10");
            return (Criteria) this;
        }

        public Criteria andTime10NotIn(List<Long> values) {
            addCriterion("time10 not in", values, "time10");
            return (Criteria) this;
        }

        public Criteria andTime10Between(Long value1, Long value2) {
            addCriterion("time10 between", value1, value2, "time10");
            return (Criteria) this;
        }

        public Criteria andTime10NotBetween(Long value1, Long value2) {
            addCriterion("time10 not between", value1, value2, "time10");
            return (Criteria) this;
        }

        public Criteria andTime15IsNull() {
            addCriterion("time15 is null");
            return (Criteria) this;
        }

        public Criteria andTime15IsNotNull() {
            addCriterion("time15 is not null");
            return (Criteria) this;
        }

        public Criteria andTime15EqualTo(Long value) {
            addCriterion("time15 =", value, "time15");
            return (Criteria) this;
        }

        public Criteria andTime15NotEqualTo(Long value) {
            addCriterion("time15 <>", value, "time15");
            return (Criteria) this;
        }

        public Criteria andTime15GreaterThan(Long value) {
            addCriterion("time15 >", value, "time15");
            return (Criteria) this;
        }

        public Criteria andTime15GreaterThanOrEqualTo(Long value) {
            addCriterion("time15 >=", value, "time15");
            return (Criteria) this;
        }

        public Criteria andTime15LessThan(Long value) {
            addCriterion("time15 <", value, "time15");
            return (Criteria) this;
        }

        public Criteria andTime15LessThanOrEqualTo(Long value) {
            addCriterion("time15 <=", value, "time15");
            return (Criteria) this;
        }

        public Criteria andTime15In(List<Long> values) {
            addCriterion("time15 in", values, "time15");
            return (Criteria) this;
        }

        public Criteria andTime15NotIn(List<Long> values) {
            addCriterion("time15 not in", values, "time15");
            return (Criteria) this;
        }

        public Criteria andTime15Between(Long value1, Long value2) {
            addCriterion("time15 between", value1, value2, "time15");
            return (Criteria) this;
        }

        public Criteria andTime15NotBetween(Long value1, Long value2) {
            addCriterion("time15 not between", value1, value2, "time15");
            return (Criteria) this;
        }

        public Criteria andTime20IsNull() {
            addCriterion("time20 is null");
            return (Criteria) this;
        }

        public Criteria andTime20IsNotNull() {
            addCriterion("time20 is not null");
            return (Criteria) this;
        }

        public Criteria andTime20EqualTo(Long value) {
            addCriterion("time20 =", value, "time20");
            return (Criteria) this;
        }

        public Criteria andTime20NotEqualTo(Long value) {
            addCriterion("time20 <>", value, "time20");
            return (Criteria) this;
        }

        public Criteria andTime20GreaterThan(Long value) {
            addCriterion("time20 >", value, "time20");
            return (Criteria) this;
        }

        public Criteria andTime20GreaterThanOrEqualTo(Long value) {
            addCriterion("time20 >=", value, "time20");
            return (Criteria) this;
        }

        public Criteria andTime20LessThan(Long value) {
            addCriterion("time20 <", value, "time20");
            return (Criteria) this;
        }

        public Criteria andTime20LessThanOrEqualTo(Long value) {
            addCriterion("time20 <=", value, "time20");
            return (Criteria) this;
        }

        public Criteria andTime20In(List<Long> values) {
            addCriterion("time20 in", values, "time20");
            return (Criteria) this;
        }

        public Criteria andTime20NotIn(List<Long> values) {
            addCriterion("time20 not in", values, "time20");
            return (Criteria) this;
        }

        public Criteria andTime20Between(Long value1, Long value2) {
            addCriterion("time20 between", value1, value2, "time20");
            return (Criteria) this;
        }

        public Criteria andTime20NotBetween(Long value1, Long value2) {
            addCriterion("time20 not between", value1, value2, "time20");
            return (Criteria) this;
        }

        public Criteria andTime25IsNull() {
            addCriterion("time25 is null");
            return (Criteria) this;
        }

        public Criteria andTime25IsNotNull() {
            addCriterion("time25 is not null");
            return (Criteria) this;
        }

        public Criteria andTime25EqualTo(Long value) {
            addCriterion("time25 =", value, "time25");
            return (Criteria) this;
        }

        public Criteria andTime25NotEqualTo(Long value) {
            addCriterion("time25 <>", value, "time25");
            return (Criteria) this;
        }

        public Criteria andTime25GreaterThan(Long value) {
            addCriterion("time25 >", value, "time25");
            return (Criteria) this;
        }

        public Criteria andTime25GreaterThanOrEqualTo(Long value) {
            addCriterion("time25 >=", value, "time25");
            return (Criteria) this;
        }

        public Criteria andTime25LessThan(Long value) {
            addCriterion("time25 <", value, "time25");
            return (Criteria) this;
        }

        public Criteria andTime25LessThanOrEqualTo(Long value) {
            addCriterion("time25 <=", value, "time25");
            return (Criteria) this;
        }

        public Criteria andTime25In(List<Long> values) {
            addCriterion("time25 in", values, "time25");
            return (Criteria) this;
        }

        public Criteria andTime25NotIn(List<Long> values) {
            addCriterion("time25 not in", values, "time25");
            return (Criteria) this;
        }

        public Criteria andTime25Between(Long value1, Long value2) {
            addCriterion("time25 between", value1, value2, "time25");
            return (Criteria) this;
        }

        public Criteria andTime25NotBetween(Long value1, Long value2) {
            addCriterion("time25 not between", value1, value2, "time25");
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
    }

    /**
     * @Title public.vehicle_queue_analysis表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-14 16:28:28
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @Title public.vehicle_queue_analysis表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-14 16:28:28
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