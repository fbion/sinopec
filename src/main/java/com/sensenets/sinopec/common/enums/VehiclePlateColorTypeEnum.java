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
 * @ClassName: VehiclePlateColorTypeEnum
 * @Description: 车牌颜色类型枚举
 * @author think
 * @date 2018年8月31日 下午7:25:43
 *
 */
public enum VehiclePlateColorTypeEnum {

    // 车牌颜色 -1 未知
    // 车牌颜色 1 蓝色
    // 车牌颜色 2 黄色
    // 车牌颜色 3 白色
    // 车牌颜色 4 黑色
    // 车牌颜色 5 绿色

    lan((short)1, "蓝色"), huang((short)2, "黄色"), bai((short)3, "白色"), hei((short)4, "黑色"), lv((short)5, "绿色"), unknown((short)-1, "未知");

    private short code;

    private String desc;

    private VehiclePlateColorTypeEnum(short code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescByCode(Short code) {
        for (VehiclePlateColorTypeEnum type : VehiclePlateColorTypeEnum.values()) {
            if (code!=null&&type.getCode() == code) {
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
