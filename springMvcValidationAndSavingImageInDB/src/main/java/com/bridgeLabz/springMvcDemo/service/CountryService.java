package com.bridgeLabz.springMvcDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bridgeLabz.springMvcDemo.dao.CountryDaoInterface;
import com.bridgeLabz.springMvcDemo.model.Country;

@Service

public class CountryService {

	@Autowired
	CountryDaoInterface CountryDaoImplementation;

	@Transactional
	public void addCountry(Country country, CommonsMultipartFile file) {
		CountryDaoImplementation.addCountry(country,file);
	}

	@Transactional
	public List<Country> displayAllCountry() {
		return CountryDaoImplementation.displayAllCountry();
	}

	@Transactional
	public List<Country> updateCountryDetails(int countryid) {
		System.out.println(countryid);
		return CountryDaoImplementation.updateCountryDetails(countryid);
	}

	@Transactional
	public void updateCountryInDataBase(Country country) {
		CountryDaoImplementation.updateCountryInDataBase(country);
	}

	@Transactional
	public void deleteCountry(int deleteId) {
		CountryDaoImplementation.deleteCountry(deleteId);

	}

	@Transactional
	public byte[] getImageById(int id) {
		return CountryDaoImplementation.getImageById(id);
	}

	@Transactional
	public void deleteImageById(int id) {
		CountryDaoImplementation.deleteImageById(id);
	}
}
