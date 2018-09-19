package com.sensenets.sinopec.buiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.dao.one.SensorsMapper;
import com.sensenets.sinopec.buiness.dao.two.VehiclesMapper;
import com.sensenets.sinopec.buiness.model.two.Vehicles;
import com.sensenets.sinopec.buiness.model.two.VehiclesCriteria;
import com.sensenets.sinopec.buiness.service.IIndexCountService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IIndexCountServiceImpl implements IIndexCountService {
    
    @Autowired
    private VehiclesMapper vehiclesMapper;
    
    @Autowired
    private SensorsMapper sensorsMapper;

    public int countByExample(VehiclesCriteria example) {
        int count = this.vehiclesMapper.countByExample(example);
        return count;
    }

    public List<Vehicles> selectByExample(VehiclesCriteria example) {
        return this.vehiclesMapper.selectByExample(example);
    }

    public PageInfo<Vehicles> selectPageByExample(VehiclesCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<Vehicles> list = this.vehiclesMapper.selectByExample(example);
        PageInfo<Vehicles> pageInfo = new PageInfo<Vehicles>(list);
        return pageInfo;
    }

    public List<Short> selectVehiclesType(VehiclesCriteria example) {
        return this.vehiclesMapper.selectVehiclesType(example);
    }
 
   


    
}