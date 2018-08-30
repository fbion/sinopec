package com.sensenets.sinopec.buiness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.dao.two.CollectResultFlowMapper;
import com.sensenets.sinopec.buiness.model.two.CollectResultFlow;
import com.sensenets.sinopec.buiness.model.two.CollectResultFlowCriteria;
import com.sensenets.sinopec.buiness.service.ICollectResultFlowService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CollectResultFlowServiceImpl implements ICollectResultFlowService {
    @Autowired
    private CollectResultFlowMapper collectResultFlowMapper;

    public int countByExample(CollectResultFlowCriteria example) {
        int count = this.collectResultFlowMapper.countByExample(example);
        log.debug("count: {}", count);
        return count;
    }

    public CollectResultFlow selectByPrimaryKey(Long id) {
        return this.collectResultFlowMapper.selectByPrimaryKey(id);
    }

    public List<CollectResultFlow> selectByExample(CollectResultFlowCriteria example) {
        return this.collectResultFlowMapper.selectByExample(example);
    }

    public PageInfo<CollectResultFlow> selectPageByExample(CollectResultFlowCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<CollectResultFlow> list = this.collectResultFlowMapper.selectByExample(example);
        PageInfo<CollectResultFlow> pageInfo = new PageInfo<CollectResultFlow>(list);
        return pageInfo;
    }

    public int deleteByPrimaryKey(Long id) {
        return this.collectResultFlowMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(CollectResultFlow record) {
        return this.collectResultFlowMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(CollectResultFlow record) {
        return this.collectResultFlowMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(CollectResultFlowCriteria example) {
        return this.collectResultFlowMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(CollectResultFlow record, CollectResultFlowCriteria example) {
        return this.collectResultFlowMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(CollectResultFlow record, CollectResultFlowCriteria example) {
        return this.collectResultFlowMapper.updateByExample(record, example);
    }

    public int insert(CollectResultFlow record) {
        return this.collectResultFlowMapper.insert(record);
    }

    public int insertSelective(CollectResultFlow record) {
        return this.collectResultFlowMapper.insertSelective(record);
    }
}