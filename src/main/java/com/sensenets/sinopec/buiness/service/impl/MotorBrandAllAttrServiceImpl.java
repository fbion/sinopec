package com.sensenets.sinopec.buiness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.dao.one.MotorBrandAllAttrMapper;
import com.sensenets.sinopec.buiness.model.one.MotorBrandAllAttr;
import com.sensenets.sinopec.buiness.model.one.MotorBrandAllAttrCriteria;
import com.sensenets.sinopec.buiness.service.IMotorBrandAllAttrService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MotorBrandAllAttrServiceImpl implements IMotorBrandAllAttrService {
    @Autowired
    private MotorBrandAllAttrMapper motorBrandAllAttrMapper;

    public int countByExample(MotorBrandAllAttrCriteria example) {
        int count = this.motorBrandAllAttrMapper.countByExample(example);
        log.debug("count: {}", count);
        return count;
    }

    public MotorBrandAllAttr selectByPrimaryKey(Long id) {
        return this.motorBrandAllAttrMapper.selectByPrimaryKey(id);
    }

    public List<MotorBrandAllAttr> selectByExample(MotorBrandAllAttrCriteria example) {
        return this.motorBrandAllAttrMapper.selectByExample(example);
    }

    public PageInfo<MotorBrandAllAttr> selectPageByExample(MotorBrandAllAttrCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<MotorBrandAllAttr> list = this.motorBrandAllAttrMapper.selectByExample(example);
        PageInfo<MotorBrandAllAttr> pageInfo = new PageInfo<MotorBrandAllAttr>(list);
        return pageInfo;
    }

    public int deleteByPrimaryKey(Long id) {
        return this.motorBrandAllAttrMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(MotorBrandAllAttr record) {
        return this.motorBrandAllAttrMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MotorBrandAllAttr record) {
        return this.motorBrandAllAttrMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(MotorBrandAllAttrCriteria example) {
        return this.motorBrandAllAttrMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(MotorBrandAllAttr record, MotorBrandAllAttrCriteria example) {
        return this.motorBrandAllAttrMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(MotorBrandAllAttr record, MotorBrandAllAttrCriteria example) {
        return this.motorBrandAllAttrMapper.updateByExample(record, example);
    }

    public int insert(MotorBrandAllAttr record) {
        return this.motorBrandAllAttrMapper.insert(record);
    }

    public int insertSelective(MotorBrandAllAttr record) {
        return this.motorBrandAllAttrMapper.insertSelective(record);
    }
}