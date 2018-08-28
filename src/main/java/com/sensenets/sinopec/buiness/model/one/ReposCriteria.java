/**
  * ReposCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-28
  */
package com.sensenets.sinopec.buiness.model.one;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title public.repos表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-08-28 16:28:34
 */
public class ReposCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     *  构造查询条件:public.repos
     */
    public ReposCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *  设置排序字段:public.repos
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *  获取排序字段:public.repos
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *  设置过滤重复数据:public.repos
     *
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *  是否过滤重复数据:public.repos
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *  获取当前的查询条件实例:public.repos
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * :public.repos
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * :public.repos
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *  创建一个查询条件:public.repos
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *  内部构建查询条件对象:public.repos
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *  清除查询条件:public.repos
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
     * @Title public.repos表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-28 16:28:34
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

        public Criteria andRepoNameIsNull() {
            addCriterion("repo_name is null");
            return (Criteria) this;
        }

        public Criteria andRepoNameIsNotNull() {
            addCriterion("repo_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepoNameEqualTo(String value) {
            addCriterion("repo_name =", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameNotEqualTo(String value) {
            addCriterion("repo_name <>", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameGreaterThan(String value) {
            addCriterion("repo_name >", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameGreaterThanOrEqualTo(String value) {
            addCriterion("repo_name >=", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameLessThan(String value) {
            addCriterion("repo_name <", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameLessThanOrEqualTo(String value) {
            addCriterion("repo_name <=", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameLike(String value) {
            addCriterion("repo_name like", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameNotLike(String value) {
            addCriterion("repo_name not like", value, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameIn(List<String> values) {
            addCriterion("repo_name in", values, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameNotIn(List<String> values) {
            addCriterion("repo_name not in", values, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameBetween(String value1, String value2) {
            addCriterion("repo_name between", value1, value2, "repoName");
            return (Criteria) this;
        }

        public Criteria andRepoNameNotBetween(String value1, String value2) {
            addCriterion("repo_name not between", value1, value2, "repoName");
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

        public Criteria andRepoSnIsNull() {
            addCriterion("repo_sn is null");
            return (Criteria) this;
        }

        public Criteria andRepoSnIsNotNull() {
            addCriterion("repo_sn is not null");
            return (Criteria) this;
        }

        public Criteria andRepoSnEqualTo(String value) {
            addCriterion("repo_sn =", value, "repoSn");
            return (Criteria) this;
        }

        public Criteria andRepoSnNotEqualTo(String value) {
            addCriterion("repo_sn <>", value, "repoSn");
            return (Criteria) this;
        }

        public Criteria andRepoSnGreaterThan(String value) {
            addCriterion("repo_sn >", value, "repoSn");
            return (Criteria) this;
        }

        public Criteria andRepoSnGreaterThanOrEqualTo(String value) {
            addCriterion("repo_sn >=", value, "repoSn");
            return (Criteria) this;
        }

        public Criteria andRepoSnLessThan(String value) {
            addCriterion("repo_sn <", value, "repoSn");
            return (Criteria) this;
        }

        public Criteria andRepoSnLessThanOrEqualTo(String value) {
            addCriterion("repo_sn <=", value, "repoSn");
            return (Criteria) this;
        }

        public Criteria andRepoSnLike(String value) {
            addCriterion("repo_sn like", value, "repoSn");
            return (Criteria) this;
        }

        public Criteria andRepoSnNotLike(String value) {
            addCriterion("repo_sn not like", value, "repoSn");
            return (Criteria) this;
        }

        public Criteria andRepoSnIn(List<String> values) {
            addCriterion("repo_sn in", values, "repoSn");
            return (Criteria) this;
        }

        public Criteria andRepoSnNotIn(List<String> values) {
            addCriterion("repo_sn not in", values, "repoSn");
            return (Criteria) this;
        }

        public Criteria andRepoSnBetween(String value1, String value2) {
            addCriterion("repo_sn between", value1, value2, "repoSn");
            return (Criteria) this;
        }

        public Criteria andRepoSnNotBetween(String value1, String value2) {
            addCriterion("repo_sn not between", value1, value2, "repoSn");
            return (Criteria) this;
        }

        public Criteria andRepoLevelIsNull() {
            addCriterion("repo_level is null");
            return (Criteria) this;
        }

        public Criteria andRepoLevelIsNotNull() {
            addCriterion("repo_level is not null");
            return (Criteria) this;
        }

        public Criteria andRepoLevelEqualTo(Short value) {
            addCriterion("repo_level =", value, "repoLevel");
            return (Criteria) this;
        }

        public Criteria andRepoLevelNotEqualTo(Short value) {
            addCriterion("repo_level <>", value, "repoLevel");
            return (Criteria) this;
        }

        public Criteria andRepoLevelGreaterThan(Short value) {
            addCriterion("repo_level >", value, "repoLevel");
            return (Criteria) this;
        }

        public Criteria andRepoLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("repo_level >=", value, "repoLevel");
            return (Criteria) this;
        }

        public Criteria andRepoLevelLessThan(Short value) {
            addCriterion("repo_level <", value, "repoLevel");
            return (Criteria) this;
        }

        public Criteria andRepoLevelLessThanOrEqualTo(Short value) {
            addCriterion("repo_level <=", value, "repoLevel");
            return (Criteria) this;
        }

        public Criteria andRepoLevelIn(List<Short> values) {
            addCriterion("repo_level in", values, "repoLevel");
            return (Criteria) this;
        }

        public Criteria andRepoLevelNotIn(List<Short> values) {
            addCriterion("repo_level not in", values, "repoLevel");
            return (Criteria) this;
        }

        public Criteria andRepoLevelBetween(Short value1, Short value2) {
            addCriterion("repo_level between", value1, value2, "repoLevel");
            return (Criteria) this;
        }

        public Criteria andRepoLevelNotBetween(Short value1, Short value2) {
            addCriterion("repo_level not between", value1, value2, "repoLevel");
            return (Criteria) this;
        }

        public Criteria andLevelIdIsNull() {
            addCriterion("level_id is null");
            return (Criteria) this;
        }

        public Criteria andLevelIdIsNotNull() {
            addCriterion("level_id is not null");
            return (Criteria) this;
        }

        public Criteria andLevelIdEqualTo(Short value) {
            addCriterion("level_id =", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotEqualTo(Short value) {
            addCriterion("level_id <>", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdGreaterThan(Short value) {
            addCriterion("level_id >", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdGreaterThanOrEqualTo(Short value) {
            addCriterion("level_id >=", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdLessThan(Short value) {
            addCriterion("level_id <", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdLessThanOrEqualTo(Short value) {
            addCriterion("level_id <=", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdIn(List<Short> values) {
            addCriterion("level_id in", values, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotIn(List<Short> values) {
            addCriterion("level_id not in", values, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdBetween(Short value1, Short value2) {
            addCriterion("level_id between", value1, value2, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotBetween(Short value1, Short value2) {
            addCriterion("level_id not between", value1, value2, "levelId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andLeftIdIsNull() {
            addCriterion("left_id is null");
            return (Criteria) this;
        }

        public Criteria andLeftIdIsNotNull() {
            addCriterion("left_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeftIdEqualTo(String value) {
            addCriterion("left_id =", value, "leftId");
            return (Criteria) this;
        }

        public Criteria andLeftIdNotEqualTo(String value) {
            addCriterion("left_id <>", value, "leftId");
            return (Criteria) this;
        }

        public Criteria andLeftIdGreaterThan(String value) {
            addCriterion("left_id >", value, "leftId");
            return (Criteria) this;
        }

        public Criteria andLeftIdGreaterThanOrEqualTo(String value) {
            addCriterion("left_id >=", value, "leftId");
            return (Criteria) this;
        }

        public Criteria andLeftIdLessThan(String value) {
            addCriterion("left_id <", value, "leftId");
            return (Criteria) this;
        }

        public Criteria andLeftIdLessThanOrEqualTo(String value) {
            addCriterion("left_id <=", value, "leftId");
            return (Criteria) this;
        }

        public Criteria andLeftIdLike(String value) {
            addCriterion("left_id like", value, "leftId");
            return (Criteria) this;
        }

        public Criteria andLeftIdNotLike(String value) {
            addCriterion("left_id not like", value, "leftId");
            return (Criteria) this;
        }

        public Criteria andLeftIdIn(List<String> values) {
            addCriterion("left_id in", values, "leftId");
            return (Criteria) this;
        }

        public Criteria andLeftIdNotIn(List<String> values) {
            addCriterion("left_id not in", values, "leftId");
            return (Criteria) this;
        }

        public Criteria andLeftIdBetween(String value1, String value2) {
            addCriterion("left_id between", value1, value2, "leftId");
            return (Criteria) this;
        }

        public Criteria andLeftIdNotBetween(String value1, String value2) {
            addCriterion("left_id not between", value1, value2, "leftId");
            return (Criteria) this;
        }

        public Criteria andRightIdIsNull() {
            addCriterion("right_id is null");
            return (Criteria) this;
        }

        public Criteria andRightIdIsNotNull() {
            addCriterion("right_id is not null");
            return (Criteria) this;
        }

        public Criteria andRightIdEqualTo(String value) {
            addCriterion("right_id =", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdNotEqualTo(String value) {
            addCriterion("right_id <>", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdGreaterThan(String value) {
            addCriterion("right_id >", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdGreaterThanOrEqualTo(String value) {
            addCriterion("right_id >=", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdLessThan(String value) {
            addCriterion("right_id <", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdLessThanOrEqualTo(String value) {
            addCriterion("right_id <=", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdLike(String value) {
            addCriterion("right_id like", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdNotLike(String value) {
            addCriterion("right_id not like", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdIn(List<String> values) {
            addCriterion("right_id in", values, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdNotIn(List<String> values) {
            addCriterion("right_id not in", values, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdBetween(String value1, String value2) {
            addCriterion("right_id between", value1, value2, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdNotBetween(String value1, String value2) {
            addCriterion("right_id not between", value1, value2, "rightId");
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
    }

    /**
     * @Title public.repos表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-28 16:28:34
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @Title public.repos表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-08-28 16:28:34
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