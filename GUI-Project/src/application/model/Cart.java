package application.model;
import java.util.ArrayList;

/**
 * @author Jerome Daly
 * @author Erwin Herrera
 * @author Shane Bogard
 *
 * This java file will contain information pertaining
 * to the shopping cart of the customer.
 */
public class Cart{

	/** An ArrayList of item objects */
	private ArrayList<Item> cart;
	
	private double cartTotal = 0;
	
	/** 
	 * Constructs a new cart object consisting of a specified
	 * ArrayList of item objects.	 
	 * @param cart ArrayList of item objects
	 */
	public Cart(ArrayList<Item> cart) {
		this.cart = cart;
	}
	
	/**
	 * Constructs an empty Cart Object (no items in the cart).
	 */
	public Cart() {
		this(new ArrayList<Item>());
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
	public void clearCart(){
		this.cart.clear();
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
	
	//return the cartTotal, calls setCartTotal to make sure it
	//returns the most up to date cartTotal
	public double getCartTotal(){
		setCartTotal();
		return cartTotal;
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
		String result = "";
		for(Item item : cart)
			result += item.toString() + "\n";
		return result;
	}
}
