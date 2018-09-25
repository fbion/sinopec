/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月15日 下午2:56:31
 * @version V1.0
 */
package com.sensenets.sinopec.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
  * @ClassName: GenerateSqlHelper
  * @Description: 生成sql语句工具
  * @author think
  * @date 2018年9月15日 下午2:56:31
  *
  */
@Slf4j
public class GenerateSqlHelper {
    
    private static final String INSERT =" INSERT INTO " ;
    private static final String VALUES=" VALUES " ;
    
    private static final String LEFT_BR =" ( " ;
    private static final String RIGHT_BR =" ) " ;
    
    public static Map<String,String> generateInsertSql(List<ParamObj> objs){
        Map<String,String> map = new HashMap<String,String>();
        if(CollectionUtils.isNotEmpty(objs)){
            for(ParamObj obj:objs){
                if(obj instanceof AddParamObj){
                    AddParamObj add = (AddParamObj)obj;
                    StringBuffer tabStr = new StringBuffer();
                    tabStr.append("\"public\".");
                    tabStr.append("\""+add.getTableName()+"\"");
                    StringBuffer fieldStr = new StringBuffer();
                    for(String field: add.getFieldAry()){
                        fieldStr.append(field+",");
                    }
                    
                    for(ValueObj[] valueAry : add.getValueList()){
                        StringBuffer valueStr = new StringBuffer();
                        for(ValueObj  value :valueAry){
                            if(value.getFieldType()==FieldType.BIGINT||value.getFieldType()==FieldType.INTEGER||value.getFieldType()==FieldType.SHORT){
                                valueStr.append(value.getFieldValue()+",");
                            }else if(value.getFieldType()==FieldType.BOOLEAN){
                                valueStr.append(BooleanUtils.toBoolean(value.getFieldValue())?1:0+",");
                            }else if(value.getFieldType()==FieldType.VARCHAR||value.getFieldType()==FieldType.TIMESTAMP){
                                valueStr.append("'"+value.getFieldValue()+"'"+",");
                            }
                        }
                        String sqlStr = INSERT +tabStr.toString()+LEFT_BR + StringUtils.substringBeforeLast(fieldStr.toString(), ",")+ RIGHT_BR + VALUES +LEFT_BR + StringUtils.substringBeforeLast(valueStr.toString(), ",")+RIGHT_BR +";"; 
                        map.put(sqlStr, sqlStr);
                        System.out.println(sqlStr);
                    }
                }
            }
        }
        return map;
    } 
    
    public static void main(String[] args) {
        List<ParamObj> objs = Lists.newArrayList();
        List<String> funcIds = Lists.newArrayList();
        objs.add(generateFuncsParamsObj(funcIds));
        objs.add(generateFuncRoleFuncsParamsObj(funcIds));
        generateInsertSql(objs);
    }
    
    private static ParamObj  generateFuncsParamsObj(List<String> funcIds){
        String tableName = "funcs" ;
        String[] fieldAry = {"func_id","func_name","func_uri"};
        List<ValueObj[]> valueList = Lists.newArrayList();
        List<ValueObj> values = null ;
        String uuid = UUIDHelper.genSourceUUID(false);
        funcIds.add(uuid);
        values = Lists.newArrayList();
        values.add(generateValueObj("func_id",uuid,FieldType.VARCHAR));
        values.add(generateValueObj("func_name","移动分析/移动数据采集管理/移动数据采集列表",FieldType.VARCHAR));
        values.add(generateValueObj("func_uri","POST /service/mobileCollectTask/listPage;",FieldType.VARCHAR));
        valueList.add(values.toArray(new ValueObj[values.size()]));
        
        uuid = UUIDHelper.genSourceUUID(false);
        funcIds.add(uuid);
        values = Lists.newArrayList();
        values.add(generateValueObj("func_id",uuid,FieldType.VARCHAR));
        values.add(generateValueObj("func_name","移动分析/移动数据采集管理/移动数据采集添加",FieldType.VARCHAR));
        values.add(generateValueObj("func_uri","POST /service/mobileCollectTask/add;",FieldType.VARCHAR));
        valueList.add(values.toArray(new ValueObj[values.size()]));
        
        uuid = UUIDHelper.genSourceUUID(false);
        funcIds.add(uuid);
        values = Lists.newArrayList();
        values.add(generateValueObj("func_id",uuid,FieldType.VARCHAR));
        values.add(generateValueObj("func_name","移动分析/移动数据采集管理/移动数据采集查询",FieldType.VARCHAR));
        values.add(generateValueObj("func_uri","GET /service/mobileCollectTask/query/;",FieldType.VARCHAR));
        valueList.add(values.toArray(new ValueObj[values.size()]));
        
        uuid = UUIDHelper.genSourceUUID(false);
        funcIds.add(uuid);
        values = Lists.newArrayList();
        values.add(generateValueObj("func_id",uuid,FieldType.VARCHAR));
        values.add(generateValueObj("func_name","移动分析/移动数据采集管理/移动数据采集修改",FieldType.VARCHAR));
        values.add(generateValueObj("func_uri","PUT /service/mobileCollectTask/update/;",FieldType.VARCHAR));
        valueList.add(values.toArray(new ValueObj[values.size()]));
        
        uuid = UUIDHelper.genSourceUUID(false);
        funcIds.add(uuid);
        values = Lists.newArrayList();
        values.add(generateValueObj("func_id",uuid,FieldType.VARCHAR));
        values.add(generateValueObj("func_name","移动分析/移动数据采集管理/移动数据采集删除",FieldType.VARCHAR));
        values.add(generateValueObj("func_uri","POST /service/mobileCollectTask/deleteBatch;",FieldType.VARCHAR));
        valueList.add(values.toArray(new ValueObj[values.size()]));
    
        uuid = UUIDHelper.genSourceUUID(false);
        funcIds.add(uuid);
        values = Lists.newArrayList();
        values.add(generateValueObj("func_id",uuid,FieldType.VARCHAR));
        values.add(generateValueObj("func_name","移动分析/移动数据采集分析/获取分析结果",FieldType.VARCHAR));
        values.add(generateValueObj("func_uri","GET /service/mobileCollectTask/getResult/;",FieldType.VARCHAR));
        valueList.add(values.toArray(new ValueObj[values.size()]));
        
        uuid = UUIDHelper.genSourceUUID(false);
        funcIds.add(uuid);
        values = Lists.newArrayList();
        values.add(generateValueObj("func_id",uuid,FieldType.VARCHAR));
        values.add(generateValueObj("func_name","移动分析/移动数据采集分析/导出分析结果",FieldType.VARCHAR));
        values.add(generateValueObj("func_uri","GET /service/mobileCollectTask/exportResult/;",FieldType.VARCHAR));
        valueList.add(values.toArray(new ValueObj[values.size()]));

        uuid = UUIDHelper.genSourceUUID(false);
        funcIds.add(uuid);
        values = Lists.newArrayList();
        values.add(generateValueObj("func_id",uuid,FieldType.VARCHAR));
        values.add(generateValueObj("func_name","车辆应用/车辆排队/车辆排队列表",FieldType.VARCHAR));
        values.add(generateValueObj("func_uri","POST /service/vehicleQueue/listPage;",FieldType.VARCHAR));
        valueList.add(values.toArray(new ValueObj[values.size()]));
        
        uuid = UUIDHelper.genSourceUUID(false);
        funcIds.add(uuid);
        values = Lists.newArrayList();
        values.add(generateValueObj("func_id",uuid,FieldType.VARCHAR));
        values.add(generateValueObj("func_name","车辆应用/车辆排队/导出排队数据",FieldType.VARCHAR));
        values.add(generateValueObj("func_uri","POST /service/vehicleQueue/exportData;",FieldType.VARCHAR));
        valueList.add(values.toArray(new ValueObj[values.size()]));
        
        
        uuid = UUIDHelper.genSourceUUID(false);
        funcIds.add(uuid);
        values = Lists.newArrayList();
        values.add(generateValueObj("func_id",uuid,FieldType.VARCHAR));
        values.add(generateValueObj("func_name","数据统计/机动车统计/排队报表统计",FieldType.VARCHAR));
        values.add(generateValueObj("func_uri","POST /service/vehicleQueueAnalysis/analysisCount;",FieldType.VARCHAR));
        valueList.add(values.toArray(new ValueObj[values.size()]));
        
        uuid = UUIDHelper.genSourceUUID(false);
        funcIds.add(uuid);
        values = Lists.newArrayList();
        values.add(generateValueObj("func_id",uuid,FieldType.VARCHAR));
        values.add(generateValueObj("func_name","数据统计/机动车统计/导出排队分析数据",FieldType.VARCHAR));
        values.add(generateValueObj("func_uri","POST /service/vehicleQueueAnalysis/exportData;",FieldType.VARCHAR));
        valueList.add(values.toArray(new ValueObj[values.size()]));
        
        
        return new AddParamObj(tableName,fieldAry,valueList);
    }
    
    private static ParamObj  generateFuncRoleFuncsParamsObj(List<String> funcIds){
        String tableName = "func_role_funcs" ;
        String[] fieldAry = {"func_role_id","func_id"};
        List<ValueObj[]> valueList = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(funcIds)){
            for(String funcId:funcIds){
                List<ValueObj> values = Lists.newArrayList();
                values.add(generateValueObj("func_role_id","admin",FieldType.VARCHAR));
                values.add(generateValueObj("func_id",funcId,FieldType.VARCHAR));
                valueList.add(values.toArray(new ValueObj[values.size()]));
            }
        }
        return new AddParamObj(tableName,fieldAry,valueList);
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
        
        List<ValueObj[]> valueList;
        
        public AddParamObj(){
            this.type = SqlType.Add;
        }
        
        public AddParamObj(String tableName,String[] fieldAry,List<ValueObj[]> valueList){
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
