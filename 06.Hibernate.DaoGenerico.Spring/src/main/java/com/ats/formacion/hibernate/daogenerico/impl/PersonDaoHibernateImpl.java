package com.ats.formacion.hibernate.daogenerico.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ats.formacion.hibernate.daogenerico.PersonDao;
import com.ats.formacion.hibernate.daogenerico.modelo.Person;


public class PersonDaoHibernateImpl extends GenericHibernateDaoImpl<Person,Long> implements PersonDao {

	public PersonDaoHibernateImpl() {
		super();
		
	}

	public List<Person> findByAge(int age) {
		
		return findByCriteria(Restrictions.eq("age",age));
	}

	public Person findByNif(String nif) {
		return (Person)getSession().createQuery("From Person where nif= ?").setString(0, nif).uniqueResult();
	}



}
