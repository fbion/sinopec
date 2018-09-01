package com.sensenets.sinopec.buiness.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sensenets.sinopec.buiness.dao.one.MobileCollectTaskMapper;
import com.sensenets.sinopec.buiness.dao.one.ReposMapper;
import com.sensenets.sinopec.buiness.dao.one.SensorsMapper;
import com.sensenets.sinopec.buiness.dao.one.VjMobileCollectTaskViewMapper;
import com.sensenets.sinopec.buiness.dao.two.CollectResultFlowMapper;
import com.sensenets.sinopec.buiness.dao.two.CollectResultTypeMapper;
import com.sensenets.sinopec.buiness.dto.CollectResultDto;
import com.sensenets.sinopec.buiness.dto.CollectTaskDto;
import com.sensenets.sinopec.buiness.dto.MobileCollectTaskDto;
import com.sensenets.sinopec.buiness.dto.RepoIdDto;
import com.sensenets.sinopec.buiness.model.one.MobileCollectTask;
import com.sensenets.sinopec.buiness.model.one.MobileCollectTaskCriteria;
import com.sensenets.sinopec.buiness.model.one.Repos;
import com.sensenets.sinopec.buiness.model.one.ReposCriteria;
import com.sensenets.sinopec.buiness.model.one.Sensors;
import com.sensenets.sinopec.buiness.model.one.SensorsCriteria;
import com.sensenets.sinopec.buiness.model.one.VjMobileCollectTaskView;
import com.sensenets.sinopec.buiness.model.one.VjMobileCollectTaskViewCriteria;
import com.sensenets.sinopec.buiness.model.two.CollectResultFlow;
import com.sensenets.sinopec.buiness.model.two.CollectResultFlowCriteria;
import com.sensenets.sinopec.buiness.model.two.CollectResultType;
import com.sensenets.sinopec.buiness.model.two.CollectResultTypeCriteria;
import com.sensenets.sinopec.buiness.schedule.CollectTaskQueue;
import com.sensenets.sinopec.buiness.schedule.ExcelExportHelper;
import com.sensenets.sinopec.buiness.service.IMobileCollectTaskService;
import com.sensenets.sinopec.common.enums.BizExceptionEnum;
import com.sensenets.sinopec.common.enums.CollectTaskStatusEnum;
import com.sensenets.sinopec.common.enums.SensorGroupEnum;
import com.sensenets.sinopec.common.enums.VehicleTypeEnum;
import com.sensenets.sinopec.common.exception.BusinessException;
import com.sensenets.sinopec.common.utils.DateHelper;
import com.sensenets.sinopec.common.utils.JsonHelper;

import io.jsonwebtoken.lang.Collections;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MobileCollectTaskServiceImpl implements IMobileCollectTaskService {

    @Autowired
    private MobileCollectTaskMapper mobileCollectTaskMapper;

    @Autowired
    private VjMobileCollectTaskViewMapper vjMobileCollectTaskViewMapper;

    @Autowired
    private ReposMapper reposMapper;

    @Autowired
    private SensorsMapper sensorsMapper;
    
    @Autowired
    private CollectResultFlowMapper  collectResultFlowMapper ;
    
    @Autowired
    private CollectResultTypeMapper  collectResultTypeMapper ;
    
    public int countByExample(MobileCollectTaskCriteria example) {
        int count = this.mobileCollectTaskMapper.countByExample(example);
        return count;
    }

    public MobileCollectTask selectByPrimaryKey(Long id) {
        return this.mobileCollectTaskMapper.selectByPrimaryKey(id);
    }

    public List<MobileCollectTask> selectByExample(MobileCollectTaskCriteria example) {
        return this.mobileCollectTaskMapper.selectByExample(example);
    }

    
    
    public PageInfo<MobileCollectTaskDto> selectPageByExample(VjMobileCollectTaskViewCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize(),true);
        List<VjMobileCollectTaskView> list = this.vjMobileCollectTaskViewMapper.selectByExample(example);
        PageInfo<VjMobileCollectTaskView> page = new PageInfo<VjMobileCollectTaskView>(list);
        // 获取所有父节点的信息放入集合
        PageInfo<MobileCollectTaskDto> pageInfo = new PageInfo<MobileCollectTaskDto>(Lists.newArrayList());
        if (CollectionUtils.isNotEmpty(list)) {
            List<Long> pids = Lists.newArrayList();
            for (VjMobileCollectTaskView view : list) {
                if (ArrayUtils.isNotEmpty(view.getCollectRpath())) {
                    pids.addAll(Collections.arrayToList(view.getCollectRpath()));
                }
                if (ArrayUtils.isNotEmpty(view.getStationRpath())) {
                    pids.addAll(Collections.arrayToList(view.getStationRpath()));
                }
            }
            Set<Long> repoid = Sets.newHashSet();
            if (CollectionUtils.isNotEmpty(pids)) {
                for (Long id : pids) {
                    repoid.add(id);
                }
            }
            ReposCriteria parentEx = new ReposCriteria();
            ReposCriteria.Criteria reposCri = parentEx.createCriteria();
            reposCri.andIdIn(new ArrayList<Long>(repoid));
            List<Repos> parentList = reposMapper.selectByExample(parentEx);
            Map<Long, RepoIdDto> pMap = new HashMap<Long, RepoIdDto>();
            if (CollectionUtils.isNotEmpty(parentList)) {
                for (Repos p : parentList) {
                    pMap.put(p.getId(), new RepoIdDto(p.getId(),p.getRepoId(), p.getRepoName(),p.getRepoLevel()));
                }
            }
            List<MobileCollectTaskDto> pageList = Lists.newArrayList();
            for (VjMobileCollectTaskView view : list) {
                pageList.add(getDto(pMap, view));
            }
            pageInfo = new PageInfo<MobileCollectTaskDto>(pageList);
            pageInfo.setTotal(page.getTotal());
        }
        return pageInfo;
    }

    private MobileCollectTaskDto getDto(final Map<Long, RepoIdDto> pMap, final VjMobileCollectTaskView view) {
        Map<String, String> map = Maps.newHashMap();
        if (ArrayUtils.isNotEmpty(view.getCollectRpath()) && view.getCollectRpath().length >= 3) {
            int len = view.getCollectRpath().length;
            Long[] colletAry = view.getCollectRpath();
            // 采集站点信息
            map.put("collect_1", pMap.get(colletAry[len - 3]).getRepoName());
            map.put("collect_2", pMap.get(colletAry[len - 2]).getRepoName());
            map.put("collect_3", pMap.get(colletAry[len - 1]).getRepoName());
        } else {
            map.put("collect_1", "");
            map.put("collect_2", "");
            map.put("collect_3", "");
        }

        if (ArrayUtils.isNotEmpty(view.getStationRpath()) && view.getStationRpath().length >= 3) {
            int len = view.getStationRpath().length;
            Long[] colletAry = view.getStationRpath();
            // 采集站点信息
            map.put("station_1", pMap.get(colletAry[len - 3]).getRepoName());
            map.put("station_2", pMap.get(colletAry[len - 2]).getRepoName());
            map.put("station_3", pMap.get(colletAry[len - 1]).getRepoName());
           
        } else {
            map.put("station_1", "");
            map.put("station_2", "");
            map.put("station_3", "");
        }
        MobileCollectTaskDto dto = new MobileCollectTaskDto();
        
        dto.setCollectionRepoName(map.get("collect_3"));
        dto.setCollectRepoId(view.getCollectRepoId());
        dto.setCollectAeraName(map.get("collect_2"));
        dto.setCollectCityName(map.get("collect_1"));
        dto.setOilStationRepoName(map.get("station_3"));
        dto.setOilStationRepoId(view.getOilStationRepoId());
        dto.setOilStationManager(map.get("station_2"));
        dto.setOilStationCityName(map.get("station_1"));

        dto.setCollectStartTime(view.getCollectStartTime());
        dto.setCollectEndTime(view.getCollectEndTime());

        dto.setId(view.getId());
        dto.setTaskStatus(view.getTaskStatus());
        dto.setType(view.getType());
        dto.setUserId(view.getUserId());
        dto.setUts(view.getUts());
        
        if (ArrayUtils.isNotEmpty(view.getCollectRpath())) {
            String[] collectParents = new String[view.getCollectRpath().length];
            for(int i= 0;i<view.getCollectRpath().length;i++){
                collectParents[i] = pMap.get(view.getCollectRpath()[i]).getRepoId();
            }
            dto.setCollectParent(JsonHelper.toJson(collectParents));
        }
        if (ArrayUtils.isNotEmpty(view.getStationRpath())) {
            String[] oilStationParents = new String[view.getCollectRpath().length];
            for(int i= 0;i<view.getStationRpath().length;i++){
                oilStationParents[i] = pMap.get(view.getStationRpath()[i]).getRepoId();
            }
            dto.setOilStationParent(JsonHelper.toJson(oilStationParents));
        }
        return dto;
    }

    public int deleteByPrimaryKey(Long id) {
        return this.mobileCollectTaskMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(MobileCollectTask record) {
        return this.mobileCollectTaskMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MobileCollectTask record) {
        return this.mobileCollectTaskMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(MobileCollectTaskCriteria example) {
        return this.mobileCollectTaskMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(MobileCollectTask record, MobileCollectTaskCriteria example) {
        return this.mobileCollectTaskMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(MobileCollectTask record, MobileCollectTaskCriteria example) {
        return this.mobileCollectTaskMapper.updateByExample(record, example);
    }

    public int insert(MobileCollectTask record) {
        int result = this.mobileCollectTaskMapper.insert(record);
        if(result>0){
            VjMobileCollectTaskViewCriteria  viewExample = new VjMobileCollectTaskViewCriteria();
            VjMobileCollectTaskViewCriteria.Criteria cri = viewExample.createCriteria();
            cri.andIdEqualTo(record.getId());
            List<VjMobileCollectTaskView> list = this.vjMobileCollectTaskViewMapper.selectByExample(viewExample);
            VjMobileCollectTaskView view = list.get(0);
            CollectTaskDto dto = new CollectTaskDto();
            dto.setCollectEndTime(view.getCollectEndTime());
            dto.setCollectStartTime(view.getCollectStartTime());
            dto.setCollectRepoId(view.getCollectRepoId());
            dto.setId(view.getId());
            dto.setOilStationRepoId(view.getOilStationRepoId());
            dto.setTaskStatus(view.getTaskStatus());
            dto.setType(view.getType());
            dto.setCollectId(view.getCollectRpath()[view.getCollectRpath().length-1]);
            dto.setOilStationId(view.getStationRpath()[view.getStationRpath().length-1]);
            
            // 油站关联的设备查询
            SensorsCriteria  example = new  SensorsCriteria();
            SensorsCriteria.Criteria  sencri =  example.createCriteria();
            List<String> repoList = Lists.newArrayList();
            repoList.add(dto.getCollectRepoId());
            repoList.add(dto.getOilStationRepoId());
            sencri.andRepoIdIn(repoList);
            List<Short> groupType = Lists.newArrayList();
            groupType.add(SensorGroupEnum.sensor_collect_come.getCode());
            groupType.add(SensorGroupEnum.sensor_collect_out.getCode());
            groupType.add(SensorGroupEnum.sensor_come.getCode());
            groupType.add(SensorGroupEnum.sensor_out.getCode());
            sencri.andGroupTypeIn(groupType);
            List<Sensors> sensorList = sensorsMapper.selectByExample(example);
            if(CollectionUtils.isEmpty(sensorList)){
                throw new BusinessException(BizExceptionEnum.SENSOR_ERROR_NULL);
            }
           List<Long> sensorCollectInIds = new ArrayList<Long>();
           List<Long> sensorCollectOutIds = new ArrayList<Long>();
           List<Long> sensorInIds = new ArrayList<Long>();
           List<Long> sensorOutIds = new ArrayList<Long>();
           for(Sensors sensor : sensorList){
               if(sensor.getGroupType() == SensorGroupEnum.sensor_collect_come.getCode()){
                   sensorCollectInIds.add(sensor.getId());
               }
               if(sensor.getGroupType() == SensorGroupEnum.sensor_collect_out.getCode()){
                   sensorCollectOutIds.add(sensor.getId());
               }
               if(sensor.getGroupType() == SensorGroupEnum.sensor_come.getCode()){
                   sensorInIds.add(sensor.getId());
               }
               if(sensor.getGroupType() == SensorGroupEnum.sensor_out.getCode()){
                   sensorOutIds.add(sensor.getId());
               }
           }
           if(dto.getType()==1&&(CollectionUtils.isEmpty(sensorCollectInIds)||CollectionUtils.isEmpty(sensorInIds))){
               throw new BusinessException(BizExceptionEnum.SENSOR_ERROR_NULL);
           }
           if(dto.getType()==2&&(CollectionUtils.isEmpty(sensorCollectOutIds)||CollectionUtils.isEmpty(sensorOutIds))){
               throw new BusinessException(BizExceptionEnum.SENSOR_ERROR_NULL);
           }
           if(dto.getType()==3&&(CollectionUtils.isEmpty(sensorCollectInIds)||CollectionUtils.isEmpty(sensorCollectOutIds)||CollectionUtils.isEmpty(sensorInIds)||CollectionUtils.isEmpty(sensorOutIds))){
               throw new BusinessException(BizExceptionEnum.SENSOR_ERROR_NULL);
           }
           dto.setSensorCollectInIds(sensorCollectInIds);
           dto.setSensorCollectOutIds(sensorCollectOutIds);
           dto.setSensorInIds(sensorInIds);
           dto.setSensorOutIds(sensorOutIds);
           CollectTaskQueue.add(dto);
        }
        return result;
    }

    public int insertSelective(MobileCollectTask record) {
        return this.mobileCollectTaskMapper.insertSelective(record);
    }

    @Override
    public int updateBatchStatusByPrimaryKey(Short status, List<Long> ids) {
        return this.mobileCollectTaskMapper.updateBatchStatusByPrimaryKey(ids,status);
    }


   
    @Override
    public CollectResultDto getCollectResult(Long id) {
        CollectResultDto dto = new CollectResultDto();
        MobileCollectTask task = mobileCollectTaskMapper.selectByPrimaryKey(id);
        if(task==null){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_ID_PARAMS_ERROR);
        }
        if(task.getTaskStatus()==CollectTaskStatusEnum.RUNNING.getCode()){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_TASK_UNFINISH);
        }
        CollectResultFlowCriteria flowExample = new CollectResultFlowCriteria();
        CollectResultFlowCriteria.Criteria flowCri = flowExample.createCriteria();
        flowCri.andCollectTaskIdEqualTo(id);
        List<CollectResultFlow>  flowList = collectResultFlowMapper.selectByExample(flowExample);
        List<CollectResultDto.ResultInFlow> inFlowList = new ArrayList<CollectResultDto.ResultInFlow>();
        List<CollectResultDto.ResultOutFlow> outFlowList = new ArrayList<CollectResultDto.ResultOutFlow>();
        if(CollectionUtils.isNotEmpty(flowList)){
            for(CollectResultFlow flow: flowList){
                String dateTime = DateHelper.convertDateStrToOtherFormat(String.valueOf(flow.getDataHour()), DateHelper.FORMAT_5, DateHelper.FORMAT_5_2);
                CollectResultDto.ResultInFlow inFlow =  new CollectResultDto.ResultInFlow();
                inFlow.setCollectCount(flow.getCollectInCount());
                inFlow.setStationCount(flow.getStationInCount());
                inFlow.setDataTime(dateTime);
                inFlowList.add(inFlow);
                CollectResultDto.ResultOutFlow outFlow =  new CollectResultDto.ResultOutFlow();
                outFlow.setCollectCount(flow.getCollectOutCount());
                outFlow.setStationCount(flow.getStationOutCount());
                outFlow.setDataTime(dateTime);
                outFlowList.add(outFlow);
            }
        }
        dto.setInFlows(inFlowList);
        dto.setOutFlows(outFlowList);
        
        CollectResultTypeCriteria typeExample = new CollectResultTypeCriteria();
        CollectResultTypeCriteria.Criteria typeCri = typeExample.createCriteria();
        typeCri.andCollectTaskIdEqualTo(id);
        List<CollectResultType>  typeList = collectResultTypeMapper.selectByExample(typeExample);
        List<CollectResultDto.ResultInVehicleType> inTypeList = new ArrayList<CollectResultDto.ResultInVehicleType>();
        List<CollectResultDto.ResultOutVehicleType> outTypeList = new ArrayList<CollectResultDto.ResultOutVehicleType>();
        if(CollectionUtils.isNotEmpty(typeList)){
            int collectInCount = 0;
            int stationInCount = 0;
            int collectOutCount = 0;
            int stationOutCount = 0;
            for(CollectResultType type: typeList){
                String veType = VehicleTypeEnum.getDescByCode(NumberUtils.toShort(type.getVerhicleType()));
                if(veType.equals("其他")){
                    collectInCount +=type.getCollectInCount();
                    stationInCount +=type.getStationInCount();
                    collectOutCount +=type.getCollectOutCount();
                    stationOutCount +=type.getStationOutCount();
                    continue;
                }
                CollectResultDto.ResultInVehicleType inType =  new CollectResultDto.ResultInVehicleType();
                inType.setCollectCount(type.getCollectInCount());
                inType.setStationCount(type.getStationInCount());
                inType.setVehicleType(veType);
                inTypeList.add(inType);
                CollectResultDto.ResultOutVehicleType outType =  new CollectResultDto.ResultOutVehicleType();
                outType.setCollectCount(type.getCollectOutCount());
                outType.setStationCount(type.getStationOutCount());
                outType.setVehicleType(veType);
                outTypeList.add(outType);
            }
            CollectResultDto.ResultInVehicleType qitaInType =  new CollectResultDto.ResultInVehicleType();
            qitaInType.setCollectCount(collectInCount);
            qitaInType.setStationCount(stationInCount);
            qitaInType.setVehicleType("其他");
            inTypeList.add(qitaInType);
            CollectResultDto.ResultOutVehicleType qitaOutType =  new CollectResultDto.ResultOutVehicleType();
            qitaOutType.setCollectCount(collectOutCount);
            qitaOutType.setStationCount(stationOutCount);
            qitaOutType.setVehicleType("其他");
            outTypeList.add(qitaOutType);
        }
        dto.setTaskId(id);
        dto.setInVehicleTypes(inTypeList);
        dto.setOutVehicleTypes(outTypeList);
        return dto;
    }

 
    @Override
    public String getCollectResultExcel(HttpServletResponse response,Long id) {
        CollectResultDto dto = new CollectResultDto();
        VjMobileCollectTaskViewCriteria  viewExample = new VjMobileCollectTaskViewCriteria();
        VjMobileCollectTaskViewCriteria.Criteria cri = viewExample.createCriteria();
        cri.andIdEqualTo(id);
        List<VjMobileCollectTaskView> list = this.vjMobileCollectTaskViewMapper.selectByExample(viewExample);
        if(CollectionUtils.isEmpty(list)){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_ID_PARAMS_ERROR);
        }
        VjMobileCollectTaskView view = list.get(0);
        if(view.getTaskStatus()==CollectTaskStatusEnum.RUNNING.getCode()){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_TASK_UNFINISH);
        }
        
        CollectResultFlowCriteria flowExample = new CollectResultFlowCriteria();
        CollectResultFlowCriteria.Criteria flowCri = flowExample.createCriteria();
        flowCri.andCollectTaskIdEqualTo(id);
        List<CollectResultFlow>  flowList = collectResultFlowMapper.selectByExample(flowExample);
        List<CollectResultDto.ResultInFlow> inFlowList = new ArrayList<CollectResultDto.ResultInFlow>();
        List<CollectResultDto.ResultOutFlow> outFlowList = new ArrayList<CollectResultDto.ResultOutFlow>();
        if(CollectionUtils.isNotEmpty(flowList)){
            for(CollectResultFlow flow: flowList){
                String dateTime = DateHelper.convertDateStrToOtherFormat(String.valueOf(flow.getDataHour()), DateHelper.FORMAT_5, DateHelper.FORMAT_5_2);
                CollectResultDto.ResultInFlow inFlow =  new CollectResultDto.ResultInFlow();
                inFlow.setCollectCount(flow.getCollectInCount());
                inFlow.setStationCount(flow.getStationInCount());
                inFlow.setDataTime(dateTime);
                inFlowList.add(inFlow);
                CollectResultDto.ResultOutFlow outFlow =  new CollectResultDto.ResultOutFlow();
                outFlow.setCollectCount(flow.getCollectOutCount());
                outFlow.setStationCount(flow.getStationOutCount());
                outFlow.setDataTime(dateTime);
                outFlowList.add(outFlow);
            }
        }
        dto.setInFlows(inFlowList);
        dto.setOutFlows(outFlowList);
        
        CollectResultTypeCriteria typeExample = new CollectResultTypeCriteria();
        CollectResultTypeCriteria.Criteria typeCri = typeExample.createCriteria();
        typeCri.andCollectTaskIdEqualTo(id);
        List<CollectResultType>  typeList = collectResultTypeMapper.selectByExample(typeExample);
        List<CollectResultDto.ResultInVehicleType> inTypeList = new ArrayList<CollectResultDto.ResultInVehicleType>();
        List<CollectResultDto.ResultOutVehicleType> outTypeList = new ArrayList<CollectResultDto.ResultOutVehicleType>();
        if(CollectionUtils.isNotEmpty(typeList)){
            int collectInCount = 0;
            int stationInCount = 0;
            int collectOutCount = 0;
            int stationOutCount = 0;
            for(CollectResultType type: typeList){
                String veType = VehicleTypeEnum.getDescByCode(NumberUtils.toShort(type.getVerhicleType()));
                if(veType.equals("其他")){
                    collectInCount +=type.getCollectInCount();
                    stationInCount +=type.getStationInCount();
                    collectOutCount +=type.getCollectOutCount();
                    stationOutCount +=type.getStationOutCount();
                    continue;
                }
                CollectResultDto.ResultInVehicleType inType =  new CollectResultDto.ResultInVehicleType();
                inType.setCollectCount(type.getCollectInCount());
                inType.setStationCount(type.getStationInCount());
                inType.setVehicleType(veType);
                inTypeList.add(inType);
                CollectResultDto.ResultOutVehicleType outType =  new CollectResultDto.ResultOutVehicleType();
                outType.setCollectCount(type.getCollectOutCount());
                outType.setStationCount(type.getStationOutCount());
                outType.setVehicleType(veType);
                outTypeList.add(outType);
            }
            CollectResultDto.ResultInVehicleType qitaInType =  new CollectResultDto.ResultInVehicleType();
            qitaInType.setCollectCount(collectInCount);
            qitaInType.setStationCount(stationInCount);
            qitaInType.setVehicleType("其他");
            inTypeList.add(qitaInType);
            CollectResultDto.ResultOutVehicleType qitaOutType =  new CollectResultDto.ResultOutVehicleType();
            qitaOutType.setCollectCount(collectOutCount);
            qitaOutType.setStationCount(stationOutCount);
            qitaOutType.setVehicleType("其他");
            outTypeList.add(qitaOutType);
        }
        dto.setTaskId(id);
        dto.setInVehicleTypes(inTypeList);
        dto.setOutVehicleTypes(outTypeList);
        MobileCollectTaskDto taskDto = getMoileCollectTaskDto(view);
         String baseName = taskDto.getCollectionRepoName()+"与"+taskDto.getOilStationRepoName()+"比对，时间段"+DateHelper.date2String(taskDto.getCollectStartTime(),DateHelper.FORMAT_0)+"-"+
                DateHelper.date2String(taskDto.getCollectEndTime(),DateHelper.FORMAT_0);
        String fileName = "移动数据采集分析统计:"+baseName+".xls";
        try {
            new ExcelExportHelper().exportExcel(fileName,response,dto,taskDto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_EXPORT_FAIL);
        }
        return fileName;
    }
    
    private MobileCollectTaskDto getMoileCollectTaskDto(final VjMobileCollectTaskView view){
        List<Long> pids = Lists.newArrayList();
        if (ArrayUtils.isNotEmpty(view.getCollectRpath())) {
            pids.addAll(Collections.arrayToList(view.getCollectRpath()));
        }
        if (ArrayUtils.isNotEmpty(view.getStationRpath())) {
            pids.addAll(Collections.arrayToList(view.getStationRpath()));
        }
        Set<Long> repoid = Sets.newHashSet();
        if (CollectionUtils.isNotEmpty(pids)) {
            for (Long id : pids) {
                repoid.add(id);
            }
        }
        ReposCriteria parentEx = new ReposCriteria();
        ReposCriteria.Criteria reposCri = parentEx.createCriteria();
        reposCri.andIdIn(new ArrayList<Long>(repoid));
        List<Repos> parentList = reposMapper.selectByExample(parentEx);
        Map<Long, RepoIdDto> pMap = new HashMap<Long, RepoIdDto>();
        if (CollectionUtils.isNotEmpty(parentList)) {
            for (Repos p : parentList) {
                pMap.put(p.getId(), new RepoIdDto(p.getId(),p.getRepoId(), p.getRepoName(),p.getRepoLevel()));
            }
        }
        return getDto(pMap, view);
    }
}