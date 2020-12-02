package com.lti.restcrudexample.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lti.restcrudexample.model.Country;
import com.lti.restcrudexample.service.CountryService;



@Path("/countries")
public class CountryController {
	
	/*@GET
	public String printMessage(){
		return "API wroking fine";
	}*/
	
	//create service class object to call service class method
	CountryService countServ=new CountryService();
	@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_ATOM_XML)
	public List<Country> getCountries() {
		List<Country> countries =countServ.getAllCountries();
		return countries;
		
	}
	@GET
	@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Country getCountries(@PathParam("id")String s) {
			Country country =countServ.getAllCountries().get(Integer.parseInt(s)-1);
			//System.out.println(country);
			return country;
			
		}
	@POST
	@Path("/addcountry")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(Country country) {
		return countServ.addCountry(country);
	}
	
	@PUT
	@Path("/updatecountry") 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Country updateCountry(Country country) {
		return countServ.updateCountry(country);
	}
	@DELETE
	@Path("/deletecountry/{id}") 
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteCountry(@PathParam("id")int id){
		boolean res=countServ.deleteCountry(id);
		if(!res)
		return "country deleted successfully";
		else
			return "country not found";
	}
	
	

}
