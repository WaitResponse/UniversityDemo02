package com.gem.java.jdbc.dao;

import java.util.List;

import com.gem.java.jdbc.pojo.Person;

	public interface PersonDAO{
		//1.�����Person
		boolean addPerson(Person person);
		//2.�޸��ض�Person��Ϣ
		boolean updatePerson(Person person);
		//3.ɾ���ض�Person��Ϣ
		boolean delPerson(int id);
		//4.��ѯ����Person��Ϣ
		List<Person>getPersonList();
		//5.��ѯ�ض�person��Ϣ
		Person getPerson(int id);
	}

