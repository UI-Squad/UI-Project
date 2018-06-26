package application.model;

/**
 *
 * @author Erwin Herrera
 *
 * This class will be responsible for
 * keeping the information of the customer.
 *
 * (i.e. Name, password info, etc)
 */

public class Customer {
  //customer name
  String name, address;
  int phoneNum;

  Cart cart = new Cart;

  //constructor
  public void customer(String name, address, int phoneNum){
    this.name = name;
    this.address = address;
    this.phoneNum = phoneNum;
  }

  //todo: Add customer getters and setters
  public void setName(String name){
    this.name = name;
  }

  //Do we want to ask for customer data? Name, address, email?
}
