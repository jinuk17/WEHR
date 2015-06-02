package com.wemade.solution.wehr.web.service;

import java.util.List;

import com.wemade.solution.wehr.web.dto.DepartmentDto;

public interface DepartmentService {

	void insert(DepartmentDto departmentDto);

	DepartmentDto selectByCode(String departmentCode);

	List<DepartmentDto> getRoots(Long companyId);
	
	List<Long> getDepartmentChildIdsById(Long id);
}
