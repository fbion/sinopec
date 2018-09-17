package com.sensenets.sinopec.buiness.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.condition.VehicleQueueCondition;
import com.sensenets.sinopec.buiness.condition.VehicleQueueExportCondition;
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

    /**
      * @Title: getExportResultExcel
      * @Description: 导出到服务器
      * @param condition
      * @return
      */
    String getExportResultExcel(VehicleQueueExportCondition condition);
   
   /**
    * @Title: downloadVehicleQueueResultExcel
    * @Description: 下载到客户端
    * @param response
    * @param key
    * @return
    */
   String downloadVehicleQueueResultExcel(HttpServletRequest request,HttpServletResponse response,String key);
}