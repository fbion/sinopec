package com.sensenets.sinopec.buiness.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sensenets.sinopec.buiness.condition.VehicleQueueAnalysisCondition;
import com.sensenets.sinopec.buiness.condition.VehicleQueueExportCondition;
import com.sensenets.sinopec.buiness.dto.VehicleQueueResultDto;
import com.sensenets.sinopec.buiness.service.IVehicleQueueAnalysisService;
import com.sensenets.sinopec.common.controller.BaseController;
import com.sensenets.sinopec.common.domain.ResponseInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
  * @ClassName: VehicleQueueAnalysisController
  * @Description: 车辆排队分析控制层
  * @author think
  * @date 2018年08月24日 17:56:41
  */
  
@RestController
@Api(value="VehicleQueueAnalysisController", tags = "车辆排队分析接口", description="VehicleQueueAnalysisController")
@RequestMapping(value = "/service/vehicleQueueAnalysis",produces = {APPLICATION_JSON_UTF8_VALUE})
public class VehicleQueueAnalysisController extends BaseController {

    @Autowired
    IVehicleQueueAnalysisService vehicleQueueAnalysisService;
    
     @ApiOperation(value = "分页列表")
     @RequestMapping(value = "/analysisCount", method= RequestMethod.POST, produces = "application/json")
     public ResponseInfo analysisCount(@RequestBody VehicleQueueAnalysisCondition condition){
         VehicleQueueResultDto dto = vehicleQueueAnalysisService.selectAnalysisCount(condition);
         return this.warpObject(dto);
     }
     
     
     @ApiOperation(value = "导出排队数据")
     @RequestMapping(value="/exportData", method = RequestMethod.POST, produces = "application/json")
     @ResponseBody
     public ResponseInfo exportData(@RequestBody VehicleQueueAnalysisCondition condition,HttpServletRequest request,HttpServletResponse response){
         return this.warpObject(vehicleQueueAnalysisService.getExportResultExcel(condition));
     }
    
}




