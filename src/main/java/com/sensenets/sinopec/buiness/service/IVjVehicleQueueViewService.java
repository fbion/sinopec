package com.sensenets.sinopec.buiness.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.condition.VehicleQueueCondition;
import com.sensenets.sinopec.buiness.dto.VehicleQueueDto;
import com.sensenets.sinopec.buiness.model.two.VjVehicleQueueView;
import com.sensenets.sinopec.buiness.model.two.VjVehicleQueueViewCriteria;

public interface IVjVehicleQueueViewService {
    
    int countByExample(VjVehicleQueueViewCriteria example);

    VjVehicleQueueView selectByPrimaryKey(Long id);

    List<VjVehicleQueueView> selectByExample(VjVehicleQueueViewCriteria example);

    PageInfo<VehicleQueueDto> selectPageByExample(VehicleQueueCondition condition);
}