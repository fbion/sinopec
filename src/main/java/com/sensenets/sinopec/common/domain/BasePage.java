package com.sensenets.sinopec.common.domain;

import lombok.Data;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-09 18:22
 * @desc 基础分页对象
 */
@Data
public class BasePage {


    private int pageNumber = 1;

    private int pageSize = 10;

    public BasePage(){

    }

    public BasePage(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

}
