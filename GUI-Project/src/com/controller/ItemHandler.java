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
	
	public Item getItem(String itemId) throws SQLException{
		connect();
		results = fetcher.fetchItem(itemId);
		parseResults();
		return itemList.get(0);
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
	
	public ArrayList<Item> searchForItems(String search) throws SQLException{
		connect();
		results = fetcher.searchQuery(search);
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
	 * Changes the attributes of a specified Inventory item with the exception of it's unique ID. 
	 * @param itemId String literal specifying the item to update
	 * @param name String literal specifying the new name of the item
	 * @param description String literal specifying the new item's description
	 * @param dept String literal specifying the item's new department
	 * @param price String literal specifying the item's new price
	 * @param inStock String literal specifying the new in stock quantity of the item
	 */
	public void updateInventoryItem(String itemId, String name, String description, String dept,
									double price, int inStock) {
		connect();
		fetcher.updateInventoryItem(itemId, name, description, dept, price, inStock);
	}
	
	/**
	 * Changes the attributes of a specified Inventory item with the exception of it's unique ID.
	 * @param item Item object specifying the item's new attributes
	 */
	public void updateInventoryItem(Item item) {
		connect();
		fetcher.updateInventoryItem(item.getItemId(), item.getItemName(), item.getDescription(), item.getDept(), 
										item.getPrice(), item.getQuantity());
	}
	
	/**
	 * Changes a specified item's inStock field in the Inventory table. 
	 * @param itemId String literal specifying the itemId
	 * @param quantity Integer value specifying the new quantity in stock
	 */
	public void updateInventoryStock(String itemId, int quantity) {
		connect();
		fetcher.updateInventoryStock(itemId, quantity);
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
