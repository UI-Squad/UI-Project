package application.model;
import java.util.ArrayList;

/**
 * @author Jerome Daly
 * @author Erwin Herrera
 *
 * This java file will contain information pertaining
 * to the shopping cart of the customer.
 */
public class Cart{

  //create an ArrayList for the cart
	private ArrayList<Item> cartArray = new ArrayList<Item>();
	private double cartTotal = 0;

  //add an item to the cart array
  public void addToCart(Item item){
    this.cartArray.add(item);
  }

	//clear the shopping cart
	public void clearCart(){
		this.cartArray.clear();
	}

	//remove a specific item from the cart
	public void removeItem(Item item){
		this.cartArray.remove(item);
	}

	//return the size of the cartArray
	public void getSize(){
		return cartArray.size();
	}

	//add the total of all the items values based on their quantity
	public void setCartTotal(){
		double total = 0;
		for(Item item : cartArray){
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
}
