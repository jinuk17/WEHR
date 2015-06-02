package com.wemade.solution.wehr.web.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wemade.solution.wehr.web.dao.PersonDao;
import com.wemade.solution.wehr.web.dto.PersonDto;
import com.wemade.solution.wehr.web.framework.dao.AbstractHibernateDao;

@Repository
public class PersonDaoImpl extends AbstractHibernateDao<PersonDto, Long> implements PersonDao {

	@Override
	public PersonDto selectByName(String personName) {
		Criteria criteria = this.getCriteria();
		criteria.add(Restrictions.eq("name", personName).ignoreCase());
		PersonDto dto = (PersonDto) criteria.uniqueResult();
		return dto;
	}

}
