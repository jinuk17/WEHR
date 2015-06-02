package com.wemade.solution.wehr.web.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wemade.solution.wehr.web.dao.DepartmentDao;
import com.wemade.solution.wehr.web.dto.DepartmentDto;
import com.wemade.solution.wehr.web.framework.dao.AbstractHibernateDao;

@Repository
public class DepartmentDaoImpl extends AbstractHibernateDao<DepartmentDto, Long> implements DepartmentDao {

	@Override
	public boolean exists(DepartmentDto departmentDto) {
		if(departmentDto.getId() != null){
			return this.exists(departmentDto.getId());
		}else{
			DepartmentDto dto = this.selectByCode(departmentDto.getCode());
			return dto != null;
		}
	}

	@Override
	public DepartmentDto selectByCode(String departmentCode) {
		Criteria criteria = this.getCriteria();
		criteria.add(Restrictions.eq("code", departmentCode).ignoreCase());
		DepartmentDto dto = (DepartmentDto) criteria.uniqueResult();
		return dto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DepartmentDto> selectRootsByCompanyId(Long companyId) {
		Criteria criteria = this.getCriteria();
		criteria.add(Restrictions.eq("companyDto.id", companyId));
		criteria.add(Restrictions.isNull("parentDto.id"));
		return	(List<DepartmentDto>)criteria.list();
	}

}
