package com.wemade.solution.wehr.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemade.solution.wehr.web.dao.CompanyDao;
import com.wemade.solution.wehr.web.dto.CompanyDto;
import com.wemade.solution.wehr.web.service.CompanyService;

@Service
@Transactional(readOnly = true)
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	@Transactional(readOnly = false)
	public void insert(CompanyDto companyDto) {
		if(!this.companyDao.exists(companyDto)){
			this.companyDao.insert(companyDto);
		}
	}

	@Override
	public CompanyDto selectByCode(String companyCode) {
		return this.companyDao.selectByCode(companyCode);
	}
}
