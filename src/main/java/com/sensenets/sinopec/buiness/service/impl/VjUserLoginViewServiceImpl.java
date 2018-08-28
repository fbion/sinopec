package com.sensenets.sinopec.buiness.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensenets.sinopec.buiness.dao.one.VjUserLoginViewMapper;
import com.sensenets.sinopec.buiness.model.one.VjUserLoginView;
import com.sensenets.sinopec.buiness.service.IVjUserLoginViewService;

import lombok.extern.slf4j.Slf4j;

 /**
  * @ClassName: VjUserLoginViewServiceImpl
  * @Description: 用户登录视图业务层接口实现
  * @author think
  * @date 2018年08月16日 19:12:36
  */
@Service
@Slf4j
public class VjUserLoginViewServiceImpl implements IVjUserLoginViewService {

    @Autowired
    VjUserLoginViewMapper vjUserLoginViewDao;

    @Override
    public List<VjUserLoginView> findForLogin(String username){
        VjUserLoginView view = new VjUserLoginView();
        view.setUserName(username);
        List<VjUserLoginView> reView = vjUserLoginViewDao.selectByUserInfo(view);
        return reView;
    }

   

}
