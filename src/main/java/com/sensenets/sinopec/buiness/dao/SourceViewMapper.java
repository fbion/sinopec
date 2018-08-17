/**
  * SourceViewMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao;

import com.sensenets.sinopec.buiness.model.SourceView;
import java.util.List;

public interface SourceViewMapper {
    /**
     *  新写入数据库记录:source_view
     *
     * @param record
     */
    int insert(SourceView record);

    /**
     * :source_view
     */
    List<SourceView> selectAll();
}