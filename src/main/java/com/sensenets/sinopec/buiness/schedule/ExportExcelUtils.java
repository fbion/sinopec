package com.sensenets.sinopec.buiness.schedule;
 
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
 
public class ExportExcelUtils {
 
	/**
	 * @Title: exportExcel
	 * @Description: 导出Excel的方法
	 * @param workbook 
	 * @param sheetNum (sheet的位置，0表示第一个表格中的第一个sheet)
	 * @param sheetTitle  （sheet的名称）
	 * @param headers    （表格的标题）
	 * @param result   （表格的数据）
	 * @param out  （输出流）
	 * @throws Exception
	 */
	public void exportExcel(HSSFWorkbook workbook, int sheetNum,
			String sheetTitle, String[] headers, List<List<String>> result,
			int titleStartRow,String titleContent) throws Exception {
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(sheetNum, sheetTitle);
		// 设置表格默认列宽度为20个字节
		sheet.setDefaultColumnWidth((short) 20);
		// 产生表格title
		Row titleRow = sheet.createRow(titleStartRow);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = titleRow.createCell((short) i);
            cell.setCellStyle(createCellStyle(cell,true));
        }
        sheet.addMergedRegion(new CellRangeAddress(titleStartRow,titleStartRow,0,2));//横向：合并第一行的第1列到第3列
        Cell titleCell = titleRow.getCell(0);
        HSSFRichTextString titleText = new HSSFRichTextString(titleContent);
        titleCell.setCellValue(titleText.toString());
        
		// 产生表格表头行
		Row row = sheet.createRow(titleStartRow+1);
		for (int i = 0; i < headers.length; i++) {
			Cell cell = row.createCell((short) i);
			cell.setCellStyle(createCellStyle(cell,true));
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text.toString());
		}
		// 设置上面四行冻结
		// 前两个参数是你要用来拆分的列数和行数。后两个参数是下面窗口的可见象限，
        // 其中第三个参数是右边区域可见的左边列数，第四个参数是下面区域可见的首行
		sheet.createFreezePane(0, 2, 0, 2); 
		// 遍历集合数据，产生数据行
		if (result != null) {
			int index = titleStartRow+2;
			for (List<String> m : result) {
				row = sheet.createRow(index);
				int cellIndex = 0;
				for (String str : m) {
					Cell cell = row.createCell((short) cellIndex);
					cell.setCellStyle(createCellStyle(cell,false));
					cell.setCellValue(str.toString());
					cellIndex++;
				}
				index++;
			}
		}
     
	}
	
	/**
     * @Title: createCellStyle
     * @Description: 创建单元格样式
     * @param cell 单元格
     * @param align 水平位置
     * @param vertical 垂直位置
     * @return
     */
   private static CellStyle createCellStyle(final Cell cell,boolean isBlod){
       CellStyle cellStyle = cell.getRow().getSheet().getWorkbook().createCellStyle();
       cellStyle.cloneStyleFrom(cell.getCellStyle());    // 克隆出一个 style
       cellStyle.setBorderBottom(BorderStyle.THIN);
       cellStyle.setBorderLeft(BorderStyle.THIN);
       cellStyle.setBorderRight(BorderStyle.THIN);
       cellStyle.setBorderTop(BorderStyle.THIN);
       cellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
       cellStyle.setLeftBorderColor(IndexedColors.BLACK.index);
       cellStyle.setRightBorderColor(IndexedColors.BLACK.index);
       cellStyle.setTopBorderColor(IndexedColors.BLACK.index);
       //水平居中  
       cellStyle.setAlignment(HorizontalAlignment.CENTER);
       //垂直居中   
       cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
       cellStyle.setWrapText(true); // 自动换行
       // 生成一个字体
       Font cellFont = cell.getRow().getSheet().getWorkbook().createFont();
       cellFont.setFontHeightInPoints((short)11);
       cellFont.setBold(isBlod);
       cellFont.setColor(HSSFFont.COLOR_NORMAL);
       cellFont.setFontName("Courier New");
       // 把字体应用到当前的样式
       cellStyle.setFont(cellFont);
       return cellStyle;
   }
   
}
