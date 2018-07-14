package com.controller;
/**
 * @author ShaneBogard
 */

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
