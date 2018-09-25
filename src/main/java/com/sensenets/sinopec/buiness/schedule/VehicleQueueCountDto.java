/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月23日 下午2:05:03
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.schedule;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Data;


/**
  * @ClassName: VehicleQueueCountDto
  * @Description: 车辆排队统计对象
  * @author think
  * @date 2018年9月23日 下午2:05:03
  *
  */
@Data
public class VehicleQueueCountDto {
    
    private String repoId;
    
    
    private List<VehicleSortDto> inList  = Lists.newArrayList() ;
    
    private List<VehicleSortDto> outList = Lists.newArrayList() ;
    
    private List<VehicleSortDto> oilList = Lists.newArrayList() ;
    
    

}
