/**
  * TasksMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import com.sensenets.sinopec.buiness.model.one.Tasks;

public interface TasksMapper {
    /**
     *  根据主键删除数据库的记录:tasks
     *
     * @param taskId
     */
    int deleteByPrimaryKey(String taskId);

    /**
     *  新写入数据库记录:tasks
     *
     * @param record
     */
    int insert(Tasks record);

    /**
     *  根据指定主键获取一条数据库记录:tasks
     *
     * @param taskId
     */
    Tasks selectByPrimaryKey(String taskId);

    /**
     * :tasks
     */
    List<Tasks> selectAll();

    /**
     *  根据主键来更新符合条件的数据库记录:tasks
     *
     * @param record
     */
    int updateByPrimaryKey(Tasks record);
}