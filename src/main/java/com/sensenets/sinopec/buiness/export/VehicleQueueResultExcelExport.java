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
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sensenets.sinopec.buiness.dto.VehicleQueueExportDto;
import com.sensenets.sinopec.common.utils.ListPageHelper;

/**
  * @ClassName: ExcelExportHelper
  * @Description: 车辆排队数据导出
  * @author think
  * @date 2018年9月1日 上午10:35:41
  *
  */
public class VehicleQueueResultExcelExport {
    
    public HSSFWorkbook exportExcel(String fileName,String filePath,String imagePath,List<VehicleQueueExportDto> exportList,int sheetMaxRows) throws Exception {
        List<List<List<String>>> dataList = new ArrayList<List<List<String>>>();
        if(CollectionUtils.isNotEmpty(exportList)){
            List<List<VehicleQueueExportDto>> pageList =  ListPageHelper.getPages(VehicleQueueExportDto.class, exportList, sheetMaxRows);
            for(List<VehicleQueueExportDto> sheet :pageList){
                List<List<String>> sheetList = Lists.newArrayList();
                for(VehicleQueueExportDto dto : sheet){
                    List<String> list = new ArrayList<String>();
                    list.add(String.valueOf(dto.getOilStationRepoName()));
                    list.add(String.valueOf(dto.getInTime()));
                    list.add(String.valueOf(dto.getInSensorName()));
                    list.add(String.valueOf(dto.getOutTime()));
                    list.add(String.valueOf(dto.getOutSensorName()));
                    list.add(String.valueOf(dto.getQueueTime()));
                    list.add(String.valueOf(dto.getOilType()));
                    
                    list.add(String.valueOf(dto.getInBrandName()));
                    list.add(String.valueOf(dto.getInVehicleTypeName()));
                    list.add(String.valueOf(dto.getInVehicleColorName()));
                    list.add(String.valueOf(dto.getInPlateType()));
                    list.add(String.valueOf(dto.getInPlateColor()));
                    list.add(String.valueOf(dto.getInPlateNumber()));
                    list.add(String.valueOf(dto.getInVehicleAngleName()));
                    
                    list.add(String.valueOf(dto.getOutBrandName()));
                    list.add(String.valueOf(dto.getOutVehicleTypeName()));
                    list.add(String.valueOf(dto.getOutVehicleColorName()));
                    list.add(String.valueOf(dto.getOutPlateType()));
                    list.add(String.valueOf(dto.getOutPlateColor()));
                    list.add(String.valueOf(dto.getOutPlateNumber()));
                    list.add(String.valueOf(dto.getOutVehicleAngleName()));
                    
                    list.add(String.valueOf("#image@inSrc@"+dto.getInSourceImage()));
                    list.add(String.valueOf("#image@inFeature@"+dto.getInFeatureImage()));
                    list.add(String.valueOf("#image@outSrc@"+dto.getOutSourceImage()));
                    list.add(String.valueOf("#image@outFeature@"+dto.getOutFeatureImage()));
                    sheetList.add(list);
                }
                dataList.add(sheetList);
            }
        }
        String[] headers = { 
                "加油站名称","进站时间","进站设备名称","出站时间","出站设备名称","排队时间(分钟)","燃料类型"
                ,"车辆品牌","车辆类型","车辆颜色","车牌类型","车牌颜色","车牌号码","车辆方向"
                ,"车辆品牌","车辆类型","车辆颜色","车牌类型","车牌颜色","车牌号码","车辆方向"
                ,"进站原图链接","进站特征图链接","出站原图链接","出站特征图链接"
                };
        ExportExcelUtils eeu = new ExportExcelUtils();
        HSSFWorkbook workbook = new HSSFWorkbook();
        File imageFile = new File(imagePath);
        if(!imageFile.exists()){
            imageFile.mkdirs();
        }
        File excelFile = new File(filePath);
        if(!excelFile.exists()){
            excelFile.mkdirs();
        }
        FileOutputStream fileOut = new FileOutputStream(filePath+"/"+fileName);
        for(int i = 0;i<dataList.size();i++){
            List<List<String>> sheet = dataList.get(i);
            Map<String,ExcelImageDto> downloadImageMap = Maps.newHashMap();
            for(List<String> rowObj : sheet){
                String storeImagePath = String.format("%s/sheet%d",imagePath,i);
                File imageSheetFile = new File(storeImagePath);
                if(!imageSheetFile.exists()){
                    imageSheetFile.mkdirs();
                }
                String fullImagePath = storeImagePath+"/"+"full";
                File fullImageSheetFile = new File(fullImagePath);
                if(!fullImageSheetFile.exists()){
                    fullImageSheetFile.mkdirs();
                }
                String partImagePath = storeImagePath+"/"+"part";
                File partImageSheetFile = new File(partImagePath);
                if(!partImageSheetFile.exists()){
                    partImageSheetFile.mkdirs();
                }
                for(String colVal : rowObj){
                    if(colVal.startsWith("#image@")){
                        if(colVal.indexOf("@inSrc@")!=-1){
                            downloadImageMap.put(colVal,new ExcelImageDto("进站原图",fullImagePath,"full-sheet"+i));
                        }else if(colVal.indexOf("@inFeature@")!=-1){
                            downloadImageMap.put(colVal,new ExcelImageDto("进站特征图",partImagePath,"part-sheet"+i));
                        }else if(colVal.indexOf("@outSrc@")!=-1){
                            downloadImageMap.put(colVal,new ExcelImageDto("出站原图",fullImagePath,"full-sheet"+i));
                        }else if(colVal.indexOf("@outFeature@")!=-1){
                            downloadImageMap.put(colVal,new ExcelImageDto("出站特征图",partImagePath,"part-sheet"+i));
                        }
                    }
                }
            }
            eeu.exportExcel(workbook, i, "车辆排队统计"+i, headers, dataList.get(i),downloadImageMap);
        }
        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();
        return workbook;
    }
    
    
}
