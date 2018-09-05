/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年8月28日 下午12:28:45
 * @version V1.0
 */
package com.sensenets.sinopec.common.enums;

/**
  * @ClassName: VehicleAngleTypeEnum
  * @Description: 车辆角度类型枚举
  * @author think
  * @date 2018年8月28日 下午12:28:45
  *
  */
public enum VehicleAngleTypeEnum {
    
//    车辆角度    0   车尾
//    车辆角度    1   车头
//    车辆角度    2   侧面

    
    chewei((short)0,"车尾"),
    
    chetou((short)1,"车头"),
    
    cemian((short)2,"侧面");
    
    private short code;
    
    private String desc;
    
    private VehicleAngleTypeEnum(short code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public static String  getDescByCode(short code){
        for(VehicleAngleTypeEnum type : VehicleAngleTypeEnum.values()){
            if(type.getCode()==code){
                return type.getDesc();
            }
        }
        return "未知";
    }
    
    
    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    

}
