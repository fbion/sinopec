package com.sensenets.sinopec.buiness.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.condition.VehicleQueueCondition;
import com.sensenets.sinopec.buiness.dto.VehicleQueueDto;
import com.sensenets.sinopec.buiness.model.two.VehicleQueue;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueCriteria;

public interface IVehicleQueueService {
    int countByExample(VehicleQueueCriteria example);

    VehicleQueue selectByPrimaryKey(Long id);

    List<VehicleQueue> selectByExample(VehicleQueueCriteria example);

    PageInfo<VehicleQueueDto> selectPageByExample(VehicleQueueCondition example);

    int updateByPrimaryKeySelective(VehicleQueue record);

    int updateByPrimaryKey(VehicleQueue record);

    int updateByExampleSelective(VehicleQueue record, VehicleQueueCriteria example);

    int updateByExample(VehicleQueue record, VehicleQueueCriteria example);

    int insert(VehicleQueue record);

    int insertSelective(VehicleQueue record);
}