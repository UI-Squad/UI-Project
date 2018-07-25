package application.model;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * @author Jerome Daly
 * @author Erwin Herrera
 * @author Shane Bogard
 * @author Manuel Ben Bravo
 *
 * This java file will contain information pertaining
 * to the shopping cart of the customer.
 */
public class Cart{

	/** An ArrayList of item objects */
	private ArrayList<Item> cart;
	
	/** this cart's ID */
	private String cartId;
	
	private double cartTotal = 0;
	
	/**
	 * 
	 * @param cart
	 * @param cartId
	 */
	public Cart(String cartId, ArrayList<Item> cart) {
		this.cartId = cartId;
		this.cart = cart;		
	}
	
	/** 
	 * Constructs a new cart object consisting of a specified
	 * ArrayList of item objects.	 
	 * @param cart ArrayList of item objects
	 */
	public Cart(ArrayList<Item> cart) {
		this("guest", cart);
	}
	
	public Cart(String cartId) {
		this(cartId, new ArrayList<Item>());
	}
	
	/**
	 * Constructs an empty Cart Object (no items in the cart).
	 */
	public Cart() {
		this(new ArrayList<Item>());
	}
	
	/**
	 * 
	 * @param cartId
	 */
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	
	public String getCartId() {
		return cartId;
	}
		
	/**
	 * Changes the items in this cart. 
	 * @param cart ArrayList of items
	 */
	public void setCartItems(ArrayList<Item> cart) {
		this.cart = cart;
	}
	
	/**
	 * Returns a copy of the items contained in this cart. 
	 * @return ArrayList of item objects
	 */
	public ArrayList<Item> getCartItems(){
		return new ArrayList<Item>(cart);
	}
	
	/**
	 * Adds an item to this cart.
	 * @param item An item object to add to this cart
	 */
	public void addToCart(Item item){
		this.cart.add(item);
	}

	/**
	 * removes all items from the shopping cart
	 */
	public ArrayList<Item> clearCart(){
		ArrayList<Item> temp = new ArrayList<Item>(cart);
		this.cart.clear();
		return temp;
	}

	/**
	 * Removes an item from the cart.
	 * @param item A specified item object to be removed from the cart
	 */
	public void removeItem(Item item){
		this.cart.remove(item);
	}

	/**
	 * Returns the size of this cart.
	 * @return Double value representing the size of this cart
	 */
	public double getSize(){
		return cart.size();
	}
	
	/**
	 * Returns the total value of a specified item in the Cart.
	 * @param item Item object
	 * @return double value representing the total item value
	 */
	public double getItemTotal(Item item) {
		double itemTotal = 0;
		itemTotal = cart.get(cart.indexOf(item)).getPrice() * 
					cart.get(cart.indexOf(item)).getQuantity();
		return itemTotal;
	}

	/**
	 * Adds the total of the items prices based on their quantity.
	 */
	public void setCartTotal(){
		double total = 0;
		for(Item item : cart){
			total += (item.getPrice() * item.getQuantity());
		}
		this.cartTotal = total;
	}
	
	/**return the cartTotal, calls setCartTotal to make sure it
	 * returns the most up to date cartTotal. Returns in US
	 * currency format
	 * @return String value representing the total item value
	 * */
	public String getCartTotal(){
		setCartTotal();
		NumberFormat formating = NumberFormat.getCurrencyInstance();
		String Amt = formating.format(this.cartTotal);
		return Amt;
	}
	
	/**
	 * 
	 */
	public boolean equals(Object o) {
		if(!(o instanceof Cart)) return false;
		Cart other = (Cart)o;
		return cart.equals(other.getCartItems());
	}
	
	/**
	 * Returns a String literal representation of this cart object.
	 */
	public String toString() {
		String result = cartId + "\n";
		for(Item item : cart)
			result += item.toString() + "\n";
		return result;
	}
}
