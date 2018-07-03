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

  //create an array for the cart
	private ArrayList cartArray;

  //add an item to the cart array
  public void addToCart(Item item){
    this.cartArray.add(item);
  }
  
}
