package com.bridgeLabz.springMvcDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeLabz.springMvcDemo.dao.CountryDaoInterface;
import com.bridgeLabz.springMvcDemo.model.Country;

@Service
@Transactional
public class CountryService {

	@Autowired
	CountryDaoInterface CountryDaoImplementation;
	
	@Transactional
	public void addCountry(Country country) throws Exception{
		CountryDaoImplementation.addCountry(country);
	}
	
	@Transactional
	public List<Country> displayAllCountry() 
	{
		return CountryDaoImplementation.displayAllCountry();
	}
}
