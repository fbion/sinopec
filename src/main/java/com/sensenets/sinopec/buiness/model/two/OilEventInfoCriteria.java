/**
  * OilEventInfoCriteria.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-18
  */
package com.sensenets.sinopec.buiness.model.two;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title public.oil_event_info表实体类
 * @Description 
 * @Version 1.0 
 * @Author kelly 
 * @Date 2018-09-18 15:05:46
 */
public class OilEventInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer pageSize;

    private Integer pageNumber;

    /**
     *  构造查询条件:public.oil_event_info
     */
    public OilEventInfoCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *  设置排序字段:public.oil_event_info
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *  获取排序字段:public.oil_event_info
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *  设置过滤重复数据:public.oil_event_info
     *
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *  是否过滤重复数据:public.oil_event_info
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *  获取当前的查询条件实例:public.oil_event_info
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * :public.oil_event_info
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * :public.oil_event_info
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *  创建一个查询条件:public.oil_event_info
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *  内部构建查询条件对象:public.oil_event_info
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *  清除查询条件:public.oil_event_info
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
     * @Title public.oil_event_info表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-18 15:05:46
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

        public Criteria andOilStationIdIsNull() {
            addCriterion("oil_station_id is null");
            return (Criteria) this;
        }

        public Criteria andOilStationIdIsNotNull() {
            addCriterion("oil_station_id is not null");
            return (Criteria) this;
        }

        public Criteria andOilStationIdEqualTo(String value) {
            addCriterion("oil_station_id =", value, "oilStationId");
            return (Criteria) this;
        }

        public Criteria andOilStationIdNotEqualTo(String value) {
            addCriterion("oil_station_id <>", value, "oilStationId");
            return (Criteria) this;
        }

        public Criteria andOilStationIdGreaterThan(String value) {
            addCriterion("oil_station_id >", value, "oilStationId");
            return (Criteria) this;
        }

        public Criteria andOilStationIdGreaterThanOrEqualTo(String value) {
            addCriterion("oil_station_id >=", value, "oilStationId");
            return (Criteria) this;
        }

        public Criteria andOilStationIdLessThan(String value) {
            addCriterion("oil_station_id <", value, "oilStationId");
            return (Criteria) this;
        }

        public Criteria andOilStationIdLessThanOrEqualTo(String value) {
            addCriterion("oil_station_id <=", value, "oilStationId");
            return (Criteria) this;
        }

        public Criteria andOilStationIdLike(String value) {
            addCriterion("oil_station_id like", value, "oilStationId");
            return (Criteria) this;
        }

        public Criteria andOilStationIdNotLike(String value) {
            addCriterion("oil_station_id not like", value, "oilStationId");
            return (Criteria) this;
        }

        public Criteria andOilStationIdIn(List<String> values) {
            addCriterion("oil_station_id in", values, "oilStationId");
            return (Criteria) this;
        }

        public Criteria andOilStationIdNotIn(List<String> values) {
            addCriterion("oil_station_id not in", values, "oilStationId");
            return (Criteria) this;
        }

        public Criteria andOilStationIdBetween(String value1, String value2) {
            addCriterion("oil_station_id between", value1, value2, "oilStationId");
            return (Criteria) this;
        }

        public Criteria andOilStationIdNotBetween(String value1, String value2) {
            addCriterion("oil_station_id not between", value1, value2, "oilStationId");
            return (Criteria) this;
        }

        public Criteria andOilGunIdIsNull() {
            addCriterion("oil_gun_id is null");
            return (Criteria) this;
        }

        public Criteria andOilGunIdIsNotNull() {
            addCriterion("oil_gun_id is not null");
            return (Criteria) this;
        }

        public Criteria andOilGunIdEqualTo(String value) {
            addCriterion("oil_gun_id =", value, "oilGunId");
            return (Criteria) this;
        }

        public Criteria andOilGunIdNotEqualTo(String value) {
            addCriterion("oil_gun_id <>", value, "oilGunId");
            return (Criteria) this;
        }

        public Criteria andOilGunIdGreaterThan(String value) {
            addCriterion("oil_gun_id >", value, "oilGunId");
            return (Criteria) this;
        }

        public Criteria andOilGunIdGreaterThanOrEqualTo(String value) {
            addCriterion("oil_gun_id >=", value, "oilGunId");
            return (Criteria) this;
        }

        public Criteria andOilGunIdLessThan(String value) {
            addCriterion("oil_gun_id <", value, "oilGunId");
            return (Criteria) this;
        }

        public Criteria andOilGunIdLessThanOrEqualTo(String value) {
            addCriterion("oil_gun_id <=", value, "oilGunId");
            return (Criteria) this;
        }

        public Criteria andOilGunIdLike(String value) {
            addCriterion("oil_gun_id like", value, "oilGunId");
            return (Criteria) this;
        }

        public Criteria andOilGunIdNotLike(String value) {
            addCriterion("oil_gun_id not like", value, "oilGunId");
            return (Criteria) this;
        }

        public Criteria andOilGunIdIn(List<String> values) {
            addCriterion("oil_gun_id in", values, "oilGunId");
            return (Criteria) this;
        }

        public Criteria andOilGunIdNotIn(List<String> values) {
            addCriterion("oil_gun_id not in", values, "oilGunId");
            return (Criteria) this;
        }

        public Criteria andOilGunIdBetween(String value1, String value2) {
            addCriterion("oil_gun_id between", value1, value2, "oilGunId");
            return (Criteria) this;
        }

        public Criteria andOilGunIdNotBetween(String value1, String value2) {
            addCriterion("oil_gun_id not between", value1, value2, "oilGunId");
            return (Criteria) this;
        }

        public Criteria andLiftTimestampIsNull() {
            addCriterion("lift_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andLiftTimestampIsNotNull() {
            addCriterion("lift_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andLiftTimestampEqualTo(Date value) {
            addCriterion("lift_timestamp =", value, "liftTimestamp");
            return (Criteria) this;
        }

        public Criteria andLiftTimestampNotEqualTo(Date value) {
            addCriterion("lift_timestamp <>", value, "liftTimestamp");
            return (Criteria) this;
        }

        public Criteria andLiftTimestampGreaterThan(Date value) {
            addCriterion("lift_timestamp >", value, "liftTimestamp");
            return (Criteria) this;
        }

        public Criteria andLiftTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("lift_timestamp >=", value, "liftTimestamp");
            return (Criteria) this;
        }

        public Criteria andLiftTimestampLessThan(Date value) {
            addCriterion("lift_timestamp <", value, "liftTimestamp");
            return (Criteria) this;
        }

        public Criteria andLiftTimestampLessThanOrEqualTo(Date value) {
            addCriterion("lift_timestamp <=", value, "liftTimestamp");
            return (Criteria) this;
        }

        public Criteria andLiftTimestampIn(List<Date> values) {
            addCriterion("lift_timestamp in", values, "liftTimestamp");
            return (Criteria) this;
        }

        public Criteria andLiftTimestampNotIn(List<Date> values) {
            addCriterion("lift_timestamp not in", values, "liftTimestamp");
            return (Criteria) this;
        }

        public Criteria andLiftTimestampBetween(Date value1, Date value2) {
            addCriterion("lift_timestamp between", value1, value2, "liftTimestamp");
            return (Criteria) this;
        }

        public Criteria andLiftTimestampNotBetween(Date value1, Date value2) {
            addCriterion("lift_timestamp not between", value1, value2, "liftTimestamp");
            return (Criteria) this;
        }

        public Criteria andHangTimestampIsNull() {
            addCriterion("hang_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andHangTimestampIsNotNull() {
            addCriterion("hang_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andHangTimestampEqualTo(Date value) {
            addCriterion("hang_timestamp =", value, "hangTimestamp");
            return (Criteria) this;
        }

        public Criteria andHangTimestampNotEqualTo(Date value) {
            addCriterion("hang_timestamp <>", value, "hangTimestamp");
            return (Criteria) this;
        }

        public Criteria andHangTimestampGreaterThan(Date value) {
            addCriterion("hang_timestamp >", value, "hangTimestamp");
            return (Criteria) this;
        }

        public Criteria andHangTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("hang_timestamp >=", value, "hangTimestamp");
            return (Criteria) this;
        }

        public Criteria andHangTimestampLessThan(Date value) {
            addCriterion("hang_timestamp <", value, "hangTimestamp");
            return (Criteria) this;
        }

        public Criteria andHangTimestampLessThanOrEqualTo(Date value) {
            addCriterion("hang_timestamp <=", value, "hangTimestamp");
            return (Criteria) this;
        }

        public Criteria andHangTimestampIn(List<Date> values) {
            addCriterion("hang_timestamp in", values, "hangTimestamp");
            return (Criteria) this;
        }

        public Criteria andHangTimestampNotIn(List<Date> values) {
            addCriterion("hang_timestamp not in", values, "hangTimestamp");
            return (Criteria) this;
        }

        public Criteria andHangTimestampBetween(Date value1, Date value2) {
            addCriterion("hang_timestamp between", value1, value2, "hangTimestamp");
            return (Criteria) this;
        }

        public Criteria andHangTimestampNotBetween(Date value1, Date value2) {
            addCriterion("hang_timestamp not between", value1, value2, "hangTimestamp");
            return (Criteria) this;
        }

        public Criteria andTccNoIsNull() {
            addCriterion("tcc_no is null");
            return (Criteria) this;
        }

        public Criteria andTccNoIsNotNull() {
            addCriterion("tcc_no is not null");
            return (Criteria) this;
        }

        public Criteria andTccNoEqualTo(String value) {
            addCriterion("tcc_no =", value, "tccNo");
            return (Criteria) this;
        }

        public Criteria andTccNoNotEqualTo(String value) {
            addCriterion("tcc_no <>", value, "tccNo");
            return (Criteria) this;
        }

        public Criteria andTccNoGreaterThan(String value) {
            addCriterion("tcc_no >", value, "tccNo");
            return (Criteria) this;
        }

        public Criteria andTccNoGreaterThanOrEqualTo(String value) {
            addCriterion("tcc_no >=", value, "tccNo");
            return (Criteria) this;
        }

        public Criteria andTccNoLessThan(String value) {
            addCriterion("tcc_no <", value, "tccNo");
            return (Criteria) this;
        }

        public Criteria andTccNoLessThanOrEqualTo(String value) {
            addCriterion("tcc_no <=", value, "tccNo");
            return (Criteria) this;
        }

        public Criteria andTccNoLike(String value) {
            addCriterion("tcc_no like", value, "tccNo");
            return (Criteria) this;
        }

        public Criteria andTccNoNotLike(String value) {
            addCriterion("tcc_no not like", value, "tccNo");
            return (Criteria) this;
        }

        public Criteria andTccNoIn(List<String> values) {
            addCriterion("tcc_no in", values, "tccNo");
            return (Criteria) this;
        }

        public Criteria andTccNoNotIn(List<String> values) {
            addCriterion("tcc_no not in", values, "tccNo");
            return (Criteria) this;
        }

        public Criteria andTccNoBetween(String value1, String value2) {
            addCriterion("tcc_no between", value1, value2, "tccNo");
            return (Criteria) this;
        }

        public Criteria andTccNoNotBetween(String value1, String value2) {
            addCriterion("tcc_no not between", value1, value2, "tccNo");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumIsNull() {
            addCriterion("oil_type_num is null");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumIsNotNull() {
            addCriterion("oil_type_num is not null");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumEqualTo(String value) {
            addCriterion("oil_type_num =", value, "oilTypeNum");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumNotEqualTo(String value) {
            addCriterion("oil_type_num <>", value, "oilTypeNum");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumGreaterThan(String value) {
            addCriterion("oil_type_num >", value, "oilTypeNum");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumGreaterThanOrEqualTo(String value) {
            addCriterion("oil_type_num >=", value, "oilTypeNum");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumLessThan(String value) {
            addCriterion("oil_type_num <", value, "oilTypeNum");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumLessThanOrEqualTo(String value) {
            addCriterion("oil_type_num <=", value, "oilTypeNum");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumLike(String value) {
            addCriterion("oil_type_num like", value, "oilTypeNum");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumNotLike(String value) {
            addCriterion("oil_type_num not like", value, "oilTypeNum");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumIn(List<String> values) {
            addCriterion("oil_type_num in", values, "oilTypeNum");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumNotIn(List<String> values) {
            addCriterion("oil_type_num not in", values, "oilTypeNum");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumBetween(String value1, String value2) {
            addCriterion("oil_type_num between", value1, value2, "oilTypeNum");
            return (Criteria) this;
        }

        public Criteria andOilTypeNumNotBetween(String value1, String value2) {
            addCriterion("oil_type_num not between", value1, value2, "oilTypeNum");
            return (Criteria) this;
        }

        public Criteria andOilCardIdIsNull() {
            addCriterion("oil_card_id is null");
            return (Criteria) this;
        }

        public Criteria andOilCardIdIsNotNull() {
            addCriterion("oil_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andOilCardIdEqualTo(String value) {
            addCriterion("oil_card_id =", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdNotEqualTo(String value) {
            addCriterion("oil_card_id <>", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdGreaterThan(String value) {
            addCriterion("oil_card_id >", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("oil_card_id >=", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdLessThan(String value) {
            addCriterion("oil_card_id <", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdLessThanOrEqualTo(String value) {
            addCriterion("oil_card_id <=", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdLike(String value) {
            addCriterion("oil_card_id like", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdNotLike(String value) {
            addCriterion("oil_card_id not like", value, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdIn(List<String> values) {
            addCriterion("oil_card_id in", values, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdNotIn(List<String> values) {
            addCriterion("oil_card_id not in", values, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdBetween(String value1, String value2) {
            addCriterion("oil_card_id between", value1, value2, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andOilCardIdNotBetween(String value1, String value2) {
            addCriterion("oil_card_id not between", value1, value2, "oilCardId");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateIsNull() {
            addCriterion("limit_vehicle_plate is null");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateIsNotNull() {
            addCriterion("limit_vehicle_plate is not null");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateEqualTo(String value) {
            addCriterion("limit_vehicle_plate =", value, "limitVehiclePlate");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateNotEqualTo(String value) {
            addCriterion("limit_vehicle_plate <>", value, "limitVehiclePlate");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateGreaterThan(String value) {
            addCriterion("limit_vehicle_plate >", value, "limitVehiclePlate");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateGreaterThanOrEqualTo(String value) {
            addCriterion("limit_vehicle_plate >=", value, "limitVehiclePlate");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateLessThan(String value) {
            addCriterion("limit_vehicle_plate <", value, "limitVehiclePlate");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateLessThanOrEqualTo(String value) {
            addCriterion("limit_vehicle_plate <=", value, "limitVehiclePlate");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateLike(String value) {
            addCriterion("limit_vehicle_plate like", value, "limitVehiclePlate");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateNotLike(String value) {
            addCriterion("limit_vehicle_plate not like", value, "limitVehiclePlate");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateIn(List<String> values) {
            addCriterion("limit_vehicle_plate in", values, "limitVehiclePlate");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateNotIn(List<String> values) {
            addCriterion("limit_vehicle_plate not in", values, "limitVehiclePlate");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateBetween(String value1, String value2) {
            addCriterion("limit_vehicle_plate between", value1, value2, "limitVehiclePlate");
            return (Criteria) this;
        }

        public Criteria andLimitVehiclePlateNotBetween(String value1, String value2) {
            addCriterion("limit_vehicle_plate not between", value1, value2, "limitVehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateIsNull() {
            addCriterion("vehicle_plate is null");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateIsNotNull() {
            addCriterion("vehicle_plate is not null");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateEqualTo(String value) {
            addCriterion("vehicle_plate =", value, "vehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateNotEqualTo(String value) {
            addCriterion("vehicle_plate <>", value, "vehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateGreaterThan(String value) {
            addCriterion("vehicle_plate >", value, "vehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_plate >=", value, "vehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateLessThan(String value) {
            addCriterion("vehicle_plate <", value, "vehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateLessThanOrEqualTo(String value) {
            addCriterion("vehicle_plate <=", value, "vehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateLike(String value) {
            addCriterion("vehicle_plate like", value, "vehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateNotLike(String value) {
            addCriterion("vehicle_plate not like", value, "vehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateIn(List<String> values) {
            addCriterion("vehicle_plate in", values, "vehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateNotIn(List<String> values) {
            addCriterion("vehicle_plate not in", values, "vehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateBetween(String value1, String value2) {
            addCriterion("vehicle_plate between", value1, value2, "vehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateNotBetween(String value1, String value2) {
            addCriterion("vehicle_plate not between", value1, value2, "vehiclePlate");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandIsNull() {
            addCriterion("vehicle_brand is null");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandIsNotNull() {
            addCriterion("vehicle_brand is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandEqualTo(String value) {
            addCriterion("vehicle_brand =", value, "vehicleBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandNotEqualTo(String value) {
            addCriterion("vehicle_brand <>", value, "vehicleBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandGreaterThan(String value) {
            addCriterion("vehicle_brand >", value, "vehicleBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_brand >=", value, "vehicleBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandLessThan(String value) {
            addCriterion("vehicle_brand <", value, "vehicleBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandLessThanOrEqualTo(String value) {
            addCriterion("vehicle_brand <=", value, "vehicleBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandLike(String value) {
            addCriterion("vehicle_brand like", value, "vehicleBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandNotLike(String value) {
            addCriterion("vehicle_brand not like", value, "vehicleBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandIn(List<String> values) {
            addCriterion("vehicle_brand in", values, "vehicleBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandNotIn(List<String> values) {
            addCriterion("vehicle_brand not in", values, "vehicleBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandBetween(String value1, String value2) {
            addCriterion("vehicle_brand between", value1, value2, "vehicleBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleBrandNotBetween(String value1, String value2) {
            addCriterion("vehicle_brand not between", value1, value2, "vehicleBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandIsNull() {
            addCriterion("vehicle_sub_brand is null");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandIsNotNull() {
            addCriterion("vehicle_sub_brand is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandEqualTo(String value) {
            addCriterion("vehicle_sub_brand =", value, "vehicleSubBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandNotEqualTo(String value) {
            addCriterion("vehicle_sub_brand <>", value, "vehicleSubBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandGreaterThan(String value) {
            addCriterion("vehicle_sub_brand >", value, "vehicleSubBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_sub_brand >=", value, "vehicleSubBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandLessThan(String value) {
            addCriterion("vehicle_sub_brand <", value, "vehicleSubBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandLessThanOrEqualTo(String value) {
            addCriterion("vehicle_sub_brand <=", value, "vehicleSubBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandLike(String value) {
            addCriterion("vehicle_sub_brand like", value, "vehicleSubBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandNotLike(String value) {
            addCriterion("vehicle_sub_brand not like", value, "vehicleSubBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandIn(List<String> values) {
            addCriterion("vehicle_sub_brand in", values, "vehicleSubBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandNotIn(List<String> values) {
            addCriterion("vehicle_sub_brand not in", values, "vehicleSubBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandBetween(String value1, String value2) {
            addCriterion("vehicle_sub_brand between", value1, value2, "vehicleSubBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleSubBrandNotBetween(String value1, String value2) {
            addCriterion("vehicle_sub_brand not between", value1, value2, "vehicleSubBrand");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleIsNull() {
            addCriterion("vehicle_style is null");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleIsNotNull() {
            addCriterion("vehicle_style is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleEqualTo(String value) {
            addCriterion("vehicle_style =", value, "vehicleStyle");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleNotEqualTo(String value) {
            addCriterion("vehicle_style <>", value, "vehicleStyle");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleGreaterThan(String value) {
            addCriterion("vehicle_style >", value, "vehicleStyle");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_style >=", value, "vehicleStyle");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleLessThan(String value) {
            addCriterion("vehicle_style <", value, "vehicleStyle");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleLessThanOrEqualTo(String value) {
            addCriterion("vehicle_style <=", value, "vehicleStyle");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleLike(String value) {
            addCriterion("vehicle_style like", value, "vehicleStyle");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleNotLike(String value) {
            addCriterion("vehicle_style not like", value, "vehicleStyle");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleIn(List<String> values) {
            addCriterion("vehicle_style in", values, "vehicleStyle");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleNotIn(List<String> values) {
            addCriterion("vehicle_style not in", values, "vehicleStyle");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleBetween(String value1, String value2) {
            addCriterion("vehicle_style between", value1, value2, "vehicleStyle");
            return (Criteria) this;
        }

        public Criteria andVehicleStyleNotBetween(String value1, String value2) {
            addCriterion("vehicle_style not between", value1, value2, "vehicleStyle");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIsNull() {
            addCriterion("vehicle_type is null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIsNotNull() {
            addCriterion("vehicle_type is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeEqualTo(String value) {
            addCriterion("vehicle_type =", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotEqualTo(String value) {
            addCriterion("vehicle_type <>", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeGreaterThan(String value) {
            addCriterion("vehicle_type >", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_type >=", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLessThan(String value) {
            addCriterion("vehicle_type <", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLessThanOrEqualTo(String value) {
            addCriterion("vehicle_type <=", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLike(String value) {
            addCriterion("vehicle_type like", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotLike(String value) {
            addCriterion("vehicle_type not like", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIn(List<String> values) {
            addCriterion("vehicle_type in", values, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotIn(List<String> values) {
            addCriterion("vehicle_type not in", values, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeBetween(String value1, String value2) {
            addCriterion("vehicle_type between", value1, value2, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotBetween(String value1, String value2) {
            addCriterion("vehicle_type not between", value1, value2, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleColorIsNull() {
            addCriterion("vehicle_color is null");
            return (Criteria) this;
        }

        public Criteria andVehicleColorIsNotNull() {
            addCriterion("vehicle_color is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleColorEqualTo(String value) {
            addCriterion("vehicle_color =", value, "vehicleColor");
            return (Criteria) this;
        }

        public Criteria andVehicleColorNotEqualTo(String value) {
            addCriterion("vehicle_color <>", value, "vehicleColor");
            return (Criteria) this;
        }

        public Criteria andVehicleColorGreaterThan(String value) {
            addCriterion("vehicle_color >", value, "vehicleColor");
            return (Criteria) this;
        }

        public Criteria andVehicleColorGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_color >=", value, "vehicleColor");
            return (Criteria) this;
        }

        public Criteria andVehicleColorLessThan(String value) {
            addCriterion("vehicle_color <", value, "vehicleColor");
            return (Criteria) this;
        }

        public Criteria andVehicleColorLessThanOrEqualTo(String value) {
            addCriterion("vehicle_color <=", value, "vehicleColor");
            return (Criteria) this;
        }

        public Criteria andVehicleColorLike(String value) {
            addCriterion("vehicle_color like", value, "vehicleColor");
            return (Criteria) this;
        }

        public Criteria andVehicleColorNotLike(String value) {
            addCriterion("vehicle_color not like", value, "vehicleColor");
            return (Criteria) this;
        }

        public Criteria andVehicleColorIn(List<String> values) {
            addCriterion("vehicle_color in", values, "vehicleColor");
            return (Criteria) this;
        }

        public Criteria andVehicleColorNotIn(List<String> values) {
            addCriterion("vehicle_color not in", values, "vehicleColor");
            return (Criteria) this;
        }

        public Criteria andVehicleColorBetween(String value1, String value2) {
            addCriterion("vehicle_color between", value1, value2, "vehicleColor");
            return (Criteria) this;
        }

        public Criteria andVehicleColorNotBetween(String value1, String value2) {
            addCriterion("vehicle_color not between", value1, value2, "vehicleColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleIsNull() {
            addCriterion("vehicle_plate_tyle is null");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleIsNotNull() {
            addCriterion("vehicle_plate_tyle is not null");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleEqualTo(String value) {
            addCriterion("vehicle_plate_tyle =", value, "vehiclePlateTyle");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleNotEqualTo(String value) {
            addCriterion("vehicle_plate_tyle <>", value, "vehiclePlateTyle");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleGreaterThan(String value) {
            addCriterion("vehicle_plate_tyle >", value, "vehiclePlateTyle");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_plate_tyle >=", value, "vehiclePlateTyle");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleLessThan(String value) {
            addCriterion("vehicle_plate_tyle <", value, "vehiclePlateTyle");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleLessThanOrEqualTo(String value) {
            addCriterion("vehicle_plate_tyle <=", value, "vehiclePlateTyle");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleLike(String value) {
            addCriterion("vehicle_plate_tyle like", value, "vehiclePlateTyle");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleNotLike(String value) {
            addCriterion("vehicle_plate_tyle not like", value, "vehiclePlateTyle");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleIn(List<String> values) {
            addCriterion("vehicle_plate_tyle in", values, "vehiclePlateTyle");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleNotIn(List<String> values) {
            addCriterion("vehicle_plate_tyle not in", values, "vehiclePlateTyle");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleBetween(String value1, String value2) {
            addCriterion("vehicle_plate_tyle between", value1, value2, "vehiclePlateTyle");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateTyleNotBetween(String value1, String value2) {
            addCriterion("vehicle_plate_tyle not between", value1, value2, "vehiclePlateTyle");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorIsNull() {
            addCriterion("vehicle_plate_color is null");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorIsNotNull() {
            addCriterion("vehicle_plate_color is not null");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorEqualTo(String value) {
            addCriterion("vehicle_plate_color =", value, "vehiclePlateColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorNotEqualTo(String value) {
            addCriterion("vehicle_plate_color <>", value, "vehiclePlateColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorGreaterThan(String value) {
            addCriterion("vehicle_plate_color >", value, "vehiclePlateColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_plate_color >=", value, "vehiclePlateColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorLessThan(String value) {
            addCriterion("vehicle_plate_color <", value, "vehiclePlateColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorLessThanOrEqualTo(String value) {
            addCriterion("vehicle_plate_color <=", value, "vehiclePlateColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorLike(String value) {
            addCriterion("vehicle_plate_color like", value, "vehiclePlateColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorNotLike(String value) {
            addCriterion("vehicle_plate_color not like", value, "vehiclePlateColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorIn(List<String> values) {
            addCriterion("vehicle_plate_color in", values, "vehiclePlateColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorNotIn(List<String> values) {
            addCriterion("vehicle_plate_color not in", values, "vehiclePlateColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorBetween(String value1, String value2) {
            addCriterion("vehicle_plate_color between", value1, value2, "vehiclePlateColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateColorNotBetween(String value1, String value2) {
            addCriterion("vehicle_plate_color not between", value1, value2, "vehiclePlateColor");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlIsNull() {
            addCriterion("vehicle_plate_image_url is null");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlIsNotNull() {
            addCriterion("vehicle_plate_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlEqualTo(String value) {
            addCriterion("vehicle_plate_image_url =", value, "vehiclePlateImageUrl");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlNotEqualTo(String value) {
            addCriterion("vehicle_plate_image_url <>", value, "vehiclePlateImageUrl");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlGreaterThan(String value) {
            addCriterion("vehicle_plate_image_url >", value, "vehiclePlateImageUrl");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_plate_image_url >=", value, "vehiclePlateImageUrl");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlLessThan(String value) {
            addCriterion("vehicle_plate_image_url <", value, "vehiclePlateImageUrl");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlLessThanOrEqualTo(String value) {
            addCriterion("vehicle_plate_image_url <=", value, "vehiclePlateImageUrl");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlLike(String value) {
            addCriterion("vehicle_plate_image_url like", value, "vehiclePlateImageUrl");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlNotLike(String value) {
            addCriterion("vehicle_plate_image_url not like", value, "vehiclePlateImageUrl");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlIn(List<String> values) {
            addCriterion("vehicle_plate_image_url in", values, "vehiclePlateImageUrl");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlNotIn(List<String> values) {
            addCriterion("vehicle_plate_image_url not in", values, "vehiclePlateImageUrl");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlBetween(String value1, String value2) {
            addCriterion("vehicle_plate_image_url between", value1, value2, "vehiclePlateImageUrl");
            return (Criteria) this;
        }

        public Criteria andVehiclePlateImageUrlNotBetween(String value1, String value2) {
            addCriterion("vehicle_plate_image_url not between", value1, value2, "vehiclePlateImageUrl");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosIsNull() {
            addCriterion("additional_infos is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosIsNotNull() {
            addCriterion("additional_infos is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosEqualTo(String value) {
            addCriterion("additional_infos =", value, "additionalInfos");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosNotEqualTo(String value) {
            addCriterion("additional_infos <>", value, "additionalInfos");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosGreaterThan(String value) {
            addCriterion("additional_infos >", value, "additionalInfos");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosGreaterThanOrEqualTo(String value) {
            addCriterion("additional_infos >=", value, "additionalInfos");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosLessThan(String value) {
            addCriterion("additional_infos <", value, "additionalInfos");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosLessThanOrEqualTo(String value) {
            addCriterion("additional_infos <=", value, "additionalInfos");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosLike(String value) {
            addCriterion("additional_infos like", value, "additionalInfos");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosNotLike(String value) {
            addCriterion("additional_infos not like", value, "additionalInfos");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosIn(List<String> values) {
            addCriterion("additional_infos in", values, "additionalInfos");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosNotIn(List<String> values) {
            addCriterion("additional_infos not in", values, "additionalInfos");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosBetween(String value1, String value2) {
            addCriterion("additional_infos between", value1, value2, "additionalInfos");
            return (Criteria) this;
        }

        public Criteria andAdditionalInfosNotBetween(String value1, String value2) {
            addCriterion("additional_infos not between", value1, value2, "additionalInfos");
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Float value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Float value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Float value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Float value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Float value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Float> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Float> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Float value1, Float value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Float value1, Float value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }
    }

    /**
     * @Title public.oil_event_info表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-18 15:05:46
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @Title public.oil_event_info表实体类
     * @Description 
     * @Version 1.0 
     * @Author kelly 
     * @Date 2018-09-18 15:05:46
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