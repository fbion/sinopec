package com.sensenets.sinopec.buiness.schedule;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.sensenets.sinopec.common.enums.VehicleRecordTypeEnum;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VehicleSortDto  implements Comparable<VehicleSortDto> {
    
    /**
      * @Fields serialVersionUID 
      */
    private static final long serialVersionUID = 3533308423444274619L;
    
    private VehicleRecordTypeEnum type;
    
    /**
     * @Fields id 
     */
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * @Fields uts 
     */
    @ApiModelProperty(value = "")
    private Date uts;

    /**
     * @Fields vehicleId 
     */
    @ApiModelProperty(value = "")
    private String vehicleId;

    /**
     * @Fields imageId 
     */
    @ApiModelProperty(value = "")
    private String imageId;

    /**
     * @Fields ts 
     */
    @ApiModelProperty(value = "")
    private Long ts;

    /**
     * @Fields repoId 
     */
    @ApiModelProperty(value = "")
    private String repoId;

    /**
     * @Fields sensorId 
     */
    @ApiModelProperty(value = "")
    private String sensorId;

    /**
     * @Fields confidence 
     */
    @ApiModelProperty(value = "")
    private Float confidence;

    /**
     * @Fields brandId 
     */
    @ApiModelProperty(value = "")
    private Short brandId;

    /**
     * @Fields subBrandId 
     */
    @ApiModelProperty(value = "")
    private Short subBrandId;

    /**
     * @Fields modelYearId 
     */
    @ApiModelProperty(value = "")
    private Short modelYearId;

    /**
     * @Fields typeId 
     */
    @ApiModelProperty(value = "")
    private Short typeId;

    /**
     * @Fields colorId 
     */
    @ApiModelProperty(value = "")
    private Short colorId;

    /**
     * @Fields plateText 
     */
    @ApiModelProperty(value = "")
    private String plateText;

    /**
     * @Fields plateTypeId 
     */
    @ApiModelProperty(value = "")
    private Short plateTypeId;

    /**
     * @Fields plateColorId 
     */
    @ApiModelProperty(value = "")
    private Short plateColorId;

    /**
     * @Fields side 
     */
    @ApiModelProperty(value = "")
    private Short side;

    /**
     * @Fields size 
     */
    @ApiModelProperty(value = "")
    private Short size;

    /**
     * @Fields speed 
     */
    @ApiModelProperty(value = "")
    private Short speed;

    /**
     * @Fields direction 
     */
    @ApiModelProperty(value = "")
    private Short direction;

    /**
     * @Fields symbolInt 
     */
    @ApiModelProperty(value = "")
    private Long symbolInt;

    /**
     * @Fields symbolStr 
     */
    @ApiModelProperty(value = "")
    private String symbolStr;

    /**
     * @Fields illegalInt 
     */
    @ApiModelProperty(value = "")
    private Long illegalInt;

    /**
     * @Fields illegalStr 
     */
    @ApiModelProperty(value = "")
    private String illegalStr;

    /**
     * @Fields coillegalInt 
     */
    @ApiModelProperty(value = "")
    private Long coillegalInt;

    /**
     * @Fields coillegalStr 
     */
    @ApiModelProperty(value = "")
    private String coillegalStr;

    /**
     * @Fields specialInt 
     */
    @ApiModelProperty(value = "")
    private Long specialInt;

    /**
     * @Fields specialStr 
     */
    @ApiModelProperty(value = "")
    private String specialStr;

    /**
     * @Fields driverOnThePhone 
     */
    @ApiModelProperty(value = "")
    private Boolean driverOnThePhone;

    /**
     * @Fields driverWithoutBelt 
     */
    @ApiModelProperty(value = "")
    private Boolean driverWithoutBelt;

    /**
     * @Fields codriverWithoutBelt 
     */
    @ApiModelProperty(value = "")
    private Boolean codriverWithoutBelt;

    /**
     * @Fields content 
     */
    @ApiModelProperty(value = "")
    private String content;

    /**
     * @Fields lane 
     */
    @ApiModelProperty(value = "")
    private String lane;

    /**
     * @Fields faceId 
     */
    @ApiModelProperty(value = "")
    private String faceId;

    /**
     * @Fields oilType 加油量
     */
    @ApiModelProperty(value = "加油量")
    private String oilType;

    /**
     * @Fields oilAmount 
     */
    @ApiModelProperty(value = "")
    private Float oilAmount;

    /**
     * @Fields engineFuel 1：汽油车，2：柴油车
     */
    @ApiModelProperty(value = "1：汽油车，2：柴油车")
    private Short engineFuel;
    
    
    @Override
    public int compareTo(VehicleSortDto o) {
        if(o==null){
            return 0;
        }
        if(o.getTs()==null||ts==null){
            return 0;
        }
        if(ts < o.getTs()){
            return -1;
        }
        if(ts > o.getTs()){
            return 1;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        VehicleSortDto obj1 = new VehicleSortDto();
        obj1.setTs(3232L);
        VehicleSortDto obj2 = new VehicleSortDto();
        obj2.setTs(2232L);
        List<VehicleSortDto> list = Lists.newArrayList();
        list.add(obj1);
        list.add(obj2);
        Collections.sort(list);
        for(VehicleSortDto o :list){
           System.out.println(o.getTs());
        }
    }
    
}