package com.sensenets.sinopec.buiness.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.condition.MobileCollectTaskCondition;
import com.sensenets.sinopec.buiness.dto.CollectResultDto;
import com.sensenets.sinopec.buiness.dto.MobileCollectTaskDto;
import com.sensenets.sinopec.buiness.model.one.MobileCollectTask;
import com.sensenets.sinopec.buiness.model.one.MobileCollectTaskCriteria;

public interface IMobileCollectTaskService {
    int countByExample(MobileCollectTaskCriteria example);

    MobileCollectTask selectByPrimaryKey(Long id);

    List<MobileCollectTask> selectByExample(MobileCollectTaskCriteria example);

    PageInfo<MobileCollectTaskDto> selectPageByExample(MobileCollectTaskCondition condition);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MobileCollectTask record);

    int updateByPrimaryKey(MobileCollectTask record);

    int deleteByExample(MobileCollectTaskCriteria example);

    int updateByExampleSelective(MobileCollectTask record, MobileCollectTaskCriteria example);
    
    int updateBatchStatusByPrimaryKey(Short status,List<Long> ids);

    int updateByExample(MobileCollectTask record, MobileCollectTaskCriteria example);

    int insert(MobileCollectTask record);

    int insertSelective(MobileCollectTask record);

    /**
      * @Title: getCollectResult
      * @Description: 查询分析结果
      * @param id
      * @return CollectResultDto
      */
    CollectResultDto getCollectResult(Long id);

  
    /**
      * @Title: getCollectResultExcel
      * @Description: 导出到服务器
      * @param id
      * @return
      */
    String getCollectResultExcel(Long id);
    
    /**
     * @Title: downloadCollectResultExcel
     * @Description: 下载到客户端
     * @param response
     * @param key
     * @return
     */
    String downloadCollectResultExcel(HttpServletRequest request , HttpServletResponse response,String key);
}