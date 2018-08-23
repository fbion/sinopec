/**
  * VjUserLoginViewMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import com.sensenets.sinopec.buiness.model.one.VjUserLoginView;

public interface VjUserLoginViewMapper {
  
    /**
      * @Title: selectByUserInfo
      * @Description: 根据登录信息查询用户
      * @param record
      * @return
      */
    List<VjUserLoginView> selectByUserInfo(VjUserLoginView record);

}