package com.sensenets.sinopec.kafka.buffer.gas;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;
import com.sensenets.sinopec.buiness.model.two.Vehicles;
import com.sensenets.sinopec.common.enums.VehicleRecordTypeEnum;

import lombok.Data;

@Data
public class VehicleSortObj  extends Vehicles implements Comparable<VehicleSortObj> {
    
    /**
      * @Fields serialVersionUID 
      */
    private static final long serialVersionUID = 3533308423444274619L;
    /**
      * @Fields time : 与当前记录时间差
      */
    private long  time;
    
    private VehicleRecordTypeEnum type;
    
    public VehicleSortObj(){
        
    }
    
    public VehicleSortObj(long time){
        this.time = time;
    }
    
    @Override
    public int compareTo(VehicleSortObj o) {
        if(time < o.time){
            return -1;
        }
        if(time > o.time){
            return 1;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        VehicleSortObj obj1 = new VehicleSortObj(1231);
        VehicleSortObj obj2 = new VehicleSortObj(1230);
        
        List<VehicleSortObj> list = Lists.newArrayList();
        Collections.sort(list);
        list.add(obj1);
        list.add(obj2);
        Collections.sort(list);
        for(VehicleSortObj o :list){
           System.out.println(o.getTime());
        }
    }
    
}