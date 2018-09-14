/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月14日 下午3:41:22
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.model.two;

import java.io.Serializable;

import lombok.Data;

/**
  * @ClassName: VehicleQueueAnalysisCount
  * @Description: 车辆排队分析统计对象
  * @author think
  * @date 2018年9月14日 下午3:41:22
  *
  */
@Data
public class VehicleQueueAnalysisCount implements Serializable{

    /**
      * @Fields serialVersionUID 
      */
    private static final long serialVersionUID = 5971548627310485359L;

    private  int time5;
    private  int time10;
    private  int time15;
    private  int time20;
    private  int time25;
    
    
}
