package com.sensenets.sinopec.buiness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.condition.CommonCondition;
import com.sensenets.sinopec.buiness.condition.TestCondition;
import com.sensenets.sinopec.buiness.dao.TestMapper;
import com.sensenets.sinopec.buiness.model.Test;
import com.sensenets.sinopec.buiness.service.ITestService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName: TestServiceImpl
 * @Description: 测试业务层接口实现
 * @author think
 * @date 2018年08月07日 10:40:56
 */
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    TestMapper testDao;

    @Override
    public int save(Test record) {
        return testDao.insert(record);
    }

    @Override
    public boolean deleteById(Long id) {
        return testDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }

    @Override
    public int updateById(Test record) {
        return testDao.updateByPrimaryKey(record);
    }

    @Override
    public Test findById(Long id) {
        return testDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Test> findAll() {
        return testDao.selectAll();
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

        List<Test> list = testDao.selectPage(testCondition);
        PageInfo<Test> pageInfo = new PageInfo<Test>(list);
        return pageInfo;
    }

}
