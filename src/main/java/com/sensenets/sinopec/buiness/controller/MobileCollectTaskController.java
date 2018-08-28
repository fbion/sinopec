package com.sensenets.sinopec.buiness.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sensenets.sinopec.buiness.condition.CommonDeleteCondition;
import com.sensenets.sinopec.buiness.condition.MobileCollectTaskCondition;
import com.sensenets.sinopec.buiness.dto.MobileCollectTaskDto;
import com.sensenets.sinopec.buiness.model.one.MobileCollectTask;
import com.sensenets.sinopec.buiness.model.one.MobileCollectTaskCriteria;
import com.sensenets.sinopec.buiness.model.one.VjMobileCollectTaskViewCriteria;
import com.sensenets.sinopec.buiness.service.IMobileCollectTaskService;
import com.sensenets.sinopec.common.controller.BaseController;
import com.sensenets.sinopec.common.domain.ResponseInfo;
import com.sensenets.sinopec.common.enums.BizExceptionEnum;
import com.sensenets.sinopec.common.enums.CollectTaskStatusEnum;
import com.sensenets.sinopec.common.exception.BusinessException;
import com.sensenets.sinopec.common.utils.DateHelper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

 /**
  * @ClassName: MobileCollectTaskController
  * @Description: 移动数据采集控制层
  * @author think
  * @date 2018年08月24日 17:56:41
  */
  
@RestController
@Api(value="MobileCollectTaskController", tags = "移动数据采集接口", description="MobileCollectTaskController")
@RequestMapping(value = "/service/mobileCollectTask",produces = {APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class MobileCollectTaskController extends BaseController {

    @Autowired
    IMobileCollectTaskService mobileCollectTaskService;
    
    @ApiOperation(value = "列表")
    @RequestMapping(value = "/list", method= RequestMethod.POST, produces = "application/json")
    public ResponseInfo list(MobileCollectTaskCondition condition){
        // 判断条件并转化为Criteria对象
        MobileCollectTaskCriteria example = new MobileCollectTaskCriteria();
        example.setDistinct(true);
        example.setPageNumber(condition.getPageNumber());
        example.setPageSize(condition.getPageSize());
        MobileCollectTaskCriteria.Criteria cri = example.createCriteria();
       
        if(StringUtils.isNotBlank(condition.getCollectStartTime())){
            Date startTime = DateHelper.string2Date(condition.getCollectStartTime(), DateHelper.FORMAT_0);
            cri.andCollectStartTimeGreaterThanOrEqualTo(startTime);
        }
        if(StringUtils.isNotBlank(condition.getCollectEndTime())){
            Date endTime = DateHelper.string2Date(condition.getCollectEndTime(), DateHelper.FORMAT_0);
            cri.andCollectEndTimeLessThanOrEqualTo(endTime);
        }
        if(StringUtils.isNotBlank(condition.getCollectRepoId())){
            cri.andCollectRepoIdEqualTo(condition.getCollectRepoId());
        }
        if(StringUtils.isNotBlank(condition.getOilStationRepoId())){
            cri.andOilStationRepoIdEqualTo(condition.getOilStationRepoId());
        }
        List<MobileCollectTask> list = mobileCollectTaskService.selectByExample(example);
        
        return this.warpCollectionObject(list);
    }
    
    

     @ApiOperation(value = "分页列表")
     @RequestMapping(value = "/listPage", method= RequestMethod.POST, produces = "application/json")
     public ResponseInfo listPage(@RequestBody MobileCollectTaskCondition condition){
         // 判断条件并转化为Criteria对象
         VjMobileCollectTaskViewCriteria example = new VjMobileCollectTaskViewCriteria();
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
             cri.andCollectRepoIdEqualTo(condition.getCollectRepoId());
         }
         if(StringUtils.isNotBlank(condition.getOilStationRepoId())){
             cri.andOilStationRepoIdEqualTo(condition.getOilStationRepoId());
         }
         PageInfo<MobileCollectTaskDto> page = mobileCollectTaskService.selectPageByExample(example);
         return this.warpPageObject(page);
     }

    @ApiOperation(value = "根据id查询")
    @RequestMapping(value = "/query/{id}", method= RequestMethod.GET, produces = "application/json")
    public ResponseInfo find(@PathVariable Long id){
        return this.warpObject(mobileCollectTaskService.selectByPrimaryKey(id));
    }

    @ApiOperation(value = "添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseInfo save(@RequestBody MobileCollectTask record){
        if(record.getCollectEndTime()==null||record.getCollectStartTime()==null){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_TIME_PARAMS_NULL);
        }
        if(record.getType() == null){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_TYPE_PARAMS_NULL);
        }
        if(StringUtils.isEmpty(record.getCollectRepoId())){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_NAME_PARAMS_NULL);
        }
        if(StringUtils.isEmpty(record.getOilStationRepoId())){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_STATION_NAME_PARAMS_NULL);
        }
        // 设置参数
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        record.setUserId(username);
        record.setTs(System.currentTimeMillis());
        record.setType(CollectTaskStatusEnum.RUNNING.getCode());
        record.setUts(DateHelper.string2Date(DateHelper.getCurrentDateFormat0(),DateHelper.FORMAT_0));
        return this.warpObject(mobileCollectTaskService.insert(record));
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseInfo update(@PathVariable Long id, @RequestBody MobileCollectTask record){
        if(record.getCollectEndTime()==null||record.getCollectStartTime()==null){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_TIME_PARAMS_NULL);
        }
        if(record.getType() == null){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_TYPE_PARAMS_NULL);
        }
        if(StringUtils.isEmpty(record.getCollectRepoId())){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_NAME_PARAMS_NULL);
        }
        if(StringUtils.isEmpty(record.getOilStationRepoId())){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_STATION_NAME_PARAMS_NULL);
        }
        record.setId(id);
        return this.warpObject(mobileCollectTaskService.updateByPrimaryKeySelective(record));
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseInfo delete(@PathVariable Long id){
        return this.warpObject(mobileCollectTaskService.deleteByPrimaryKey(id));
    }
    
    @ApiOperation(value = "批量删除")
    @RequestMapping(value="/deleteBatch", method = RequestMethod.POST, produces = "application/json")
    public ResponseInfo delete(@RequestBody CommonDeleteCondition condition){

        if(StringUtils.isBlank(condition.getIds())||ArrayUtils.isEmpty(condition.getIds().split(","))){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_ID_PARAMS_NULL);
        }
        String[] idAry = condition.getIds().split(",");
        MobileCollectTaskCriteria example = new MobileCollectTaskCriteria();
        MobileCollectTaskCriteria.Criteria cri = example.createCriteria();
        List<Long> list = Lists.newArrayList();
        for(String id : idAry){
            if(StringUtils.isNotBlank(id)){
                list.add(NumberUtils.toLong(id));
            }
        }
        if(CollectionUtils.isEmpty(list)){
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_ERROR_ID_PARAMS_NULL);
        }
        cri.andIdIn(list);
        return this.warpObject(mobileCollectTaskService.deleteByExample(example));
    }
    
    
}




