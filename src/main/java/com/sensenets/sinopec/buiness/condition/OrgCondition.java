package com.sensenets.sinopec.buiness.condition;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sensenets.sinopec.common.utils.JsonHelper;

import lombok.Data;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-09 18:45
 * @desc 测试查询条件
 */
@Data
public class OrgCondition  extends CommonCondition {

    private String name;

    private long id;

    private String startTime;

    private String endTime;
    
    @JsonIgnore
    private Timestamp genStartTime ;
    @JsonIgnore
    private Timestamp genEndTime;
    
   public OrgCondition() {
       super();
   }

    public OrgCondition(String name) {
        super();
        this.name = name;
    }

    public OrgCondition(long id) {
        super();
        this.id = id;
    }

    public OrgCondition(String name, long id) {
        super();
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) {
        OrgCondition condition = new OrgCondition("a");
        condition.setPage(true);
        condition.setPageSize(1);
        condition.setPageNumber(1);
        System.out.println(JsonHelper.toJson(condition));
    }

  
}
