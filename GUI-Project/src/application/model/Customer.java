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
  private String cusName, cusAddress;
  private int cusPhoneNum;

  private Cart cart = new Cart();

  //constructor
  public void customer(String cusName, String cusAddress, int cusPhoneNum){
    name = cusName;
    address = cusAddress;
    phoneNum = cusPhoneNum;
  }

  //Getters and setters for customer information
  public void setName(String name){
    this.cusName = name;
  }
  public String getName(){
    return cusName;
  }

  public void setAddress(String addr){
    this.cusAddress = addr;
  }
  public String getAddress(){
    return cusAddress;
  }

  public void setPhone(int phone){
    this.cusPhoneNum = phone;
  }
  public int getPhoneNum(){
    return cusPhoneNum;
  }
}
