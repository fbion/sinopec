package com.sensenets.sinopec.buiness.schedule;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sensenets.sinopec.buiness.dto.CollectTaskDto;
import com.sensenets.sinopec.buiness.model.two.CollectResultFlow;
import com.sensenets.sinopec.buiness.model.two.CollectResultType;
import com.sensenets.sinopec.buiness.model.two.VehiclesCriteria;
import com.sensenets.sinopec.buiness.service.ICollectResultFlowService;
import com.sensenets.sinopec.buiness.service.ICollectResultTypeService;
import com.sensenets.sinopec.buiness.service.IMobileCollectTaskService;
import com.sensenets.sinopec.buiness.service.IVehiclesService;
import com.sensenets.sinopec.common.enums.CollectTaskTypeEnum;
import com.sensenets.sinopec.common.enums.CountStatusEnum;
import com.sensenets.sinopec.common.enums.ResultTypeEnum;
import com.sensenets.sinopec.common.utils.BeanHelper;
import com.sensenets.sinopec.common.utils.DateHelper;

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

    private IMobileCollectTaskService mobileCollectTaskService;
    
    private ICollectResultFlowService collectResultFlowService;
    
    private ICollectResultTypeService collectResultTypeService;
    
    private IVehiclesService vehiclesService;
    
    /**
     * 发送数据线程池
     */
    private ThreadPoolExecutor sendThreadPool;

    public CollectSubTask(CollectTaskDto collectTaskDto) {
        this.collectTaskDto = collectTaskDto;
        this.mobileCollectTaskService = BeanHelper.getBean(IMobileCollectTaskService.class);
        this.collectResultFlowService = BeanHelper.getBean(ICollectResultFlowService.class);
        this.collectResultTypeService = BeanHelper.getBean(ICollectResultTypeService.class);
        this.vehiclesService = BeanHelper.getBean(IVehiclesService.class);
        if (sendThreadPool == null) {
            sendThreadPool = new ThreadPoolExecutor(10, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        }
    }

    @Override
    public CollectTaskDto call() {
        try {
            CollectTaskProxy.putKey(collectTaskDto.getId());
            // 4类数据采集进站流量，进站车型统计，站外流量，站外车型统计
            CountDownLatch countDownLatch = new CountDownLatch(2);
            // 车流量表初始化
            sendThreadPool.execute(countData(1,collectTaskDto,countDownLatch));
            // 车辆类型表初始化
            sendThreadPool.execute(countData(2,collectTaskDto,countDownLatch));
            countDownLatch.await();
            collectTaskDto.setSendOk(true);
            CollectTaskProxy.removeKey(collectTaskDto.getId(), true);
        } catch (Exception e) {
            e.printStackTrace();
            collectTaskDto.setSendOk(false);
            CollectTaskProxy.removeKey(collectTaskDto.getId(), false);
        } finally {
            if (sendThreadPool != null) {
                sendThreadPool.shutdown();
            }
        }
        return collectTaskDto;
    }

    private  Runnable countData(int type , final CollectTaskDto task, CountDownLatch countDownLatch) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                     switch(type){
                     case 1:
                         // 车流量分析
                         List<CollectResultFlow> list = convert2CollectResultFlowList(task);
                         List<CollectResultFlow> afterList = collectResultFlowService.insertBatch(list);
                         for(CollectResultFlow flow :afterList){
                            CollectTaskDto flowTask = new CollectTaskDto();
                            BeanUtils.copyProperties(flowTask, task);
                            flowTask.setResultId(flow.getId());
                            flowTask.setResultType(ResultTypeEnum.VEHICLE_FLOW);
                            flowTask.setCollectResultFlow(flow);
                            ExecuteTaskQueue.add(flowTask);
                         }
                         break;
                     case 2:
                         // 车辆类型分析
                         List<CollectResultType> typelist = convert2CollectResultTypeList(task);
                         List<CollectResultType> afterTypeList = collectResultTypeService.insertBatch(typelist);
                         for(CollectResultType type :afterTypeList){
                             CollectTaskDto typeTask = new CollectTaskDto();
                             BeanUtils.copyProperties(typeTask, task);
                             typeTask.setResultId(type.getId());
                             typeTask.setResultType(ResultTypeEnum.VEHICLE_TYPE);
                             typeTask.setCollectResultType(type);
                             ExecuteTaskQueue.add(typeTask);
                         }
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

    /**
      * @Title: convert2CollectResultFlowList
      * @Description: 转化为采集结果流量记录
      * @param task
      * @return
      */
    private List<CollectResultFlow> convert2CollectResultFlowList(final CollectTaskDto task){
        // 计算时间段，将时间转换成小时数
        long hours = (task.getCollectEndTime().getTime() - task.getCollectStartTime().getTime())/(1000*60*60);
        List<CollectResultFlow> condition = new ArrayList<CollectResultFlow>();
        
        CollectResultFlow record = new CollectResultFlow();
        record.setCollectInCount(0);
        record.setCollectOutCount(0);
        record.setCollectTaskId(task.getId());
        record.setMobRepId(task.getCollectId());
        record.setStationInCount(0);
        record.setStationOutCount(0);
        record.setStationRepId(task.getOilStationId());
        record.setUts(new Date());
        record.setCountStatus(CountStatusEnum.UNFINISH.getCode());
        for(int i = 0;i<hours;i++){
            CollectResultFlow flow = new CollectResultFlow();
            try {
                BeanUtils.copyProperties(flow, record);
                String start = DateHelper.dateAddHour(task.getCollectStartTime(), DateHelper.FORMAT_0, i);
                int dataHour = NumberUtils.toInt(DateHelper.convertDateStrToOtherFormat(start, 
                        DateHelper.FORMAT_0, DateHelper.FORMAT_5));
                int dataDay = NumberUtils.toInt(DateHelper.convertDateStrToOtherFormat(start, 
                        DateHelper.FORMAT_0, DateHelper.FORMAT_6));
                flow.setDataHour(dataHour);
                flow.setDataDay(dataDay);
                condition.add(flow);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return condition;
        
    }
    
    /**
      * @Title: convert2CollectResultTypeList
      * @Description: 转化为车辆类型统计列表
      * @param task
      * @return
      */
    private List<CollectResultType> convert2CollectResultTypeList(final CollectTaskDto task){
        // 计算时间段，将时间转换成小时数
        List<CollectResultType> condition = new ArrayList<CollectResultType>();
        VehiclesCriteria example = new VehiclesCriteria();
        example.setDistinct(true);
        VehiclesCriteria.Criteria cri = example.createCriteria();
        cri.andUtsGreaterThanOrEqualTo(task.getCollectStartTime());
        cri.andUtsLessThan(task.getCollectEndTime());
        // 关联油站设备id
        List<String> sensorIds = getVehicleSensorIds(task);
        cri.andSensorIdIn(sensorIds);
        // 关联油站组织id
        List<String> repoIds = new ArrayList<String>();
        repoIds.add(String.valueOf(task.getCollectId()));
        repoIds.add(String.valueOf(task.getOilStationId()));
        cri.andRepoIdIn(repoIds);
        // 关联的车型id
        List<Short> vehicleTypeList = vehiclesService.selectVehiclesType(example);
        CollectResultType record = new CollectResultType();
        record.setCollectInCount(0);
        record.setCollectOutCount(0);
        record.setCollectTaskId(task.getId());
        record.setMobRepId(task.getCollectId());
        record.setStationInCount(0);
        record.setStationOutCount(0);
        record.setStationRepId(task.getOilStationId());
        record.setUts(new Date());
        record.setCountStatus(CountStatusEnum.UNFINISH.getCode());
        // 不为空则进行插入统计任务
        if(CollectionUtils.isNotEmpty(vehicleTypeList)){
            for(Short vehicleType:vehicleTypeList){
                CollectResultType flow = new CollectResultType();
                try {
                    BeanUtils.copyProperties(flow, record);
                    flow.setVerhicleType(String.valueOf(vehicleType));
                    condition.add(flow);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return condition;
        
    }
    
    /**
      * @Title: getVehicleSensorIds
      * @Description: 获取油站采集时间段关联的设备
      * @param task
      * @return
      */
    private List<String> getVehicleSensorIds(final CollectTaskDto task){
        List<Long> sensorIds = new ArrayList<>();
        if(task.getType()==CollectTaskTypeEnum.InStation.getCode()){
            if(CollectionUtils.isNotEmpty(task.getSensorInIds())){
                sensorIds.addAll(task.getSensorInIds());
            }
            if(CollectionUtils.isNotEmpty(task.getSensorCollectInIds())){
                sensorIds.addAll(task.getSensorCollectInIds());
            }
        }
        if(task.getType()==CollectTaskTypeEnum.OutStation.getCode()){
            if(CollectionUtils.isNotEmpty(task.getSensorOutIds())){
                sensorIds.addAll(task.getSensorInIds());
            }
            if(CollectionUtils.isNotEmpty(task.getSensorCollectOutIds())){
                sensorIds.addAll(task.getSensorCollectOutIds());
            }
        }
        if(task.getType()==CollectTaskTypeEnum.ALL.getCode()){
            if(CollectionUtils.isNotEmpty(task.getSensorCollectInIds())){
                sensorIds.addAll(task.getSensorCollectInIds());
            }
            if(CollectionUtils.isNotEmpty(task.getSensorCollectOutIds())){
                sensorIds.addAll(task.getSensorCollectOutIds());
            }
            if(CollectionUtils.isNotEmpty(task.getSensorOutIds())){
                sensorIds.addAll(task.getSensorInIds());
            }
            if(CollectionUtils.isNotEmpty(task.getSensorOutIds())){
                sensorIds.addAll(task.getSensorInIds());
            }
        }
        List<String> ids = new ArrayList<String>();
        for(Long sensor:sensorIds){
            ids.add(String.valueOf(sensor));
        }
        return ids;
    }
    
   

}