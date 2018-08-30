/**
  * MobileCollectTaskMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-28
  */
package com.sensenets.sinopec.buiness.dao.one;

import com.sensenets.sinopec.buiness.model.one.MobileCollectTask;
import com.sensenets.sinopec.buiness.model.one.MobileCollectTaskCriteria;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileCollectTaskMapper extends IMapper<MobileCollectTask, MobileCollectTaskCriteria, Long> {
   
    /**
      * @Title: updateBatchStatusByPrimaryKey
      * @Description: 批量更新删除状态
      * @param ids
      * @param status
      * @return
      */
    int updateBatchStatusByPrimaryKey(@Param("ids")List<Long> ids,@Param("status")Short status);
    
    
}