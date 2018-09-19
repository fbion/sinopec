package com.sensenets.sinopec.buiness.schedule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sensenets.sinopec.buiness.dto.CollectTaskDto;
import com.sensenets.sinopec.buiness.model.one.MobileCollectTask;
import com.sensenets.sinopec.buiness.model.two.CollectResultFlow;
import com.sensenets.sinopec.buiness.model.two.CollectResultFlowCriteria;
import com.sensenets.sinopec.buiness.model.two.CollectResultType;
import com.sensenets.sinopec.buiness.model.two.CollectResultTypeCriteria;
import com.sensenets.sinopec.buiness.model.two.VehiclesCriteria;
import com.sensenets.sinopec.buiness.service.ICollectResultFlowService;
import com.sensenets.sinopec.buiness.service.ICollectResultTypeService;
import com.sensenets.sinopec.buiness.service.IMobileCollectTaskService;
import com.sensenets.sinopec.buiness.service.IVehiclesService;
import com.sensenets.sinopec.common.enums.CollectTaskStatusEnum;
import com.sensenets.sinopec.common.enums.CollectTaskTypeEnum;
import com.sensenets.sinopec.common.enums.CountStatusEnum;
import com.sensenets.sinopec.common.enums.CountTaskTypeEnum;
import com.sensenets.sinopec.common.enums.ResultTypeEnum;
import com.sensenets.sinopec.common.utils.BeanHelper;
import com.sensenets.sinopec.common.utils.DateHelper;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: ExecuteSubTask
 * @Description:采集具体业务处理线程
 * @author xzc
 * @date 2018年4月12日 下午2:13:27
 *
 */
@Slf4j
public class ExecuteSubTask implements Callable<CollectTaskDto>, Serializable {

    private static final long serialVersionUID = 7402497864829689350L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecuteSubTask.class);

    private CollectTaskDto collectTaskDto;

    private IMobileCollectTaskService mobileCollectTaskService;
    
    private ICollectResultFlowService collectResultFlowService;
    
    private ICollectResultTypeService collectResultTypeService;
    
    private IVehiclesService vehiclesService;
    
    /**
     * 发送数据线程池
     */
    private ThreadPoolExecutor sendThreadPool;

    public ExecuteSubTask(CollectTaskDto collectTaskDto) {
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
            ExecuteTaskProxy.putKey(collectTaskDto.getResultId());
            // 4类数据采集进站流量，进站车型统计，站外流量，站外车型统计
            if(collectTaskDto.getType()==CollectTaskTypeEnum.InStation.getCode()){
                if(collectTaskDto.getResultType() == ResultTypeEnum.VEHICLE_FLOW){
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    // 进站流量(采集进站 设备，油站进站摄像机) 
                    sendThreadPool.execute(countData(CountTaskTypeEnum.InStation,collectTaskDto,countDownLatch));
                    countDownLatch.await();
                    finishCount(collectTaskDto);
                }else if(collectTaskDto.getResultType() == ResultTypeEnum.VEHICLE_TYPE){
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    // 进站车型(采集进站设备，油站进站摄像机) 
                    sendThreadPool.execute(countData(CountTaskTypeEnum.InVehicleType,collectTaskDto,countDownLatch));
                    countDownLatch.await();
                    finishCount(collectTaskDto);
                }
            }
            if(collectTaskDto.getType()==CollectTaskTypeEnum.OutStation.getCode()){
                if(collectTaskDto.getResultType() == ResultTypeEnum.VEHICLE_FLOW){
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    // 站外流量(采集站外 设备，油站站外摄像机) 
                    sendThreadPool.execute(countData(CountTaskTypeEnum.OutStation,collectTaskDto,countDownLatch));
                    countDownLatch.await();
                    finishCount(collectTaskDto);
                }else if(collectTaskDto.getResultType() == ResultTypeEnum.VEHICLE_TYPE){
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    // 站外车型(采集站外设备，油站站外摄像机) 
                    sendThreadPool.execute(countData(CountTaskTypeEnum.OutVehicleType,collectTaskDto,countDownLatch));
                    countDownLatch.await();
                    finishCount(collectTaskDto);
                }
            }
            if(collectTaskDto.getType()==CollectTaskTypeEnum.ALL.getCode()){
                if(collectTaskDto.getResultType() == ResultTypeEnum.VEHICLE_FLOW){
                    CountDownLatch countDownLatch = new CountDownLatch(2);
                    // 进站流量(采集进站 设备，油站进站摄像机) 
                    sendThreadPool.execute(countData(CountTaskTypeEnum.InStation,collectTaskDto,countDownLatch));
                    // 站外流量(采集站外 设备，油站站外摄像机) 
                    sendThreadPool.execute(countData(CountTaskTypeEnum.OutStation,collectTaskDto,countDownLatch));
                    countDownLatch.await();
                    finishCount(collectTaskDto);
                }else if(collectTaskDto.getResultType() == ResultTypeEnum.VEHICLE_TYPE){
                    CountDownLatch countDownLatch = new CountDownLatch(2);
                    // 进站车型(采集进站设备，油站进站摄像机) 
                    sendThreadPool.execute(countData(CountTaskTypeEnum.InVehicleType,collectTaskDto,countDownLatch));
                    // 站外车型(采集站外设备，油站站外摄像机) 
                    sendThreadPool.execute(countData(CountTaskTypeEnum.OutVehicleType,collectTaskDto,countDownLatch));
                    countDownLatch.await();
                    finishCount(collectTaskDto);
                }
            }
            collectTaskDto.setSendOk(true);
            updateCollectTaskStatus(collectTaskDto);
            ExecuteTaskProxy.removeKey(collectTaskDto.getResultId(), true);
        } catch (Exception e) {
            e.printStackTrace();
            collectTaskDto.setSendOk(false);
            ExecuteTaskProxy.removeKey(collectTaskDto.getResultId(), false);
        } finally {
            if (sendThreadPool != null) {
                sendThreadPool.shutdown();
            }
        }
        return collectTaskDto;
    }
    
    private void finishCount(final CollectTaskDto task){
        if(task.getResultType()==ResultTypeEnum.VEHICLE_FLOW){
            CollectResultFlow flowRecord = new CollectResultFlow();
            flowRecord.setId(task.getResultId());
            flowRecord.setCountStatus(CountStatusEnum.FINISH.getCode());
            collectResultFlowService.updateByPrimaryKeySelective(flowRecord);
        }else if(task.getResultType()==ResultTypeEnum.VEHICLE_TYPE){
            CollectResultType typeRecord = new CollectResultType();
            typeRecord.setId(task.getResultId());
            typeRecord.setCountStatus(CountStatusEnum.FINISH.getCode());
            collectResultTypeService.updateByPrimaryKeySelective(typeRecord);
        }
    }
    
    /**
      * @Title: updateCollectTaskStatus
      * @Description: 修改采集任务状态
      * @param task
      */
    private void updateCollectTaskStatus(final CollectTaskDto  task){
        // 查询当前任务的 车流量统计表状态
        CollectResultFlowCriteria flowExample = new CollectResultFlowCriteria();
        CollectResultFlowCriteria.Criteria flowCri = flowExample.createCriteria();
        flowCri.andCountStatusEqualTo(CountStatusEnum.UNFINISH.getCode());
        flowCri.andCollectTaskIdEqualTo(task.getId());
        int flowUnCount = collectResultFlowService.countByExample(flowExample);
        // 查询当前任务的 车类型统计表状态
        CollectResultTypeCriteria typeExample = new CollectResultTypeCriteria();
        CollectResultTypeCriteria.Criteria typeCri = typeExample.createCriteria();
        typeCri.andCountStatusEqualTo(CountStatusEnum.UNFINISH.getCode());
        typeCri.andCollectTaskIdEqualTo(task.getId());
        int typeUnCount = collectResultTypeService.countByExample(typeExample);
        
        if(flowUnCount==0&&typeUnCount==0){
            // 统计完成修改任务状态为已完成
            MobileCollectTask record = new MobileCollectTask();
            record.setId(collectTaskDto.getId());
            record.setTaskStatus(CollectTaskStatusEnum.FINISH.getCode());
            mobileCollectTaskService.updateByPrimaryKeySelective(record);
            log.info("移动数据采集任务处理完成");
        }
    }

    private  Runnable countData(CountTaskTypeEnum type , final CollectTaskDto task, CountDownLatch countDownLatch) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    int inCollectCount = 0;
                    int inStationCount = 0;
                    
                    int outCollectCount = 0;
                    int outStationCount = 0;
                    
                    int inCollectVehicleTypeCount = 0;
                    int intStationVehicleTypeCount= 0;
                    
                    int outCollectVehicleTypeCount= 0;
                    int outStationVehicleTypeCount= 0;
                    // 进站采集任务
                    if(task.getType()==CollectTaskTypeEnum.InStation.getCode()){
                        // 进站车流量分析
                        if(type==CountTaskTypeEnum.InStation&&task.getResultType()==ResultTypeEnum.VEHICLE_FLOW){
                            String startDate = DateHelper.convertDateStrToOtherFormat(String.valueOf(task.getCollectResultFlow().getDataHour()),
                                    DateHelper.FORMAT_5, DateHelper.FORMAT_5_1);
                            Date start = DateHelper.string2Date(startDate, DateHelper.FORMAT_5_1);
                            Date end = DateHelper.string2Date(DateHelper.dateAddHour(start, DateHelper.FORMAT_5_1, 1), DateHelper.FORMAT_5_1); 
                            // 进站 采集设备
                            VehiclesCriteria inCollectExample = new VehiclesCriteria();
                            VehiclesCriteria.Criteria  inCollectCri = inCollectExample.createCriteria();
                            inCollectCri.andRepoIdEqualTo(String.valueOf(task.getCollectId()));
                            inCollectCri.andSensorIdIn(convertLongList2StringList(task.getSensorCollectInIds()));
                            inCollectCri.andTsGreaterThanOrEqualTo(start.getTime());
                            inCollectCri.andTsLessThan(end.getTime());
                            inCollectCount = vehiclesService.countByExample(inCollectExample);
                            // 进站 油站摄像机
                            VehiclesCriteria inStationExample = new VehiclesCriteria();
                            VehiclesCriteria.Criteria  inStationCri = inStationExample.createCriteria();
                            inStationCri.andRepoIdEqualTo(String.valueOf(task.getOilStationId()));
                            inStationCri.andSensorIdIn(convertLongList2StringList(task.getSensorInIds()));
                            inStationCri.andTsGreaterThanOrEqualTo(start.getTime());
                            inStationCri.andTsLessThan(end.getTime());
                            inStationCount = vehiclesService.countByExample(inStationExample);
                        }
                        // 进站车辆类型分析
                        if(type==CountTaskTypeEnum.InVehicleType&&task.getResultType()==ResultTypeEnum.VEHICLE_TYPE){
                            String vehicleType = task.getCollectResultType().getVerhicleType();
                            // 进站采集设备
                            VehiclesCriteria inCollectExample = new VehiclesCriteria();
                            VehiclesCriteria.Criteria  inCollectCri = inCollectExample.createCriteria();
                            inCollectCri.andRepoIdEqualTo(String.valueOf(task.getCollectId()));
                            inCollectCri.andSensorIdIn(convertLongList2StringList(task.getSensorCollectInIds()));
                            inCollectCri.andTypeIdEqualTo(NumberUtils.toShort(vehicleType));
                            inCollectCri.andTsGreaterThanOrEqualTo(task.getCollectStartTime().getTime());
                            inCollectCri.andTsLessThan(task.getCollectEndTime().getTime());
                            inCollectVehicleTypeCount = vehiclesService.countByExample(inCollectExample);
                            // 进站 油站摄像机
                            VehiclesCriteria inStationExample = new VehiclesCriteria();
                            VehiclesCriteria.Criteria  inStationCri = inStationExample.createCriteria();
                            inStationCri.andRepoIdEqualTo(String.valueOf(task.getOilStationId()));
                            inStationCri.andSensorIdIn(convertLongList2StringList(task.getSensorInIds()));
                            inStationCri.andTypeIdEqualTo(NumberUtils.toShort(vehicleType));
                            inStationCri.andTsGreaterThanOrEqualTo(task.getCollectStartTime().getTime());
                            inStationCri.andTsLessThan(task.getCollectEndTime().getTime());
                            intStationVehicleTypeCount = vehiclesService.countByExample(inStationExample);
                        }
                    }
                   // 站外采集任务
                   if(task.getType()==CollectTaskTypeEnum.OutStation.getCode()){
                        // 站外车流量分析
                        if(type==CountTaskTypeEnum.OutStation&&task.getResultType()==ResultTypeEnum.VEHICLE_FLOW){
                            String startDate = DateHelper.convertDateStrToOtherFormat(String.valueOf(task.getCollectResultFlow().getDataHour()),
                                    DateHelper.FORMAT_5, DateHelper.FORMAT_5_1);
                            Date start = DateHelper.string2Date(startDate, DateHelper.FORMAT_5_1);
                            Date end = DateHelper.string2Date(DateHelper.dateAddHour(start, DateHelper.FORMAT_5_1, 1), DateHelper.FORMAT_5_1);
                            // 站外 采集设备
                            VehiclesCriteria outCollectExample = new VehiclesCriteria();
                            VehiclesCriteria.Criteria  outCollectCri = outCollectExample.createCriteria();
                            outCollectCri.andRepoIdEqualTo(String.valueOf(task.getCollectId()));
                            outCollectCri.andSensorIdIn(convertLongList2StringList(task.getSensorCollectOutIds()));
                            outCollectCri.andTsGreaterThanOrEqualTo(start.getTime());
                            outCollectCri.andTsLessThan(end.getTime());
                            outCollectCount = vehiclesService.countByExample(outCollectExample);
                            // 站外 油站摄像机
                            VehiclesCriteria outStationExample = new VehiclesCriteria();
                            VehiclesCriteria.Criteria  outStationCri = outStationExample.createCriteria();
                            outStationCri.andRepoIdEqualTo(String.valueOf(task.getOilStationId()));
                            outStationCri.andSensorIdIn(convertLongList2StringList(task.getSensorOutIds()));
                            outStationCri.andTsGreaterThanOrEqualTo(start.getTime());
                            outStationCri.andTsLessThan(end.getTime());
                            outStationCount = vehiclesService.countByExample(outStationExample);
                        }
                        // 站外车辆类型分析
                        if(type==CountTaskTypeEnum.OutVehicleType&&task.getResultType()==ResultTypeEnum.VEHICLE_TYPE){
                            String vehicleType = task.getCollectResultType().getVerhicleType();
                           // 站外采集设备
                            VehiclesCriteria outCollectExample = new VehiclesCriteria();
                            VehiclesCriteria.Criteria  outCollectCri = outCollectExample.createCriteria();
                            outCollectCri.andRepoIdEqualTo(String.valueOf(task.getCollectId()));
                            outCollectCri.andSensorIdIn(convertLongList2StringList(task.getSensorCollectOutIds()));
                            outCollectCri.andTypeIdEqualTo(NumberUtils.toShort(vehicleType));
                            outCollectCri.andTsGreaterThanOrEqualTo(task.getCollectStartTime().getTime());
                            outCollectCri.andTsLessThan(task.getCollectEndTime().getTime());
                            outCollectVehicleTypeCount = vehiclesService.countByExample(outCollectExample);
                            // 站外 油站摄像机
                            VehiclesCriteria outStationExample = new VehiclesCriteria();
                            VehiclesCriteria.Criteria  outStationCri = outStationExample.createCriteria();
                            outStationCri.andRepoIdEqualTo(String.valueOf(task.getOilStationId()));
                            outStationCri.andSensorIdIn(convertLongList2StringList(task.getSensorOutIds()));
                            outStationCri.andTypeIdEqualTo(NumberUtils.toShort(vehicleType));
                            outStationCri.andTsGreaterThanOrEqualTo(task.getCollectStartTime().getTime());
                            outStationCri.andTsLessThan(task.getCollectEndTime().getTime());
                            outStationVehicleTypeCount = vehiclesService.countByExample(outStationExample);
                        }
                    }
                   
                   // 进站和站外采集任务
                   if(task.getType()==CollectTaskTypeEnum.ALL.getCode()){
                       // 进站车流量分析
                       if(type==CountTaskTypeEnum.InStation&&task.getResultType()==ResultTypeEnum.VEHICLE_FLOW){
                           String startDate = DateHelper.convertDateStrToOtherFormat(String.valueOf(task.getCollectResultFlow().getDataHour()),
                                   DateHelper.FORMAT_5, DateHelper.FORMAT_5_1);
                           Date start = DateHelper.string2Date(startDate, DateHelper.FORMAT_5_1);
                           Date end = DateHelper.string2Date(DateHelper.dateAddHour(start, DateHelper.FORMAT_5_1, 1), DateHelper.FORMAT_5_1); 
                           // 进站 采集设备
                           VehiclesCriteria inCollectExample = new VehiclesCriteria();
                           VehiclesCriteria.Criteria  inCollectCri = inCollectExample.createCriteria();
                           inCollectCri.andRepoIdEqualTo(String.valueOf(task.getCollectId()));
                           inCollectCri.andSensorIdIn(convertLongList2StringList(task.getSensorCollectInIds()));
                           inCollectCri.andTsGreaterThanOrEqualTo(start.getTime());
                           inCollectCri.andTsLessThan(end.getTime());
                           inCollectCount = vehiclesService.countByExample(inCollectExample);
                           // 进站 油站摄像机
                           VehiclesCriteria inStationExample = new VehiclesCriteria();
                           VehiclesCriteria.Criteria  inStationCri = inStationExample.createCriteria();
                           inStationCri.andRepoIdEqualTo(String.valueOf(task.getOilStationId()));
                           inStationCri.andSensorIdIn(convertLongList2StringList(task.getSensorInIds()));
                           inStationCri.andTsGreaterThanOrEqualTo(start.getTime());
                           inStationCri.andTsLessThan(end.getTime());
                           inStationCount = vehiclesService.countByExample(inStationExample);
                       }
                       // 进站车辆类型分析
                       if(type==CountTaskTypeEnum.InVehicleType&&task.getResultType()==ResultTypeEnum.VEHICLE_TYPE){
                           String vehicleType = task.getCollectResultType().getVerhicleType();
                           // 进站采集设备
                           VehiclesCriteria inCollectExample = new VehiclesCriteria();
                           VehiclesCriteria.Criteria  inCollectCri = inCollectExample.createCriteria();
                           inCollectCri.andRepoIdEqualTo(String.valueOf(task.getCollectId()));
                           inCollectCri.andSensorIdIn(convertLongList2StringList(task.getSensorCollectInIds()));
                           inCollectCri.andTypeIdEqualTo(NumberUtils.toShort(vehicleType));
                           inCollectCri.andTsGreaterThanOrEqualTo(task.getCollectStartTime().getTime());
                           inCollectCri.andTsLessThan(task.getCollectEndTime().getTime());
                           inCollectVehicleTypeCount = vehiclesService.countByExample(inCollectExample);
                           // 进站 油站摄像机
                           VehiclesCriteria inStationExample = new VehiclesCriteria();
                           VehiclesCriteria.Criteria  inStationCri = inStationExample.createCriteria();
                           inStationCri.andRepoIdEqualTo(String.valueOf(task.getOilStationId()));
                           inStationCri.andSensorIdIn(convertLongList2StringList(task.getSensorInIds()));
                           inStationCri.andTypeIdEqualTo(NumberUtils.toShort(vehicleType));
                           inStationCri.andTsGreaterThanOrEqualTo(task.getCollectStartTime().getTime());
                           inStationCri.andTsLessThan(task.getCollectEndTime().getTime());
                           intStationVehicleTypeCount = vehiclesService.countByExample(inStationExample);
                       }
                       // 站外车流量分析
                       if(type==CountTaskTypeEnum.OutStation&&task.getResultType()==ResultTypeEnum.VEHICLE_FLOW){
                           String startDate = DateHelper.convertDateStrToOtherFormat(String.valueOf(task.getCollectResultFlow().getDataHour()),
                                   DateHelper.FORMAT_5, DateHelper.FORMAT_5_1);
                           Date start = DateHelper.string2Date(startDate, DateHelper.FORMAT_5_1);
                           Date end = DateHelper.string2Date(DateHelper.dateAddHour(start, DateHelper.FORMAT_5_1, 1), DateHelper.FORMAT_5_1);
                           // 站外 采集设备
                           VehiclesCriteria outCollectExample = new VehiclesCriteria();
                           VehiclesCriteria.Criteria  outCollectCri = outCollectExample.createCriteria();
                           outCollectCri.andRepoIdEqualTo(String.valueOf(task.getCollectId()));
                           outCollectCri.andSensorIdIn(convertLongList2StringList(task.getSensorCollectOutIds()));
                           outCollectCri.andTsGreaterThanOrEqualTo(start.getTime());
                           outCollectCri.andTsLessThan(end.getTime());
                           outCollectCount = vehiclesService.countByExample(outCollectExample);
                           // 站外 油站摄像机
                           VehiclesCriteria outStationExample = new VehiclesCriteria();
                           VehiclesCriteria.Criteria  outStationCri = outStationExample.createCriteria();
                           outStationCri.andRepoIdEqualTo(String.valueOf(task.getOilStationId()));
                           outStationCri.andSensorIdIn(convertLongList2StringList(task.getSensorOutIds()));
                           outStationCri.andTsGreaterThanOrEqualTo(start.getTime());
                           outStationCri.andTsLessThan(end.getTime());
                           outStationCount = vehiclesService.countByExample(outStationExample);
                       }
                       // 站外车辆类型分析
                       if(type==CountTaskTypeEnum.OutVehicleType&&task.getResultType()==ResultTypeEnum.VEHICLE_TYPE){
                           String vehicleType = task.getCollectResultType().getVerhicleType();
                          // 站外采集设备
                           VehiclesCriteria outCollectExample = new VehiclesCriteria();
                           VehiclesCriteria.Criteria  outCollectCri = outCollectExample.createCriteria();
                           outCollectCri.andRepoIdEqualTo(String.valueOf(task.getCollectId()));
                           outCollectCri.andSensorIdIn(convertLongList2StringList(task.getSensorCollectOutIds()));
                           outCollectCri.andTypeIdEqualTo(NumberUtils.toShort(vehicleType));
                           outCollectCri.andTsGreaterThanOrEqualTo(task.getCollectStartTime().getTime());
                           outCollectCri.andTsLessThan(task.getCollectEndTime().getTime());
                           outCollectVehicleTypeCount = vehiclesService.countByExample(outCollectExample);
                           // 站外 油站摄像机
                           VehiclesCriteria outStationExample = new VehiclesCriteria();
                           VehiclesCriteria.Criteria  outStationCri = outStationExample.createCriteria();
                           outStationCri.andRepoIdEqualTo(String.valueOf(task.getOilStationId()));
                           outStationCri.andSensorIdIn(convertLongList2StringList(task.getSensorOutIds()));
                           outStationCri.andTypeIdEqualTo(NumberUtils.toShort(vehicleType));
                           outStationCri.andTsGreaterThanOrEqualTo(task.getCollectStartTime().getTime());
                           outStationCri.andTsLessThan(task.getCollectEndTime().getTime());
                           outStationVehicleTypeCount = vehiclesService.countByExample(outStationExample);
                       }
                   }
                   if(task.getResultType()==ResultTypeEnum.VEHICLE_FLOW){
                       CollectResultFlow flowRecord = new CollectResultFlow();
                       boolean flag = false;
                       if(inCollectCount>0){
                           flowRecord.setCollectInCount(inCollectCount);
                           flag = true;
                       }
                       if(outCollectCount>0){
                           flowRecord.setCollectOutCount(outCollectCount);
                           flag = true;
                       }
                       if(inStationCount>0){
                           flowRecord.setStationInCount(inStationCount);
                           flag = true;
                       }
                       if(outStationCount>0){
                           flowRecord.setStationOutCount(outStationCount);
                           flag = true;
                       }
                       flowRecord.setId(task.getResultId());
                       if(flag){
                           collectResultFlowService.updateByPrimaryKeySelective(flowRecord);
                       }
                   }else if(task.getResultType()==ResultTypeEnum.VEHICLE_TYPE){
                       CollectResultType typeRecord = new CollectResultType();
                       boolean flag = false;
                       if(inCollectVehicleTypeCount>0){
                           typeRecord.setCollectInCount(inCollectVehicleTypeCount);
                           flag = true;
                       }
                       if(outCollectVehicleTypeCount>0){
                           typeRecord.setCollectOutCount(outCollectVehicleTypeCount);
                           flag = true;
                       }
                       if(intStationVehicleTypeCount>0){
                           typeRecord.setStationInCount(intStationVehicleTypeCount);
                           flag = true;
                       }
                       if(outStationVehicleTypeCount>0){
                           typeRecord.setStationOutCount(outStationVehicleTypeCount);
                           flag = true;
                       }
                       typeRecord.setId(task.getResultId());
                       if(flag){
                           collectResultTypeService.updateByPrimaryKeySelective(typeRecord);
                       }
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

    private List<String> convertLongList2StringList(List<Long> list){
        List<String> ids = new ArrayList<String>();
        if(CollectionUtils.isNotEmpty(list)){
            for(Long id :list){
                ids.add(String.valueOf(id));
            }
        }
        return ids;
    }
   
    
   

}