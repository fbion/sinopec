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
import com.sensenets.sinopec.buiness.dao.one.SensorsMapper;
import com.sensenets.sinopec.buiness.dao.two.ImagesMapper;
import com.sensenets.sinopec.buiness.dao.two.VjVehicleQueueViewMapper;
import com.sensenets.sinopec.buiness.dto.BrandObj;
import com.sensenets.sinopec.buiness.dto.ImageDto;
import com.sensenets.sinopec.buiness.dto.VehicleQueueDto;
import com.sensenets.sinopec.buiness.dto.VehicleQueueDto.VehicleRecord;
import com.sensenets.sinopec.buiness.model.one.MotorBrandAllAttr;
import com.sensenets.sinopec.buiness.model.one.MotorBrandAllAttrCriteria;
import com.sensenets.sinopec.buiness.model.one.Repos;
import com.sensenets.sinopec.buiness.model.one.ReposCriteria;
import com.sensenets.sinopec.buiness.model.one.Sensors;
import com.sensenets.sinopec.buiness.model.one.SensorsCriteria;
import com.sensenets.sinopec.buiness.model.two.Images;
import com.sensenets.sinopec.buiness.model.two.ImagesCriteria;
import com.sensenets.sinopec.buiness.model.two.VjVehicleQueueView;
import com.sensenets.sinopec.buiness.model.two.VjVehicleQueueViewCriteria;
import com.sensenets.sinopec.buiness.service.IVjVehicleQueueViewService;
import com.sensenets.sinopec.common.enums.VehicleAngleTypeEnum;
import com.sensenets.sinopec.common.enums.VehicleColorTypeEnum;
import com.sensenets.sinopec.common.enums.VehiclePlateColorTypeEnum;
import com.sensenets.sinopec.common.enums.VehiclePlateTypeEnum;
import com.sensenets.sinopec.common.enums.VehicleTypeEnum;
import com.sensenets.sinopec.common.utils.DateHelper;
import com.sensenets.sinopec.common.utils.JsonHelper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VjVehicleQueueViewServiceImpl implements IVjVehicleQueueViewService {
    @Autowired
    private VjVehicleQueueViewMapper vjVehicleQueueViewMapper;
    @Autowired
    private ReposMapper  reposMapper;
    
    @Autowired
    private SensorsMapper  sensorsMapper;
    
    @Autowired
    private ImagesMapper  imagesMapper;
    
    @Autowired
    private MotorBrandAllAttrMapper  brandMapper;

    public int countByExample(VjVehicleQueueViewCriteria example) {
        int count = this.vjVehicleQueueViewMapper.countByExample(example);
        log.debug("count: {}", count);
        return count;
    }
    
    public VjVehicleQueueView selectByPrimaryKey(Long id) {
        return this.vjVehicleQueueViewMapper.selectByPrimaryKey(id);
    }

    public List<VjVehicleQueueView> selectByExample(VjVehicleQueueViewCriteria example) {
        return this.vjVehicleQueueViewMapper.selectByExample(example);
    }

    public PageInfo<VehicleQueueDto> selectPageByExample(VehicleQueueCondition condition) {
        // 判断条件并转化为Criteria对象
        VjVehicleQueueViewCriteria example = new VjVehicleQueueViewCriteria();
        example.setDistinct(true);
        example.setPageNumber(condition.getPageNumber());
        example.setPageSize(condition.getPageSize());
        VjVehicleQueueViewCriteria.Criteria cri = example.createCriteria();
        // 进站时间
        if(StringUtils.isNotBlank(condition.getInStartTime())){
            Date startTime = DateHelper.string2Date(condition.getInStartTime(), DateHelper.FORMAT_0);
            cri.andVaTsGreaterThanOrEqualTo(startTime.getTime());
        }
        if(StringUtils.isNotBlank(condition.getInEndTime())){
            Date endTime = DateHelper.string2Date(condition.getInEndTime(), DateHelper.FORMAT_0);
            cri.andVaTsLessThanOrEqualTo(endTime.getTime());
        }
        // 排队时间
        if(condition.getQueueTime()!=null&&condition.getQueueTime()>0){
            long endQueueTime = condition.getQueueTime()*1000;
            cri.andQueueTimeGreaterThanOrEqualTo(0L);
            if(condition.getQueueTime()>60){
                endQueueTime = 60*1000L;
            }
            cri.andQueueTimeLessThanOrEqualTo(endQueueTime);
        }
        // 加油类型 
        if(StringUtils.isNotBlank(condition.getOilType())){
            cri.andVaOilTypeEqualTo(condition.getOilType());
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
                cri.andVaBrandIdIn(brandList);
            }
            if(CollectionUtils.isNotEmpty(subBrandList)){
                cri.andVaSubBrandIdIn(subBrandList);
            }
            if(CollectionUtils.isNotEmpty(modelYearList)){
                cri.andVaModelYearIdIn(modelYearList);
            }
        }
        // 车辆类型id
        if(ArrayUtils.isNotEmpty(condition.getVehicleType())){
            cri.andVaTypeIdIn(Arrays.asList(condition.getVehicleType()));
        }
        
        // 车辆颜色id
        if(ArrayUtils.isNotEmpty(condition.getVehicleColorType())){
            cri.andVaColorIdIn(Arrays.asList(condition.getVehicleColorType()));
        }        
        // 车牌类型id
        if(ArrayUtils.isNotEmpty(condition.getPlateType())){
            cri.andVaPlateTypeIdIn(Arrays.asList(condition.getPlateType()));
        } 
        // 车牌颜色id
        if(ArrayUtils.isNotEmpty(condition.getPlateColorType())){
            cri.andVaPlateColorIdIn(Arrays.asList(condition.getPlateColorType()));
        } 
        // 车辆角度id
        if(ArrayUtils.isNotEmpty(condition.getVehicleAngleType())){
            cri.andVaSideIn(Arrays.asList(condition.getVehicleAngleType()));
        } 
        // 车牌号
        if(StringUtils.isNotBlank(condition.getPlateNumber())){
            cri.andVaPlateTextEqualTo(condition.getPlateNumber());
        } 
        
        // 油站选择 查询当前油站的所有子节点
        Map<String,String> map = Maps.newHashMap();
        if(StringUtils.isNotBlank(condition.getRepoId())){
            List<Repos> reposList  = new ArrayList<Repos>();
            getRepoChildren(reposList,condition.getRepoId());
            List<String> repodIdList = new ArrayList<String>();
            if(CollectionUtils.isNotEmpty(reposList)){
                reposList.forEach(repos->{
                    repodIdList.add(repos.getRepoId());
                    map.put(repos.getRepoId(), repos.getRepoName());
                });
                repodIdList.add(condition.getRepoId());
                cri.andVaRepoIdIn(repodIdList);
            }
        }
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<VjVehicleQueueView> list = this.vjVehicleQueueViewMapper.selectByExample(example);
        PageInfo<VjVehicleQueueView> page = new PageInfo<VjVehicleQueueView>(list);
        PageInfo<VehicleQueueDto> pageInfo = new PageInfo<VehicleQueueDto>(Lists.newArrayList());
        List<VehicleQueueDto> dtoList = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(list)){
            Map<String,String> pMap = getReposAndSensorAndBrandAttrAndImageUrl(list);
            for(VjVehicleQueueView view:list){
                dtoList.add(convertView2Dto(pMap,view));
            }
            pageInfo = new PageInfo<VehicleQueueDto>(dtoList);
            pageInfo.setTotal(page.getTotal());
        }
        return pageInfo;
    }
    
    private VehicleQueueDto convertView2Dto(final Map<String,String> map ,final VjVehicleQueueView view){
        VehicleQueueDto dto = new VehicleQueueDto();
        String reposKey = String.format("repos_%s", view.getVaRepoId());
        String inBrandKey = String.format("brand_%d_%d_%d", view.getVaBrandId(),view.getVaSubBrandId(),view.getVaModelYearId());
        String outBrandKey = String.format("brand_%d_%d_%d", view.getVbBrandId(),view.getVbSubBrandId(),view.getVbModelYearId());
        String inSensorKey = String.format("sensors_%s", view.getVaSensorId());
        String outSensorKey = String.format("sensors_%s", view.getVaSensorId());
        String inImageKey = String.format("images_%s", view.getVaImageId());
        String outImageKey = String.format("images_%s", view.getVbImageId());
        dto.setId(view.getId());
        dto.setInFeatureImage(map.get(inImageKey));
        dto.setInSensorName(map.get(inSensorKey));
        dto.setOutSensorName(map.get(outSensorKey));
        ImageDto inImageDto = StringUtils.isNotBlank(map.get(inImageKey))?JsonHelper.fromJsonByT(map.get(inImageKey), ImageDto.class):null;
        ImageDto outImageDto = StringUtils.isNotBlank(map.get(outImageKey))?JsonHelper.fromJsonByT(map.get(outImageKey), ImageDto.class):null;
        if(inImageDto!=null){
            dto.setInSourceImage(inImageDto.getSourceImageUrl());
            dto.setInFeatureImage(inImageDto.getFeatureImageUrl());
        }
        if(outImageDto!=null){
            dto.setOutSourceImage(outImageDto.getSourceImageUrl());
            dto.setOutFeatureImage(outImageDto.getFeatureImageUrl());
        }
        dto.setInTime(DateHelper.long2DateStr(view.getVaTs(),DateHelper.FORMAT_0));
        dto.setOutTime(DateHelper.long2DateStr(view.getVbTs(),DateHelper.FORMAT_0));
        dto.setOilStationRepoId(view.getVaRepoId());
        dto.setOilStationRepoName(map.get(reposKey));
        dto.setOilType(view.getVaOilType());
        dto.setPlateNumber(view.getVaPlateText());
        dto.setQueueTime(view.getQueueTime()/1000);
        List<VehicleRecord> records = Lists.newArrayList();
        VehicleRecord in = new VehicleRecord();
        in.setBrandName(map.get(inBrandKey));
        in.setPlateColor(VehiclePlateColorTypeEnum.getDescByCode(view.getVaPlateColorId()));
        in.setPlateNumber(view.getVaPlateText());
        in.setPlateType(VehiclePlateTypeEnum.getDescByCode(view.getVaPlateTypeId()));
        in.setType((short)1);
        in.setVehicleAngleName(VehicleAngleTypeEnum.getDescByCode(view.getVaSide()));
        in.setBrandName(map.get(inBrandKey));
        in.setVehicleColorName(VehicleColorTypeEnum.getDescByCode(view.getVaColorId()));
        in.setVehicleTypeName(VehicleTypeEnum.getDescByCode(view.getVaTypeId()));
        VehicleRecord out = new VehicleRecord();
        out.setBrandName(map.get(outBrandKey));
        out.setPlateColor(VehiclePlateColorTypeEnum.getDescByCode(view.getVbPlateColorId()));
        out.setPlateNumber(view.getVbPlateText());
        out.setPlateType(VehiclePlateTypeEnum.getDescByCode(view.getVbPlateTypeId()));
        out.setType((short)1);
        out.setVehicleAngleName(VehicleAngleTypeEnum.getDescByCode(view.getVbSide()));
        out.setBrandName(map.get(outBrandKey));
        out.setVehicleColorName(VehicleColorTypeEnum.getDescByCode(view.getVbColorId()));
        out.setVehicleTypeName(VehicleTypeEnum.getDescByCode(view.getVbTypeId()));
        records.add(in);
        records.add(out);
        dto.setRecords(records);
        
        return dto;
    }
    
    private Map<String,String> getReposAndSensorAndBrandAttrAndImageUrl(final List<VjVehicleQueueView> list){
        Map<String,String> pMap = Maps.newHashMap();
        Set<Long> repoIds = Sets.newHashSet();
        Set<Long> sensorIds = Sets.newHashSet();
        Set<String> imageIds = Sets.newHashSet();
        Set<Integer> brandIds = Sets.newHashSet();
        Set<Integer> subBrandIds = Sets.newHashSet();
        Set<Integer> yearIds = Sets.newHashSet();
        
        if (CollectionUtils.isNotEmpty(list)) {
            for (VjVehicleQueueView view : list) {
                repoIds.add(Long.parseLong(view.getVaRepoId()));
                sensorIds.add(Long.parseLong(view.getVaSensorId()));
                if(StringUtils.isNotBlank(view.getVaImageId())){
                    imageIds.add(view.getVaImageId());
                }
                if(StringUtils.isNotBlank(view.getVbImageId())){
                    imageIds.add(view.getVbImageId());
                }
                if(view.getVaBrandId()!=null){
                    brandIds.add(NumberUtils.toInt(String.valueOf(view.getVaBrandId())));
                }
                if(view.getVbBrandId()!=null){
                    brandIds.add(NumberUtils.toInt(String.valueOf(view.getVbBrandId())));
                }
                if(view.getVaSubBrandId()!=null){
                    subBrandIds.add(NumberUtils.toInt(String.valueOf(view.getVaSubBrandId())));
                }
                if(view.getVbSubBrandId()!=null){
                    subBrandIds.add(NumberUtils.toInt(String.valueOf(view.getVbSubBrandId())));
                }
                if(view.getVaModelYearId()!=null){
                    yearIds.add(NumberUtils.toInt(String.valueOf(view.getVaModelYearId())));
                }
                if(view.getVbModelYearId()!=null){
                    yearIds.add(NumberUtils.toInt(String.valueOf(view.getVbModelYearId())));
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
        SensorsCriteria example = new SensorsCriteria();
        SensorsCriteria.Criteria cri = example.createCriteria();
        cri.andIdIn(new ArrayList<Long>(sensorIds));
        List<Sensors> sensorList = sensorsMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(sensorList)) {
            for (Sensors s : sensorList) {
                pMap.put("sensors_"+s.getId(), s.getSensorName());
            }
        }
        ImagesCriteria imageExample = new ImagesCriteria();
        ImagesCriteria.Criteria imageCri = imageExample.createCriteria();
        imageCri.andImageIdIn(new ArrayList<String>(imageIds));
        List<Images> imagesList = imagesMapper.selectByExample(imageExample);
        if (CollectionUtils.isNotEmpty(imagesList)) {
            for (Images i : imagesList) {
                ImageDto dto = new ImageDto(i.getImageId(),i.getImageUri(),i.getThumbnailImageUri());
                pMap.put("images_"+i.getImageId(),JsonHelper.toJson(dto));
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
    
}