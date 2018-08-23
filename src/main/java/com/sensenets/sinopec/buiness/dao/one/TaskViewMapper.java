/**
  * TaskViewMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import com.sensenets.sinopec.buiness.model.one.TaskView;

public interface TaskViewMapper {
    /**
     *  新写入数据库记录:task_view
     *
     * @param record
     */
    int insert(TaskView record);

    /**
     * :task_view
     */
    List<TaskView> selectAll();
}