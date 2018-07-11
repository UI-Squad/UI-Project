package application.model;

/**
 * @author Erwin Herrera
 * @author Jerome Daly
 * @author Manuel Ben Bravo 
 *
 * This class will be responsible for
 * keeping the information of the customer.
 *
 */
public class Customer {

	private String cusName, cusAddress;
	private int cusPhoneNum;

	private Cart cart = new Cart();

	private String Fname, Lname;
	private String Email;
	private String CusID;

	/**
	 * Constructor
	 * @param Fname, Lname 	Customer name
	 * @param Email			Customer email address 
	 * 
	 */
	public void customer(String Firstname, String Lastname, String Email){
		this.Fname = Firstname ;
		this.Lname = Lastname;
		this.Email = Email;
	}

	//Getters and setters for customer information

	/**
	 * Setter for customer name
	 * @param name
	 */
	public void setName(String FirstName, String LastName){
		this.Fname = FirstName;
		this.Lname = LastName;
	}

	/**
	 * Getter for customer name
	 * @return Returns customer name
	 */
	public String getName(){
		return this.Fname + " " + this.Lname;
	}

	/**
	 * Setter for customer Email
	 * @param Email
	 */
	public void setEmail(String email){
		this.Email =email;
	}

	/**
	 * Getter for customer email
	 * @return Returns the email of the customer
	 */
	public String getEmail(){
		return this.Email;
	}

	/**
	 * Getter for Customer ID, Same as cart ID!
	 * @return cusID
	 */
	public String getCusID() {
		return this.CusID;
	}

	/**
	 * Getter for customer phone number
	 * @return Returns the customer phone number
	 */
	public int getPhoneNum(){
		return cusPhoneNum;
		
	}
	public void setCusID(String cusID) {
		this.CusID = cusID;

	}

}
