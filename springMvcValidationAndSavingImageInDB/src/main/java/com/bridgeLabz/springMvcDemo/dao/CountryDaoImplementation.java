package com.bridgeLabz.springMvcDemo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

	public void addCountry(Country country, CommonsMultipartFile file) {
		Session session = sessionFactory.getCurrentSession();

		String filename = file.getOriginalFilename();
		// InputStream inputStream=file.getInputStream();
		/*
		 * byte[] bytes=file.getBytes(); country.setFlag(bytes);
		 */
		try {
			// Transaction tran = session.beginTransaction();
			session.save(country);
			// tran.commit();
		} catch (Exception e) {
			// session.getTransaction().rollback();
			System.out.println("catch of addcountry");
		}
	}

	public List<Country> displayAllCountry() {
		Session session = sessionFactory.getCurrentSession();
		// Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from Country");
		List<Country> list = query.list();
		/*
		 * for (Object o1 : list) { System.out.println(o1); }
		 */
		// tran.commit();
		return list;
	}

	public List<Country> updateCountryDetails(int countryid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Country c where c.id=" + countryid);
		List<Country> list = query.list();
		return list;
	}

	public void updateCountryInDataBase(Country country) {
		Session session = sessionFactory.getCurrentSession();
		int id = country.getId();
		session.update(country);
		System.out.println("update successfully executed....");
	}

	public void deleteCountry(int deleteId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete Country c where c.id=" + deleteId);
		int result = query.executeUpdate();
		System.out.println("delete successfully executed....");

	}

	public byte[] getImageById(int id) {
		
		byte[] imageData = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Country c where c.id=" + id);
		List<Country> list = query.list();
		if(list != null && list.size() > 0) {
			imageData = list.get(0).getfile();
		}
		return imageData;
	}

	public void deleteImageById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query =session.createQuery("update Country c set c.file=? where c.id="+id);
		query.setParameter(0,null);
		query.executeUpdate();
		System.out.println("image successfully deleted....");
	}

}
