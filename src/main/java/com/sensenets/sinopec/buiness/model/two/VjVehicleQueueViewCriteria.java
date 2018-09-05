/**
  * VjVehicleQueueViewCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-05
  */
package com.sensenets.sinopec.buiness.model.two;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title public.vj_vehicle_queue_view表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-09-05 14:27:22
 */
public class VjVehicleQueueViewCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     *  构造查询条件:public.vj_vehicle_queue_view
     */
    public VjVehicleQueueViewCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *  设置排序字段:public.vj_vehicle_queue_view
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *  获取排序字段:public.vj_vehicle_queue_view
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *  设置过滤重复数据:public.vj_vehicle_queue_view
     *
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *  是否过滤重复数据:public.vj_vehicle_queue_view
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *  获取当前的查询条件实例:public.vj_vehicle_queue_view
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * :public.vj_vehicle_queue_view
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * :public.vj_vehicle_queue_view
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *  创建一个查询条件:public.vj_vehicle_queue_view
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *  内部构建查询条件对象:public.vj_vehicle_queue_view
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *  清除查询条件:public.vj_vehicle_queue_view
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
     * @Title public.vj_vehicle_queue_view表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-05 14:27:22
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

        public Criteria andVehicleInIdIsNull() {
            addCriterion("vehicle_in_id is null");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdIsNotNull() {
            addCriterion("vehicle_in_id is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdEqualTo(String value) {
            addCriterion("vehicle_in_id =", value, "vehicleInId");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdNotEqualTo(String value) {
            addCriterion("vehicle_in_id <>", value, "vehicleInId");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdGreaterThan(String value) {
            addCriterion("vehicle_in_id >", value, "vehicleInId");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_in_id >=", value, "vehicleInId");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdLessThan(String value) {
            addCriterion("vehicle_in_id <", value, "vehicleInId");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdLessThanOrEqualTo(String value) {
            addCriterion("vehicle_in_id <=", value, "vehicleInId");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdLike(String value) {
            addCriterion("vehicle_in_id like", value, "vehicleInId");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdNotLike(String value) {
            addCriterion("vehicle_in_id not like", value, "vehicleInId");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdIn(List<String> values) {
            addCriterion("vehicle_in_id in", values, "vehicleInId");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdNotIn(List<String> values) {
            addCriterion("vehicle_in_id not in", values, "vehicleInId");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdBetween(String value1, String value2) {
            addCriterion("vehicle_in_id between", value1, value2, "vehicleInId");
            return (Criteria) this;
        }

        public Criteria andVehicleInIdNotBetween(String value1, String value2) {
            addCriterion("vehicle_in_id not between", value1, value2, "vehicleInId");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdIsNull() {
            addCriterion("vehicle_out_id is null");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdIsNotNull() {
            addCriterion("vehicle_out_id is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdEqualTo(String value) {
            addCriterion("vehicle_out_id =", value, "vehicleOutId");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdNotEqualTo(String value) {
            addCriterion("vehicle_out_id <>", value, "vehicleOutId");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdGreaterThan(String value) {
            addCriterion("vehicle_out_id >", value, "vehicleOutId");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_out_id >=", value, "vehicleOutId");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdLessThan(String value) {
            addCriterion("vehicle_out_id <", value, "vehicleOutId");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdLessThanOrEqualTo(String value) {
            addCriterion("vehicle_out_id <=", value, "vehicleOutId");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdLike(String value) {
            addCriterion("vehicle_out_id like", value, "vehicleOutId");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdNotLike(String value) {
            addCriterion("vehicle_out_id not like", value, "vehicleOutId");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdIn(List<String> values) {
            addCriterion("vehicle_out_id in", values, "vehicleOutId");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdNotIn(List<String> values) {
            addCriterion("vehicle_out_id not in", values, "vehicleOutId");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdBetween(String value1, String value2) {
            addCriterion("vehicle_out_id between", value1, value2, "vehicleOutId");
            return (Criteria) this;
        }

        public Criteria andVehicleOutIdNotBetween(String value1, String value2) {
            addCriterion("vehicle_out_id not between", value1, value2, "vehicleOutId");
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

        public Criteria andVaUtsIsNull() {
            addCriterion("va_uts is null");
            return (Criteria) this;
        }

        public Criteria andVaUtsIsNotNull() {
            addCriterion("va_uts is not null");
            return (Criteria) this;
        }

        public Criteria andVaUtsEqualTo(Date value) {
            addCriterion("va_uts =", value, "vaUts");
            return (Criteria) this;
        }

        public Criteria andVaUtsNotEqualTo(Date value) {
            addCriterion("va_uts <>", value, "vaUts");
            return (Criteria) this;
        }

        public Criteria andVaUtsGreaterThan(Date value) {
            addCriterion("va_uts >", value, "vaUts");
            return (Criteria) this;
        }

        public Criteria andVaUtsGreaterThanOrEqualTo(Date value) {
            addCriterion("va_uts >=", value, "vaUts");
            return (Criteria) this;
        }

        public Criteria andVaUtsLessThan(Date value) {
            addCriterion("va_uts <", value, "vaUts");
            return (Criteria) this;
        }

        public Criteria andVaUtsLessThanOrEqualTo(Date value) {
            addCriterion("va_uts <=", value, "vaUts");
            return (Criteria) this;
        }

        public Criteria andVaUtsIn(List<Date> values) {
            addCriterion("va_uts in", values, "vaUts");
            return (Criteria) this;
        }

        public Criteria andVaUtsNotIn(List<Date> values) {
            addCriterion("va_uts not in", values, "vaUts");
            return (Criteria) this;
        }

        public Criteria andVaUtsBetween(Date value1, Date value2) {
            addCriterion("va_uts between", value1, value2, "vaUts");
            return (Criteria) this;
        }

        public Criteria andVaUtsNotBetween(Date value1, Date value2) {
            addCriterion("va_uts not between", value1, value2, "vaUts");
            return (Criteria) this;
        }

        public Criteria andVaTsIsNull() {
            addCriterion("va_ts is null");
            return (Criteria) this;
        }

        public Criteria andVaTsIsNotNull() {
            addCriterion("va_ts is not null");
            return (Criteria) this;
        }

        public Criteria andVaTsEqualTo(Long value) {
            addCriterion("va_ts =", value, "vaTs");
            return (Criteria) this;
        }

        public Criteria andVaTsNotEqualTo(Long value) {
            addCriterion("va_ts <>", value, "vaTs");
            return (Criteria) this;
        }

        public Criteria andVaTsGreaterThan(Long value) {
            addCriterion("va_ts >", value, "vaTs");
            return (Criteria) this;
        }

        public Criteria andVaTsGreaterThanOrEqualTo(Long value) {
            addCriterion("va_ts >=", value, "vaTs");
            return (Criteria) this;
        }

        public Criteria andVaTsLessThan(Long value) {
            addCriterion("va_ts <", value, "vaTs");
            return (Criteria) this;
        }

        public Criteria andVaTsLessThanOrEqualTo(Long value) {
            addCriterion("va_ts <=", value, "vaTs");
            return (Criteria) this;
        }

        public Criteria andVaTsIn(List<Long> values) {
            addCriterion("va_ts in", values, "vaTs");
            return (Criteria) this;
        }

        public Criteria andVaTsNotIn(List<Long> values) {
            addCriterion("va_ts not in", values, "vaTs");
            return (Criteria) this;
        }

        public Criteria andVaTsBetween(Long value1, Long value2) {
            addCriterion("va_ts between", value1, value2, "vaTs");
            return (Criteria) this;
        }

        public Criteria andVaTsNotBetween(Long value1, Long value2) {
            addCriterion("va_ts not between", value1, value2, "vaTs");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdIsNull() {
            addCriterion("va_vehicle_id is null");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdIsNotNull() {
            addCriterion("va_vehicle_id is not null");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdEqualTo(String value) {
            addCriterion("va_vehicle_id =", value, "vaVehicleId");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdNotEqualTo(String value) {
            addCriterion("va_vehicle_id <>", value, "vaVehicleId");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdGreaterThan(String value) {
            addCriterion("va_vehicle_id >", value, "vaVehicleId");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdGreaterThanOrEqualTo(String value) {
            addCriterion("va_vehicle_id >=", value, "vaVehicleId");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdLessThan(String value) {
            addCriterion("va_vehicle_id <", value, "vaVehicleId");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdLessThanOrEqualTo(String value) {
            addCriterion("va_vehicle_id <=", value, "vaVehicleId");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdLike(String value) {
            addCriterion("va_vehicle_id like", value, "vaVehicleId");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdNotLike(String value) {
            addCriterion("va_vehicle_id not like", value, "vaVehicleId");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdIn(List<String> values) {
            addCriterion("va_vehicle_id in", values, "vaVehicleId");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdNotIn(List<String> values) {
            addCriterion("va_vehicle_id not in", values, "vaVehicleId");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdBetween(String value1, String value2) {
            addCriterion("va_vehicle_id between", value1, value2, "vaVehicleId");
            return (Criteria) this;
        }

        public Criteria andVaVehicleIdNotBetween(String value1, String value2) {
            addCriterion("va_vehicle_id not between", value1, value2, "vaVehicleId");
            return (Criteria) this;
        }

        public Criteria andVaImageIdIsNull() {
            addCriterion("va_image_id is null");
            return (Criteria) this;
        }

        public Criteria andVaImageIdIsNotNull() {
            addCriterion("va_image_id is not null");
            return (Criteria) this;
        }

        public Criteria andVaImageIdEqualTo(String value) {
            addCriterion("va_image_id =", value, "vaImageId");
            return (Criteria) this;
        }

        public Criteria andVaImageIdNotEqualTo(String value) {
            addCriterion("va_image_id <>", value, "vaImageId");
            return (Criteria) this;
        }

        public Criteria andVaImageIdGreaterThan(String value) {
            addCriterion("va_image_id >", value, "vaImageId");
            return (Criteria) this;
        }

        public Criteria andVaImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("va_image_id >=", value, "vaImageId");
            return (Criteria) this;
        }

        public Criteria andVaImageIdLessThan(String value) {
            addCriterion("va_image_id <", value, "vaImageId");
            return (Criteria) this;
        }

        public Criteria andVaImageIdLessThanOrEqualTo(String value) {
            addCriterion("va_image_id <=", value, "vaImageId");
            return (Criteria) this;
        }

        public Criteria andVaImageIdLike(String value) {
            addCriterion("va_image_id like", value, "vaImageId");
            return (Criteria) this;
        }

        public Criteria andVaImageIdNotLike(String value) {
            addCriterion("va_image_id not like", value, "vaImageId");
            return (Criteria) this;
        }

        public Criteria andVaImageIdIn(List<String> values) {
            addCriterion("va_image_id in", values, "vaImageId");
            return (Criteria) this;
        }

        public Criteria andVaImageIdNotIn(List<String> values) {
            addCriterion("va_image_id not in", values, "vaImageId");
            return (Criteria) this;
        }

        public Criteria andVaImageIdBetween(String value1, String value2) {
            addCriterion("va_image_id between", value1, value2, "vaImageId");
            return (Criteria) this;
        }

        public Criteria andVaImageIdNotBetween(String value1, String value2) {
            addCriterion("va_image_id not between", value1, value2, "vaImageId");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdIsNull() {
            addCriterion("va_repo_id is null");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdIsNotNull() {
            addCriterion("va_repo_id is not null");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdEqualTo(String value) {
            addCriterion("va_repo_id =", value, "vaRepoId");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdNotEqualTo(String value) {
            addCriterion("va_repo_id <>", value, "vaRepoId");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdGreaterThan(String value) {
            addCriterion("va_repo_id >", value, "vaRepoId");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdGreaterThanOrEqualTo(String value) {
            addCriterion("va_repo_id >=", value, "vaRepoId");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdLessThan(String value) {
            addCriterion("va_repo_id <", value, "vaRepoId");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdLessThanOrEqualTo(String value) {
            addCriterion("va_repo_id <=", value, "vaRepoId");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdLike(String value) {
            addCriterion("va_repo_id like", value, "vaRepoId");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdNotLike(String value) {
            addCriterion("va_repo_id not like", value, "vaRepoId");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdIn(List<String> values) {
            addCriterion("va_repo_id in", values, "vaRepoId");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdNotIn(List<String> values) {
            addCriterion("va_repo_id not in", values, "vaRepoId");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdBetween(String value1, String value2) {
            addCriterion("va_repo_id between", value1, value2, "vaRepoId");
            return (Criteria) this;
        }

        public Criteria andVaRepoIdNotBetween(String value1, String value2) {
            addCriterion("va_repo_id not between", value1, value2, "vaRepoId");
            return (Criteria) this;
        }

        public Criteria andVaColorIdIsNull() {
            addCriterion("va_color_id is null");
            return (Criteria) this;
        }

        public Criteria andVaColorIdIsNotNull() {
            addCriterion("va_color_id is not null");
            return (Criteria) this;
        }

        public Criteria andVaColorIdEqualTo(Short value) {
            addCriterion("va_color_id =", value, "vaColorId");
            return (Criteria) this;
        }

        public Criteria andVaColorIdNotEqualTo(Short value) {
            addCriterion("va_color_id <>", value, "vaColorId");
            return (Criteria) this;
        }

        public Criteria andVaColorIdGreaterThan(Short value) {
            addCriterion("va_color_id >", value, "vaColorId");
            return (Criteria) this;
        }

        public Criteria andVaColorIdGreaterThanOrEqualTo(Short value) {
            addCriterion("va_color_id >=", value, "vaColorId");
            return (Criteria) this;
        }

        public Criteria andVaColorIdLessThan(Short value) {
            addCriterion("va_color_id <", value, "vaColorId");
            return (Criteria) this;
        }

        public Criteria andVaColorIdLessThanOrEqualTo(Short value) {
            addCriterion("va_color_id <=", value, "vaColorId");
            return (Criteria) this;
        }

        public Criteria andVaColorIdIn(List<Short> values) {
            addCriterion("va_color_id in", values, "vaColorId");
            return (Criteria) this;
        }

        public Criteria andVaColorIdNotIn(List<Short> values) {
            addCriterion("va_color_id not in", values, "vaColorId");
            return (Criteria) this;
        }

        public Criteria andVaColorIdBetween(Short value1, Short value2) {
            addCriterion("va_color_id between", value1, value2, "vaColorId");
            return (Criteria) this;
        }

        public Criteria andVaColorIdNotBetween(Short value1, Short value2) {
            addCriterion("va_color_id not between", value1, value2, "vaColorId");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdIsNull() {
            addCriterion("va_sensor_id is null");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdIsNotNull() {
            addCriterion("va_sensor_id is not null");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdEqualTo(String value) {
            addCriterion("va_sensor_id =", value, "vaSensorId");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdNotEqualTo(String value) {
            addCriterion("va_sensor_id <>", value, "vaSensorId");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdGreaterThan(String value) {
            addCriterion("va_sensor_id >", value, "vaSensorId");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdGreaterThanOrEqualTo(String value) {
            addCriterion("va_sensor_id >=", value, "vaSensorId");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdLessThan(String value) {
            addCriterion("va_sensor_id <", value, "vaSensorId");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdLessThanOrEqualTo(String value) {
            addCriterion("va_sensor_id <=", value, "vaSensorId");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdLike(String value) {
            addCriterion("va_sensor_id like", value, "vaSensorId");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdNotLike(String value) {
            addCriterion("va_sensor_id not like", value, "vaSensorId");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdIn(List<String> values) {
            addCriterion("va_sensor_id in", values, "vaSensorId");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdNotIn(List<String> values) {
            addCriterion("va_sensor_id not in", values, "vaSensorId");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdBetween(String value1, String value2) {
            addCriterion("va_sensor_id between", value1, value2, "vaSensorId");
            return (Criteria) this;
        }

        public Criteria andVaSensorIdNotBetween(String value1, String value2) {
            addCriterion("va_sensor_id not between", value1, value2, "vaSensorId");
            return (Criteria) this;
        }

        public Criteria andVaConfidenceIsNull() {
            addCriterion("va_confidence is null");
            return (Criteria) this;
        }

        public Criteria andVaConfidenceIsNotNull() {
            addCriterion("va_confidence is not null");
            return (Criteria) this;
        }

        public Criteria andVaConfidenceEqualTo(Float value) {
            addCriterion("va_confidence =", value, "vaConfidence");
            return (Criteria) this;
        }

        public Criteria andVaConfidenceNotEqualTo(Float value) {
            addCriterion("va_confidence <>", value, "vaConfidence");
            return (Criteria) this;
        }

        public Criteria andVaConfidenceGreaterThan(Float value) {
            addCriterion("va_confidence >", value, "vaConfidence");
            return (Criteria) this;
        }

        public Criteria andVaConfidenceGreaterThanOrEqualTo(Float value) {
            addCriterion("va_confidence >=", value, "vaConfidence");
            return (Criteria) this;
        }

        public Criteria andVaConfidenceLessThan(Float value) {
            addCriterion("va_confidence <", value, "vaConfidence");
            return (Criteria) this;
        }

        public Criteria andVaConfidenceLessThanOrEqualTo(Float value) {
            addCriterion("va_confidence <=", value, "vaConfidence");
            return (Criteria) this;
        }

        public Criteria andVaConfidenceIn(List<Float> values) {
            addCriterion("va_confidence in", values, "vaConfidence");
            return (Criteria) this;
        }

        public Criteria andVaConfidenceNotIn(List<Float> values) {
            addCriterion("va_confidence not in", values, "vaConfidence");
            return (Criteria) this;
        }

        public Criteria andVaConfidenceBetween(Float value1, Float value2) {
            addCriterion("va_confidence between", value1, value2, "vaConfidence");
            return (Criteria) this;
        }

        public Criteria andVaConfidenceNotBetween(Float value1, Float value2) {
            addCriterion("va_confidence not between", value1, value2, "vaConfidence");
            return (Criteria) this;
        }

        public Criteria andVaBrandIdIsNull() {
            addCriterion("va_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andVaBrandIdIsNotNull() {
            addCriterion("va_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andVaBrandIdEqualTo(Short value) {
            addCriterion("va_brand_id =", value, "vaBrandId");
            return (Criteria) this;
        }

        public Criteria andVaBrandIdNotEqualTo(Short value) {
            addCriterion("va_brand_id <>", value, "vaBrandId");
            return (Criteria) this;
        }

        public Criteria andVaBrandIdGreaterThan(Short value) {
            addCriterion("va_brand_id >", value, "vaBrandId");
            return (Criteria) this;
        }

        public Criteria andVaBrandIdGreaterThanOrEqualTo(Short value) {
            addCriterion("va_brand_id >=", value, "vaBrandId");
            return (Criteria) this;
        }

        public Criteria andVaBrandIdLessThan(Short value) {
            addCriterion("va_brand_id <", value, "vaBrandId");
            return (Criteria) this;
        }

        public Criteria andVaBrandIdLessThanOrEqualTo(Short value) {
            addCriterion("va_brand_id <=", value, "vaBrandId");
            return (Criteria) this;
        }

        public Criteria andVaBrandIdIn(List<Short> values) {
            addCriterion("va_brand_id in", values, "vaBrandId");
            return (Criteria) this;
        }

        public Criteria andVaBrandIdNotIn(List<Short> values) {
            addCriterion("va_brand_id not in", values, "vaBrandId");
            return (Criteria) this;
        }

        public Criteria andVaBrandIdBetween(Short value1, Short value2) {
            addCriterion("va_brand_id between", value1, value2, "vaBrandId");
            return (Criteria) this;
        }

        public Criteria andVaBrandIdNotBetween(Short value1, Short value2) {
            addCriterion("va_brand_id not between", value1, value2, "vaBrandId");
            return (Criteria) this;
        }

        public Criteria andVaSubBrandIdIsNull() {
            addCriterion("va_sub_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andVaSubBrandIdIsNotNull() {
            addCriterion("va_sub_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andVaSubBrandIdEqualTo(Short value) {
            addCriterion("va_sub_brand_id =", value, "vaSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVaSubBrandIdNotEqualTo(Short value) {
            addCriterion("va_sub_brand_id <>", value, "vaSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVaSubBrandIdGreaterThan(Short value) {
            addCriterion("va_sub_brand_id >", value, "vaSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVaSubBrandIdGreaterThanOrEqualTo(Short value) {
            addCriterion("va_sub_brand_id >=", value, "vaSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVaSubBrandIdLessThan(Short value) {
            addCriterion("va_sub_brand_id <", value, "vaSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVaSubBrandIdLessThanOrEqualTo(Short value) {
            addCriterion("va_sub_brand_id <=", value, "vaSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVaSubBrandIdIn(List<Short> values) {
            addCriterion("va_sub_brand_id in", values, "vaSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVaSubBrandIdNotIn(List<Short> values) {
            addCriterion("va_sub_brand_id not in", values, "vaSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVaSubBrandIdBetween(Short value1, Short value2) {
            addCriterion("va_sub_brand_id between", value1, value2, "vaSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVaSubBrandIdNotBetween(Short value1, Short value2) {
            addCriterion("va_sub_brand_id not between", value1, value2, "vaSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVaModelYearIdIsNull() {
            addCriterion("va_model_year_id is null");
            return (Criteria) this;
        }

        public Criteria andVaModelYearIdIsNotNull() {
            addCriterion("va_model_year_id is not null");
            return (Criteria) this;
        }

        public Criteria andVaModelYearIdEqualTo(Short value) {
            addCriterion("va_model_year_id =", value, "vaModelYearId");
            return (Criteria) this;
        }

        public Criteria andVaModelYearIdNotEqualTo(Short value) {
            addCriterion("va_model_year_id <>", value, "vaModelYearId");
            return (Criteria) this;
        }

        public Criteria andVaModelYearIdGreaterThan(Short value) {
            addCriterion("va_model_year_id >", value, "vaModelYearId");
            return (Criteria) this;
        }

        public Criteria andVaModelYearIdGreaterThanOrEqualTo(Short value) {
            addCriterion("va_model_year_id >=", value, "vaModelYearId");
            return (Criteria) this;
        }

        public Criteria andVaModelYearIdLessThan(Short value) {
            addCriterion("va_model_year_id <", value, "vaModelYearId");
            return (Criteria) this;
        }

        public Criteria andVaModelYearIdLessThanOrEqualTo(Short value) {
            addCriterion("va_model_year_id <=", value, "vaModelYearId");
            return (Criteria) this;
        }

        public Criteria andVaModelYearIdIn(List<Short> values) {
            addCriterion("va_model_year_id in", values, "vaModelYearId");
            return (Criteria) this;
        }

        public Criteria andVaModelYearIdNotIn(List<Short> values) {
            addCriterion("va_model_year_id not in", values, "vaModelYearId");
            return (Criteria) this;
        }

        public Criteria andVaModelYearIdBetween(Short value1, Short value2) {
            addCriterion("va_model_year_id between", value1, value2, "vaModelYearId");
            return (Criteria) this;
        }

        public Criteria andVaModelYearIdNotBetween(Short value1, Short value2) {
            addCriterion("va_model_year_id not between", value1, value2, "vaModelYearId");
            return (Criteria) this;
        }

        public Criteria andVaTypeIdIsNull() {
            addCriterion("va_type_id is null");
            return (Criteria) this;
        }

        public Criteria andVaTypeIdIsNotNull() {
            addCriterion("va_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andVaTypeIdEqualTo(Short value) {
            addCriterion("va_type_id =", value, "vaTypeId");
            return (Criteria) this;
        }

        public Criteria andVaTypeIdNotEqualTo(Short value) {
            addCriterion("va_type_id <>", value, "vaTypeId");
            return (Criteria) this;
        }

        public Criteria andVaTypeIdGreaterThan(Short value) {
            addCriterion("va_type_id >", value, "vaTypeId");
            return (Criteria) this;
        }

        public Criteria andVaTypeIdGreaterThanOrEqualTo(Short value) {
            addCriterion("va_type_id >=", value, "vaTypeId");
            return (Criteria) this;
        }

        public Criteria andVaTypeIdLessThan(Short value) {
            addCriterion("va_type_id <", value, "vaTypeId");
            return (Criteria) this;
        }

        public Criteria andVaTypeIdLessThanOrEqualTo(Short value) {
            addCriterion("va_type_id <=", value, "vaTypeId");
            return (Criteria) this;
        }

        public Criteria andVaTypeIdIn(List<Short> values) {
            addCriterion("va_type_id in", values, "vaTypeId");
            return (Criteria) this;
        }

        public Criteria andVaTypeIdNotIn(List<Short> values) {
            addCriterion("va_type_id not in", values, "vaTypeId");
            return (Criteria) this;
        }

        public Criteria andVaTypeIdBetween(Short value1, Short value2) {
            addCriterion("va_type_id between", value1, value2, "vaTypeId");
            return (Criteria) this;
        }

        public Criteria andVaTypeIdNotBetween(Short value1, Short value2) {
            addCriterion("va_type_id not between", value1, value2, "vaTypeId");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextIsNull() {
            addCriterion("va_plate_text is null");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextIsNotNull() {
            addCriterion("va_plate_text is not null");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextEqualTo(String value) {
            addCriterion("va_plate_text =", value, "vaPlateText");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextNotEqualTo(String value) {
            addCriterion("va_plate_text <>", value, "vaPlateText");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextGreaterThan(String value) {
            addCriterion("va_plate_text >", value, "vaPlateText");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextGreaterThanOrEqualTo(String value) {
            addCriterion("va_plate_text >=", value, "vaPlateText");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextLessThan(String value) {
            addCriterion("va_plate_text <", value, "vaPlateText");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextLessThanOrEqualTo(String value) {
            addCriterion("va_plate_text <=", value, "vaPlateText");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextLike(String value) {
            addCriterion("va_plate_text like", value, "vaPlateText");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextNotLike(String value) {
            addCriterion("va_plate_text not like", value, "vaPlateText");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextIn(List<String> values) {
            addCriterion("va_plate_text in", values, "vaPlateText");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextNotIn(List<String> values) {
            addCriterion("va_plate_text not in", values, "vaPlateText");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextBetween(String value1, String value2) {
            addCriterion("va_plate_text between", value1, value2, "vaPlateText");
            return (Criteria) this;
        }

        public Criteria andVaPlateTextNotBetween(String value1, String value2) {
            addCriterion("va_plate_text not between", value1, value2, "vaPlateText");
            return (Criteria) this;
        }

        public Criteria andVaPlateTypeIdIsNull() {
            addCriterion("va_plate_type_id is null");
            return (Criteria) this;
        }

        public Criteria andVaPlateTypeIdIsNotNull() {
            addCriterion("va_plate_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andVaPlateTypeIdEqualTo(Short value) {
            addCriterion("va_plate_type_id =", value, "vaPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVaPlateTypeIdNotEqualTo(Short value) {
            addCriterion("va_plate_type_id <>", value, "vaPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVaPlateTypeIdGreaterThan(Short value) {
            addCriterion("va_plate_type_id >", value, "vaPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVaPlateTypeIdGreaterThanOrEqualTo(Short value) {
            addCriterion("va_plate_type_id >=", value, "vaPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVaPlateTypeIdLessThan(Short value) {
            addCriterion("va_plate_type_id <", value, "vaPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVaPlateTypeIdLessThanOrEqualTo(Short value) {
            addCriterion("va_plate_type_id <=", value, "vaPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVaPlateTypeIdIn(List<Short> values) {
            addCriterion("va_plate_type_id in", values, "vaPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVaPlateTypeIdNotIn(List<Short> values) {
            addCriterion("va_plate_type_id not in", values, "vaPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVaPlateTypeIdBetween(Short value1, Short value2) {
            addCriterion("va_plate_type_id between", value1, value2, "vaPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVaPlateTypeIdNotBetween(Short value1, Short value2) {
            addCriterion("va_plate_type_id not between", value1, value2, "vaPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVaPlateColorIdIsNull() {
            addCriterion("va_plate_color_id is null");
            return (Criteria) this;
        }

        public Criteria andVaPlateColorIdIsNotNull() {
            addCriterion("va_plate_color_id is not null");
            return (Criteria) this;
        }

        public Criteria andVaPlateColorIdEqualTo(Short value) {
            addCriterion("va_plate_color_id =", value, "vaPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVaPlateColorIdNotEqualTo(Short value) {
            addCriterion("va_plate_color_id <>", value, "vaPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVaPlateColorIdGreaterThan(Short value) {
            addCriterion("va_plate_color_id >", value, "vaPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVaPlateColorIdGreaterThanOrEqualTo(Short value) {
            addCriterion("va_plate_color_id >=", value, "vaPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVaPlateColorIdLessThan(Short value) {
            addCriterion("va_plate_color_id <", value, "vaPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVaPlateColorIdLessThanOrEqualTo(Short value) {
            addCriterion("va_plate_color_id <=", value, "vaPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVaPlateColorIdIn(List<Short> values) {
            addCriterion("va_plate_color_id in", values, "vaPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVaPlateColorIdNotIn(List<Short> values) {
            addCriterion("va_plate_color_id not in", values, "vaPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVaPlateColorIdBetween(Short value1, Short value2) {
            addCriterion("va_plate_color_id between", value1, value2, "vaPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVaPlateColorIdNotBetween(Short value1, Short value2) {
            addCriterion("va_plate_color_id not between", value1, value2, "vaPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVaSideIsNull() {
            addCriterion("va_side is null");
            return (Criteria) this;
        }

        public Criteria andVaSideIsNotNull() {
            addCriterion("va_side is not null");
            return (Criteria) this;
        }

        public Criteria andVaSideEqualTo(Short value) {
            addCriterion("va_side =", value, "vaSide");
            return (Criteria) this;
        }

        public Criteria andVaSideNotEqualTo(Short value) {
            addCriterion("va_side <>", value, "vaSide");
            return (Criteria) this;
        }

        public Criteria andVaSideGreaterThan(Short value) {
            addCriterion("va_side >", value, "vaSide");
            return (Criteria) this;
        }

        public Criteria andVaSideGreaterThanOrEqualTo(Short value) {
            addCriterion("va_side >=", value, "vaSide");
            return (Criteria) this;
        }

        public Criteria andVaSideLessThan(Short value) {
            addCriterion("va_side <", value, "vaSide");
            return (Criteria) this;
        }

        public Criteria andVaSideLessThanOrEqualTo(Short value) {
            addCriterion("va_side <=", value, "vaSide");
            return (Criteria) this;
        }

        public Criteria andVaSideIn(List<Short> values) {
            addCriterion("va_side in", values, "vaSide");
            return (Criteria) this;
        }

        public Criteria andVaSideNotIn(List<Short> values) {
            addCriterion("va_side not in", values, "vaSide");
            return (Criteria) this;
        }

        public Criteria andVaSideBetween(Short value1, Short value2) {
            addCriterion("va_side between", value1, value2, "vaSide");
            return (Criteria) this;
        }

        public Criteria andVaSideNotBetween(Short value1, Short value2) {
            addCriterion("va_side not between", value1, value2, "vaSide");
            return (Criteria) this;
        }

        public Criteria andVaSizeIsNull() {
            addCriterion("va_size is null");
            return (Criteria) this;
        }

        public Criteria andVaSizeIsNotNull() {
            addCriterion("va_size is not null");
            return (Criteria) this;
        }

        public Criteria andVaSizeEqualTo(Short value) {
            addCriterion("va_size =", value, "vaSize");
            return (Criteria) this;
        }

        public Criteria andVaSizeNotEqualTo(Short value) {
            addCriterion("va_size <>", value, "vaSize");
            return (Criteria) this;
        }

        public Criteria andVaSizeGreaterThan(Short value) {
            addCriterion("va_size >", value, "vaSize");
            return (Criteria) this;
        }

        public Criteria andVaSizeGreaterThanOrEqualTo(Short value) {
            addCriterion("va_size >=", value, "vaSize");
            return (Criteria) this;
        }

        public Criteria andVaSizeLessThan(Short value) {
            addCriterion("va_size <", value, "vaSize");
            return (Criteria) this;
        }

        public Criteria andVaSizeLessThanOrEqualTo(Short value) {
            addCriterion("va_size <=", value, "vaSize");
            return (Criteria) this;
        }

        public Criteria andVaSizeIn(List<Short> values) {
            addCriterion("va_size in", values, "vaSize");
            return (Criteria) this;
        }

        public Criteria andVaSizeNotIn(List<Short> values) {
            addCriterion("va_size not in", values, "vaSize");
            return (Criteria) this;
        }

        public Criteria andVaSizeBetween(Short value1, Short value2) {
            addCriterion("va_size between", value1, value2, "vaSize");
            return (Criteria) this;
        }

        public Criteria andVaSizeNotBetween(Short value1, Short value2) {
            addCriterion("va_size not between", value1, value2, "vaSize");
            return (Criteria) this;
        }

        public Criteria andVaSpeedIsNull() {
            addCriterion("va_speed is null");
            return (Criteria) this;
        }

        public Criteria andVaSpeedIsNotNull() {
            addCriterion("va_speed is not null");
            return (Criteria) this;
        }

        public Criteria andVaSpeedEqualTo(Short value) {
            addCriterion("va_speed =", value, "vaSpeed");
            return (Criteria) this;
        }

        public Criteria andVaSpeedNotEqualTo(Short value) {
            addCriterion("va_speed <>", value, "vaSpeed");
            return (Criteria) this;
        }

        public Criteria andVaSpeedGreaterThan(Short value) {
            addCriterion("va_speed >", value, "vaSpeed");
            return (Criteria) this;
        }

        public Criteria andVaSpeedGreaterThanOrEqualTo(Short value) {
            addCriterion("va_speed >=", value, "vaSpeed");
            return (Criteria) this;
        }

        public Criteria andVaSpeedLessThan(Short value) {
            addCriterion("va_speed <", value, "vaSpeed");
            return (Criteria) this;
        }

        public Criteria andVaSpeedLessThanOrEqualTo(Short value) {
            addCriterion("va_speed <=", value, "vaSpeed");
            return (Criteria) this;
        }

        public Criteria andVaSpeedIn(List<Short> values) {
            addCriterion("va_speed in", values, "vaSpeed");
            return (Criteria) this;
        }

        public Criteria andVaSpeedNotIn(List<Short> values) {
            addCriterion("va_speed not in", values, "vaSpeed");
            return (Criteria) this;
        }

        public Criteria andVaSpeedBetween(Short value1, Short value2) {
            addCriterion("va_speed between", value1, value2, "vaSpeed");
            return (Criteria) this;
        }

        public Criteria andVaSpeedNotBetween(Short value1, Short value2) {
            addCriterion("va_speed not between", value1, value2, "vaSpeed");
            return (Criteria) this;
        }

        public Criteria andVaDirectionIsNull() {
            addCriterion("va_direction is null");
            return (Criteria) this;
        }

        public Criteria andVaDirectionIsNotNull() {
            addCriterion("va_direction is not null");
            return (Criteria) this;
        }

        public Criteria andVaDirectionEqualTo(Short value) {
            addCriterion("va_direction =", value, "vaDirection");
            return (Criteria) this;
        }

        public Criteria andVaDirectionNotEqualTo(Short value) {
            addCriterion("va_direction <>", value, "vaDirection");
            return (Criteria) this;
        }

        public Criteria andVaDirectionGreaterThan(Short value) {
            addCriterion("va_direction >", value, "vaDirection");
            return (Criteria) this;
        }

        public Criteria andVaDirectionGreaterThanOrEqualTo(Short value) {
            addCriterion("va_direction >=", value, "vaDirection");
            return (Criteria) this;
        }

        public Criteria andVaDirectionLessThan(Short value) {
            addCriterion("va_direction <", value, "vaDirection");
            return (Criteria) this;
        }

        public Criteria andVaDirectionLessThanOrEqualTo(Short value) {
            addCriterion("va_direction <=", value, "vaDirection");
            return (Criteria) this;
        }

        public Criteria andVaDirectionIn(List<Short> values) {
            addCriterion("va_direction in", values, "vaDirection");
            return (Criteria) this;
        }

        public Criteria andVaDirectionNotIn(List<Short> values) {
            addCriterion("va_direction not in", values, "vaDirection");
            return (Criteria) this;
        }

        public Criteria andVaDirectionBetween(Short value1, Short value2) {
            addCriterion("va_direction between", value1, value2, "vaDirection");
            return (Criteria) this;
        }

        public Criteria andVaDirectionNotBetween(Short value1, Short value2) {
            addCriterion("va_direction not between", value1, value2, "vaDirection");
            return (Criteria) this;
        }

        public Criteria andVaLaneIsNull() {
            addCriterion("va_lane is null");
            return (Criteria) this;
        }

        public Criteria andVaLaneIsNotNull() {
            addCriterion("va_lane is not null");
            return (Criteria) this;
        }

        public Criteria andVaLaneEqualTo(String value) {
            addCriterion("va_lane =", value, "vaLane");
            return (Criteria) this;
        }

        public Criteria andVaLaneNotEqualTo(String value) {
            addCriterion("va_lane <>", value, "vaLane");
            return (Criteria) this;
        }

        public Criteria andVaLaneGreaterThan(String value) {
            addCriterion("va_lane >", value, "vaLane");
            return (Criteria) this;
        }

        public Criteria andVaLaneGreaterThanOrEqualTo(String value) {
            addCriterion("va_lane >=", value, "vaLane");
            return (Criteria) this;
        }

        public Criteria andVaLaneLessThan(String value) {
            addCriterion("va_lane <", value, "vaLane");
            return (Criteria) this;
        }

        public Criteria andVaLaneLessThanOrEqualTo(String value) {
            addCriterion("va_lane <=", value, "vaLane");
            return (Criteria) this;
        }

        public Criteria andVaLaneLike(String value) {
            addCriterion("va_lane like", value, "vaLane");
            return (Criteria) this;
        }

        public Criteria andVaLaneNotLike(String value) {
            addCriterion("va_lane not like", value, "vaLane");
            return (Criteria) this;
        }

        public Criteria andVaLaneIn(List<String> values) {
            addCriterion("va_lane in", values, "vaLane");
            return (Criteria) this;
        }

        public Criteria andVaLaneNotIn(List<String> values) {
            addCriterion("va_lane not in", values, "vaLane");
            return (Criteria) this;
        }

        public Criteria andVaLaneBetween(String value1, String value2) {
            addCriterion("va_lane between", value1, value2, "vaLane");
            return (Criteria) this;
        }

        public Criteria andVaLaneNotBetween(String value1, String value2) {
            addCriterion("va_lane not between", value1, value2, "vaLane");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdIsNull() {
            addCriterion("va_face_id is null");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdIsNotNull() {
            addCriterion("va_face_id is not null");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdEqualTo(String value) {
            addCriterion("va_face_id =", value, "vaFaceId");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdNotEqualTo(String value) {
            addCriterion("va_face_id <>", value, "vaFaceId");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdGreaterThan(String value) {
            addCriterion("va_face_id >", value, "vaFaceId");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdGreaterThanOrEqualTo(String value) {
            addCriterion("va_face_id >=", value, "vaFaceId");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdLessThan(String value) {
            addCriterion("va_face_id <", value, "vaFaceId");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdLessThanOrEqualTo(String value) {
            addCriterion("va_face_id <=", value, "vaFaceId");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdLike(String value) {
            addCriterion("va_face_id like", value, "vaFaceId");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdNotLike(String value) {
            addCriterion("va_face_id not like", value, "vaFaceId");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdIn(List<String> values) {
            addCriterion("va_face_id in", values, "vaFaceId");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdNotIn(List<String> values) {
            addCriterion("va_face_id not in", values, "vaFaceId");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdBetween(String value1, String value2) {
            addCriterion("va_face_id between", value1, value2, "vaFaceId");
            return (Criteria) this;
        }

        public Criteria andVaFaceIdNotBetween(String value1, String value2) {
            addCriterion("va_face_id not between", value1, value2, "vaFaceId");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeIsNull() {
            addCriterion("va_oil_type is null");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeIsNotNull() {
            addCriterion("va_oil_type is not null");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeEqualTo(String value) {
            addCriterion("va_oil_type =", value, "vaOilType");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeNotEqualTo(String value) {
            addCriterion("va_oil_type <>", value, "vaOilType");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeGreaterThan(String value) {
            addCriterion("va_oil_type >", value, "vaOilType");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeGreaterThanOrEqualTo(String value) {
            addCriterion("va_oil_type >=", value, "vaOilType");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeLessThan(String value) {
            addCriterion("va_oil_type <", value, "vaOilType");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeLessThanOrEqualTo(String value) {
            addCriterion("va_oil_type <=", value, "vaOilType");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeLike(String value) {
            addCriterion("va_oil_type like", value, "vaOilType");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeNotLike(String value) {
            addCriterion("va_oil_type not like", value, "vaOilType");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeIn(List<String> values) {
            addCriterion("va_oil_type in", values, "vaOilType");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeNotIn(List<String> values) {
            addCriterion("va_oil_type not in", values, "vaOilType");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeBetween(String value1, String value2) {
            addCriterion("va_oil_type between", value1, value2, "vaOilType");
            return (Criteria) this;
        }

        public Criteria andVaOilTypeNotBetween(String value1, String value2) {
            addCriterion("va_oil_type not between", value1, value2, "vaOilType");
            return (Criteria) this;
        }

        public Criteria andVaOilAmountIsNull() {
            addCriterion("va_oil_amount is null");
            return (Criteria) this;
        }

        public Criteria andVaOilAmountIsNotNull() {
            addCriterion("va_oil_amount is not null");
            return (Criteria) this;
        }

        public Criteria andVaOilAmountEqualTo(Float value) {
            addCriterion("va_oil_amount =", value, "vaOilAmount");
            return (Criteria) this;
        }

        public Criteria andVaOilAmountNotEqualTo(Float value) {
            addCriterion("va_oil_amount <>", value, "vaOilAmount");
            return (Criteria) this;
        }

        public Criteria andVaOilAmountGreaterThan(Float value) {
            addCriterion("va_oil_amount >", value, "vaOilAmount");
            return (Criteria) this;
        }

        public Criteria andVaOilAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("va_oil_amount >=", value, "vaOilAmount");
            return (Criteria) this;
        }

        public Criteria andVaOilAmountLessThan(Float value) {
            addCriterion("va_oil_amount <", value, "vaOilAmount");
            return (Criteria) this;
        }

        public Criteria andVaOilAmountLessThanOrEqualTo(Float value) {
            addCriterion("va_oil_amount <=", value, "vaOilAmount");
            return (Criteria) this;
        }

        public Criteria andVaOilAmountIn(List<Float> values) {
            addCriterion("va_oil_amount in", values, "vaOilAmount");
            return (Criteria) this;
        }

        public Criteria andVaOilAmountNotIn(List<Float> values) {
            addCriterion("va_oil_amount not in", values, "vaOilAmount");
            return (Criteria) this;
        }

        public Criteria andVaOilAmountBetween(Float value1, Float value2) {
            addCriterion("va_oil_amount between", value1, value2, "vaOilAmount");
            return (Criteria) this;
        }

        public Criteria andVaOilAmountNotBetween(Float value1, Float value2) {
            addCriterion("va_oil_amount not between", value1, value2, "vaOilAmount");
            return (Criteria) this;
        }

        public Criteria andVbUtsIsNull() {
            addCriterion("vb_uts is null");
            return (Criteria) this;
        }

        public Criteria andVbUtsIsNotNull() {
            addCriterion("vb_uts is not null");
            return (Criteria) this;
        }

        public Criteria andVbUtsEqualTo(Date value) {
            addCriterion("vb_uts =", value, "vbUts");
            return (Criteria) this;
        }

        public Criteria andVbUtsNotEqualTo(Date value) {
            addCriterion("vb_uts <>", value, "vbUts");
            return (Criteria) this;
        }

        public Criteria andVbUtsGreaterThan(Date value) {
            addCriterion("vb_uts >", value, "vbUts");
            return (Criteria) this;
        }

        public Criteria andVbUtsGreaterThanOrEqualTo(Date value) {
            addCriterion("vb_uts >=", value, "vbUts");
            return (Criteria) this;
        }

        public Criteria andVbUtsLessThan(Date value) {
            addCriterion("vb_uts <", value, "vbUts");
            return (Criteria) this;
        }

        public Criteria andVbUtsLessThanOrEqualTo(Date value) {
            addCriterion("vb_uts <=", value, "vbUts");
            return (Criteria) this;
        }

        public Criteria andVbUtsIn(List<Date> values) {
            addCriterion("vb_uts in", values, "vbUts");
            return (Criteria) this;
        }

        public Criteria andVbUtsNotIn(List<Date> values) {
            addCriterion("vb_uts not in", values, "vbUts");
            return (Criteria) this;
        }

        public Criteria andVbUtsBetween(Date value1, Date value2) {
            addCriterion("vb_uts between", value1, value2, "vbUts");
            return (Criteria) this;
        }

        public Criteria andVbUtsNotBetween(Date value1, Date value2) {
            addCriterion("vb_uts not between", value1, value2, "vbUts");
            return (Criteria) this;
        }

        public Criteria andVbTsIsNull() {
            addCriterion("vb_ts is null");
            return (Criteria) this;
        }

        public Criteria andVbTsIsNotNull() {
            addCriterion("vb_ts is not null");
            return (Criteria) this;
        }

        public Criteria andVbTsEqualTo(Long value) {
            addCriterion("vb_ts =", value, "vbTs");
            return (Criteria) this;
        }

        public Criteria andVbTsNotEqualTo(Long value) {
            addCriterion("vb_ts <>", value, "vbTs");
            return (Criteria) this;
        }

        public Criteria andVbTsGreaterThan(Long value) {
            addCriterion("vb_ts >", value, "vbTs");
            return (Criteria) this;
        }

        public Criteria andVbTsGreaterThanOrEqualTo(Long value) {
            addCriterion("vb_ts >=", value, "vbTs");
            return (Criteria) this;
        }

        public Criteria andVbTsLessThan(Long value) {
            addCriterion("vb_ts <", value, "vbTs");
            return (Criteria) this;
        }

        public Criteria andVbTsLessThanOrEqualTo(Long value) {
            addCriterion("vb_ts <=", value, "vbTs");
            return (Criteria) this;
        }

        public Criteria andVbTsIn(List<Long> values) {
            addCriterion("vb_ts in", values, "vbTs");
            return (Criteria) this;
        }

        public Criteria andVbTsNotIn(List<Long> values) {
            addCriterion("vb_ts not in", values, "vbTs");
            return (Criteria) this;
        }

        public Criteria andVbTsBetween(Long value1, Long value2) {
            addCriterion("vb_ts between", value1, value2, "vbTs");
            return (Criteria) this;
        }

        public Criteria andVbTsNotBetween(Long value1, Long value2) {
            addCriterion("vb_ts not between", value1, value2, "vbTs");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdIsNull() {
            addCriterion("vb_vehicle_id is null");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdIsNotNull() {
            addCriterion("vb_vehicle_id is not null");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdEqualTo(String value) {
            addCriterion("vb_vehicle_id =", value, "vbVehicleId");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdNotEqualTo(String value) {
            addCriterion("vb_vehicle_id <>", value, "vbVehicleId");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdGreaterThan(String value) {
            addCriterion("vb_vehicle_id >", value, "vbVehicleId");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdGreaterThanOrEqualTo(String value) {
            addCriterion("vb_vehicle_id >=", value, "vbVehicleId");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdLessThan(String value) {
            addCriterion("vb_vehicle_id <", value, "vbVehicleId");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdLessThanOrEqualTo(String value) {
            addCriterion("vb_vehicle_id <=", value, "vbVehicleId");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdLike(String value) {
            addCriterion("vb_vehicle_id like", value, "vbVehicleId");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdNotLike(String value) {
            addCriterion("vb_vehicle_id not like", value, "vbVehicleId");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdIn(List<String> values) {
            addCriterion("vb_vehicle_id in", values, "vbVehicleId");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdNotIn(List<String> values) {
            addCriterion("vb_vehicle_id not in", values, "vbVehicleId");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdBetween(String value1, String value2) {
            addCriterion("vb_vehicle_id between", value1, value2, "vbVehicleId");
            return (Criteria) this;
        }

        public Criteria andVbVehicleIdNotBetween(String value1, String value2) {
            addCriterion("vb_vehicle_id not between", value1, value2, "vbVehicleId");
            return (Criteria) this;
        }

        public Criteria andVbImageIdIsNull() {
            addCriterion("vb_image_id is null");
            return (Criteria) this;
        }

        public Criteria andVbImageIdIsNotNull() {
            addCriterion("vb_image_id is not null");
            return (Criteria) this;
        }

        public Criteria andVbImageIdEqualTo(String value) {
            addCriterion("vb_image_id =", value, "vbImageId");
            return (Criteria) this;
        }

        public Criteria andVbImageIdNotEqualTo(String value) {
            addCriterion("vb_image_id <>", value, "vbImageId");
            return (Criteria) this;
        }

        public Criteria andVbImageIdGreaterThan(String value) {
            addCriterion("vb_image_id >", value, "vbImageId");
            return (Criteria) this;
        }

        public Criteria andVbImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("vb_image_id >=", value, "vbImageId");
            return (Criteria) this;
        }

        public Criteria andVbImageIdLessThan(String value) {
            addCriterion("vb_image_id <", value, "vbImageId");
            return (Criteria) this;
        }

        public Criteria andVbImageIdLessThanOrEqualTo(String value) {
            addCriterion("vb_image_id <=", value, "vbImageId");
            return (Criteria) this;
        }

        public Criteria andVbImageIdLike(String value) {
            addCriterion("vb_image_id like", value, "vbImageId");
            return (Criteria) this;
        }

        public Criteria andVbImageIdNotLike(String value) {
            addCriterion("vb_image_id not like", value, "vbImageId");
            return (Criteria) this;
        }

        public Criteria andVbImageIdIn(List<String> values) {
            addCriterion("vb_image_id in", values, "vbImageId");
            return (Criteria) this;
        }

        public Criteria andVbImageIdNotIn(List<String> values) {
            addCriterion("vb_image_id not in", values, "vbImageId");
            return (Criteria) this;
        }

        public Criteria andVbImageIdBetween(String value1, String value2) {
            addCriterion("vb_image_id between", value1, value2, "vbImageId");
            return (Criteria) this;
        }

        public Criteria andVbImageIdNotBetween(String value1, String value2) {
            addCriterion("vb_image_id not between", value1, value2, "vbImageId");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdIsNull() {
            addCriterion("vb_repo_id is null");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdIsNotNull() {
            addCriterion("vb_repo_id is not null");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdEqualTo(String value) {
            addCriterion("vb_repo_id =", value, "vbRepoId");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdNotEqualTo(String value) {
            addCriterion("vb_repo_id <>", value, "vbRepoId");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdGreaterThan(String value) {
            addCriterion("vb_repo_id >", value, "vbRepoId");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdGreaterThanOrEqualTo(String value) {
            addCriterion("vb_repo_id >=", value, "vbRepoId");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdLessThan(String value) {
            addCriterion("vb_repo_id <", value, "vbRepoId");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdLessThanOrEqualTo(String value) {
            addCriterion("vb_repo_id <=", value, "vbRepoId");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdLike(String value) {
            addCriterion("vb_repo_id like", value, "vbRepoId");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdNotLike(String value) {
            addCriterion("vb_repo_id not like", value, "vbRepoId");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdIn(List<String> values) {
            addCriterion("vb_repo_id in", values, "vbRepoId");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdNotIn(List<String> values) {
            addCriterion("vb_repo_id not in", values, "vbRepoId");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdBetween(String value1, String value2) {
            addCriterion("vb_repo_id between", value1, value2, "vbRepoId");
            return (Criteria) this;
        }

        public Criteria andVbRepoIdNotBetween(String value1, String value2) {
            addCriterion("vb_repo_id not between", value1, value2, "vbRepoId");
            return (Criteria) this;
        }

        public Criteria andVbColorIdIsNull() {
            addCriterion("vb_color_id is null");
            return (Criteria) this;
        }

        public Criteria andVbColorIdIsNotNull() {
            addCriterion("vb_color_id is not null");
            return (Criteria) this;
        }

        public Criteria andVbColorIdEqualTo(Short value) {
            addCriterion("vb_color_id =", value, "vbColorId");
            return (Criteria) this;
        }

        public Criteria andVbColorIdNotEqualTo(Short value) {
            addCriterion("vb_color_id <>", value, "vbColorId");
            return (Criteria) this;
        }

        public Criteria andVbColorIdGreaterThan(Short value) {
            addCriterion("vb_color_id >", value, "vbColorId");
            return (Criteria) this;
        }

        public Criteria andVbColorIdGreaterThanOrEqualTo(Short value) {
            addCriterion("vb_color_id >=", value, "vbColorId");
            return (Criteria) this;
        }

        public Criteria andVbColorIdLessThan(Short value) {
            addCriterion("vb_color_id <", value, "vbColorId");
            return (Criteria) this;
        }

        public Criteria andVbColorIdLessThanOrEqualTo(Short value) {
            addCriterion("vb_color_id <=", value, "vbColorId");
            return (Criteria) this;
        }

        public Criteria andVbColorIdIn(List<Short> values) {
            addCriterion("vb_color_id in", values, "vbColorId");
            return (Criteria) this;
        }

        public Criteria andVbColorIdNotIn(List<Short> values) {
            addCriterion("vb_color_id not in", values, "vbColorId");
            return (Criteria) this;
        }

        public Criteria andVbColorIdBetween(Short value1, Short value2) {
            addCriterion("vb_color_id between", value1, value2, "vbColorId");
            return (Criteria) this;
        }

        public Criteria andVbColorIdNotBetween(Short value1, Short value2) {
            addCriterion("vb_color_id not between", value1, value2, "vbColorId");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdIsNull() {
            addCriterion("vb_sensor_id is null");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdIsNotNull() {
            addCriterion("vb_sensor_id is not null");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdEqualTo(String value) {
            addCriterion("vb_sensor_id =", value, "vbSensorId");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdNotEqualTo(String value) {
            addCriterion("vb_sensor_id <>", value, "vbSensorId");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdGreaterThan(String value) {
            addCriterion("vb_sensor_id >", value, "vbSensorId");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdGreaterThanOrEqualTo(String value) {
            addCriterion("vb_sensor_id >=", value, "vbSensorId");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdLessThan(String value) {
            addCriterion("vb_sensor_id <", value, "vbSensorId");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdLessThanOrEqualTo(String value) {
            addCriterion("vb_sensor_id <=", value, "vbSensorId");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdLike(String value) {
            addCriterion("vb_sensor_id like", value, "vbSensorId");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdNotLike(String value) {
            addCriterion("vb_sensor_id not like", value, "vbSensorId");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdIn(List<String> values) {
            addCriterion("vb_sensor_id in", values, "vbSensorId");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdNotIn(List<String> values) {
            addCriterion("vb_sensor_id not in", values, "vbSensorId");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdBetween(String value1, String value2) {
            addCriterion("vb_sensor_id between", value1, value2, "vbSensorId");
            return (Criteria) this;
        }

        public Criteria andVbSensorIdNotBetween(String value1, String value2) {
            addCriterion("vb_sensor_id not between", value1, value2, "vbSensorId");
            return (Criteria) this;
        }

        public Criteria andVbConfidenceIsNull() {
            addCriterion("vb_confidence is null");
            return (Criteria) this;
        }

        public Criteria andVbConfidenceIsNotNull() {
            addCriterion("vb_confidence is not null");
            return (Criteria) this;
        }

        public Criteria andVbConfidenceEqualTo(Float value) {
            addCriterion("vb_confidence =", value, "vbConfidence");
            return (Criteria) this;
        }

        public Criteria andVbConfidenceNotEqualTo(Float value) {
            addCriterion("vb_confidence <>", value, "vbConfidence");
            return (Criteria) this;
        }

        public Criteria andVbConfidenceGreaterThan(Float value) {
            addCriterion("vb_confidence >", value, "vbConfidence");
            return (Criteria) this;
        }

        public Criteria andVbConfidenceGreaterThanOrEqualTo(Float value) {
            addCriterion("vb_confidence >=", value, "vbConfidence");
            return (Criteria) this;
        }

        public Criteria andVbConfidenceLessThan(Float value) {
            addCriterion("vb_confidence <", value, "vbConfidence");
            return (Criteria) this;
        }

        public Criteria andVbConfidenceLessThanOrEqualTo(Float value) {
            addCriterion("vb_confidence <=", value, "vbConfidence");
            return (Criteria) this;
        }

        public Criteria andVbConfidenceIn(List<Float> values) {
            addCriterion("vb_confidence in", values, "vbConfidence");
            return (Criteria) this;
        }

        public Criteria andVbConfidenceNotIn(List<Float> values) {
            addCriterion("vb_confidence not in", values, "vbConfidence");
            return (Criteria) this;
        }

        public Criteria andVbConfidenceBetween(Float value1, Float value2) {
            addCriterion("vb_confidence between", value1, value2, "vbConfidence");
            return (Criteria) this;
        }

        public Criteria andVbConfidenceNotBetween(Float value1, Float value2) {
            addCriterion("vb_confidence not between", value1, value2, "vbConfidence");
            return (Criteria) this;
        }

        public Criteria andVbBrandIdIsNull() {
            addCriterion("vb_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andVbBrandIdIsNotNull() {
            addCriterion("vb_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andVbBrandIdEqualTo(Short value) {
            addCriterion("vb_brand_id =", value, "vbBrandId");
            return (Criteria) this;
        }

        public Criteria andVbBrandIdNotEqualTo(Short value) {
            addCriterion("vb_brand_id <>", value, "vbBrandId");
            return (Criteria) this;
        }

        public Criteria andVbBrandIdGreaterThan(Short value) {
            addCriterion("vb_brand_id >", value, "vbBrandId");
            return (Criteria) this;
        }

        public Criteria andVbBrandIdGreaterThanOrEqualTo(Short value) {
            addCriterion("vb_brand_id >=", value, "vbBrandId");
            return (Criteria) this;
        }

        public Criteria andVbBrandIdLessThan(Short value) {
            addCriterion("vb_brand_id <", value, "vbBrandId");
            return (Criteria) this;
        }

        public Criteria andVbBrandIdLessThanOrEqualTo(Short value) {
            addCriterion("vb_brand_id <=", value, "vbBrandId");
            return (Criteria) this;
        }

        public Criteria andVbBrandIdIn(List<Short> values) {
            addCriterion("vb_brand_id in", values, "vbBrandId");
            return (Criteria) this;
        }

        public Criteria andVbBrandIdNotIn(List<Short> values) {
            addCriterion("vb_brand_id not in", values, "vbBrandId");
            return (Criteria) this;
        }

        public Criteria andVbBrandIdBetween(Short value1, Short value2) {
            addCriterion("vb_brand_id between", value1, value2, "vbBrandId");
            return (Criteria) this;
        }

        public Criteria andVbBrandIdNotBetween(Short value1, Short value2) {
            addCriterion("vb_brand_id not between", value1, value2, "vbBrandId");
            return (Criteria) this;
        }

        public Criteria andVbSubBrandIdIsNull() {
            addCriterion("vb_sub_brand_id is null");
            return (Criteria) this;
        }

        public Criteria andVbSubBrandIdIsNotNull() {
            addCriterion("vb_sub_brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andVbSubBrandIdEqualTo(Short value) {
            addCriterion("vb_sub_brand_id =", value, "vbSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVbSubBrandIdNotEqualTo(Short value) {
            addCriterion("vb_sub_brand_id <>", value, "vbSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVbSubBrandIdGreaterThan(Short value) {
            addCriterion("vb_sub_brand_id >", value, "vbSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVbSubBrandIdGreaterThanOrEqualTo(Short value) {
            addCriterion("vb_sub_brand_id >=", value, "vbSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVbSubBrandIdLessThan(Short value) {
            addCriterion("vb_sub_brand_id <", value, "vbSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVbSubBrandIdLessThanOrEqualTo(Short value) {
            addCriterion("vb_sub_brand_id <=", value, "vbSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVbSubBrandIdIn(List<Short> values) {
            addCriterion("vb_sub_brand_id in", values, "vbSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVbSubBrandIdNotIn(List<Short> values) {
            addCriterion("vb_sub_brand_id not in", values, "vbSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVbSubBrandIdBetween(Short value1, Short value2) {
            addCriterion("vb_sub_brand_id between", value1, value2, "vbSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVbSubBrandIdNotBetween(Short value1, Short value2) {
            addCriterion("vb_sub_brand_id not between", value1, value2, "vbSubBrandId");
            return (Criteria) this;
        }

        public Criteria andVbModelYearIdIsNull() {
            addCriterion("vb_model_year_id is null");
            return (Criteria) this;
        }

        public Criteria andVbModelYearIdIsNotNull() {
            addCriterion("vb_model_year_id is not null");
            return (Criteria) this;
        }

        public Criteria andVbModelYearIdEqualTo(Short value) {
            addCriterion("vb_model_year_id =", value, "vbModelYearId");
            return (Criteria) this;
        }

        public Criteria andVbModelYearIdNotEqualTo(Short value) {
            addCriterion("vb_model_year_id <>", value, "vbModelYearId");
            return (Criteria) this;
        }

        public Criteria andVbModelYearIdGreaterThan(Short value) {
            addCriterion("vb_model_year_id >", value, "vbModelYearId");
            return (Criteria) this;
        }

        public Criteria andVbModelYearIdGreaterThanOrEqualTo(Short value) {
            addCriterion("vb_model_year_id >=", value, "vbModelYearId");
            return (Criteria) this;
        }

        public Criteria andVbModelYearIdLessThan(Short value) {
            addCriterion("vb_model_year_id <", value, "vbModelYearId");
            return (Criteria) this;
        }

        public Criteria andVbModelYearIdLessThanOrEqualTo(Short value) {
            addCriterion("vb_model_year_id <=", value, "vbModelYearId");
            return (Criteria) this;
        }

        public Criteria andVbModelYearIdIn(List<Short> values) {
            addCriterion("vb_model_year_id in", values, "vbModelYearId");
            return (Criteria) this;
        }

        public Criteria andVbModelYearIdNotIn(List<Short> values) {
            addCriterion("vb_model_year_id not in", values, "vbModelYearId");
            return (Criteria) this;
        }

        public Criteria andVbModelYearIdBetween(Short value1, Short value2) {
            addCriterion("vb_model_year_id between", value1, value2, "vbModelYearId");
            return (Criteria) this;
        }

        public Criteria andVbModelYearIdNotBetween(Short value1, Short value2) {
            addCriterion("vb_model_year_id not between", value1, value2, "vbModelYearId");
            return (Criteria) this;
        }

        public Criteria andVbTypeIdIsNull() {
            addCriterion("vb_type_id is null");
            return (Criteria) this;
        }

        public Criteria andVbTypeIdIsNotNull() {
            addCriterion("vb_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andVbTypeIdEqualTo(Short value) {
            addCriterion("vb_type_id =", value, "vbTypeId");
            return (Criteria) this;
        }

        public Criteria andVbTypeIdNotEqualTo(Short value) {
            addCriterion("vb_type_id <>", value, "vbTypeId");
            return (Criteria) this;
        }

        public Criteria andVbTypeIdGreaterThan(Short value) {
            addCriterion("vb_type_id >", value, "vbTypeId");
            return (Criteria) this;
        }

        public Criteria andVbTypeIdGreaterThanOrEqualTo(Short value) {
            addCriterion("vb_type_id >=", value, "vbTypeId");
            return (Criteria) this;
        }

        public Criteria andVbTypeIdLessThan(Short value) {
            addCriterion("vb_type_id <", value, "vbTypeId");
            return (Criteria) this;
        }

        public Criteria andVbTypeIdLessThanOrEqualTo(Short value) {
            addCriterion("vb_type_id <=", value, "vbTypeId");
            return (Criteria) this;
        }

        public Criteria andVbTypeIdIn(List<Short> values) {
            addCriterion("vb_type_id in", values, "vbTypeId");
            return (Criteria) this;
        }

        public Criteria andVbTypeIdNotIn(List<Short> values) {
            addCriterion("vb_type_id not in", values, "vbTypeId");
            return (Criteria) this;
        }

        public Criteria andVbTypeIdBetween(Short value1, Short value2) {
            addCriterion("vb_type_id between", value1, value2, "vbTypeId");
            return (Criteria) this;
        }

        public Criteria andVbTypeIdNotBetween(Short value1, Short value2) {
            addCriterion("vb_type_id not between", value1, value2, "vbTypeId");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextIsNull() {
            addCriterion("vb_plate_text is null");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextIsNotNull() {
            addCriterion("vb_plate_text is not null");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextEqualTo(String value) {
            addCriterion("vb_plate_text =", value, "vbPlateText");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextNotEqualTo(String value) {
            addCriterion("vb_plate_text <>", value, "vbPlateText");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextGreaterThan(String value) {
            addCriterion("vb_plate_text >", value, "vbPlateText");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextGreaterThanOrEqualTo(String value) {
            addCriterion("vb_plate_text >=", value, "vbPlateText");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextLessThan(String value) {
            addCriterion("vb_plate_text <", value, "vbPlateText");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextLessThanOrEqualTo(String value) {
            addCriterion("vb_plate_text <=", value, "vbPlateText");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextLike(String value) {
            addCriterion("vb_plate_text like", value, "vbPlateText");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextNotLike(String value) {
            addCriterion("vb_plate_text not like", value, "vbPlateText");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextIn(List<String> values) {
            addCriterion("vb_plate_text in", values, "vbPlateText");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextNotIn(List<String> values) {
            addCriterion("vb_plate_text not in", values, "vbPlateText");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextBetween(String value1, String value2) {
            addCriterion("vb_plate_text between", value1, value2, "vbPlateText");
            return (Criteria) this;
        }

        public Criteria andVbPlateTextNotBetween(String value1, String value2) {
            addCriterion("vb_plate_text not between", value1, value2, "vbPlateText");
            return (Criteria) this;
        }

        public Criteria andVbPlateTypeIdIsNull() {
            addCriterion("vb_plate_type_id is null");
            return (Criteria) this;
        }

        public Criteria andVbPlateTypeIdIsNotNull() {
            addCriterion("vb_plate_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andVbPlateTypeIdEqualTo(Short value) {
            addCriterion("vb_plate_type_id =", value, "vbPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVbPlateTypeIdNotEqualTo(Short value) {
            addCriterion("vb_plate_type_id <>", value, "vbPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVbPlateTypeIdGreaterThan(Short value) {
            addCriterion("vb_plate_type_id >", value, "vbPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVbPlateTypeIdGreaterThanOrEqualTo(Short value) {
            addCriterion("vb_plate_type_id >=", value, "vbPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVbPlateTypeIdLessThan(Short value) {
            addCriterion("vb_plate_type_id <", value, "vbPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVbPlateTypeIdLessThanOrEqualTo(Short value) {
            addCriterion("vb_plate_type_id <=", value, "vbPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVbPlateTypeIdIn(List<Short> values) {
            addCriterion("vb_plate_type_id in", values, "vbPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVbPlateTypeIdNotIn(List<Short> values) {
            addCriterion("vb_plate_type_id not in", values, "vbPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVbPlateTypeIdBetween(Short value1, Short value2) {
            addCriterion("vb_plate_type_id between", value1, value2, "vbPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVbPlateTypeIdNotBetween(Short value1, Short value2) {
            addCriterion("vb_plate_type_id not between", value1, value2, "vbPlateTypeId");
            return (Criteria) this;
        }

        public Criteria andVbPlateColorIdIsNull() {
            addCriterion("vb_plate_color_id is null");
            return (Criteria) this;
        }

        public Criteria andVbPlateColorIdIsNotNull() {
            addCriterion("vb_plate_color_id is not null");
            return (Criteria) this;
        }

        public Criteria andVbPlateColorIdEqualTo(Short value) {
            addCriterion("vb_plate_color_id =", value, "vbPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVbPlateColorIdNotEqualTo(Short value) {
            addCriterion("vb_plate_color_id <>", value, "vbPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVbPlateColorIdGreaterThan(Short value) {
            addCriterion("vb_plate_color_id >", value, "vbPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVbPlateColorIdGreaterThanOrEqualTo(Short value) {
            addCriterion("vb_plate_color_id >=", value, "vbPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVbPlateColorIdLessThan(Short value) {
            addCriterion("vb_plate_color_id <", value, "vbPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVbPlateColorIdLessThanOrEqualTo(Short value) {
            addCriterion("vb_plate_color_id <=", value, "vbPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVbPlateColorIdIn(List<Short> values) {
            addCriterion("vb_plate_color_id in", values, "vbPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVbPlateColorIdNotIn(List<Short> values) {
            addCriterion("vb_plate_color_id not in", values, "vbPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVbPlateColorIdBetween(Short value1, Short value2) {
            addCriterion("vb_plate_color_id between", value1, value2, "vbPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVbPlateColorIdNotBetween(Short value1, Short value2) {
            addCriterion("vb_plate_color_id not between", value1, value2, "vbPlateColorId");
            return (Criteria) this;
        }

        public Criteria andVbSideIsNull() {
            addCriterion("vb_side is null");
            return (Criteria) this;
        }

        public Criteria andVbSideIsNotNull() {
            addCriterion("vb_side is not null");
            return (Criteria) this;
        }

        public Criteria andVbSideEqualTo(Short value) {
            addCriterion("vb_side =", value, "vbSide");
            return (Criteria) this;
        }

        public Criteria andVbSideNotEqualTo(Short value) {
            addCriterion("vb_side <>", value, "vbSide");
            return (Criteria) this;
        }

        public Criteria andVbSideGreaterThan(Short value) {
            addCriterion("vb_side >", value, "vbSide");
            return (Criteria) this;
        }

        public Criteria andVbSideGreaterThanOrEqualTo(Short value) {
            addCriterion("vb_side >=", value, "vbSide");
            return (Criteria) this;
        }

        public Criteria andVbSideLessThan(Short value) {
            addCriterion("vb_side <", value, "vbSide");
            return (Criteria) this;
        }

        public Criteria andVbSideLessThanOrEqualTo(Short value) {
            addCriterion("vb_side <=", value, "vbSide");
            return (Criteria) this;
        }

        public Criteria andVbSideIn(List<Short> values) {
            addCriterion("vb_side in", values, "vbSide");
            return (Criteria) this;
        }

        public Criteria andVbSideNotIn(List<Short> values) {
            addCriterion("vb_side not in", values, "vbSide");
            return (Criteria) this;
        }

        public Criteria andVbSideBetween(Short value1, Short value2) {
            addCriterion("vb_side between", value1, value2, "vbSide");
            return (Criteria) this;
        }

        public Criteria andVbSideNotBetween(Short value1, Short value2) {
            addCriterion("vb_side not between", value1, value2, "vbSide");
            return (Criteria) this;
        }

        public Criteria andVbSizeIsNull() {
            addCriterion("vb_size is null");
            return (Criteria) this;
        }

        public Criteria andVbSizeIsNotNull() {
            addCriterion("vb_size is not null");
            return (Criteria) this;
        }

        public Criteria andVbSizeEqualTo(Short value) {
            addCriterion("vb_size =", value, "vbSize");
            return (Criteria) this;
        }

        public Criteria andVbSizeNotEqualTo(Short value) {
            addCriterion("vb_size <>", value, "vbSize");
            return (Criteria) this;
        }

        public Criteria andVbSizeGreaterThan(Short value) {
            addCriterion("vb_size >", value, "vbSize");
            return (Criteria) this;
        }

        public Criteria andVbSizeGreaterThanOrEqualTo(Short value) {
            addCriterion("vb_size >=", value, "vbSize");
            return (Criteria) this;
        }

        public Criteria andVbSizeLessThan(Short value) {
            addCriterion("vb_size <", value, "vbSize");
            return (Criteria) this;
        }

        public Criteria andVbSizeLessThanOrEqualTo(Short value) {
            addCriterion("vb_size <=", value, "vbSize");
            return (Criteria) this;
        }

        public Criteria andVbSizeIn(List<Short> values) {
            addCriterion("vb_size in", values, "vbSize");
            return (Criteria) this;
        }

        public Criteria andVbSizeNotIn(List<Short> values) {
            addCriterion("vb_size not in", values, "vbSize");
            return (Criteria) this;
        }

        public Criteria andVbSizeBetween(Short value1, Short value2) {
            addCriterion("vb_size between", value1, value2, "vbSize");
            return (Criteria) this;
        }

        public Criteria andVbSizeNotBetween(Short value1, Short value2) {
            addCriterion("vb_size not between", value1, value2, "vbSize");
            return (Criteria) this;
        }

        public Criteria andVbSpeedIsNull() {
            addCriterion("vb_speed is null");
            return (Criteria) this;
        }

        public Criteria andVbSpeedIsNotNull() {
            addCriterion("vb_speed is not null");
            return (Criteria) this;
        }

        public Criteria andVbSpeedEqualTo(Short value) {
            addCriterion("vb_speed =", value, "vbSpeed");
            return (Criteria) this;
        }

        public Criteria andVbSpeedNotEqualTo(Short value) {
            addCriterion("vb_speed <>", value, "vbSpeed");
            return (Criteria) this;
        }

        public Criteria andVbSpeedGreaterThan(Short value) {
            addCriterion("vb_speed >", value, "vbSpeed");
            return (Criteria) this;
        }

        public Criteria andVbSpeedGreaterThanOrEqualTo(Short value) {
            addCriterion("vb_speed >=", value, "vbSpeed");
            return (Criteria) this;
        }

        public Criteria andVbSpeedLessThan(Short value) {
            addCriterion("vb_speed <", value, "vbSpeed");
            return (Criteria) this;
        }

        public Criteria andVbSpeedLessThanOrEqualTo(Short value) {
            addCriterion("vb_speed <=", value, "vbSpeed");
            return (Criteria) this;
        }

        public Criteria andVbSpeedIn(List<Short> values) {
            addCriterion("vb_speed in", values, "vbSpeed");
            return (Criteria) this;
        }

        public Criteria andVbSpeedNotIn(List<Short> values) {
            addCriterion("vb_speed not in", values, "vbSpeed");
            return (Criteria) this;
        }

        public Criteria andVbSpeedBetween(Short value1, Short value2) {
            addCriterion("vb_speed between", value1, value2, "vbSpeed");
            return (Criteria) this;
        }

        public Criteria andVbSpeedNotBetween(Short value1, Short value2) {
            addCriterion("vb_speed not between", value1, value2, "vbSpeed");
            return (Criteria) this;
        }

        public Criteria andVbDirectionIsNull() {
            addCriterion("vb_direction is null");
            return (Criteria) this;
        }

        public Criteria andVbDirectionIsNotNull() {
            addCriterion("vb_direction is not null");
            return (Criteria) this;
        }

        public Criteria andVbDirectionEqualTo(Short value) {
            addCriterion("vb_direction =", value, "vbDirection");
            return (Criteria) this;
        }

        public Criteria andVbDirectionNotEqualTo(Short value) {
            addCriterion("vb_direction <>", value, "vbDirection");
            return (Criteria) this;
        }

        public Criteria andVbDirectionGreaterThan(Short value) {
            addCriterion("vb_direction >", value, "vbDirection");
            return (Criteria) this;
        }

        public Criteria andVbDirectionGreaterThanOrEqualTo(Short value) {
            addCriterion("vb_direction >=", value, "vbDirection");
            return (Criteria) this;
        }

        public Criteria andVbDirectionLessThan(Short value) {
            addCriterion("vb_direction <", value, "vbDirection");
            return (Criteria) this;
        }

        public Criteria andVbDirectionLessThanOrEqualTo(Short value) {
            addCriterion("vb_direction <=", value, "vbDirection");
            return (Criteria) this;
        }

        public Criteria andVbDirectionIn(List<Short> values) {
            addCriterion("vb_direction in", values, "vbDirection");
            return (Criteria) this;
        }

        public Criteria andVbDirectionNotIn(List<Short> values) {
            addCriterion("vb_direction not in", values, "vbDirection");
            return (Criteria) this;
        }

        public Criteria andVbDirectionBetween(Short value1, Short value2) {
            addCriterion("vb_direction between", value1, value2, "vbDirection");
            return (Criteria) this;
        }

        public Criteria andVbDirectionNotBetween(Short value1, Short value2) {
            addCriterion("vb_direction not between", value1, value2, "vbDirection");
            return (Criteria) this;
        }

        public Criteria andVbLaneIsNull() {
            addCriterion("vb_lane is null");
            return (Criteria) this;
        }

        public Criteria andVbLaneIsNotNull() {
            addCriterion("vb_lane is not null");
            return (Criteria) this;
        }

        public Criteria andVbLaneEqualTo(String value) {
            addCriterion("vb_lane =", value, "vbLane");
            return (Criteria) this;
        }

        public Criteria andVbLaneNotEqualTo(String value) {
            addCriterion("vb_lane <>", value, "vbLane");
            return (Criteria) this;
        }

        public Criteria andVbLaneGreaterThan(String value) {
            addCriterion("vb_lane >", value, "vbLane");
            return (Criteria) this;
        }

        public Criteria andVbLaneGreaterThanOrEqualTo(String value) {
            addCriterion("vb_lane >=", value, "vbLane");
            return (Criteria) this;
        }

        public Criteria andVbLaneLessThan(String value) {
            addCriterion("vb_lane <", value, "vbLane");
            return (Criteria) this;
        }

        public Criteria andVbLaneLessThanOrEqualTo(String value) {
            addCriterion("vb_lane <=", value, "vbLane");
            return (Criteria) this;
        }

        public Criteria andVbLaneLike(String value) {
            addCriterion("vb_lane like", value, "vbLane");
            return (Criteria) this;
        }

        public Criteria andVbLaneNotLike(String value) {
            addCriterion("vb_lane not like", value, "vbLane");
            return (Criteria) this;
        }

        public Criteria andVbLaneIn(List<String> values) {
            addCriterion("vb_lane in", values, "vbLane");
            return (Criteria) this;
        }

        public Criteria andVbLaneNotIn(List<String> values) {
            addCriterion("vb_lane not in", values, "vbLane");
            return (Criteria) this;
        }

        public Criteria andVbLaneBetween(String value1, String value2) {
            addCriterion("vb_lane between", value1, value2, "vbLane");
            return (Criteria) this;
        }

        public Criteria andVbLaneNotBetween(String value1, String value2) {
            addCriterion("vb_lane not between", value1, value2, "vbLane");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdIsNull() {
            addCriterion("vb_face_id is null");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdIsNotNull() {
            addCriterion("vb_face_id is not null");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdEqualTo(String value) {
            addCriterion("vb_face_id =", value, "vbFaceId");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdNotEqualTo(String value) {
            addCriterion("vb_face_id <>", value, "vbFaceId");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdGreaterThan(String value) {
            addCriterion("vb_face_id >", value, "vbFaceId");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdGreaterThanOrEqualTo(String value) {
            addCriterion("vb_face_id >=", value, "vbFaceId");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdLessThan(String value) {
            addCriterion("vb_face_id <", value, "vbFaceId");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdLessThanOrEqualTo(String value) {
            addCriterion("vb_face_id <=", value, "vbFaceId");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdLike(String value) {
            addCriterion("vb_face_id like", value, "vbFaceId");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdNotLike(String value) {
            addCriterion("vb_face_id not like", value, "vbFaceId");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdIn(List<String> values) {
            addCriterion("vb_face_id in", values, "vbFaceId");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdNotIn(List<String> values) {
            addCriterion("vb_face_id not in", values, "vbFaceId");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdBetween(String value1, String value2) {
            addCriterion("vb_face_id between", value1, value2, "vbFaceId");
            return (Criteria) this;
        }

        public Criteria andVbFaceIdNotBetween(String value1, String value2) {
            addCriterion("vb_face_id not between", value1, value2, "vbFaceId");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeIsNull() {
            addCriterion("vb_oil_type is null");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeIsNotNull() {
            addCriterion("vb_oil_type is not null");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeEqualTo(String value) {
            addCriterion("vb_oil_type =", value, "vbOilType");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeNotEqualTo(String value) {
            addCriterion("vb_oil_type <>", value, "vbOilType");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeGreaterThan(String value) {
            addCriterion("vb_oil_type >", value, "vbOilType");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeGreaterThanOrEqualTo(String value) {
            addCriterion("vb_oil_type >=", value, "vbOilType");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeLessThan(String value) {
            addCriterion("vb_oil_type <", value, "vbOilType");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeLessThanOrEqualTo(String value) {
            addCriterion("vb_oil_type <=", value, "vbOilType");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeLike(String value) {
            addCriterion("vb_oil_type like", value, "vbOilType");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeNotLike(String value) {
            addCriterion("vb_oil_type not like", value, "vbOilType");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeIn(List<String> values) {
            addCriterion("vb_oil_type in", values, "vbOilType");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeNotIn(List<String> values) {
            addCriterion("vb_oil_type not in", values, "vbOilType");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeBetween(String value1, String value2) {
            addCriterion("vb_oil_type between", value1, value2, "vbOilType");
            return (Criteria) this;
        }

        public Criteria andVbOilTypeNotBetween(String value1, String value2) {
            addCriterion("vb_oil_type not between", value1, value2, "vbOilType");
            return (Criteria) this;
        }

        public Criteria andVbOilAmountIsNull() {
            addCriterion("vb_oil_amount is null");
            return (Criteria) this;
        }

        public Criteria andVbOilAmountIsNotNull() {
            addCriterion("vb_oil_amount is not null");
            return (Criteria) this;
        }

        public Criteria andVbOilAmountEqualTo(Float value) {
            addCriterion("vb_oil_amount =", value, "vbOilAmount");
            return (Criteria) this;
        }

        public Criteria andVbOilAmountNotEqualTo(Float value) {
            addCriterion("vb_oil_amount <>", value, "vbOilAmount");
            return (Criteria) this;
        }

        public Criteria andVbOilAmountGreaterThan(Float value) {
            addCriterion("vb_oil_amount >", value, "vbOilAmount");
            return (Criteria) this;
        }

        public Criteria andVbOilAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("vb_oil_amount >=", value, "vbOilAmount");
            return (Criteria) this;
        }

        public Criteria andVbOilAmountLessThan(Float value) {
            addCriterion("vb_oil_amount <", value, "vbOilAmount");
            return (Criteria) this;
        }

        public Criteria andVbOilAmountLessThanOrEqualTo(Float value) {
            addCriterion("vb_oil_amount <=", value, "vbOilAmount");
            return (Criteria) this;
        }

        public Criteria andVbOilAmountIn(List<Float> values) {
            addCriterion("vb_oil_amount in", values, "vbOilAmount");
            return (Criteria) this;
        }

        public Criteria andVbOilAmountNotIn(List<Float> values) {
            addCriterion("vb_oil_amount not in", values, "vbOilAmount");
            return (Criteria) this;
        }

        public Criteria andVbOilAmountBetween(Float value1, Float value2) {
            addCriterion("vb_oil_amount between", value1, value2, "vbOilAmount");
            return (Criteria) this;
        }

        public Criteria andVbOilAmountNotBetween(Float value1, Float value2) {
            addCriterion("vb_oil_amount not between", value1, value2, "vbOilAmount");
            return (Criteria) this;
        }
    }

    /**
     * @Title public.vj_vehicle_queue_view表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-05 14:27:22
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @Title public.vj_vehicle_queue_view表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-05 14:27:22
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