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
	public Customer getCust(String email, String password) throws SQLException {
		connect();
		results = fetcher.fetchCustomer(email, password);
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
		return getCustomerCart(customer.getId());
	}
	
	/**
	 * 
	 * @param custId
	 * @return
	 * @throws SQLException 
	 */
	public Cart getCustomerCart(String custId) throws SQLException {
		System.out.println("CustomerID " + custId);
		results = fetcher.fetchCartbyCustomerId(custId);
		results.next();
		return new CartHandler(getFetcher()).getCart(results.getString("cartId"));
	}
	
	
	/**
	 * @throws SQLException 
	 * 
	 */
	public void returnCartToInventory(String custId, Cart cart) throws SQLException {
		results = fetcher.fetchCartbyCustomerId(custId);
		new CartHandler(getFetcher()).returnToInventory(results.getString("cartId"), cart);
		results.next();
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
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @param firstNm
	 * @param lastNm
	 * @return
	 * @throws SQLException
	 */
	public Customer addCust(String email, String password, String firstNm, String lastNm) throws SQLException{
		connect();
		fetcher.addCustomer(email, password, firstNm, lastNm);
		results = fetcher.fetchCustomer(email, password);
		results.next();
		fetcher.addCartItem(results.getString("curCart"), results.getString("customerId"), "", 0);
		return cust;
	}
	
	/**
	 * Parse results from DataFetcher for getCust
	 */
	@Override
	protected void parseResults() throws SQLException {
		cust = null;
		while(results.next()) {
			cust = new Customer(results.getString("email"), 
					results.getString("customerId"), 
					new Name(results.getString("firstNm"), 
							(results.getString("middleNm") != null) ? results.getString("middleNm") : "", 
							results.getString("lastNm")), 
					new Address((results.getString("address") != null) ? results.getString("address") : ""),
					results.getLong("phoneNum"), 
					new CartHandler(getFetcher()).getCart(results.getString("curCart")));
		}
	}	
}
