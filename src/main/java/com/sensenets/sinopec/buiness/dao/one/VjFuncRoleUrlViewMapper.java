/**
  * VjFuncRoleUrlViewMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-17
  */
package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import com.sensenets.sinopec.buiness.model.one.VjFuncRoleUrlView;

public interface VjFuncRoleUrlViewMapper {

    /**
     * :vj_func_role_url_view
     */
    List<VjFuncRoleUrlView> selectAll();
}