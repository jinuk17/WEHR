package com.wemade.solution.wehr.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemade.solution.wehr.web.dao.DepartmentDao;
import com.wemade.solution.wehr.web.dto.DepartmentDto;
import com.wemade.solution.wehr.web.framework.exception.InstanceNotFoundException;
import com.wemade.solution.wehr.web.service.DepartmentService;

@Service
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	@Transactional(readOnly = false)
	public void insert(DepartmentDto departmentDto) {
		if(!this.departmentDao.exists(departmentDto)){
			this.departmentDao.insert(departmentDto);
		}
	}

	@Override
	public DepartmentDto selectByCode(String departmentCode) {
		return this.departmentDao.selectByCode(departmentCode);
	}

	@Override
	public List<DepartmentDto> getRoots(Long companyId) {
		return this.departmentDao.selectRootsByCompanyId(companyId);
	}

	@Override
	public List<Long> getDepartmentChildIdsById(Long id) {
		List<Long> ids = new ArrayList<Long>();
		try {
			DepartmentDto departmentDto = this.departmentDao.selectById(id);
			generateDepartmentIds(ids, departmentDto);
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
		return ids;
	}
	
	private void generateDepartmentIds(List<Long> ids, DepartmentDto departmentDto){
		ids.add(departmentDto.getId());
		List<DepartmentDto> childrenList = departmentDto.getChildren();
		if(childrenList == null){
			return ;
		}
		for(DepartmentDto childCodeDto : childrenList){
			generateDepartmentIds(ids, childCodeDto);
		}
	}

}
