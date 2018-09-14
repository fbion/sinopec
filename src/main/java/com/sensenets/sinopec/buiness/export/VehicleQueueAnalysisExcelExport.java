/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author think
 * @date 2018年9月1日 上午10:35:41
 * @version V1.0
 */
package com.sensenets.sinopec.buiness.export;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.google.common.collect.Lists;
import com.sensenets.sinopec.buiness.dto.VehicleQueueAnalysisExportDto;
import com.sensenets.sinopec.common.utils.ListPageHelper;

/**
  * @ClassName: VehicleQueueAnalysisExcelExport
  * @Description: 车辆排队分析数据导出
  * @author think
  * @date 2018年9月1日 上午10:35:41
  *
  */
public class VehicleQueueAnalysisExcelExport {
    
    public HSSFWorkbook exportExcel(String fileName,String filePath,List<VehicleQueueAnalysisExportDto> exportList,int sheetMaxRows) throws Exception {
        List<List<List<String>>> dataList = new ArrayList<List<List<String>>>();
        if(CollectionUtils.isNotEmpty(exportList)){
            List<List<VehicleQueueAnalysisExportDto>> pageList =  ListPageHelper.getPages(VehicleQueueAnalysisExportDto.class, exportList, sheetMaxRows);
            for(List<VehicleQueueAnalysisExportDto> sheet :pageList){
                List<List<String>> sheetList = Lists.newArrayList();
                for(VehicleQueueAnalysisExportDto dto : sheet){
                    List<String> list = new ArrayList<String>();
                    list.add(String.valueOf(dto.getPlateNumber()));
                    list.add(String.valueOf(dto.getVehicleTypeName()));
                    list.add(String.valueOf(dto.getVehicleColorName()));
                    list.add(String.valueOf(dto.getPlateType()));
                    list.add(String.valueOf(dto.getPlateColor()));
                    list.add(String.valueOf(dto.getOilType()));
                    list.add(String.valueOf(dto.getOilStationRepoName()));
                    
                    list.add(String.valueOf(dto.getInTime()));
                    list.add(String.valueOf(dto.getOutTime()));
                    list.add(String.valueOf(dto.getQueueTime()));
                    
                    sheetList.add(list);
                }
                dataList.add(sheetList);
            }
        }
        String[] headers = { 
                "车牌","车型","车身颜色","车牌类型","车牌颜色","燃油类型" 
                ,"油站","进站时间","出站时间","排队时间(分钟)"
                };
        ExportExcelUtils eeu = new ExportExcelUtils();
        HSSFWorkbook workbook = new HSSFWorkbook();
        File excelFile = new File(filePath);
        if(!excelFile.exists()){
            excelFile.mkdirs();
        }
        FileOutputStream fileOut = new FileOutputStream(filePath+fileName);
        for(int i = 0;i<dataList.size();i++){
            eeu.exportExcel(workbook, i, "车辆排队分析统计"+i, headers, dataList.get(i));
        }
        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();
        return workbook;
    }
    
    
}
