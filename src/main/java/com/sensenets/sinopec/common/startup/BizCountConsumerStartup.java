/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月14日 上午10:51:46
 * @version V1.0
 */
package com.sensenets.sinopec.common.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.sensenets.sinopec.buiness.schedule.VehicleQueue2DbProxy;
import com.sensenets.sinopec.buiness.service.IVehicleQueueService;
import com.sensenets.sinopec.kafka.buffer.vehana.VehicleQueueAnalysisConsumer;
import com.sensenets.sinopec.kafka.buffer.vehana.VehicleQueueAnalysisCountService;

import lombok.extern.slf4j.Slf4j;

/**
  * @ClassName: BizCountConsumerStartup
  * @Description: 业务统计消费启动
  * @author think
  * @date 2018年9月14日 上午10:51:46
  *
  */
@Component
@Slf4j
public class BizCountConsumerStartup implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private VehicleQueueAnalysisCountService countService;
    
    @Autowired
    private IVehicleQueueService  vehicleQueueService;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        VehicleQueueAnalysisConsumer.start(countService);
        log.info("启动车辆排队分析--统计代理--完成");
        
        VehicleQueue2DbProxy.startTask(vehicleQueueService);
        log.info("启动车辆排队--入库代理--完成");
    }

}
