package com.wemade.solution.wehr.web.framework.view;

import java.util.List;

public class GridModel {

	@SuppressWarnings("rawtypes")
	List rows;
	long total;
	
	public long getTotal(){
		return this.total;
	};
	
	public void setTotal(long total){
		this.total = total;
	}

	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}

	@SuppressWarnings("rawtypes")
	public void setRows(List rows) {
		this.rows = rows;
	};
}
