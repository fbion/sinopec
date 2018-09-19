/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月18日 下午4:26:15
 * @version V1.0
 */
package com.sensenets.sinopec.kafka.buffer.gas;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
  * @ClassName: VehicleQueueTimeDto
  * @Description: 车辆排队开始时间和结束时间
  * @author think
  * @date 2018年9月18日 下午4:26:15
  *
  */
@Data
@AllArgsConstructor
public class VehicleQueueTimeDto {
    
    /**
      * @Fields startTime : 匹配开始时间
      */
    private Long startTime;
    
    /**
      * @Fields endTime : 匹配结束时间
      */
    private Long endTime;
    
    /**
      * @Fields matchTime : 匹配时间点
      */
    private long matchTime;
    
}
