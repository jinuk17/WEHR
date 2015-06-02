package com.wemade.solution.wehr.web.service;

import java.util.List;

import com.wemade.solution.wehr.web.dto.EmployeeDto;
import com.wemade.solution.wehr.web.dto.PersonDto;
import com.wemade.solution.wehr.web.dto.sdto.EmployeeSDto;

public interface EmployeeService {
	
	EmployeeDto selectByCode(String employeeCode);

	PersonDto selectByName(String personName);

	void insert(EmployeeDto dto);

	void insert(PersonDto personDto);

	List<EmployeeDto> getList(EmployeeSDto params, boolean isPaging);

	Long getTotalCount(EmployeeSDto params);
}
