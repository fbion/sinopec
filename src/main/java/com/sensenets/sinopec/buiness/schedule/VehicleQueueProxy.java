/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月23日 下午12:30:51
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.schedule;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sensenets.sinopec.buiness.model.one.Repos;
import com.sensenets.sinopec.buiness.model.one.ReposCriteria;
import com.sensenets.sinopec.buiness.model.one.Sensors;
import com.sensenets.sinopec.buiness.model.one.SensorsCriteria;
import com.sensenets.sinopec.buiness.model.two.Images;
import com.sensenets.sinopec.buiness.model.two.VehicleQueue;
import com.sensenets.sinopec.buiness.model.two.Vehicles;
import com.sensenets.sinopec.buiness.model.two.VehiclesCriteria;
import com.sensenets.sinopec.buiness.service.IImagesService;
import com.sensenets.sinopec.buiness.service.IReposService;
import com.sensenets.sinopec.buiness.service.ISensorsService;
import com.sensenets.sinopec.buiness.service.IVehiclesService;
import com.sensenets.sinopec.common.enums.SensorGroupEnum;
import com.sensenets.sinopec.common.enums.VehicleRecordTypeEnum;
import com.sensenets.sinopec.common.utils.DateHelper;
import com.sensenets.sinopec.common.utils.UUIDHelper;
import com.sensenets.sinopec.config.AppConfig;
import com.sensenets.sinopec.kafka.common.ConvertHelper;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: VehicleQueueProxy
 * @Description: 车辆排队代理
 * @author think
 * @date 2018年9月23日 下午12:30:51
 *
 */
@Service
@Slf4j
public class VehicleQueueProxy {

    @Autowired
    private IVehiclesService vehicesService;

    @Autowired
    private ISensorsService sensorsService;
    
    @Autowired
    private IReposService resposService;
    
    @Autowired
    private IImagesService imagesService;
    
    @Autowired
    private AppConfig appConfig;

    private static final int pageSize = 500;

    private Map<String, VehicleQueueCountDto> map;
    
    /**
     * @Title: getVehicleByDay
     * @Description: 每天凌晨3点获取前一天车辆记录
     */
    @Scheduled(cron = "0 0 3 * * ?")
    public void getVehicleByDay() {
        if(!appConfig.isVehicleScheduleEnabled()){
             log.info("油站端忽略执行车辆排队定时任务");
        }
        map = Maps.newHashMap();
        int total = countRecord();
        int page = total <= pageSize ? 1 : total / pageSize + 1;
        Map<String, Short> sensorGroupMap = Maps.newHashMap();
        Map<String, String> sensorNameMap = Maps.newHashMap();
        Set<String> allSensorIds = getDaySensor();
        // 加载设备信息
        loadAllSensors(allSensorIds,sensorGroupMap,sensorNameMap);
        // 加载油站信息
        Map<String, String> reposNameMap = Maps.newHashMap();
        Set<String> allRespoIds = getDayRepos();
        loadAllRespos(allRespoIds,reposNameMap);
        // 记录分类 同一个油站同一个车牌 ，进站，加油，出站 记录分类
        generateVehicleCountRecord(page,sensorGroupMap);
        // 计算同一个油站 最早进站记录，最晚加油记录，最晚出站记录 ，排队时间=最晚加油记录-最早进站记录
        generateVehicleQueueRecord(sensorNameMap,reposNameMap);
        
    }
    
    /**
      * @Title: generateVehicleQueueRecord
      * @Description: 计算车辆排队
      */
    private void generateVehicleQueueRecord(final Map<String, String> sensorNameMap,final Map<String, String> reposNameMap){
        if(MapUtils.isEmpty(map)){
            return ;
        }
        for(Map.Entry<String, VehicleQueueCountDto> entry:map.entrySet()){
            VehicleQueueCountDto countDto = entry.getValue();
            List<VehicleSortDto> inList = countDto.getInList();
            List<VehicleSortDto> outList = countDto.getOutList();
            List<VehicleSortDto> oilList = countDto.getOilList();
            if(CollectionUtils.isEmpty(inList)||CollectionUtils.isEmpty(outList)){
                continue;
            }
            Collections.sort(inList);
            Collections.sort(outList);
            long queueTime = 0L;
            // 同一个油站 同一个车牌 最早进站记录，最晚加油记录，最晚出站记录 ，排队时间=最晚加油记录-最早进站记录
            VehicleSortDto inVeh = inList.get(0);
            VehicleSortDto outVeh = outList.get(outList.size()-1);
            if(CollectionUtils.isNotEmpty(oilList)){
                Collections.sort(oilList);
                VehicleSortDto oilVeh = oilList.get(oilList.size()-1);
                queueTime = oilVeh.getTs()-inVeh.getTs();
            }
            VehicleQueue queue = new VehicleQueue();
            queue = generateVehicleQueueObj(sensorNameMap,reposNameMap,queueTime,inVeh,outVeh);
            VehiclesQueue.add(queue);
        }
        
    }
    
 
    /**
      * @Title: generateVehicleQueueObj
      * @Description: 生成排队对象
      * @param sensorNameMap 设备名称
      * @param reposNameMap 油站名称
      * @param queueTime 排队时间
      * @param oilType 加油类型
      * @param in 进站记录
      * @param out 出站记录
      * @return
      */
    private VehicleQueue generateVehicleQueueObj(final Map<String, String> sensorNameMap,final Map<String, String> reposNameMap,long queueTime,final  VehicleSortDto in , final VehicleSortDto out) {
        VehicleQueue queue = new VehicleQueue();
        queue.setBizId(UUIDHelper.genUUID(false));
        queue.setReposId(Long.parseLong(in.getRepoId()));
        queue.setReposName(reposNameMap.containsKey(in.getRepoId())?reposNameMap.get(in.getRepoId()):"未知");
        if(StringUtils.isNotBlank(String.valueOf(in.getEngineFuel()))){
            queue.setOilType(String.valueOf(in.getEngineFuel()));
        }else{
            if(StringUtils.isNotBlank(String.valueOf(out.getEngineFuel()))){
                queue.setOilType(String.valueOf(out.getEngineFuel()));
            }
        }
        queue.setUts(new Date());
        // 排队时间= 进站时间-提枪时间
        queue.setQueueTime(queueTime);
        // 进出站时间= 进站时间-出站时间
        queue.setInOutTime(Math.abs(in.getTs() - out.getTs()));
        // 查询图片地址
        Images outImage = imagesService.selectByPrimaryKey(out.getImageId());
        queue.setOutSensorName(sensorNameMap.containsKey(out.getSensorId()) ? sensorNameMap.get(out.getSensorId()) : "未知");
        queue.setOutFeatureImage(outImage != null ? outImage.getThumbnailImageUri() : "暂无");
        queue.setOutSourceImage(outImage != null ? outImage.getImageUri() : "暂无");
        queue.setOutImageId(outImage.getImageId());
        queue.setOutAngleId(out.getSide());
        queue.setOutBrandId(out.getBrandId());
        queue.setOutColorId(out.getColorId());
        queue.setOutModeYearId(out.getModelYearId());
        queue.setOutPlateColorId(out.getPlateColorId());
        queue.setOutPlateText(out.getPlateText());
        queue.setOutPlateTypeId(out.getPlateTypeId());
        queue.setOutSensorId(ConvertHelper.str2Long(out.getSensorId()));
        queue.setOutSubBrandId(out.getSubBrandId());
        queue.setOutTime(DateHelper.string2Date(DateHelper.long2DateStr(out.getTs(), DateHelper.FORMAT_0), DateHelper.FORMAT_0));
        queue.setOutTypeId(out.getTypeId());
        queue.setOutVehicleId(out.getId());

        // 查询图片地址
        Images inImage = imagesService.selectByPrimaryKey(in.getImageId());
        queue.setInSensorName(sensorNameMap.containsKey(in.getSensorId()) ? sensorNameMap.get(in.getSensorId()) : "未知");
        queue.setInFeatureImage(inImage != null ? inImage.getThumbnailImageUri() : "暂无");
        queue.setInSourceImage(inImage != null ? inImage.getImageUri() : "暂无");
        queue.setInImageId(inImage.getImageId());
        queue.setInAngleId(in.getSide());
        queue.setInBrandId(in.getBrandId());
        queue.setInColorId(in.getColorId());
        queue.setInModeYearId(in.getModelYearId());
        queue.setInPlateColorId(in.getPlateColorId());
        queue.setInPlateText(in.getPlateText());
        queue.setInPlateTypeId(in.getPlateTypeId());
        queue.setInSensorId(ConvertHelper.str2Long(in.getSensorId()));
        queue.setInSubBrandId(in.getSubBrandId());
        queue.setInTime(DateHelper.string2Date(DateHelper.long2DateStr(in.getTs(), DateHelper.FORMAT_0), DateHelper.FORMAT_0));
        queue.setInTypeId(in.getTypeId());
        queue.setInVehicleId(in.getId());
        return queue;
    }

    
    private void loadAllSensors(final Set<String> allSensorIds,final Map<String, Short> sensorGroupMap,final Map<String, String> sensorNameMap){
        if (CollectionUtils.isNotEmpty(allSensorIds)) {
            SensorsCriteria senExp = new SensorsCriteria();
            SensorsCriteria.Criteria cri = senExp.createCriteria();
            List<Long> sensorIds = Lists.newArrayList();
            for (String sensorId : allSensorIds) {
                sensorIds.add(Long.parseLong(sensorId));
            }
            cri.andIdIn(sensorIds);
            List<Sensors> sensorList = sensorsService.selectByExample(senExp);
            if (CollectionUtils.isNotEmpty(sensorList)) {
                for (Sensors sensor : sensorList) {
                    sensorGroupMap.put(String.valueOf(sensor.getId()), sensor.getGroupType());
                    sensorNameMap.put(String.valueOf(sensor.getId()), sensor.getSensorName());
                }
            }
        }
    }
    
    private void loadAllRespos(final Set<String> allReposIds,final Map<String, String> reposNameMap){
        if (CollectionUtils.isNotEmpty(allReposIds)) {
           ReposCriteria senExp = new ReposCriteria();
           ReposCriteria.Criteria cri = senExp.createCriteria();
            List<Long> ids = Lists.newArrayList();
            for (String id : allReposIds) {
                ids.add(Long.parseLong(id));
            }
            cri.andIdIn(ids);
            List<Repos> reposList = resposService.selectByExample(senExp);
            if (CollectionUtils.isNotEmpty(reposList)) {
                for (Repos repos : reposList) {
                    reposNameMap.put(String.valueOf(repos.getId()), repos.getRepoName());
                }
            }
        }
    }
    
    /**
      * @Title: generateVehicleCountRecord
      * @Description: 记录分类
      * @param page
      * @param sensorGroupMap
      */
    private void generateVehicleCountRecord(final int page,final Map<String, Short> sensorGroupMap){
        for (int pageNumber = 1; pageNumber <= page; pageNumber++) {
            PageInfo<Vehicles> list = vehicesService.selectPageByExample(generateVehiclesCriteria(false, pageSize, pageNumber));
            if (CollectionUtils.isNotEmpty(list.getList())) {
                for (Vehicles veh : list.getList()) {
                    String key = String.valueOf(veh.getRepoId())+"_"+veh.getPlateText();
                    if (sensorGroupMap.containsKey(veh.getSensorId()) && sensorGroupMap.get(veh.getSensorId()) == SensorGroupEnum.sensor_come.getCode()) {
                        if(map.containsKey(key)){
                            VehicleQueueCountDto countDto = map.get(key);
                            VehicleSortDto dto = new VehicleSortDto();
                            try {
                                BeanUtils.copyProperties(dto, veh);
                            } catch (Exception e) {
                               e.printStackTrace();
                            }
                            dto.setType(VehicleRecordTypeEnum.In);
                            countDto.getInList().add(dto);
                        }else{
                            VehicleQueueCountDto countDto = new VehicleQueueCountDto();
                            countDto.setRepoId(veh.getRepoId());
                            VehicleSortDto dto = new VehicleSortDto();
                            try {
                                BeanUtils.copyProperties(dto, veh);
                            } catch (Exception e) {
                               e.printStackTrace();
                            }
                            dto.setType(VehicleRecordTypeEnum.In);
                            countDto.getInList().add(dto);
                            map.put(key, countDto);
                        }
                    }
                    else if (sensorGroupMap.containsKey(veh.getSensorId()) && sensorGroupMap.get(veh.getSensorId()) == SensorGroupEnum.sensor_exit.getCode()) {
                        if(map.containsKey(key)){
                            VehicleQueueCountDto countDto = map.get(key);
                            VehicleSortDto dto = new VehicleSortDto();
                            try {
                                BeanUtils.copyProperties(dto, veh);
                            } catch (Exception e) {
                               e.printStackTrace();
                            }
                            dto.setType(VehicleRecordTypeEnum.Out);
                            countDto.getOutList().add(dto);
                        }else{
                            VehicleQueueCountDto countDto = new VehicleQueueCountDto();
                            countDto.setRepoId(veh.getRepoId());
                            VehicleSortDto dto = new VehicleSortDto();
                            try {
                                BeanUtils.copyProperties(dto, veh);
                            } catch (Exception e) {
                               e.printStackTrace();
                            }
                            dto.setType(VehicleRecordTypeEnum.Out);
                            countDto.getOutList().add(dto);
                            map.put(key, countDto);
                        }
                    }else if (sensorGroupMap.containsKey(veh.getSensorId()) && sensorGroupMap.get(veh.getSensorId()) == SensorGroupEnum.sensor_oil.getCode()) {
                        if(map.containsKey(key)){
                            VehicleQueueCountDto countDto = map.get(key);
                            VehicleSortDto dto = new VehicleSortDto();
                            try {
                                BeanUtils.copyProperties(dto, veh);
                            } catch (Exception e) {
                               e.printStackTrace();
                            }
                            dto.setType(VehicleRecordTypeEnum.Oil);
                            countDto.getOilList().add(dto);
                        }else{
                            VehicleQueueCountDto countDto = new VehicleQueueCountDto();
                            countDto.setRepoId(veh.getRepoId());
                            VehicleSortDto dto = new VehicleSortDto();
                            try {
                                BeanUtils.copyProperties(dto, veh);
                            } catch (Exception e) {
                               e.printStackTrace();
                            }
                            dto.setType(VehicleRecordTypeEnum.Oil);
                            countDto.getOilList().add(dto);
                            map.put(key, countDto);
                        }
                    }
                   
                }
            }
        }
    }


    private int countRecord() {
        return vehicesService.countByExample(generateVehiclesCriteria(true, 0, 0));
    }

    /**
     * @Title: getDayRepos
     * @Description: 获取前一天的所有油站
     * @return
     */
    private Set<String> getDayRepos() {
        Set<String> set = Sets.newHashSet();
        List<String> list = vehicesService.getAllReposIds(generateVehiclesCriteria(true, 0, 0));
        if (CollectionUtils.isNotEmpty(list)) {
            set.addAll(list);
        }
        return set;
    }

    /**
     * @Title: getDaySensor
     * @Description: 获取前一天的所有油站相机
     * @return
     */
    private Set<String> getDaySensor() {
        Set<String> set = Sets.newHashSet();
        List<String> list = vehicesService.getAllSensorIds(generateVehiclesCriteria(true, 0, 0));
        if (CollectionUtils.isNotEmpty(list)) {
            set.addAll(list);
        }
        return set;
    }

    private VehiclesCriteria generateVehiclesCriteria(boolean count, int pageSize, int pageNumber) {
        VehiclesCriteria criExp = new VehiclesCriteria();
        criExp.setDistinct(true);
        if(!count){
            criExp.setPageNumber(pageNumber);
            criExp.setPageSize(pageSize);
        }
        VehiclesCriteria.Criteria cri = criExp.createCriteria();
        Date countDate = DateHelper.dateAddDay(new Date(), -1);
        String startDate = DateHelper.getSomeDateStartTimeF0(countDate);
        String endDate = DateHelper.getSomeDateEndTimeF0(countDate);
        cri.andTsGreaterThanOrEqualTo(DateHelper.reverseDate2Long(startDate));
        cri.andTsLessThanOrEqualTo(DateHelper.reverseDate2Long(endDate));
        cri.andPlateTextIsNotNull();
        cri.andPlateTextNotEqualTo("-");
        return criExp;
    }

}
