package com.sensenets.sinopec.buiness.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sensenets.sinopec.buiness.service.IMobileCollectTaskService;
import com.sensenets.sinopec.buiness.service.IVehicleQueueAnalysisService;
import com.sensenets.sinopec.buiness.service.IVehicleQueueService;
import com.sensenets.sinopec.common.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
  * @ClassName: IgnoreUrlController
  * @Description: 忽略令牌校验控制层
  * @author think
  * @date 2018年08月24日 17:56:41
  */
  
@RestController
@Api(value="IgnoreUrlController", tags = "忽略令牌校验接口", description="IgnoreUrlController")
@RequestMapping(value = "/service/ignore",produces = {APPLICATION_JSON_UTF8_VALUE})
public class IgnoreUrlController extends BaseController {

    @Autowired
    IMobileCollectTaskService mobileCollectTaskService;
    
    @Autowired
    IVehicleQueueService vehicleQueueService;
    
    @Autowired
    IVehicleQueueAnalysisService vehicleQueueAnalysisService;
    
    @ApiOperation(value = "获取移动采集分析导出结果")
    @RequestMapping(value="/getExportResult/{key}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public void getExportResult(@PathVariable String key,HttpServletRequest request,HttpServletResponse response){
        mobileCollectTaskService.downloadCollectResultExcel(request,response,key);
    }
    
    
    @ApiOperation(value = "获取车辆排队导出结果")
    @RequestMapping(value="/getVehicleQueueResult/{key}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public void getVehcileQueueExportResult(@PathVariable String key,HttpServletRequest request,HttpServletResponse response){
        vehicleQueueService.downloadVehicleQueueResultExcel(request,response,key);
    }
    
    @ApiOperation(value = "获取车辆排队分析导出结果")
    @RequestMapping(value="/getVehicleQueueAnalysisResult/{key}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public void getVehicleQueueAnalysisResult(@PathVariable String key,HttpServletRequest request,HttpServletResponse response){
        vehicleQueueAnalysisService.downloadVehicleQueueAnalysisExcel(request,response, key);
    }
    
}




