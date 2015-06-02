package com.wemade.solution.wehr.web.dao;

import com.wemade.solution.wehr.web.dto.DutyDto;
import com.wemade.solution.wehr.web.framework.dao.impl.AbstractDao;

public interface DutyDao extends AbstractDao<DutyDto, Long> {

	DutyDto selectByCode(String dutyCode);

}
