package com.sensenets.sinopec.buiness.service;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.model.one.Sensors;
import com.sensenets.sinopec.buiness.model.one.SensorsCriteria;
import java.util.List;

public interface ISensorsService {
    int countByExample(SensorsCriteria example);

    Sensors selectByPrimaryKey(String sensorId);

    List<Sensors> selectByExample(SensorsCriteria example);

    PageInfo<Sensors> selectPageByExample(SensorsCriteria example);

    int deleteByPrimaryKey(String sensorId);

    int updateByPrimaryKeySelective(Sensors record);

    int updateByPrimaryKey(Sensors record);

    int deleteByExample(SensorsCriteria example);

    int updateByExampleSelective(Sensors record, SensorsCriteria example);

    int updateByExample(Sensors record, SensorsCriteria example);

    int insert(Sensors record);

    int insertSelective(Sensors record);
}