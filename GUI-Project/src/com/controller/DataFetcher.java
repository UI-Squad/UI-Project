package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataFetcher {
	
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private Connection connect = null;
	
	private static final String USER = "uiuser";
	private static final String PASS = "uipassword1";
	
	public DataFetcher() {
		try {
			// This will load the MySQL driver, each DBMS has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			this.connect = DriverManager
					.getConnection("jdbc:mysql://uidbinstance.cut52ysezncx.us-west-2.rds.amazonaws.com/storedb", 
									USER, PASS);
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
}
