package com.bridgeLabz.springMvcDemo.dao;

import java.util.List;

import com.bridgeLabz.springMvcDemo.model.Country;

public interface CountryDaoInterface {
	public void addCountry(Country country);

	public List<Country> displayAllCountry();

	public List<Country> updateCountryDetails(int countryid);

	public void updateCountryInDataBase(Country country);

	public void deleteCountry(int deleteId);
}
