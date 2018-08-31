/**
  * VehiclesMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-30
  */
package com.sensenets.sinopec.buiness.dao.two;

import com.sensenets.sinopec.buiness.model.two.Vehicles;
import com.sensenets.sinopec.buiness.model.two.VehiclesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehiclesMapper {
    /**
     *  根据指定的条件获取数据库记录数:public.vehicles
     *
     * @param example
     */
    int countByExample(VehiclesCriteria example);

    /**
     *  根据指定的条件删除数据库符合条件的记录:public.vehicles
     *
     * @param example
     */
    int deleteByExample(VehiclesCriteria example);

    /**
     *  新写入数据库记录:public.vehicles
     *
     * @param record
     */
    int insert(Vehicles record);

    /**
     *  动态字段,写入数据库记录:public.vehicles
     *
     * @param record
     */
    int insertSelective(Vehicles record);

    /**
     *  根据指定的条件查询符合条件的数据库记录:public.vehicles
     *
     * @param example
     */
    List<Vehicles> selectByExample(VehiclesCriteria example);
    
    /**
      * @Title: selectVehiclesType
      * @Description: 查询所有车型
      * @param example
      * @return
      */
    List<Short> selectVehiclesType(VehiclesCriteria example);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录:public.vehicles
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Vehicles record, @Param("example") VehiclesCriteria example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录:public.vehicles
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Vehicles record, @Param("example") VehiclesCriteria example);
}