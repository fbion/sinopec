package com.sensenets.sinopec.buiness.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.condition.CommonCondition;
import com.sensenets.sinopec.buiness.condition.TestCondition;
import com.sensenets.sinopec.buiness.dao.one.TestMapper;
import com.sensenets.sinopec.buiness.dao.two.OrgMapper;
import com.sensenets.sinopec.buiness.model.one.Test;
import com.sensenets.sinopec.buiness.model.two.Org;
import com.sensenets.sinopec.buiness.service.ITestService;
import com.sensenets.sinopec.common.utils.DateHelper;

/**
 * @ClassName: TestServiceImpl
 * @Description: 测试业务层接口实现
 * @author think
 * @date 2018年08月07日 10:40:56
 */
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    TestMapper testMapper;
    
    @Autowired
    OrgMapper orgMapper;
    

    @Override
    public int save(Test record) {
        Test test  = new Test();
        test.setName("222");
        test.setUts(DateHelper.getTimestampFormat0());
        int  t1 = testMapper.insert(test);
        Org org  = new Org();
        org.setName("12131");
        org.setUts(DateHelper.getTimestampFormat0());
        int  t2 = orgMapper.insert(org);
        return t1+t2;
    }
    

    @Override
    public boolean deleteById(Long id) {
        return testMapper.deleteByPrimaryKey(id) > 0 ? true : false;
    }

    @Override
    public int updateById(Test record) {
        return testMapper.updateByPrimaryKey(record);
    }

    @Override
    public Test findById(Long id) {
        return testMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Test> findAll() {
        return testMapper.selectAll();
    }

    @Override
    public PageInfo<Test> findPage(CommonCondition condition) {
        PageHelper.startPage(condition.getPageNumber(), condition.getPageSize());
        TestCondition testCondition = (TestCondition) condition;
        if (StringUtils.isNotBlank(testCondition.getEndTime())) {
            testCondition.setGenEndTime(Timestamp.valueOf(testCondition.getEndTime()));
        }
        if (StringUtils.isNotBlank(testCondition.getStartTime())) {
            testCondition.setGenStartTime(Timestamp.valueOf(testCondition.getStartTime()));
        }

        List<Test> list = testMapper.selectPage(testCondition);
        PageInfo<Test> pageInfo = new PageInfo<Test>(list);
        return pageInfo;
    }

}
