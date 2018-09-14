/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月27日 上午10:29:21
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
  * @ClassName: VehicleQueueAnalysisCondition
  * @Description: 车辆排队分析查询条件
  * @author think
  * @date 2018年8月27日 上午10:29:21
  *
  */
@Data
@ApiModel(description="车辆排队分析查询条件",value ="VehicleQueueAnalysisCondition")
public class VehicleQueueAnalysisCondition extends CommonCondition{
    
    @ApiModelProperty(value = "开始时间")
    private String inStartTime;

    @ApiModelProperty(value = "结束时间")
    private String inEndTime;
    
    @ApiModelProperty(value = "油站id")
    private String repoId;
  
    @ApiModelProperty(value = "车辆类型")
    private Short vehicleType;
    
}
