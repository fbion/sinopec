/**
  * CollectResultFlowMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-31
  */
package com.sensenets.sinopec.buiness.dao.two;

import com.sensenets.sinopec.buiness.model.two.CollectResultFlow;
import com.sensenets.sinopec.buiness.model.two.CollectResultFlowCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectResultFlowMapper {
    /**
     *  根据指定的条件获取数据库记录数:public.collect_result_flow
     *
     * @param example
     */
    int countByExample(CollectResultFlowCriteria example);

    /**
     *  根据指定的条件删除数据库符合条件的记录:public.collect_result_flow
     *
     * @param example
     */
    int deleteByExample(CollectResultFlowCriteria example);

    /**
     *  根据主键删除数据库的记录:public.collect_result_flow
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录:public.collect_result_flow
     *
     * @param record
     */
    int insert(CollectResultFlow record);
    
    /**
     *  新写入数据库记录:public.collect_result_flow
     *
     * @param record
     */
    int insertBatch(@Param("list")List<CollectResultFlow> list);

    /**
     *  动态字段,写入数据库记录:public.collect_result_flow
     *
     * @param record
     */
    int insertSelective(CollectResultFlow record);

    /**
     *  根据指定的条件查询符合条件的数据库记录:public.collect_result_flow
     *
     * @param example
     */
    List<CollectResultFlow> selectByExample(CollectResultFlowCriteria example);

    /**
     *  根据指定主键获取一条数据库记录:public.collect_result_flow
     *
     * @param id
     */
    CollectResultFlow selectByPrimaryKey(Long id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录:public.collect_result_flow
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") CollectResultFlow record, @Param("example") CollectResultFlowCriteria example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录:public.collect_result_flow
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") CollectResultFlow record, @Param("example") CollectResultFlowCriteria example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:public.collect_result_flow
     *
     * @param record
     */
    int updateByPrimaryKeySelective(CollectResultFlow record);

    /**
     *  根据主键来更新符合条件的数据库记录:public.collect_result_flow
     *
     * @param record
     */
    int updateByPrimaryKey(CollectResultFlow record);
}