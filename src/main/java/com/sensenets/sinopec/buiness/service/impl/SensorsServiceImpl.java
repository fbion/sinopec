package com.sensenets.sinopec.buiness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.dao.one.SensorsMapper;
import com.sensenets.sinopec.buiness.model.one.Sensors;
import com.sensenets.sinopec.buiness.model.one.SensorsCriteria;
import com.sensenets.sinopec.buiness.service.ISensorsService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SensorsServiceImpl implements ISensorsService {
    @Autowired
    private SensorsMapper sensorsMapper;

    public int countByExample(SensorsCriteria example) {
        int count = this.sensorsMapper.countByExample(example);
        log.debug("count: {}", count);
        return count;
    }

    public Sensors selectByPrimaryKey(String sensorId) {
        return this.sensorsMapper.selectByPrimaryKey(sensorId);
    }

    public List<Sensors> selectByExample(SensorsCriteria example) {
        return this.sensorsMapper.selectByExample(example);
    }

    public PageInfo<Sensors> selectPageByExample(SensorsCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<Sensors> list = this.sensorsMapper.selectByExample(example);
        PageInfo<Sensors> pageInfo = new PageInfo<Sensors>(list);
        return pageInfo;
    }

    public int deleteByPrimaryKey(String sensorId) {
        return this.sensorsMapper.deleteByPrimaryKey(sensorId);
    }

    public int updateByPrimaryKeySelective(Sensors record) {
        return this.sensorsMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Sensors record) {
        return this.sensorsMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(SensorsCriteria example) {
        return this.sensorsMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Sensors record, SensorsCriteria example) {
        return this.sensorsMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Sensors record, SensorsCriteria example) {
        return this.sensorsMapper.updateByExample(record, example);
    }

    public int insert(Sensors record) {
        return this.sensorsMapper.insert(record);
    }

    public int insertSelective(Sensors record) {
        return this.sensorsMapper.insertSelective(record);
    }
}