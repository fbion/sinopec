/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月29日 下午5:00:44
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.schedule;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.sensenets.sinopec.buiness.model.two.VehicleQueue;
import com.sensenets.sinopec.buiness.service.IVehicleQueueService;
import com.sensenets.sinopec.common.utils.ThreadHelper;
import com.sensenets.sinopec.kafka.buffer.vehana.VehicleQueueAnalysisConsumer;

import lombok.extern.slf4j.Slf4j;


/**
  * @ClassName: VehicleQueue2DbProxy
  * @Description: 车辆排队入库代理
  * @author think
  * @date 2018年9月23日 下午3:33:37
  *
  */
@Slf4j
public class VehicleQueue2DbProxy extends Thread {
    
    /**
     * @Fields TASKEXECUTOR : 线程池
     */
    private static ThreadPoolTaskExecutor TASKEXECUTOR;

    private static boolean running = false;
 
    /**
     * @Fields INSTANCE
     */
    private static volatile VehicleQueue2DbProxy INSTANCE;
    
    private  IVehicleQueueService  vehicleQueueService ;

    /**
     * @Title: getInstance
     * @Description: 获取实例
     * @return ExportImgHelper
     */
    public static VehicleQueue2DbProxy init(IVehicleQueueService  vehicleQueueService) {
        if (INSTANCE == null) {
            synchronized (VehicleQueue2DbProxy.class) {
                if (INSTANCE == null) {
                    TASKEXECUTOR = new ThreadPoolTaskExecutor();
                    TASKEXECUTOR.setCorePoolSize(0);
                    TASKEXECUTOR.setMaxPoolSize(2);
                    TASKEXECUTOR.setKeepAliveSeconds(20);
                    TASKEXECUTOR.setQueueCapacity(5);
                    TASKEXECUTOR.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
                    TASKEXECUTOR.initialize();
                    INSTANCE = new VehicleQueue2DbProxy(vehicleQueueService);
                    log.info("------VehicleQueue2DbProxy init ------");
                }
            }
        }
        return INSTANCE;
    }

    private VehicleQueue2DbProxy(IVehicleQueueService  vehicleQueueService) {
        this.vehicleQueueService = vehicleQueueService;
    }

    @Override
    public void run() {
        while (true) {
            if (checkRunning()) {
                try {
                    List<VehicleQueue> taskList = VehiclesQueue.takeList();
                    log.debug(String.format("***************正在进行车辆排队数据入库*********"));
                    executeCollect(taskList);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
            ThreadHelper.sleepThread(3000);
        }
    }

    private void executeCollect(List<VehicleQueue> tasks) {
        TASKEXECUTOR.submit(insertData(tasks));
    }
    
    private  Runnable insertData( final List<VehicleQueue> tasks) {
        return new Runnable() {
            @Override
            public void run() {
                for(VehicleQueue queue:tasks){
                    vehicleQueueService.insert(queue);
                }
                log.debug("新增排队数据成功");
                // 新增排队数据成功后，将记录id返回进行排队统计分析
                VehicleQueueAnalysisConsumer.add(tasks);
            }
        };
    }

    private boolean checkRunning() {
        if (running) {
            log.debug("车辆排队入库线程正在运行");
        } else {
            log.debug("车辆排队入库线程已停止运行");
        }
        return running;
    }

    /**
     * @Title: stopTask
     * @Description:停止采集
     */
    public static void stopTask() {
        running = false;
    }

    /**
     * @Title: startTask
     * @Description: 开启入库
     */
    public static void startTask(IVehicleQueueService  vehicleQueueService) {
        init(vehicleQueueService);
        INSTANCE.start();
        running = true;
    }

    
}
