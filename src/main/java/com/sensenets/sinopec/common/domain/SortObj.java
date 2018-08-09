package com.sensenets.sinopec.common.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-09 18:34
 * @desc 排序对象
 */
@Data
public class SortObj implements Serializable {

    private String field;

    private Boolean isAsc;


}
