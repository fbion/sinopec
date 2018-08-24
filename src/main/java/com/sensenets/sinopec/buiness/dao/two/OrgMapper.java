package com.sensenets.sinopec.buiness.dao.two;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sensenets.sinopec.buiness.condition.OrgCondition;
import com.sensenets.sinopec.buiness.model.two.Org;


@Mapper
public interface OrgMapper {
    
    int deleteByPrimaryKey(@Param("id") Long id);

    int insert(Org record);

    Org selectByPrimaryKey(@Param("id") Long id);

    List<Org> selectAll();

    int updateByPrimaryKey(@Param("org")Org record);

    List<Org> selectPage(@Param("condition") OrgCondition condition);

}