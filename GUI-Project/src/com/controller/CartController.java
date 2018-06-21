package com.controller;

import java.sql.*;

/**
 * Cart Controller class to modify and retrieve 
 * Shopping cart from the SQL Database 
 * 
 * @author Manuel Ben Bravo 
 */


public class CartController {

	private DataFetcher data;	/* Accesses Data from Database */ 
	
	private ResultSet results; /* Stores results from Database */
	
	
	/**
	 * Constructor for Cart Controller
	 */
	public CartController(){
		this.data = new DataFetcher();
		this.results = null;
	}
	
}