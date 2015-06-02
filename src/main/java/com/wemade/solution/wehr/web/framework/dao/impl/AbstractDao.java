package com.wemade.solution.wehr.web.framework.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

import com.wemade.solution.wehr.web.framework.exception.InstanceNotFoundException;

public interface AbstractDao<E, K extends Serializable> {
	
	K insert(E entity);
	
	List<E> selectAll();
	List<E> selectRangeAll(int page, int range);
	E selectById(K id) throws InstanceNotFoundException;
	
	long count();
	boolean exists(K id);
	
	void update(E entity);
	void saveOrUpdate(E entity);
	
	void delete(E entity);
	void deleteById(K id) throws InstanceNotFoundException;
	
	Criteria getCriteria() ;

}
