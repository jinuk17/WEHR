package com.wemade.solution.wehr.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemade.solution.wehr.web.dao.DutyDao;
import com.wemade.solution.wehr.web.dto.DutyDto;
import com.wemade.solution.wehr.web.service.CodeService;

@Service
@Transactional(readOnly = true)
public class CodeServiceImpl implements CodeService{

	@Autowired
	private DutyDao dutyDao;
	
	@Override
	public DutyDto selectByCode(String dutyCode) {
		return this.dutyDao.selectByCode(dutyCode);
	}

	@Override
	@Transactional(readOnly = false)
	public void insert(DutyDto dutyDto) {
		this.dutyDao.insert(dutyDto);
	}

}
