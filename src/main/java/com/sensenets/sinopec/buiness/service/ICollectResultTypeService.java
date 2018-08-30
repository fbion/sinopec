package com.sensenets.sinopec.buiness.service;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.model.two.CollectResultType;
import com.sensenets.sinopec.buiness.model.two.CollectResultTypeCriteria;
import java.util.List;

public interface ICollectResultTypeService {
    int countByExample(CollectResultTypeCriteria example);

    CollectResultType selectByPrimaryKey(Long id);

    List<CollectResultType> selectByExample(CollectResultTypeCriteria example);

    PageInfo<CollectResultType> selectPageByExample(CollectResultTypeCriteria example);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CollectResultType record);

    int updateByPrimaryKey(CollectResultType record);

    int deleteByExample(CollectResultTypeCriteria example);

    int updateByExampleSelective(CollectResultType record, CollectResultTypeCriteria example);

    int updateByExample(CollectResultType record, CollectResultTypeCriteria example);

    int insert(CollectResultType record);

    int insertSelective(CollectResultType record);
}