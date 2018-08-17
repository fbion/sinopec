package com.sensenets.sinopec.buiness.service;


import java.util.List;

import com.sensenets.sinopec.buiness.model.VjUserLoginView;

 /**
  * @ClassName: VjUserLoginViewService
  * @Description: 用户登录视图业务层接口
  * @author think
  * @date 2018年08月16日 19:12:36
  */
public interface IVjUserLoginViewService {

    List<VjUserLoginView>  findForLogin(String username);

}


