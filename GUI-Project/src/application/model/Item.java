package application.model;

/**
 *
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

  //constructor
  public void item(String itemName, double itemId, price, quantity){
    this.itemName = itemName;
    this.itemId = itemId;
    this.price = price;
    this.quantity = quantity;
  }

  //getters and setters for item information
  public void setName(String name){
    this.itemName = name;
  }
  public String getName(){
    return itemName;
  }
  public void setId(int id){
    this.itemId = id;
  }
  public String getId(){
    return itemId;
  }
  public void setPrice(double price){
    this.price = price;
  }
  public String getPrice(){
    return price;
  }
  public void setQuantity(int quantity){
    this.quantity = quantity;
  }
  public int getQuantity(){
    return quantity;
  }
}
