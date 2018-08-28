/**
  * VjMobileCollectTaskViewMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-28
  */
package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import com.sensenets.sinopec.buiness.model.one.VjMobileCollectTaskView;
import com.sensenets.sinopec.buiness.model.one.VjMobileCollectTaskViewCriteria;

public interface VjMobileCollectTaskViewMapper {
    /**
     *  根据指定的条件获取数据库记录数:public.vj_mobile_collect_task_view
     *
     * @param example
     */
    int countByExample(VjMobileCollectTaskViewCriteria example);


    /**
     *  根据指定的条件查询符合条件的数据库记录:public.vj_mobile_collect_task_view
     *
     * @param example
     */
    List<VjMobileCollectTaskView> selectByExample(VjMobileCollectTaskViewCriteria example);

   
}