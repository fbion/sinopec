/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月30日 下午4:09:18
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
  * @ClassName: CollectVehicleDto
  * @Description: 采集车辆信息对象
  * @author think
  * @date 2018年8月30日 下午4:09:18
  *
  */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectVehicleDto {

    private Long collectId;
    
    private Long oilStationId;
    
    private Date collectStartTime;
    
    private Date collectEndTime;
    
    private List<String> sensorIds;
    
    private int dataHour;
    
    private int dataDay;
    
    /**
     * @Fields sensorInIds : 关联的采集设备
     */
    private List<Long> sensorCollectIds;
   
   /**
    * @Fields sensorInIds : 关联的进站摄像机
    */
    private List<Long> sensorInIds;
   
   /**
    * @Fields sensorOutIds : 关联的出站摄像机
    */
    private List<Long> sensorOutIds;
}
