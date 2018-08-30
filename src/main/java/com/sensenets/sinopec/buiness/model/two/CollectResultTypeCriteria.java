/**
  * CollectResultTypeCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-29
  */
package com.sensenets.sinopec.buiness.model.two;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title public.collect_result_type表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-29 16:48:01
 */
public class CollectResultTypeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     *  构造查询条件:public.collect_result_type
     */
    public CollectResultTypeCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *  设置排序字段:public.collect_result_type
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *  获取排序字段:public.collect_result_type
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *  设置过滤重复数据:public.collect_result_type
     *
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *  是否过滤重复数据:public.collect_result_type
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *  获取当前的查询条件实例:public.collect_result_type
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * :public.collect_result_type
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * :public.collect_result_type
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *  创建一个查询条件:public.collect_result_type
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *  内部构建查询条件对象:public.collect_result_type
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *  清除查询条件:public.collect_result_type
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
     * @Title public.collect_result_type表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-29 16:48:01
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

        public Criteria andCollectTaskIdIsNull() {
            addCriterion("collect_task_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectTaskIdIsNotNull() {
            addCriterion("collect_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectTaskIdEqualTo(Long value) {
            addCriterion("collect_task_id =", value, "collectTaskId");
            return (Criteria) this;
        }

        public Criteria andCollectTaskIdNotEqualTo(Long value) {
            addCriterion("collect_task_id <>", value, "collectTaskId");
            return (Criteria) this;
        }

        public Criteria andCollectTaskIdGreaterThan(Long value) {
            addCriterion("collect_task_id >", value, "collectTaskId");
            return (Criteria) this;
        }

        public Criteria andCollectTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("collect_task_id >=", value, "collectTaskId");
            return (Criteria) this;
        }

        public Criteria andCollectTaskIdLessThan(Long value) {
            addCriterion("collect_task_id <", value, "collectTaskId");
            return (Criteria) this;
        }

        public Criteria andCollectTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("collect_task_id <=", value, "collectTaskId");
            return (Criteria) this;
        }

        public Criteria andCollectTaskIdIn(List<Long> values) {
            addCriterion("collect_task_id in", values, "collectTaskId");
            return (Criteria) this;
        }

        public Criteria andCollectTaskIdNotIn(List<Long> values) {
            addCriterion("collect_task_id not in", values, "collectTaskId");
            return (Criteria) this;
        }

        public Criteria andCollectTaskIdBetween(Long value1, Long value2) {
            addCriterion("collect_task_id between", value1, value2, "collectTaskId");
            return (Criteria) this;
        }

        public Criteria andCollectTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("collect_task_id not between", value1, value2, "collectTaskId");
            return (Criteria) this;
        }

        public Criteria andMobRepIdIsNull() {
            addCriterion("mob_rep_id is null");
            return (Criteria) this;
        }

        public Criteria andMobRepIdIsNotNull() {
            addCriterion("mob_rep_id is not null");
            return (Criteria) this;
        }

        public Criteria andMobRepIdEqualTo(Long value) {
            addCriterion("mob_rep_id =", value, "mobRepId");
            return (Criteria) this;
        }

        public Criteria andMobRepIdNotEqualTo(Long value) {
            addCriterion("mob_rep_id <>", value, "mobRepId");
            return (Criteria) this;
        }

        public Criteria andMobRepIdGreaterThan(Long value) {
            addCriterion("mob_rep_id >", value, "mobRepId");
            return (Criteria) this;
        }

        public Criteria andMobRepIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mob_rep_id >=", value, "mobRepId");
            return (Criteria) this;
        }

        public Criteria andMobRepIdLessThan(Long value) {
            addCriterion("mob_rep_id <", value, "mobRepId");
            return (Criteria) this;
        }

        public Criteria andMobRepIdLessThanOrEqualTo(Long value) {
            addCriterion("mob_rep_id <=", value, "mobRepId");
            return (Criteria) this;
        }

        public Criteria andMobRepIdIn(List<Long> values) {
            addCriterion("mob_rep_id in", values, "mobRepId");
            return (Criteria) this;
        }

        public Criteria andMobRepIdNotIn(List<Long> values) {
            addCriterion("mob_rep_id not in", values, "mobRepId");
            return (Criteria) this;
        }

        public Criteria andMobRepIdBetween(Long value1, Long value2) {
            addCriterion("mob_rep_id between", value1, value2, "mobRepId");
            return (Criteria) this;
        }

        public Criteria andMobRepIdNotBetween(Long value1, Long value2) {
            addCriterion("mob_rep_id not between", value1, value2, "mobRepId");
            return (Criteria) this;
        }

        public Criteria andStationRepIdIsNull() {
            addCriterion("station_rep_id is null");
            return (Criteria) this;
        }

        public Criteria andStationRepIdIsNotNull() {
            addCriterion("station_rep_id is not null");
            return (Criteria) this;
        }

        public Criteria andStationRepIdEqualTo(Long value) {
            addCriterion("station_rep_id =", value, "stationRepId");
            return (Criteria) this;
        }

        public Criteria andStationRepIdNotEqualTo(Long value) {
            addCriterion("station_rep_id <>", value, "stationRepId");
            return (Criteria) this;
        }

        public Criteria andStationRepIdGreaterThan(Long value) {
            addCriterion("station_rep_id >", value, "stationRepId");
            return (Criteria) this;
        }

        public Criteria andStationRepIdGreaterThanOrEqualTo(Long value) {
            addCriterion("station_rep_id >=", value, "stationRepId");
            return (Criteria) this;
        }

        public Criteria andStationRepIdLessThan(Long value) {
            addCriterion("station_rep_id <", value, "stationRepId");
            return (Criteria) this;
        }

        public Criteria andStationRepIdLessThanOrEqualTo(Long value) {
            addCriterion("station_rep_id <=", value, "stationRepId");
            return (Criteria) this;
        }

        public Criteria andStationRepIdIn(List<Long> values) {
            addCriterion("station_rep_id in", values, "stationRepId");
            return (Criteria) this;
        }

        public Criteria andStationRepIdNotIn(List<Long> values) {
            addCriterion("station_rep_id not in", values, "stationRepId");
            return (Criteria) this;
        }

        public Criteria andStationRepIdBetween(Long value1, Long value2) {
            addCriterion("station_rep_id between", value1, value2, "stationRepId");
            return (Criteria) this;
        }

        public Criteria andStationRepIdNotBetween(Long value1, Long value2) {
            addCriterion("station_rep_id not between", value1, value2, "stationRepId");
            return (Criteria) this;
        }

        public Criteria andCollectInCountIsNull() {
            addCriterion("collect_in_count is null");
            return (Criteria) this;
        }

        public Criteria andCollectInCountIsNotNull() {
            addCriterion("collect_in_count is not null");
            return (Criteria) this;
        }

        public Criteria andCollectInCountEqualTo(Integer value) {
            addCriterion("collect_in_count =", value, "collectInCount");
            return (Criteria) this;
        }

        public Criteria andCollectInCountNotEqualTo(Integer value) {
            addCriterion("collect_in_count <>", value, "collectInCount");
            return (Criteria) this;
        }

        public Criteria andCollectInCountGreaterThan(Integer value) {
            addCriterion("collect_in_count >", value, "collectInCount");
            return (Criteria) this;
        }

        public Criteria andCollectInCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_in_count >=", value, "collectInCount");
            return (Criteria) this;
        }

        public Criteria andCollectInCountLessThan(Integer value) {
            addCriterion("collect_in_count <", value, "collectInCount");
            return (Criteria) this;
        }

        public Criteria andCollectInCountLessThanOrEqualTo(Integer value) {
            addCriterion("collect_in_count <=", value, "collectInCount");
            return (Criteria) this;
        }

        public Criteria andCollectInCountIn(List<Integer> values) {
            addCriterion("collect_in_count in", values, "collectInCount");
            return (Criteria) this;
        }

        public Criteria andCollectInCountNotIn(List<Integer> values) {
            addCriterion("collect_in_count not in", values, "collectInCount");
            return (Criteria) this;
        }

        public Criteria andCollectInCountBetween(Integer value1, Integer value2) {
            addCriterion("collect_in_count between", value1, value2, "collectInCount");
            return (Criteria) this;
        }

        public Criteria andCollectInCountNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_in_count not between", value1, value2, "collectInCount");
            return (Criteria) this;
        }

        public Criteria andStationInCountIsNull() {
            addCriterion("station_in_count is null");
            return (Criteria) this;
        }

        public Criteria andStationInCountIsNotNull() {
            addCriterion("station_in_count is not null");
            return (Criteria) this;
        }

        public Criteria andStationInCountEqualTo(Integer value) {
            addCriterion("station_in_count =", value, "stationInCount");
            return (Criteria) this;
        }

        public Criteria andStationInCountNotEqualTo(Integer value) {
            addCriterion("station_in_count <>", value, "stationInCount");
            return (Criteria) this;
        }

        public Criteria andStationInCountGreaterThan(Integer value) {
            addCriterion("station_in_count >", value, "stationInCount");
            return (Criteria) this;
        }

        public Criteria andStationInCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("station_in_count >=", value, "stationInCount");
            return (Criteria) this;
        }

        public Criteria andStationInCountLessThan(Integer value) {
            addCriterion("station_in_count <", value, "stationInCount");
            return (Criteria) this;
        }

        public Criteria andStationInCountLessThanOrEqualTo(Integer value) {
            addCriterion("station_in_count <=", value, "stationInCount");
            return (Criteria) this;
        }

        public Criteria andStationInCountIn(List<Integer> values) {
            addCriterion("station_in_count in", values, "stationInCount");
            return (Criteria) this;
        }

        public Criteria andStationInCountNotIn(List<Integer> values) {
            addCriterion("station_in_count not in", values, "stationInCount");
            return (Criteria) this;
        }

        public Criteria andStationInCountBetween(Integer value1, Integer value2) {
            addCriterion("station_in_count between", value1, value2, "stationInCount");
            return (Criteria) this;
        }

        public Criteria andStationInCountNotBetween(Integer value1, Integer value2) {
            addCriterion("station_in_count not between", value1, value2, "stationInCount");
            return (Criteria) this;
        }

        public Criteria andCollectOutCountIsNull() {
            addCriterion("collect_out_count is null");
            return (Criteria) this;
        }

        public Criteria andCollectOutCountIsNotNull() {
            addCriterion("collect_out_count is not null");
            return (Criteria) this;
        }

        public Criteria andCollectOutCountEqualTo(Integer value) {
            addCriterion("collect_out_count =", value, "collectOutCount");
            return (Criteria) this;
        }

        public Criteria andCollectOutCountNotEqualTo(Integer value) {
            addCriterion("collect_out_count <>", value, "collectOutCount");
            return (Criteria) this;
        }

        public Criteria andCollectOutCountGreaterThan(Integer value) {
            addCriterion("collect_out_count >", value, "collectOutCount");
            return (Criteria) this;
        }

        public Criteria andCollectOutCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_out_count >=", value, "collectOutCount");
            return (Criteria) this;
        }

        public Criteria andCollectOutCountLessThan(Integer value) {
            addCriterion("collect_out_count <", value, "collectOutCount");
            return (Criteria) this;
        }

        public Criteria andCollectOutCountLessThanOrEqualTo(Integer value) {
            addCriterion("collect_out_count <=", value, "collectOutCount");
            return (Criteria) this;
        }

        public Criteria andCollectOutCountIn(List<Integer> values) {
            addCriterion("collect_out_count in", values, "collectOutCount");
            return (Criteria) this;
        }

        public Criteria andCollectOutCountNotIn(List<Integer> values) {
            addCriterion("collect_out_count not in", values, "collectOutCount");
            return (Criteria) this;
        }

        public Criteria andCollectOutCountBetween(Integer value1, Integer value2) {
            addCriterion("collect_out_count between", value1, value2, "collectOutCount");
            return (Criteria) this;
        }

        public Criteria andCollectOutCountNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_out_count not between", value1, value2, "collectOutCount");
            return (Criteria) this;
        }

        public Criteria andStationOutCountIsNull() {
            addCriterion("station_out_count is null");
            return (Criteria) this;
        }

        public Criteria andStationOutCountIsNotNull() {
            addCriterion("station_out_count is not null");
            return (Criteria) this;
        }

        public Criteria andStationOutCountEqualTo(Integer value) {
            addCriterion("station_out_count =", value, "stationOutCount");
            return (Criteria) this;
        }

        public Criteria andStationOutCountNotEqualTo(Integer value) {
            addCriterion("station_out_count <>", value, "stationOutCount");
            return (Criteria) this;
        }

        public Criteria andStationOutCountGreaterThan(Integer value) {
            addCriterion("station_out_count >", value, "stationOutCount");
            return (Criteria) this;
        }

        public Criteria andStationOutCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("station_out_count >=", value, "stationOutCount");
            return (Criteria) this;
        }

        public Criteria andStationOutCountLessThan(Integer value) {
            addCriterion("station_out_count <", value, "stationOutCount");
            return (Criteria) this;
        }

        public Criteria andStationOutCountLessThanOrEqualTo(Integer value) {
            addCriterion("station_out_count <=", value, "stationOutCount");
            return (Criteria) this;
        }

        public Criteria andStationOutCountIn(List<Integer> values) {
            addCriterion("station_out_count in", values, "stationOutCount");
            return (Criteria) this;
        }

        public Criteria andStationOutCountNotIn(List<Integer> values) {
            addCriterion("station_out_count not in", values, "stationOutCount");
            return (Criteria) this;
        }

        public Criteria andStationOutCountBetween(Integer value1, Integer value2) {
            addCriterion("station_out_count between", value1, value2, "stationOutCount");
            return (Criteria) this;
        }

        public Criteria andStationOutCountNotBetween(Integer value1, Integer value2) {
            addCriterion("station_out_count not between", value1, value2, "stationOutCount");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeIsNull() {
            addCriterion("verhicle_type is null");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeIsNotNull() {
            addCriterion("verhicle_type is not null");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeEqualTo(String value) {
            addCriterion("verhicle_type =", value, "verhicleType");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeNotEqualTo(String value) {
            addCriterion("verhicle_type <>", value, "verhicleType");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeGreaterThan(String value) {
            addCriterion("verhicle_type >", value, "verhicleType");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("verhicle_type >=", value, "verhicleType");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeLessThan(String value) {
            addCriterion("verhicle_type <", value, "verhicleType");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeLessThanOrEqualTo(String value) {
            addCriterion("verhicle_type <=", value, "verhicleType");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeLike(String value) {
            addCriterion("verhicle_type like", value, "verhicleType");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeNotLike(String value) {
            addCriterion("verhicle_type not like", value, "verhicleType");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeIn(List<String> values) {
            addCriterion("verhicle_type in", values, "verhicleType");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeNotIn(List<String> values) {
            addCriterion("verhicle_type not in", values, "verhicleType");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeBetween(String value1, String value2) {
            addCriterion("verhicle_type between", value1, value2, "verhicleType");
            return (Criteria) this;
        }

        public Criteria andVerhicleTypeNotBetween(String value1, String value2) {
            addCriterion("verhicle_type not between", value1, value2, "verhicleType");
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
     * @Title public.collect_result_type表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-29 16:48:01
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @Title public.collect_result_type表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-29 16:48:01
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