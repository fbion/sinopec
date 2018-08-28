package com.sensenets.sinopec.buiness.service;

import com.github.pagehelper.PageInfo;
import com.sensenets.sinopec.buiness.model.one.VjMobileCollectTaskView;
import com.sensenets.sinopec.buiness.model.one.VjMobileCollectTaskViewCriteria;
import java.util.List;

public interface IVjMobileCollectTaskViewService {
    int countByExample(VjMobileCollectTaskViewCriteria example);

    List<VjMobileCollectTaskView> selectByExample(VjMobileCollectTaskViewCriteria example);

    PageInfo<VjMobileCollectTaskView> selectPageByExample(VjMobileCollectTaskViewCriteria example);
}