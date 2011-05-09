package com.ats.formacion.hibernate.daogenerico;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ats.formacion.hibernate.daogenerico.impl.PersonDaoHibernateImpl;

import com.ats.formacion.hibernate.daogenerico.modelo.Person;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")  
public class PersonDaoTest {
	
	@Autowired
	private PersonDao dao;
	
	@Test
	public void testCreatePerson(){
		Person person = new Person("1234g","Israel","Alcazar",31);
		Long pk = dao.create(person);
		assertNotNull(pk);
	}
	
	@Test
	public void testRetrievePersonSuccess(){
		//TODO I should insert a Person directly with SQL (use JdbcTemplate)
		Person person = new Person("1234g","Israel","Alcazar",31);
		Long pk = dao.create(person);
		
		Person person2 = dao.retrieve(1l);
		assertNotNull(person2);
		assertEquals("1234g",person.getNif());
		
		
	}
	@Test
	public void testRetrievePersonNotFound(){
		Person person = dao.retrieve(4l);
		assertNull(person);
		
	}
	@Test
	public void testDeletePersonSuccess(){
		//TODO I should insert a Person directly with SQL  (use JdbcTemplate)
		Person person = new Person();
		person.setId(1l);
		
		dao.delete(person);
		
		//TODO I should check Person deleted doesn't exist with SQL directly
		Person personRetrieved = dao.retrieve(1l);
		assertNull(personRetrieved);
		
	}

	@Test
	public void testUpdatePersonSuccess(){
		//TODO I should insert a Person directly with SQL
		Person person = new Person("1234","Luis","Sur",23);
		Long pk = dao.create(person);
		
		person.setName("Otro");
		person.setNif("2222");
		person.setSurname("OtroS");
		person.setAge(28);
		dao.update(person);
		
		//TODO I should check updated fields directly with SQL
		Person personExpected = dao.retrieve(pk);
		assertNotNull(personExpected);

		assertEquals("2222", personExpected.getNif());
		assertEquals("Otro", personExpected.getName());
		assertEquals("OtroS", personExpected.getSurname());
		assertEquals(28, personExpected.getAge());
	}
	
	@Test
	public void testFindByNifSuccess(){
		//TODO I should insert a Person directly with SQL
		Person person = new Person("1234","Luis","Sur",23);
		Long pk = dao.create(person);
		
		Person personExpected = dao.findByNif("1234");
		assertNotNull(personExpected);
		
	}
	@Test
	public void testFindByNifNotFound(){
		Person personExpected = dao.retrieve(123424l);
		assertNull(personExpected);
	}
	@Test
	public void testFindByAgeSuccess(){
		//TODO I should insert a Person directly with SQL
		Person person1 = new Person("22344","Luis","Sur",55);
		Person person2 = new Person("22345","pepe","Sur",55);
		Long pk1 = dao.create(person1);
		Long pk2 = dao.create(person2);
		
		List<Person> list = dao.findByAge(55);
		
		assertNotNull(list);
		System.out.println(list.size());
		assertTrue(list.size()==2);
	}
	
	@Test
	public void testFindByAgeNotFound(){
		//TODO I should insert a Person directly with SQL
		Person person1 = new Person("22344","Luis","Sur",54);
		Person person2 = new Person("22345","pepe","Sur",53);
		Long pk1 = dao.create(person1);
		Long pk2 = dao.create(person2);
		
		List<Person> list = dao.findByAge(99);
		
		assertNull(list);
		
	}
	

}
