package com.sensenets.sinopec.kafka.buffer.vehana;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sensenets.sinopec.buiness.model.two.VehicleQueue;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueAnalysis;
import com.sensenets.sinopec.buiness.model.two.VehicleQueueAnalysisCriteria;
import com.sensenets.sinopec.buiness.service.IVehicleQueueAnalysisService;
import com.sensenets.sinopec.common.enums.OilTypeEnum;
import com.sensenets.sinopec.common.utils.DateHelper;
import com.sensenets.sinopec.common.utils.JsonHelper;
import com.sensenets.sinopec.common.utils.UUIDHelper;


/**
  * @ClassName: VehicleQueueAnalysisCountService
  * @Description: 车辆排队分析
  * @author think
  * @date 2018年9月13日 下午6:29:38
  *
  */
@Component
public class VehicleQueueAnalysisCountService {
    /**
     * 日志
     */
    private final Logger logger = LoggerFactory.getLogger(VehicleQueueAnalysisCountService.class);

    private final Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

    /**
     * yyyyMMdd 仅用于删除之前日期的缓存数据,故只有日期
     */
    private  Set<Integer> cacheDateMap = new HashSet<Integer>();

    @Autowired
    private IVehicleQueueAnalysisService vehicleQueueAnalysisService;
    
    /**
      * @Fields cacheDayNum : 缓存天数(默认存放最近30天数据)
      */
    private static final int cacheDayNum = 30;

    /**
      * @Title: loadPersistenceData
      * @Description: 线程启动之前要做的第一件事, 加载已经持久化的当天数据
      */
    public void loadPersistenceData() {
        // 查询数据库中当天的抓拍统计数据
        final StringBuilder sBuffer = new StringBuilder();
        final StringBuilder sBuilder = new StringBuilder();
        // 查询需要缓存的数据
        final List<VehicleQueueAnalysis> list = this.selCurrDataInDB();
        // 缓存查询的数据结果
        this.cacheCurrDayData(sBuffer, sBuilder, list);
        // 设置缓存数据的日期,便于删除过期的缓存数据
        sBuffer.setLength(0);
        sBuffer.append("Cache Data Over!").append("at present cacheDate is ").append(JsonHelper.toJson(cacheDateMap));
        this.setCacheDataDate(sBuffer.toString(), sBuilder);
    }

    /**
     * 设置缓存数据日期
     *
     * @param logInfo
     *            日志信息
     * @param sBuilder
     *            已经被实例化的StringBuilder
     * @param sBuilder
     *            StringBuilder实例
     */
    private void setCacheDataDate(final String logInfo, final StringBuilder sBuilder) {
        // 设置缓存数据的日期
        Calendar calendar = Calendar.getInstance();
        sBuilder.setLength(0);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        sBuilder.append(calendar.get(Calendar.YEAR)).append(month < 10 ? ("0" + month) : month).append(dayOfMonth < 10 ? ("0" + dayOfMonth) : dayOfMonth);
        synchronized (VehicleQueueAnalysisCountService.class) {
            cacheDateMap.add(Integer.parseInt(sBuilder.toString()));
        }
        logger.debug(logInfo);
    }

    /**
     * 缓存当天所有相机的缓存数据
     *
     * @param sBuffer
     *            StringBuilder实例
     * @param sBuilder
     *            StringBuilder实例
     * @param list
     *            需要缓存的数据集合
     */
    private void cacheCurrDayData(final StringBuilder sBuffer, final StringBuilder sBuilder, final List<VehicleQueueAnalysis> list) {
        // Clear map data
        cache.clear();
        // Cache data begin
        logger.debug("Cache data begin!");
        for (VehicleQueueAnalysis st : list) {
            cacheDateMap.add(st.getDataDay());
            sBuffer.setLength(0);
            sBuffer.append(st.getDataDay()).append("@").append(st.getOilType())
              .append("@").append(st.getReposId()).append("@").append(st.getVehicleType());
            String identity = sBuffer.toString();
            // 缓存 天  ,油品类型,油站id 值yyyyMMdd@oilType@reposId@vehicleType:true
            cache.put(identity, true);
            sBuffer.setLength(0);
            sBuffer.append(identity).append("@time5");
            // yyyyMMdd@oilType@reposId@time5:time5
            cache.put(sBuffer.toString(), st.getTime5());

            sBuffer.setLength(0);
            sBuffer.append(identity).append("@time10");
            // yyyyMMdd@oilType@reposId@time10:time10
            cache.put(sBuffer.toString(), st.getTime10());
            
            sBuffer.setLength(0);
            sBuffer.append(identity).append("@time15");
            // yyyyMMdd@oilType@reposId@time15:time15
            cache.put(sBuffer.toString(), st.getTime15());
            
            sBuffer.setLength(0);
            sBuffer.append(identity).append("@time20");
            // yyyyMMdd@oilType@reposId@time20:time20
            cache.put(sBuffer.toString(), st.getTime20());
            
            sBuffer.setLength(0);
            sBuffer.append(identity).append("@time25");
            // yyyyMMdd@oilType@reposId@time25:time25
            cache.put(sBuffer.toString(), st.getTime25());
        } // for
          // Cache Data Over!
        logger.debug("Cache data is " + cache);
    }

    /**
     * 缓存当天的缓存数据
     *
     * @param sBuffer
     *            StringBuilder实例
     * @param sBuilder
     *            StringBuilder实例
     * @param list
     *            需要缓存的数据集合
     */
    private void cacheCurrDayData(final StringBuilder sBuffer, final StringBuilder sBuilder, final VehicleQueueAnalysis ve) {
        // Cache data begin
        logger.debug("Cache data begin!");
        sBuffer.setLength(0);
        sBuffer.append(ve.getDataDay()).append("@").append(ve.getOilType()).append("@")
                .append(ve.getReposId()).append("@").append(ve.getVehicleType());
        String identity = sBuffer.toString();
        // 缓存 天  ,油品类型,油站id 值yyyyMMdd@oilType@reposId:true
        if (cache.containsKey(identity)) {
            // Clear map curr day data
            for (Map.Entry<String, Object> entry : cache.entrySet()) {
                String key = entry.getKey().toString();
                if (key.startsWith(identity)) {
                    cache.remove(key);
                }
            }
        }
        cacheDateMap.add(ve.getDataDay());
        cache.put(identity, true);
        
        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time5");
        // yyyyMMdd@oilType@reposId@time5:time5
        cache.put(sBuffer.toString(), ve.getTime5());

        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time10");
        // yyyyMMdd@oilType@reposId@time10:time10
        cache.put(sBuffer.toString(), ve.getTime10());
        
        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time15");
        // yyyyMMdd@oilType@reposId@time15:time15
        cache.put(sBuffer.toString(), ve.getTime15());
        
        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time20");
        // yyyyMMdd@oilType@reposId@time20:time20
        cache.put(sBuffer.toString(), ve.getTime20());
        
        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time25");
        // yyyyMMdd@oilType@reposId@time25:time25
        cache.put(sBuffer.toString(), ve.getTime25());
        // Cache Data Over!
        logger.debug("Cache data is " + cache);
    }


    /**
     * 查询数据库中当前已有入库的数据
     * @param sBuffer
     *            StringBuilder实例
     * @param sBuilder
     *            StringBuilder实例
     * @return list 需要缓存的数据集合
     */
    private List<VehicleQueueAnalysis> selCurrDataInDB() {
        final List<VehicleQueueAnalysis> list = new ArrayList<VehicleQueueAnalysis>();
        VehicleQueueAnalysisCriteria criExa =  new VehicleQueueAnalysisCriteria();
        criExa.setDistinct(true);
        VehicleQueueAnalysisCriteria.Criteria  cri = criExa.createCriteria();
        Date curDate = new Date();
        // 缓存最近30天的数据
        String dataDay = DateHelper.date2String(curDate, DateHelper.FORMAT_6);
        String dataDay30 =DateHelper.dateAddDay(curDate, DateHelper.FORMAT_6, -cacheDayNum);
        cri.andDataDayLessThanOrEqualTo(Integer.parseInt(dataDay));
        cri.andDataDayGreaterThanOrEqualTo(Integer.parseInt(dataDay30));
        List<VehicleQueueAnalysis> anaList =  vehicleQueueAnalysisService.selectByExample(criExa);
        if(CollectionUtils.isNotEmpty(anaList)){
            list.addAll(anaList);
        }
        return list;
    }
    

    /**
     * 查询数据库中当前已有入库的数据
     * @param sBuffer
     *            StringBuilder实例
     * @param sBuilder
     *            StringBuilder实例
     * @return list 需要缓存的数据集合
     */
    private List<VehicleQueueAnalysis> selCurrDataInDB(VehicleQueueAnalysis queue) {
        final List<VehicleQueueAnalysis> list = new ArrayList<VehicleQueueAnalysis>();
        VehicleQueueAnalysisCriteria criExa =  new VehicleQueueAnalysisCriteria();
        criExa.setDistinct(true);
        VehicleQueueAnalysisCriteria.Criteria  cri = criExa.createCriteria();
        cri.andDataDayEqualTo(queue.getDataDay());
        cri.andOilTypeEqualTo(queue.getOilType());
        cri.andReposIdEqualTo(queue.getReposId());
        cri.andVehicleTypeEqualTo(queue.getVehicleType());
        List<VehicleQueueAnalysis> anaList =  vehicleQueueAnalysisService.selectByExample(criExa);
        if(CollectionUtils.isNotEmpty(anaList)){
            list.addAll(anaList);
        }
        return list;
    }

    /**
     * @param st
     * @Description: 每次持久化数据的时候更新本缓存数据(不需要考虑系统重启之后当天数据异常, 在系统重之时会先加载数据库中数据)
     * @Title: updateCache
     */
    private int updateCache(VehicleQueueAnalysis ve) {
        int result = -1;
        StringBuilder sBuffer = new StringBuilder();
        StringBuilder sBuilder = new StringBuilder();
        sBuffer.setLength(0);
        sBuffer.append(ve.getDataDay()).append("@").append(ve.getOilType()).append("@")
        .append(ve.getReposId()).append("@").append(ve.getVehicleType());
        cacheDateMap.add(ve.getDataDay());
        // 缓存 天  ,油品类型,油站id 值yyyyMMdd@oilType@reposId:true
        String identity = sBuffer.toString();
        boolean existCurrData = false;
        if (null != cache.get(identity)) {
            logger.debug("{} exist.", identity);
            existCurrData = true;
        } else {
            // 如果不存在则去数据库中查询记录，如果存在则更新否则插入
            List<VehicleQueueAnalysis> list = this.selCurrDataInDB(ve);
            if (CollectionUtils.isNotEmpty(list)) {
                VehicleQueueAnalysis any = list.get(0);
                // 存在则缓存数据
                cacheCurrDayData(sBuffer, sBuilder, any);
                existCurrData = true;
            }
        }
        if (existCurrData) {
            // update data
            result = this.updateCurrRecordData(ve, sBuffer, sBuilder, identity);
        } else {
            // insert data
            result = this.insertCurrRecordData(ve, sBuffer, sBuilder, identity);
        }
        return result;
    }

    /**
     * 插入当前记录(日期_cameraId)的数据记录(以前不存在,第一次插入,之后更新)
     *
     * @param st
     * @param sBuffer
     *            StringBuilder实例
     * @param sBuilder
     *            StringBuilder实例
     * @param identity
     *            每一天记录的唯一标识符
     * @return 更新数据记录条数
     */
    private int insertCurrRecordData(VehicleQueueAnalysis ve, StringBuilder sBuffer, StringBuilder sBuilder, String identity) {
        int result = -1;
        cache.put(identity, true);
        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time5");
        // yyyyMMdd@oilType@reposId@time5:time5
        cache.put(sBuffer.toString(), ve.getTime5());

        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time10");
        // yyyyMMdd@oilType@reposId@time10:time10
        cache.put(sBuffer.toString(), ve.getTime10());
        
        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time15");
        // yyyyMMdd@oilType@reposId@time15:time15
        cache.put(sBuffer.toString(), ve.getTime15());
        
        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time20");
        // yyyyMMdd@oilType@reposId@time20:time20
        cache.put(sBuffer.toString(), ve.getTime20());
        
        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time25");
        // yyyyMMdd@oilType@reposId@time25:time25
        cache.put(sBuffer.toString(), ve.getTime25());
        
        // insert data
        try {// 插入记录异常,原因是因为已经有
            result = vehicleQueueAnalysisService.insert(ve);
        } catch (Exception e) {
            logger.error("insertCurrRecordData", e);
        }
        // 更新缓存数据的日期
        sBuffer.setLength(0);
        sBuffer.append("insert data, update cacheDate. ").append(ve.getDataDay());
        this.setCacheDataDate(sBuffer.toString(), sBuilder);
        return result;
    }

    /**
     * 更新指定标识记录的数据
     *
     * @param st
     *            统计数据封装对象
     * @param sBuffer
     *            StringBuilder 实例
     * @param sBuilder
     *            StringBuilder 实例
     * @param identity
     *            记录唯一标识符
     * @return 数据库更新记录数
     */
    private int updateCurrRecordData(VehicleQueueAnalysis ve, StringBuilder sBuffer, StringBuilder sBuilder, String identity) {
        int result = -1;
        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time5");
        // yyyyMMdd@oilType@reposId@time5:time5
        String time5 = sBuffer.toString();
        cache.put(sBuffer.toString(), ve.getTime5()+(Long) cache.get(sBuffer.toString()));

        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time10");
        // yyyyMMdd@oilType@reposId@time10:time10
        String time10 = sBuffer.toString();
        cache.put(sBuffer.toString(), ve.getTime10()+(Long) cache.get(sBuffer.toString()));
        
        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time15");
        // yyyyMMdd@oilType@reposId@time15:time15
        String time15 = sBuffer.toString();
        cache.put(sBuffer.toString(), ve.getTime15()+(Long) cache.get(sBuffer.toString()));
        
        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time20");
        // yyyyMMdd@oilType@reposId@time20:time20
        String time20 = sBuffer.toString();
        cache.put(sBuffer.toString(), ve.getTime20()+(Long) cache.get(sBuffer.toString()));
        
        sBuffer.setLength(0);
        sBuffer.append(identity).append("@time25");
        // yyyyMMdd@oilType@reposId@time25:time25
        String time25 = sBuffer.toString();
        cache.put(sBuffer.toString(), ve.getTime25()+(Long) cache.get(sBuffer.toString()));
        // update data
        logger.debug(sBuilder.toString());
        try {
            VehicleQueueAnalysis any  = new VehicleQueueAnalysis();
            any.setTime5((Long)cache.get(time5));
            any.setTime10((Long)cache.get(time10));
            any.setTime15((Long)cache.get(time15));
            any.setTime20((Long)cache.get(time20));
            any.setTime25((Long)cache.get(time25));
            VehicleQueueAnalysisCriteria criExa =  new VehicleQueueAnalysisCriteria();
            criExa.setDistinct(true);
            VehicleQueueAnalysisCriteria.Criteria  cri = criExa.createCriteria();
            cri.andDataDayEqualTo(ve.getDataDay());
            cri.andOilTypeEqualTo(ve.getOilType());
            cri.andReposIdEqualTo(ve.getReposId());
            cri.andVehicleTypeEqualTo(ve.getVehicleType());
            result = vehicleQueueAnalysisService.updateByExampleSelective(any, criExa);
        } catch (Exception e) {
            logger.error("updateCurrRecordData", e);
        }
        return result;
    }

    /**
     * @param calendar
     *            Calendar实例
     * @param sBuilder
     *            StringBuilder实例
     * @Description: 删除过期的缓存数据, 节约资源, 释放内存
     * @Title: deleteExpriedCache
     */
    private void deleteExpriedCache(Calendar calendar, StringBuilder sBuilder) {
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        sBuilder.setLength(0);
        sBuilder.append(calendar.get(Calendar.YEAR)).append(month < 10 ? ("0" + month) : month).append(dayOfMonth < 10 ? ("0" + dayOfMonth) : dayOfMonth);
        // 存在过期数据因为 map数据量大于30
        if (CollectionUtils.isNotEmpty(cacheDateMap)&&cacheDateMap.size()>cacheDayNum) {
            Date date = DateHelper.string2Date(sBuilder.toString(), DateHelper.FORMAT_6);
            Date dateBefore = DateHelper.dateAddDay(date,-cacheDayNum);
            synchronized (VehicleQueueAnalysisCountService.class) {
                // 获取过期的缓存日期
                Map<String,String> map = new HashMap<String,String>();
                for(Integer day:cacheDateMap){
                    if(dateBefore.getTime()>DateHelper.string2Date(String.valueOf(day), DateHelper.FORMAT_6).getTime()){
                        map.put(String.valueOf(day),String.valueOf(day));
                    }
                }
                for (String key : cache.keySet()) {
                    for(String expireDate: map.keySet()){
                        if (key.startsWith(expireDate)) {
                            logger.debug("Delete expried cache key is {}", key);
                            cache.remove(key);
                        }
                    }
                }
            }
        }
    }

    public int persitVehicleQueueAnalysis(List<VehicleQueue> infos) {
        int result = -1;
        if (null == infos) {
            logger.debug("Persistent data is null.");
            return result;
        }
        long start = System.currentTimeMillis();
        StringBuilder sBuilder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        // 删除最近30天之前的所有缓存数据
        this.deleteExpriedCache(calendar, sBuilder);
        // 按oilType和reposId和vehicleType的形式分类数据
        Set<String> oilTypeSet = this.getOilTypeSet(infos);
        Set<String> reposIdSet = this.getReposIdSet(infos);
        Set<String> vehicleTypeSet = this.getVehicleTypeSet(infos);
        Map<String, List<VehicleQueue>> map = this.groupDataByOilTypeAndReposIdAndVehicleType(infos, oilTypeSet, reposIdSet,vehicleTypeSet);
        result = 0;
        for (Entry<String, List<VehicleQueue>> entry : map.entrySet()) {
            List<VehicleQueue> lst = entry.getValue();
            Map<String, VehicleQueueAnalysis> smap = new HashMap<String, VehicleQueueAnalysis>(lst.size());
            try {
                for (VehicleQueue queue : lst) {
                    VehicleQueueAnalysis any = smap.get(entry.getKey());
                    if (any == null) {
                        any = new VehicleQueueAnalysis();
                        String[] temp = StringUtils.split(entry.getKey(), "@");
                        String oilType = temp[0];
                        String reposId = temp[1];
                        String vehicleType = temp[2];
                        any.setDataHour(0);
                        any.setBizId(UUIDHelper.genUUID(false));
                        String d = DateHelper.date2String(queue.getInTime(), DateHelper.FORMAT_6);
                        any.setDataDay(Integer.parseInt(d));
                        any.setReposId(reposId);
                        any.setVehicleType(Short.parseShort(vehicleType));
                        any.setOilType(String.valueOf(OilTypeEnum.getTypeByCode(oilType)));
                        any.setUts(new Date());
                        smap.put(entry.getKey(), any);
                    }
                    // 统计数据的时间点不对
                    long inTime = DateHelper.string2Date(DateHelper.date2String(queue.getInTime(), DateHelper.FORMAT_6),  DateHelper.FORMAT_6).getTime();
                    long curDateBefore =  DateHelper.dateAddDay(DateHelper.string2Date(sBuilder.toString(), DateHelper.FORMAT_6),-cacheDayNum).getTime();
                    if (curDateBefore > inTime) {
                        logger.error("Capture time anomaly. inTime={}", inTime);
                        continue;
                    }
                    if(queue.getQueueTime()>=0&&queue.getQueueTime()<5*60*1000){
                        any.setTime5(any.getTime5()+1L);
                    }else if(queue.getQueueTime()>=5*60*1000&&queue.getQueueTime()<10*60*1000){
                        any.setTime10(any.getTime10()+1L);
                    }else if(queue.getQueueTime()>=10*60*1000&&queue.getQueueTime()<15*60*1000){
                        any.setTime15(any.getTime15()+1L);
                    }else if(queue.getQueueTime()>=15*60*1000&&queue.getQueueTime()<20*60*1000){
                        any.setTime20(any.getTime20()+1L);
                    }else if(queue.getQueueTime()>=20*60*1000){
                        any.setTime25(any.getTime25()+1L);
                    }
                }
            } catch (Exception e) {
                logger.error("persitVehicleQueueAnalysis", e);
            }
            if(MapUtils.isNotEmpty(smap)){
                for (Map.Entry<String, VehicleQueueAnalysis> ent : smap.entrySet()) {
                    updateCache(ent.getValue());
                }
            }
            result++;
        }
        logger.debug("----persist total time----{}----data size {}", (System.currentTimeMillis() - start), infos.size());
        return result;
    }


    /**
      * @Title: groupDataByOilTypeAndReposIdAndVehicleType
      * @Description: 将要处理的数据按照油品类型和油站Id和车辆类型分组存储
      * @param infos
      * @param oilTypeSet
      * @param reposIdSet
      * @param vehicleTypeSet
      * @return 分组好了的数据集合
      */
    private Map<String, List<VehicleQueue>> groupDataByOilTypeAndReposIdAndVehicleType(List<VehicleQueue> infos, Set<String> oilTypeSet, Set<String> reposIdSet, Set<String> vehicleTypeSet) {
        Map<String, List<VehicleQueue>> map = new HashMap<String, List<VehicleQueue>>();
        for (String oilType : oilTypeSet) {
            for (String reposId : reposIdSet) {
                for (String vehicleType : vehicleTypeSet) {
                    List<VehicleQueue> list = new ArrayList<VehicleQueue>();
                    for (VehicleQueue queue : infos) {
                        if (oilType.equals(String.valueOf(queue.getOilType())) && reposId.equals(String.valueOf(queue.getReposId()))&& vehicleType.equals(String.valueOf(queue.getInTypeId()))) {
                            list.add(queue);
                        }
                    }
                    map.put(String.format("%s@%s@%s", oilType, reposId,vehicleType), list);
                }
            }
        }
        return map;
    }

    /**
     * 整理要处理的数据为那几个油品类型的数据
     *
     * @param infos
     *            要处理的数据集合
     * @return 油品类型的集合
     */
    private Set<String> getOilTypeSet(List<VehicleQueue> infos) {
        // 多少个cameraId的数据
        Set<String> set = new HashSet<String>();
        for (VehicleQueue fr : infos) {
            set.add(String.valueOf(fr.getOilType()));
        }
        return set;
    }

    /**
     * 整理要处理的数据为那几个油站的数据
     *
     * @param infos
     *            要处理的数据集合
     * @return 油站id的集合
     */
    private Set<String> getReposIdSet(List<VehicleQueue> infos) {
        // 多少个cameraId的数据
        Set<String> set = new HashSet<String>();
        for (VehicleQueue fr : infos) {
            set.add(String.valueOf(fr.getReposId()));
        }
        return set;
    }
 

    /**
     * 整理要处理的数据为那几个车辆类型的数据
     *
     * @param infos
     *            要处理的数据集合
     * @return 车辆类型的集合
     */
    private Set<String> getVehicleTypeSet(List<VehicleQueue> infos) {
        Set<String> set = new HashSet<String>();
        for (VehicleQueue fr : infos) {
            set.add(String.valueOf(fr.getInTypeId()));
        }
        return set;
    }
   

}
