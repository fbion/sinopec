/**
  * CollectResultTypeMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-29
  */
package com.sensenets.sinopec.buiness.dao.two;

import com.sensenets.sinopec.buiness.model.two.CollectResultType;
import com.sensenets.sinopec.buiness.model.two.CollectResultTypeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectResultTypeMapper {
    /**
     *  根据指定的条件获取数据库记录数:public.collect_result_type
     *
     * @param example
     */
    int countByExample(CollectResultTypeCriteria example);

    /**
     *  根据指定的条件删除数据库符合条件的记录:public.collect_result_type
     *
     * @param example
     */
    int deleteByExample(CollectResultTypeCriteria example);

    /**
     *  根据主键删除数据库的记录:public.collect_result_type
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录:public.collect_result_type
     *
     * @param record
     */
    int insert(CollectResultType record);

    /**
     *  动态字段,写入数据库记录:public.collect_result_type
     *
     * @param record
     */
    int insertSelective(CollectResultType record);

    /**
     *  根据指定的条件查询符合条件的数据库记录:public.collect_result_type
     *
     * @param example
     */
    List<CollectResultType> selectByExample(CollectResultTypeCriteria example);

    /**
     *  根据指定主键获取一条数据库记录:public.collect_result_type
     *
     * @param id
     */
    CollectResultType selectByPrimaryKey(Long id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录:public.collect_result_type
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") CollectResultType record, @Param("example") CollectResultTypeCriteria example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录:public.collect_result_type
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") CollectResultType record, @Param("example") CollectResultTypeCriteria example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:public.collect_result_type
     *
     * @param record
     */
    int updateByPrimaryKeySelective(CollectResultType record);

    /**
     *  根据主键来更新符合条件的数据库记录:public.collect_result_type
     *
     * @param record
     */
    int updateByPrimaryKey(CollectResultType record);
}