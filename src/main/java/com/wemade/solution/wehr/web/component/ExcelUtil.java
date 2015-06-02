package com.wemade.solution.wehr.web.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtil {

	static String getCellString(Row row, int index, String defaultValue){
		String value = null;
		
		if(row.getCell(index) == null || row.getCell(index).getCellType() == Cell.CELL_TYPE_BLANK){
			return defaultValue;
		}
		
		try{
			
			if(row.getCell(index).getCellType() == Cell.CELL_TYPE_NUMERIC){
				value = ""+(int)row.getCell(index).getNumericCellValue();
			}else{
				value = row.getCell(index).getStringCellValue();
			}
			
		}catch(Exception e){
			value = defaultValue;
		}
		return value;
	}
	
	static Double getCellDouble(Row row, int index, Double defaultValue){
		
		Double value = null;
		
		if(row.getCell(index) == null || row.getCell(index).getCellType() == Cell.CELL_TYPE_BLANK){
			return defaultValue;
		}
		
		try{
			value = row.getCell(index).getNumericCellValue();
		}catch(Exception e){
			value = defaultValue;
		}
		return value;
	}
	
	static Float getCellFloat(Row row, int index, Float defaultValue){
		Float value = null;
		
		if(row.getCell(index) == null || row.getCell(index).getCellType() == Cell.CELL_TYPE_BLANK){
			return defaultValue;
		}
		
		try{
			value = (float) row.getCell(index).getNumericCellValue();
		}catch(Exception e){
			value = defaultValue;
		}
		return value;
	}
	
	static Long getCellLong(Row row, int index, Long defaultValue){
		Long value = null;
		
		if(row.getCell(index) == null || row.getCell(index).getCellType() == Cell.CELL_TYPE_BLANK){
			return defaultValue;
		}
		
		try{
			value = (long) row.getCell(index).getNumericCellValue();
		}catch(Exception e){
			value = defaultValue;
		}
		return value;
	}
	
	static Integer getCellInteger(Row row, int index, Integer defaultValue){
		Integer value = null;
		
		if(row.getCell(index) == null || row.getCell(index).getCellType() == Cell.CELL_TYPE_BLANK){
			return defaultValue;
		}
		
		try{
			value = (int)row.getCell(index).getNumericCellValue();
		}catch(Exception e){
			value = defaultValue;
		}
		return value;
	}
	
	static Date getCellDate(Row row, int index, String format, Date defaultValue){
		Date value = null;
		if(row.getCell(index) == null || row.getCell(index).getCellType() == Cell.CELL_TYPE_BLANK){
			return defaultValue;
		}
		
		try{
			Cell cell = row.getCell(index);
			if(HSSFDateUtil.isCellDateFormatted(cell)){
				value = cell.getDateCellValue();
			}else{
				Double time = cell.getNumericCellValue();
				Integer intTime = time.intValue();
				SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
				value = originalFormat.parse(String.valueOf(intTime));
			}
			
		}catch(Exception e){
			value = defaultValue;
		}
		return value;
	}
	
	static Boolean getCellBoolean(Row row, int index, Boolean defaultValue){
		Boolean value = null;
		
		if(row.getCell(index) == null || row.getCell(index).getCellType() == Cell.CELL_TYPE_BLANK){
			return defaultValue;
		}
		
		try{
			value = row.getCell(index).getBooleanCellValue();
		}catch(Exception e){
			value = defaultValue;
		}
		
		return value;
	}
}
