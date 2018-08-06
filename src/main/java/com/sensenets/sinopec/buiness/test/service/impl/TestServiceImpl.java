package com.sensenets.sinopec.buiness.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensenets.sinopec.buiness.test.service.ITestService;
import com.sensenets.sinopec.persistence.mapper.TestMapper;
import com.sensenets.sinopec.persistence.model.Test;

 /**
  * @ClassName: TestServiceImpl
  * @Description: 测试业务层接口实现
  * @author think
  * @date 2018年08月06日 16:42:59
  */
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    TestMapper  testMapper;
    
    @Override
    public List<Test> findAll(){
        return testMapper.selectAll();
    }
    

}
