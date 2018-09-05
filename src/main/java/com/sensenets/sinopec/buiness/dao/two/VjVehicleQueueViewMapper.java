/**
  * VjVehicleQueueViewMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-04
  */
package com.sensenets.sinopec.buiness.dao.two;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sensenets.sinopec.buiness.model.two.VjVehicleQueueView;
import com.sensenets.sinopec.buiness.model.two.VjVehicleQueueViewCriteria;

public interface VjVehicleQueueViewMapper {
    /**
     *  根据指定的条件获取数据库记录数:public.vj_vehicle_queue_view
     *
     * @param example
     */
    int countByExample(VjVehicleQueueViewCriteria example);

    /**
     *  根据指定的条件查询符合条件的数据库记录:public.vj_vehicle_queue_view
     *
     * @param example
     */
    List<VjVehicleQueueView> selectByExample(VjVehicleQueueViewCriteria example);

    /**
      * @Title: selectByPrimaryKey
      * @Description: 根据主键查询
      * @param id 
      * @return  VjVehicleQueueView
      */
    VjVehicleQueueView selectByPrimaryKey(@Param("id")Long id);

}