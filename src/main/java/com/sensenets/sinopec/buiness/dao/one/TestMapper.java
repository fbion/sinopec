package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sensenets.sinopec.buiness.condition.TestCondition;
import com.sensenets.sinopec.buiness.model.one.Test;


@Mapper
public interface TestMapper {
    
    int deleteByPrimaryKey(@Param("id") Long id);

    int insert(Test record);

    Test selectByPrimaryKey(@Param("id") Long id);

    List<Test> selectAll();

    int updateByPrimaryKey(@Param("test")Test record);

    List<Test> selectPage(@Param("condition") TestCondition condition);

}