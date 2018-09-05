/**
  * MotorBrandAllAttrMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-05
  */
package com.sensenets.sinopec.buiness.dao.one;

import com.sensenets.sinopec.buiness.model.one.MotorBrandAllAttr;
import com.sensenets.sinopec.buiness.model.one.MotorBrandAllAttrCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MotorBrandAllAttrMapper {
    /**
     *  根据指定的条件获取数据库记录数:public.motor_brand_all_attr
     *
     * @param example
     */
    int countByExample(MotorBrandAllAttrCriteria example);

    /**
     *  根据指定的条件删除数据库符合条件的记录:public.motor_brand_all_attr
     *
     * @param example
     */
    int deleteByExample(MotorBrandAllAttrCriteria example);

    /**
     *  根据主键删除数据库的记录:public.motor_brand_all_attr
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录:public.motor_brand_all_attr
     *
     * @param record
     */
    int insert(MotorBrandAllAttr record);

    /**
     *  动态字段,写入数据库记录:public.motor_brand_all_attr
     *
     * @param record
     */
    int insertSelective(MotorBrandAllAttr record);

    /**
     *  根据指定的条件查询符合条件的数据库记录:public.motor_brand_all_attr
     *
     * @param example
     */
    List<MotorBrandAllAttr> selectByExample(MotorBrandAllAttrCriteria example);

    /**
     *  根据指定主键获取一条数据库记录:public.motor_brand_all_attr
     *
     * @param id
     */
    MotorBrandAllAttr selectByPrimaryKey(Long id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录:public.motor_brand_all_attr
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") MotorBrandAllAttr record, @Param("example") MotorBrandAllAttrCriteria example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录:public.motor_brand_all_attr
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") MotorBrandAllAttr record, @Param("example") MotorBrandAllAttrCriteria example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:public.motor_brand_all_attr
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MotorBrandAllAttr record);

    /**
     *  根据主键来更新符合条件的数据库记录:public.motor_brand_all_attr
     *
     * @param record
     */
    int updateByPrimaryKey(MotorBrandAllAttr record);
}