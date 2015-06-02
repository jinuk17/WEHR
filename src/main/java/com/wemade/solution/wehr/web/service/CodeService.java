package com.wemade.solution.wehr.web.service;

import com.wemade.solution.wehr.web.dto.DutyDto;

public interface CodeService {

	DutyDto selectByCode(String dutyCode);

	void insert(DutyDto dutyDto);
}
