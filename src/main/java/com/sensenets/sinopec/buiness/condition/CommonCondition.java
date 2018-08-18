package com.sensenets.sinopec.buiness.condition;

import com.sensenets.sinopec.common.domain.QuerySortPage;
import lombok.Data;

/**
 * @author kelly
 * @version V1.0
 * @date 2018-08-09 18:42
 * @desc 通用查询条件
 */
@Data
public class CommonCondition extends QuerySortPage {

    private boolean isPage = false;

    private long timestamp = System.currentTimeMillis();

}
