package Coforge.com.Day5;

public class Customer implements Comparable<Customer> {
  private int custid;
  private String custName;
  private String city;
  private double orderCost;
  public Customer() {
	  super();
  }
  public Customer(int custid, String custName, String city, double orderCost) {
	super();
	this.custid = custid;
	this.custName = custName;
	this.city = city;
	this.orderCost = orderCost;
  }
  public int getCustid() {
	return custid;
  }
  public void setCustid(int custid) {
	this.custid = custid;
  }
  public String getCustName() {
	return custName;
  }
  public void setCustName(String custName) {
	this.custName = custName;
  }
  public String getCity() {
	return city;
  }
  public void setCity(String city) {
	this.city = city;
  }
  public double getOrderCost() {
	return orderCost;
  }
  public void setOrderCost(double orderCost) {
	this.orderCost = orderCost;
  }
  @Override
  public String toString() {
	return "Customer [custid=" + custid + ", custName=" + custName + ", city=" + city + ", orderCost=" + orderCost
			+ "]";
  }
//  public int compareTo(Customer o) {
//	return (int) (this.getOrderCost()-o.getOrderCost());
//  }
  @Override
  public int compareTo(Customer o) {
  	return this.getCustName().compareTo(o.getCustName());
  }
//  public int compare(Customer o1,Customer o2) {
// 	  
//  }
  
}
