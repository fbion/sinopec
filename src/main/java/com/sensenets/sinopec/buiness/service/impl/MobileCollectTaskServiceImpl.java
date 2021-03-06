package com.sensenets.sinopec.buiness.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sensenets.sinopec.buiness.condition.MobileCollectTaskCondition;
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
import com.sensenets.sinopec.buiness.export.CollectResultExcelExport;
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
import com.sensenets.sinopec.buiness.service.IMobileCollectTaskService;
import com.sensenets.sinopec.common.enums.BizExceptionEnum;
import com.sensenets.sinopec.common.enums.CollectTaskStatusEnum;
import com.sensenets.sinopec.common.enums.CollectTaskTypeEnum;
import com.sensenets.sinopec.common.enums.DeleteStatusEnum;
import com.sensenets.sinopec.common.enums.SensorGroupEnum;
import com.sensenets.sinopec.common.enums.VehicleTypeEnum;
import com.sensenets.sinopec.common.exception.BusinessException;
import com.sensenets.sinopec.common.utils.DateHelper;
import com.sensenets.sinopec.common.utils.JsonHelper;
import com.sensenets.sinopec.common.utils.UUIDHelper;
import com.sensenets.sinopec.config.AppConfig;

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
    
    @Autowired
    private AppConfig appConfig;
    
    @Resource
    private CacheManager cacheManager;
    
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

    
    /**
     * @Title: getRepoChildren
     * @Description: 递归获取子节点
     * @param children
     * @param parentRepoId
     */
   private void  getRepoChildren(List<Repos> children,String parentRepoId){
       ReposCriteria  example = new ReposCriteria();
       ReposCriteria.Criteria  cri = example.createCriteria();
       cri.andParentIdEqualTo(parentRepoId);
       List<Repos> reposList =  reposMapper.selectByExample(example);
       if(CollectionUtils.isNotEmpty(reposList)){
           children.addAll(reposList);
           for(Repos repos:reposList){
               getRepoChildren(children,repos.getRepoId());
           }
       }
   }
    
    public PageInfo<MobileCollectTaskDto> selectPageByExample(MobileCollectTaskCondition condition) {
     // 判断条件并转化为Criteria对象
        VjMobileCollectTaskViewCriteria example = new VjMobileCollectTaskViewCriteria();
        example.setOrderByClause("uts desc");
        example.setDistinct(true);
        example.setPageNumber(condition.getPageNumber());
        example.setPageSize(condition.getPageSize());
        VjMobileCollectTaskViewCriteria.Criteria cri = example.createCriteria();
        
        if(StringUtils.isNotBlank(condition.getCollectStartTime())){
            Date startTime = DateHelper.string2Date(condition.getCollectStartTime(), DateHelper.FORMAT_0);
            cri.andCollectStartTimeGreaterThanOrEqualTo(startTime);
        }
        if(StringUtils.isNotBlank(condition.getCollectEndTime())){
            Date endTime = DateHelper.string2Date(condition.getCollectEndTime(), DateHelper.FORMAT_0);
            cri.andCollectEndTimeLessThanOrEqualTo(endTime);
        }
        if(StringUtils.isNotBlank(condition.getCollectRepoId())){
            List<Repos> reposList = Lists.newArrayList();
            getRepoChildren(reposList,condition.getCollectRepoId());
            if(CollectionUtils.isNotEmpty(reposList)){
                List<String> reposIds = Lists.newArrayList();
                for(Repos repo:reposList){
                    reposIds.add(repo.getRepoId());
                }
                cri.andCollectRepoIdIn(reposIds);
            }else{
                cri.andCollectRepoIdEqualTo(condition.getCollectRepoId()); 
            }
        }
        if(StringUtils.isNotBlank(condition.getOilStationRepoId())){
            List<Repos> reposList = Lists.newArrayList();
            getRepoChildren(reposList,condition.getOilStationRepoId());
            if(CollectionUtils.isNotEmpty(reposList)){
                List<String> reposIds = Lists.newArrayList();
                for(Repos repos:reposList){
                    reposIds.add(repos.getRepoId());
                }
                cri.andOilStationRepoIdIn(reposIds);
            }else{
                cri.andOilStationRepoIdEqualTo(condition.getOilStationRepoId()); 
            }
        }
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
            String[] oilStationParents = new String[view.getStationRpath().length];
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
            if(ArrayUtils.isEmpty(view.getCollectRpath())||ArrayUtils.isEmpty(view.getStationRpath())){
                throw  new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_REPOS_NOT_EXIST);
            }
            dto.setCollectId(view.getCollectRpath()[view.getCollectRpath().length-1]);
            dto.setOilStationId(view.getStationRpath()[view.getStationRpath().length-1]);
            
            // 油站关联的设备查询
            SensorsCriteria  example = new  SensorsCriteria();
            SensorsCriteria.Criteria  sencri =  example.createCriteria();
            List<String> repoList = Lists.newArrayList();
            repoList.add(dto.getCollectRepoId());
            repoList.add(dto.getOilStationRepoId());
            sencri.andRepoIdIn(repoList);
            sencri.andStatusNotEqualTo(DeleteStatusEnum.DELETE.getCode());
            List<Short> groupType = Lists.newArrayList();
            // 进站或者全部
            if(view.getType()==CollectTaskTypeEnum.InStation.getCode()|| view.getType()==CollectTaskTypeEnum.ALL.getCode()){
                groupType.add(SensorGroupEnum.sensor_collect_come.getCode());
                groupType.add(SensorGroupEnum.sensor_come.getCode());
            }
            // 站外或者全部
            if(view.getType()==CollectTaskTypeEnum.OutStation.getCode()|| view.getType()==CollectTaskTypeEnum.ALL.getCode()){
                groupType.add(SensorGroupEnum.sensor_collect_out.getCode());
                groupType.add(SensorGroupEnum.sensor_out.getCode());
            }
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
       
           if(view.getType()==CollectTaskTypeEnum.InStation.getCode()||view.getType()==CollectTaskTypeEnum.ALL.getCode()){
               if(CollectionUtils.isEmpty(sensorInIds)){
                   throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_IN_STATION_SENSOR_NOT_EXIST.getCode()
                           ,view.getRbRepoName()+BizExceptionEnum.MOBILE_COLLECT_ERROR_IN_STATION_SENSOR_NOT_EXIST.getMessage()
                           );
               }
               if(CollectionUtils.isEmpty(sensorCollectInIds)){
                   throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_IN_STATION_COLLECT_SENSOR_NOT_EXIST.getCode()
                           ,view.getRaRepoName()+BizExceptionEnum.MOBILE_COLLECT_ERROR_IN_STATION_COLLECT_SENSOR_NOT_EXIST.getMessage()
                           );
               }
           }
           if(view.getType()==CollectTaskTypeEnum.OutStation.getCode()||view.getType()==CollectTaskTypeEnum.ALL.getCode()){
               if(CollectionUtils.isEmpty(sensorOutIds)){
                   throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_OUT_STATION_SENSOR_NOT_EXIST.getCode()
                           ,view.getRbRepoName()+BizExceptionEnum.MOBILE_COLLECT_ERROR_OUT_STATION_SENSOR_NOT_EXIST.getMessage()
                           );
               }
               if(CollectionUtils.isEmpty(sensorCollectOutIds)){
                   throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_OUT_STATION_COLLECT_SENSOR_NOT_EXIST.getCode()
                           ,view.getRaRepoName()+BizExceptionEnum.MOBILE_COLLECT_ERROR_OUT_STATION_COLLECT_SENSOR_NOT_EXIST.getMessage()
                           );
               }
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
        dto.setTaskType(task.getType());
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
                inFlow.setIndex(flow.getDataHour());
                inFlowList.add(inFlow);
                CollectResultDto.ResultOutFlow outFlow =  new CollectResultDto.ResultOutFlow();
                outFlow.setCollectCount(flow.getCollectOutCount());
                outFlow.setStationCount(flow.getStationOutCount());
                outFlow.setDataTime(dateTime);
                outFlow.setIndex(flow.getDataHour());
                outFlowList.add(outFlow);
            }
        }
        java.util.Collections.sort(inFlowList);
        java.util.Collections.sort(outFlowList);
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
                inType.setIndex(Integer.parseInt(type.getVerhicleType()));
                inTypeList.add(inType);
                CollectResultDto.ResultOutVehicleType outType =  new CollectResultDto.ResultOutVehicleType();
                outType.setCollectCount(type.getCollectOutCount());
                outType.setStationCount(type.getStationOutCount());
                outType.setVehicleType(veType);
                outType.setIndex(Integer.parseInt(type.getVerhicleType()));
                outTypeList.add(outType);
            }
            CollectResultDto.ResultInVehicleType qitaInType =  new CollectResultDto.ResultInVehicleType();
            qitaInType.setCollectCount(collectInCount);
            qitaInType.setStationCount(stationInCount);
            qitaInType.setVehicleType("其他");
            qitaInType.setIndex(VehicleTypeEnum.qita3.getCode());
            inTypeList.add(qitaInType);
            CollectResultDto.ResultOutVehicleType qitaOutType =  new CollectResultDto.ResultOutVehicleType();
            qitaOutType.setCollectCount(collectOutCount);
            qitaOutType.setStationCount(stationOutCount);
            qitaOutType.setVehicleType("其他");
            qitaOutType.setIndex(VehicleTypeEnum.qita3.getCode());
            outTypeList.add(qitaOutType);
        }
        dto.setTaskId(id);
        java.util.Collections.sort(inTypeList);
        java.util.Collections.sort(outTypeList);
        dto.setInVehicleTypes(inTypeList);
        dto.setOutVehicleTypes(outTypeList);
        return dto;
    }

    private String getExportKey(Long id,String filePath){
        String responseInfo = UUIDHelper.genUUID(false);
        try {
            Cache cache = cacheManager.getCache("collectResultExcelCache");
            cache.put(responseInfo,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseInfo;
    }
 
    @Override
    public String getCollectResultExcel(Long id) {
        // 查询缓存
        Cache cache = cacheManager.getCache("collectResultExcelCache");
        String filePathCache = cache.get(String.valueOf(id), String.class);
        String fileNameCache = cache.get(String.valueOf("filename_"+id), String.class);
        if(StringUtils.isNotBlank(filePathCache)&&StringUtils.isNotBlank(fileNameCache)){
            File file = new File(filePathCache);
            if(file.exists()){
                return getExportKey(id,filePathCache);
            }
        }
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
                inFlow.setIndex(flow.getDataHour());
                inFlowList.add(inFlow);
                CollectResultDto.ResultOutFlow outFlow =  new CollectResultDto.ResultOutFlow();
                outFlow.setCollectCount(flow.getCollectOutCount());
                outFlow.setStationCount(flow.getStationOutCount());
                outFlow.setDataTime(dateTime);
                outFlow.setIndex(flow.getDataHour());
                outFlowList.add(outFlow);
            }
        }
        java.util.Collections.sort(inFlowList);
        java.util.Collections.sort(outFlowList);
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
                inType.setIndex(Integer.parseInt(type.getVerhicleType()));
                inTypeList.add(inType);
                CollectResultDto.ResultOutVehicleType outType =  new CollectResultDto.ResultOutVehicleType();
                outType.setCollectCount(type.getCollectOutCount());
                outType.setStationCount(type.getStationOutCount());
                outType.setVehicleType(veType);
                outType.setIndex(Integer.parseInt(type.getVerhicleType()));
                outTypeList.add(outType);
            }
            CollectResultDto.ResultInVehicleType qitaInType =  new CollectResultDto.ResultInVehicleType();
            qitaInType.setCollectCount(collectInCount);
            qitaInType.setStationCount(stationInCount);
            qitaInType.setVehicleType("其他");
            qitaInType.setIndex(VehicleTypeEnum.qita3.getCode());
            inTypeList.add(qitaInType);
            CollectResultDto.ResultOutVehicleType qitaOutType =  new CollectResultDto.ResultOutVehicleType();
            qitaOutType.setCollectCount(collectOutCount);
            qitaOutType.setStationCount(stationOutCount);
            qitaOutType.setVehicleType("其他");
            qitaOutType.setIndex(VehicleTypeEnum.qita3.getCode());
            outTypeList.add(qitaOutType);
        }
        dto.setTaskId(id);
        java.util.Collections.sort(inTypeList);
        java.util.Collections.sort(outTypeList);
        dto.setInVehicleTypes(inTypeList);
        dto.setOutVehicleTypes(outTypeList);
        MobileCollectTaskDto taskDto = getMoileCollectTaskDto(view);
         String baseName = taskDto.getCollectionRepoName()+"与"+taskDto.getOilStationRepoName()+"比对，时间段"+DateHelper.date2String(taskDto.getCollectStartTime(),DateHelper.FORMAT_0)+"-"+
                DateHelper.date2String(taskDto.getCollectEndTime(),DateHelper.FORMAT_0);
        String fileName = "移动数据采集分析统计:"+baseName+".xls";
        String fileIndex = UUIDHelper.genUUID(false);
        String exportPath = appConfig.getExportDir();
        String filePath = String.format("%s%s.xls",exportPath.endsWith("/")?exportPath:exportPath+"/",fileIndex);
        try {
            new CollectResultExcelExport().exportExcel(fileName,filePath,dto,taskDto);
            cache.put(String.valueOf(id),filePath);
            cache.put(String.valueOf("filename_"+id),fileName);
        } catch (Exception e) {
            cache.evict(String.valueOf(id));
            cache.evict(String.valueOf("filename_"+id));
            cache.put(String.valueOf(id),filePath);
            e.printStackTrace();
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_EXPORT_FAIL);
        }
        return getExportKey(id,filePath);
    }
    
    
    @Override
    public String downloadCollectResultExcel(HttpServletRequest request,HttpServletResponse response,String key) {
        if(StringUtils.isBlank(key)){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_DOWNLOAD_PARAM);
        }
        // 查询缓存
        Cache cache = cacheManager.getCache("collectResultExcelCache");
        Long id = cache.get(key,Long.class);
        if(id==null||id==0){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_DOWNLOAD_PARAM);
        }
        String filePathCache = cache.get(String.valueOf(id), String.class);
        String fileNameCache = cache.get(String.valueOf("filename_"+id), String.class);
        if(StringUtils.isNotBlank(filePathCache)&&StringUtils.isNotBlank(fileNameCache)){
            OutputStream out  = null;
            try {
                File file = new File(filePathCache);
                byte[] fileData = FileUtils.readFileToByteArray(file);
                out  = response.getOutputStream();
                
                String userAgent = request.getHeader("User-Agent"); 
                String formFileName = "";
                // 针对IE或者以IE为内核的浏览器
                if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                    response.setContentType("application/octet-stream;charset=UTF-8");
                    formFileName = java.net.URLEncoder.encode(fileNameCache, "UTF-8");  
                } else {
                    response.setContentType("application/octet-stream;charset=ISO8859-1");
                    // 非IE浏览器的处理  
                    formFileName = new String(fileNameCache.getBytes("UTF-8"), "ISO-8859-1");  
                }  
                response.setHeader("Content-Disposition", "attachment;filename="+ formFileName);
                response.addHeader("Pargam", "no-cache");
                response.addHeader("Cache-Control", "no-cache");
                response.setCharacterEncoding("UTF-8");
                out.write(fileData);
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                try {
                    if(out!=null)
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return String.valueOf(id);
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