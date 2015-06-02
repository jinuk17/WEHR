package com.wemade.solution.wehr.web.dao;

import com.wemade.solution.wehr.web.dto.CompanyDto;
import com.wemade.solution.wehr.web.framework.dao.impl.AbstractDao;

public interface CompanyDao extends AbstractDao<CompanyDto, Long>{

	boolean exists(CompanyDto companyDto);

	CompanyDto selectByCode(String companyCode);

}
