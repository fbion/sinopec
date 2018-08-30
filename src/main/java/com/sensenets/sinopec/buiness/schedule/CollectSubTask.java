package com.sensenets.sinopec.buiness.schedule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sensenets.sinopec.buiness.service.IMobileCollectTaskService;
import com.sensenets.sinopec.common.utils.BeanHelper;
import com.sensenets.sinopec.common.utils.ThreadHelper;

/**
 * @ClassName: CollectSubTask
 * @Description:采集具体业务处理线程
 * @author xzc
 * @date 2018年4月12日 下午2:13:27
 *
 */
public class CollectSubTask implements Callable<CollectTaskDto>, Serializable {

    private static final long serialVersionUID = 7402497864829689350L;

    private static final Logger LOGGER = LoggerFactory.getLogger(CollectSubTask.class);

    private CollectTaskDto collectTaskDto;

    private boolean monitorFlag = true;
    
    private IMobileCollectTaskService mobileCollectTaskService;
    
    /**
     * 发送数据线程池
     */
    private ThreadPoolExecutor sendThreadPool;

    public CollectSubTask(CollectTaskDto collectTaskDto) {
        this.collectTaskDto = collectTaskDto;
        this.mobileCollectTaskService = BeanHelper.getBean(IMobileCollectTaskService.class);
        if (sendThreadPool == null) {
            sendThreadPool = new ThreadPoolExecutor(10, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        }
    }

    @Override
    public CollectTaskDto call() {
        try {
            MobCollectTaskProxy.putKey(collectTaskDto.getId());
            // 计算总线程数4类数据采集进出站流量，采集进出站车型统计，站外进出站流量，站外车型统计
            CountDownLatch countDownLatch = new CountDownLatch(4);
            for(int i = 1;i<=4;i++){
                sendThreadPool.execute(countData(i,collectTaskDto,countDownLatch));
            }
            countDownLatch.await();
            collectTaskDto.setSendOk(true);
            MobCollectTaskProxy.removeKey(collectTaskDto.getId(), true);
        } catch (Exception e) {
            e.printStackTrace();
            collectTaskDto.setSendOk(false);
            MobCollectTaskProxy.removeKey(collectTaskDto.getId(), false);
        } finally {
            if (sendThreadPool != null) {
                sendThreadPool.shutdown();
            }
        }
        return collectTaskDto;
    }

    private  Runnable countData(int type,final CollectTaskDto task, CountDownLatch countDownLatch) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                     switch(type){
                     case 1:
                         // 进出站车流量分析
                         
                         break;
                     case 2:
                         // 进出站车辆类型分析
                         break;
                     case 3:
                         // 站外车流量分析
                         break;
                     case 4:
                         // 站外车辆类型分析
                         break;
                     default :
                         break;
                    }
                } catch (Exception e) {
                    LOGGER.error(String.format("******采集任务ID[%d]失败*****", task.getId()));
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        };
    }

   
    private void inAndOutFlowCount(final CollectTaskDto task){
        // 查找某时间段 
    }
    
    private void inAndOutVehicleTypeCount(final CollectTaskDto task){
        // 查找某时间段 车型统计
    }
    
//    /**
//      * @ClassName: MonitorTaskStatus
//      * @Description: 监控聚类任务状态
//      * @author xzc
//      * @date 2018年5月22日 下午7:26:32
//      *
//      */
//    class MonitorTaskStatusThread extends Thread{
//        
//        @Override
//        public void run() {
//            while (monitorFlag) {
//                try {
//                    ClusterTask task = clusterTaskService.get(clusterDataDto.getTaskId());
//                    if(task==null||task.getStatus()==ClusterTaskStatus.FAILED||task.getStatus()==ClusterTaskStatus.CANCELED){
//                        dataSendFlag = false;
//                        monitorFlag = false;
//                    }
//                } catch (Exception e) {
//                    LOGGER.error(e.getMessage(), e);
//                }
//                ThreadHelper.sleepThread(3000);
//            }
//            
//        }
//    }

}