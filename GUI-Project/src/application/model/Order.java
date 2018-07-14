package application.model;
/**
 * @author Shane Bogard
 *
 */

import java.util.Calendar;

public class Order {
	/** The Id for this order */
	private String orderId;
	/** The items purchased for this order */
	private Cart cart;
	/** The date this order was created */
	private Calendar orderDt;
	/** The date this order was shipped */
	private Calendar shipDt;
	/** The tracking number for this order */
	private int trackNm;
	
	/**
	 * Constructs a new order consisting of an Order Id, a cart containing items purchased,
	 * the date the order was created, the date the order was shipped and the tracking 
	 * number for the shipment.
	 * @param orderId String literal specifying the order ID
	 * @param cart Cart object specifying the items purchased
	 * @param orderDt Calendar object specifying the date of the order's creation
	 * @param shipDt Calendar object specifying the date the order was shipped
	 * @param trackNm Integer value specifying the tracking number of the order
	 */
	public Order(String orderId, Cart cart, Calendar orderDt, Calendar shipDt, int trackNm) {
		this.orderId = orderId;
		this.cart = cart;
		this.orderDt = orderDt;
		this.shipDt = shipDt;
		this.trackNm = trackNm;
		//no ship date provided
		if(shipDt == null) {
			this.shipDt = Calendar.getInstance();
			this.shipDt.set(0, 0, 0);
		}
	}
	
	/**
	 * Constructs a new Order consisting of a specified order Id, cart of purchased items,
	 * an order date, shipped date and a default tracking number.
	 * @param orderId String literal specifying the order ID
	 * @param cart Cart object specifying the items purchased
	 * @param orderDt Calendar object specifying the date of the order's creation
	 * @param shipDt Calendar object specifying the date the order was shipped
	 */
	public Order(String orderId, Cart cart, Calendar orderDt, Calendar shipDt) {
		this(orderId, cart, orderDt, shipDt, 0); //tracking number zero by default
	}
	
	/**
	 * Constructs a new Order consisting of a specified order Id, cart of purchased items,
	 * an order date, a default shipped date and tracking number.
	 * @param orderId String literal specifying the order ID
	 * @param cart Cart object specifying the items purchased
	 * @param orderDt Calendar object specifying the date of the order's creation
	 */
	public Order(String orderId, Cart cart, Calendar orderDt) {
		this(orderId, cart, orderDt, null);
	}
	
	/**
	 * Changes this order id into a new order id.
	 * @param orderId String literal specifying the new order id
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	/**
	 * Returns the order id of this order.
	 * @return String literal representing this order's id
	 */
	public String getOrderId() {
		return orderId;
	}
	
	/**
	 * Changes this order's cart into a new cart
	 * @param cart Cart object specifying the new cart of this order
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	/**
	 * Returns a Cart containing the items purchased for this order.
	 * @return Cart object representing the items contained in this order
	 */
	public Cart getCart() {
		return cart;
	}
	
	/**
	 * Changes the date this order was created.
	 * @param orderDt Calendar object specifying the date this order was created
	 */
	public void setOrderDate(Calendar orderDt) {
		this.orderDt = orderDt;
	}
	
	/**
	 * Returns the date this order was created.
	 * @return Calendar object representing the date this order was created
	 */
	public Calendar getOrderDate() {
		return orderDt;
	}
	
	/**
	 * Changes the ship date of this order into a new ship date.
	 * @param shipDt Calendar object specifying the new ship date of this order
	 */
	public void setShipDate(Calendar shipDt) {
		this.shipDt = shipDt;
	}
	
	/**
	 * Returns the ship date of this order.
	 * @return Calendar object representing the ship date of this order
	 */
	public Calendar getShipDate() {
		return shipDt;
	}
	
	/**
	 * Changes this order's tracking number to a new tracking number.
	 * @param trackNm Integer value specifying the new tracking number for this order
	 */
	public void setTrackingNumber(int trackNm) {
		this.trackNm = trackNm;
	}
	
	/**
	 * Returns the tracking number for this order.
	 * @return Integer value representing the tracking number for this order
	 */
	public int getTrackingNumber() {
		return trackNm;
	}
	
	/**
	 * Returns a string literal representation of this order object.
	 */
	public String toString() {
		return orderId + "\n" + cart.toString() + orderDt.getTime().toString()
						+ "\n" + shipDt.getTime().toString() + "\n" + trackNm;
	}
}
