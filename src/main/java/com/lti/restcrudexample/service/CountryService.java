package com.lti.restcrudexample.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.lti.restcrudexample.dao.CountryDAO;
import com.lti.restcrudexample.model.Country;

public class CountryService {

	static HashMap<Integer, Country> countryIdMap = getCountryIdMap();

	private static HashMap<Integer, Country> getCountryIdMap() {
		return countryIdMap;
	}

	public CountryService() {
		super();
		if (countryIdMap == null) {

			// creating a hashmap to store the country values
			countryIdMap = new HashMap<Integer, Country>();

			// creating some country objects while initializing

			Country indiaCountry = new Country(1, "India", "New Delhi");
			Country usaCountry = new Country(2, "USA", "Washington DC");
			Country italyCountry = new Country(3, "Italy", "Rome");
			Country greeceCountry = new Country(4, "Greece", "Athens");
			Country japanCountry = new Country(5, "Japan", "Tokyo");
			Country chinaCountry = new Country(6, "China", "Beijing");
			Country ukCountry = new Country(7, "UK", "London");
			Country malaysiaCountry = new Country(8, "Malaysia", "Kuala Lampur");

			// adding objects to map
			countryIdMap.put(1, indiaCountry);
			countryIdMap.put(2, usaCountry);
			countryIdMap.put(3, italyCountry);
			countryIdMap.put(4, greeceCountry);
			countryIdMap.put(5, japanCountry);
			countryIdMap.put(6, chinaCountry);
			countryIdMap.put(7, ukCountry);
			countryIdMap.put(8, malaysiaCountry);

		} // closing of if
	}// closing of constructor
	CountryDAO cdao =new CountryDAO();
	public List<Country> getAllCountries() {

		//List<Country> countries = new ArrayList<Country>(countryIdMap.values());
		//return countries;
		return cdao.getAllCountries();
	}
	
	public Country updateCountry(Country country) {
		// TODO Auto-generated method stub
		if(country.getId()<=0)
			return null;
		//countryIdMap.put(country.getId(), country);
		//return country;
		return cdao.updateCountry(country);
		}
		
	public Country addCountry(Country country) {
		//country.setId(countryIdMap.size() + 1);
		//countryIdMap.put(country.getId(), country);
		//return country;
		return cdao.addCountry(country);
		
	}
	
	public boolean deleteCountry(int id) {
		//countryIdMap.remove(id);
		boolean res=cdao.deleteCountry(id);
		return res;
	}

}


