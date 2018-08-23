package com.sensenets.sinopec.buiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensenets.sinopec.buiness.dao.one.VjFuncRoleUrlViewMapper;
import com.sensenets.sinopec.buiness.model.one.VjFuncRoleUrlView;
import com.sensenets.sinopec.buiness.service.IVjFuncRoleUrlViewService;

 /**
  * @ClassName: VjFuncRoleUrlViewServiceImpl
  * @Description: 功能权限视图业务层接口实现
  * @author think
  * @date 2018年08月17日 12:05:12
  */
@Service
public class VjFuncRoleUrlViewServiceImpl implements IVjFuncRoleUrlViewService {

    @Autowired
    VjFuncRoleUrlViewMapper vjFuncRoleUrlViewDao;

    @Override
    public List<VjFuncRoleUrlView> findAll() {
        return vjFuncRoleUrlViewDao.selectAll();
    }

 

}
