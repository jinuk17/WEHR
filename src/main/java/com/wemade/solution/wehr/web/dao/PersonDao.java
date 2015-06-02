package com.wemade.solution.wehr.web.dao;

import com.wemade.solution.wehr.web.dto.PersonDto;
import com.wemade.solution.wehr.web.framework.dao.impl.AbstractDao;

public interface PersonDao extends AbstractDao<PersonDto, Long> {

	PersonDto selectByName(String personName);
}
