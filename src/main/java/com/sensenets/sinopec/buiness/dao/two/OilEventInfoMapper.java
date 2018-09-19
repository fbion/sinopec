/**
  * OilEventInfoMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-18
  */
package com.sensenets.sinopec.buiness.dao.two;

import com.sensenets.sinopec.buiness.model.two.OilEventInfo;
import com.sensenets.sinopec.buiness.model.two.OilEventInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OilEventInfoMapper {
    /**
     *  根据指定的条件获取数据库记录数:public.oil_event_info
     *
     * @param example
     */
    int countByExample(OilEventInfoCriteria example);

    /**
     *  根据指定的条件删除数据库符合条件的记录:public.oil_event_info
     *
     * @param example
     */
    int deleteByExample(OilEventInfoCriteria example);

    /**
     *  根据主键删除数据库的记录:public.oil_event_info
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录:public.oil_event_info
     *
     * @param record
     */
    int insert(OilEventInfo record);

    /**
     *  动态字段,写入数据库记录:public.oil_event_info
     *
     * @param record
     */
    int insertSelective(OilEventInfo record);

    /**
     *  根据指定的条件查询符合条件的数据库记录:public.oil_event_info
     *
     * @param example
     */
    List<OilEventInfo> selectByExample(OilEventInfoCriteria example);

    /**
     *  根据指定主键获取一条数据库记录:public.oil_event_info
     *
     * @param id
     */
    OilEventInfo selectByPrimaryKey(Long id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录:public.oil_event_info
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") OilEventInfo record, @Param("example") OilEventInfoCriteria example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录:public.oil_event_info
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") OilEventInfo record, @Param("example") OilEventInfoCriteria example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:public.oil_event_info
     *
     * @param record
     */
    int updateByPrimaryKeySelective(OilEventInfo record);

    /**
     *  根据主键来更新符合条件的数据库记录:public.oil_event_info
     *
     * @param record
     */
    int updateByPrimaryKey(OilEventInfo record);
}