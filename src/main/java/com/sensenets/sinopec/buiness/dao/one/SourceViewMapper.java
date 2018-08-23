/**
  * SourceViewMapper.java
  * Copyright(C) 2017-2018 
  * @date 2018-08-16
  */
package com.sensenets.sinopec.buiness.dao.one;

import java.util.List;

import com.sensenets.sinopec.buiness.model.one.SourceView;

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