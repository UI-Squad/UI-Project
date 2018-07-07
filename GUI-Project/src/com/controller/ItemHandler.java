package com.controller;

/**
 * 
 * @author Shane Bogard
 *
 */

import java.util.ArrayList;
import application.model.Item;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemHandler {
	/** Retrieves data from server **/
	private DataFetcher fetcher;
	
	/** Results of mySQL queries **/
	private ResultSet results;
	
	/** An ArrayList of items */
	private ArrayList<Item> itemList;
	
	/**
	 * Constructs a new ItemHandler object.
	 */
	public ItemHandler() {
		fetcher = new DataFetcher();
		results = null;
		itemList = new ArrayList<Item>();
		fetcher.connect();
	}
	
	/**
	 * Returns all of the items contained in the Nile database
	 * in the form of an ArrayList of item objects.
	 * @return ArrayList of item objects
	 * @throws SQLException
	 */
	public ArrayList<Item> getAllItems() throws SQLException{
		if(!fetcher.isConnected())
			fetcher.connect();
		results = fetcher.fetchAllInventory();
		parseResults();
		return itemList;
	}
	
	/**
	 * Returns an ArrayList of item objects specified by their department.
	 * @param dept String literal specifying the items department
	 * @return ArrayList of item objects
	 * @throws SQLException 
	 */
	public ArrayList<Item> getItemsByDept(String dept) throws SQLException{
		if(!fetcher.isConnected())
			fetcher.connect();
		results = fetcher.fetchInventoryByDept(dept);
		parseResults();
		return itemList;
	}
	
	/**
	 * Parses the current resultSet into an ArrayList of item objects
	 * @throws SQLException
	 */
	private void parseResults() throws SQLException {
		itemList.clear();
		while(results.next()) {
			itemList.add(new Item(results.getString("itemId"), results.getString("name"), 
						results.getString("description"), results.getString("dept"), results.getDouble("price"),
						results.getInt("inStock")));
		}
	}

	/**
	 * Closes all the ItemHandler's connections to the database.
	 */
	public void closeConnection() {
		fetcher.close();
	}
	
}
