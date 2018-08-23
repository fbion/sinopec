/**
  * SensorsViewMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import com.sensenets.sinopec.buiness.model.one.SensorsView;

public interface SensorsViewMapper {
    /**
     *  新写入数据库记录:sensors_view
     *
     * @param record
     */
    int insert(SensorsView record);

    /**
     * :sensors_view
     */
    List<SensorsView> selectAll();
}