package com.sensenets.sinopec.buiness.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.dto.MobileCollectTaskDto;
import com.sensenets.sinopec.buiness.model.one.MobileCollectTask;
import com.sensenets.sinopec.buiness.model.one.MobileCollectTaskCriteria;
import com.sensenets.sinopec.buiness.model.one.VjMobileCollectTaskViewCriteria;

public interface IMobileCollectTaskService {
    int countByExample(MobileCollectTaskCriteria example);

    MobileCollectTask selectByPrimaryKey(Long id);

    List<MobileCollectTask> selectByExample(MobileCollectTaskCriteria example);

    PageInfo<MobileCollectTaskDto> selectPageByExample(VjMobileCollectTaskViewCriteria example);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MobileCollectTask record);

    int updateByPrimaryKey(MobileCollectTask record);

    int deleteByExample(MobileCollectTaskCriteria example);

    int updateByExampleSelective(MobileCollectTask record, MobileCollectTaskCriteria example);
    
    int updateBatchStatusByPrimaryKey(Short status,List<Long> ids);

    int updateByExample(MobileCollectTask record, MobileCollectTaskCriteria example);

    int insert(MobileCollectTask record);

    int insertSelective(MobileCollectTask record);
}