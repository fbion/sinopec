package com.sensenets.sinopec.common.utils;
import java.util.ArrayList;
import java.util.List;


/**
  * @ClassName: ListPageHelper
  * @Description: list分页工具
  * @author xzc
  * @date 2018年4月12日 上午10:23:30
  *
  */
public class ListPageHelper {
    
    public static <T> List<List<T>> getPages(Class<T> entityClass ,List<T> list, int pageSize) {
        int totalCount = list.size();
        int pageCount;
        int m = totalCount % pageSize;
        if (m > 0) {
            pageCount = totalCount / pageSize + 1;
        } else {
            pageCount = totalCount / pageSize;
        }
        List<List<T>> totalList = new ArrayList<List<T>>();
        for (int i = 1; i <= pageCount; i++) {
            if (m == 0) {
                List<T> subList = list.subList((i - 1) * pageSize, pageSize * (i));
                totalList.add(subList);
            } else {
                if (i == pageCount) {
                    List<T> subList = list.subList((i - 1) * pageSize, totalCount);
                    totalList.add(subList);
                } else {
                    List<T> subList = list.subList((i - 1) * pageSize, pageSize * i);
                    totalList.add(subList);
                }
            }
        }

        return totalList;
    }
    
    
   
}