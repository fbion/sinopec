/**
  * VjMobileCollectTaskViewCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-29
  */
package com.sensenets.sinopec.buiness.model.one;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title public.vj_mobile_collect_task_view表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-29 20:23:32
 */
public class VjMobileCollectTaskViewCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     *  构造查询条件:public.vj_mobile_collect_task_view
     */
    public VjMobileCollectTaskViewCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *  设置排序字段:public.vj_mobile_collect_task_view
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *  获取排序字段:public.vj_mobile_collect_task_view
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *  设置过滤重复数据:public.vj_mobile_collect_task_view
     *
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *  是否过滤重复数据:public.vj_mobile_collect_task_view
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *  获取当前的查询条件实例:public.vj_mobile_collect_task_view
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * :public.vj_mobile_collect_task_view
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * :public.vj_mobile_collect_task_view
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *  创建一个查询条件:public.vj_mobile_collect_task_view
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *  内部构建查询条件对象:public.vj_mobile_collect_task_view
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *  清除查询条件:public.vj_mobile_collect_task_view
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
     * @Title public.vj_mobile_collect_task_view表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-29 20:23:32
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

        public Criteria andCollectRepoIdIsNull() {
            addCriterion("collect_repo_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdIsNotNull() {
            addCriterion("collect_repo_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdEqualTo(String value) {
            addCriterion("collect_repo_id =", value, "collectRepoId");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdNotEqualTo(String value) {
            addCriterion("collect_repo_id <>", value, "collectRepoId");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdGreaterThan(String value) {
            addCriterion("collect_repo_id >", value, "collectRepoId");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdGreaterThanOrEqualTo(String value) {
            addCriterion("collect_repo_id >=", value, "collectRepoId");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdLessThan(String value) {
            addCriterion("collect_repo_id <", value, "collectRepoId");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdLessThanOrEqualTo(String value) {
            addCriterion("collect_repo_id <=", value, "collectRepoId");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdLike(String value) {
            addCriterion("collect_repo_id like", value, "collectRepoId");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdNotLike(String value) {
            addCriterion("collect_repo_id not like", value, "collectRepoId");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdIn(List<String> values) {
            addCriterion("collect_repo_id in", values, "collectRepoId");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdNotIn(List<String> values) {
            addCriterion("collect_repo_id not in", values, "collectRepoId");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdBetween(String value1, String value2) {
            addCriterion("collect_repo_id between", value1, value2, "collectRepoId");
            return (Criteria) this;
        }

        public Criteria andCollectRepoIdNotBetween(String value1, String value2) {
            addCriterion("collect_repo_id not between", value1, value2, "collectRepoId");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdIsNull() {
            addCriterion("oil_station_repo_id is null");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdIsNotNull() {
            addCriterion("oil_station_repo_id is not null");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdEqualTo(String value) {
            addCriterion("oil_station_repo_id =", value, "oilStationRepoId");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdNotEqualTo(String value) {
            addCriterion("oil_station_repo_id <>", value, "oilStationRepoId");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdGreaterThan(String value) {
            addCriterion("oil_station_repo_id >", value, "oilStationRepoId");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdGreaterThanOrEqualTo(String value) {
            addCriterion("oil_station_repo_id >=", value, "oilStationRepoId");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdLessThan(String value) {
            addCriterion("oil_station_repo_id <", value, "oilStationRepoId");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdLessThanOrEqualTo(String value) {
            addCriterion("oil_station_repo_id <=", value, "oilStationRepoId");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdLike(String value) {
            addCriterion("oil_station_repo_id like", value, "oilStationRepoId");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdNotLike(String value) {
            addCriterion("oil_station_repo_id not like", value, "oilStationRepoId");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdIn(List<String> values) {
            addCriterion("oil_station_repo_id in", values, "oilStationRepoId");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdNotIn(List<String> values) {
            addCriterion("oil_station_repo_id not in", values, "oilStationRepoId");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdBetween(String value1, String value2) {
            addCriterion("oil_station_repo_id between", value1, value2, "oilStationRepoId");
            return (Criteria) this;
        }

        public Criteria andOilStationRepoIdNotBetween(String value1, String value2) {
            addCriterion("oil_station_repo_id not between", value1, value2, "oilStationRepoId");
            return (Criteria) this;
        }

        public Criteria andCollectStartTimeIsNull() {
            addCriterion("collect_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCollectStartTimeIsNotNull() {
            addCriterion("collect_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCollectStartTimeEqualTo(Date value) {
            addCriterion("collect_start_time =", value, "collectStartTime");
            return (Criteria) this;
        }

        public Criteria andCollectStartTimeNotEqualTo(Date value) {
            addCriterion("collect_start_time <>", value, "collectStartTime");
            return (Criteria) this;
        }

        public Criteria andCollectStartTimeGreaterThan(Date value) {
            addCriterion("collect_start_time >", value, "collectStartTime");
            return (Criteria) this;
        }

        public Criteria andCollectStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("collect_start_time >=", value, "collectStartTime");
            return (Criteria) this;
        }

        public Criteria andCollectStartTimeLessThan(Date value) {
            addCriterion("collect_start_time <", value, "collectStartTime");
            return (Criteria) this;
        }

        public Criteria andCollectStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("collect_start_time <=", value, "collectStartTime");
            return (Criteria) this;
        }

        public Criteria andCollectStartTimeIn(List<Date> values) {
            addCriterion("collect_start_time in", values, "collectStartTime");
            return (Criteria) this;
        }

        public Criteria andCollectStartTimeNotIn(List<Date> values) {
            addCriterion("collect_start_time not in", values, "collectStartTime");
            return (Criteria) this;
        }

        public Criteria andCollectStartTimeBetween(Date value1, Date value2) {
            addCriterion("collect_start_time between", value1, value2, "collectStartTime");
            return (Criteria) this;
        }

        public Criteria andCollectStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("collect_start_time not between", value1, value2, "collectStartTime");
            return (Criteria) this;
        }

        public Criteria andCollectEndTimeIsNull() {
            addCriterion("collect_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCollectEndTimeIsNotNull() {
            addCriterion("collect_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCollectEndTimeEqualTo(Date value) {
            addCriterion("collect_end_time =", value, "collectEndTime");
            return (Criteria) this;
        }

        public Criteria andCollectEndTimeNotEqualTo(Date value) {
            addCriterion("collect_end_time <>", value, "collectEndTime");
            return (Criteria) this;
        }

        public Criteria andCollectEndTimeGreaterThan(Date value) {
            addCriterion("collect_end_time >", value, "collectEndTime");
            return (Criteria) this;
        }

        public Criteria andCollectEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("collect_end_time >=", value, "collectEndTime");
            return (Criteria) this;
        }

        public Criteria andCollectEndTimeLessThan(Date value) {
            addCriterion("collect_end_time <", value, "collectEndTime");
            return (Criteria) this;
        }

        public Criteria andCollectEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("collect_end_time <=", value, "collectEndTime");
            return (Criteria) this;
        }

        public Criteria andCollectEndTimeIn(List<Date> values) {
            addCriterion("collect_end_time in", values, "collectEndTime");
            return (Criteria) this;
        }

        public Criteria andCollectEndTimeNotIn(List<Date> values) {
            addCriterion("collect_end_time not in", values, "collectEndTime");
            return (Criteria) this;
        }

        public Criteria andCollectEndTimeBetween(Date value1, Date value2) {
            addCriterion("collect_end_time between", value1, value2, "collectEndTime");
            return (Criteria) this;
        }

        public Criteria andCollectEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("collect_end_time not between", value1, value2, "collectEndTime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Short value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Short value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Short value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Short value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Short value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Short> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Short> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Short value1, Short value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Short value1, Short value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdIsNull() {
            addCriterion("ra_repo_id_id is null");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdIsNotNull() {
            addCriterion("ra_repo_id_id is not null");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdEqualTo(String value) {
            addCriterion("ra_repo_id_id =", value, "raRepoIdId");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdNotEqualTo(String value) {
            addCriterion("ra_repo_id_id <>", value, "raRepoIdId");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdGreaterThan(String value) {
            addCriterion("ra_repo_id_id >", value, "raRepoIdId");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdGreaterThanOrEqualTo(String value) {
            addCriterion("ra_repo_id_id >=", value, "raRepoIdId");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdLessThan(String value) {
            addCriterion("ra_repo_id_id <", value, "raRepoIdId");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdLessThanOrEqualTo(String value) {
            addCriterion("ra_repo_id_id <=", value, "raRepoIdId");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdLike(String value) {
            addCriterion("ra_repo_id_id like", value, "raRepoIdId");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdNotLike(String value) {
            addCriterion("ra_repo_id_id not like", value, "raRepoIdId");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdIn(List<String> values) {
            addCriterion("ra_repo_id_id in", values, "raRepoIdId");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdNotIn(List<String> values) {
            addCriterion("ra_repo_id_id not in", values, "raRepoIdId");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdBetween(String value1, String value2) {
            addCriterion("ra_repo_id_id between", value1, value2, "raRepoIdId");
            return (Criteria) this;
        }

        public Criteria andRaRepoIdIdNotBetween(String value1, String value2) {
            addCriterion("ra_repo_id_id not between", value1, value2, "raRepoIdId");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameIsNull() {
            addCriterion("ra_repo_name is null");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameIsNotNull() {
            addCriterion("ra_repo_name is not null");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameEqualTo(String value) {
            addCriterion("ra_repo_name =", value, "raRepoName");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameNotEqualTo(String value) {
            addCriterion("ra_repo_name <>", value, "raRepoName");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameGreaterThan(String value) {
            addCriterion("ra_repo_name >", value, "raRepoName");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameGreaterThanOrEqualTo(String value) {
            addCriterion("ra_repo_name >=", value, "raRepoName");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameLessThan(String value) {
            addCriterion("ra_repo_name <", value, "raRepoName");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameLessThanOrEqualTo(String value) {
            addCriterion("ra_repo_name <=", value, "raRepoName");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameLike(String value) {
            addCriterion("ra_repo_name like", value, "raRepoName");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameNotLike(String value) {
            addCriterion("ra_repo_name not like", value, "raRepoName");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameIn(List<String> values) {
            addCriterion("ra_repo_name in", values, "raRepoName");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameNotIn(List<String> values) {
            addCriterion("ra_repo_name not in", values, "raRepoName");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameBetween(String value1, String value2) {
            addCriterion("ra_repo_name between", value1, value2, "raRepoName");
            return (Criteria) this;
        }

        public Criteria andRaRepoNameNotBetween(String value1, String value2) {
            addCriterion("ra_repo_name not between", value1, value2, "raRepoName");
            return (Criteria) this;
        }

        public Criteria andRaParentIdIsNull() {
            addCriterion("ra_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andRaParentIdIsNotNull() {
            addCriterion("ra_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andRaParentIdEqualTo(String value) {
            addCriterion("ra_parent_id =", value, "raParentId");
            return (Criteria) this;
        }

        public Criteria andRaParentIdNotEqualTo(String value) {
            addCriterion("ra_parent_id <>", value, "raParentId");
            return (Criteria) this;
        }

        public Criteria andRaParentIdGreaterThan(String value) {
            addCriterion("ra_parent_id >", value, "raParentId");
            return (Criteria) this;
        }

        public Criteria andRaParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("ra_parent_id >=", value, "raParentId");
            return (Criteria) this;
        }

        public Criteria andRaParentIdLessThan(String value) {
            addCriterion("ra_parent_id <", value, "raParentId");
            return (Criteria) this;
        }

        public Criteria andRaParentIdLessThanOrEqualTo(String value) {
            addCriterion("ra_parent_id <=", value, "raParentId");
            return (Criteria) this;
        }

        public Criteria andRaParentIdLike(String value) {
            addCriterion("ra_parent_id like", value, "raParentId");
            return (Criteria) this;
        }

        public Criteria andRaParentIdNotLike(String value) {
            addCriterion("ra_parent_id not like", value, "raParentId");
            return (Criteria) this;
        }

        public Criteria andRaParentIdIn(List<String> values) {
            addCriterion("ra_parent_id in", values, "raParentId");
            return (Criteria) this;
        }

        public Criteria andRaParentIdNotIn(List<String> values) {
            addCriterion("ra_parent_id not in", values, "raParentId");
            return (Criteria) this;
        }

        public Criteria andRaParentIdBetween(String value1, String value2) {
            addCriterion("ra_parent_id between", value1, value2, "raParentId");
            return (Criteria) this;
        }

        public Criteria andRaParentIdNotBetween(String value1, String value2) {
            addCriterion("ra_parent_id not between", value1, value2, "raParentId");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdIsNull() {
            addCriterion("rb_repo_id is null");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdIsNotNull() {
            addCriterion("rb_repo_id is not null");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdEqualTo(String value) {
            addCriterion("rb_repo_id =", value, "rbRepoId");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdNotEqualTo(String value) {
            addCriterion("rb_repo_id <>", value, "rbRepoId");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdGreaterThan(String value) {
            addCriterion("rb_repo_id >", value, "rbRepoId");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdGreaterThanOrEqualTo(String value) {
            addCriterion("rb_repo_id >=", value, "rbRepoId");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdLessThan(String value) {
            addCriterion("rb_repo_id <", value, "rbRepoId");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdLessThanOrEqualTo(String value) {
            addCriterion("rb_repo_id <=", value, "rbRepoId");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdLike(String value) {
            addCriterion("rb_repo_id like", value, "rbRepoId");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdNotLike(String value) {
            addCriterion("rb_repo_id not like", value, "rbRepoId");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdIn(List<String> values) {
            addCriterion("rb_repo_id in", values, "rbRepoId");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdNotIn(List<String> values) {
            addCriterion("rb_repo_id not in", values, "rbRepoId");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdBetween(String value1, String value2) {
            addCriterion("rb_repo_id between", value1, value2, "rbRepoId");
            return (Criteria) this;
        }

        public Criteria andRbRepoIdNotBetween(String value1, String value2) {
            addCriterion("rb_repo_id not between", value1, value2, "rbRepoId");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameIsNull() {
            addCriterion("rb_repo_name is null");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameIsNotNull() {
            addCriterion("rb_repo_name is not null");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameEqualTo(String value) {
            addCriterion("rb_repo_name =", value, "rbRepoName");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameNotEqualTo(String value) {
            addCriterion("rb_repo_name <>", value, "rbRepoName");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameGreaterThan(String value) {
            addCriterion("rb_repo_name >", value, "rbRepoName");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameGreaterThanOrEqualTo(String value) {
            addCriterion("rb_repo_name >=", value, "rbRepoName");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameLessThan(String value) {
            addCriterion("rb_repo_name <", value, "rbRepoName");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameLessThanOrEqualTo(String value) {
            addCriterion("rb_repo_name <=", value, "rbRepoName");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameLike(String value) {
            addCriterion("rb_repo_name like", value, "rbRepoName");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameNotLike(String value) {
            addCriterion("rb_repo_name not like", value, "rbRepoName");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameIn(List<String> values) {
            addCriterion("rb_repo_name in", values, "rbRepoName");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameNotIn(List<String> values) {
            addCriterion("rb_repo_name not in", values, "rbRepoName");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameBetween(String value1, String value2) {
            addCriterion("rb_repo_name between", value1, value2, "rbRepoName");
            return (Criteria) this;
        }

        public Criteria andRbRepoNameNotBetween(String value1, String value2) {
            addCriterion("rb_repo_name not between", value1, value2, "rbRepoName");
            return (Criteria) this;
        }

        public Criteria andRbParentIdIsNull() {
            addCriterion("rb_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andRbParentIdIsNotNull() {
            addCriterion("rb_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andRbParentIdEqualTo(String value) {
            addCriterion("rb_parent_id =", value, "rbParentId");
            return (Criteria) this;
        }

        public Criteria andRbParentIdNotEqualTo(String value) {
            addCriterion("rb_parent_id <>", value, "rbParentId");
            return (Criteria) this;
        }

        public Criteria andRbParentIdGreaterThan(String value) {
            addCriterion("rb_parent_id >", value, "rbParentId");
            return (Criteria) this;
        }

        public Criteria andRbParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("rb_parent_id >=", value, "rbParentId");
            return (Criteria) this;
        }

        public Criteria andRbParentIdLessThan(String value) {
            addCriterion("rb_parent_id <", value, "rbParentId");
            return (Criteria) this;
        }

        public Criteria andRbParentIdLessThanOrEqualTo(String value) {
            addCriterion("rb_parent_id <=", value, "rbParentId");
            return (Criteria) this;
        }

        public Criteria andRbParentIdLike(String value) {
            addCriterion("rb_parent_id like", value, "rbParentId");
            return (Criteria) this;
        }

        public Criteria andRbParentIdNotLike(String value) {
            addCriterion("rb_parent_id not like", value, "rbParentId");
            return (Criteria) this;
        }

        public Criteria andRbParentIdIn(List<String> values) {
            addCriterion("rb_parent_id in", values, "rbParentId");
            return (Criteria) this;
        }

        public Criteria andRbParentIdNotIn(List<String> values) {
            addCriterion("rb_parent_id not in", values, "rbParentId");
            return (Criteria) this;
        }

        public Criteria andRbParentIdBetween(String value1, String value2) {
            addCriterion("rb_parent_id between", value1, value2, "rbParentId");
            return (Criteria) this;
        }

        public Criteria andRbParentIdNotBetween(String value1, String value2) {
            addCriterion("rb_parent_id not between", value1, value2, "rbParentId");
            return (Criteria) this;
        }

        public Criteria andCollectRpathIsNull() {
            addCriterion("collect_rpath is null");
            return (Criteria) this;
        }

        public Criteria andCollectRpathIsNotNull() {
            addCriterion("collect_rpath is not null");
            return (Criteria) this;
        }

        public Criteria andCollectRpathEqualTo(Object value) {
            addCriterion("collect_rpath =", value, "collectRpath");
            return (Criteria) this;
        }

        public Criteria andCollectRpathNotEqualTo(Object value) {
            addCriterion("collect_rpath <>", value, "collectRpath");
            return (Criteria) this;
        }

        public Criteria andCollectRpathGreaterThan(Object value) {
            addCriterion("collect_rpath >", value, "collectRpath");
            return (Criteria) this;
        }

        public Criteria andCollectRpathGreaterThanOrEqualTo(Object value) {
            addCriterion("collect_rpath >=", value, "collectRpath");
            return (Criteria) this;
        }

        public Criteria andCollectRpathLessThan(Object value) {
            addCriterion("collect_rpath <", value, "collectRpath");
            return (Criteria) this;
        }

        public Criteria andCollectRpathLessThanOrEqualTo(Object value) {
            addCriterion("collect_rpath <=", value, "collectRpath");
            return (Criteria) this;
        }

        public Criteria andCollectRpathIn(List<Object> values) {
            addCriterion("collect_rpath in", values, "collectRpath");
            return (Criteria) this;
        }

        public Criteria andCollectRpathNotIn(List<Object> values) {
            addCriterion("collect_rpath not in", values, "collectRpath");
            return (Criteria) this;
        }

        public Criteria andCollectRpathBetween(Object value1, Object value2) {
            addCriterion("collect_rpath between", value1, value2, "collectRpath");
            return (Criteria) this;
        }

        public Criteria andCollectRpathNotBetween(Object value1, Object value2) {
            addCriterion("collect_rpath not between", value1, value2, "collectRpath");
            return (Criteria) this;
        }

        public Criteria andStationRpathIsNull() {
            addCriterion("station_rpath is null");
            return (Criteria) this;
        }

        public Criteria andStationRpathIsNotNull() {
            addCriterion("station_rpath is not null");
            return (Criteria) this;
        }

        public Criteria andStationRpathEqualTo(Object value) {
            addCriterion("station_rpath =", value, "stationRpath");
            return (Criteria) this;
        }

        public Criteria andStationRpathNotEqualTo(Object value) {
            addCriterion("station_rpath <>", value, "stationRpath");
            return (Criteria) this;
        }

        public Criteria andStationRpathGreaterThan(Object value) {
            addCriterion("station_rpath >", value, "stationRpath");
            return (Criteria) this;
        }

        public Criteria andStationRpathGreaterThanOrEqualTo(Object value) {
            addCriterion("station_rpath >=", value, "stationRpath");
            return (Criteria) this;
        }

        public Criteria andStationRpathLessThan(Object value) {
            addCriterion("station_rpath <", value, "stationRpath");
            return (Criteria) this;
        }

        public Criteria andStationRpathLessThanOrEqualTo(Object value) {
            addCriterion("station_rpath <=", value, "stationRpath");
            return (Criteria) this;
        }

        public Criteria andStationRpathIn(List<Object> values) {
            addCriterion("station_rpath in", values, "stationRpath");
            return (Criteria) this;
        }

        public Criteria andStationRpathNotIn(List<Object> values) {
            addCriterion("station_rpath not in", values, "stationRpath");
            return (Criteria) this;
        }

        public Criteria andStationRpathBetween(Object value1, Object value2) {
            addCriterion("station_rpath between", value1, value2, "stationRpath");
            return (Criteria) this;
        }

        public Criteria andStationRpathNotBetween(Object value1, Object value2) {
            addCriterion("station_rpath not between", value1, value2, "stationRpath");
            return (Criteria) this;
        }
    }

    /**
     * @Title public.vj_mobile_collect_task_view表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-29 20:23:32
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @Title public.vj_mobile_collect_task_view表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-29 20:23:32
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