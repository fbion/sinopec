package com.sensenets.sinopec.buiness.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.condition.CommonCondition;
import com.sensenets.sinopec.buiness.model.two.Org;

/**
  * @ClassName: OrgService
  * @Description: 测试业务层接口
  * @author think
  * @date 2018年08月07日 10:40:56
  */
public interface IOrgService {
    
    Org findById(Long id);

    boolean deleteById(Long id);
    
    int updateById(Org record);
    
    int save(Org record);
    
    List<Org> findAll();

    PageInfo<Org> findPage(CommonCondition condition);

    
}
