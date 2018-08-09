package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.condition.TestCondition;
import com.sensenets.sinopec.buiness.model.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface TestMapper {
    
    int deleteByPrimaryKey(@Param("id") Long id);

    int insert(@Param("test")Test record);

    Test selectByPrimaryKey(@Param("id") Long id);

    List<Test> selectAll();

    int updateByPrimaryKey(@Param("test")Test record);

    List<Test> selectPage(@Param("condition") TestCondition condition);

}