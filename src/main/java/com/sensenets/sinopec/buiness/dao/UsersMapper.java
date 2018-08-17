/**
  * UsersMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.model.Users;
import java.util.List;

public interface UsersMapper {
    /**
     *  根据主键删除数据库的记录:users
     *
     * @param userId
     */
    int deleteByPrimaryKey(String userId);

    /**
     *  新写入数据库记录:users
     *
     * @param record
     */
    int insert(Users record);

    /**
     *  根据指定主键获取一条数据库记录:users
     *
     * @param userId
     */
    Users selectByPrimaryKey(String userId);

    /**
     * :users
     */
    List<Users> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:users
     *
     * @param record
     */
    int updateByPrimaryKey(Users record);
}