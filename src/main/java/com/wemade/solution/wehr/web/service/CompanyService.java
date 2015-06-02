package com.wemade.solution.wehr.web.service;

import com.wemade.solution.wehr.web.dto.CompanyDto;

public interface CompanyService {

	void insert(CompanyDto companyDto);

	CompanyDto selectByCode(String companyCode);
	
}
