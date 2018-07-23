package com.controller;
/**
 * 
 * @author Manuel Ben Bravo 
 * @author Shane Bogard
 */

import java.sql.SQLException;
import application.model.Address;
import application.model.Cart;
import application.model.Customer;
import application.model.Name;

public class CustomerHandler extends DataHandler {

	/** Customer object */
	private Customer cust;
	
	/**
	 * Creates CustomerHandler Object
	 */
	public CustomerHandler() {
		super();
		cust = null;
	}
	
	/**
	 * 
	 * @param Email
	 * @param Password
	 * @return
	 * @throws SQLException
	 */
	public Customer getCust(String Email, String Password) throws SQLException {
		connect();
		results = fetcher.fetchCustomer(Email,Password);
		parseResults();
		return cust; 
	}
	
	/**
	 * Returns the cart for the specified Customer
	 * @param customer Customer object specifying the customer's cart to update
	 * @return Cart cart object representing the updated cart
	 * @throws SQLException 
	 */
	public Cart getCustomerCart(Customer customer) throws SQLException {
		results = fetcher.fetchCartbyCustomerId(customer.getId());
		results.next();
		return new CartHandler(getFetcher()).getCart(results.getString("cartId"));
	}
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @param custId
	 * @param firstNm
	 * @param middleNm
	 * @param lastNm
	 * @param address
	 * @param phoneNum
	 * @param cartId
	 */
	public void addCust(String email, String password, String custId, String firstNm, String middleNm, String lastNm,
					String address, int phoneNum, String cartId) {
		connect();
		fetcher.addCustomer(email, password, custId, firstNm, middleNm, lastNm, address, phoneNum, cartId);
			
	}
	
	public Customer addCust(String FirstName, String LastName, String Email, String Password) throws SQLException{
		connect();
		fetcher.addCustomer(FirstName, LastName, Email, Password);
		return cust;
		
	}
	
		
	/*public String getCartID(String CustID) throws SQLException {
		connect();
		fetcher.fetchCartID(CustID);
		return (results.getString("curCart"));
	}*/

	
	/**
	 * Parse results from DataFetcher for getCust
	 */
	@Override
	protected void parseResults() throws SQLException {
		cust = null;
		while(results.next()) {
			cust = new Customer(results.getString("Email"), results.getString("CustomerID"), 
					new Name(results.getString("FirstName"), results.getString("middleNm"), 
							results.getString("LastName")), new Address(results.getString("address")),
							results.getLong("phoneNm"), new CartHandler(getFetcher()).getCart(results.getString("curCart")));
		}
	}	
}
