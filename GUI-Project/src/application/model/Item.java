package application.model;

/**
 * @author Jerome Daly
 * @author Erwin Herrera
 * @author Shane Bogard
 *
 * This class will hold information pertaining
 * to basics of an item within the shopping web site.
 * (quantity, price, etc)
 */
public class Item {

	/** The item's ID */
	private String itemId;
	/** The name of this item */
	private String itemName;
	/** The department the item belongs to */
	private String dept;
	/** The description of the item */
	private String description;
	/** The price of the item */
	private double price;
	/** The item's quantity */
	private int quantity;
	
	/** The items default quantity */
	private static final int DEF_QTY = 1;
	/** The items default description */
	private static final String DEF_DEPT = "N/A";
	/** The items default department */
	private static final String DEF_DES = null;
  
	
	//Constructors 
	/**
	 * Constructs a new item object consisting of an item id, item name, description of the item, 
	 * the department the item belongs to, the price of the item and the quantity.
	 * @param itemId String literal specifying the item's id
	 * @param itemName String literal specifying the item's name
	 * @param description String literal specifying the item's description 
	 * @param dept String literal specifying the department the item belongs to
	 * @param price Double value specifying the price of the item
	 * @param quantity Integer value specifying the quantity of the item
	 */
	public Item(String itemId, String itemName, String description, String dept, double price, int quantity) {
	  this.itemId = itemId;
	  this.itemName = itemName;
	  this.description = description;
	  this.dept = dept;
	  this.price = (price < 0) ? 0 : price; //negative bounds check 
	  this.quantity = (quantity < 0) ? 0 : quantity; //negative bounds check
	}
  
	/**
	 * Constructs a new item object consisting of an item id, item name, description of the item, 
	 * the department the item belongs to, the price of the item and a default quantity.
	 * @param itemId String literal specifying the item's id
	 * @param itemName String literal specifying the item's name
	 * @param description String literal specifying the item's description
	 * @param dept String literal specifying the department the item belongs to
	 * @param price Double value specifying the price of the item
	 */
	public Item (String itemId, String itemName, String description, String dept, double price) {
		this(itemId, itemName, description, dept, price, DEF_QTY);
	}
	
	/**
	 * Constructs a new item object consisting of a specified item ID, item name, item description, item price
	 * a default item department and a default item quantity.
	 * @param itemId String literal specifying the item's id
	 * @param itemName String literal specifying the item's name
	 * @param description String literal specifying the item's description
	 * @param price Double value specifying the price of the item
	 */
	public Item(String itemId, String itemName, String description, double price) {
		this(itemId, itemName, description, DEF_DEPT, price, DEF_QTY);
	}
	
	/**
	 * Constructs a new item object consisting of a specified item ID, item name, price, quantity, 
	 * a default description and a default department.
	 * @param itemId String literal specifying the item's id
	 * @param itemName String literal specifying the item's name
	 * @param price Double value specifying the price of the item
	 * @param quantity Integer value specifying the quantity of the item
	 */
	public Item(String itemId, String itemName, double price, int quantity) {
		this(itemId, itemName, DEF_DES, DEF_DEPT, price, quantity);
	}
	
	/**
	 * Constructs a new item object consisting of a specified required item id, item name and price.
	 * The item's description, department and quantity are set to default values.
	 * @param itemId itemId itemId String literal specifying the item's id
	 * @param itemName String literal specifying the item's name
	 * @param price Double value specifying the price of the item
	 */
	public Item (String itemId, String itemName, double price) {
		this(itemId, itemName, DEF_DES, DEF_DEPT, price, DEF_QTY);
	}
	
	
	//getters and setters	
	/**
	 * Changes this item's Id to a new item Id.
	 * @param itemId A string literal specifying the new item id
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	/**
	 * Returns this item's Id.
	 * @return A string literal representing the ID of this item
	 */
	public String getItemId() {
		return itemId;
	}
	
	/**
	 * Changes this item's name to a new item name.
	 * @param itemName A string literal specifying the new item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	 * Returns the name of this item.
	 * @return A string literal representing the name of this item
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Changes the description of this item to a new description.
	 * @param description A string literal specifying the new description of this item
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Returns the description of this item/
	 * @return String literal representing the description of this item
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Changes the item's department to a new department
	 * @param dept A string literal specifying4 the new department
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	/**
	 * Returns the item's department
	 * @return A string literal representing the department of the item
	 */
	public String getDept() {
		return dept;
	}
	
	/**
	 * Changes the price of the item to a new price.
	 * @param price Double value specifying the new price of the item
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Returns the price of this item.
	 * @return Double value representing the price of this item
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Changes the quantity of this item.
	 * @param quantity Integer value specifying the new quantity of this item
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Returns the quantity of this item.
	 * @return Integer value representing the quantity of this item
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Compares this item with another object for equivalence.
	 * @param obj Object
	 * @return boolean value representing if this item is equal to another item
	 */
	public boolean equals(Object obj) {
		if(!(obj instanceof Item)) return false;
		Item other = (Item) obj;
		return this.itemId.equalsIgnoreCase(other.itemId);
	}
	
	/**
	 * Returns a string literal representation of this item object
	 * containing each attribute separated by colons.
	 */
	public String toString() {
		return itemId + ":" + itemName + ":" + description + ":" + dept + ":"
				+ price + ":" + quantity;
	}

}
