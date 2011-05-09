package com.ats.formacion.hibernate.daogenerico.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ats.formacion.hibernate.daogenerico.GenericDao;

public abstract class GenericHibernateDaoImpl<T extends Serializable,ID extends Serializable> extends HibernateDaoSupport 
									implements GenericDao<T,ID>{
	
	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public GenericHibernateDaoImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                                .getGenericSuperclass()).getActualTypeArguments()[0];
    }
	
	
	@SuppressWarnings("unchecked")
	public ID create(T element) {
		return (ID)getHibernateTemplate().save(element);
	}

	public void delete(T element) {
		getHibernateTemplate().delete(element);
	}

	public List<T> findAll() {
		
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	public T retrieve(ID primaryKey) {
		return (T) getHibernateTemplate().get(getPersistentClass(), primaryKey);
		
	}
	public void update(T element) {
		getHibernateTemplate().saveOrUpdate(element);
	}
	public void flush() {
		getHibernateTemplate().flush();
    }
 
    public void clear() {
    	getHibernateTemplate().clear();
    }
    
    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        List<T> result = crit.list();
        
        return (result.size()==0?null:result);
   }
	
   
 
    
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
    
    

}
