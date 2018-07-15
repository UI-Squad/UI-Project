package com.controller;
/**
 * @author Shane Bogard
 */

import java.sql.SQLException;
import java.util.ArrayList;
import application.model.Cart;
import application.model.Item;

public class CartHandler extends DataHandler {	
	
	/** A Cart object */
	private Cart cart;
	
	/** An ArrayList of items */
	private ArrayList<Item> itemList;
	
	public CartHandler(DataFetcher fetcher) {
		super(fetcher);
		cart = new Cart();
		itemList = new ArrayList<Item>();
	}
	
	/**
	 * Constructs a new CartHandler object.
	 */
	public CartHandler() {
		this(new DataFetcher());
	}
	
	/**
	 * Returns a Cart object specified by a cart ID.
	 * @param cartId String literal specifying the cart ID
	 * @return Cart A cart object
	 * @throws SQLException 
	 */
	public Cart getCart(String cartId) throws SQLException{
		connect();
		results = fetcher.fetchCartItems(cartId);
		parseResults();
		return cart;
	}
	
	public void addCartItem() {
		
	}
	
	/**
	 * Parses the ResultSet into a Cart object.
	 * @throws SQLException 
	 */
	protected void parseResults() throws SQLException {
		itemList.clear();
		cart = new Cart();
		while(results.next()) {
			itemList.add(new Item(results.getString("itemId"), results.getString("name"), 
						results.getString("description"), results.getString("dept"), results.getDouble("price"),
						results.getInt("quantity")));
		}
		cart.setCartItems(itemList);
	}
}
