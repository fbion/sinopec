package com.sensenets.sinopec.buiness.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensenets.sinopec.buiness.service.IIndexCountService;
import com.sensenets.sinopec.common.controller.BaseController;
import com.sensenets.sinopec.common.domain.ResponseInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
  * @ClassName: IndexCountController
  * @Description: 首页统计控制层
  * @author think
  * @date 2018年08月24日 17:56:41
  */
  
@RestController
@Api(value="IndexCountController", tags = "首页统计接口", description="IndexCountController")
@RequestMapping(value = "/service/indexCount",produces = {APPLICATION_JSON_UTF8_VALUE})
public class IndexCountController extends BaseController {

    @Autowired
    IIndexCountService indexCountService;
    
    
    @ApiOperation(value = "首页汇总统计")
    @RequestMapping(value="/summaryCount", method = RequestMethod.GET, produces = "application/json")
    public ResponseInfo summaryCount(){
        return null;
    }
    
    
    @ApiOperation(value = "进站车辆统计")
    @RequestMapping(value="/inVehicleCount", method = RequestMethod.GET, produces = "application/json")
    public ResponseInfo inVehicleCount(){
        return null;
    }
    
    @ApiOperation(value = "进站车辆车型统计")
    @RequestMapping(value="/inVehicleTypeCount", method = RequestMethod.GET, produces = "application/json")
    public ResponseInfo inVehicleTypeCount(){
        return null;
    }
    
    @ApiOperation(value = "进站车辆品牌统计")
    @RequestMapping(value="/inVehicleBrandCount", method = RequestMethod.GET, produces = "application/json")
    public ResponseInfo inVehicleBrandCount(){
        return null;
    }
    
    @ApiOperation(value = "进站车辆燃油类型统计")
    @RequestMapping(value="/inVehicleFuelTypeCount", method = RequestMethod.GET, produces = "application/json")
    public ResponseInfo inVehicleFuelTypeCount(){
        return null;
    }
    
    @ApiOperation(value = "进店消费统计")
    @RequestMapping(value="/inStoreConsumeCount", method = RequestMethod.GET, produces = "application/json")
    public ResponseInfo inStoreConsumeCount(){
        return null;
    }
    
}




