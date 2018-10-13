/**
 * Copyright: Copyright (c) 2017 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author xzc
 * @date 2017年8月7日 上午10:49:33
 * @version V1.0
 */
package com.sensenets.sinopec.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


/**
  * @ClassName: AppConfig
  * @Description: 应用基本配置
  * @author think
  * @date 2018年8月8日 下午1:26:14
  *
  */
@Configuration
@ConfigurationProperties(prefix = "app.info")
@Data
public class AppConfig {

   private String exportDir;
   
   private int receiveGasStationThreadMinNum;
   
   private int receiveGasStationThreadMaxNum;
   
   private int matchVehicleQueue;
   
   private int vehicleQueueExportNum;
   
   private int vehicleQueueExportTotalNum;
   
   private boolean vehicleScheduleEnabled;

}
