package com.wemade.solution.wehr.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemade.solution.wehr.web.dao.PersonDao;
import com.wemade.solution.wehr.web.dto.PersonDto;
import com.wemade.solution.wehr.web.service.PersonService;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;

	@Override
	public List<PersonDto> getPersonList() {
		return this.personDao.selectAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Long addPerson(PersonDto personDto) {
		return this.personDao.insert(personDto);
	}
	
}
