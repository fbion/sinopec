package com.sensenets.sinopec.buiness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.dao.one.ReposMapper;
import com.sensenets.sinopec.buiness.model.one.Repos;
import com.sensenets.sinopec.buiness.model.one.ReposCriteria;
import com.sensenets.sinopec.buiness.service.IReposService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReposServiceImpl implements IReposService {
    @Autowired
    private ReposMapper reposMapper;

    public int countByExample(ReposCriteria example) {
        int count = this.reposMapper.countByExample(example);
        return count;
    }

    public Repos selectByPrimaryKey(String repoId) {
        return this.reposMapper.selectByPrimaryKey(repoId);
    }

    public List<Repos> selectByExample(ReposCriteria example) {
        return this.reposMapper.selectByExample(example);
    }

    public PageInfo<Repos> selectPageByExample(ReposCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<Repos> list = this.reposMapper.selectByExample(example);
        PageInfo<Repos> pageInfo = new PageInfo<Repos>(list);
        return pageInfo;
    }

    public int deleteByPrimaryKey(String repoId) {
        return this.reposMapper.deleteByPrimaryKey(repoId);
    }

    public int updateByPrimaryKeySelective(Repos record) {
        return this.reposMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Repos record) {
        return this.reposMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(ReposCriteria example) {
        return this.reposMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Repos record, ReposCriteria example) {
        return this.reposMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Repos record, ReposCriteria example) {
        return this.reposMapper.updateByExample(record, example);
    }

    public int insert(Repos record) {
        return this.reposMapper.insert(record);
    }

    public int insertSelective(Repos record) {
        return this.reposMapper.insertSelective(record);
    }
}