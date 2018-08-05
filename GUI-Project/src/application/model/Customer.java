package application.model;

/**
 * @author Erwin Herrera
 * @author Jerome Daly
 * @author Manuel Ben Bravo 
 * @author Shane Bogard
 *
 * This class will be responsible for
 * keeping the information of the customer.
 *
 */


public class Customer {
	
	/** email */
	private String email;
	/** Customer ID */
	private String cusId;
	/** name */
	private Name name;
	/** physical address */
	private Address address;
	/** phone number */
	private String phoneNum;
	/** Shopping Cart */
	private Cart cart;

	/**
	 * Constructs a new Customer object consisting of a name, address, phone number, cart,
	 * email and customer Id.
	 * @param cusId String literal specifying this customer's Id
	 * @param name Name object specifying the customer's name
	 * @param address Address object specifying this customer's address
	 * @param phoneNum Integer value specifying this customer's phone number
	 * @param cart Cart object specifying the items in this customer's cart
	 * @param email String literal specifying this customer's email address
	 */
	public Customer(String email, String cusId, Name name, Address address, String phoneNum, Cart cart){
		this.email = email;
		this.cusId = cusId;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.cart = cart;
	}
	
	/**
	 * 
	 * @param email
	 * @param cusId
	 * @param name
	 * @param address
	 * @param phoneNum
	 */
	public Customer(String email, String cusId, Name name, Address address, String phoneNum) {
		this(email, cusId, name, address, phoneNum, new Cart());
	}
	
	/**
	 * 
	 * @param email
	 * @param cusId
	 * @param name
	 * @param phoneNum
	 * @param cart
	 */
	public Customer(String email, String cusId, Name name, String phoneNum, Cart cart) {
		this(email, cusId, name, new Address(), phoneNum, cart);
	}
	
	/**
	 * 
	 * @param email
	 * @param cusId
	 * @param address
	 * @param phoneNum
	 * @param cart
	 */
	public Customer(String email, String cusId, Address address, String phoneNum, Cart cart) {
		this(email, cusId, new Name(), address, phoneNum, cart);
	}
	
	/**
	 * 
	 * @param email
	 * @param cusId
	 * @param name
	 * @param address
	 * @param cart
	 */
	public Customer(String email, String cusId, Name name, Address address, Cart cart) {
		this(email, cusId, name, address, null, cart);
	}
	
	/**
	 * 
	 * @param email
	 * @param cusId
	 * @param name
	 * @param address
	 */
	public Customer(String email, String cusId, Name name, Address address) {
		this(email, cusId, name, address, null, new Cart());
	}
	
	/**
	 * 
	 * @param email
	 * @param cusId
	 * @param name
	 */
	public Customer(String email, String cusId, Name name) {
		this(email, cusId, name, new Address(), null, new Cart());
	}
	
	/**
	 * 
	 * @param email
	 * @param cusId
	 * @param address
	 */
	public Customer(String email, String cusId, Address address) {
		this(email, cusId, new Name(), address, null, new Cart());
	}
	
	/**
	 * 
	 * @param email
	 * @param cusId
	 */
	public Customer(String email, String cusId) {
		this(email, cusId, new Name(), new Address(), null, new Cart());
	}
	

	//Getters and setters for customer information
	
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @param cusId
	 */
	public void setId(String cusId) {
		this.cusId = cusId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getId() {
		return cusId;
	}

	/**
	 * Setter for customer name
	 * @param name
	 */
	public void setName(Name name){
		this.name = name;
	}

	/**
	 * Getter for customer name
	 * @return Returns customer name
	 */
	public Name getName(){
		return name;
	}
	
	/**
	 * 
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * 
	 * @return
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * 
	 * @param phoneNum
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * 
	 * @param cart
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	/**
	 * 
	 * @return
	 */
	public Cart getCart() {
		return cart;
	}
	
	/**
	 * 
	 */
	public boolean equals(Object o ) {
		if(!(o instanceof Customer)) return false;
		Customer other = (Customer)o;
		return email.equals(other.getEmail()) && cusId.equals(other.getId());
	}
	
	/**
	 * 
	 */
	public String toString() {
		return email + ":" + cusId + ":" + name.toString() + ":" + address.toString()
						+ ":" + phoneNum + "\n" + cart.toString(); 
	}
	
}
