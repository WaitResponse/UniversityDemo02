package com.gem.Hibernate.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.gem.Hibernate.pojo.Person;

public class PersonTest {
	private Session session;
	@Before
	public void setup(){
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		session=factory.openSession();
	}
	@Test
	public void test01(){
		//configure(),不带参数表示默认找src目录下的hibernate.cfg.xml文件
		Person person=new Person("jack",20,"suzhou");
		session.save(person);
	}
	@Test
	public void test02(){
		Person person=session.load(Person.class,1);
		System.out.println(person);
	}
	@Test
	public void test03(){
		Person person=session.load(Person.class,1);
		person.setAddress("苏州");
		session.update(person);
		session.beginTransaction().commit();
	}
	@Test
	public void test04(){
		Person person=session.load(Person.class, 1);
		session.delete(person);
		session.beginTransaction().commit();
	}
	@Test
	public void test05(){
		//Query query=session.createQuery("from Person");
		Criteria criteria=session.createCriteria(Person.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		
		List<Person>personList=criteria.list();
		for(Person person:personList){
			System.out.println(person);
		}
		
	}
}
