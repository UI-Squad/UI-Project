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
  //customer name
  private String name, address;
  private int phoneNum;

  private Cart cart = new Cart();

  //constructor
  public void customer(String cusName, String cusAddress, int cusPhoneNum){
    name = cusName;
    address = cusAddress;
    phoneNum = cusPhoneNum;
  }

  //todo: Add customer getters and setters
  public void setName(String name){
    this.name = name;
    //test
  }

  //Do we want to ask for customer data? Name, address, email?
}
