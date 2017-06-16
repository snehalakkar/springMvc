package com.bridgeLabz.SpringHibernateDemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bridgeLabz.SpringHibernateDemo.Dao.PersonDao;
import com.bridgeLabz.SpringHibernateDemo.model.Person;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("in spring");
		PersonDao personDAO = (PersonDao) context.getBean("personDAO");
		System.out.println("out spring");

		Person person = new Person();
		person.setName("snehal");
		person.setCountry("India");

		personDAO.save(person);

		System.out.println("Person::" + person);

		List<Person> list = personDAO.list();

		for (Person p : list) {
			System.out.println("Person List::" + p);
		}
		
	}
}
