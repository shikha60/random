package com.lti.restcrudexample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lti.restcrudexample.model.Country;

public class CountryDAO {
	static Connection conn=DBManager.getConnection();
	static Statement stmt=null;
	static PreparedStatement pstmt = null;
	
	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<Country>();
		try{
		stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from country"); 
		while (rs.next()){
			Country country=new Country();
			country.setId(rs.getInt(1));
			country.setCountryName(rs.getString(2));
			country.setCapital(rs.getString(3));
			countries.add(country);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return countries;
	}
	public Country addCountry(Country country) {
	
		try{
			pstmt= conn.prepareStatement("insert into country  values(?,?,?)");
			pstmt.setInt(1,country.getId() );
			pstmt.setString(2,country.getCountryName());
			pstmt.setString(3,country.getCapital());
			pstmt.executeUpdate();
		}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		
		return country;
	}
	
	public Country updateCountry(Country country) {
		try{
			pstmt= conn.prepareStatement("update country set id=? where countryName=?");
			pstmt.setInt(1,country.getId() );
			pstmt.setString(2,country.getCountryName());
			pstmt.executeUpdate();
		}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		
		return country;}
	
	public boolean deleteCountry(int id) {
		boolean res=true;
		try{
			pstmt= conn.prepareStatement("delete from country where id=?");
			pstmt.setInt(1, id);
			res=pstmt.execute();}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	

}
