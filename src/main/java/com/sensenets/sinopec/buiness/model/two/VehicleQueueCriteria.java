/**
  * VehicleQueueCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-03
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
 * @Date 2018-09-03 17:29:18
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
     * @Date 2018-09-03 17:29:18
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
     * @Title public.vehicle_queue表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-03 17:29:18
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
     * @Date 2018-09-03 17:29:18
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