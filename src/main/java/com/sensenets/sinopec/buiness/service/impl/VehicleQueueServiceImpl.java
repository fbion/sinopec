package com.sensenets.sinopec.buiness.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.math.NumberUtils;
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
import com.sensenets.sinopec.buiness.condition.VehicleQueueCondition;
import com.sensenets.sinopec.buiness.condition.VehicleQueueExportCondition;
import com.sensenets.sinopec.buiness.dao.one.MotorBrandAllAttrMapper;
import com.sensenets.sinopec.buiness.dao.one.ReposMapper;
import com.sensenets.sinopec.buiness.dao.two.VehicleQueueMapper;
import com.sensenets.sinopec.buiness.dto.BrandObj;
import com.sensenets.sinopec.buiness.dto.VehicleQueueDto;
import com.sensenets.sinopec.buiness.dto.VehicleQueueDto.VehicleRecord;
import com.sensenets.sinopec.buiness.dto.VehicleQueueExportDto;
import com.sensenets.sinopec.buiness.export.VehicleQueueResultExcelExport;
import com.sensenets.sinopec.buiness.export.ZipCompressor;
import com.sensenets.sinopec.buiness.model.one.MotorBrandAllAttr;
import com.sensenets.sinopec.buiness.model.one.MotorBrandAllAttrCriteria;
import com.sensenets.sinopec.buiness.model.one.Repos;
import com.sensenets.sinopec.buiness.model.one.ReposCriteria;
import com.sensenets.sinopec.buiness.model.two.VehicleQueue;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueCriteria;
import com.sensenets.sinopec.buiness.service.IVehicleQueueService;
import com.sensenets.sinopec.common.enums.BizExceptionEnum;
import com.sensenets.sinopec.common.enums.FuelTypeEnum;
import com.sensenets.sinopec.common.enums.OilTypeEnum;
import com.sensenets.sinopec.common.enums.VehicleAngleTypeEnum;
import com.sensenets.sinopec.common.enums.VehicleColorTypeEnum;
import com.sensenets.sinopec.common.enums.VehiclePlateColorTypeEnum;
import com.sensenets.sinopec.common.enums.VehiclePlateTypeEnum;
import com.sensenets.sinopec.common.enums.VehicleTypeEnum;
import com.sensenets.sinopec.common.exception.BusinessException;
import com.sensenets.sinopec.common.utils.DateHelper;
import com.sensenets.sinopec.common.utils.MD5Helper;
import com.sensenets.sinopec.common.utils.UUIDHelper;
import com.sensenets.sinopec.config.AppConfig;
import com.sensenets.sinopec.kafka.common.ConvertHelper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VehicleQueueServiceImpl implements IVehicleQueueService {
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

    public int countByExample(VehicleQueueCriteria example) {
        int count = this.vehicleQueueMapper.countByExample(example);
        log.debug("count: {}", count);
        return count;
    }

    public VehicleQueue selectByPrimaryKey(Long id) {
        return this.vehicleQueueMapper.selectByPrimaryKey(id);
    }

    public List<VehicleQueue> selectByExample(VehicleQueueCriteria example) {
        return this.vehicleQueueMapper.selectByExample(example);
    }

    public PageInfo<VehicleQueueDto> selectPageByExample(VehicleQueueCondition condition) {
        PageHelper.startPage(condition.getPageNumber(), condition.getPageSize());
        VehicleQueueCriteria example = new VehicleQueueCriteria();
        example.setOrderByClause("in_time desc");
        example.setDistinct(true);
        example.setPageNumber(condition.getPageNumber());
        example.setPageSize(condition.getPageSize());
        VehicleQueueCriteria.Criteria cri = example.createCriteria();
        // 进站时间
        if(StringUtils.isNotBlank(condition.getInStartTime())){
            Date startTime = DateHelper.string2Date(condition.getInStartTime(), DateHelper.FORMAT_0);
            cri.andInTimeGreaterThanOrEqualTo(startTime);
        }
        cri.andQueueTimeGreaterThan(0L);
        if(StringUtils.isNotBlank(condition.getInEndTime())){
            Date endTime = DateHelper.string2Date(condition.getInEndTime(), DateHelper.FORMAT_0);
            cri.andInTimeLessThanOrEqualTo(endTime);
        }
        // 排队开始时间
        if(condition.getStartQueueTime()!=null&&condition.getStartQueueTime()>0){
            cri.andQueueTimeGreaterThanOrEqualTo(condition.getStartQueueTime()*1000L);
        }
        // 排队结束时间
        if(condition.getEndQueueTime()!=null&&condition.getEndQueueTime()>0){
            cri.andQueueTimeLessThanOrEqualTo(condition.getEndQueueTime()*1000L);
        }
        // 加油类型 
        if(StringUtils.isNotBlank(condition.getOilType())){
            cri.andOilTypeEqualTo(condition.getOilType());
        }
        // 车辆品牌 brands
        if(ArrayUtils.isNotEmpty(condition.getBrands())){
            List<Short> brandList = new ArrayList<Short>();
            List<Short> subBrandList = new ArrayList<Short>();
            List<Short> modelYearList = new ArrayList<Short>();
            for(BrandObj obj:condition.getBrands()){
                if(obj.getBrandId()!=null){
                    brandList.add(obj.getBrandId());
                }
                if(obj.getSubBrandId()!=null){
                    subBrandList.add(obj.getSubBrandId());
                }
                if(obj.getModelYearId()!=null){
                    modelYearList.add(obj.getModelYearId());
                }
            }
            if(CollectionUtils.isNotEmpty(brandList)){
                cri.andInBrandIdIn(brandList);
            }
            if(CollectionUtils.isNotEmpty(subBrandList)){
                cri.andInSubBrandIdIn(subBrandList);
            }
            if(CollectionUtils.isNotEmpty(modelYearList)){
                cri.andInModeYearIdIn(modelYearList);
            }
        }
        // 车辆类型id
        if(ArrayUtils.isNotEmpty(condition.getVehicleType())){
            cri.andInTypeIdIn(Arrays.asList(condition.getVehicleType()));
        }
        
        // 车辆颜色id
        if(ArrayUtils.isNotEmpty(condition.getVehicleColorType())){
            cri.andInColorIdIn(Arrays.asList(condition.getVehicleColorType()));
        }        
        // 车牌类型id
        if(ArrayUtils.isNotEmpty(condition.getPlateType())){
            cri.andInPlateTypeIdIn(Arrays.asList(condition.getPlateType()));
        } 
        // 车牌颜色id
        if(ArrayUtils.isNotEmpty(condition.getPlateColorType())){
            cri.andInPlateColorIdIn(Arrays.asList(condition.getPlateColorType()));
        } 
        // 车辆角度id
        if(ArrayUtils.isNotEmpty(condition.getVehicleAngleType())){
            cri.andInAngleIdIn(Arrays.asList(condition.getVehicleAngleType()));
        } 
        // 进站车牌号
        if(StringUtils.isNotBlank(condition.getPlateNumber())){
            cri.andInPlateTextLike(condition.getPlateNumber());
        } 
        
        // 油站选择 查询当前油站的所有子节点
        Repos reps = null;
        if(StringUtils.isNotBlank(condition.getRepoId())){
            reps = reposMapper.selectByPrimaryKey(condition.getRepoId());
            if(reps==null){
                throw new BusinessException(BizExceptionEnum.VEHICLE_QUEUE_REPOS_ID_PARAM_ERROR);
            }
            List<Repos> reposList  = new ArrayList<Repos>();
            getRepoChildren(reposList,condition.getRepoId());
            List<Long> repodIdList = new ArrayList<Long>();
            repodIdList.add(reps.getId());
            if(CollectionUtils.isNotEmpty(reposList)){
                reposList.forEach(repos->{
                    repodIdList.add(repos.getId());
                });
                cri.andReposIdIn(repodIdList);
            }else{
                cri.andReposIdEqualTo(reps.getId());
            }
        }
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<VehicleQueue> list = this.vehicleQueueMapper.selectByExample(example);
        PageInfo<VehicleQueue> page = new PageInfo<VehicleQueue>(list);
        PageInfo<VehicleQueueDto> pageInfo = new PageInfo<VehicleQueueDto>(Lists.newArrayList());
        List<VehicleQueueDto> dtoList = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(list)){
            Map<String,String> pMap = getReposAndBrandAttr(list);
            for(VehicleQueue view:list){
                dtoList.add(convertView2Dto(pMap,view));
            }
            pageInfo = new PageInfo<VehicleQueueDto>(dtoList);
            pageInfo.setTotal(page.getTotal());
        }
        return pageInfo;
    }

    
    
    private VehicleQueueDto convertView2Dto(final Map<String,String> map ,final VehicleQueue view){
        String reposKey = String.format("repos_%s", view.getReposId());
        String inBrandKey = String.format("brand_%d_%d_%d", view.getInBrandId(),view.getInSubBrandId(),view.getInModeYearId());
        String outBrandKey = String.format("brand_%d_%d_%d", view.getOutBrandId(),view.getOutSubBrandId(),view.getOutModeYearId());
        VehicleQueueDto dto = new VehicleQueueDto();
        dto.setId(view.getId());
        dto.setInFeatureImage(view.getInFeatureImage());
        dto.setInSensorName(view.getInSensorName());
        dto.setOutSensorName(view.getOutSensorName());
        dto.setInSourceImage(view.getInSourceImage());
        dto.setInFeatureImage(view.getInFeatureImage());
        dto.setOutSourceImage(view.getOutSourceImage());
        dto.setOutFeatureImage(view.getOutFeatureImage());
        dto.setInTime(DateHelper.date2String(view.getInTime(), DateHelper.FORMAT_0));
        dto.setOutTime(DateHelper.date2String(view.getOutTime(), DateHelper.FORMAT_0));
        dto.setOilStationRepoId(String.valueOf(view.getReposId()));
        dto.setOilStationRepoName(map.get(reposKey));
       
        dto.setOilType(FuelTypeEnum.getDescByType(ConvertHelper.str2Short(view.getOilType())));
        dto.setPlateNumber(view.getInPlateText());
        dto.setQueueTime(view.getQueueTime()/1000);
        dto.setInVehicleId(view.getInVehicleId());
        dto.setOutVehicleId(view.getOutVehicleId());
        List<VehicleRecord> records = Lists.newArrayList();
        VehicleRecord in = new VehicleRecord();
        in.setPlateColor(VehiclePlateColorTypeEnum.getDescByCode(view.getInPlateColorId()));
        in.setPlateNumber(view.getInPlateText());
        in.setPlateType(VehiclePlateTypeEnum.getDescByCode(view.getInPlateTypeId()));
        in.setType((short)1); // 进站
        in.setVehicleAngleName(VehicleAngleTypeEnum.getDescByCode(view.getInAngleId()));
        in.setBrandName(map.get(inBrandKey));
        in.setVehicleColorName(VehicleColorTypeEnum.getDescByCode(view.getInColorId()));
        in.setVehicleTypeName(VehicleTypeEnum.getDescByCode(view.getInTypeId()));
        
        VehicleRecord out = new VehicleRecord();
        out.setPlateColor(VehiclePlateColorTypeEnum.getDescByCode(view.getOutPlateColorId()));
        out.setPlateNumber(view.getOutPlateText());
        out.setPlateType(VehiclePlateTypeEnum.getDescByCode(view.getOutPlateTypeId()));
        out.setType((short)2);// 出站
        out.setVehicleAngleName(VehicleAngleTypeEnum.getDescByCode(view.getOutAngleId()));
        out.setBrandName(map.get(outBrandKey));
        out.setVehicleColorName(VehicleColorTypeEnum.getDescByCode(view.getOutColorId()));
        out.setVehicleTypeName(VehicleTypeEnum.getDescByCode(view.getOutTypeId()));
        records.add(in);
        records.add(out);
        dto.setRecords(records);
        
        return dto;
    }
    
    private Map<String,String> getReposAndBrandAttr(final List<VehicleQueue> list){
        Map<String,String> pMap = Maps.newHashMap();
        Set<Long> repoIds = Sets.newHashSet();
        Set<Integer> brandIds = Sets.newHashSet();
        Set<Integer> subBrandIds = Sets.newHashSet();
        Set<Integer> yearIds = Sets.newHashSet();
        
        if (CollectionUtils.isNotEmpty(list)) {
            for (VehicleQueue view : list) {
                repoIds.add(view.getReposId());
                if(view.getInBrandId()!=null){
                    brandIds.add(NumberUtils.toInt(String.valueOf(view.getInBrandId())));
                }
                if(view.getInBrandId()!=null){
                    brandIds.add(NumberUtils.toInt(String.valueOf(view.getInBrandId())));
                }
                if(view.getInSubBrandId()!=null){
                    subBrandIds.add(NumberUtils.toInt(String.valueOf(view.getInSubBrandId())));
                }
                if(view.getInSubBrandId()!=null){
                    subBrandIds.add(NumberUtils.toInt(String.valueOf(view.getInSubBrandId())));
                }
                if(view.getInModeYearId()!=null){
                    yearIds.add(NumberUtils.toInt(String.valueOf(view.getInModeYearId())));
                }
                if(view.getInModeYearId()!=null){
                    yearIds.add(NumberUtils.toInt(String.valueOf(view.getInModeYearId())));
                }
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
        MotorBrandAllAttrCriteria brandExample = new MotorBrandAllAttrCriteria();
        MotorBrandAllAttrCriteria.Criteria brandCri = brandExample.createCriteria();
        brandCri.andBrandIdIn(new ArrayList<Integer>(brandIds));
        brandCri.andSubBrandIdIn(new ArrayList<Integer>(subBrandIds));
        brandCri.andYearIdIn(new ArrayList<Integer>(yearIds));
        
        List<MotorBrandAllAttr> brandList = brandMapper.selectByExample(brandExample);
        if (CollectionUtils.isNotEmpty(brandList)) {
            for (MotorBrandAllAttr m : brandList) {
                pMap.put("brand_"+m.getBrandId()+"_"+m.getSubBrandId()+"_"+m.getYearId(),m.getBrandName()+"-"+m.getSubBrandName()+"-"+m.getYearName());
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

    public int updateByPrimaryKeySelective(VehicleQueue record) {
        return this.vehicleQueueMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(VehicleQueue record) {
        return this.vehicleQueueMapper.updateByPrimaryKey(record);
    }

    public int updateByExampleSelective(VehicleQueue record, VehicleQueueCriteria example) {
        return this.vehicleQueueMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(VehicleQueue record, VehicleQueueCriteria example) {
        return this.vehicleQueueMapper.updateByExample(record, example);
    }

    public int insert(VehicleQueue record) {
        return this.vehicleQueueMapper.insert(record);
    }

    public int insertSelective(VehicleQueue record) {
        return this.vehicleQueueMapper.insertSelective(record);
    }
    
    private String getExportKey(String id,String filePath){
        String responseInfo = UUIDHelper.genUUID(false);
        try {
            Cache cache = cacheManager.getCache("vehicleQueueResultExcelCache");
            cache.put(responseInfo,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseInfo;
    }
 
    private VehicleQueueCriteria generateVehicleQueueCri(VehicleQueueExportCondition condition){
        VehicleQueueCriteria example = new VehicleQueueCriteria();
        example.setDistinct(true);
        example.setPageNumber(condition.getPageNumber());
        example.setPageSize(condition.getPageSize());
        VehicleQueueCriteria.Criteria cri = example.createCriteria();
        // 选择的id列表
        if(ArrayUtils.isNotEmpty(condition.getIds())){
            cri.andIdIn(Arrays.asList(condition.getIds()));
        }
        // 进站时间
        if(StringUtils.isNotBlank(condition.getInStartTime())){
            Date startTime = DateHelper.string2Date(condition.getInStartTime(), DateHelper.FORMAT_0);
            cri.andInTimeGreaterThanOrEqualTo(startTime);
        }
        if(StringUtils.isNotBlank(condition.getInEndTime())){
            Date endTime = DateHelper.string2Date(condition.getInEndTime(), DateHelper.FORMAT_0);
            cri.andInTimeLessThanOrEqualTo(endTime);
        }
        cri.andQueueTimeGreaterThan(0L);
        // 排队开始时间
        if(condition.getStartQueueTime()!=null&&condition.getStartQueueTime()>0){
            cri.andQueueTimeGreaterThanOrEqualTo(condition.getStartQueueTime()*1000L);
        }
        // 排队结束时间
        if(condition.getEndQueueTime()!=null&&condition.getEndQueueTime()>0){
            cri.andQueueTimeLessThanOrEqualTo(condition.getEndQueueTime()*1000L);
        }
        // 加油类型 
        if(StringUtils.isNotBlank(condition.getOilType())){
            cri.andOilTypeEqualTo(condition.getOilType());
        }
        // 车辆品牌 brands
        if(ArrayUtils.isNotEmpty(condition.getBrands())){
            List<Short> brandList = new ArrayList<Short>();
            List<Short> subBrandList = new ArrayList<Short>();
            List<Short> modelYearList = new ArrayList<Short>();
            for(BrandObj obj:condition.getBrands()){
                if(obj.getBrandId()!=null){
                    brandList.add(obj.getBrandId());
                }
                if(obj.getSubBrandId()!=null){
                    subBrandList.add(obj.getSubBrandId());
                }
                if(obj.getModelYearId()!=null){
                    modelYearList.add(obj.getModelYearId());
                }
            }
            if(CollectionUtils.isNotEmpty(brandList)){
                cri.andInBrandIdIn(brandList);
            }
            if(CollectionUtils.isNotEmpty(subBrandList)){
                cri.andInSubBrandIdIn(subBrandList);
            }
            if(CollectionUtils.isNotEmpty(modelYearList)){
                cri.andInModeYearIdIn(modelYearList);
            }
        }
        // 车辆类型id
        if(ArrayUtils.isNotEmpty(condition.getVehicleType())){
            cri.andInTypeIdIn(Arrays.asList(condition.getVehicleType()));
        }
        
        // 车辆颜色id
        if(ArrayUtils.isNotEmpty(condition.getVehicleColorType())){
            cri.andInColorIdIn(Arrays.asList(condition.getVehicleColorType()));
        }        
        // 车牌类型id
        if(ArrayUtils.isNotEmpty(condition.getPlateType())){
            cri.andInPlateTypeIdIn(Arrays.asList(condition.getPlateType()));
        } 
        // 车牌颜色id
        if(ArrayUtils.isNotEmpty(condition.getPlateColorType())){
            cri.andInPlateColorIdIn(Arrays.asList(condition.getPlateColorType()));
        } 
        // 车辆角度id
        if(ArrayUtils.isNotEmpty(condition.getVehicleAngleType())){
            cri.andInAngleIdIn(Arrays.asList(condition.getVehicleAngleType()));
        } 
        // 进站车牌号
        if(StringUtils.isNotBlank(condition.getPlateNumber())){
            cri.andInPlateTextEqualTo(condition.getPlateNumber());
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
            repodIdList.add(reps.getId());
            if(CollectionUtils.isNotEmpty(reposList)){
                reposList.forEach(repos->{
                    repodIdList.add(repos.getId());
                    map.put(repos.getRepoId(), repos.getRepoName());
                });
                cri.andReposIdIn(repodIdList);
            }else{
                cri.andReposIdEqualTo(reps.getId());
            }
        }
        return example;
    }
    
    @Override
    public String downloadVehicleQueueResultExcel(HttpServletRequest request,HttpServletResponse response,String key) {
        if(StringUtils.isBlank(key)){
            throw new BusinessException(BizExceptionEnum.VEHICLE_QUEUE_ERROR_DOWNLOAD_PARAM);
        }
        // 查询缓存
        Cache cache = cacheManager.getCache("vehicleQueueResultExcelCache");
        String id = cache.get(key,String.class);
        if(StringUtils.isBlank(id)){
            throw new BusinessException(BizExceptionEnum.VEHICLE_QUEUE_ERROR_DOWNLOAD_PARAM);
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
    
    
    @Override
    public String getExportResultExcel(VehicleQueueExportCondition condition) {
        // 查询缓存
        Cache cache = cacheManager.getCache("vehicleQueueResultExcelCache");
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
        queueExa.setOrderByClause("in_time desc");
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
        List<VehicleQueueExportDto> exportList = Lists.newArrayList();
        Map<String,String> pMap = getReposAndBrandAttr(list);
        for(VehicleQueue  queue:list){
            exportList.add(convert2ExportDto(pMap,queue));
        }
        String baseName = DateHelper.date2String(new Date(), DateHelper.FORMAT_0);
        String excelFileName = "车辆排队数据统计.xls";
        String fileIndex = UUIDHelper.genUUID(false);
        String baseFileDir = appConfig.getExportDir()+"/vehicleQueue_"+fileIndex;
        String imageDir = String.format("%s/%s",baseFileDir,"images");
        String zipName = "vehicleQueue_"+fileIndex+".zip";
        String zipPath = appConfig.getExportDir()+"/"+zipName;
        String zipDownloadName = "车辆排队数据统计:"+baseName+".zip";
        
        try {
            new VehicleQueueResultExcelExport().exportExcel(excelFileName,baseFileDir,imageDir,exportList,appConfig.getVehicleQueueExportNum());
            ZipCompressor zc = new ZipCompressor(zipPath);
            zc.compress(baseFileDir);
            FileUtils.deleteDirectory(new File(baseFileDir));
            cache.put(id,zipPath);
            cache.put("filename_"+id,zipDownloadName);
        } catch (Exception e) {
            cache.evict(id);
            cache.evict("filename_"+id);
            cache.put(id,zipPath);
            e.printStackTrace();
            throw new BusinessException(BizExceptionEnum.VEHICLE_QUEUE_ERROR_EXPORT_FAIL);
        }
        return getExportKey(id,zipPath);
    }
    
    private VehicleQueueExportDto convert2ExportDto(final Map<String,String> map ,final VehicleQueue view){
        VehicleQueueExportDto dto = new VehicleQueueExportDto();
        String reposKey = String.format("repos_%s", view.getReposId());
        String inBrandKey = String.format("brand_%d_%d_%d", view.getInBrandId(),view.getInSubBrandId(),view.getInModeYearId());
        String outBrandKey = String.format("brand_%d_%d_%d", view.getOutBrandId(),view.getOutSubBrandId(),view.getOutModeYearId());
        dto.setId(view.getId());
        dto.setInSensorName(view.getInSensorName());
        dto.setOutSensorName(view.getOutSensorName());
        
        dto.setInFeatureImage(view.getInFeatureImage());
        dto.setInSourceImage(view.getInSourceImage());
        
        dto.setOutSourceImage(view.getOutSourceImage());
        dto.setOutFeatureImage(view.getOutFeatureImage());
        
        dto.setInTime(DateHelper.date2String(view.getInTime(), DateHelper.FORMAT_0));
        dto.setOutTime(DateHelper.date2String(view.getOutTime(), DateHelper.FORMAT_0));
        dto.setOilStationRepoName(map.get(reposKey));
        dto.setOilType(OilTypeEnum.getDescByCode(view.getOilType()));
        dto.setInPlateNumber(view.getInPlateText());
        dto.setOutPlateNumber(view.getOutPlateText());
        dto.setQueueTime((long)Math.round(view.getQueueTime()/60000));
        dto.setInPlateColor(VehiclePlateColorTypeEnum.getDescByCode(view.getInPlateColorId()));
        dto.setInPlateType(VehiclePlateTypeEnum.getDescByCode(view.getInPlateTypeId()));
        dto.setInVehicleAngleName(VehicleAngleTypeEnum.getDescByCode(view.getInAngleId()));
        dto.setInBrandName(map.get(inBrandKey));
        dto.setInVehicleColorName(VehicleColorTypeEnum.getDescByCode(view.getInColorId()));
        dto.setInVehicleTypeName(VehicleTypeEnum.getDescByCode(view.getInTypeId()));
        dto.setOutPlateColor(VehiclePlateColorTypeEnum.getDescByCode(view.getOutPlateColorId()));
        dto.setOutPlateType(VehiclePlateTypeEnum.getDescByCode(view.getOutPlateTypeId()));
        dto.setOutVehicleAngleName(VehicleAngleTypeEnum.getDescByCode(view.getOutAngleId()));
        dto.setOutBrandName(map.get(outBrandKey));
        dto.setOutVehicleColorName(VehicleColorTypeEnum.getDescByCode(view.getOutColorId()));
        dto.setOutVehicleTypeName(VehicleTypeEnum.getDescByCode(view.getOutTypeId()));
        return  dto;
    }


}