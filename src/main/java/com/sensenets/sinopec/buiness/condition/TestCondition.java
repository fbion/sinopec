package com.sensenets.sinopec.buiness.condition;

import com.sensenets.sinopec.buiness.model.Test;
import com.sensenets.sinopec.common.utils.JsonHelper;
import lombok.Data;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-09 18:45
 * @desc 测试查询条件
 */
@Data
public class TestCondition  extends CommonCondition {

    private String name;

    private long id;

    private String startTime;

    private String endTime;

    public TestCondition(String name) {
        this.name = name;
    }

    public TestCondition(long id) {
        this.id = id;
    }

    public TestCondition(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) {
        TestCondition condition = new TestCondition("a");
        condition.setPage(true);
        condition.setPageSize(1);
        condition.setPageNumber(1);
        System.out.println(JsonHelper.toJson(condition));
    }
}
