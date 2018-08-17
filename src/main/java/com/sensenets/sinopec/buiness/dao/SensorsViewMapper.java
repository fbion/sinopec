/**
  * SensorsViewMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.model.SensorsView;
import java.util.List;

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