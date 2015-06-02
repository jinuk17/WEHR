package com.wemade.solution.wehr.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wemade.solution.wehr.web.component.CompanyExcelComponent;
import com.wemade.solution.wehr.web.component.DepartmentExcelComponent;
import com.wemade.solution.wehr.web.component.EmployeeExcelComponent;
import com.wemade.solution.wehr.web.component.ExcelConstants;
import com.wemade.solution.wehr.web.dto.EmployeeDto;
import com.wemade.solution.wehr.web.dto.PersonDto;
import com.wemade.solution.wehr.web.dto.sdto.EmployeeSDto;
import com.wemade.solution.wehr.web.dto.sdto.GridSDto;
import com.wemade.solution.wehr.web.framework.view.GridModel;
import com.wemade.solution.wehr.web.service.DepartmentService;
import com.wemade.solution.wehr.web.service.EmployeeService;
import com.wemade.solution.wehr.web.service.PersonService;

@Controller
@RequestMapping(value="/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private CompanyExcelComponent companyExcelComponent;
	@Autowired
	private DepartmentExcelComponent departmentExcelComponent;
	@Autowired
	private EmployeeExcelComponent employeeExcelComponent;
	
	
	@RequestMapping(value="/columns", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public void getColumns(Model model,  @RequestBody GridSDto params){
		List<PersonDto> list = this.personService.getPersonList();
		model.addAttribute("model", list);
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public void getEmployeeList(Model model, EmployeeSDto params){
		if(params.getDepartmentId() != null){
			params.setDepartmentIds(this.departmentService.getDepartmentChildIdsById(params.getDepartmentId()));
		}
		Long totalCount = this.employeeService.getTotalCount(params);
		List<EmployeeDto> list = this.employeeService.getList(params, true);
		
		GridModel gridModel = new GridModel();
		gridModel.setTotal(totalCount);
		gridModel.setRows(list);
		model.addAttribute("model", gridModel);
	}
	
	@RequestMapping(value="/import", method=RequestMethod.POST)
	public void importExcelData(Model model, @RequestParam("file") MultipartFile file){
		
		if(file == null){
			return ;
		}
		
		InputStream is = null;
		try{
			is = file.getInputStream();
			
			Workbook workbook = null;
			
			workbook = WorkbookFactory.create(is);
			
			Sheet sheet = workbook.getSheet(ExcelConstants.COMPANY_SHEET_NAME);
			if(sheet != null){
				this.companyExcelComponent.process(sheet);
			}
			
			sheet = null;
			sheet = workbook.getSheet(ExcelConstants.DEPARTMENT_SHEET_NAME);
			if(sheet != null){
				this.departmentExcelComponent.process(sheet);
			}
			
			sheet = null;
			sheet = workbook.getSheet(ExcelConstants.EMPLOYEE_SHEET_NAME);
			if(sheet != null){
				this.employeeExcelComponent.process(sheet);
			}
			
		}catch(Exception e){
			
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				is = null;
			}
		}
	}
}
