package application.model;

/**
 * @author Jerome Daly
 * @author Erwin Herrera
 *
 * This class will hold information pertaining
 * to basics of an item within the shopping web site.
 * (quantity, price, etc)
 */
public class Item {
  private String itemName;
  private double price;
  private int itemId, quantity;

  /**
   * Constructor
   * @param itemName Item name
   * @param itemId Item Id
   * @param quantity Item quantity
   * @param price	Item price
   */
  public void item(String itemName, int itemId, int quantity, double price){
    this.itemName = itemName;
    this.itemId = itemId;
    this.price = price;
    this.quantity = quantity;
  }

  //getters and setters for item information
  
  /**
   * Setter for item name
   * @param name
   */
  public void setName(String name){
    this.itemName = name;
  }
  
  /**
   * Getter for item name
   * @return Returns the item name
   */
  public String getName(){
    return itemName;
  }
  
  /**
   * Setter for item ID
   * @param id
   */
  public void setId(int id){
    this.itemId = id;
  }
  
  /**
   * Getter for item ID
   * @return Returns the item ID
   */
  public double getId(){
    return itemId;
  }
  
  /**
   * Setter for item price
   * @param price
   */
  public void setPrice(double price){
    this.price = price;
  }
  
  /**
   * Getter for item price
   * @return Returns the item price
   */
  public double getPrice(){
    return price;
  }
  
  /**
   * Setter for item quantity
   * @param quantity
   */
  public void setQuantity(int quantity){
    this.quantity = quantity;
  }
  
  /**
   * Getter for item quantity
   * @return Returns the item's quantity
   */
  public int getQuantity(){
    return quantity;
  }
}
