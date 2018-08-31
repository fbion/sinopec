/**
  * SensorsCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-30
  */
package com.sensenets.sinopec.buiness.model.one;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title public.sensors表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-30 14:38:04
 */
public class SensorsCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     *  构造查询条件:public.sensors
     */
    public SensorsCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *  设置排序字段:public.sensors
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *  获取排序字段:public.sensors
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *  设置过滤重复数据:public.sensors
     *
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *  是否过滤重复数据:public.sensors
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *  获取当前的查询条件实例:public.sensors
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * :public.sensors
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * :public.sensors
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *  创建一个查询条件:public.sensors
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *  内部构建查询条件对象:public.sensors
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *  清除查询条件:public.sensors
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
     * @Title public.sensors表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-30 14:38:04
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

        public Criteria andSensorNameIsNull() {
            addCriterion("sensor_name is null");
            return (Criteria) this;
        }

        public Criteria andSensorNameIsNotNull() {
            addCriterion("sensor_name is not null");
            return (Criteria) this;
        }

        public Criteria andSensorNameEqualTo(String value) {
            addCriterion("sensor_name =", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameNotEqualTo(String value) {
            addCriterion("sensor_name <>", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameGreaterThan(String value) {
            addCriterion("sensor_name >", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_name >=", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameLessThan(String value) {
            addCriterion("sensor_name <", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameLessThanOrEqualTo(String value) {
            addCriterion("sensor_name <=", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameLike(String value) {
            addCriterion("sensor_name like", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameNotLike(String value) {
            addCriterion("sensor_name not like", value, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameIn(List<String> values) {
            addCriterion("sensor_name in", values, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameNotIn(List<String> values) {
            addCriterion("sensor_name not in", values, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameBetween(String value1, String value2) {
            addCriterion("sensor_name between", value1, value2, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorNameNotBetween(String value1, String value2) {
            addCriterion("sensor_name not between", value1, value2, "sensorName");
            return (Criteria) this;
        }

        public Criteria andSensorSnIsNull() {
            addCriterion("sensor_sn is null");
            return (Criteria) this;
        }

        public Criteria andSensorSnIsNotNull() {
            addCriterion("sensor_sn is not null");
            return (Criteria) this;
        }

        public Criteria andSensorSnEqualTo(String value) {
            addCriterion("sensor_sn =", value, "sensorSn");
            return (Criteria) this;
        }

        public Criteria andSensorSnNotEqualTo(String value) {
            addCriterion("sensor_sn <>", value, "sensorSn");
            return (Criteria) this;
        }

        public Criteria andSensorSnGreaterThan(String value) {
            addCriterion("sensor_sn >", value, "sensorSn");
            return (Criteria) this;
        }

        public Criteria andSensorSnGreaterThanOrEqualTo(String value) {
            addCriterion("sensor_sn >=", value, "sensorSn");
            return (Criteria) this;
        }

        public Criteria andSensorSnLessThan(String value) {
            addCriterion("sensor_sn <", value, "sensorSn");
            return (Criteria) this;
        }

        public Criteria andSensorSnLessThanOrEqualTo(String value) {
            addCriterion("sensor_sn <=", value, "sensorSn");
            return (Criteria) this;
        }

        public Criteria andSensorSnLike(String value) {
            addCriterion("sensor_sn like", value, "sensorSn");
            return (Criteria) this;
        }

        public Criteria andSensorSnNotLike(String value) {
            addCriterion("sensor_sn not like", value, "sensorSn");
            return (Criteria) this;
        }

        public Criteria andSensorSnIn(List<String> values) {
            addCriterion("sensor_sn in", values, "sensorSn");
            return (Criteria) this;
        }

        public Criteria andSensorSnNotIn(List<String> values) {
            addCriterion("sensor_sn not in", values, "sensorSn");
            return (Criteria) this;
        }

        public Criteria andSensorSnBetween(String value1, String value2) {
            addCriterion("sensor_sn between", value1, value2, "sensorSn");
            return (Criteria) this;
        }

        public Criteria andSensorSnNotBetween(String value1, String value2) {
            addCriterion("sensor_sn not between", value1, value2, "sensorSn");
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

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(Long value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Long value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Long value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Long value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Long value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Long value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Long> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Long> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Long value1, Long value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Long value1, Long value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Long value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Long value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Long value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Long value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Long value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Long value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Long> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Long> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Long value1, Long value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Long value1, Long value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
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

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("port like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("port not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<String> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<String> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andRenderedurlIsNull() {
            addCriterion("renderedurl is null");
            return (Criteria) this;
        }

        public Criteria andRenderedurlIsNotNull() {
            addCriterion("renderedurl is not null");
            return (Criteria) this;
        }

        public Criteria andRenderedurlEqualTo(String value) {
            addCriterion("renderedurl =", value, "renderedurl");
            return (Criteria) this;
        }

        public Criteria andRenderedurlNotEqualTo(String value) {
            addCriterion("renderedurl <>", value, "renderedurl");
            return (Criteria) this;
        }

        public Criteria andRenderedurlGreaterThan(String value) {
            addCriterion("renderedurl >", value, "renderedurl");
            return (Criteria) this;
        }

        public Criteria andRenderedurlGreaterThanOrEqualTo(String value) {
            addCriterion("renderedurl >=", value, "renderedurl");
            return (Criteria) this;
        }

        public Criteria andRenderedurlLessThan(String value) {
            addCriterion("renderedurl <", value, "renderedurl");
            return (Criteria) this;
        }

        public Criteria andRenderedurlLessThanOrEqualTo(String value) {
            addCriterion("renderedurl <=", value, "renderedurl");
            return (Criteria) this;
        }

        public Criteria andRenderedurlLike(String value) {
            addCriterion("renderedurl like", value, "renderedurl");
            return (Criteria) this;
        }

        public Criteria andRenderedurlNotLike(String value) {
            addCriterion("renderedurl not like", value, "renderedurl");
            return (Criteria) this;
        }

        public Criteria andRenderedurlIn(List<String> values) {
            addCriterion("renderedurl in", values, "renderedurl");
            return (Criteria) this;
        }

        public Criteria andRenderedurlNotIn(List<String> values) {
            addCriterion("renderedurl not in", values, "renderedurl");
            return (Criteria) this;
        }

        public Criteria andRenderedurlBetween(String value1, String value2) {
            addCriterion("renderedurl between", value1, value2, "renderedurl");
            return (Criteria) this;
        }

        public Criteria andRenderedurlNotBetween(String value1, String value2) {
            addCriterion("renderedurl not between", value1, value2, "renderedurl");
            return (Criteria) this;
        }

        public Criteria andRtmpurlIsNull() {
            addCriterion("rtmpurl is null");
            return (Criteria) this;
        }

        public Criteria andRtmpurlIsNotNull() {
            addCriterion("rtmpurl is not null");
            return (Criteria) this;
        }

        public Criteria andRtmpurlEqualTo(String value) {
            addCriterion("rtmpurl =", value, "rtmpurl");
            return (Criteria) this;
        }

        public Criteria andRtmpurlNotEqualTo(String value) {
            addCriterion("rtmpurl <>", value, "rtmpurl");
            return (Criteria) this;
        }

        public Criteria andRtmpurlGreaterThan(String value) {
            addCriterion("rtmpurl >", value, "rtmpurl");
            return (Criteria) this;
        }

        public Criteria andRtmpurlGreaterThanOrEqualTo(String value) {
            addCriterion("rtmpurl >=", value, "rtmpurl");
            return (Criteria) this;
        }

        public Criteria andRtmpurlLessThan(String value) {
            addCriterion("rtmpurl <", value, "rtmpurl");
            return (Criteria) this;
        }

        public Criteria andRtmpurlLessThanOrEqualTo(String value) {
            addCriterion("rtmpurl <=", value, "rtmpurl");
            return (Criteria) this;
        }

        public Criteria andRtmpurlLike(String value) {
            addCriterion("rtmpurl like", value, "rtmpurl");
            return (Criteria) this;
        }

        public Criteria andRtmpurlNotLike(String value) {
            addCriterion("rtmpurl not like", value, "rtmpurl");
            return (Criteria) this;
        }

        public Criteria andRtmpurlIn(List<String> values) {
            addCriterion("rtmpurl in", values, "rtmpurl");
            return (Criteria) this;
        }

        public Criteria andRtmpurlNotIn(List<String> values) {
            addCriterion("rtmpurl not in", values, "rtmpurl");
            return (Criteria) this;
        }

        public Criteria andRtmpurlBetween(String value1, String value2) {
            addCriterion("rtmpurl between", value1, value2, "rtmpurl");
            return (Criteria) this;
        }

        public Criteria andRtmpurlNotBetween(String value1, String value2) {
            addCriterion("rtmpurl not between", value1, value2, "rtmpurl");
            return (Criteria) this;
        }

        public Criteria andLiveActiveIsNull() {
            addCriterion("live_active is null");
            return (Criteria) this;
        }

        public Criteria andLiveActiveIsNotNull() {
            addCriterion("live_active is not null");
            return (Criteria) this;
        }

        public Criteria andLiveActiveEqualTo(Boolean value) {
            addCriterion("live_active =", value, "liveActive");
            return (Criteria) this;
        }

        public Criteria andLiveActiveNotEqualTo(Boolean value) {
            addCriterion("live_active <>", value, "liveActive");
            return (Criteria) this;
        }

        public Criteria andLiveActiveGreaterThan(Boolean value) {
            addCriterion("live_active >", value, "liveActive");
            return (Criteria) this;
        }

        public Criteria andLiveActiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("live_active >=", value, "liveActive");
            return (Criteria) this;
        }

        public Criteria andLiveActiveLessThan(Boolean value) {
            addCriterion("live_active <", value, "liveActive");
            return (Criteria) this;
        }

        public Criteria andLiveActiveLessThanOrEqualTo(Boolean value) {
            addCriterion("live_active <=", value, "liveActive");
            return (Criteria) this;
        }

        public Criteria andLiveActiveIn(List<Boolean> values) {
            addCriterion("live_active in", values, "liveActive");
            return (Criteria) this;
        }

        public Criteria andLiveActiveNotIn(List<Boolean> values) {
            addCriterion("live_active not in", values, "liveActive");
            return (Criteria) this;
        }

        public Criteria andLiveActiveBetween(Boolean value1, Boolean value2) {
            addCriterion("live_active between", value1, value2, "liveActive");
            return (Criteria) this;
        }

        public Criteria andLiveActiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("live_active not between", value1, value2, "liveActive");
            return (Criteria) this;
        }

        public Criteria andDataActiveIsNull() {
            addCriterion("data_active is null");
            return (Criteria) this;
        }

        public Criteria andDataActiveIsNotNull() {
            addCriterion("data_active is not null");
            return (Criteria) this;
        }

        public Criteria andDataActiveEqualTo(Boolean value) {
            addCriterion("data_active =", value, "dataActive");
            return (Criteria) this;
        }

        public Criteria andDataActiveNotEqualTo(Boolean value) {
            addCriterion("data_active <>", value, "dataActive");
            return (Criteria) this;
        }

        public Criteria andDataActiveGreaterThan(Boolean value) {
            addCriterion("data_active >", value, "dataActive");
            return (Criteria) this;
        }

        public Criteria andDataActiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("data_active >=", value, "dataActive");
            return (Criteria) this;
        }

        public Criteria andDataActiveLessThan(Boolean value) {
            addCriterion("data_active <", value, "dataActive");
            return (Criteria) this;
        }

        public Criteria andDataActiveLessThanOrEqualTo(Boolean value) {
            addCriterion("data_active <=", value, "dataActive");
            return (Criteria) this;
        }

        public Criteria andDataActiveIn(List<Boolean> values) {
            addCriterion("data_active in", values, "dataActive");
            return (Criteria) this;
        }

        public Criteria andDataActiveNotIn(List<Boolean> values) {
            addCriterion("data_active not in", values, "dataActive");
            return (Criteria) this;
        }

        public Criteria andDataActiveBetween(Boolean value1, Boolean value2) {
            addCriterion("data_active between", value1, value2, "dataActive");
            return (Criteria) this;
        }

        public Criteria andDataActiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("data_active not between", value1, value2, "dataActive");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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

        public Criteria andRoisIsNull() {
            addCriterion("rois is null");
            return (Criteria) this;
        }

        public Criteria andRoisIsNotNull() {
            addCriterion("rois is not null");
            return (Criteria) this;
        }

        public Criteria andRoisEqualTo(String value) {
            addCriterion("rois =", value, "rois");
            return (Criteria) this;
        }

        public Criteria andRoisNotEqualTo(String value) {
            addCriterion("rois <>", value, "rois");
            return (Criteria) this;
        }

        public Criteria andRoisGreaterThan(String value) {
            addCriterion("rois >", value, "rois");
            return (Criteria) this;
        }

        public Criteria andRoisGreaterThanOrEqualTo(String value) {
            addCriterion("rois >=", value, "rois");
            return (Criteria) this;
        }

        public Criteria andRoisLessThan(String value) {
            addCriterion("rois <", value, "rois");
            return (Criteria) this;
        }

        public Criteria andRoisLessThanOrEqualTo(String value) {
            addCriterion("rois <=", value, "rois");
            return (Criteria) this;
        }

        public Criteria andRoisLike(String value) {
            addCriterion("rois like", value, "rois");
            return (Criteria) this;
        }

        public Criteria andRoisNotLike(String value) {
            addCriterion("rois not like", value, "rois");
            return (Criteria) this;
        }

        public Criteria andRoisIn(List<String> values) {
            addCriterion("rois in", values, "rois");
            return (Criteria) this;
        }

        public Criteria andRoisNotIn(List<String> values) {
            addCriterion("rois not in", values, "rois");
            return (Criteria) this;
        }

        public Criteria andRoisBetween(String value1, String value2) {
            addCriterion("rois between", value1, value2, "rois");
            return (Criteria) this;
        }

        public Criteria andRoisNotBetween(String value1, String value2) {
            addCriterion("rois not between", value1, value2, "rois");
            return (Criteria) this;
        }

        public Criteria andLanesIsNull() {
            addCriterion("lanes is null");
            return (Criteria) this;
        }

        public Criteria andLanesIsNotNull() {
            addCriterion("lanes is not null");
            return (Criteria) this;
        }

        public Criteria andLanesEqualTo(String value) {
            addCriterion("lanes =", value, "lanes");
            return (Criteria) this;
        }

        public Criteria andLanesNotEqualTo(String value) {
            addCriterion("lanes <>", value, "lanes");
            return (Criteria) this;
        }

        public Criteria andLanesGreaterThan(String value) {
            addCriterion("lanes >", value, "lanes");
            return (Criteria) this;
        }

        public Criteria andLanesGreaterThanOrEqualTo(String value) {
            addCriterion("lanes >=", value, "lanes");
            return (Criteria) this;
        }

        public Criteria andLanesLessThan(String value) {
            addCriterion("lanes <", value, "lanes");
            return (Criteria) this;
        }

        public Criteria andLanesLessThanOrEqualTo(String value) {
            addCriterion("lanes <=", value, "lanes");
            return (Criteria) this;
        }

        public Criteria andLanesLike(String value) {
            addCriterion("lanes like", value, "lanes");
            return (Criteria) this;
        }

        public Criteria andLanesNotLike(String value) {
            addCriterion("lanes not like", value, "lanes");
            return (Criteria) this;
        }

        public Criteria andLanesIn(List<String> values) {
            addCriterion("lanes in", values, "lanes");
            return (Criteria) this;
        }

        public Criteria andLanesNotIn(List<String> values) {
            addCriterion("lanes not in", values, "lanes");
            return (Criteria) this;
        }

        public Criteria andLanesBetween(String value1, String value2) {
            addCriterion("lanes between", value1, value2, "lanes");
            return (Criteria) this;
        }

        public Criteria andLanesNotBetween(String value1, String value2) {
            addCriterion("lanes not between", value1, value2, "lanes");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIsNull() {
            addCriterion("platform_type is null");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIsNotNull() {
            addCriterion("platform_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeEqualTo(Short value) {
            addCriterion("platform_type =", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotEqualTo(Short value) {
            addCriterion("platform_type <>", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeGreaterThan(Short value) {
            addCriterion("platform_type >", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("platform_type >=", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeLessThan(Short value) {
            addCriterion("platform_type <", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeLessThanOrEqualTo(Short value) {
            addCriterion("platform_type <=", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIn(List<Short> values) {
            addCriterion("platform_type in", values, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotIn(List<Short> values) {
            addCriterion("platform_type not in", values, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeBetween(Short value1, Short value2) {
            addCriterion("platform_type between", value1, value2, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotBetween(Short value1, Short value2) {
            addCriterion("platform_type not between", value1, value2, "platformType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIsNull() {
            addCriterion("group_type is null");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIsNotNull() {
            addCriterion("group_type is not null");
            return (Criteria) this;
        }

        public Criteria andGroupTypeEqualTo(Short value) {
            addCriterion("group_type =", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotEqualTo(Short value) {
            addCriterion("group_type <>", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeGreaterThan(Short value) {
            addCriterion("group_type >", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("group_type >=", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeLessThan(Short value) {
            addCriterion("group_type <", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeLessThanOrEqualTo(Short value) {
            addCriterion("group_type <=", value, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeIn(List<Short> values) {
            addCriterion("group_type in", values, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotIn(List<Short> values) {
            addCriterion("group_type not in", values, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeBetween(Short value1, Short value2) {
            addCriterion("group_type between", value1, value2, "groupType");
            return (Criteria) this;
        }

        public Criteria andGroupTypeNotBetween(Short value1, Short value2) {
            addCriterion("group_type not between", value1, value2, "groupType");
            return (Criteria) this;
        }
    }

    /**
     * @Title public.sensors表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-30 14:38:04
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @Title public.sensors表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-30 14:38:04
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