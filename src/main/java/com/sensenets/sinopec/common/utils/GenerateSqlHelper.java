/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月15日 下午2:56:31
 * @version V1.0
 */
package com.sensenets.sinopec.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
  * @ClassName: GenerateSqlHelper
  * @Description: 生成sql语句工具
  * @author think
  * @date 2018年9月15日 下午2:56:31
  *
  */
public class GenerateSqlHelper {
    
    private static final String INSERT =" insert into " ;
    private static final String VALUES=" values " ;
    
    private static final String LEFT_BR =" ( " ;
    private static final String RIGHT_BR =" ) " ;
    
    public static Map<String,String> generateInsertSql(List<ParamObj> objs){
        Map<String,String> map = new HashMap<String,String>();
        if(CollectionUtils.isNotEmpty(objs)){
            for(ParamObj obj:objs){
                if(obj instanceof AddParamObj){
                    AddParamObj add = (AddParamObj)obj;
                    StringBuffer fieldStr = new StringBuffer();
                    for(String field: add.getFieldAry()){
                        fieldStr.append(field+",");
                    }
                    StringBuffer valueStr = new StringBuffer();
                    for(ValueObj value : add.getValueList()){
                        if(value.getFieldType()==FieldType.BIGINT||value.getFieldType()==FieldType.INTEGER||value.getFieldType()==FieldType.SHORT){
                            valueStr.append(value.getFieldValue()+",");
                        }else if(value.getFieldType()==FieldType.BOOLEAN){
                            valueStr.append(BooleanUtils.toBoolean(value.getFieldValue())?1:0+",");
                        }else if(value.getFieldType()==FieldType.VARCHAR||value.getFieldType()==FieldType.TIMESTAMP){
                            valueStr.append(value.getFieldValue()+",");
                        }
                    }
                    System.out.println(valueStr);
//                    String sqlStr = INSERT + add.getTableName() + LEFT_BR + StringUtils.substringBeforeLast(fieldStr.toString(), ",") + RIGHT_BR+VALUES+ LEFT_BR + StringUtils.substringBeforeLast(valueStr.toString(), ",") + RIGHT_BR;
//                    map.put(sqlStr, sqlStr);
//                    System.out.println(sqlStr);
                }
            }
        }
        return map;
    } 
    
    public static void main(String[] args) {
        List<ParamObj> objs = Lists.newArrayList();
        String tableName = " public.funcs " ;
        String[] fieldAry = {"func_id","func_name","func_uri"};
        List<ValueObj> valueList = Lists.newArrayList();
        valueList.add(generateValueObj("func_id",UUIDHelper.genSourceUUID(false),FieldType.VARCHAR));
        valueList.add(generateValueObj("func_name","/移动数据分析/移动数据采集管理/移动数据采集列表",FieldType.VARCHAR));
        valueList.add(generateValueObj("func_uri","POST /service/mobileCollectTask/listPage;",FieldType.VARCHAR));
        
        valueList.add(generateValueObj("func_id",UUIDHelper.genSourceUUID(false),FieldType.VARCHAR));
        valueList.add(generateValueObj("func_name","/移动数据分析/移动数据采集管理/移动数据采集添加",FieldType.VARCHAR));
        valueList.add(generateValueObj("func_uri","POST /service/mobileCollectTask/add;",FieldType.VARCHAR));
        
        valueList.add(generateValueObj("func_id",UUIDHelper.genSourceUUID(false),FieldType.VARCHAR));
        valueList.add(generateValueObj("func_name","/移动数据分析/移动数据采集管理/移动数据采集查询",FieldType.VARCHAR));
        valueList.add(generateValueObj("func_uri","GET /service/mobileCollectTask/query/;",FieldType.VARCHAR));
        
        valueList.add(generateValueObj("func_id",UUIDHelper.genSourceUUID(false),FieldType.VARCHAR));
        valueList.add(generateValueObj("func_name","/移动数据分析/移动数据采集管理/移动数据采集修改",FieldType.VARCHAR));
        valueList.add(generateValueObj("func_uri","PUT /service/mobileCollectTask/update/;",FieldType.VARCHAR));
        
        valueList.add(generateValueObj("func_id",UUIDHelper.genSourceUUID(false),FieldType.VARCHAR));
        valueList.add(generateValueObj("func_name","/移动数据分析/移动数据采集管理/移动数据采集删除",FieldType.VARCHAR));
        valueList.add(generateValueObj("func_uri","POST /service/mobileCollectTask/deleteBatch;",FieldType.VARCHAR));
        
        objs.add(new AddParamObj(tableName,fieldAry,valueList.toArray(new ValueObj[valueList.size()])));
        generateInsertSql(objs);
    }
    
    private static ValueObj generateValueObj(String fieldName,String fieldVal,FieldType type){
        return new ValueObj(fieldName,fieldVal,type);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ParamObj{
        String tableName;
        SqlType type;
        String[] fieldAry;
    }
    
    @Data
    public static  class AddParamObj extends ParamObj{
        
        ValueObj[] valueList;
        
        public AddParamObj(){
            this.type = SqlType.Add;
        }
        
        public AddParamObj(String tableName,String[] fieldAry,ValueObj[] valueList){
            this.tableName = tableName;
            this.type = SqlType.Add;
            this.fieldAry = fieldAry;
            this.valueList = valueList;
        }
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ValueObj{
        private String fieldName;
        
        private String fieldValue;
        
        private FieldType fieldType;
    }
    
    public static  enum  SqlType{
        Add , Update , Delete ,Select
    }
    
    public static  enum  FieldType{
        INTEGER,BIGINT,BOOLEAN,SHORT,VARCHAR,TIMESTAMP
    }
}
