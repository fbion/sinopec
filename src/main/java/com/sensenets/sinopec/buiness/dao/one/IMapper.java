package com.sensenets.sinopec.buiness.dao.one;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 通用IMapper<M, E, ID>
 * M:实体类
 * E:Example
 * ID:主键的变量类型
 *
 * @author : think
 * @date :2018-08-28 12:24:39
 */
public interface IMapper<M, E, ID extends Serializable> {
    /**
     *  根据指定的条件获取数据库记录数:public.mobile_collect_task
     *
     * @param example
     */
    int countByExample(E example);

    /**
     *  根据指定的条件删除数据库符合条件的记录:public.mobile_collect_task
     *
     * @param example
     */
    int deleteByExample(E example);

    /**
     *  根据主键删除数据库的记录:public.mobile_collect_task
     *
     * @param id
     */
    int deleteByPrimaryKey(ID id);

    /**
     *  新写入数据库记录:public.mobile_collect_task
     *
     * @param record
     */
    int insert(M record);

    /**
     *  动态字段,写入数据库记录:public.mobile_collect_task
     *
     * @param record
     */
    int insertSelective(M record);

    /**
     * :public.mobile_collect_task
     *
     * @param record
     */
    int insertBatch(List<M> record);

    /**
     * :public.mobile_collect_task
     *
     * @param record
     */
    int insertBatchSelective(List<M> record);

    /**
     * :public.mobile_collect_task
     *
     * @param example
     */
    List<M> selectByExampleWithBLOBs(E example);

    /**
     *  根据指定的条件查询符合条件的数据库记录:public.mobile_collect_task
     *
     * @param example
     */
    List<M> selectByExample(E example);

    /**
     *  根据指定主键获取一条数据库记录:public.mobile_collect_task
     *
     * @param id
     */
    M selectByPrimaryKey(ID id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:public.mobile_collect_task
     *
     * @param record
     */
    int updateByPrimaryKeySelective(M record);

    /**
     * :public.mobile_collect_task
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(M record);

    /**
     *  根据主键来更新符合条件的数据库记录:public.mobile_collect_task
     *
     * @param record
     */
    int updateByPrimaryKey(M record);

    /**
     *  根据指定的条件来更新符合条件的数据库记录:public.mobile_collect_task
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") M record, @Param("example") E example);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录:public.mobile_collect_task
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") M record, @Param("example") E example);

    /**
     * :public.mobile_collect_task
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") M record, @Param("example") E example);

    /**
     * :public.mobile_collect_task
     *
     * @param record
     */
    int updateBatchByPrimaryKey(List<M> record);

    /**
     * :public.mobile_collect_task
     *
     * @param record
     */
    int updateBatchByPrimaryKeySelective(List<M> record);

    /**
     * :public.mobile_collect_task
     *
     * @param record
     * @param example
     */
    int updateBatchByExampleSelective(@Param("recordList") List<M> record, @Param("example") E example);

    /**
     * :public.mobile_collect_task
     *
     * @param record
     * @param example
     */
    int updateBatchByExample(@Param("recordList") List<M> record, @Param("example") E example);
}