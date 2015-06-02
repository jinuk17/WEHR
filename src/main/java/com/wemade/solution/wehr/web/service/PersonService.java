package com.wemade.solution.wehr.web.service;

import java.util.List;

import com.wemade.solution.wehr.web.dto.PersonDto;

public interface PersonService {

	List<PersonDto> getPersonList();
	
	Long addPerson(PersonDto personDto);
}
