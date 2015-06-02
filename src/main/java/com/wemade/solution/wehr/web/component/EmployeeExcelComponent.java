package com.wemade.solution.wehr.web.component;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.wemade.solution.wehr.web.dto.CompanyDto;
import com.wemade.solution.wehr.web.dto.DepartmentDto;
import com.wemade.solution.wehr.web.dto.DutyDto;
import com.wemade.solution.wehr.web.dto.EmployeeDto;
import com.wemade.solution.wehr.web.dto.PersonDto;
import com.wemade.solution.wehr.web.service.CodeService;
import com.wemade.solution.wehr.web.service.CompanyService;
import com.wemade.solution.wehr.web.service.DepartmentService;
import com.wemade.solution.wehr.web.service.EmployeeService;

@Component
public class EmployeeExcelComponent {

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CodeService codeService;
	
	Sheet sheet;
	
	public void process(Sheet sheet){
		
		this.sheet = sheet;
		
		Iterator<Row> rows = this.sheet.rowIterator();
		
		for(int i = 0; i < 1; i++){
			rows.next();
		}
		
		while(rows.hasNext()){
			
			/* 
			 * Column Info
			 * 0 : COM_CD
			 * 1 : ENTER_YMD											
			 * 2 : RETIRE_YMD
			 * 3 : EMP_CD
			 * 4 : EMP_NM
			 * 5 : DEPT_CD
			 * 6 : DEPT_NM
			 * 7 : ORG_FULL_NM
			 * 8 : EMP_ACT
			 * 9 : EMP_MAIL
			 * 10: TEL_NO
			 * 11: HP_NO
			 * 12: EMP_GRADE_NM
			 * 13: DUTY_CD
			 * 14: DUTY_NM
			 * 15: EMP_TYPE
			 * 16: O365_LIC
			 * 17: INS_YMDHMS
			 * 18: MOD_YMDHMS
			 * 19: WM 겸직
			 * 20: JM 겸직	
			 * 21: WC 겸직
			 */
			
			Row row = rows.next();
			
			EmployeeDto dto = null;
			
			String employeeCode = ExcelUtil.getCellString(row, 3, null);
			
			/*
			if(!StringUtils.isEmpty(employeeCode)){
				
				dto = this.employeeService.selectByCode(employeeCode);
				
				if(dto != null){
					continue;
				}
			}
			*/
			
			dto = new EmployeeDto();
			dto.setCode(employeeCode);
			
			String companyCode = ExcelUtil.getCellString(row, 0, null);
			
			if(!StringUtils.isEmpty(companyCode)){
				CompanyDto companyDto = this.companyService.selectByCode(companyCode);
				if(companyDto != null){
					// how to save retired employee
					dto.setCompanyDto(companyDto);
				}
			}
			
			dto.setIssueDt(ExcelUtil.getCellDate(row, 1, "yyyyDDMM", null));
			dto.setRetireDt(ExcelUtil.getCellDate(row, 2, "yyyyDDMM", null));
			
			String personName = ExcelUtil.getCellString(row, 4, null);
			
			if(!StringUtils.isEmpty(personName)){
				// Modify source that select the 'personDto' by other unique value.  
				
				PersonDto personDto = this.employeeService.selectByName(personName);
				
				if(personDto == null){
					personDto = new PersonDto();
					personDto.setName(personName);
					personDto.setHp(ExcelUtil.getCellString(row, 11, null));
					this.employeeService.insert(personDto);
				}
				
				dto.setPersonDto(personDto);
			}
			
			String departmentCode = ExcelUtil.getCellString(row, 5, null);
			
			if(!StringUtils.isEmpty(departmentCode)){
				DepartmentDto departmentDto = this.departmentService.selectByCode(departmentCode);
				if(departmentDto != null){
					dto.setDepartmentDto(departmentDto);
					departmentDto.setEmployeeDto(dto);
				}
				
				dto.setDepartmentDto(departmentDto);
			}
			
			dto.setAct(ExcelUtil.getCellString(row, 8, null));
			dto.setMail(ExcelUtil.getCellString(row, 9, null));
			dto.setTel(ExcelUtil.getCellString(row, 10, null));
			dto.setGradeName(ExcelUtil.getCellString(row, 12, null));
			dto.setEmpType(ExcelUtil.getCellString(row, 15, null));
			
			String dutyCode = ExcelUtil.getCellString(row, 13, null);
			
			if(!StringUtils.isEmpty(dutyCode)){
				DutyDto dutyDto = this.codeService.selectByCode(dutyCode);
				if(dutyDto == null){
					dutyDto = new DutyDto();
					dutyDto.setCode(dutyCode);
					dutyDto.setName(ExcelUtil.getCellString(row, 14, null));
					
					this.codeService.insert(dutyDto);
				}
				dto.setDutyDto(dutyDto);
			}

			this.employeeService.insert(dto);
		}
	}
}
