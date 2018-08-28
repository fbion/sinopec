/**
  * MobileCollectTaskCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-28
  */
package com.sensenets.sinopec.buiness.model.one;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title public.mobile_collect_task表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-28 12:24:39
 */
public class MobileCollectTaskCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     *  构造查询条件:public.mobile_collect_task
     */
    public MobileCollectTaskCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *  设置排序字段:public.mobile_collect_task
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *  获取排序字段:public.mobile_collect_task
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *  设置过滤重复数据:public.mobile_collect_task
     *
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *  是否过滤重复数据:public.mobile_collect_task
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *  获取当前的查询条件实例:public.mobile_collect_task
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * :public.mobile_collect_task
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * :public.mobile_collect_task
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *  创建一个查询条件:public.mobile_collect_task
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *  内部构建查询条件对象:public.mobile_collect_task
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *  清除查询条件:public.mobile_collect_task
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
     * @Title public.mobile_collect_task表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-28 12:24:39
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
    }

    /**
     * @Title public.mobile_collect_task表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-28 12:24:39
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @Title public.mobile_collect_task表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-28 12:24:39
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