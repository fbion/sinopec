package com.sensenets.sinopec.buiness.service;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.model.two.OilEventInfo;
import com.sensenets.sinopec.buiness.model.two.OilEventInfoCriteria;
import java.util.List;

public interface IOilEventInfoService {
    int countByExample(OilEventInfoCriteria example);

    OilEventInfo selectByPrimaryKey(Long id);

    List<OilEventInfo> selectByExample(OilEventInfoCriteria example);

    PageInfo<OilEventInfo> selectPageByExample(OilEventInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OilEventInfo record);

    int updateByPrimaryKey(OilEventInfo record);

    int deleteByExample(OilEventInfoCriteria example);

    int updateByExampleSelective(OilEventInfo record, OilEventInfoCriteria example);

    int updateByExample(OilEventInfo record, OilEventInfoCriteria example);

    int insert(OilEventInfo record);

    int insertSelective(OilEventInfo record);
}