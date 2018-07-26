package com.controller;
/**
 * @author Shane Bogard
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import application.model.Cart;
import application.model.Item;

public class CartHandler extends DataHandler {	
	
	/** A Cart object */
	private Cart cart;
	
	/** An ArrayList of items */
	private ArrayList<Item> itemList;
	
	private String cartId;
		
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
	 * 
	 * @param customerId
	 * @return
	 * @throws SQLException 
	 */
	public Cart getCartByCustomerId(String customerId) throws SQLException {
		connect();
		results = fetcher.fetchCartId(customerId);
		results.next();
		cartId = (results.getString("curCart") != null) ? results.getString("curCart") : "guest";
		results = fetcher.fetchCartItems(cartId);
		parseResults();
		return cart;
	}
	
	/**
	 * Returns a Cart object specified by a cart ID.
	 * @param cartId String literal specifying the cart ID
	 * @return Cart A cart object
	 * @throws SQLException 
	 */
	public Cart getCart(String cartId) throws SQLException{
		this.cartId = cartId;
		connect();
		results = fetcher.fetchCartItems(cartId);
		parseResults();
		return cart;
	}
	/**
	 * Generate cart and returns cart for Guest Checkout function
	 * @return
	 * @throws SQLException
	 */
	
	public Cart generateCart() throws SQLException {
		String car = "car";
		Random rand = new Random();
		int random = rand.nextInt(999);
		car += Integer.toString(random);
		return (getCart(car));
	}
	
	/**
	 * 
	 * @param cartId
	 * @param customerId
	 * @param itemId
	 * @param quantity
	 */
	public void addCartItem(String cartId, String customerId, String itemId, int quantity) {
		connect();
		if(!itemId.equals("") || quantity > 0) {
			//retrieve item stock from Inventory
			int stock = fetcher.fetchInventoryItemStock(itemId);
			//add item to cart if there is enough available in inventory
			if(stock >= quantity) {
				fetcher.addCartItem(cartId, customerId, itemId, quantity);
				fetcher.updateInventoryStock(itemId, stock - quantity);
			}
			//delete any non-existent items
			fetcher.removeCartItem(cartId, "");
		}else {
			fetcher.addCartItem(cartId, customerId, itemId, quantity);
		}
	}
	
	/**
	 * 
	 * @param cartId
	 * @param itemId
	 * @param quantity
	 */
	public void addCartItem(String cartId, String itemId, int quantity) {
		connect();
		if(!itemId.equals("") || quantity > 0) {
			//retrieve item stock from Inventory
			int stock = fetcher.fetchInventoryItemStock(itemId);
			//add item to cart if there is enough available in inventory
			if(stock >= quantity) {
				fetcher.addCartItem(cartId, itemId, quantity);
				fetcher.updateInventoryStock(itemId, stock - quantity);
			}
			//delete any non-existent items
			fetcher.removeCartItem(cartId, "");
		}else {
			fetcher.addCartItem(cartId, itemId, quantity);
		}
	}
	
	/**
	 * 
	 * @param cartId
	 * @param itemId
	 * @throws SQLException 
	 */
	public void removeCartItem(String cartId, String itemId) throws SQLException {
		int quantity = 0;
		int newStock = 0;
		connect();
		// fetch item from Cart
		results = fetcher.fetchCartItem(cartId, itemId);
		results.next();
		quantity = results.getInt("quantity");
		//fetch item from Inventory
		results = fetcher.fetchItem(itemId);
		results.next();
		newStock = quantity + results.getInt("inStock");
		//update Inventory to reflect new inStock quantity
		fetcher.removeCartItem(cartId, itemId);
		fetcher.updateInventoryStock(itemId, newStock);	
	}
	
	/**
	 * 
	 * @param cartId
	 * @param cart
	 * @throws SQLException 
	 */
	public void returnToInventory(String cartId, Cart cart) throws SQLException {
		for(Item item: cart.getCartItems()) {
			removeCartItem(cartId, item.getItemId());
		}
	}
		
	/**
	 * Parses the ResultSet into a Cart object.
	 * @throws SQLException 
	 */
	protected void parseResults() throws SQLException {
		itemList.clear();
		cart = new Cart(cartId);
		while(results.next()) {
			itemList.add(new Item((results.getString("itemId") != null ? results.getString("itemId") : ""), 
						(results.getString("name") != null) ? results.getString("name") : "", 
						(results.getString("description") != null) ? results.getString("description") : "", 
						(results.getString("dept") != null) ? results.getString("dept") : "",
						results.getDouble("price"),
						results.getInt("quantity")));
		}
		cart.setCartItems(itemList);
	}
}
