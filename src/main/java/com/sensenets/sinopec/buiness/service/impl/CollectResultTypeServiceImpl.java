package com.sensenets.sinopec.buiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.dao.two.CollectResultTypeMapper;
import com.sensenets.sinopec.buiness.model.two.CollectResultType;
import com.sensenets.sinopec.buiness.model.two.CollectResultTypeCriteria;
import com.sensenets.sinopec.buiness.service.ICollectResultTypeService;
import com.sensenets.sinopec.common.enums.BizExceptionEnum;
import com.sensenets.sinopec.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CollectResultTypeServiceImpl implements ICollectResultTypeService {
    @Autowired
    private CollectResultTypeMapper collectResultTypeMapper;

    public int countByExample(CollectResultTypeCriteria example) {
        int count = this.collectResultTypeMapper.countByExample(example);
        log.debug("count: {}", count);
        return count;
    }

    public CollectResultType selectByPrimaryKey(Long id) {
        return this.collectResultTypeMapper.selectByPrimaryKey(id);
    }

    public List<CollectResultType> selectByExample(CollectResultTypeCriteria example) {
        return this.collectResultTypeMapper.selectByExample(example);
    }

    public PageInfo<CollectResultType> selectPageByExample(CollectResultTypeCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<CollectResultType> list = this.collectResultTypeMapper.selectByExample(example);
        PageInfo<CollectResultType> pageInfo = new PageInfo<CollectResultType>(list);
        return pageInfo;
    }

    public int deleteByPrimaryKey(Long id) {
        return this.collectResultTypeMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(CollectResultType record) {
        return this.collectResultTypeMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(CollectResultType record) {
        return this.collectResultTypeMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(CollectResultTypeCriteria example) {
        return this.collectResultTypeMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(CollectResultType record, CollectResultTypeCriteria example) {
        return this.collectResultTypeMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(CollectResultType record, CollectResultTypeCriteria example) {
        return this.collectResultTypeMapper.updateByExample(record, example);
    }

    public long insert(CollectResultType record) {
        int i = this.collectResultTypeMapper.insert(record);
        if(i>0){
            return record.getId();
        }else{
            throw new BusinessException(BizExceptionEnum.MOBILE_COLLECT_VEHCLE_INSERT_ERROR);
        }
    }

    public int insertSelective(CollectResultType record) {
        return this.collectResultTypeMapper.insertSelective(record);
    }
    
    
    @Override
    public List<CollectResultType> insertBatch(List<CollectResultType> records) {
        this.collectResultTypeMapper.insertBatch(records);
        return records;
    }
    
}

