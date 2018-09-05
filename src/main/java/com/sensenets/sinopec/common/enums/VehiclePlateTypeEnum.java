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
  * @ClassName: VehiclePlateTypeEnum
  * @Description: 车颜色类型枚举
  * @author think
  * @date 2018年8月31日 下午7:25:43
  *
  */
public enum VehiclePlateTypeEnum {
    

//    车牌类型    -1  未知
//    车牌类型    1   普通蓝牌
//    车牌类型    2   普通黑牌
//    车牌类型    3   单层黄牌
//    车牌类型    4   双层黄牌（大车尾牌，农用车）
//    车牌类型    5   警车车牌
//    车牌类型    6   武警车牌
//    车牌类型    7   个性车牌
//    车牌类型    8   单层军车
//    车牌类型    9   双层军车
//    车牌类型    10  使馆车牌
//    车牌类型    11  香港车牌
//    车牌类型    12  农用车牌（农用绿牌，农用黄牌）
//    车牌类型    13  新能源小车
//    车牌类型    14  新能源大车
//    车牌类型    1000    驾校车牌


    
    putonglanpai((short)1,"普通蓝牌"),
    putongheipai((short)2,"普通黑牌"),
    dancenghuangpai((short)3,"单层黄牌"),
    shuangcenghuangpai((short)4,"双层黄牌"),
    jinchechepai((short)5,"警车车牌"),
    wujinchepai((short)6,"武警车牌"),
    gexingchepai((short)7,"个性车牌"),
    dancengjunche((short)8,"单层军车"),
    shaungcengjunche((short)9,"双层军车"),
    shiguanchepai((short)10,"使馆车牌"),
    xianggangchepai((short)11,"香港车牌"),
    nongyongchepai((short)12,"农用车牌"),
    xinnengyuanxiaoche((short)13,"新能源小车"),
    xinnengyuandache((short)14,"新能源大车"),
    jiaoxiaochepai((short)1000,"驾校车牌"),
    
    unknown((short)-1,"未知");
    
    private short code;
    
    private String desc;
    
    private VehiclePlateTypeEnum(short code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public static String  getDescByCode(short code){
        for(VehiclePlateTypeEnum type : VehiclePlateTypeEnum.values()){
            if(type.getCode()==code){
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
