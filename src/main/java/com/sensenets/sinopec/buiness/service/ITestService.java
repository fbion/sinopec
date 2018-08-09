package com.sensenets.sinopec.buiness.service;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.condition.CommonCondition;
import com.sensenets.sinopec.buiness.model.Test;

import java.util.List;

/**
  * @ClassName: TestService
  * @Description: 测试业务层接口
  * @author think
  * @date 2018年08月07日 10:40:56
  */
public interface ITestService {
    
    Test findById(Long id);

    boolean deleteById(Long id);
    
    int updateById(Test record);
    
    int save(Test record);
    
    List<Test> findAll();

    PageInfo<Test> findPage(CommonCondition condition);

    
}
