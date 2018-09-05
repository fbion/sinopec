/**
  * ImagesMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-09-05
  */
package com.sensenets.sinopec.buiness.dao.two;

import com.sensenets.sinopec.buiness.model.two.Images;
import com.sensenets.sinopec.buiness.model.two.ImagesCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImagesMapper {
    /**
     *  根据指定的条件获取数据库记录数:public.images
     *
     * @param example
     */
    int countByExample(ImagesCriteria example);

    /**
     *  根据指定的条件删除数据库符合条件的记录:public.images
     *
     * @param example
     */
    int deleteByExample(ImagesCriteria example);

    /**
     *  根据主键删除数据库的记录:public.images
     *
     * @param imageId
     */
    int deleteByPrimaryKey(String imageId);

    /**
     *  新写入数据库记录:public.images
     *
     * @param record
     */
    int insert(Images record);

    /**
     *  动态字段,写入数据库记录:public.images
     *
     * @param record
     */
    int insertSelective(Images record);

    /**
     *  根据指定的条件查询符合条件的数据库记录:public.images
     *
     * @param example
     */
    List<Images> selectByExample(ImagesCriteria example);

    /**
     *  根据指定主键获取一条数据库记录:public.images
     *
     * @param imageId
     */
    Images selectByPrimaryKey(String imageId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录:public.images
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Images record, @Param("example") ImagesCriteria example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录:public.images
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Images record, @Param("example") ImagesCriteria example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:public.images
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Images record);

    /**
     *  根据主键来更新符合条件的数据库记录:public.images
     *
     * @param record
     */
    int updateByPrimaryKey(Images record);
}