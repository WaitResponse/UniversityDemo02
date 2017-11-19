package com.gem.java.jdbc.test;

import junit.framework.TestCase;

import com.gem.java.jdbc.dao.PersonDAO;
import com.gem.java.jdbc.dao.impl.PersonDAOImpl;
import com.gem.java.jdbc.pojo.Person;


public class PersonDAOTest  extends TestCase{
	PersonDAO personDAO=new PersonDAOImpl();
	
	public void testAddPerson(){
		Person person=new Person("´¸Ê¯",108,"°µÓ°µº");
		boolean flag=personDAO.addPerson(person);
		assertTrue(flag);
	}

	public void testUpdatePerson() {
		fail("Not yet implemented");
	}

	public void testDelPerson() {
		fail("Not yet implemented");
	}

	public void testGetPersonList() {
		fail("Not yet implemented");
	}

	public void testGetPerson() {
//		assertNull(object)
		fail("Not yet implemented");
	}
	
	
}
