package com.sensenets.sinopec.buiness.test.service;

import java.util.List;

import com.sensenets.sinopec.persistence.model.Test;

/**
  * @ClassName: TestService
  * @Description: 测试业务层接口
  * @author think
  * @date 2018年08月06日 16:42:59
  */
public interface ITestService {
    
    List<Test> findAll();

}
