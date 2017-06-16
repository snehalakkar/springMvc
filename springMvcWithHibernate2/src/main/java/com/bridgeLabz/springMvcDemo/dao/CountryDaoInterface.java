package com.bridgeLabz.springMvcDemo.dao;

import java.util.List;

import com.bridgeLabz.springMvcDemo.model.Country;

public interface CountryDaoInterface {
	public void addCountry(Country country) throws Exception;

	public List<Country> displayAllCountry();
}
