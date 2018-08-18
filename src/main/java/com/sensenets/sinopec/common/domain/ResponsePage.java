package com.sensenets.sinopec.common.domain;

import lombok.Data;

import java.util.List;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-09 19:56
 * @desc 通用响应分页对象
 */
@Data
public class ResponsePage<T> {

    private List<T> list;

    private Integer pageSize ;

    private Integer pageNumber;

    private Long total;

    public ResponsePage(List<T> list, Integer pageSize, Integer pageNumber, Long total) {
        this.list = list;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.total = total;
    }

    public ResponsePage(List<T> list) {
        this.list = list;
    }

}
