/**
  * MotorBrandAllAttrCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-05
  */
package com.sensenets.sinopec.buiness.model.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title public.motor_brand_all_attr表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-09-05 15:00:34
 */
public class MotorBrandAllAttrCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     *  构造查询条件:public.motor_brand_all_attr
     */
    public MotorBrandAllAttrCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *  设置排序字段:public.motor_brand_all_attr
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *  获取排序字段:public.motor_brand_all_attr
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *  设置过滤重复数据:public.motor_brand_all_attr
     *
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *  是否过滤重复数据:public.motor_brand_all_attr
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *  获取当前的查询条件实例:public.motor_brand_all_attr
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * :public.motor_brand_all_attr
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * :public.motor_brand_all_attr
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *  创建一个查询条件:public.motor_brand_all_attr
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *  内部构建查询条件对象:public.motor_brand_all_attr
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *  清除查询条件:public.motor_brand_all_attr
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
     * @Title public.motor_brand_all_attr表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-05 15:00:34
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

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
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

        public Criteria andSubBrandIdEqualTo(Integer value) {
            addCriterion("sub_brand_id =", value, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdNotEqualTo(Integer value) {
            addCriterion("sub_brand_id <>", value, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdGreaterThan(Integer value) {
            addCriterion("sub_brand_id >", value, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_brand_id >=", value, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdLessThan(Integer value) {
            addCriterion("sub_brand_id <", value, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("sub_brand_id <=", value, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdIn(List<Integer> values) {
            addCriterion("sub_brand_id in", values, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdNotIn(List<Integer> values) {
            addCriterion("sub_brand_id not in", values, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("sub_brand_id between", value1, value2, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_brand_id not between", value1, value2, "subBrandId");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameIsNull() {
            addCriterion("sub_brand_name is null");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameIsNotNull() {
            addCriterion("sub_brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameEqualTo(String value) {
            addCriterion("sub_brand_name =", value, "subBrandName");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameNotEqualTo(String value) {
            addCriterion("sub_brand_name <>", value, "subBrandName");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameGreaterThan(String value) {
            addCriterion("sub_brand_name >", value, "subBrandName");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_brand_name >=", value, "subBrandName");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameLessThan(String value) {
            addCriterion("sub_brand_name <", value, "subBrandName");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameLessThanOrEqualTo(String value) {
            addCriterion("sub_brand_name <=", value, "subBrandName");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameLike(String value) {
            addCriterion("sub_brand_name like", value, "subBrandName");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameNotLike(String value) {
            addCriterion("sub_brand_name not like", value, "subBrandName");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameIn(List<String> values) {
            addCriterion("sub_brand_name in", values, "subBrandName");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameNotIn(List<String> values) {
            addCriterion("sub_brand_name not in", values, "subBrandName");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameBetween(String value1, String value2) {
            addCriterion("sub_brand_name between", value1, value2, "subBrandName");
            return (Criteria) this;
        }

        public Criteria andSubBrandNameNotBetween(String value1, String value2) {
            addCriterion("sub_brand_name not between", value1, value2, "subBrandName");
            return (Criteria) this;
        }

        public Criteria andYearIdIsNull() {
            addCriterion("year_id is null");
            return (Criteria) this;
        }

        public Criteria andYearIdIsNotNull() {
            addCriterion("year_id is not null");
            return (Criteria) this;
        }

        public Criteria andYearIdEqualTo(Integer value) {
            addCriterion("year_id =", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotEqualTo(Integer value) {
            addCriterion("year_id <>", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdGreaterThan(Integer value) {
            addCriterion("year_id >", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("year_id >=", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdLessThan(Integer value) {
            addCriterion("year_id <", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdLessThanOrEqualTo(Integer value) {
            addCriterion("year_id <=", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdIn(List<Integer> values) {
            addCriterion("year_id in", values, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotIn(List<Integer> values) {
            addCriterion("year_id not in", values, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdBetween(Integer value1, Integer value2) {
            addCriterion("year_id between", value1, value2, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotBetween(Integer value1, Integer value2) {
            addCriterion("year_id not between", value1, value2, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearNameIsNull() {
            addCriterion("year_name is null");
            return (Criteria) this;
        }

        public Criteria andYearNameIsNotNull() {
            addCriterion("year_name is not null");
            return (Criteria) this;
        }

        public Criteria andYearNameEqualTo(String value) {
            addCriterion("year_name =", value, "yearName");
            return (Criteria) this;
        }

        public Criteria andYearNameNotEqualTo(String value) {
            addCriterion("year_name <>", value, "yearName");
            return (Criteria) this;
        }

        public Criteria andYearNameGreaterThan(String value) {
            addCriterion("year_name >", value, "yearName");
            return (Criteria) this;
        }

        public Criteria andYearNameGreaterThanOrEqualTo(String value) {
            addCriterion("year_name >=", value, "yearName");
            return (Criteria) this;
        }

        public Criteria andYearNameLessThan(String value) {
            addCriterion("year_name <", value, "yearName");
            return (Criteria) this;
        }

        public Criteria andYearNameLessThanOrEqualTo(String value) {
            addCriterion("year_name <=", value, "yearName");
            return (Criteria) this;
        }

        public Criteria andYearNameLike(String value) {
            addCriterion("year_name like", value, "yearName");
            return (Criteria) this;
        }

        public Criteria andYearNameNotLike(String value) {
            addCriterion("year_name not like", value, "yearName");
            return (Criteria) this;
        }

        public Criteria andYearNameIn(List<String> values) {
            addCriterion("year_name in", values, "yearName");
            return (Criteria) this;
        }

        public Criteria andYearNameNotIn(List<String> values) {
            addCriterion("year_name not in", values, "yearName");
            return (Criteria) this;
        }

        public Criteria andYearNameBetween(String value1, String value2) {
            addCriterion("year_name between", value1, value2, "yearName");
            return (Criteria) this;
        }

        public Criteria andYearNameNotBetween(String value1, String value2) {
            addCriterion("year_name not between", value1, value2, "yearName");
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
     * @Title public.motor_brand_all_attr表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-05 15:00:34
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @Title public.motor_brand_all_attr表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-05 15:00:34
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