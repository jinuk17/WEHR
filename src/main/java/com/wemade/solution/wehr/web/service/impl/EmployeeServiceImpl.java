package com.wemade.solution.wehr.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemade.solution.wehr.web.dao.EmployeeDao;
import com.wemade.solution.wehr.web.dao.PersonDao;
import com.wemade.solution.wehr.web.dto.EmployeeDto;
import com.wemade.solution.wehr.web.dto.PersonDto;
import com.wemade.solution.wehr.web.dto.sdto.EmployeeSDto;
import com.wemade.solution.wehr.web.service.EmployeeService;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private PersonDao personDao;
	
	@Override
	public PersonDto selectByName(String personName) {
		return this.personDao.selectByName(personName);
	}

	@Override
	public EmployeeDto selectByCode(String employeeCode) {
		return this.employeeDao.selectByCode(employeeCode);
	}

	@Override
	@Transactional(readOnly = false)
	public void insert(PersonDto personDto) {
		this.personDao.insert(personDto);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void insert(EmployeeDto dto) {
		this.employeeDao.insert(dto);
	}

	@Override
	public List<EmployeeDto> getList(EmployeeSDto params, boolean isPaging){
		return this.employeeDao.selectByParams(params, isPaging);
	}

	@Override
	public Long getTotalCount(EmployeeSDto params) {
		return this.employeeDao.countByParams(params);
	}
	
}
