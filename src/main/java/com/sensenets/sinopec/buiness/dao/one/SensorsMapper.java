/**
  * SensorsMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-30
  */
package com.sensenets.sinopec.buiness.dao.one;

import com.sensenets.sinopec.buiness.model.one.Sensors;
import com.sensenets.sinopec.buiness.model.one.SensorsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SensorsMapper {
    /**
     *  根据指定的条件获取数据库记录数:public.sensors
     *
     * @param example
     */
    int countByExample(SensorsCriteria example);

    /**
     *  根据指定的条件删除数据库符合条件的记录:public.sensors
     *
     * @param example
     */
    int deleteByExample(SensorsCriteria example);

    /**
     *  根据主键删除数据库的记录:public.sensors
     *
     * @param sensorId
     */
    int deleteByPrimaryKey(String sensorId);

    /**
     *  新写入数据库记录:public.sensors
     *
     * @param record
     */
    int insert(Sensors record);

    /**
     *  动态字段,写入数据库记录:public.sensors
     *
     * @param record
     */
    int insertSelective(Sensors record);

    /**
     *  根据指定的条件查询符合条件的数据库记录:public.sensors
     *
     * @param example
     */
    List<Sensors> selectByExample(SensorsCriteria example);

    /**
     *  根据指定主键获取一条数据库记录:public.sensors
     *
     * @param sensorId
     */
    Sensors selectByPrimaryKey(String sensorId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录:public.sensors
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Sensors record, @Param("example") SensorsCriteria example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录:public.sensors
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Sensors record, @Param("example") SensorsCriteria example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:public.sensors
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Sensors record);

    /**
     *  根据主键来更新符合条件的数据库记录:public.sensors
     *
     * @param record
     */
    int updateByPrimaryKey(Sensors record);
}