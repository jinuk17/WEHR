package com.wemade.solution.wehr.web.component;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.wemade.solution.wehr.web.dto.CompanyDto;
import com.wemade.solution.wehr.web.dto.DepartmentDto;
import com.wemade.solution.wehr.web.service.CompanyService;
import com.wemade.solution.wehr.web.service.DepartmentService;

@Component
public class DepartmentExcelComponent {

	@Autowired
	private DepartmentService departmentService;
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
			
			int colIdx= 0;
			Row row = rows.next();
			
			DepartmentDto dto = new DepartmentDto();
			
			dto.setStartDt(ExcelUtil.getCellDate(row, colIdx++, "YYYYMMDD", null));
			dto.setEndDt(ExcelUtil.getCellDate(row, colIdx++, "YYYYMMDD", null));
			
			String companyCode = ExcelUtil.getCellString(row, colIdx++, null);
			
			CompanyDto companyDto = this.companyService.selectByCode(companyCode);
			
			dto.setCompanyDto(companyDto);
			
			String parentCode = ExcelUtil.getCellString(row, colIdx++, null);
			
			if(!StringUtils.isEmpty(parentCode)){
				DepartmentDto parentDto = this.departmentService.selectByCode(parentCode);
				dto.setParentDto(parentDto);
			}
			
			//TOPDEPT_NM
			colIdx++;
			
			dto.setCode(ExcelUtil.getCellString(row, colIdx++, null));
			dto.setName(ExcelUtil.getCellString(row, colIdx++, null));

			//ORG_FULL_NM
			colIdx++;
			
			dto.setAct(ExcelUtil.getCellString(row, colIdx++, null));
			dto.setMail(ExcelUtil.getCellString(row, colIdx++, null));
			
			this.departmentService.insert(dto);
		}
	}
}
