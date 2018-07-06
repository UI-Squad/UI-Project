package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataFetcher {
	
	private static final String USER = "uiuser";
	private static final String PASS = "uipassword1";
	protected PreparedStatement preparedStatement = null;
	protected ResultSet resultSet = null;
	protected Connection connect = null;

	public DataFetcher() {
		try {
			// This will load the MySQL driver, each DBMS has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://45.17.26.63/ui_database?serverTimezone=UTC", USER, PASS);
			
			/*	this.connect = DriverManager
					.getConnection("jdbc:mysql://uidbinstance.cut52ysezncx.us-west-2.rds.amazonaws.com/storedb", 
									USER, PASS);*/
		} catch (Exception e) {
			// TODO: Needs to redirect to error page
			e.printStackTrace();
		}
	}
		
	/**
	 * Returns all fields from the Inventory table in the UI database.
	* @return ResultSet the results of the SQL query
	*/
	public ResultSet fetchAllInventory() {
		try {
			preparedStatement = connect.prepareStatement("select * from Inventory");
			resultSet = preparedStatement.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	/**
	 * Returns resultSet from Inventory table specified by dept.
	 * @param dept A string literal specifying the department
	 * @return resultSet results of the SQL query
	 */
	public ResultSet fetchInventoryByDept(String dept) {
		try {
			preparedStatement = connect.prepareStatement("select i.* from Inventory i where i.dept = ?");
			preparedStatement.setString(1, dept);
			resultSet = preparedStatement.executeQuery();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	/**
	 * Returns all data fields from the Carts table and the price
	 * of each matching item from the Inventory table in the GUI Database
	 * that matches the specified cartId.
	 * @param cartId A string literal representing the cart id
	 * @return ResultSet the resulSet of the SQL query
	 */
	public ResultSet fetchCart(String cartId) {
		try {
			preparedStatement = connect.prepareStatement("select c.*, i.price from Carts c, Inventory i"
									+ " where c.cartId = ? and c.itemId = i.itemId");
			preparedStatement.setString(1, cartId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
}
