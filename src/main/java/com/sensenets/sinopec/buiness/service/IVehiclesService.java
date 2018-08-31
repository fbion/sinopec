package com.sensenets.sinopec.buiness.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.model.two.Vehicles;
import com.sensenets.sinopec.buiness.model.two.VehiclesCriteria;

public interface IVehiclesService {
    
    int countByExample(VehiclesCriteria example);

    List<Short> selectVehiclesType(VehiclesCriteria example);
    
    List<Vehicles> selectByExample(VehiclesCriteria example);

    PageInfo<Vehicles> selectPageByExample(VehiclesCriteria example);
    
}