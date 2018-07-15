package com.controller;
/**
 * @author ShaneBogard
 */

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import application.model.Cart;
import application.model.Order;

public class OrderHandler extends DataHandler{

	/**
	 * Order object
	 */
	private Order order;
	
	/**
	 * Cart object
	 */
	private Cart cart;
	
	/**
	 * Constructs a new OrderHandler object.
	 */
	public OrderHandler() {
		super();
		order = null;
		cart = null;
	}
	
	/**
	 * Returns an order object that is created based upon a specified orderId
	 * @param orderId String literal specifying the id of the order.
	 * @return Order object
	 * @throws SQLException
	 */
	public Order getOrder(String orderId) throws SQLException {
		connect();
		results = fetcher.fetchOrder(orderId);
		parseResults();
		return order;
	}
	
	/**
	 * Adds a new order to the order table in the database.
	 * @param orderId String literal specifying the unique order ID
	 * @param cartId String literal specifying the cart ID
	 * @param orderDt Date object specifying the date the order was placed
	 * @param shipDt Date object specifying the date the order was shipped
	 * @param trackNm Integer value specifying the tracking number of the order
	 */
	public void addOrder(String orderId, String cartId, Date orderDt, Date shipDt, int trackNm) {
		connect();
		fetcher.addOrder(orderId, cartId, orderDt, shipDt, trackNm);
	}
	
	/**
	 * Adds a new order to the order table in the database with a null tracking number
	 * @param orderId String literal specifying the unique order ID
	 * @param cartId String literal specifying the cart ID
	 * @param orderDt Date object specifying the date the order was placed
	 * @param shipDt Date object specifying the date the order was shipped
	 */
	public void addOrder(String orderId, String cartId, Date orderDt, Date shipDt) {
		connect();
		fetcher.addOrder(orderId, cartId, orderDt, shipDt);
	}
	
	/**
	 * Adds a new order to the order table in the database with a null ship date and tracking number
	 * @param orderId String literal specifying the unique order ID
	 * @param cartId String literal specifying the cart ID
	 * @param orderDt Date object specifying the date the order was placed
	 * @param shipDt Date object specifying the date the order was shipped
	 */
	public void addOrder(String orderId, String cartId, Date orderDt) {
		connect();
		fetcher.addOrder(orderId, cartId, orderDt);
	}
	
	/**
	 * Adds a new order to the order table in the database that uses the current date as an order date
	 * with a null ship date and tracking number
	 * @param orderId String literal specifying the unique order ID
	 * @param cartId String literal specifying the cart ID
	 * @param orderDt Date object specifying the date the order was placed
	 */
	public void addOrder(String orderId, String cartId) {
		connect();
		fetcher.addOrder(orderId, cartId);
	}
	
	/**
	 * Parses the results of a given SQL query on the order table.
	 */
	protected void parseResults() throws SQLException {
		order = null;
		cart = new Cart();
		while(results.next()) {
			String orderId = results.getString("orderId");
			cart = new CartHandler(getFetcher()).getCart(results.getString("cartId"));
			Calendar orderDt = Calendar.getInstance();
			orderDt.setTime(results.getDate("orderDt"));
			Calendar shipDt = Calendar.getInstance();
			if(results.getDate("shipDt") != null) {
				shipDt.setTime(results.getDate("shipDt"));
			}else {
				shipDt.set(1900, 0, 0, 0, 0);
			}
			int trackNm = results.getInt("trackNm");
			order = new Order(orderId, cart, orderDt, shipDt, trackNm);
		}
	}
}
