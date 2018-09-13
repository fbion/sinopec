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
  * @ClassName: VehicleColorTypeEnum
  * @Description: 车颜色类型枚举
  * @author think
  * @date 2018年8月31日 下午7:25:43
  *
  */
public enum VehicleColorTypeEnum {
    

//    颜色  1   黑
//    颜色  2   蓝
//    颜色  3   棕
//    颜色  4   绿
//    颜色  5   灰
//    颜色  6   橙
//    颜色  7   粉
//    颜色  8   紫
//    颜色  9   红
//    颜色  10  银
//    颜色  11  白
//    颜色  12  黄
//    颜色  -1 未知
    
    hei((short)1,"黑色"),
    lan((short)2,"蓝色"),
    zong((short)3,"棕色"),
    lv((short)4,"绿色"),
    hui((short)5,"灰色"),
    cheng((short)6,"橙色"),
    fen((short)7,"粉色"),
    zi((short)8,"紫色"),
    hong((short)9,"红色"),
    yin((short)10,"银色"),
    bai((short)11,"白色"),
    huang((short)12,"黄色"),
    unknown((short)-1,"未知");
    
    private short code;
    
    private String desc;
    
    private VehicleColorTypeEnum(short code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public static String  getDescByCode(Short code){
        for(VehicleColorTypeEnum type : VehicleColorTypeEnum.values()){
            if(code!=null&&type.getCode()==code){
                return type.getDesc();
            }
        }
        return unknown.getDesc();
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
