package com.sensenets.sinopec.kafka.common;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sensenets.sinopec.common.utils.DateHelper;
import com.sensenets.sinopec.kafka.buffer.gas.VehicleQueueSourceData;

import dg.model.Common;
import dg.model.PimpOilEvent;
import dg.model.PimpRecObj;

/**
  * @ClassName: ReceiveDataConverter
  * @Description: 接收数据转换工具
  * @author think
  * @date 2018年9月10日 下午6:15:12
  *
  */
public class ReceiveDataConverter {

    protected static final Logger log = LoggerFactory.getLogger(ReceiveDataConverter.class);


    public VehicleQueueSourceData transformObj(final PimpRecObj.PetrolStationObj pimpObj) {
        VehicleQueueSourceData data = new VehicleQueueSourceData();
        try {
            PimpRecObj.PetrolVehicleObj vehicleObj = pimpObj.getVehicleObj();
            if(vehicleObj==null){
                return null;
            }
            // 车辆前端数据
            PimpRecObj.PetrolStationMetaObj meta = vehicleObj.getMetaVehicle();
            if(meta==null){
                return null;
            }
            // 元数据
            Common.SrcMetadata srcMeta = meta.getMetadata();
            if(srcMeta==null){
                return null;
            }
            PimpRecObj.PetrolStationVehicleObj ve = vehicleObj.getVehicle();
            if(ve==null){
                return null;
            }
            // 加油数据
            PimpOilEvent.OilEventWithPlate oilEvent = vehicleObj.getOilEventWithPlate();
            data.setBrandId(ConvertHelper.str2Short(ve.getVehicleBrand()));
            data.setFeatureImage(meta.getCutboardImage().getImg().getURI());
            // 车辆角度
            data.setAngleId(null);
            data.setColorId(ConvertHelper.str2Short(ve.getVehicleColor()));
            data.setModeYearId(ConvertHelper.str2Short(ve.getVehicleStyle()));
            data.setOilType(StringUtils.isNotBlank(oilEvent.getOilTypeNum())?oilEvent.getOilTypeNum():null);
            data.setPlateColorId(ConvertHelper.str2Short(ve.getVehiclePlateColor()));
            // 车牌号为空忽略
            if(StringUtils.isEmpty(ve.getVehiclePlate())||ve.getVehiclePlate().startsWith("-")){
                return null;
            }
            data.setPlateText(ve.getVehiclePlate());
            data.setPlateTypeId(ConvertHelper.str2Short(ve.getVehiclePlateTyle()));
            data.setReposId(ConvertHelper.int2Long(srcMeta.getRepoId()));
            data.setReposName(srcMeta.getRepoInfo());
            data.setSensorId(ConvertHelper.int2Long(srcMeta.getSensorId()));
            data.setSensorName(srcMeta.getSensorName());
            data.setSourceImage(meta.getOriginImage().getURI());
            data.setSubBrandId(ConvertHelper.str2Short(ve.getVehicleSubBrand()));
            data.setTime(DateHelper.string2Date(DateHelper.long2DateStr(srcMeta.getTimestamp(), DateHelper.FORMAT_0), DateHelper.FORMAT_0));
            data.setTypeId(ConvertHelper.str2Short(ve.getVehicleType()));
        } catch (Exception e) {
            log.error("vehicle data transform error.", e);
            e.printStackTrace();
        }
        return data;
    }
   



}
