package com.bridgeLabz.SpringHibernateDemo.Dao;

import java.util.List;

import com.bridgeLabz.SpringHibernateDemo.model.Person;

public interface PersonDaoInterface {
	public void save(Person p);

	public List<Person> list();

}
