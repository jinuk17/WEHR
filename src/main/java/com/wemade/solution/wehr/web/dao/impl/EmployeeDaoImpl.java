package com.wemade.solution.wehr.web.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wemade.solution.wehr.web.dao.EmployeeDao;
import com.wemade.solution.wehr.web.dto.EmployeeDto;
import com.wemade.solution.wehr.web.dto.PersonDto;
import com.wemade.solution.wehr.web.dto.sdto.EmployeeSDto;
import com.wemade.solution.wehr.web.framework.dao.AbstractHibernateDao;

@Repository
public class EmployeeDaoImpl extends AbstractHibernateDao<EmployeeDto, Long> implements EmployeeDao {

	@Override
	public EmployeeDto selectByCode(String employeeCode) {
		Criteria criteria = this.getCriteria();
		criteria.add(Restrictions.eq("code", employeeCode).ignoreCase());
		EmployeeDto dto = (EmployeeDto) criteria.uniqueResult();
		return dto;
	}
	
	@Override
	public Long countByParams(EmployeeSDto params) {
		Criteria criteria = this.getSearchCriteria(params);
		return (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeDto> selectByParams(EmployeeSDto params, boolean isPaging) {
		Criteria criteria = this.getSearchCriteria(params);
		if(params.getSort() != null && params.getOrder() != null){
			
			String sortColumn = params.getSort();
			
			if(params.getOrder().equals("desc")){
				criteria.addOrder(Order.desc(sortColumn));
			}else if(params.getOrder().equals("asc")){
				criteria.addOrder(Order.asc(sortColumn));
			}
		}
		
		if(isPaging){
			criteria.setFirstResult((params.getPage()-1)*params.getRows()).setMaxResults(params.getRows());
		}
		return criteria.list();
	}
	
	private Criteria getSearchCriteria(EmployeeSDto params){
		Criteria criteria = this.getCriteria();
		if(params.getDepartmentIds() != null){
			criteria.createAlias("departments", "dept");
			criteria.add(Restrictions.in("dept.id", params.getDepartmentIds()));
		}
		
		return criteria;
	}

}
