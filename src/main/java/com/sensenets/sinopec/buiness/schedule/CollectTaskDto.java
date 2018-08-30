/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月29日 下午5:45:01
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.schedule;

import com.sensenets.sinopec.buiness.model.one.MobileCollectTask;

import lombok.Data;

/**
  * @ClassName: CollectTaskDto
  * @Description: 采集任务对象
  * @author think
  * @date 2018年8月29日 下午5:45:01
  *
  */
@Data
public class CollectTaskDto extends MobileCollectTask{

    /**
      * @Fields serialVersionUID 
      */
    private static final long serialVersionUID = -9003825328183024867L;

    private boolean sendOk;
}
