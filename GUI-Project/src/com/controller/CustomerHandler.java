package com.controller;
import java.sql.SQLException;
import application.model.Customer;
import application.model.Item;


/**
 * 
 * @author Manuel Ben Bravo 
 *
 */
public class CustomerHandler extends DataHandler {

	private Customer cust;
	
	/*
	 * Creates CustomerHandler Object
	 */
	public CustomerHandler() {
		cust = new Customer();
	}
	
	public Customer getCust(String Email, String Password) throws SQLException {
		connect();
		results = fetcher.fetchCustomer(Email,Password);
		parseResults();
		return cust; 
	}
	
	public Customer addCust(String FirstName, String LastName, String Email, String Password) throws SQLException{
		connect();
		results = fetcher.addCustomer(FirstName, LastName, Email,Password);
		parseResults();
		return cust;
		
	}
	/**
	 * Parse results from DataFetcher for GetCust
	 */
	@Override
	protected void parseResults() throws SQLException {
		// TODO Auto-generated method stub
		while(results.next()) {
			cust.setEmail(results.getString("email"));
			cust.setName(results.getString("FirstName"), results.getString("LastName"));
			cust.setCusID(results.getString("CustomerID"));
		}
	}
	

	 /* 
	 * protected void parseResultsAdd() throws SQLException{
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 */
		
	
}
