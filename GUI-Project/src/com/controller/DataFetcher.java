package com.controller;


/**
 * @author Shane Bogard
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Item;

public class DataFetcher {
	
	private static final String USER = "uiuser";
	private static final String PASS = "uipassword1";
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private Connection connect;

	/**
	 * Constructs a new DataFetcher object.
	 */
	public DataFetcher() {
		preparedStatement = null;
		resultSet = null;
		connect = null;
	}
	
	/**
	 * Opens connection to mySQL database.
	 */
	public void connect() {
		try {
			// This will load the MySQL driver, each DBMS has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://45.17.26.63/ui_database?serverTimezone=UTC", USER, PASS);
			
			/*	this.connect = DriverManager
					.getConnection("jdbc:mysql://uidbinstance.cut52ysezncx.us-west-2.rds.amazonaws.com/storedb", 
									USER, PASS);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns a row from the Inventory table specified by itemId.
	 * @param itemId String literal specifying the itemId
	 * @return ResultSet results of the SQL query
	 */
	public ResultSet fetchItem(String itemId) {
		try {
			preparedStatement = connect.prepareStatement("select i.* from Inventory i"
								+ " where i.itemId = ?");
			preparedStatement.setString(1, itemId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			
		}
		return resultSet;
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
	
	/**
	 * Returns a ResultSet of items from the Inventory table and their matching quantities 
	 * in the Carts table by a specified cartId and joining the tables by itemId.
	 * @param cartId String literal specifying the cart Id
	 * @return ResultSet resulting SQL query
	 */
	public ResultSet fetchCartItems(String cartId) {
		try {
			preparedStatement = connect.prepareStatement("select i.itemId, i.name, i.description"
									+ ", i.dept, i.price, c.quantity from Inventory i, Carts c"
									+ " where c.cartId = ? and i.itemId = c.itemId");
			preparedStatement.setString(1, cartId);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	/**
	 * Returns a boolean value indicating if this Data Fetcher is still
	 * connected to the database.
	 * @return Boolean value
	 * @throws SQLException
	 */
	public boolean isConnected() {
		return (connect != null);
	}
	
	/**
	 * Closes the preparedStatment, resultSet and connect.
	 */
	public void close() {
		try {
			if(preparedStatement != null)
				preparedStatement.close();
			if(resultSet != null)
				resultSet.close();
			if(connect != null)
				connect.close();
		}
		catch (Exception e) {
			
		}
	}
}
