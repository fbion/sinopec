package com.sensenets.sinopec.buiness.service;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.model.two.VehicleQueue;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueCriteria;
import java.util.List;

public interface IVehicleQueueService {
    int countByExample(VehicleQueueCriteria example);

    VehicleQueue selectByPrimaryKey(String bizId);

    List<VehicleQueue> selectByExample(VehicleQueueCriteria example);

    PageInfo<VehicleQueue> selectPageByExample(VehicleQueueCriteria example);

    int insert(VehicleQueue record);

    int insertSelective(VehicleQueue record);
}