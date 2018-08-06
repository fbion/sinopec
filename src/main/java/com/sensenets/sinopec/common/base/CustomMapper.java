package com.sensenets.sinopec.common.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


/**
  * @ClassName: CustomMapper
  * @Description: 自定义Mapper
  * @author think
  * @date 2018年8月5日 下午11:35:35
  *
  * @param <T>
  */
public interface CustomMapper<T> extends Mapper<T>,MySqlMapper<T>{

}
