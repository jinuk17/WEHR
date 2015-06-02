package com.wemade.solution.wehr.web.framework.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wemade.solution.wehr.web.framework.dao.impl.AbstractDao;
import com.wemade.solution.wehr.web.framework.exception.InstanceNotFoundException;

public class AbstractHibernateDao<E, K extends Serializable> implements AbstractDao<E, K> {

	@Autowired
	private SessionFactory sessionFactory;
	private Class<E> entityClass;
	
	@SuppressWarnings("unchecked")
	@Override
	public K insert(E entity) {
		return (K) this.getSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> selectAll() {
		return this.getSelectQuery().list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> selectRangeAll(int page, int range) {
		return this.getSelectQuery().setFirstResult((page-1) * range).setMaxResults(range).list();
	}
	
	private Query getSelectQuery(){
		return this.getSession().createQuery("from "+this.getDomainClassName());
	}

	@SuppressWarnings("unchecked")
	@Override
	public E selectById(K id) throws InstanceNotFoundException {
		Object entity = this.getSession().get(this.entityClass, id);
		if(entity == null){
			throw new InstanceNotFoundException(id, this.getDomainClassName());
		}
		return (E) entity;
	}

	@Override
	public long count() {
		return (long) this.getSession().createQuery("select count(*) from " + this.getDomainClassName()).uniqueResult();
	}

	@Override
	public boolean exists(K id) {
		try {
			return this.selectById(id) != null;
		} catch (InstanceNotFoundException e) {
			return false;
		}
	}

	@Override
	public void update(E entity) {
		this.getSession().merge(entity);
	}

	@Override
	public void saveOrUpdate(E entity) {
		this.getSession().saveOrUpdate(this.getDomainClassName(), entity);
	}

	@Override
	public void delete(E entity) {
		this.getSession().delete(entity);
	}

	@Override
	public void deleteById(K id) throws InstanceNotFoundException {
		this.getSession().delete(this.selectById(id));
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() {
		if(this.entityClass == null){
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			this.entityClass = (Class<E>) type.getActualTypeArguments()[0];
		}
		return entityClass;
	}

	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	private String getDomainClassName(){
		return this.getEntityClass().getName();
	}

	@Override
	public Criteria getCriteria() {
		return this.getSession().createCriteria(this.getEntityClass());
	}

}
