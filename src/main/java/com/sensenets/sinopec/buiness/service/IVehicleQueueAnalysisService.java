package com.sensenets.sinopec.buiness.service;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.condition.VehicleQueueAnalysisCondition;
import com.sensenets.sinopec.buiness.dto.VehicleQueueResultDto;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueAnalysis;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueAnalysisCriteria;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IVehicleQueueAnalysisService {
    int countByExample(VehicleQueueAnalysisCriteria example);

    VehicleQueueAnalysis selectByPrimaryKey(Long id);

    List<VehicleQueueAnalysis> selectByExample(VehicleQueueAnalysisCriteria example);

    PageInfo<VehicleQueueAnalysis> selectPageByExample(VehicleQueueAnalysisCriteria example);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VehicleQueueAnalysis record);

    int updateByPrimaryKey(VehicleQueueAnalysis record);

    int deleteByExample(VehicleQueueAnalysisCriteria example);

    int updateByExampleSelective(VehicleQueueAnalysis record, VehicleQueueAnalysisCriteria example);

    int updateByExample(VehicleQueueAnalysis record, VehicleQueueAnalysisCriteria example);

    int insert(VehicleQueueAnalysis record);

    long insertSelective(VehicleQueueAnalysis record);

    /**
      * @Title: selectAnalysisCount
      * @Description: 查询车辆排队分析结果
      * @param condition  查询条件
      * @return 排队分析结果
      */
    VehicleQueueResultDto selectAnalysisCount(VehicleQueueAnalysisCondition condition);
    

    /**
      * @Title: downloadVehicleQueueAnalysisExcel
      * @Description: 下载车辆排队分析表格
      * @param request
      * @param response
      * @param key
      * @return
      */
    String downloadVehicleQueueAnalysisExcel(HttpServletRequest request,HttpServletResponse response,String key);
    
    /**
      * @Title: getExportResultExcel
      * @Description: 导出excel
      * @param condition 查询条件
      * @return 存放地址
      */
    String getExportResultExcel(VehicleQueueAnalysisCondition condition);
}