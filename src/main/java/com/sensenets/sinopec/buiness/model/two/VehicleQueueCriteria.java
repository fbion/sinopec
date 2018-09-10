/**
  * VehicleQueueCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-10
  */
package com.sensenets.sinopec.buiness.model.two;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title public.vehicle_queue表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-09-10 12:48:47
 */
public class VehicleQueueCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     *  构造查询条件:public.vehicle_queue
     */
    public VehicleQueueCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *  设置排序字段:public.vehicle_queue
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *  获取排序字段:public.vehicle_queue
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *  设置过滤重复数据:public.vehicle_queue
     *
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *  是否过滤重复数据:public.vehicle_queue
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *  获取当前的查询条件实例:public.vehicle_queue
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * :public.vehicle_queue
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * :public.vehicle_queue
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *  创建一个查询条件:public.vehicle_queue
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *  内部构建查询条件对象:public.vehicle_queue
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *  清除查询条件:public.vehicle_queue
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
     * @Title public.vehicle_queue表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-10 12:48:47
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

        public Criteria andQueueTimeIsNull() {
            addCriterion("queue_time is null");
            return (Criteria) this;
        }

        public Criteria andQueueTimeIsNotNull() {
            addCriterion("queue_time is not null");
            return (Criteria) this;
        }

        public Criteria andQueueTimeEqualTo(Long value) {
            addCriterion("queue_time =", value, "queueTime");
            return (Criteria) this;
        }

        public Criteria andQueueTimeNotEqualTo(Long value) {
            addCriterion("queue_time <>", value, "queueTime");
            return (Criteria) this;
        }

        public Criteria andQueueTimeGreaterThan(Long value) {
            addCriterion("queue_time >", value, "queueTime");
            return (Criteria) this;
        }

        public Criteria andQueueTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("queue_time >=", value, "queueTime");
            return (Criteria) this;
        }

        public Criteria andQueueTimeLessThan(Long value) {
            addCriterion("queue_time <", value, "queueTime");
            return (Criteria) this;
        }

        public Criteria andQueueTimeLessThanOrEqualTo(Long value) {
            addCriterion("queue_time <=", value, "queueTime");
            return (Criteria) this;
        }

        public Criteria andQueueTimeIn(List<Long> values) {
            addCriterion("queue_time in", values, "queueTime");
            return (Criteria) this;
        }

        public Criteria andQueueTimeNotIn(List<Long> values) {
            addCriterion("queue_time not in", values, "queueTime");
            return (Criteria) this;
        }

        public Criteria andQueueTimeBetween(Long value1, Long value2) {
            addCriterion("queue_time between", value1, value2, "queueTime");
            return (Criteria) this;
        }

        public Criteria andQueueTimeNotBetween(Long value1, Long value2) {
            addCriterion("queue_time not between", value1, value2, "queueTime");
            return (Criteria) this;
        }

        public Criteria andInSensorIdIsNull() {
            addCriterion("in_sensor_id is null");
            return (Criteria) this;
        }

        public Criteria andInSensorIdIsNotNull() {
            addCriterion("in_sensor_id is not null");
            return (Criteria) this;
        }

        public Criteria andInSensorIdEqualTo(Long value) {
            addCriterion("in_sensor_id =", value, "inSensorId");
            return (Criteria) this;
        }

        public Criteria andInSensorIdNotEqualTo(Long value) {
            addCriterion("in_sensor_id <>", value, "inSensorId");
            return (Criteria) this;
        }

        public Criteria andInSensorIdGreaterThan(Long value) {
            addCriterion("in_sensor_id >", value, "inSensorId");
            return (Criteria) this;
        }

        public Criteria andInSensorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("in_sensor_id >=", value, "inSensorId");
            return (Criteria) this;
        }

        public Criteria andInSensorIdLessThan(Long value) {
            addCriterion("in_sensor_id <", value, "inSensorId");
            return (Criteria) this;
        }

        public Criteria andInSensorIdLessThanOrEqualTo(Long value) {
            addCriterion("in_sensor_id <=", value, "inSensorId");
            return (Criteria) this;
        }

        public Criteria andInSensorIdIn(List<Long> values) {
            addCriterion("in_sensor_id in", values, "inSensorId");
            return (Criteria) this;
        }

        public Criteria andInSensorIdNotIn(List<Long> values) {
            addCriterion("in_sensor_id not in", values, "inSensorId");
            return (Criteria) this;
        }

        public Criteria andInSensorIdBetween(Long value1, Long value2) {
            addCriterion("in_sensor_id between", value1, value2, "inSensorId");
            return (Criteria) this;
        }

        public Criteria andInSensorIdNotBetween(Long value1, Long value2) {
            addCriterion("in_sensor_id not between", value1, value2, "inSensorId");
            return (Criteria) this;
        }

        public Criteria andInSensorNameIsNull() {
            addCriterion("in_sensor_name is null");
            return (Criteria) this;
        }

        public Criteria andInSensorNameIsNotNull() {
            addCriterion("in_sensor_name is not null");
            return (Criteria) this;
        }

        public Criteria andInSensorNameEqualTo(String value) {
            addCriterion("in_sensor_name =", value, "inSensorName");
            return (Criteria) this;
        }

        public Criteria andInSensorNameNotEqualTo(String value) {
            addCriterion("in_sensor_name <>", value, "inSensorName");
            return (Criteria) this;
        }

        public Criteria andInSensorNameGreaterThan(String value) {
            addCriterion("in_sensor_name >", value, "inSensorName");
            return (Criteria) this;
        }

        public Criteria andInSensorNameGreaterThanOrEqualTo(String value) {
            addCriterion("in_sensor_name >=", value, "inSensorName");
            return (Criteria) this;
        }

        public Criteria andInSensorNameLessThan(String value) {
            addCriterion("in_sensor_name <", value, "inSensorName");
            return (Criteria) this;
        }

        public Criteria andInSensorNameLessThanOrEqualTo(String value) {
            addCriterion("in_sensor_name <=", value, "inSensorName");
            return (Criteria) this;
        }

        public Criteria andInSensorNameLike(String value) {
            addCriterion("in_sensor_name like", value, "inSensorName");
            return (Criteria) this;
        }

        public Criteria andInSensorNameNotLike(String value) {
            addCriterion("in_sensor_name not like", value, "inSensorName");
            return (Criteria) this;
        }

        public Criteria andInSensorNameIn(List<String> values) {
            addCriterion("in_sensor_name in", values, "inSensorName");
            return (Criteria) this;
        }

        public Criteria andInSensorNameNotIn(List<String> values) {
            addCriterion("in_sensor_name not in", values, "inSensorName");
            return (Criteria) this;
        }

        public Criteria andInSensorNameBetween(String value1, String value2) {
            addCriterion("in_sensor_name between", value1, value2, "inSensorName");
            return (Criteria) this;
        }

        public Criteria andInSensorNameNotBetween(String value1, String value2) {
            addCriterion("in_sensor_name not between", value1, value2, "inSensorName");
            return (Criteria) this;
        }

        public Criteria andInImageIdIsNull() {
            addCriterion("in_image_id is null");
            return (Criteria) this;
        }

        public Criteria andInImageIdIsNotNull() {
            addCriterion("in_image_id is not null");
            return (Criteria) this;
        }

        public Criteria andInImageIdEqualTo(String value) {
            addCriterion("in_image_id =", value, "inImageId");
            return (Criteria) this;
        }

        public Criteria andInImageIdNotEqualTo(String value) {
            addCriterion("in_image_id <>", value, "inImageId");
            return (Criteria) this;
        }

        public Criteria andInImageIdGreaterThan(String value) {
            addCriterion("in_image_id >", value, "inImageId");
            return (Criteria) this;
        }

        public Criteria andInImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("in_image_id >=", value, "inImageId");
            return (Criteria) this;
        }

        public Criteria andInImageIdLessThan(String value) {
            addCriterion("in_image_id <", value, "inImageId");
            return (Criteria) this;
        }

        public Criteria andInImageIdLessThanOrEqualTo(String value) {
            addCriterion("in_image_id <=", value, "inImageId");
            return (Criteria) this;
        }

        public Criteria andInImageIdLike(String value) {
            addCriterion("in_image_id like", value, "inImageId");
            return (Criteria) this;
        }

        public Criteria andInImageIdNotLike(String value) {
            addCriterion("in_image_id not like", value, "inImageId");
            return (Criteria) this;
        }

        public Criteria andInImageIdIn(List<String> values) {
            addCriterion("in_image_id in", values, "inImageId");
            return (Criteria) this;
        }

        public Criteria andInImageIdNotIn(List<String> values) {
            addCriterion("in_image_id not in", values, "inImageId");
            return (Criteria) this;
        }

        public Criteria andInImageIdBetween(String value1, String value2) {
            addCriterion("in_image_id between", value1, value2, "inImageId");
            return (Criteria) this;
        }

        public Criteria andInImageIdNotBetween(String value1, String value2) {
            addCriterion("in_image_id not between", value1, value2, "inImageId");
            return (Criteria) this;
        }

        public Criteria andInSourceImageIsNull() {
            addCriterion("in_source_image is null");
            return (Criteria) this;
        }

        public Criteria andInSourceImageIsNotNull() {
            addCriterion("in_source_image is not null");
            return (Criteria) this;
        }

        public Criteria andInSourceImageEqualTo(String value) {
            addCriterion("in_source_image =", value, "inSourceImage");
            return (Criteria) this;
        }

        public Criteria andInSourceImageNotEqualTo(String value) {
            addCriterion("in_source_image <>", value, "inSourceImage");
            return (Criteria) this;
        }

        public Criteria andInSourceImageGreaterThan(String value) {
            addCriterion("in_source_image >", value, "inSourceImage");
            return (Criteria) this;
        }

        public Criteria andInSourceImageGreaterThanOrEqualTo(String value) {
            addCriterion("in_source_image >=", value, "inSourceImage");
            return (Criteria) this;
        }

        public Criteria andInSourceImageLessThan(String value) {
            addCriterion("in_source_image <", value, "inSourceImage");
            return (Criteria) this;
        }

        public Criteria andInSourceImageLessThanOrEqualTo(String value) {
            addCriterion("in_source_image <=", value, "inSourceImage");
            return (Criteria) this;
        }

        public Criteria andInSourceImageLike(String value) {
            addCriterion("in_source_image like", value, "inSourceImage");
            return (Criteria) this;
        }

        public Criteria andInSourceImageNotLike(String value) {
            addCriterion("in_source_image not like", value, "inSourceImage");
            return (Criteria) this;
        }

        public Criteria andInSourceImageIn(List<String> values) {
            addCriterion("in_source_image in", values, "inSourceImage");
            return (Criteria) this;
        }

        public Criteria andInSourceImageNotIn(List<String> values) {
            addCriterion("in_source_image not in", values, "inSourceImage");
            return (Criteria) this;
        }

        public Criteria andInSourceImageBetween(String value1, String value2) {
            addCriterion("in_source_image between", value1, value2, "inSourceImage");
            return (Criteria) this;
        }

        public Criteria andInSourceImageNotBetween(String value1, String value2) {
            addCriterion("in_source_image not between", value1, value2, "inSourceImage");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageIsNull() {
            addCriterion("in_feature_image is null");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageIsNotNull() {
            addCriterion("in_feature_image is not null");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageEqualTo(String value) {
            addCriterion("in_feature_image =", value, "inFeatureImage");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageNotEqualTo(String value) {
            addCriterion("in_feature_image <>", value, "inFeatureImage");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageGreaterThan(String value) {
            addCriterion("in_feature_image >", value, "inFeatureImage");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageGreaterThanOrEqualTo(String value) {
            addCriterion("in_feature_image >=", value, "inFeatureImage");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageLessThan(String value) {
            addCriterion("in_feature_image <", value, "inFeatureImage");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageLessThanOrEqualTo(String value) {
            addCriterion("in_feature_image <=", value, "inFeatureImage");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageLike(String value) {
            addCriterion("in_feature_image like", value, "inFeatureImage");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageNotLike(String value) {
            addCriterion("in_feature_image not like", value, "inFeatureImage");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageIn(List<String> values) {
            addCriterion("in_feature_image in", values, "inFeatureImage");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageNotIn(List<String> values) {
            addCriterion("in_feature_image not in", values, "inFeatureImage");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageBetween(String value1, String value2) {
            addCriterion("in_feature_image between", value1, value2, "inFeatureImage");
            return (Criteria) this;
        }

        public Criteria andInFeatureImageNotBetween(String value1, String value2) {
            addCriterion("in_feature_image not between", value1, value2, "inFeatureImage");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(Date value) {
            addCriterion("in_time =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(Date value) {
            addCriterion("in_time <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(Date value) {
            addCriterion("in_time >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("in_time >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(Date value) {
            addCriterion("in_time <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(Date value) {
            addCriterion("in_time <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(List<Date> values) {
            addCriterion("in_time in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(List<Date> values) {
            addCriterion("in_time not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(Date value1, Date value2) {
            addCriterion("in_time between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(Date value1, Date value2) {
            addCriterion("in_time not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andOutSensorIdIsNull() {
            addCriterion("out_sensor_id is null");
            return (Criteria) this;
        }

        public Criteria andOutSensorIdIsNotNull() {
            addCriterion("out_sensor_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutSensorIdEqualTo(Long value) {
            addCriterion("out_sensor_id =", value, "outSensorId");
            return (Criteria) this;
        }

        public Criteria andOutSensorIdNotEqualTo(Long value) {
            addCriterion("out_sensor_id <>", value, "outSensorId");
            return (Criteria) this;
        }

        public Criteria andOutSensorIdGreaterThan(Long value) {
            addCriterion("out_sensor_id >", value, "outSensorId");
            return (Criteria) this;
        }

        public Criteria andOutSensorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("out_sensor_id >=", value, "outSensorId");
            return (Criteria) this;
        }

        public Criteria andOutSensorIdLessThan(Long value) {
            addCriterion("out_sensor_id <", value, "outSensorId");
            return (Criteria) this;
        }

        public Criteria andOutSensorIdLessThanOrEqualTo(Long value) {
            addCriterion("out_sensor_id <=", value, "outSensorId");
            return (Criteria) this;
        }

        public Criteria andOutSensorIdIn(List<Long> values) {
            addCriterion("out_sensor_id in", values, "outSensorId");
            return (Criteria) this;
        }

        public Criteria andOutSensorIdNotIn(List<Long> values) {
            addCriterion("out_sensor_id not in", values, "outSensorId");
            return (Criteria) this;
        }

        public Criteria andOutSensorIdBetween(Long value1, Long value2) {
            addCriterion("out_sensor_id between", value1, value2, "outSensorId");
            return (Criteria) this;
        }

        public Criteria andOutSensorIdNotBetween(Long value1, Long value2) {
            addCriterion("out_sensor_id not between", value1, value2, "outSensorId");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameIsNull() {
            addCriterion("out_sensor_name is null");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameIsNotNull() {
            addCriterion("out_sensor_name is not null");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameEqualTo(String value) {
            addCriterion("out_sensor_name =", value, "outSensorName");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameNotEqualTo(String value) {
            addCriterion("out_sensor_name <>", value, "outSensorName");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameGreaterThan(String value) {
            addCriterion("out_sensor_name >", value, "outSensorName");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameGreaterThanOrEqualTo(String value) {
            addCriterion("out_sensor_name >=", value, "outSensorName");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameLessThan(String value) {
            addCriterion("out_sensor_name <", value, "outSensorName");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameLessThanOrEqualTo(String value) {
            addCriterion("out_sensor_name <=", value, "outSensorName");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameLike(String value) {
            addCriterion("out_sensor_name like", value, "outSensorName");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameNotLike(String value) {
            addCriterion("out_sensor_name not like", value, "outSensorName");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameIn(List<String> values) {
            addCriterion("out_sensor_name in", values, "outSensorName");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameNotIn(List<String> values) {
            addCriterion("out_sensor_name not in", values, "outSensorName");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameBetween(String value1, String value2) {
            addCriterion("out_sensor_name between", value1, value2, "outSensorName");
            return (Criteria) this;
        }

        public Criteria andOutSensorNameNotBetween(String value1, String value2) {
            addCriterion("out_sensor_name not between", value1, value2, "outSensorName");
            return (Criteria) this;
        }

        public Criteria andOutImageIdIsNull() {
            addCriterion("out_image_id is null");
            return (Criteria) this;
        }

        public Criteria andOutImageIdIsNotNull() {
            addCriterion("out_image_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutImageIdEqualTo(String value) {
            addCriterion("out_image_id =", value, "outImageId");
            return (Criteria) this;
        }

        public Criteria andOutImageIdNotEqualTo(String value) {
            addCriterion("out_image_id <>", value, "outImageId");
            return (Criteria) this;
        }

        public Criteria andOutImageIdGreaterThan(String value) {
            addCriterion("out_image_id >", value, "outImageId");
            return (Criteria) this;
        }

        public Criteria andOutImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("out_image_id >=", value, "outImageId");
            return (Criteria) this;
        }

        public Criteria andOutImageIdLessThan(String value) {
            addCriterion("out_image_id <", value, "outImageId");
            return (Criteria) this;
        }

        public Criteria andOutImageIdLessThanOrEqualTo(String value) {
            addCriterion("out_image_id <=", value, "outImageId");
            return (Criteria) this;
        }

        public Criteria andOutImageIdLike(String value) {
            addCriterion("out_image_id like", value, "outImageId");
            return (Criteria) this;
        }

        public Criteria andOutImageIdNotLike(String value) {
            addCriterion("out_image_id not like", value, "outImageId");
            return (Criteria) this;
        }

        public Criteria andOutImageIdIn(List<String> values) {
            addCriterion("out_image_id in", values, "outImageId");
            return (Criteria) this;
        }

        public Criteria andOutImageIdNotIn(List<String> values) {
            addCriterion("out_image_id not in", values, "outImageId");
            return (Criteria) this;
        }

        public Criteria andOutImageIdBetween(String value1, String value2) {
            addCriterion("out_image_id between", value1, value2, "outImageId");
            return (Criteria) this;
        }

        public Criteria andOutImageIdNotBetween(String value1, String value2) {
            addCriterion("out_image_id not between", value1, value2, "outImageId");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageIsNull() {
            addCriterion("out_source_image is null");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageIsNotNull() {
            addCriterion("out_source_image is not null");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageEqualTo(String value) {
            addCriterion("out_source_image =", value, "outSourceImage");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageNotEqualTo(String value) {
            addCriterion("out_source_image <>", value, "outSourceImage");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageGreaterThan(String value) {
            addCriterion("out_source_image >", value, "outSourceImage");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageGreaterThanOrEqualTo(String value) {
            addCriterion("out_source_image >=", value, "outSourceImage");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageLessThan(String value) {
            addCriterion("out_source_image <", value, "outSourceImage");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageLessThanOrEqualTo(String value) {
            addCriterion("out_source_image <=", value, "outSourceImage");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageLike(String value) {
            addCriterion("out_source_image like", value, "outSourceImage");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageNotLike(String value) {
            addCriterion("out_source_image not like", value, "outSourceImage");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageIn(List<String> values) {
            addCriterion("out_source_image in", values, "outSourceImage");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageNotIn(List<String> values) {
            addCriterion("out_source_image not in", values, "outSourceImage");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageBetween(String value1, String value2) {
            addCriterion("out_source_image between", value1, value2, "outSourceImage");
            return (Criteria) this;
        }

        public Criteria andOutSourceImageNotBetween(String value1, String value2) {
            addCriterion("out_source_image not between", value1, value2, "outSourceImage");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageIsNull() {
            addCriterion("out_feature_image is null");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageIsNotNull() {
            addCriterion("out_feature_image is not null");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageEqualTo(String value) {
            addCriterion("out_feature_image =", value, "outFeatureImage");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageNotEqualTo(String value) {
            addCriterion("out_feature_image <>", value, "outFeatureImage");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageGreaterThan(String value) {
            addCriterion("out_feature_image >", value, "outFeatureImage");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageGreaterThanOrEqualTo(String value) {
            addCriterion("out_feature_image >=", value, "outFeatureImage");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageLessThan(String value) {
            addCriterion("out_feature_image <", value, "outFeatureImage");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageLessThanOrEqualTo(String value) {
            addCriterion("out_feature_image <=", value, "outFeatureImage");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageLike(String value) {
            addCriterion("out_feature_image like", value, "outFeatureImage");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageNotLike(String value) {
            addCriterion("out_feature_image not like", value, "outFeatureImage");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageIn(List<String> values) {
            addCriterion("out_feature_image in", values, "outFeatureImage");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageNotIn(List<String> values) {
            addCriterion("out_feature_image not in", values, "outFeatureImage");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageBetween(String value1, String value2) {
            addCriterion("out_feature_image between", value1, value2, "outFeatureImage");
            return (Criteria) this;
        }

        public Criteria andOutFeatureImageNotBetween(String value1, String value2) {
            addCriterion("out_feature_image not between", value1, value2, "outFeatureImage");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeEqualTo(Date value) {
            addCriterion("out_time =", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotEqualTo(Date value) {
            addCriterion("out_time <>", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThan(Date value) {
            addCriterion("out_time >", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("out_time >=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThan(Date value) {
            addCriterion("out_time <", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThanOrEqualTo(Date value) {
            addCriterion("out_time <=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIn(List<Date> values) {
            addCriterion("out_time in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotIn(List<Date> values) {
            addCriterion("out_time not in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeBetween(Date value1, Date value2) {
            addCriterion("out_time between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotBetween(Date value1, Date value2) {
            addCriterion("out_time not between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andInBrandIdIsNull() {
            addCriterion("in_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andInBrandIdIsNotNull() {
            addCriterion("in_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andInBrandIdEqualTo(Short value) {
            addCriterion("in_brand_id =", value, "inBrandId");
            return (Criteria) this;
        }

        public Criteria andInBrandIdNotEqualTo(Short value) {
            addCriterion("in_brand_id <>", value, "inBrandId");
            return (Criteria) this;
        }

        public Criteria andInBrandIdGreaterThan(Short value) {
            addCriterion("in_brand_id >", value, "inBrandId");
            return (Criteria) this;
        }

        public Criteria andInBrandIdGreaterThanOrEqualTo(Short value) {
            addCriterion("in_brand_id >=", value, "inBrandId");
            return (Criteria) this;
        }

        public Criteria andInBrandIdLessThan(Short value) {
            addCriterion("in_brand_id <", value, "inBrandId");
            return (Criteria) this;
        }

        public Criteria andInBrandIdLessThanOrEqualTo(Short value) {
            addCriterion("in_brand_id <=", value, "inBrandId");
            return (Criteria) this;
        }

        public Criteria andInBrandIdIn(List<Short> values) {
            addCriterion("in_brand_id in", values, "inBrandId");
            return (Criteria) this;
        }

        public Criteria andInBrandIdNotIn(List<Short> values) {
            addCriterion("in_brand_id not in", values, "inBrandId");
            return (Criteria) this;
        }

        public Criteria andInBrandIdBetween(Short value1, Short value2) {
            addCriterion("in_brand_id between", value1, value2, "inBrandId");
            return (Criteria) this;
        }

        public Criteria andInBrandIdNotBetween(Short value1, Short value2) {
            addCriterion("in_brand_id not between", value1, value2, "inBrandId");
            return (Criteria) this;
        }

        public Criteria andInPlateColorIdIsNull() {
            addCriterion("in_plate_color_id is null");
            return (Criteria) this;
        }

        public Criteria andInPlateColorIdIsNotNull() {
            addCriterion("in_plate_color_id is not null");
            return (Criteria) this;
        }

        public Criteria andInPlateColorIdEqualTo(Short value) {
            addCriterion("in_plate_color_id =", value, "inPlateColorId");
            return (Criteria) this;
        }

        public Criteria andInPlateColorIdNotEqualTo(Short value) {
            addCriterion("in_plate_color_id <>", value, "inPlateColorId");
            return (Criteria) this;
        }

        public Criteria andInPlateColorIdGreaterThan(Short value) {
            addCriterion("in_plate_color_id >", value, "inPlateColorId");
            return (Criteria) this;
        }

        public Criteria andInPlateColorIdGreaterThanOrEqualTo(Short value) {
            addCriterion("in_plate_color_id >=", value, "inPlateColorId");
            return (Criteria) this;
        }

        public Criteria andInPlateColorIdLessThan(Short value) {
            addCriterion("in_plate_color_id <", value, "inPlateColorId");
            return (Criteria) this;
        }

        public Criteria andInPlateColorIdLessThanOrEqualTo(Short value) {
            addCriterion("in_plate_color_id <=", value, "inPlateColorId");
            return (Criteria) this;
        }

        public Criteria andInPlateColorIdIn(List<Short> values) {
            addCriterion("in_plate_color_id in", values, "inPlateColorId");
            return (Criteria) this;
        }

        public Criteria andInPlateColorIdNotIn(List<Short> values) {
            addCriterion("in_plate_color_id not in", values, "inPlateColorId");
            return (Criteria) this;
        }

        public Criteria andInPlateColorIdBetween(Short value1, Short value2) {
            addCriterion("in_plate_color_id between", value1, value2, "inPlateColorId");
            return (Criteria) this;
        }

        public Criteria andInPlateColorIdNotBetween(Short value1, Short value2) {
            addCriterion("in_plate_color_id not between", value1, value2, "inPlateColorId");
            return (Criteria) this;
        }

        public Criteria andInPlateTypeIdIsNull() {
            addCriterion("in_plate_type_id is null");
            return (Criteria) this;
        }

        public Criteria andInPlateTypeIdIsNotNull() {
            addCriterion("in_plate_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andInPlateTypeIdEqualTo(Short value) {
            addCriterion("in_plate_type_id =", value, "inPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andInPlateTypeIdNotEqualTo(Short value) {
            addCriterion("in_plate_type_id <>", value, "inPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andInPlateTypeIdGreaterThan(Short value) {
            addCriterion("in_plate_type_id >", value, "inPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andInPlateTypeIdGreaterThanOrEqualTo(Short value) {
            addCriterion("in_plate_type_id >=", value, "inPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andInPlateTypeIdLessThan(Short value) {
            addCriterion("in_plate_type_id <", value, "inPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andInPlateTypeIdLessThanOrEqualTo(Short value) {
            addCriterion("in_plate_type_id <=", value, "inPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andInPlateTypeIdIn(List<Short> values) {
            addCriterion("in_plate_type_id in", values, "inPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andInPlateTypeIdNotIn(List<Short> values) {
            addCriterion("in_plate_type_id not in", values, "inPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andInPlateTypeIdBetween(Short value1, Short value2) {
            addCriterion("in_plate_type_id between", value1, value2, "inPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andInPlateTypeIdNotBetween(Short value1, Short value2) {
            addCriterion("in_plate_type_id not between", value1, value2, "inPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andInAngleIdIsNull() {
            addCriterion("in_angle_id is null");
            return (Criteria) this;
        }

        public Criteria andInAngleIdIsNotNull() {
            addCriterion("in_angle_id is not null");
            return (Criteria) this;
        }

        public Criteria andInAngleIdEqualTo(Short value) {
            addCriterion("in_angle_id =", value, "inAngleId");
            return (Criteria) this;
        }

        public Criteria andInAngleIdNotEqualTo(Short value) {
            addCriterion("in_angle_id <>", value, "inAngleId");
            return (Criteria) this;
        }

        public Criteria andInAngleIdGreaterThan(Short value) {
            addCriterion("in_angle_id >", value, "inAngleId");
            return (Criteria) this;
        }

        public Criteria andInAngleIdGreaterThanOrEqualTo(Short value) {
            addCriterion("in_angle_id >=", value, "inAngleId");
            return (Criteria) this;
        }

        public Criteria andInAngleIdLessThan(Short value) {
            addCriterion("in_angle_id <", value, "inAngleId");
            return (Criteria) this;
        }

        public Criteria andInAngleIdLessThanOrEqualTo(Short value) {
            addCriterion("in_angle_id <=", value, "inAngleId");
            return (Criteria) this;
        }

        public Criteria andInAngleIdIn(List<Short> values) {
            addCriterion("in_angle_id in", values, "inAngleId");
            return (Criteria) this;
        }

        public Criteria andInAngleIdNotIn(List<Short> values) {
            addCriterion("in_angle_id not in", values, "inAngleId");
            return (Criteria) this;
        }

        public Criteria andInAngleIdBetween(Short value1, Short value2) {
            addCriterion("in_angle_id between", value1, value2, "inAngleId");
            return (Criteria) this;
        }

        public Criteria andInAngleIdNotBetween(Short value1, Short value2) {
            addCriterion("in_angle_id not between", value1, value2, "inAngleId");
            return (Criteria) this;
        }

        public Criteria andInColorIdIsNull() {
            addCriterion("in_color_id is null");
            return (Criteria) this;
        }

        public Criteria andInColorIdIsNotNull() {
            addCriterion("in_color_id is not null");
            return (Criteria) this;
        }

        public Criteria andInColorIdEqualTo(Short value) {
            addCriterion("in_color_id =", value, "inColorId");
            return (Criteria) this;
        }

        public Criteria andInColorIdNotEqualTo(Short value) {
            addCriterion("in_color_id <>", value, "inColorId");
            return (Criteria) this;
        }

        public Criteria andInColorIdGreaterThan(Short value) {
            addCriterion("in_color_id >", value, "inColorId");
            return (Criteria) this;
        }

        public Criteria andInColorIdGreaterThanOrEqualTo(Short value) {
            addCriterion("in_color_id >=", value, "inColorId");
            return (Criteria) this;
        }

        public Criteria andInColorIdLessThan(Short value) {
            addCriterion("in_color_id <", value, "inColorId");
            return (Criteria) this;
        }

        public Criteria andInColorIdLessThanOrEqualTo(Short value) {
            addCriterion("in_color_id <=", value, "inColorId");
            return (Criteria) this;
        }

        public Criteria andInColorIdIn(List<Short> values) {
            addCriterion("in_color_id in", values, "inColorId");
            return (Criteria) this;
        }

        public Criteria andInColorIdNotIn(List<Short> values) {
            addCriterion("in_color_id not in", values, "inColorId");
            return (Criteria) this;
        }

        public Criteria andInColorIdBetween(Short value1, Short value2) {
            addCriterion("in_color_id between", value1, value2, "inColorId");
            return (Criteria) this;
        }

        public Criteria andInColorIdNotBetween(Short value1, Short value2) {
            addCriterion("in_color_id not between", value1, value2, "inColorId");
            return (Criteria) this;
        }

        public Criteria andInTypeIdIsNull() {
            addCriterion("in_type_id is null");
            return (Criteria) this;
        }

        public Criteria andInTypeIdIsNotNull() {
            addCriterion("in_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andInTypeIdEqualTo(Short value) {
            addCriterion("in_type_id =", value, "inTypeId");
            return (Criteria) this;
        }

        public Criteria andInTypeIdNotEqualTo(Short value) {
            addCriterion("in_type_id <>", value, "inTypeId");
            return (Criteria) this;
        }

        public Criteria andInTypeIdGreaterThan(Short value) {
            addCriterion("in_type_id >", value, "inTypeId");
            return (Criteria) this;
        }

        public Criteria andInTypeIdGreaterThanOrEqualTo(Short value) {
            addCriterion("in_type_id >=", value, "inTypeId");
            return (Criteria) this;
        }

        public Criteria andInTypeIdLessThan(Short value) {
            addCriterion("in_type_id <", value, "inTypeId");
            return (Criteria) this;
        }

        public Criteria andInTypeIdLessThanOrEqualTo(Short value) {
            addCriterion("in_type_id <=", value, "inTypeId");
            return (Criteria) this;
        }

        public Criteria andInTypeIdIn(List<Short> values) {
            addCriterion("in_type_id in", values, "inTypeId");
            return (Criteria) this;
        }

        public Criteria andInTypeIdNotIn(List<Short> values) {
            addCriterion("in_type_id not in", values, "inTypeId");
            return (Criteria) this;
        }

        public Criteria andInTypeIdBetween(Short value1, Short value2) {
            addCriterion("in_type_id between", value1, value2, "inTypeId");
            return (Criteria) this;
        }

        public Criteria andInTypeIdNotBetween(Short value1, Short value2) {
            addCriterion("in_type_id not between", value1, value2, "inTypeId");
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

        public Criteria andReposIdEqualTo(Long value) {
            addCriterion("repos_id =", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdNotEqualTo(Long value) {
            addCriterion("repos_id <>", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdGreaterThan(Long value) {
            addCriterion("repos_id >", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdGreaterThanOrEqualTo(Long value) {
            addCriterion("repos_id >=", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdLessThan(Long value) {
            addCriterion("repos_id <", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdLessThanOrEqualTo(Long value) {
            addCriterion("repos_id <=", value, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdIn(List<Long> values) {
            addCriterion("repos_id in", values, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdNotIn(List<Long> values) {
            addCriterion("repos_id not in", values, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdBetween(Long value1, Long value2) {
            addCriterion("repos_id between", value1, value2, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposIdNotBetween(Long value1, Long value2) {
            addCriterion("repos_id not between", value1, value2, "reposId");
            return (Criteria) this;
        }

        public Criteria andReposNameIsNull() {
            addCriterion("repos_name is null");
            return (Criteria) this;
        }

        public Criteria andReposNameIsNotNull() {
            addCriterion("repos_name is not null");
            return (Criteria) this;
        }

        public Criteria andReposNameEqualTo(String value) {
            addCriterion("repos_name =", value, "reposName");
            return (Criteria) this;
        }

        public Criteria andReposNameNotEqualTo(String value) {
            addCriterion("repos_name <>", value, "reposName");
            return (Criteria) this;
        }

        public Criteria andReposNameGreaterThan(String value) {
            addCriterion("repos_name >", value, "reposName");
            return (Criteria) this;
        }

        public Criteria andReposNameGreaterThanOrEqualTo(String value) {
            addCriterion("repos_name >=", value, "reposName");
            return (Criteria) this;
        }

        public Criteria andReposNameLessThan(String value) {
            addCriterion("repos_name <", value, "reposName");
            return (Criteria) this;
        }

        public Criteria andReposNameLessThanOrEqualTo(String value) {
            addCriterion("repos_name <=", value, "reposName");
            return (Criteria) this;
        }

        public Criteria andReposNameLike(String value) {
            addCriterion("repos_name like", value, "reposName");
            return (Criteria) this;
        }

        public Criteria andReposNameNotLike(String value) {
            addCriterion("repos_name not like", value, "reposName");
            return (Criteria) this;
        }

        public Criteria andReposNameIn(List<String> values) {
            addCriterion("repos_name in", values, "reposName");
            return (Criteria) this;
        }

        public Criteria andReposNameNotIn(List<String> values) {
            addCriterion("repos_name not in", values, "reposName");
            return (Criteria) this;
        }

        public Criteria andReposNameBetween(String value1, String value2) {
            addCriterion("repos_name between", value1, value2, "reposName");
            return (Criteria) this;
        }

        public Criteria andReposNameNotBetween(String value1, String value2) {
            addCriterion("repos_name not between", value1, value2, "reposName");
            return (Criteria) this;
        }

        public Criteria andOutBrandIdIsNull() {
            addCriterion("out_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andOutBrandIdIsNotNull() {
            addCriterion("out_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutBrandIdEqualTo(Short value) {
            addCriterion("out_brand_id =", value, "outBrandId");
            return (Criteria) this;
        }

        public Criteria andOutBrandIdNotEqualTo(Short value) {
            addCriterion("out_brand_id <>", value, "outBrandId");
            return (Criteria) this;
        }

        public Criteria andOutBrandIdGreaterThan(Short value) {
            addCriterion("out_brand_id >", value, "outBrandId");
            return (Criteria) this;
        }

        public Criteria andOutBrandIdGreaterThanOrEqualTo(Short value) {
            addCriterion("out_brand_id >=", value, "outBrandId");
            return (Criteria) this;
        }

        public Criteria andOutBrandIdLessThan(Short value) {
            addCriterion("out_brand_id <", value, "outBrandId");
            return (Criteria) this;
        }

        public Criteria andOutBrandIdLessThanOrEqualTo(Short value) {
            addCriterion("out_brand_id <=", value, "outBrandId");
            return (Criteria) this;
        }

        public Criteria andOutBrandIdIn(List<Short> values) {
            addCriterion("out_brand_id in", values, "outBrandId");
            return (Criteria) this;
        }

        public Criteria andOutBrandIdNotIn(List<Short> values) {
            addCriterion("out_brand_id not in", values, "outBrandId");
            return (Criteria) this;
        }

        public Criteria andOutBrandIdBetween(Short value1, Short value2) {
            addCriterion("out_brand_id between", value1, value2, "outBrandId");
            return (Criteria) this;
        }

        public Criteria andOutBrandIdNotBetween(Short value1, Short value2) {
            addCriterion("out_brand_id not between", value1, value2, "outBrandId");
            return (Criteria) this;
        }

        public Criteria andOutPlateColorIdIsNull() {
            addCriterion("out_plate_color_id is null");
            return (Criteria) this;
        }

        public Criteria andOutPlateColorIdIsNotNull() {
            addCriterion("out_plate_color_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutPlateColorIdEqualTo(Short value) {
            addCriterion("out_plate_color_id =", value, "outPlateColorId");
            return (Criteria) this;
        }

        public Criteria andOutPlateColorIdNotEqualTo(Short value) {
            addCriterion("out_plate_color_id <>", value, "outPlateColorId");
            return (Criteria) this;
        }

        public Criteria andOutPlateColorIdGreaterThan(Short value) {
            addCriterion("out_plate_color_id >", value, "outPlateColorId");
            return (Criteria) this;
        }

        public Criteria andOutPlateColorIdGreaterThanOrEqualTo(Short value) {
            addCriterion("out_plate_color_id >=", value, "outPlateColorId");
            return (Criteria) this;
        }

        public Criteria andOutPlateColorIdLessThan(Short value) {
            addCriterion("out_plate_color_id <", value, "outPlateColorId");
            return (Criteria) this;
        }

        public Criteria andOutPlateColorIdLessThanOrEqualTo(Short value) {
            addCriterion("out_plate_color_id <=", value, "outPlateColorId");
            return (Criteria) this;
        }

        public Criteria andOutPlateColorIdIn(List<Short> values) {
            addCriterion("out_plate_color_id in", values, "outPlateColorId");
            return (Criteria) this;
        }

        public Criteria andOutPlateColorIdNotIn(List<Short> values) {
            addCriterion("out_plate_color_id not in", values, "outPlateColorId");
            return (Criteria) this;
        }

        public Criteria andOutPlateColorIdBetween(Short value1, Short value2) {
            addCriterion("out_plate_color_id between", value1, value2, "outPlateColorId");
            return (Criteria) this;
        }

        public Criteria andOutPlateColorIdNotBetween(Short value1, Short value2) {
            addCriterion("out_plate_color_id not between", value1, value2, "outPlateColorId");
            return (Criteria) this;
        }

        public Criteria andOutPlateTypeIdIsNull() {
            addCriterion("out_plate_type_id is null");
            return (Criteria) this;
        }

        public Criteria andOutPlateTypeIdIsNotNull() {
            addCriterion("out_plate_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutPlateTypeIdEqualTo(Short value) {
            addCriterion("out_plate_type_id =", value, "outPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andOutPlateTypeIdNotEqualTo(Short value) {
            addCriterion("out_plate_type_id <>", value, "outPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andOutPlateTypeIdGreaterThan(Short value) {
            addCriterion("out_plate_type_id >", value, "outPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andOutPlateTypeIdGreaterThanOrEqualTo(Short value) {
            addCriterion("out_plate_type_id >=", value, "outPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andOutPlateTypeIdLessThan(Short value) {
            addCriterion("out_plate_type_id <", value, "outPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andOutPlateTypeIdLessThanOrEqualTo(Short value) {
            addCriterion("out_plate_type_id <=", value, "outPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andOutPlateTypeIdIn(List<Short> values) {
            addCriterion("out_plate_type_id in", values, "outPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andOutPlateTypeIdNotIn(List<Short> values) {
            addCriterion("out_plate_type_id not in", values, "outPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andOutPlateTypeIdBetween(Short value1, Short value2) {
            addCriterion("out_plate_type_id between", value1, value2, "outPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andOutPlateTypeIdNotBetween(Short value1, Short value2) {
            addCriterion("out_plate_type_id not between", value1, value2, "outPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andOutAngleIdIsNull() {
            addCriterion("out_angle_id is null");
            return (Criteria) this;
        }

        public Criteria andOutAngleIdIsNotNull() {
            addCriterion("out_angle_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutAngleIdEqualTo(Short value) {
            addCriterion("out_angle_id =", value, "outAngleId");
            return (Criteria) this;
        }

        public Criteria andOutAngleIdNotEqualTo(Short value) {
            addCriterion("out_angle_id <>", value, "outAngleId");
            return (Criteria) this;
        }

        public Criteria andOutAngleIdGreaterThan(Short value) {
            addCriterion("out_angle_id >", value, "outAngleId");
            return (Criteria) this;
        }

        public Criteria andOutAngleIdGreaterThanOrEqualTo(Short value) {
            addCriterion("out_angle_id >=", value, "outAngleId");
            return (Criteria) this;
        }

        public Criteria andOutAngleIdLessThan(Short value) {
            addCriterion("out_angle_id <", value, "outAngleId");
            return (Criteria) this;
        }

        public Criteria andOutAngleIdLessThanOrEqualTo(Short value) {
            addCriterion("out_angle_id <=", value, "outAngleId");
            return (Criteria) this;
        }

        public Criteria andOutAngleIdIn(List<Short> values) {
            addCriterion("out_angle_id in", values, "outAngleId");
            return (Criteria) this;
        }

        public Criteria andOutAngleIdNotIn(List<Short> values) {
            addCriterion("out_angle_id not in", values, "outAngleId");
            return (Criteria) this;
        }

        public Criteria andOutAngleIdBetween(Short value1, Short value2) {
            addCriterion("out_angle_id between", value1, value2, "outAngleId");
            return (Criteria) this;
        }

        public Criteria andOutAngleIdNotBetween(Short value1, Short value2) {
            addCriterion("out_angle_id not between", value1, value2, "outAngleId");
            return (Criteria) this;
        }

        public Criteria andOutColorIdIsNull() {
            addCriterion("out_color_id is null");
            return (Criteria) this;
        }

        public Criteria andOutColorIdIsNotNull() {
            addCriterion("out_color_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutColorIdEqualTo(Short value) {
            addCriterion("out_color_id =", value, "outColorId");
            return (Criteria) this;
        }

        public Criteria andOutColorIdNotEqualTo(Short value) {
            addCriterion("out_color_id <>", value, "outColorId");
            return (Criteria) this;
        }

        public Criteria andOutColorIdGreaterThan(Short value) {
            addCriterion("out_color_id >", value, "outColorId");
            return (Criteria) this;
        }

        public Criteria andOutColorIdGreaterThanOrEqualTo(Short value) {
            addCriterion("out_color_id >=", value, "outColorId");
            return (Criteria) this;
        }

        public Criteria andOutColorIdLessThan(Short value) {
            addCriterion("out_color_id <", value, "outColorId");
            return (Criteria) this;
        }

        public Criteria andOutColorIdLessThanOrEqualTo(Short value) {
            addCriterion("out_color_id <=", value, "outColorId");
            return (Criteria) this;
        }

        public Criteria andOutColorIdIn(List<Short> values) {
            addCriterion("out_color_id in", values, "outColorId");
            return (Criteria) this;
        }

        public Criteria andOutColorIdNotIn(List<Short> values) {
            addCriterion("out_color_id not in", values, "outColorId");
            return (Criteria) this;
        }

        public Criteria andOutColorIdBetween(Short value1, Short value2) {
            addCriterion("out_color_id between", value1, value2, "outColorId");
            return (Criteria) this;
        }

        public Criteria andOutColorIdNotBetween(Short value1, Short value2) {
            addCriterion("out_color_id not between", value1, value2, "outColorId");
            return (Criteria) this;
        }

        public Criteria andOutTypeIdIsNull() {
            addCriterion("out_type_id is null");
            return (Criteria) this;
        }

        public Criteria andOutTypeIdIsNotNull() {
            addCriterion("out_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutTypeIdEqualTo(Short value) {
            addCriterion("out_type_id =", value, "outTypeId");
            return (Criteria) this;
        }

        public Criteria andOutTypeIdNotEqualTo(Short value) {
            addCriterion("out_type_id <>", value, "outTypeId");
            return (Criteria) this;
        }

        public Criteria andOutTypeIdGreaterThan(Short value) {
            addCriterion("out_type_id >", value, "outTypeId");
            return (Criteria) this;
        }

        public Criteria andOutTypeIdGreaterThanOrEqualTo(Short value) {
            addCriterion("out_type_id >=", value, "outTypeId");
            return (Criteria) this;
        }

        public Criteria andOutTypeIdLessThan(Short value) {
            addCriterion("out_type_id <", value, "outTypeId");
            return (Criteria) this;
        }

        public Criteria andOutTypeIdLessThanOrEqualTo(Short value) {
            addCriterion("out_type_id <=", value, "outTypeId");
            return (Criteria) this;
        }

        public Criteria andOutTypeIdIn(List<Short> values) {
            addCriterion("out_type_id in", values, "outTypeId");
            return (Criteria) this;
        }

        public Criteria andOutTypeIdNotIn(List<Short> values) {
            addCriterion("out_type_id not in", values, "outTypeId");
            return (Criteria) this;
        }

        public Criteria andOutTypeIdBetween(Short value1, Short value2) {
            addCriterion("out_type_id between", value1, value2, "outTypeId");
            return (Criteria) this;
        }

        public Criteria andOutTypeIdNotBetween(Short value1, Short value2) {
            addCriterion("out_type_id not between", value1, value2, "outTypeId");
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

        public Criteria andInSubBrandIdIsNull() {
            addCriterion("in_sub_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andInSubBrandIdIsNotNull() {
            addCriterion("in_sub_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andInSubBrandIdEqualTo(Short value) {
            addCriterion("in_sub_brand_id =", value, "inSubBrandId");
            return (Criteria) this;
        }

        public Criteria andInSubBrandIdNotEqualTo(Short value) {
            addCriterion("in_sub_brand_id <>", value, "inSubBrandId");
            return (Criteria) this;
        }

        public Criteria andInSubBrandIdGreaterThan(Short value) {
            addCriterion("in_sub_brand_id >", value, "inSubBrandId");
            return (Criteria) this;
        }

        public Criteria andInSubBrandIdGreaterThanOrEqualTo(Short value) {
            addCriterion("in_sub_brand_id >=", value, "inSubBrandId");
            return (Criteria) this;
        }

        public Criteria andInSubBrandIdLessThan(Short value) {
            addCriterion("in_sub_brand_id <", value, "inSubBrandId");
            return (Criteria) this;
        }

        public Criteria andInSubBrandIdLessThanOrEqualTo(Short value) {
            addCriterion("in_sub_brand_id <=", value, "inSubBrandId");
            return (Criteria) this;
        }

        public Criteria andInSubBrandIdIn(List<Short> values) {
            addCriterion("in_sub_brand_id in", values, "inSubBrandId");
            return (Criteria) this;
        }

        public Criteria andInSubBrandIdNotIn(List<Short> values) {
            addCriterion("in_sub_brand_id not in", values, "inSubBrandId");
            return (Criteria) this;
        }

        public Criteria andInSubBrandIdBetween(Short value1, Short value2) {
            addCriterion("in_sub_brand_id between", value1, value2, "inSubBrandId");
            return (Criteria) this;
        }

        public Criteria andInSubBrandIdNotBetween(Short value1, Short value2) {
            addCriterion("in_sub_brand_id not between", value1, value2, "inSubBrandId");
            return (Criteria) this;
        }

        public Criteria andInModeYearIdIsNull() {
            addCriterion("in_mode_year_id is null");
            return (Criteria) this;
        }

        public Criteria andInModeYearIdIsNotNull() {
            addCriterion("in_mode_year_id is not null");
            return (Criteria) this;
        }

        public Criteria andInModeYearIdEqualTo(Short value) {
            addCriterion("in_mode_year_id =", value, "inModeYearId");
            return (Criteria) this;
        }

        public Criteria andInModeYearIdNotEqualTo(Short value) {
            addCriterion("in_mode_year_id <>", value, "inModeYearId");
            return (Criteria) this;
        }

        public Criteria andInModeYearIdGreaterThan(Short value) {
            addCriterion("in_mode_year_id >", value, "inModeYearId");
            return (Criteria) this;
        }

        public Criteria andInModeYearIdGreaterThanOrEqualTo(Short value) {
            addCriterion("in_mode_year_id >=", value, "inModeYearId");
            return (Criteria) this;
        }

        public Criteria andInModeYearIdLessThan(Short value) {
            addCriterion("in_mode_year_id <", value, "inModeYearId");
            return (Criteria) this;
        }

        public Criteria andInModeYearIdLessThanOrEqualTo(Short value) {
            addCriterion("in_mode_year_id <=", value, "inModeYearId");
            return (Criteria) this;
        }

        public Criteria andInModeYearIdIn(List<Short> values) {
            addCriterion("in_mode_year_id in", values, "inModeYearId");
            return (Criteria) this;
        }

        public Criteria andInModeYearIdNotIn(List<Short> values) {
            addCriterion("in_mode_year_id not in", values, "inModeYearId");
            return (Criteria) this;
        }

        public Criteria andInModeYearIdBetween(Short value1, Short value2) {
            addCriterion("in_mode_year_id between", value1, value2, "inModeYearId");
            return (Criteria) this;
        }

        public Criteria andInModeYearIdNotBetween(Short value1, Short value2) {
            addCriterion("in_mode_year_id not between", value1, value2, "inModeYearId");
            return (Criteria) this;
        }

        public Criteria andOutSubBrandIdIsNull() {
            addCriterion("out_sub_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andOutSubBrandIdIsNotNull() {
            addCriterion("out_sub_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutSubBrandIdEqualTo(Short value) {
            addCriterion("out_sub_brand_id =", value, "outSubBrandId");
            return (Criteria) this;
        }

        public Criteria andOutSubBrandIdNotEqualTo(Short value) {
            addCriterion("out_sub_brand_id <>", value, "outSubBrandId");
            return (Criteria) this;
        }

        public Criteria andOutSubBrandIdGreaterThan(Short value) {
            addCriterion("out_sub_brand_id >", value, "outSubBrandId");
            return (Criteria) this;
        }

        public Criteria andOutSubBrandIdGreaterThanOrEqualTo(Short value) {
            addCriterion("out_sub_brand_id >=", value, "outSubBrandId");
            return (Criteria) this;
        }

        public Criteria andOutSubBrandIdLessThan(Short value) {
            addCriterion("out_sub_brand_id <", value, "outSubBrandId");
            return (Criteria) this;
        }

        public Criteria andOutSubBrandIdLessThanOrEqualTo(Short value) {
            addCriterion("out_sub_brand_id <=", value, "outSubBrandId");
            return (Criteria) this;
        }

        public Criteria andOutSubBrandIdIn(List<Short> values) {
            addCriterion("out_sub_brand_id in", values, "outSubBrandId");
            return (Criteria) this;
        }

        public Criteria andOutSubBrandIdNotIn(List<Short> values) {
            addCriterion("out_sub_brand_id not in", values, "outSubBrandId");
            return (Criteria) this;
        }

        public Criteria andOutSubBrandIdBetween(Short value1, Short value2) {
            addCriterion("out_sub_brand_id between", value1, value2, "outSubBrandId");
            return (Criteria) this;
        }

        public Criteria andOutSubBrandIdNotBetween(Short value1, Short value2) {
            addCriterion("out_sub_brand_id not between", value1, value2, "outSubBrandId");
            return (Criteria) this;
        }

        public Criteria andOutModeYearIdIsNull() {
            addCriterion("out_mode_year_id is null");
            return (Criteria) this;
        }

        public Criteria andOutModeYearIdIsNotNull() {
            addCriterion("out_mode_year_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutModeYearIdEqualTo(Short value) {
            addCriterion("out_mode_year_id =", value, "outModeYearId");
            return (Criteria) this;
        }

        public Criteria andOutModeYearIdNotEqualTo(Short value) {
            addCriterion("out_mode_year_id <>", value, "outModeYearId");
            return (Criteria) this;
        }

        public Criteria andOutModeYearIdGreaterThan(Short value) {
            addCriterion("out_mode_year_id >", value, "outModeYearId");
            return (Criteria) this;
        }

        public Criteria andOutModeYearIdGreaterThanOrEqualTo(Short value) {
            addCriterion("out_mode_year_id >=", value, "outModeYearId");
            return (Criteria) this;
        }

        public Criteria andOutModeYearIdLessThan(Short value) {
            addCriterion("out_mode_year_id <", value, "outModeYearId");
            return (Criteria) this;
        }

        public Criteria andOutModeYearIdLessThanOrEqualTo(Short value) {
            addCriterion("out_mode_year_id <=", value, "outModeYearId");
            return (Criteria) this;
        }

        public Criteria andOutModeYearIdIn(List<Short> values) {
            addCriterion("out_mode_year_id in", values, "outModeYearId");
            return (Criteria) this;
        }

        public Criteria andOutModeYearIdNotIn(List<Short> values) {
            addCriterion("out_mode_year_id not in", values, "outModeYearId");
            return (Criteria) this;
        }

        public Criteria andOutModeYearIdBetween(Short value1, Short value2) {
            addCriterion("out_mode_year_id between", value1, value2, "outModeYearId");
            return (Criteria) this;
        }

        public Criteria andOutModeYearIdNotBetween(Short value1, Short value2) {
            addCriterion("out_mode_year_id not between", value1, value2, "outModeYearId");
            return (Criteria) this;
        }

        public Criteria andInPlateTextIsNull() {
            addCriterion("in_plate_text is null");
            return (Criteria) this;
        }

        public Criteria andInPlateTextIsNotNull() {
            addCriterion("in_plate_text is not null");
            return (Criteria) this;
        }

        public Criteria andInPlateTextEqualTo(String value) {
            addCriterion("in_plate_text =", value, "inPlateText");
            return (Criteria) this;
        }

        public Criteria andInPlateTextNotEqualTo(String value) {
            addCriterion("in_plate_text <>", value, "inPlateText");
            return (Criteria) this;
        }

        public Criteria andInPlateTextGreaterThan(String value) {
            addCriterion("in_plate_text >", value, "inPlateText");
            return (Criteria) this;
        }

        public Criteria andInPlateTextGreaterThanOrEqualTo(String value) {
            addCriterion("in_plate_text >=", value, "inPlateText");
            return (Criteria) this;
        }

        public Criteria andInPlateTextLessThan(String value) {
            addCriterion("in_plate_text <", value, "inPlateText");
            return (Criteria) this;
        }

        public Criteria andInPlateTextLessThanOrEqualTo(String value) {
            addCriterion("in_plate_text <=", value, "inPlateText");
            return (Criteria) this;
        }

        public Criteria andInPlateTextLike(String value) {
            addCriterion("in_plate_text like", value, "inPlateText");
            return (Criteria) this;
        }

        public Criteria andInPlateTextNotLike(String value) {
            addCriterion("in_plate_text not like", value, "inPlateText");
            return (Criteria) this;
        }

        public Criteria andInPlateTextIn(List<String> values) {
            addCriterion("in_plate_text in", values, "inPlateText");
            return (Criteria) this;
        }

        public Criteria andInPlateTextNotIn(List<String> values) {
            addCriterion("in_plate_text not in", values, "inPlateText");
            return (Criteria) this;
        }

        public Criteria andInPlateTextBetween(String value1, String value2) {
            addCriterion("in_plate_text between", value1, value2, "inPlateText");
            return (Criteria) this;
        }

        public Criteria andInPlateTextNotBetween(String value1, String value2) {
            addCriterion("in_plate_text not between", value1, value2, "inPlateText");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextIsNull() {
            addCriterion("out_plate_text is null");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextIsNotNull() {
            addCriterion("out_plate_text is not null");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextEqualTo(String value) {
            addCriterion("out_plate_text =", value, "outPlateText");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextNotEqualTo(String value) {
            addCriterion("out_plate_text <>", value, "outPlateText");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextGreaterThan(String value) {
            addCriterion("out_plate_text >", value, "outPlateText");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextGreaterThanOrEqualTo(String value) {
            addCriterion("out_plate_text >=", value, "outPlateText");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextLessThan(String value) {
            addCriterion("out_plate_text <", value, "outPlateText");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextLessThanOrEqualTo(String value) {
            addCriterion("out_plate_text <=", value, "outPlateText");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextLike(String value) {
            addCriterion("out_plate_text like", value, "outPlateText");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextNotLike(String value) {
            addCriterion("out_plate_text not like", value, "outPlateText");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextIn(List<String> values) {
            addCriterion("out_plate_text in", values, "outPlateText");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextNotIn(List<String> values) {
            addCriterion("out_plate_text not in", values, "outPlateText");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextBetween(String value1, String value2) {
            addCriterion("out_plate_text between", value1, value2, "outPlateText");
            return (Criteria) this;
        }

        public Criteria andOutPlateTextNotBetween(String value1, String value2) {
            addCriterion("out_plate_text not between", value1, value2, "outPlateText");
            return (Criteria) this;
        }
    }

    /**
     * @Title public.vehicle_queue表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-10 12:48:47
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @Title public.vehicle_queue表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-10 12:48:47
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