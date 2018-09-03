package com.sensenets.sinopec.buiness.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.sensenets.sinopec.common.enums.DeleteStatusEnum;
import com.sensenets.sinopec.common.exception.BusinessException;
import com.sensenets.sinopec.common.utils.DateHelper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

 /**
  * @ClassName: IgnoreUrlController
  * @Description: 忽略令牌校验控制层
  * @author think
  * @date 2018年08月24日 17:56:41
  */
  
@RestController
@Api(value="IgnoreUrlController", tags = "忽略令牌校验接口", description="IgnoreUrlController")
@RequestMapping(value = "/service/ignore",produces = {APPLICATION_JSON_UTF8_VALUE})
@Slf4j
public class IgnoreUrlController extends BaseController {

    @Autowired
    IMobileCollectTaskService mobileCollectTaskService;
    
    @ApiOperation(value = "获取导出分析结果")
    @RequestMapping(value="/getExportResult/{key}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public void getExportResult(@PathVariable String key,HttpServletRequest request,HttpServletResponse response){
        mobileCollectTaskService.downloadCollectResultExcel(response,key);
    }
    
}




