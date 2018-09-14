/**
  * VehicleQueueAnalysisMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-13
  */
package com.sensenets.sinopec.buiness.dao.two;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sensenets.sinopec.buiness.model.two.VehicleQueueAnalysis;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueAnalysisCount;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueAnalysisCriteria;

public interface VehicleQueueAnalysisMapper {
    /**
     *  根据指定的条件获取数据库记录数:public.vehicle_queue_analysis
     *
     * @param example
     */
    int countByExample(VehicleQueueAnalysisCriteria example);

    /**
     *  根据指定的条件删除数据库符合条件的记录:public.vehicle_queue_analysis
     *
     * @param example
     */
    int deleteByExample(VehicleQueueAnalysisCriteria example);

    /**
     *  根据主键删除数据库的记录:public.vehicle_queue_analysis
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录:public.vehicle_queue_analysis
     *
     * @param record
     */
    int insert(VehicleQueueAnalysis record);

    /**
     *  动态字段,写入数据库记录:public.vehicle_queue_analysis
     *
     * @param record
     */
    int insertSelective(VehicleQueueAnalysis record);

    /**
     *  根据指定的条件查询符合条件的数据库记录:public.vehicle_queue_analysis
     *
     * @param example
     */
    List<VehicleQueueAnalysis> selectByExample(VehicleQueueAnalysisCriteria example);

    /**
     *  根据指定主键获取一条数据库记录:public.vehicle_queue_analysis
     *
     * @param id
     */
    VehicleQueueAnalysis selectByPrimaryKey(Long id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录:public.vehicle_queue_analysis
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") VehicleQueueAnalysis record, @Param("example") VehicleQueueAnalysisCriteria example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录:public.vehicle_queue_analysis
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") VehicleQueueAnalysis record, @Param("example") VehicleQueueAnalysisCriteria example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:public.vehicle_queue_analysis
     *
     * @param record
     */
    int updateByPrimaryKeySelective(VehicleQueueAnalysis record);

    /**
     *  根据主键来更新符合条件的数据库记录:public.vehicle_queue_analysis
     *
     * @param record
     */
    int updateByPrimaryKey(VehicleQueueAnalysis record);

    /**
      * @Title: selectAnalysisCount
      * @Description: 查询分析结果
      * @param example 查询条件
      * @return 结果
      */
    VehicleQueueAnalysisCount selectAnalysisCount(VehicleQueueAnalysisCriteria example);
}