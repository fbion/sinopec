package com.sensenets.sinopec.buiness.service;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.model.one.Repos;
import com.sensenets.sinopec.buiness.model.one.ReposCriteria;
import java.util.List;

public interface IReposService {
    int countByExample(ReposCriteria example);

    Repos selectByPrimaryKey(String repoId);

    List<Repos> selectByExample(ReposCriteria example);

    PageInfo<Repos> selectPageByExample(ReposCriteria example);

    int deleteByPrimaryKey(String repoId);

    int updateByPrimaryKeySelective(Repos record);

    int updateByPrimaryKey(Repos record);

    int deleteByExample(ReposCriteria example);

    int updateByExampleSelective(Repos record, ReposCriteria example);

    int updateByExample(Repos record, ReposCriteria example);

    int insert(Repos record);

    int insertSelective(Repos record);
}