package com.sensenets.sinopec.kafka.buffer.gas;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

import com.google.common.collect.Lists;
import com.sensenets.sinopec.buiness.model.one.Sensors;
import com.sensenets.sinopec.buiness.model.two.Images;
import com.sensenets.sinopec.buiness.model.two.VehicleQueue;
import com.sensenets.sinopec.buiness.model.two.Vehicles;
import com.sensenets.sinopec.buiness.model.two.VehiclesCriteria;
import com.sensenets.sinopec.buiness.service.IImagesService;
import com.sensenets.sinopec.buiness.service.ISensorsService;
import com.sensenets.sinopec.buiness.service.IVehicleQueueService;
import com.sensenets.sinopec.buiness.service.IVehiclesService;
import com.sensenets.sinopec.common.enums.SensorGroupEnum;
import com.sensenets.sinopec.common.enums.VehicleRecordTypeEnum;
import com.sensenets.sinopec.common.utils.BeanHelper;
import com.sensenets.sinopec.common.utils.DateHelper;
import com.sensenets.sinopec.common.utils.UUIDHelper;
import com.sensenets.sinopec.config.AppConfig;
import com.sensenets.sinopec.kafka.buffer.vehana.VehicleQueueAnalysisConsumer;
import com.sensenets.sinopec.kafka.common.Common2KafkaTemplate;
import com.sensenets.sinopec.kafka.common.ConvertHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VehicleQueue2Db extends Common2KafkaTemplate implements Runnable {

    private VehicleQueueDataDto motor;

    private IVehicleQueueService vehicleQueueService;

    private IVehiclesService vehiclesService;

    private ISensorsService sensorsService;

    private IImagesService imagesService;

    private AppConfig config;

    public VehicleQueue2Db(VehicleQueueDataDto motor) {
        this.motor = motor;
        config = BeanHelper.getBean(AppConfig.class);
        vehicleQueueService = BeanHelper.getBean(IVehicleQueueService.class);
        vehiclesService = BeanHelper.getBean(IVehiclesService.class);
        sensorsService = BeanHelper.getBean(ISensorsService.class);
        imagesService = BeanHelper.getBean(IImagesService.class);
    }

    @Override
    public void run() {
        if (motor == null || CollectionUtils.isEmpty(motor.getList())) {
            return;
        }
        log.info("获取到排队数据");
        if (CollectionUtils.isNotEmpty(motor.getList())) {
            // 持久化到数据库，需要将该条记录与进出站记录匹配
            for (VehicleQueueSourceData sourceData : motor.getList()) {
                Vehicles vehs = getMatchVehicle(sourceData);
                short type = 0;
                // 根据设备id确定是进站记录还是出站记录
                Sensors sensors = sensorsService.selectById(sourceData.getSensorId());
                if (sensors != null) {
                    type = sensors.getGroupType();
                }
                // 查找大于当前记录时间+50分钟和小于当前时间-50分钟的相同车牌号的相关车辆记录
                VehicleQueueTimeDto timeDto = getMatchTime(type, sourceData);
                
                VehiclesCriteria veExa = new VehiclesCriteria();
                VehiclesCriteria.Criteria veCri = veExa.createCriteria();
                veCri.andPlateTextEqualTo(sourceData.getPlateText());
                veCri.andRepoIdEqualTo(String.valueOf(sourceData.getReposId()));
                veCri.andTsGreaterThanOrEqualTo(timeDto.getStartTime());
                veCri.andTsLessThanOrEqualTo(timeDto.getEndTime());
                
                List<Vehicles> veList = vehiclesService.selectByExample(veExa);
                if (CollectionUtils.isNotEmpty(veList)) {
                    // 与当前时间最接近的相同车牌的车辆记录进行关联
                    List<VehicleSortObj> inList = Lists.newArrayList();
                    List<VehicleSortObj> outList = Lists.newArrayList();
                    for (Vehicles veh : veList) {
                        Sensors veSensors = sensorsService.selectById(ConvertHelper.str2Long(veh.getSensorId()));
                        VehicleSortObj obj = new VehicleSortObj();
                        BeanUtils.copyProperties(veh, obj);
                        obj.setTime(Math.abs(veh.getTs() - timeDto.getMatchTime()));
                        if (veSensors != null) {
                            if (veSensors.getGroupType() == SensorGroupEnum.sensor_come.getCode()) {
                                obj.setType(VehicleRecordTypeEnum.In);
                                inList.add(obj);
                            } else if (veSensors.getGroupType() == SensorGroupEnum.sensor_exit.getCode()) {
                                obj.setType(VehicleRecordTypeEnum.Out);
                                outList.add(obj);
                            }
                        }
                    }
                    Collections.sort(inList);
                    Collections.sort(outList);
                    if (type == SensorGroupEnum.sensor_come.getCode()) {
                        if (CollectionUtils.isEmpty(outList)) {
                            return;
                        }
                        VehicleSortObj outObj = outList.get(0);
                        VehicleQueue queue = generateObjValueByInObj(vehs,sourceData, outObj);
                        vehicleQueueService.insert(queue);
                        log.info("新增排队数据成功");
                        // 新增排队数据成功后，将记录id返回进行排队统计分析
                        VehicleQueueAnalysisConsumer.add(queue);
                    } else if (type == SensorGroupEnum.sensor_exit.getCode()) {
                        if (CollectionUtils.isEmpty(inList)) {
                            return;
                        }
                        VehicleSortObj inObj = inList.get(0);
                        VehicleQueue queue = generateObjValueByOutObj(vehs,sourceData, inObj);
                        vehicleQueueService.insert(queue);
                        log.info("新增排队数据成功");
                        // 新增排队数据成功后，将记录id返回进行排队统计分析
                        VehicleQueueAnalysisConsumer.add(queue);
                    } else if (type == SensorGroupEnum.sensor_oil.getCode()) {
                        if (CollectionUtils.isEmpty(inList) || CollectionUtils.isEmpty(outList)) {
                            return;
                        }
                        VehicleSortObj inObj = inList.get(0);
                        VehicleSortObj outObj = outList.get(0);
                        VehicleQueue queue = generateObjValueByOilObj(sourceData, inObj, outObj);
                        vehicleQueueService.insert(queue);
                        log.info("新增排队数据成功");
                        // 新增排队数据成功后，将记录id返回进行排队统计分析
                        VehicleQueueAnalysisConsumer.add(queue);
                    }

                }else{
                    log.info("未找到车辆信息:"+sourceData.getPlateText()+" 过车时间:"+DateHelper.date2String(sourceData.getTime(), DateHelper.FORMAT_0)+" 时间戳:"+sourceData.getTs()+" 油站id:"+sourceData.getReposId());
                }

            }
        }
    }

    private Vehicles getMatchVehicle(final VehicleQueueSourceData sourceData){
        VehiclesCriteria vehExp = new VehiclesCriteria();
        VehiclesCriteria.Criteria cri = vehExp.createCriteria();
        cri.andTsEqualTo(sourceData.getTs());
        cri.andPlateTextEqualTo(sourceData.getPlateText());
        cri.andRepoIdEqualTo(ConvertHelper.long2Str(sourceData.getReposId()));
        List<Vehicles> veList = vehiclesService.selectByExample(vehExp);
        if(CollectionUtils.isNotEmpty(veList)){
            return veList.get(0);
        }else{
            return null;
        }
    }
    
    /**
     * @Title: generateObjValueByInObj
     * @Description: 根据进站记录关联出站记录
     * @param src
     *            原始进站记录
     * @param obj
     *            出站记录
     * @return 车辆排队记录
     */
    private VehicleQueue generateObjValueByInObj(final  Vehicles vehs , final VehicleQueueSourceData src, final VehicleSortObj obj) {
        VehicleQueue queue = new VehicleQueue();
        queue.setBizId(UUIDHelper.genUUID(false));
        queue.setReposId(src.getReposId());
        queue.setReposName(src.getReposName());
        queue.setOilType(src.getOilType());
        queue.setUts(new Date());
        // 排队时间= 进站时间-提枪时间
        queue.setQueueTime(Math.abs(src.getTs() - src.getLiftGunTime().getTime()));
        // 进出站时间= 进站时间-出站时间
        queue.setInOutTime(Math.abs(obj.getTs() - src.getTs()));
        // 查询图片地址
        Images image = imagesService.selectByPrimaryKey(obj.getImageId());
        // 查询设备信息
        Sensors sensors = sensorsService.selectById(ConvertHelper.str2Long(obj.getSensorId()));
        queue.setOutFeatureImage(image != null ? image.getThumbnailImageUri() : "暂无");
        queue.setOutSensorName(sensors != null ? sensors.getSensorName() : "未知");
        queue.setOutSourceImage(image != null ? image.getImageUri() : "暂无");
        queue.setOutAngleId(obj.getSide());
        queue.setOutBrandId(obj.getBrandId());
        queue.setOutColorId(obj.getColorId());
        queue.setOutModeYearId(obj.getModelYearId());
        queue.setOutPlateColorId(obj.getPlateColorId());
        queue.setOutPlateText(obj.getPlateText());
        queue.setOutPlateTypeId(obj.getPlateTypeId());
        queue.setOutSensorId(ConvertHelper.str2Long(obj.getSensorId()));
        queue.setOutSubBrandId(obj.getSubBrandId());
        queue.setOutTime(DateHelper.string2Date(DateHelper.long2DateStr(obj.getTs(), DateHelper.FORMAT_0), DateHelper.FORMAT_0));
        queue.setOutTypeId(obj.getTypeId());
        queue.setOutVehicleId(obj.getId());

        queue.setInFeatureImage(src.getFeatureImage());
        queue.setInSensorName(src.getSensorName());
        queue.setInSourceImage(src.getSourceImage());
        queue.setInAngleId(src.getAngleId());
        queue.setInBrandId(src.getBrandId());
        queue.setInColorId(src.getColorId());
        queue.setInModeYearId(src.getModeYearId());
        queue.setInPlateColorId(src.getPlateColorId());
        queue.setInPlateText(src.getPlateText());
        queue.setInPlateTypeId(src.getPlateTypeId());
        queue.setInSensorId(src.getSensorId());
        queue.setInSubBrandId(src.getSubBrandId());
        queue.setInTime(src.getTime());
        queue.setInTypeId(src.getTypeId());
        if(vehs!=null){
            queue.setInVehicleId(vehs.getId());
        }
        return queue;
    }

    /**
     * @Title: generateObjValueByInObj
     * @Description: 根据出站记录关联进站记录
     * @param src
     *            原始出站记录
     * @param obj
     *            进站记录
     * @return 车辆排队记录
     */
    private VehicleQueue generateObjValueByOutObj(final  Vehicles vehs ,final VehicleQueueSourceData src, final VehicleSortObj obj) {
        VehicleQueue queue = new VehicleQueue();
        queue.setBizId(UUIDHelper.genUUID(false));
        queue.setReposId(src.getReposId());
        queue.setReposName(src.getReposName());
        queue.setOilType(src.getOilType());
        queue.setUts(new Date());
        // 排队时间= 进站时间-提枪时间
        queue.setQueueTime(Math.abs(obj.getTs() - src.getLiftGunTime().getTime()));
        // 进出站时间= 进站时间-出站时间
        queue.setInOutTime(Math.abs(obj.getTs() - src.getTs()));
        // 查询图片地址
        Images image = imagesService.selectByPrimaryKey(obj.getImageId());
        // 查询设备信息
        Sensors sensors = sensorsService.selectById(ConvertHelper.str2Long(obj.getSensorId()));
        queue.setInFeatureImage(image != null ? image.getThumbnailImageUri() : "暂无");
        queue.setInSensorName(sensors != null ? sensors.getSensorName() : "未知");
        queue.setInSourceImage(image != null ? image.getImageUri() : "暂无");
        queue.setInAngleId(obj.getSide());
        queue.setInBrandId(obj.getBrandId());
        queue.setInColorId(obj.getColorId());
        queue.setInModeYearId(obj.getModelYearId());
        queue.setInPlateColorId(obj.getPlateColorId());
        queue.setInPlateText(obj.getPlateText());
        queue.setInPlateTypeId(obj.getPlateTypeId());
        queue.setInSensorId(ConvertHelper.str2Long(obj.getSensorId()));
        queue.setInSubBrandId(obj.getSubBrandId());
        queue.setInTime(DateHelper.string2Date(DateHelper.long2DateStr(obj.getTs(), DateHelper.FORMAT_0), DateHelper.FORMAT_0));
        queue.setInTypeId(obj.getTypeId());
        queue.setInVehicleId(obj.getId());
        
        queue.setOutFeatureImage(src.getFeatureImage());
        queue.setOutSensorName(src.getSensorName());
        queue.setOutSourceImage(src.getSourceImage());
        queue.setOutAngleId(src.getAngleId());
        queue.setOutBrandId(src.getBrandId());
        queue.setOutColorId(src.getColorId());
        queue.setOutModeYearId(src.getModeYearId());
        queue.setOutPlateColorId(src.getPlateColorId());
        queue.setOutPlateText(src.getPlateText());
        queue.setOutPlateTypeId(src.getPlateTypeId());
        queue.setOutSensorId(src.getSensorId());
        queue.setOutSubBrandId(src.getSubBrandId());
        queue.setOutTime(src.getTime());
        queue.setOutTypeId(src.getTypeId());
        if(vehs!=null){
            queue.setOutVehicleId(vehs.getId());
        }
        return queue;
    }

    /**
     * @Title: generateObjValueByOilObj
     * @Description: 根据加油记录关联进站记录和出站记录
     * @param src
     *            原始加油记录
     * @param inObj
     *            进站记录
     * @param outObj
     *            出站记录
     * @return 车辆排队记录
     */
    private VehicleQueue generateObjValueByOilObj(final VehicleQueueSourceData src, final VehicleSortObj inObj, final VehicleSortObj outObj) {
        VehicleQueue queue = new VehicleQueue();
        queue.setBizId(UUIDHelper.genUUID(false));
        queue.setReposId(src.getReposId());
        queue.setReposName(src.getReposName());
        queue.setOilType(src.getOilType());
        queue.setUts(new Date());
        // 排队时间= 进站时间-提枪时间
        queue.setQueueTime(Math.abs(inObj.getTs() - src.getLiftGunTime().getTime()));
        // 进出站时间= 进站时间-出站时间
        queue.setInOutTime(Math.abs(inObj.getTs() - outObj.getTs()));
        // 查询图片地址
        Images outImage = imagesService.selectByPrimaryKey(outObj.getImageId());
        // 查询设备信息
        Sensors outSensors = sensorsService.selectById(ConvertHelper.str2Long(outObj.getSensorId()));
        queue.setOutFeatureImage(outImage != null ? outImage.getThumbnailImageUri() : "暂无");
        queue.setOutSensorName(outSensors != null ? outSensors.getSensorName() : "未知");
        queue.setOutSourceImage(outImage != null ? outImage.getImageUri() : "暂无");
        queue.setOutAngleId(outObj.getSide());
        queue.setOutBrandId(outObj.getBrandId());
        queue.setOutColorId(outObj.getColorId());
        queue.setOutModeYearId(outObj.getModelYearId());
        queue.setOutPlateColorId(outObj.getPlateColorId());
        queue.setOutPlateText(outObj.getPlateText());
        queue.setOutPlateTypeId(outObj.getPlateTypeId());
        queue.setOutSensorId(ConvertHelper.str2Long(outObj.getSensorId()));
        queue.setOutSubBrandId(outObj.getSubBrandId());
        queue.setOutTime(DateHelper.string2Date(DateHelper.long2DateStr(outObj.getTs(), DateHelper.FORMAT_0), DateHelper.FORMAT_0));
        queue.setOutTypeId(outObj.getTypeId());
        queue.setOutVehicleId(outObj.getId());
        
        // 查询图片地址
        Images inImage = imagesService.selectByPrimaryKey(inObj.getImageId());
        // 查询设备信息
        Sensors inSensors = sensorsService.selectById(ConvertHelper.str2Long(inObj.getSensorId()));
        queue.setInFeatureImage(inImage != null ? inImage.getThumbnailImageUri() : "暂无");
        queue.setInSensorName(inSensors != null ? inSensors.getSensorName() : "未知");
        queue.setInSourceImage(inImage != null ? inImage.getImageUri() : "暂无");
        queue.setInAngleId(inObj.getSide());
        queue.setInBrandId(inObj.getBrandId());
        queue.setInColorId(inObj.getColorId());
        queue.setInModeYearId(inObj.getModelYearId());
        queue.setInPlateColorId(inObj.getPlateColorId());
        queue.setInPlateText(inObj.getPlateText());
        queue.setInPlateTypeId(inObj.getPlateTypeId());
        queue.setInSensorId(ConvertHelper.str2Long(inObj.getSensorId()));
        queue.setInSubBrandId(inObj.getSubBrandId());
        queue.setInTime(DateHelper.string2Date(DateHelper.long2DateStr(inObj.getTs(), DateHelper.FORMAT_0), DateHelper.FORMAT_0));
        queue.setInTypeId(inObj.getTypeId());
        queue.setInVehicleId(inObj.getId());
        return queue;
    }

    /**
     * @Title: getMatchTime
     * @Description: 获取匹配时间段
     * @param type
     *            设备类型
     * @param sourceData
     *            车辆记录
     * @return
     */
    private VehicleQueueTimeDto getMatchTime(final short type, final VehicleQueueSourceData sourceData) {
        Date time = null;
        long startDate = 0;
        long endDate = 0;
        if (type == SensorGroupEnum.sensor_come.getCode()) {
            if (sourceData.getHangGunTime() != null) {
                time = sourceData.getHangGunTime();
            } else if (sourceData.getLiftGunTime() != null) {
                time = sourceData.getLiftGunTime();
            }else{
                time = sourceData.getTime();
            }
        } else if (type == SensorGroupEnum.sensor_exit.getCode()) {
            if (sourceData.getLiftGunTime() != null) {
                time = sourceData.getLiftGunTime();
            } else if (sourceData.getHangGunTime() != null) {
                time = sourceData.getHangGunTime();
            }else{
                time = sourceData.getTime();
            }
        } else if (type == SensorGroupEnum.sensor_oil.getCode()) {
            if (sourceData.getLiftGunTime() != null) {
                time = sourceData.getLiftGunTime();
            } else if (sourceData.getHangGunTime() != null) {
                time = sourceData.getHangGunTime();
            }else{
                time = sourceData.getTime();
            }
        } else {
            time = sourceData.getTime();
        }
        startDate = time.getTime() - config.getMatchVehicleQueue() * 60000;
        endDate = time.getTime() + config.getMatchVehicleQueue() * 60000;

        return new VehicleQueueTimeDto(startDate, endDate, time.getTime());
    }

}
