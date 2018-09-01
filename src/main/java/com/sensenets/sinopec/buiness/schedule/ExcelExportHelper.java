/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月1日 上午10:35:41
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.schedule;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.sensenets.sinopec.buiness.dto.CollectResultDto;
import com.sensenets.sinopec.buiness.dto.MobileCollectTaskDto;
import com.sensenets.sinopec.common.utils.DateHelper;
import com.sensenets.sinopec.common.utils.UUIDHelper;

/**
  * @ClassName: ExcelExportHelper
  * @Description: excel导出工具类型
  * @author think
  * @date 2018年9月1日 上午10:35:41
  *
  */
public class ExcelExportHelper {
    
    public static String exportExcel2local(String exportPath,CollectResultDto result,MobileCollectTaskDto task) throws Exception {
        String baseName = task.getCollectionRepoName()+"与"+task.getOilStationRepoName()+"比对，时间段"+DateHelper.date2String(task.getCollectStartTime(),DateHelper.FORMAT_0)+"-"+
                DateHelper.date2String(task.getCollectEndTime(),DateHelper.FORMAT_0);
        String inFlowName = "进站车流量统计:"+baseName;
        String inTypeName = "进站车类型统计:"+baseName;
        String outFlowName = "站外车流量统计:"+baseName;
        String outTypeName = "站外车类型统计:"+baseName;
        String collectName = task.getCollectionRepoName()+"/辆" ;
        String stationName = task.getOilStationRepoName()+"/辆" ;
        List<List<String>> inFlowList = new ArrayList<List<String>>();
        List<List<String>> inTypeList = new ArrayList<List<String>>();
        List<List<String>> outFlowList = new ArrayList<List<String>>();
        List<List<String>> outTypeList = new ArrayList<List<String>>();
        
        if(CollectionUtils.isNotEmpty(result.getOutFlows())){
            for(CollectResultDto.ResultOutFlow outflow :result.getOutFlows()){
                List<String> list = new ArrayList<String>();
                list.add(String.valueOf(outflow.getDataTime()));
                list.add(String.valueOf(outflow.getCollectCount()));
                list.add(String.valueOf(outflow.getStationCount()));
                outFlowList.add(list);
            }
        }
        
        if(CollectionUtils.isNotEmpty(result.getInFlows())){
            for(CollectResultDto.ResultInFlow inflow :result.getInFlows()){
                List<String> list = new ArrayList<String>();
                list.add(String.valueOf(inflow.getDataTime()));
                list.add(String.valueOf(inflow.getCollectCount()));
                list.add(String.valueOf(inflow.getStationCount()));
                inFlowList.add(list);
            }
        }
        
        if(CollectionUtils.isNotEmpty(result.getOutVehicleTypes())){
            for(CollectResultDto.ResultOutVehicleType outVehicleType :result.getOutVehicleTypes()){
                List<String> list = new ArrayList<String>();
                list.add(String.valueOf(outVehicleType.getVehicleType()));
                list.add(String.valueOf(outVehicleType.getCollectCount()));
                list.add(String.valueOf(outVehicleType.getStationCount()));
                outTypeList.add(list);
            }
        }
        
        if(CollectionUtils.isNotEmpty(result.getInVehicleTypes())){
            for(CollectResultDto.ResultInVehicleType inVehicleType :result.getInVehicleTypes()){
                List<String> list = new ArrayList<String>();
                list.add(String.valueOf(inVehicleType.getVehicleType()));
                list.add(String.valueOf(inVehicleType.getCollectCount()));
                list.add(String.valueOf(inVehicleType.getStationCount()));
                inTypeList.add(list);
            }
        }
        String excelName = UUIDHelper.genUUID(false)+".xls";
        try {
            File savefile = new File(exportPath);
            if (!savefile.exists()) {
                savefile.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(exportPath+excelName);
            
            String[] flowHeaders = { "时间范围",collectName,stationName };
            String[] typeHeaders = { "车辆类型",collectName,stationName };
            ExportExcelUtils eeu = new ExportExcelUtils();
            HSSFWorkbook workbook = new HSSFWorkbook();
            eeu.exportExcel(workbook, 0, "站外车流量统计", flowHeaders, outFlowList,0,outFlowName);
            eeu.exportExcel(workbook, 1, "进站车流量统计", flowHeaders, inFlowList, 0,inFlowName);
            eeu.exportExcel(workbook, 2, "站外车辆类型统计", typeHeaders, outTypeList,0,outTypeName);
            eeu.exportExcel(workbook, 3, "进站车辆类型统计", typeHeaders, inTypeList, 0,inTypeName);
            //原理就是将所有的数据一起写入，然后再关闭输入流。
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return excelName;
    }

    
    public  HSSFWorkbook exportExcel(String fileName,HttpServletResponse response,CollectResultDto result,MobileCollectTaskDto task) throws Exception {
        String baseName = task.getCollectionRepoName()+"与"+task.getOilStationRepoName()+"比对，时间段"+DateHelper.date2String(task.getCollectStartTime(),DateHelper.FORMAT_0)+"-"+
                DateHelper.date2String(task.getCollectEndTime(),DateHelper.FORMAT_0);
        String inFlowName = "进站车流量统计:"+baseName;
        String inTypeName = "进站车类型统计:"+baseName;
        String outFlowName = "站外车流量统计:"+baseName;
        String outTypeName = "站外车类型统计:"+baseName;
        String collectName = task.getCollectionRepoName()+"/辆" ;
        String stationName = task.getOilStationRepoName()+"/辆" ;
        List<List<String>> inFlowList = new ArrayList<List<String>>();
        List<List<String>> inTypeList = new ArrayList<List<String>>();
        List<List<String>> outFlowList = new ArrayList<List<String>>();
        List<List<String>> outTypeList = new ArrayList<List<String>>();
        
        if(CollectionUtils.isNotEmpty(result.getOutFlows())){
            for(CollectResultDto.ResultOutFlow outflow :result.getOutFlows()){
                List<String> list = new ArrayList<String>();
                list.add(String.valueOf(outflow.getDataTime()));
                list.add(String.valueOf(outflow.getCollectCount()));
                list.add(String.valueOf(outflow.getStationCount()));
                outFlowList.add(list);
            }
        }
        
        if(CollectionUtils.isNotEmpty(result.getInFlows())){
            for(CollectResultDto.ResultInFlow inflow :result.getInFlows()){
                List<String> list = new ArrayList<String>();
                list.add(String.valueOf(inflow.getDataTime()));
                list.add(String.valueOf(inflow.getCollectCount()));
                list.add(String.valueOf(inflow.getStationCount()));
                inFlowList.add(list);
            }
        }
        
        if(CollectionUtils.isNotEmpty(result.getOutVehicleTypes())){
            for(CollectResultDto.ResultOutVehicleType outVehicleType :result.getOutVehicleTypes()){
                List<String> list = new ArrayList<String>();
                list.add(String.valueOf(outVehicleType.getVehicleType()));
                list.add(String.valueOf(outVehicleType.getCollectCount()));
                list.add(String.valueOf(outVehicleType.getStationCount()));
                outTypeList.add(list);
            }
        }
        
        if(CollectionUtils.isNotEmpty(result.getInVehicleTypes())){
            for(CollectResultDto.ResultInVehicleType inVehicleType :result.getInVehicleTypes()){
                List<String> list = new ArrayList<String>();
                list.add(String.valueOf(inVehicleType.getVehicleType()));
                list.add(String.valueOf(inVehicleType.getCollectCount()));
                list.add(String.valueOf(inVehicleType.getStationCount()));
                inTypeList.add(list);
            }
        }
        
        String[] flowHeaders = { "时间范围",collectName,stationName };
        String[] typeHeaders = { "车辆类型",collectName,stationName };
        ExportExcelUtils eeu = new ExportExcelUtils();
        HSSFWorkbook workbook = new HSSFWorkbook();
        OutputStream out = response.getOutputStream();
        eeu.exportExcel(workbook, 0, "站外车流量统计", flowHeaders, outFlowList, 0,outFlowName);
        eeu.exportExcel(workbook, 1, "进站车流量统计", flowHeaders, inFlowList, 0,inFlowName);
        eeu.exportExcel(workbook, 2, "站外车辆类型统计", typeHeaders, outTypeList,0,outTypeName);
        eeu.exportExcel(workbook, 3, "进站车辆类型统计", typeHeaders, inTypeList,0,inTypeName);
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes(),"ISO8859-1"));
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        workbook.write(out);
        out.flush();
        out.close();
        return workbook;
    }
    
    
}
