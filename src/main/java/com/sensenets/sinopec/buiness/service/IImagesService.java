package com.sensenets.sinopec.buiness.service;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.model.two.Images;
import com.sensenets.sinopec.buiness.model.two.ImagesCriteria;
import java.util.List;

public interface IImagesService {
    int countByExample(ImagesCriteria example);

    Images selectByPrimaryKey(String imageId);

    List<Images> selectByExample(ImagesCriteria example);

    PageInfo<Images> selectPageByExample(ImagesCriteria example);

    int deleteByPrimaryKey(String imageId);

    int updateByPrimaryKeySelective(Images record);

    int updateByPrimaryKey(Images record);

    int deleteByExample(ImagesCriteria example);

    int updateByExampleSelective(Images record, ImagesCriteria example);

    int updateByExample(Images record, ImagesCriteria example);

    int insert(Images record);

    int insertSelective(Images record);
}