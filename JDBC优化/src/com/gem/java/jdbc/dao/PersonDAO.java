package com.gem.java.jdbc.dao;

import java.util.List;

import com.gem.java.jdbc.pojo.Person;

	public interface PersonDAO{
		//1.添加新Person
		boolean addPerson(Person person);
		//2.修改特定Person信息
		boolean updatePerson(Person person);
		//3.删除特定Person信息
		boolean delPerson(int id);
		//4.查询所有Person信息
		List<Person>getPersonList();
		//5.查询特定person信息
		Person getPerson(int id);
	}

