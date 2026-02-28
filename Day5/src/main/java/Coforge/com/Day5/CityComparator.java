package Coforge.com.Day5;

import java.util.Comparator;

public class CityComparator implements Comparator<Customer> {
	public int compare(Customer o1,Customer o2) {
		 return o1.getCity().compareTo(o2.getCity());
	}

}
