package com.sensenets.sinopec.buiness.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.dao.two.ImagesMapper;
import com.sensenets.sinopec.buiness.model.two.Images;
import com.sensenets.sinopec.buiness.model.two.ImagesCriteria;
import com.sensenets.sinopec.buiness.service.IImagesService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImagesServiceImpl implements IImagesService {
    @Autowired
    private ImagesMapper imagesMapper;

    public int countByExample(ImagesCriteria example) {
        int count = this.imagesMapper.countByExample(example);
        log.debug("count: {}", count);
        return count;
    }

    public Images selectByPrimaryKey(String imageId) {
        return this.imagesMapper.selectByPrimaryKey(imageId);
    }

    public List<Images> selectByExample(ImagesCriteria example) {
        return this.imagesMapper.selectByExample(example);
    }

    public PageInfo<Images> selectPageByExample(ImagesCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<Images> list = this.imagesMapper.selectByExample(example);
        PageInfo<Images> pageInfo = new PageInfo<Images>(list);
        return pageInfo;
    }

    public int deleteByPrimaryKey(String imageId) {
        return this.imagesMapper.deleteByPrimaryKey(imageId);
    }

    public int updateByPrimaryKeySelective(Images record) {
        return this.imagesMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Images record) {
        return this.imagesMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(ImagesCriteria example) {
        return this.imagesMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Images record, ImagesCriteria example) {
        return this.imagesMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Images record, ImagesCriteria example) {
        return this.imagesMapper.updateByExample(record, example);
    }

    public int insert(Images record) {
        return this.imagesMapper.insert(record);
    }

    public int insertSelective(Images record) {
        return this.imagesMapper.insertSelective(record);
    }
}