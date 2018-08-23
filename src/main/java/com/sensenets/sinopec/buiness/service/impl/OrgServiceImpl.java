package com.sensenets.sinopec.buiness.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.condition.CommonCondition;
import com.sensenets.sinopec.buiness.condition.OrgCondition;
import com.sensenets.sinopec.buiness.dao.two.OrgMapper;
import com.sensenets.sinopec.buiness.model.two.Org;
import com.sensenets.sinopec.buiness.service.IOrgService;

/**
 * @ClassName: OrgServiceImpl
 * @Description: 测试业务层接口实现
 * @author think
 * @date 2018年08月07日 10:40:56
 */
@Service
public class OrgServiceImpl implements IOrgService {

    @Autowired
    OrgMapper orgDao;

    @Override
    public int save(Org record) {
        return orgDao.insert(record);
    }

    @Override
    public boolean deleteById(Long id) {
        return orgDao.deleteByPrimaryKey(id) > 0 ? true : false;
    }

    @Override
    public int updateById(Org record) {
        return orgDao.updateByPrimaryKey(record);
    }

    @Override
    public Org findById(Long id) {
        return orgDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Org> findAll() {
        return orgDao.selectAll();
    }

    @Override
    public PageInfo<Org> findPage(CommonCondition condition) {
        PageHelper.startPage(condition.getPageNumber(), condition.getPageSize());
        OrgCondition testCondition = (OrgCondition) condition;
        if (StringUtils.isNotBlank(testCondition.getEndTime())) {
            testCondition.setGenEndTime(Timestamp.valueOf(testCondition.getEndTime()));
        }
        if (StringUtils.isNotBlank(testCondition.getStartTime())) {
            testCondition.setGenStartTime(Timestamp.valueOf(testCondition.getStartTime()));
        }

        List<Org> list = orgDao.selectPage(testCondition);
        PageInfo<Org> pageInfo = new PageInfo<Org>(list);
        return pageInfo;
    }

}
