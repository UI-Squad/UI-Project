package com.controller;

/**
 * @author Shane Bogard
 *
 */

import java.util.ArrayList;
import application.model.Item;
import java.sql.SQLException;

public class ItemHandler extends DataHandler {	
	/** An ArrayList of items */
	private ArrayList<Item> itemList;
	
	/**
	 * Constructs a new ItemHandler object.
	 */
	public ItemHandler() {
		super();
		itemList = new ArrayList<Item>();
	}
	
	/**
	 * Returns all of the items contained in the Nile database
	 * in the form of an ArrayList of item objects.
	 * @return ArrayList of item objects
	 * @throws SQLException
	 */
	public ArrayList<Item> getAllItems() throws SQLException{
		connect();
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
		connect();
		results = fetcher.fetchInventoryByDept(dept);
		parseResults();
		return itemList;
	}
	
	/**
	 * Parses the current resultSet into an ArrayList of item objects
	 * @throws SQLException
	 */
	protected void parseResults() throws SQLException {
		itemList.clear();
		while(results.next()) {
			itemList.add(new Item(results.getString("itemId"), results.getString("name"), 
						results.getString("description"), results.getString("dept"), results.getDouble("price"),
						results.getInt("inStock")));
		}
	}
}
