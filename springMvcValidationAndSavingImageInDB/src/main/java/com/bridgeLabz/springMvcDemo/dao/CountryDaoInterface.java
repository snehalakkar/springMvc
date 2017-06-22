package com.bridgeLabz.springMvcDemo.dao;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bridgeLabz.springMvcDemo.model.Country;

public interface CountryDaoInterface {
	public void addCountry(Country country, CommonsMultipartFile file);

	public List<Country> displayAllCountry();

	public List<Country> updateCountryDetails(int countryid);

	public void updateCountryInDataBase(Country country);

	public void deleteCountry(int deleteId);

	public byte[] getImageById(int id);

	public void deleteImageById(int id);
}
