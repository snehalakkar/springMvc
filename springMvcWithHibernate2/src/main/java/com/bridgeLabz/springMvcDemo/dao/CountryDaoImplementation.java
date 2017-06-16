package com.bridgeLabz.springMvcDemo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.bridgeLabz.springMvcDemo.model.Country;

@Repository
public class CountryDaoImplementation implements CountryDaoInterface {

	@Autowired
	@Qualifier("hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;

	/*
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 */

	public void addCountry(Country country)  {
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		try {
			session.save(country);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
		} 
	}

	public List<Country> displayAllCountry() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Country");
		List<Country> list = query.list();
		for (Object o1 : list) {
			System.out.println(o1);
		}
		tran.commit();
		return list;
	}
}
