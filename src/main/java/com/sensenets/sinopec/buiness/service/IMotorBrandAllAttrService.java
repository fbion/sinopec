package com.sensenets.sinopec.buiness.service;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.model.one.MotorBrandAllAttr;
import com.sensenets.sinopec.buiness.model.one.MotorBrandAllAttrCriteria;
import java.util.List;

public interface IMotorBrandAllAttrService {
    int countByExample(MotorBrandAllAttrCriteria example);

    MotorBrandAllAttr selectByPrimaryKey(Long id);

    List<MotorBrandAllAttr> selectByExample(MotorBrandAllAttrCriteria example);

    PageInfo<MotorBrandAllAttr> selectPageByExample(MotorBrandAllAttrCriteria example);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MotorBrandAllAttr record);

    int updateByPrimaryKey(MotorBrandAllAttr record);

    int deleteByExample(MotorBrandAllAttrCriteria example);

    int updateByExampleSelective(MotorBrandAllAttr record, MotorBrandAllAttrCriteria example);

    int updateByExample(MotorBrandAllAttr record, MotorBrandAllAttrCriteria example);

    int insert(MotorBrandAllAttr record);

    int insertSelective(MotorBrandAllAttr record);
}