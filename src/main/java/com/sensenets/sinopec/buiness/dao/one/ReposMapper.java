/**
  * ReposMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-28
  */
package com.sensenets.sinopec.buiness.dao.one;

import com.sensenets.sinopec.buiness.model.one.Repos;
import com.sensenets.sinopec.buiness.model.one.ReposCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReposMapper {
    /**
     *  根据指定的条件获取数据库记录数:public.repos
     *
     * @param example
     */
    int countByExample(ReposCriteria example);

    /**
     *  根据指定的条件删除数据库符合条件的记录:public.repos
     *
     * @param example
     */
    int deleteByExample(ReposCriteria example);

    /**
     *  根据主键删除数据库的记录:public.repos
     *
     * @param repoId
     */
    int deleteByPrimaryKey(String repoId);

    /**
     *  新写入数据库记录:public.repos
     *
     * @param record
     */
    int insert(Repos record);

    /**
     *  动态字段,写入数据库记录:public.repos
     *
     * @param record
     */
    int insertSelective(Repos record);

    /**
     *  根据指定的条件查询符合条件的数据库记录:public.repos
     *
     * @param example
     */
    List<Repos> selectByExample(ReposCriteria example);

    /**
     *  根据指定主键获取一条数据库记录:public.repos
     *
     * @param repoId
     */
    Repos selectByPrimaryKey(String repoId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录:public.repos
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Repos record, @Param("example") ReposCriteria example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录:public.repos
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Repos record, @Param("example") ReposCriteria example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:public.repos
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Repos record);

    /**
     *  根据主键来更新符合条件的数据库记录:public.repos
     *
     * @param record
     */
    int updateByPrimaryKey(Repos record);
}