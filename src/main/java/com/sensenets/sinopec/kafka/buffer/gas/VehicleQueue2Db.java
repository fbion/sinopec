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
import com.sensenets.sinopec.common.enums.VehicleRecordTypeEnum;
import com.sensenets.sinopec.common.utils.BeanHelper;
import com.sensenets.sinopec.common.utils.DateHelper;
import com.sensenets.sinopec.common.utils.UUIDHelper;
import com.sensenets.sinopec.config.AppConfig;
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
                // 查找大于当前记录时间+50分钟和小于当前时间-50分钟的相同车牌号的相关车辆记录
                long startDate = sourceData.getTime().getTime() - config.getMatchVehicleQueue() * 60000;
                long endDate = sourceData.getTime().getTime() + config.getMatchVehicleQueue() * 60000;
                VehiclesCriteria veExa = new VehiclesCriteria();
                VehiclesCriteria.Criteria veCri = veExa.createCriteria();
                veCri.andPlateTextEqualTo(sourceData.getPlateText());
                veCri.andTsGreaterThanOrEqualTo(startDate);
                veCri.andTsLessThanOrEqualTo(endDate);
                List<Vehicles> veList = vehiclesService.selectByExample(veExa);
                if (CollectionUtils.isNotEmpty(veList)) {
                    List<VehicleSortObj> sortList = Lists.newArrayList();
                    // 与当前时间最接近的相同车牌的车辆记录进行关联
                    veList.forEach(veh -> {
                        VehicleSortObj obj = new VehicleSortObj();
                        BeanUtils.copyProperties(veh, obj);
                        VehicleRecordTypeEnum type = (veh.getTs() - sourceData.getTime().getTime()) > 0 ? VehicleRecordTypeEnum.Out : VehicleRecordTypeEnum.In;
                        obj.setTime(Math.abs(veh.getTs() - sourceData.getTime().getTime()));
                        obj.setType(type);
                        sortList.add(obj);
                    });
                    Collections.sort(sortList);
                    VehicleSortObj obj = sortList.get(0);
                    // 关联后插入新记录到车辆排队表
                    vehicleQueueService.insert(generateObjValue(sourceData, obj));
                    log.info("新增排队数据成功");
                }

            }
        }
    }

    private VehicleQueue generateObjValue(final VehicleQueueSourceData src, final VehicleSortObj obj) {
        VehicleQueue queue = new VehicleQueue();
        queue.setBizId(UUIDHelper.genUUID(false));
        queue.setReposId(src.getReposId());
        queue.setReposName(src.getReposName());
        queue.setOilType(src.getOilType());
        queue.setUts(new Date());
        queue.setQueueTime(Math.abs(src.getTime().getTime()-obj.getTs()));
        // 查询图片地址
        Images image = imagesService.selectByPrimaryKey(obj.getImageId());
        // 查询设备信息
        Sensors sensors = sensorsService.selectById(ConvertHelper.str2Long(obj.getSensorId()));
        if (obj.getType() == VehicleRecordTypeEnum.In) {
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
            queue.setOutTypeId(obj.getTypeId());
        } else if (obj.getType() == VehicleRecordTypeEnum.Out) {
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
            queue.setInTypeId(obj.getTypeId());
        }
        return queue;
    }

}
