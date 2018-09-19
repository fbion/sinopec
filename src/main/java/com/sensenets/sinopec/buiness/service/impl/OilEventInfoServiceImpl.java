package com.sensenets.sinopec.buiness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.dao.two.OilEventInfoMapper;
import com.sensenets.sinopec.buiness.model.two.OilEventInfo;
import com.sensenets.sinopec.buiness.model.two.OilEventInfoCriteria;
import com.sensenets.sinopec.buiness.service.IOilEventInfoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OilEventInfoServiceImpl implements IOilEventInfoService {
    @Autowired
    private OilEventInfoMapper oilEventInfoMapper;

    public int countByExample(OilEventInfoCriteria example) {
        int count = this.oilEventInfoMapper.countByExample(example);
        log.debug("count: {}", count);
        return count;
    }

    public OilEventInfo selectByPrimaryKey(Long id) {
        return this.oilEventInfoMapper.selectByPrimaryKey(id);
    }

    public List<OilEventInfo> selectByExample(OilEventInfoCriteria example) {
        return this.oilEventInfoMapper.selectByExample(example);
    }

    public PageInfo<OilEventInfo> selectPageByExample(OilEventInfoCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<OilEventInfo> list = this.oilEventInfoMapper.selectByExample(example);
        PageInfo<OilEventInfo> pageInfo = new PageInfo<OilEventInfo>(list);
        return pageInfo;
    }

    public int deleteByPrimaryKey(Long id) {
        return this.oilEventInfoMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(OilEventInfo record) {
        return this.oilEventInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(OilEventInfo record) {
        return this.oilEventInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(OilEventInfoCriteria example) {
        return this.oilEventInfoMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(OilEventInfo record, OilEventInfoCriteria example) {
        return this.oilEventInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(OilEventInfo record, OilEventInfoCriteria example) {
        return this.oilEventInfoMapper.updateByExample(record, example);
    }

    public int insert(OilEventInfo record) {
        return this.oilEventInfoMapper.insert(record);
    }

    public int insertSelective(OilEventInfo record) {
        return this.oilEventInfoMapper.insertSelective(record);
    }
}