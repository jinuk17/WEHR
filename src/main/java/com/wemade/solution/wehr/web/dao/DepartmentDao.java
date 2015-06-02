package com.wemade.solution.wehr.web.dao;

import java.util.List;

import com.wemade.solution.wehr.web.dto.DepartmentDto;
import com.wemade.solution.wehr.web.framework.dao.impl.AbstractDao;

public interface DepartmentDao extends AbstractDao<DepartmentDto, Long>{

	boolean exists(DepartmentDto departmentDto); 
		
	DepartmentDto selectByCode(String departmentCode);

	List<DepartmentDto> selectRootsByCompanyId(Long companyId);

}
