package com.sensenets.sinopec.kafka.buffer.vehana;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

import org.springframework.stereotype.Component;

import com.sensenets.sinopec.buiness.model.two.VehicleQueue;
import com.sensenets.sinopec.common.utils.ThreadHelper;
import com.sensenets.sinopec.common.utils.ThreadPoolUtils;

import lombok.extern.slf4j.Slf4j;


/**
  * @ClassName: VehicleQueueAnalysisConsumer
  * @Description: 处理车辆排队分析统计
  * @author think
  * @date 2018年9月14日 上午10:32:18
  *
  */

@Component
@Slf4j
public class VehicleQueueAnalysisConsumer {

    private static Queue<VehicleQueue> vehicleQueue;
    

    private static final Object SYNC_ROOT = new Object();

    private static boolean IS_RUN = false;

    private static VehicleQueueAnalysisCountService countService ;
    
    private static ExecutorService executorService = ThreadPoolUtils.newCachedThreadPool();
    
    public static void start(VehicleQueueAnalysisCountService service) {
        countService = service;
        init();
        executorService.execute(Work);
    }

    private static void init() {
        IS_RUN = true;
        if (null == vehicleQueue) {
            vehicleQueue = new LinkedList<VehicleQueue>();
        }
        log.info("初始化车辆排队分析统计");
        countService.loadPersistenceData();
    }

    public static void add(VehicleQueue queue) {
        synchronized (SYNC_ROOT) {
            vehicleQueue.offer(queue);
        }
    }

    static Runnable Work = new Runnable() {

        @Override
        public void run() {
            while (IS_RUN) {
                try {
                    List<VehicleQueue> infos = new ArrayList<VehicleQueue>();
                    while (IS_RUN) {
                        VehicleQueue info = vehicleQueue.poll();
                        if (null != info) {
                            infos.add(info);
                            continue;
                        }
                        break;
                    }
                    if (!infos.isEmpty()) {
                        executorService.execute(queueHandle(infos));
                    }
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
                ThreadHelper.sleepThread(1000);
            }
        }
    };
    

    static Runnable queueHandle(final List<VehicleQueue> infos) {
        return new Runnable() {
            @Override
            public void run() {
                countService.persitVehicleQueueAnalysis(infos);
            }
        };
    }
    

}
