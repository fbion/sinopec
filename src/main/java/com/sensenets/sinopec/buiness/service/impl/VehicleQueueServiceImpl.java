package com.sensenets.sinopec.buiness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.dao.two.VehicleQueueMapper;
import com.sensenets.sinopec.buiness.model.two.VehicleQueue;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueCriteria;
import com.sensenets.sinopec.buiness.service.IVehicleQueueService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VehicleQueueServiceImpl implements IVehicleQueueService {
    @Autowired
    private VehicleQueueMapper vehicleQueueMapper;

    public int countByExample(VehicleQueueCriteria example) {
        int count = this.vehicleQueueMapper.countByExample(example);
        log.debug("count: {}", count);
        return count;
    }

    public VehicleQueue selectByPrimaryKey(String bizId) {
        return this.vehicleQueueMapper.selectByPrimaryKey(bizId);
    }

    public List<VehicleQueue> selectByExample(VehicleQueueCriteria example) {
        return this.vehicleQueueMapper.selectByExample(example);
    }

    public PageInfo<VehicleQueue> selectPageByExample(VehicleQueueCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<VehicleQueue> list = this.vehicleQueueMapper.selectByExample(example);
        PageInfo<VehicleQueue> pageInfo = new PageInfo<VehicleQueue>(list);
        return pageInfo;
    }

    public int deleteByExample(VehicleQueueCriteria example) {
        return this.vehicleQueueMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(VehicleQueue record, VehicleQueueCriteria example) {
        return this.vehicleQueueMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(VehicleQueue record, VehicleQueueCriteria example) {
        return this.vehicleQueueMapper.updateByExample(record, example);
    }

    public int insert(VehicleQueue record) {
        return this.vehicleQueueMapper.insert(record);
    }

    public int insertSelective(VehicleQueue record) {
        return this.vehicleQueueMapper.insertSelective(record);
    }
}