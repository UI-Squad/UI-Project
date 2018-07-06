package application.model;

/**
 * @author Erwin Herrera
 * @author Jerome Daly
 *
 * This class will be responsible for
 * keeping the information of the customer.
 *
 */
public class Customer {
	
  private String cusName, cusAddress;
  private int cusPhoneNum;

  private Cart cart = new Cart();

  /**
   * Constructor
   * @param name		Customer name
   * @param address		Customer email address (probably)
   * @param phoneNum	Customer phone number
   */
  public void customer(String name, String address, int phoneNum){
    cusName = name;
    cusAddress = address;
    cusPhoneNum = phoneNum;
  }

  //Getters and setters for customer information
  
  /**
   * Setter for customer name
   * @param name
   */
  public void setName(String name){
    this.cusName = name;
  }
  
  /**
   * Getter for customer name
   * @return Returns customer name
   */
  public String getName(){
    return cusName;
  }

  /**
   * Setter for customer address
   * @param addr
   */
  public void setAddress(String addr){
    this.cusAddress = addr;
  }
  
  /**
   * Getter for customer address
   * @return Returns the address of the customer
   */
  public String getAddress(){
    return cusAddress;
  }

  /**
   * Setter for the customer phone number
   * @param phone
   */
  public void setPhone(int phone){
    this.cusPhoneNum = phone;
  }
  
  /**
   * Getter for customer phone number
   * @return Returns the customer phone number
   */
  public int getPhoneNum(){
    return cusPhoneNum;
  }
}
