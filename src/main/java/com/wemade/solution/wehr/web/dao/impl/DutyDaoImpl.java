package com.wemade.solution.wehr.web.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wemade.solution.wehr.web.dao.DutyDao;
import com.wemade.solution.wehr.web.dto.DutyDto;
import com.wemade.solution.wehr.web.framework.dao.AbstractHibernateDao;

@Repository
public class DutyDaoImpl extends AbstractHibernateDao<DutyDto, Long> implements DutyDao {

	@Override
	public DutyDto selectByCode(String dutyCode) {
		Criteria criteria = this.getCriteria();
		criteria.add(Restrictions.eq("code", dutyCode).ignoreCase());
		DutyDto dto = (DutyDto) criteria.uniqueResult();
		return dto;
	}

}
