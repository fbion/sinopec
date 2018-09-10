package com.sensenets.sinopec.buiness.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sensenets.sinopec.buiness.condition.VehicleQueueCondition;
import com.sensenets.sinopec.buiness.dao.one.MotorBrandAllAttrMapper;
import com.sensenets.sinopec.buiness.dao.one.ReposMapper;
import com.sensenets.sinopec.buiness.dao.two.VehicleQueueMapper;
import com.sensenets.sinopec.buiness.dto.BrandObj;
import com.sensenets.sinopec.buiness.dto.VehicleQueueDto;
import com.sensenets.sinopec.buiness.dto.VehicleQueueDto.VehicleRecord;
import com.sensenets.sinopec.buiness.model.one.MotorBrandAllAttr;
import com.sensenets.sinopec.buiness.model.one.MotorBrandAllAttrCriteria;
import com.sensenets.sinopec.buiness.model.one.Repos;
import com.sensenets.sinopec.buiness.model.one.ReposCriteria;
import com.sensenets.sinopec.buiness.model.two.VehicleQueue;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueCriteria;
import com.sensenets.sinopec.buiness.service.IVehicleQueueService;
import com.sensenets.sinopec.common.enums.BizExceptionEnum;
import com.sensenets.sinopec.common.enums.OilTypeEnum;
import com.sensenets.sinopec.common.enums.VehicleAngleTypeEnum;
import com.sensenets.sinopec.common.enums.VehicleColorTypeEnum;
import com.sensenets.sinopec.common.enums.VehiclePlateColorTypeEnum;
import com.sensenets.sinopec.common.enums.VehiclePlateTypeEnum;
import com.sensenets.sinopec.common.enums.VehicleTypeEnum;
import com.sensenets.sinopec.common.exception.BusinessException;
import com.sensenets.sinopec.common.utils.DateHelper;

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
        example.setDistinct(true);
        example.setPageNumber(condition.getPageNumber());
        example.setPageSize(condition.getPageSize());
        VehicleQueueCriteria.Criteria cri = example.createCriteria();
        // 进站时间
        if(StringUtils.isNotBlank(condition.getInStartTime())){
            Date startTime = DateHelper.string2Date(condition.getInStartTime(), DateHelper.FORMAT_0);
            cri.andInTimeGreaterThanOrEqualTo(startTime);
        }
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
            if(CollectionUtils.isNotEmpty(reposList)){
                reposList.forEach(repos->{
                    repodIdList.add(repos.getId());
                    map.put(repos.getRepoId(), repos.getRepoName());
                });
                repodIdList.add(reps.getId());
                cri.andReposIdIn(repodIdList);
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
        dto.setOilType(OilTypeEnum.getDescByCode(view.getOilType()));
        dto.setPlateNumber(view.getInPlateText());
        dto.setQueueTime(view.getQueueTime()/1000);
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
}