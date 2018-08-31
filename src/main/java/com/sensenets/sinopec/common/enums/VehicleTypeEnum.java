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
  * @ClassName: VehicleTypeEnum
  * @Description: 车类型枚举
  * @author think
  * @date 2018年8月31日 下午7:25:43
  *
  */
public enum VehicleTypeEnum {
    

//    车型  0   轿车
//    车型  1   面包车
//    车型  2   皮卡
//    车型  3   越野车/SUV
//    车型  4   商务车/MPV
//    车型  5   轻型客车
//    车型  6   中型客车
//    车型  7   大型客车
//    车型  8   公交车
//    车型  9   校车
//    车型  10  微型货车
//    车型  11  轻型货车
//    车型  12  中型货车
//    车型  13  大型货车
//    车型  14  重型货车
//    车型  15  集装箱车
//    车型  16  三轮车
//    车型  17  其它
//    车型  18  其它
//    车型  19  其它
    
    jiaoche((short)0,"轿车"),
    
    mianbaoche((short)1,"面包车"),
    
    pika((short)2,"皮卡"),
    
    SUV((short)3,"越野车/SUV"),
    
    MPV((short)4,"商务车/MPV"),
    
    qingxingkeche((short)5,"轻型客车"),
    
    zhongxingkeche((short)6,"中型客车"),
    
    daxingkeche((short)7,"大型客车"),
    
    gongjiaoche((short)8,"公交车"),
    
    xiaoche((short)9,"校车"),
    
    weixinghuoche((short)10,"微型货车"),
    
    qingxinghuoche((short)11,"轻型货车"),
    
    zhongxinghuoche((short)12,"中型货车"),
    
    daxinghuoche((short)13,"大型货车"),
    
    zhongxinhuoche((short)14,"重型货车"),
    
    jizhuangxiangche((short)15,"集装箱车"),
    
    suanlunche((short)16,"三轮车"),
    
    qita1((short)17,"其他"),
    
    qita2((short)18,"其他"),
    
    qita3((short)19,"其他");
    
    private short code;
    
    private String desc;
    
    private VehicleTypeEnum(short code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public static String  getDescByCode(short code){
        for(VehicleTypeEnum type : VehicleTypeEnum.values()){
            if(type.getCode()==code){
                return type.getDesc();
            }
        }
        return "其他";
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
