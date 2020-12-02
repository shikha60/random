package com.lti.restcrudexample.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	private static  Connection conn =null;
	
	
	
	public static Connection getConnection() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/country","root","Rd_774998");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return conn;


	}
}
