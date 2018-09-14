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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
  * @ClassName: VehicleQueueResultDto
  * @Description:车辆排队分析对象返回给页面
  * @author think
  * @date 2018年8月31日 下午6:36:02
  *
  */
@ApiModel(value ="VehicleQueueResultDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleQueueResultDto implements Serializable{

    /**
      * @Fields serialVersionUID 
      */
    private static final long serialVersionUID = 2142440256953550837L;

    @ApiModelProperty(value = "汽油车排队分析结果")
    private VehicleGasOil gasOilResult;
    
    @ApiModelProperty(value = "柴油车分析结果")
    private VehicleDieselOil dieselOilResult;
   
    @Data
    @ApiModel(value ="VehicleGasOil")
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VehicleGasOil{
        @ApiModelProperty(value = "0-5分钟数量")
        private int time5 =  0 ;
        @ApiModelProperty(value = "5-10分钟数量")
        private int time10 = 0 ;
        @ApiModelProperty(value = "10-15分钟数量")
        private int time15 = 0 ;
        @ApiModelProperty(value = "15-20分钟数量")
        private int time20 = 0 ;
        @ApiModelProperty(value = "25分钟数量")
        private int time25 = 0 ;
    }
    
    @Data
    @ApiModel(value ="VehicleDieselOil")
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VehicleDieselOil{
        @ApiModelProperty(value = "0-5分钟数量")
        private int time5 =  0 ;
        @ApiModelProperty(value = "5-10分钟数量")
        private int time10 = 0 ;
        @ApiModelProperty(value = "10-15分钟数量")
        private int time15 = 0 ;
        @ApiModelProperty(value = "15-20分钟数量")
        private int time20 = 0 ;
        @ApiModelProperty(value = "25分钟数量")
        private int time25 = 0 ;
    }
    
   
}
