package com.wemade.solution.wehr.web.component;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.wemade.solution.wehr.web.dto.CompanyDto;
import com.wemade.solution.wehr.web.service.CompanyService;

@Component
public class CompanyExcelComponent {

	@Autowired
	private CompanyService companyService;
	
	Sheet sheet;
	
	public void process(Sheet sheet){
		this.sheet = sheet;
		
		Iterator<Row> rows = this.sheet.rowIterator();
		
		for(int i = 0; i < 1; i++){
			rows.next();
		}
		
		while(rows.hasNext()){
			Row row = rows.next();
			
			CompanyDto companyDto = new CompanyDto();
			
			companyDto.setCode(ExcelUtil.getCellString(row, 0, ""));
			companyDto.setName(ExcelUtil.getCellString(row, 1, ""));
			
			if(!(StringUtils.isEmpty(companyDto.getCode()) && StringUtils.isEmpty(companyDto.getName()))){
				this.companyService.insert(companyDto);
			}
		}
	}
	
}
