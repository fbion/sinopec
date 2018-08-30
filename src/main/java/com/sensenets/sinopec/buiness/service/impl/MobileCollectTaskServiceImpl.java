package com.sensenets.sinopec.buiness.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sensenets.sinopec.buiness.dao.one.MobileCollectTaskMapper;
import com.sensenets.sinopec.buiness.dao.one.ReposMapper;
import com.sensenets.sinopec.buiness.dao.one.VjMobileCollectTaskViewMapper;
import com.sensenets.sinopec.buiness.dto.MobileCollectTaskDto;
import com.sensenets.sinopec.buiness.dto.RepoIdDto;
import com.sensenets.sinopec.buiness.model.one.MobileCollectTask;
import com.sensenets.sinopec.buiness.model.one.MobileCollectTaskCriteria;
import com.sensenets.sinopec.buiness.model.one.Repos;
import com.sensenets.sinopec.buiness.model.one.ReposCriteria;
import com.sensenets.sinopec.buiness.model.one.VjMobileCollectTaskView;
import com.sensenets.sinopec.buiness.model.one.VjMobileCollectTaskViewCriteria;
import com.sensenets.sinopec.buiness.service.IMobileCollectTaskService;
import com.sensenets.sinopec.common.utils.JsonHelper;

import io.jsonwebtoken.lang.Collections;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MobileCollectTaskServiceImpl implements IMobileCollectTaskService {

    @Autowired
    private MobileCollectTaskMapper mobileCollectTaskMapper;

    @Autowired
    private VjMobileCollectTaskViewMapper vjMobileCollectTaskViewMapper;

    @Autowired
    private ReposMapper reposMapper;

    public int countByExample(MobileCollectTaskCriteria example) {
        int count = this.mobileCollectTaskMapper.countByExample(example);
        return count;
    }

    public MobileCollectTask selectByPrimaryKey(Long id) {
        return this.mobileCollectTaskMapper.selectByPrimaryKey(id);
    }

    public List<MobileCollectTask> selectByExample(MobileCollectTaskCriteria example) {
        return this.mobileCollectTaskMapper.selectByExample(example);
    }

    public PageInfo<MobileCollectTaskDto> selectPageByExample(VjMobileCollectTaskViewCriteria example) {
        PageHelper.startPage(example.getPageNumber(), example.getPageSize());
        List<VjMobileCollectTaskView> list = this.vjMobileCollectTaskViewMapper.selectByExample(example);
        // 获取所有父节点的信息放入集合
        PageInfo<MobileCollectTaskDto> pageInfo = new PageInfo<MobileCollectTaskDto>(Lists.newArrayList());
        if (CollectionUtils.isNotEmpty(list)) {
            List<Long> pids = Lists.newArrayList();
            for (VjMobileCollectTaskView view : list) {
                if (ArrayUtils.isNotEmpty(view.getCollectRpath())) {
                    pids.addAll(Collections.arrayToList(view.getCollectRpath()));
                }
                if (ArrayUtils.isNotEmpty(view.getStationRpath())) {
                    pids.addAll(Collections.arrayToList(view.getStationRpath()));
                }
            }
            Set<Long> repoid = Sets.newHashSet();
            if (CollectionUtils.isNotEmpty(pids)) {
                for (Long id : pids) {
                    repoid.add(id);
                }
            }
            ReposCriteria parentEx = new ReposCriteria();
            ReposCriteria.Criteria reposCri = parentEx.createCriteria();
            reposCri.andIdIn(new ArrayList<Long>(repoid));
            List<Repos> parentList = reposMapper.selectByExample(parentEx);
            Map<Long, RepoIdDto> pMap = new HashMap<Long, RepoIdDto>();
            if (CollectionUtils.isNotEmpty(parentList)) {
                for (Repos p : parentList) {
                    pMap.put(p.getId(), new RepoIdDto(p.getId(),p.getRepoId(), p.getRepoName(),p.getRepoLevel()));
                }
            }
            List<MobileCollectTaskDto> pageList = Lists.newArrayList();
            for (VjMobileCollectTaskView view : list) {
                pageList.add(getDto(pMap, view));
            }
            pageInfo = new PageInfo<MobileCollectTaskDto>(pageList);
        }
        return pageInfo;
    }

    private MobileCollectTaskDto getDto(final Map<Long, RepoIdDto> pMap, final VjMobileCollectTaskView view) {
        Map<String, String> map = Maps.newHashMap();
        if (ArrayUtils.isNotEmpty(view.getCollectRpath()) && view.getCollectRpath().length >= 3) {
            int len = view.getCollectRpath().length;
            Long[] colletAry = view.getCollectRpath();
            // 采集站点信息
            map.put("collect_1", pMap.get(colletAry[len - 3]).getRepoName());
            map.put("collect_2", pMap.get(colletAry[len - 2]).getRepoName());
            map.put("collect_3", pMap.get(colletAry[len - 1]).getRepoName());
        } else {
            map.put("collect_1", "");
            map.put("collect_2", "");
            map.put("collect_3", "");
        }

        if (ArrayUtils.isNotEmpty(view.getStationRpath()) && view.getStationRpath().length >= 3) {
            int len = view.getStationRpath().length;
            Long[] colletAry = view.getStationRpath();
            // 采集站点信息
            map.put("station_1", pMap.get(colletAry[len - 3]).getRepoName());
            map.put("station_2", pMap.get(colletAry[len - 2]).getRepoName());
            map.put("station_3", pMap.get(colletAry[len - 1]).getRepoName());
           
        } else {
            map.put("station_1", "");
            map.put("station_2", "");
            map.put("station_3", "");
        }
        MobileCollectTaskDto dto = new MobileCollectTaskDto();
        
        dto.setCollectionRepoName(map.get("collect_3"));
        dto.setCollectRepoId(view.getCollectRepoId());
        dto.setCollectAeraName(map.get("collect_2"));
        dto.setCollectCityName(map.get("collect_1"));
        dto.setOilStationRepoName(map.get("station_3"));
        dto.setOilStationRepoId(view.getOilStationRepoId());
        dto.setOilStationManager(map.get("station_2"));
        dto.setOilStationCityName(map.get("station_1"));

        dto.setCollectStartTime(view.getCollectStartTime());
        dto.setCollectEndTime(view.getCollectEndTime());

        dto.setId(view.getId());
        dto.setTaskStatus(view.getTaskStatus());
        dto.setType(view.getType());
        dto.setUserId(view.getUserId());
        dto.setUts(view.getUts());
        
        if (ArrayUtils.isNotEmpty(view.getCollectRpath())) {
            String[] collectParents = new String[view.getCollectRpath().length];
            for(int i= 0;i<view.getCollectRpath().length;i++){
                collectParents[i] = pMap.get(view.getCollectRpath()[i]).getRepoId();
            }
            dto.setCollectParent(JsonHelper.toJson(collectParents));
        }
        if (ArrayUtils.isNotEmpty(view.getStationRpath())) {
            String[] oilStationParents = new String[view.getCollectRpath().length];
            for(int i= 0;i<view.getStationRpath().length;i++){
                oilStationParents[i] = pMap.get(view.getStationRpath()[i]).getRepoId();
            }
            dto.setOilStationParent(JsonHelper.toJson(oilStationParents));
        }
        return dto;
    }

    public int deleteByPrimaryKey(Long id) {
        return this.mobileCollectTaskMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(MobileCollectTask record) {
        return this.mobileCollectTaskMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MobileCollectTask record) {
        return this.mobileCollectTaskMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(MobileCollectTaskCriteria example) {
        return this.mobileCollectTaskMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(MobileCollectTask record, MobileCollectTaskCriteria example) {
        return this.mobileCollectTaskMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(MobileCollectTask record, MobileCollectTaskCriteria example) {
        return this.mobileCollectTaskMapper.updateByExample(record, example);
    }

    public int insert(MobileCollectTask record) {
        return this.mobileCollectTaskMapper.insert(record);
    }

    public int insertSelective(MobileCollectTask record) {
        return this.mobileCollectTaskMapper.insertSelective(record);
    }

    @Override
    public int updateBatchStatusByPrimaryKey(Short status, List<Long> ids) {
        return this.mobileCollectTaskMapper.updateBatchStatusByPrimaryKey(ids,status);
    }
}