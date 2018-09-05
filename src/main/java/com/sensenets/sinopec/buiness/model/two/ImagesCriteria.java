/**
  * ImagesCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-05
  */
package com.sensenets.sinopec.buiness.model.two;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title public.images表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-09-05 14:00:11
 */
public class ImagesCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     *  构造查询条件:public.images
     */
    public ImagesCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *  设置排序字段:public.images
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *  获取排序字段:public.images
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *  设置过滤重复数据:public.images
     *
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *  是否过滤重复数据:public.images
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *  获取当前的查询条件实例:public.images
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * :public.images
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * :public.images
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *  创建一个查询条件:public.images
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *  内部构建查询条件对象:public.images
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *  清除查询条件:public.images
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
     * @Title public.images表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-05 14:00:11
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

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(String value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(String value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(String value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(String value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(String value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLike(String value) {
            addCriterion("source_id like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotLike(String value) {
            addCriterion("source_id not like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<String> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<String> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(String value1, String value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(String value1, String value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
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

        public Criteria andImageUriIsNull() {
            addCriterion("image_uri is null");
            return (Criteria) this;
        }

        public Criteria andImageUriIsNotNull() {
            addCriterion("image_uri is not null");
            return (Criteria) this;
        }

        public Criteria andImageUriEqualTo(String value) {
            addCriterion("image_uri =", value, "imageUri");
            return (Criteria) this;
        }

        public Criteria andImageUriNotEqualTo(String value) {
            addCriterion("image_uri <>", value, "imageUri");
            return (Criteria) this;
        }

        public Criteria andImageUriGreaterThan(String value) {
            addCriterion("image_uri >", value, "imageUri");
            return (Criteria) this;
        }

        public Criteria andImageUriGreaterThanOrEqualTo(String value) {
            addCriterion("image_uri >=", value, "imageUri");
            return (Criteria) this;
        }

        public Criteria andImageUriLessThan(String value) {
            addCriterion("image_uri <", value, "imageUri");
            return (Criteria) this;
        }

        public Criteria andImageUriLessThanOrEqualTo(String value) {
            addCriterion("image_uri <=", value, "imageUri");
            return (Criteria) this;
        }

        public Criteria andImageUriLike(String value) {
            addCriterion("image_uri like", value, "imageUri");
            return (Criteria) this;
        }

        public Criteria andImageUriNotLike(String value) {
            addCriterion("image_uri not like", value, "imageUri");
            return (Criteria) this;
        }

        public Criteria andImageUriIn(List<String> values) {
            addCriterion("image_uri in", values, "imageUri");
            return (Criteria) this;
        }

        public Criteria andImageUriNotIn(List<String> values) {
            addCriterion("image_uri not in", values, "imageUri");
            return (Criteria) this;
        }

        public Criteria andImageUriBetween(String value1, String value2) {
            addCriterion("image_uri between", value1, value2, "imageUri");
            return (Criteria) this;
        }

        public Criteria andImageUriNotBetween(String value1, String value2) {
            addCriterion("image_uri not between", value1, value2, "imageUri");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(Integer value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(Integer value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(Integer value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(Integer value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(Integer value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<Integer> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<Integer> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(Integer value1, Integer value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriIsNull() {
            addCriterion("thumbnail_image_uri is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriIsNotNull() {
            addCriterion("thumbnail_image_uri is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriEqualTo(String value) {
            addCriterion("thumbnail_image_uri =", value, "thumbnailImageUri");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriNotEqualTo(String value) {
            addCriterion("thumbnail_image_uri <>", value, "thumbnailImageUri");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriGreaterThan(String value) {
            addCriterion("thumbnail_image_uri >", value, "thumbnailImageUri");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriGreaterThanOrEqualTo(String value) {
            addCriterion("thumbnail_image_uri >=", value, "thumbnailImageUri");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriLessThan(String value) {
            addCriterion("thumbnail_image_uri <", value, "thumbnailImageUri");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriLessThanOrEqualTo(String value) {
            addCriterion("thumbnail_image_uri <=", value, "thumbnailImageUri");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriLike(String value) {
            addCriterion("thumbnail_image_uri like", value, "thumbnailImageUri");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriNotLike(String value) {
            addCriterion("thumbnail_image_uri not like", value, "thumbnailImageUri");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriIn(List<String> values) {
            addCriterion("thumbnail_image_uri in", values, "thumbnailImageUri");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriNotIn(List<String> values) {
            addCriterion("thumbnail_image_uri not in", values, "thumbnailImageUri");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriBetween(String value1, String value2) {
            addCriterion("thumbnail_image_uri between", value1, value2, "thumbnailImageUri");
            return (Criteria) this;
        }

        public Criteria andThumbnailImageUriNotBetween(String value1, String value2) {
            addCriterion("thumbnail_image_uri not between", value1, value2, "thumbnailImageUri");
            return (Criteria) this;
        }

        public Criteria andThumbnailWidthIsNull() {
            addCriterion("thumbnail_width is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailWidthIsNotNull() {
            addCriterion("thumbnail_width is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailWidthEqualTo(Integer value) {
            addCriterion("thumbnail_width =", value, "thumbnailWidth");
            return (Criteria) this;
        }

        public Criteria andThumbnailWidthNotEqualTo(Integer value) {
            addCriterion("thumbnail_width <>", value, "thumbnailWidth");
            return (Criteria) this;
        }

        public Criteria andThumbnailWidthGreaterThan(Integer value) {
            addCriterion("thumbnail_width >", value, "thumbnailWidth");
            return (Criteria) this;
        }

        public Criteria andThumbnailWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("thumbnail_width >=", value, "thumbnailWidth");
            return (Criteria) this;
        }

        public Criteria andThumbnailWidthLessThan(Integer value) {
            addCriterion("thumbnail_width <", value, "thumbnailWidth");
            return (Criteria) this;
        }

        public Criteria andThumbnailWidthLessThanOrEqualTo(Integer value) {
            addCriterion("thumbnail_width <=", value, "thumbnailWidth");
            return (Criteria) this;
        }

        public Criteria andThumbnailWidthIn(List<Integer> values) {
            addCriterion("thumbnail_width in", values, "thumbnailWidth");
            return (Criteria) this;
        }

        public Criteria andThumbnailWidthNotIn(List<Integer> values) {
            addCriterion("thumbnail_width not in", values, "thumbnailWidth");
            return (Criteria) this;
        }

        public Criteria andThumbnailWidthBetween(Integer value1, Integer value2) {
            addCriterion("thumbnail_width between", value1, value2, "thumbnailWidth");
            return (Criteria) this;
        }

        public Criteria andThumbnailWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("thumbnail_width not between", value1, value2, "thumbnailWidth");
            return (Criteria) this;
        }

        public Criteria andThumbnailHeightIsNull() {
            addCriterion("thumbnail_height is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailHeightIsNotNull() {
            addCriterion("thumbnail_height is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailHeightEqualTo(Integer value) {
            addCriterion("thumbnail_height =", value, "thumbnailHeight");
            return (Criteria) this;
        }

        public Criteria andThumbnailHeightNotEqualTo(Integer value) {
            addCriterion("thumbnail_height <>", value, "thumbnailHeight");
            return (Criteria) this;
        }

        public Criteria andThumbnailHeightGreaterThan(Integer value) {
            addCriterion("thumbnail_height >", value, "thumbnailHeight");
            return (Criteria) this;
        }

        public Criteria andThumbnailHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("thumbnail_height >=", value, "thumbnailHeight");
            return (Criteria) this;
        }

        public Criteria andThumbnailHeightLessThan(Integer value) {
            addCriterion("thumbnail_height <", value, "thumbnailHeight");
            return (Criteria) this;
        }

        public Criteria andThumbnailHeightLessThanOrEqualTo(Integer value) {
            addCriterion("thumbnail_height <=", value, "thumbnailHeight");
            return (Criteria) this;
        }

        public Criteria andThumbnailHeightIn(List<Integer> values) {
            addCriterion("thumbnail_height in", values, "thumbnailHeight");
            return (Criteria) this;
        }

        public Criteria andThumbnailHeightNotIn(List<Integer> values) {
            addCriterion("thumbnail_height not in", values, "thumbnailHeight");
            return (Criteria) this;
        }

        public Criteria andThumbnailHeightBetween(Integer value1, Integer value2) {
            addCriterion("thumbnail_height between", value1, value2, "thumbnailHeight");
            return (Criteria) this;
        }

        public Criteria andThumbnailHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("thumbnail_height not between", value1, value2, "thumbnailHeight");
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
    }

    /**
     * @Title public.images表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-05 14:00:11
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @Title public.images表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-05 14:00:11
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