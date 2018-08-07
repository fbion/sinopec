package com.sensenets.sinopec.buiness.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sensenets.sinopec.buiness.model.Test;


@Mapper
public interface TestMapper {
    
    int deleteByPrimaryKey(@Param("id") Long id);

    int insert(@Param("test")Test record);

    Test selectByPrimaryKey(@Param("id") Long id);

    List<Test> selectAll();

    int updateByPrimaryKey(@Param("test")Test record);
}