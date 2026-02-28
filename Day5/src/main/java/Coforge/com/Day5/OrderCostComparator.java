package Coforge.com.Day5;

import java.util.Comparator;

public class OrderCostComparator implements Comparator<Customer> {
	@Override
	public int compare(Customer o1,Customer o2) {
	 	  return (int)(o1.getOrderCost()-o2.getOrderCost());
	  }

}
