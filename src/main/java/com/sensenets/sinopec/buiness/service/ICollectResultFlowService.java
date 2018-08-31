package com.sensenets.sinopec.buiness.service;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.model.two.CollectResultFlow;
import com.sensenets.sinopec.buiness.model.two.CollectResultFlowCriteria;
import java.util.List;

public interface ICollectResultFlowService {
    int countByExample(CollectResultFlowCriteria example);

    CollectResultFlow selectByPrimaryKey(Long id);

    List<CollectResultFlow> selectByExample(CollectResultFlowCriteria example);

    PageInfo<CollectResultFlow> selectPageByExample(CollectResultFlowCriteria example);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CollectResultFlow record);

    int updateByPrimaryKey(CollectResultFlow record);

    int deleteByExample(CollectResultFlowCriteria example);

    int updateByExampleSelective(CollectResultFlow record, CollectResultFlowCriteria example);

    int updateByExample(CollectResultFlow record, CollectResultFlowCriteria example);

    long insert(CollectResultFlow record);

    int insertSelective(CollectResultFlow record);
}