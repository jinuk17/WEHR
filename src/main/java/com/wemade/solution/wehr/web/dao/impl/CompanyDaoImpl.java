package com.wemade.solution.wehr.web.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wemade.solution.wehr.web.dao.CompanyDao;
import com.wemade.solution.wehr.web.dto.CompanyDto;
import com.wemade.solution.wehr.web.framework.dao.AbstractHibernateDao;

@Repository
public class CompanyDaoImpl extends AbstractHibernateDao<CompanyDto, Long> implements CompanyDao {

	@Override
	public boolean exists(CompanyDto companyDto) {
		if(companyDto.getId() != null){
			return this.exists(companyDto.getId());
		}else{
			CompanyDto dto = this.selectByCode(companyDto.getCode());
			return dto != null;
		}
	}

	@Override
	public CompanyDto selectByCode(String companyCode) {
		Criteria criteria = this.getCriteria();
		criteria.add(Restrictions.eq("code", companyCode).ignoreCase());
		CompanyDto dto = (CompanyDto) criteria.uniqueResult();
		return dto;
	}

}
