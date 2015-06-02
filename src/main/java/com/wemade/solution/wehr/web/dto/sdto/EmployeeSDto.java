package com.wemade.solution.wehr.web.dto.sdto;

import java.util.List;

public class EmployeeSDto extends GridSDto {

	private Long departmentId;
	private List<Long> departmentIds;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public List<Long> getDepartmentIds() {
		return departmentIds;
	}

	public void setDepartmentIds(List<Long> departmentIds) {
		this.departmentIds = departmentIds;
	}
}
