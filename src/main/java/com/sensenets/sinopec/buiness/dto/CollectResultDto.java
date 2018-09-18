/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月31日 下午6:36:02
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
  * @ClassName: CollectResultDto
  * @Description:采集结果对象返回给页面
  * @author think
  * @date 2018年8月31日 下午6:36:02
  *
  */
@ApiModel(value ="CollectResultDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectResultDto implements Serializable{

    /**
      * @Fields serialVersionUID 
      */
    private static final long serialVersionUID = -7051180714632536771L;
    
  
    @ApiModelProperty(value = "任务id")
    private Long taskId;
    
    @ApiModelProperty(value = "任务类型1.进站统计2.站外统计3.全部")
    private Short  taskType;
    
    @ApiModelProperty(value = "进站车流量分析结果")
    private List<ResultInFlow> inFlows;
    
    @ApiModelProperty(value = "站外车流量分析结果")
    private List<ResultOutFlow> outFlows;
    
    @ApiModelProperty(value = "进站车类型分析结果")
    private List<ResultInVehicleType> inVehicleTypes;
    
    @ApiModelProperty(value = "站外车类型分析结果")
    private List<ResultOutVehicleType> outVehicleTypes;
    
    @Data
    @ApiModel(value ="ResultInFlow")
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResultInFlow implements Comparable<ResultInFlow>{
        
        @ApiModelProperty(value = "采集进站车流量数量")
        private int collectCount = 0 ;
        @ApiModelProperty(value = "油站进站车流量数量")
        private int stationCount = 0 ;
        @ApiModelProperty(value = "时间单位")
        private String dataTime =  "" ; 
        @ApiModelProperty(value = "排序")
        private int index = 0 ;
     
        @Override
        public int compareTo(ResultInFlow o) {
            if(o!=null){
                if(o.getIndex()>this.getIndex()){
                    return -1;
                }else if(o.getIndex()<this.getIndex()){
                    return 1;
                }else{
                    return 0;
                }
            }
            return 0;
        }

        
    
    }
    
    @Data
    @ApiModel(value ="ResultOutFlow")
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResultOutFlow implements Comparable<ResultOutFlow> {
        
        @ApiModelProperty(value = "采集站外车流量数量")
        private int collectCount = 0 ;
        @ApiModelProperty(value = "油站站外车流量数量")
        private int stationCount = 0 ;
        @ApiModelProperty(value = "时间单位")
        private String dataTime =  "" ; 
        @ApiModelProperty(value = "排序")
        private int index = 0 ; 
        
        @Override
        public int compareTo(ResultOutFlow o) {
            if(o!=null){
                if(o.getIndex()>this.getIndex()){
                    return -1;
                }else if(o.getIndex()<this.getIndex()){
                    return 1;
                }else{
                    return 0;
                }
            }
            return 0;
        }
    }
    
    @Data
    @ApiModel(value ="ResultInVehicleType")
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResultInVehicleType implements Comparable<ResultInVehicleType>  {
        @ApiModelProperty(value = "采集进站车类型数量")
        private int collectCount = 0 ;
        @ApiModelProperty(value = "油站进站车类型数量")
        private int stationCount = 0 ;
        @ApiModelProperty(value = "车类型单位")
        private String vehicleType =  "" ; 
        @ApiModelProperty(value = "排序")
        private int index = 0 ; 
        
        @Override
        public int compareTo(ResultInVehicleType o) {
            if(o!=null){
                if(o.getIndex()>this.getIndex()){
                    return -1;
                }else if(o.getIndex()<this.getIndex()){
                    return 1;
                }else{
                    return 0;
                }
            }
            return 0;
        }
    }
    
    @Data
    @ApiModel(value ="ResultOutVehicleType")
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResultOutVehicleType implements Comparable<ResultOutVehicleType> {
        @ApiModelProperty(value = "采集出站车类型数量")
        private int collectCount = 0 ;
        @ApiModelProperty(value = "油站出站车类型数量")
        private int stationCount = 0 ;
        @ApiModelProperty(value = "车类型单位")
        private String vehicleType =  "" ; 
        @ApiModelProperty(value = "排序")
        private int index = 0 ; 
        
        @Override
        public int compareTo(ResultOutVehicleType o) {
            if(o!=null){
                if(o.getIndex()>this.getIndex()){
                    return  -1;
                }else if(o.getIndex()<this.getIndex()){
                    return 1;
                }else{
                    return 0;
                }
            }
            return 0;
        }
        
    }

}
