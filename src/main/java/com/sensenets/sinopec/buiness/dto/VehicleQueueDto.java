package com.sensenets.sinopec.buiness.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title public.vehicle_queue表实体类
 * @Description
 * @Version 1.0
 * @Author kelly
 * @Date 2018-08-28 12:24:39
 */

@ApiModel(value = "VehicleQueueDto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleQueueDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;
   
    @ApiModelProperty(value = "进站设备名称")
    private String inSensorName;
    
    @ApiModelProperty(value = "出站设备名称")
    private String outSensorName;

    @ApiModelProperty(value = "油站id")
    private String oilStationRepoId;

    @ApiModelProperty(value = "油站名称")
    private String oilStationRepoName;

    @ApiModelProperty(value = "进站时间")
    private String inTime;
    
    @ApiModelProperty(value = "出站时间")
    private String outTime;
    
    @ApiModelProperty(value = "车牌号")
    private String plateNumber;
    
    @ApiModelProperty(value = "排队时间")
    private Long queueTime;
    
    @ApiModelProperty(value = "进站高清原图")
    private String inSourceImage;
    
    @ApiModelProperty(value = "进站特征图")
    private String inFeatureImage;
    
    @ApiModelProperty(value = "出站高清原图")
    private String outSourceImage;
    
    @ApiModelProperty(value = "出站特征图")
    private String outFeatureImage;
    
    @ApiModelProperty(value = "燃油类型")
    private String oilType;
    
    @ApiModelProperty(value = "进出站记录")
    private List<VehicleRecord> records;
    
   
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VehicleRecord{
       
        @ApiModelProperty(value = "业务类型（1.进站2.出站）")
        private Short type;
        
        @ApiModelProperty(value = "品牌型号")
        private String brandName;
        
        @ApiModelProperty(value = "车辆角度")
        private String vehicleAngleName;
        
        @ApiModelProperty(value = "车辆类型")
        private String vehicleTypeName;
        
        @ApiModelProperty(value = "车辆颜色")
        private String vehicleColorName;
        
        @ApiModelProperty(value = "车牌号码")
        private String plateNumber;
        
        @ApiModelProperty(value = "车牌类型")
        private String plateType;
        
        @ApiModelProperty(value = "车牌颜色")
        private String plateColor;
        
    }



}