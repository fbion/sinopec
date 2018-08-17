/**
  * VjFuncRoleUrlViewMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-17
  */
package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.model.VjFuncRoleUrlView;
import java.util.List;

public interface VjFuncRoleUrlViewMapper {

    /**
     * :vj_func_role_url_view
     */
    List<VjFuncRoleUrlView> selectAll();
}