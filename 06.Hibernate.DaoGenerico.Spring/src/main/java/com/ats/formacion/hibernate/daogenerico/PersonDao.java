package com.ats.formacion.hibernate.daogenerico;

import java.util.List;

import com.ats.formacion.hibernate.daogenerico.modelo.Person;



public interface PersonDao extends GenericDao<Person,Long>{
	
	public Person findByNif(String nif);
	public List<Person> findByAge(int age);

}
