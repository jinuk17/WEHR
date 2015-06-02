package com.wemade.solution.wehr.web.dao;

import java.util.List;

import com.wemade.solution.wehr.web.dto.EmployeeDto;
import com.wemade.solution.wehr.web.dto.PersonDto;
import com.wemade.solution.wehr.web.dto.sdto.EmployeeSDto;
import com.wemade.solution.wehr.web.framework.dao.impl.AbstractDao;

public interface EmployeeDao extends AbstractDao<EmployeeDto, Long> {

	EmployeeDto selectByCode(String employeeCode);
	
	Long countByParams(EmployeeSDto params);

	List<EmployeeDto> selectByParams(EmployeeSDto params, boolean isPaging);

}
