/**
  * VehicleQueueMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-10
  */
package com.sensenets.sinopec.buiness.dao.two;

import com.sensenets.sinopec.buiness.model.two.VehicleQueue;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleQueueMapper {
    /**
     *  根据指定的条件获取数据库记录数:public.vehicle_queue
     *
     * @param example
     */
    int countByExample(VehicleQueueCriteria example);

    /**
     *  根据指定的条件删除数据库符合条件的记录:public.vehicle_queue
     *
     * @param example
     */
    int deleteByExample(VehicleQueueCriteria example);

    /**
     *  根据主键删除数据库的记录:public.vehicle_queue
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录:public.vehicle_queue
     *
     * @param record
     */
    int insert(VehicleQueue record);
    

    /**
     *  动态字段,写入数据库记录:public.vehicle_queue
     *
     * @param record
     */
    int insertSelective(VehicleQueue record);

    /**
     *  根据指定的条件查询符合条件的数据库记录:public.vehicle_queue
     *
     * @param example
     */
    List<VehicleQueue> selectByExample(VehicleQueueCriteria example);

    /**
     *  根据指定主键获取一条数据库记录:public.vehicle_queue
     *
     * @param id
     */
    VehicleQueue selectByPrimaryKey(Long id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录:public.vehicle_queue
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") VehicleQueue record, @Param("example") VehicleQueueCriteria example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录:public.vehicle_queue
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") VehicleQueue record, @Param("example") VehicleQueueCriteria example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:public.vehicle_queue
     *
     * @param record
     */
    int updateByPrimaryKeySelective(VehicleQueue record);

    /**
     *  根据主键来更新符合条件的数据库记录:public.vehicle_queue
     *
     * @param record
     */
    int updateByPrimaryKey(VehicleQueue record);
}