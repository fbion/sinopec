package com.sensenets.sinopec.buiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.dao.one.VjMobileCollectTaskViewMapper;
import com.sensenets.sinopec.buiness.model.one.VjMobileCollectTaskView;
import com.sensenets.sinopec.buiness.model.one.VjMobileCollectTaskViewCriteria;
import com.sensenets.sinopec.buiness.service.IVjMobileCollectTaskViewService;

@Service
public class VjMobileCollectTaskViewServiceImpl implements IVjMobileCollectTaskViewService {
    @Autowired
    private VjMobileCollectTaskViewMapper vjMobileCollectTaskViewMapper;

    public int countByExample(VjMobileCollectTaskViewCriteria example) {
        int count = this.vjMobileCollectTaskViewMapper.countByExample(example);
        return count;
    }

    public List<VjMobileCollectTaskView> selectByExample(VjMobileCollectTaskViewCriteria example) {
        return this.vjMobileCollectTaskViewMapper.selectByExample(example);
    }

    public PageInfo<VjMobileCollectTaskView> selectPageByExample(VjMobileCollectTaskViewCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<VjMobileCollectTaskView> list = this.vjMobileCollectTaskViewMapper.selectByExample(example);
        PageInfo<VjMobileCollectTaskView> pageInfo = new PageInfo<VjMobileCollectTaskView>(list);
        return pageInfo;
    }
}