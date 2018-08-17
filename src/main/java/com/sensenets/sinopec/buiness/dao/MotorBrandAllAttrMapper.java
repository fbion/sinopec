/**
  * MotorBrandAllAttrMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.model.MotorBrandAllAttr;
import java.util.List;

public interface MotorBrandAllAttrMapper {
    /**
     *  根据主键删除数据库的记录:motor_brand_all_attr
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录:motor_brand_all_attr
     *
     * @param record
     */
    int insert(MotorBrandAllAttr record);

    /**
     *  根据指定主键获取一条数据库记录:motor_brand_all_attr
     *
     * @param id
     */
    MotorBrandAllAttr selectByPrimaryKey(Long id);

    /**
     * :motor_brand_all_attr
     */
    List<MotorBrandAllAttr> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:motor_brand_all_attr
     *
     * @param record
     */
    int updateByPrimaryKey(MotorBrandAllAttr record);
}