package com.sensenets.sinopec.buiness.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sensenets.sinopec.buiness.condition.VehicleQueueAnalysisCondition;
import com.sensenets.sinopec.buiness.dao.one.MotorBrandAllAttrMapper;
import com.sensenets.sinopec.buiness.dao.one.ReposMapper;
import com.sensenets.sinopec.buiness.dao.two.VehicleQueueAnalysisMapper;
import com.sensenets.sinopec.buiness.dao.two.VehicleQueueMapper;
import com.sensenets.sinopec.buiness.dto.VehicleQueueAnalysisExportDto;
import com.sensenets.sinopec.buiness.dto.VehicleQueueResultDto;
import com.sensenets.sinopec.buiness.export.VehicleQueueAnalysisExcelExport;
import com.sensenets.sinopec.buiness.export.ZipCompressor;
import com.sensenets.sinopec.buiness.model.one.Repos;
import com.sensenets.sinopec.buiness.model.one.ReposCriteria;
import com.sensenets.sinopec.buiness.model.two.VehicleQueue;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueAnalysis;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueAnalysisCount;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueAnalysisCriteria;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueCriteria;
import com.sensenets.sinopec.buiness.service.IVehicleQueueAnalysisService;
import com.sensenets.sinopec.common.enums.BizExceptionEnum;
import com.sensenets.sinopec.common.enums.OilTypeEnum;
import com.sensenets.sinopec.common.enums.VehicleColorTypeEnum;
import com.sensenets.sinopec.common.enums.VehiclePlateColorTypeEnum;
import com.sensenets.sinopec.common.enums.VehiclePlateTypeEnum;
import com.sensenets.sinopec.common.enums.VehicleTypeEnum;
import com.sensenets.sinopec.common.exception.BusinessException;
import com.sensenets.sinopec.common.utils.DateHelper;
import com.sensenets.sinopec.common.utils.MD5Helper;
import com.sensenets.sinopec.common.utils.UUIDHelper;
import com.sensenets.sinopec.config.AppConfig;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VehicleQueueAnalysisServiceImpl implements IVehicleQueueAnalysisService {
    @Autowired
    private VehicleQueueAnalysisMapper vehicleQueueAnalysisMapper;
    
    @Autowired
    private VehicleQueueMapper vehicleQueueMapper;
    
    @Autowired
    private ReposMapper  reposMapper;
    
    @Autowired
    private MotorBrandAllAttrMapper  brandMapper;

    @Resource
    private CacheManager cacheManager;
    
    @Autowired
    private AppConfig appConfig;

    public int countByExample(VehicleQueueAnalysisCriteria example) {
        int count = this.vehicleQueueAnalysisMapper.countByExample(example);
        log.debug("count: {}", count);
        return count;
    }

    public VehicleQueueAnalysis selectByPrimaryKey(Long id) {
        return this.vehicleQueueAnalysisMapper.selectByPrimaryKey(id);
    }

    public List<VehicleQueueAnalysis> selectByExample(VehicleQueueAnalysisCriteria example) {
        return this.vehicleQueueAnalysisMapper.selectByExample(example);
    }

    public PageInfo<VehicleQueueAnalysis> selectPageByExample(VehicleQueueAnalysisCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<VehicleQueueAnalysis> list = this.vehicleQueueAnalysisMapper.selectByExample(example);
        PageInfo<VehicleQueueAnalysis> pageInfo = new PageInfo<VehicleQueueAnalysis>(list);
        return pageInfo;
    }

    public int deleteByPrimaryKey(Long id) {
        return this.vehicleQueueAnalysisMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(VehicleQueueAnalysis record) {
        return this.vehicleQueueAnalysisMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VehicleQueueAnalysis record) {
        return this.vehicleQueueAnalysisMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(VehicleQueueAnalysisCriteria example) {
        return this.vehicleQueueAnalysisMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(VehicleQueueAnalysis record, VehicleQueueAnalysisCriteria example) {
        return this.vehicleQueueAnalysisMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(VehicleQueueAnalysis record, VehicleQueueAnalysisCriteria example) {
        return this.vehicleQueueAnalysisMapper.updateByExample(record, example);
    }

    public int insert(VehicleQueueAnalysis record) {
       return this.vehicleQueueAnalysisMapper.insert(record);
    }

    public long insertSelective(VehicleQueueAnalysis record) {
        int i = this.vehicleQueueAnalysisMapper.insertSelective(record);
        if(i>0){
            return record.getId();
        }else{
            throw new BusinessException(BizExceptionEnum.VEHICLE_QUEUE_ANALYSIS_INSERT_ERROR);
        }
    }

    @Override
    public VehicleQueueResultDto selectAnalysisCount(VehicleQueueAnalysisCondition condition) {
        VehicleQueueAnalysisCriteria  dExample = new VehicleQueueAnalysisCriteria(); 
        VehicleQueueAnalysisCriteria.Criteria  dCri = dExample.createCriteria();
        VehicleQueueAnalysisCriteria  gExample = new VehicleQueueAnalysisCriteria(); 
        VehicleQueueAnalysisCriteria.Criteria  gCri = dExample.createCriteria();
        if(StringUtils.isNotBlank(condition.getInStartTime())){
            String date  = DateHelper.convertCommDateStrToOtherFormatByJodaTime(condition.getInStartTime(), DateHelper.FORMAT_1, DateHelper.FORMAT_6);
            dCri.andDataDayGreaterThanOrEqualTo(Integer.parseInt(date));
            gCri.andDataDayGreaterThanOrEqualTo(Integer.parseInt(date));
        }
        if(StringUtils.isNotBlank(condition.getInEndTime())){
            String date = DateHelper.convertCommDateStrToOtherFormatByJodaTime(condition.getInEndTime(), DateHelper.FORMAT_1, DateHelper.FORMAT_6);
            dCri.andDataDayLessThanOrEqualTo(Integer.parseInt(date));
            gCri.andDataDayLessThanOrEqualTo(Integer.parseInt(date));
        }
        if(StringUtils.isNotBlank(condition.getRepoId())){
            dCri.andReposIdEqualTo(condition.getRepoId());
            gCri.andReposIdEqualTo(condition.getRepoId());
        }
        if(condition.getVehicleType()!=null){
            dCri.andVehicleTypeEqualTo(condition.getVehicleType());
            gCri.andVehicleTypeEqualTo(condition.getVehicleType());
        }
        dCri.andOilTypeEqualTo(String.valueOf(OilTypeEnum.oil_0_v.getType()));
        gCri.andOilTypeEqualTo(String.valueOf(OilTypeEnum.oil_92.getType()));
        
        VehicleQueueResultDto dto = new VehicleQueueResultDto();
        VehicleQueueAnalysisCount dCount = vehicleQueueAnalysisMapper.selectAnalysisCount(dExample);
        if(dCount!=null){
            VehicleQueueResultDto.VehicleDieselOil dOil = new VehicleQueueResultDto.VehicleDieselOil();
            BeanUtils.copyProperties(dCount, dOil);
            dto.setDieselOilResult(dOil);
        }else{
            dto.setDieselOilResult(new VehicleQueueResultDto.VehicleDieselOil(0,0,0,0,0));
        }
        
        VehicleQueueAnalysisCount gCount = vehicleQueueAnalysisMapper.selectAnalysisCount(gExample);
        if(gCount!=null){
            VehicleQueueResultDto.VehicleGasOil gOil = new VehicleQueueResultDto.VehicleGasOil();
            BeanUtils.copyProperties(gCount, gOil);
            dto.setGasOilResult(gOil);
        }else{
            dto.setGasOilResult(new VehicleQueueResultDto.VehicleGasOil(0,0,0,0,0));
        }
        return dto;
    }
    
    private String getExportKey(String id,String filePath){
        String responseInfo = UUIDHelper.genUUID(false);
        try {
            Cache cache = cacheManager.getCache("vehicleQueueAnalysisExcelCache");
            cache.put(responseInfo,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseInfo;
    }
    
    private Map<String,String> getRepos(final List<VehicleQueue> list){
        Map<String,String> pMap = Maps.newHashMap();
        Set<Long> repoIds = Sets.newHashSet();
        
        if (CollectionUtils.isNotEmpty(list)) {
            for (VehicleQueue view : list) {
                repoIds.add(view.getReposId());
            }
        }
        
        ReposCriteria parentEx = new ReposCriteria();
        ReposCriteria.Criteria reposCri = parentEx.createCriteria();
        reposCri.andIdIn(new ArrayList<Long>(repoIds));
        List<Repos> parentList = reposMapper.selectByExample(parentEx);
        if (CollectionUtils.isNotEmpty(parentList)) {
            for (Repos p : parentList) {
                pMap.put("repos_"+p.getId(), p.getRepoName());
            }
        }
        return pMap;
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

    private VehicleQueueCriteria generateVehicleQueueCri(VehicleQueueAnalysisCondition condition){
        VehicleQueueCriteria example = new VehicleQueueCriteria();
        example.setDistinct(true);
        example.setPageNumber(condition.getPageNumber());
        example.setPageSize(condition.getPageSize());
        VehicleQueueCriteria.Criteria cri = example.createCriteria();
        // 进站时间
        if(StringUtils.isNotBlank(condition.getInStartTime())){
            Date startTime = DateHelper.string2Date(condition.getInStartTime(), DateHelper.FORMAT_1);
            cri.andInTimeGreaterThanOrEqualTo(startTime);
        }
        if(StringUtils.isNotBlank(condition.getInEndTime())){
            Date endTime = DateHelper.string2Date(condition.getInEndTime(), DateHelper.FORMAT_1);
            cri.andInTimeLessThanOrEqualTo(endTime);
        }
        // 车辆类型id
        if(condition.getVehicleType()!=null){
            cri.andInTypeIdEqualTo(condition.getVehicleType());
        }
        // 油站选择 查询当前油站的所有子节点
        Map<String,String> map = Maps.newHashMap();
        Repos reps = null;
        if(StringUtils.isNotBlank(condition.getRepoId())){
            reps = reposMapper.selectByPrimaryKey(condition.getRepoId());
            if(reps==null){
                throw new BusinessException(BizExceptionEnum.VEHICLE_QUEUE_REPOS_ID_PARAM_ERROR);
            }
            List<Repos> reposList  = new ArrayList<Repos>();
            getRepoChildren(reposList,condition.getRepoId());
            List<Long> repodIdList = new ArrayList<Long>();
            if(CollectionUtils.isNotEmpty(reposList)){
                reposList.forEach(repos->{
                    repodIdList.add(repos.getId());
                    map.put(repos.getRepoId(), repos.getRepoName());
                });
                repodIdList.add(reps.getId());
                cri.andReposIdIn(repodIdList);
            }
        }
        return example;
    }
    
    
    @Override
    public String downloadVehicleQueueAnalysisExcel(HttpServletResponse response,String key) {
        if(StringUtils.isBlank(key)){
            throw new BusinessException(BizExceptionEnum.VEHICLE_QUEUE_ANALYSIS_ERROR_DOWNLOAD_PARAM);
        }
        // 查询缓存
        Cache cache = cacheManager.getCache("vehicleQueueAnalysisExcelCache");
        String id = cache.get(key,String.class);
        if(StringUtils.isBlank(id)){
            throw new BusinessException(BizExceptionEnum.VEHICLE_QUEUE_ANALYSIS_ERROR_DOWNLOAD_PARAM);
        }
        String filePathCache = cache.get(String.valueOf(id), String.class);
        String fileNameCache = cache.get(String.valueOf("filename_"+id), String.class);
        if(StringUtils.isNotBlank(filePathCache)&&StringUtils.isNotBlank(fileNameCache)){
            OutputStream out  = null;
            try {
                File file = new File(filePathCache);
                byte[] fileData = FileUtils.readFileToByteArray(file);
                out  = response.getOutputStream();
                response.setContentType("application/octet-stream;charset=ISO8859-1");
                response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileNameCache.getBytes(),"ISO8859-1"));
                response.addHeader("Pargam", "no-cache");
                response.addHeader("Cache-Control", "no-cache");
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
    
    
    @Override
    public String getExportResultExcel(VehicleQueueAnalysisCondition condition) {
        // 查询缓存
        Cache cache = cacheManager.getCache("vehicleQueueAnalysisExcelCache");
        String id = MD5Helper.toMD5(condition.toString());
        String filePathCache = cache.get(id, String.class);
        String fileNameCache = cache.get("filename_"+id, String.class);
        if(StringUtils.isNotBlank(filePathCache)&&StringUtils.isNotBlank(fileNameCache)){
            File file = new File(filePathCache);
            if(file.exists()){
                return getExportKey(id,filePathCache);
            }
        }
        VehicleQueueCriteria queueExa = generateVehicleQueueCri(condition);
        List<VehicleQueue> list = this.vehicleQueueMapper.selectByExample(queueExa);
        if(CollectionUtils.isEmpty(list)){
            throw new BusinessException(BizExceptionEnum.VEHICLE_QUEUE_EXPORT_RESULT_IS_NULL);
        }else{
            if(list.size()>appConfig.getVehicleQueueExportTotalNum()){
                throw new BusinessException(BizExceptionEnum.VEHICLE_QUEUE_ERROR_EXPORT_GREATER_LIMIT_NUM.getCode()
                        ,BizExceptionEnum.VEHICLE_QUEUE_ERROR_EXPORT_GREATER_LIMIT_NUM.getMessage()+appConfig.getVehicleQueueExportTotalNum()+"条！"
                        );
            }
        }
        List<VehicleQueueAnalysisExportDto> exportList = Lists.newArrayList();
        Map<String,String> pMap = getRepos(list);
        for(VehicleQueue  queue:list){
            exportList.add(convert2ExportDto(pMap,queue));
        }
        String baseName = DateHelper.date2String(new Date(), DateHelper.FORMAT_0);
        String downFileName = "车辆排队分析数据统计:"+baseName+".xls";
        String fileIndex = UUIDHelper.genUUID(false);
        String excelFileName = fileIndex+".xls" ;
        String fileBasePath = appConfig.getExportDir().endsWith("/")?appConfig.getExportDir():appConfig.getExportDir()+"/";
        String filePath = fileBasePath + excelFileName;
        try {
            new VehicleQueueAnalysisExcelExport().exportExcel(excelFileName,fileBasePath,exportList,appConfig.getVehicleQueueExportNum());
            cache.put(id,filePath);
            cache.put("filename_"+id,downFileName);
        } catch (Exception e) {
            cache.evict(id);
            cache.evict("filename_"+id);
            cache.put(id,filePath);
            e.printStackTrace();
            throw new BusinessException(BizExceptionEnum.VEHICLE_QUEUE_ANALYSIS_ERROR_EXPORT_FAIL);
        }
        return getExportKey(id,filePath);
    }
    
    private VehicleQueueAnalysisExportDto convert2ExportDto(final Map<String,String> map ,final VehicleQueue view){
        VehicleQueueAnalysisExportDto dto = new VehicleQueueAnalysisExportDto();
        String reposKey = String.format("repos_%s", view.getReposId());
        dto.setInTime(DateHelper.date2String(view.getInTime(), DateHelper.FORMAT_0));
        dto.setOutTime(DateHelper.date2String(view.getOutTime(), DateHelper.FORMAT_0));
        dto.setOilStationRepoName(map.get(reposKey));
        if(OilTypeEnum.getTypeByCode(view.getOilType())==OilTypeEnum.oil_0_v.getType()){
            dto.setOilType("柴油");
        }
        if(OilTypeEnum.getTypeByCode(view.getOilType())==OilTypeEnum.oil_92.getType()){
            dto.setOilType("汽油");
        }
        dto.setPlateNumber(view.getInPlateText());
        dto.setQueueTime((long)Math.round(view.getQueueTime()/60000));
        dto.setPlateColor(VehiclePlateColorTypeEnum.getDescByCode(view.getInPlateColorId()));
        dto.setPlateType(VehiclePlateTypeEnum.getDescByCode(view.getInPlateTypeId()));
        dto.setVehicleColorName(VehicleColorTypeEnum.getDescByCode(view.getInColorId()));
        dto.setVehicleTypeName(VehicleTypeEnum.getDescByCode(view.getInTypeId()));
        return  dto;
    }
    
}





