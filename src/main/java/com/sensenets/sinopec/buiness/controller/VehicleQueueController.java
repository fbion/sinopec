package com.sensenets.sinopec.buiness.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.condition.VehicleQueueCondition;
import com.sensenets.sinopec.buiness.dto.VehicleQueueDto;
import com.sensenets.sinopec.buiness.service.IVehicleQueueService;
import com.sensenets.sinopec.common.controller.BaseController;
import com.sensenets.sinopec.common.domain.ResponseInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

 /**
  * @ClassName: MobileCollectTaskController
  * @Description: 移动数据采集控制层
  * @author think
  * @date 2018年08月24日 17:56:41
  */
  
@RestController
@Api(value="VehicleQueueController", tags = "车辆排队接口", description="VehicleQueueController")
@RequestMapping(value = "/service/vehicleQueue",produces = {APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class VehicleQueueController extends BaseController {

    @Autowired
    IVehicleQueueService vehicleQueueService;
    
     @ApiOperation(value = "分页列表")
     @RequestMapping(value = "/listPage", method= RequestMethod.POST, produces = "application/json")
     public ResponseInfo listPage(@RequestBody VehicleQueueCondition condition){
         PageInfo<VehicleQueueDto> page = vehicleQueueService.selectPageByExample(condition);
         return this.warpPageObject(page);
     }
    
}




