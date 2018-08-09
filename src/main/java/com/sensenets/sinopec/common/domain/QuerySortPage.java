package com.sensenets.sinopec.common.domain;

import lombok.Data;

import java.util.List;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-09 18:25
 * @desc 查询并排序并分页条件
 */
@Data
public class QuerySortPage extends BasePage{


    private List<SortObj> sortList;

}
