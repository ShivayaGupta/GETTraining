package Coforge.com.Day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerArrayList {
 public static void main(String[] args) {
	Customer c1 = new Customer(1,"swapna","Hyd",560000);
	Customer c2 = new Customer(54,"amit","bglr",300000);
	Customer c3 = new Customer(11,"swapna","bglr",370000);
	Customer c4 = new Customer(55,"raj","hyd",80000);
	Customer c5 = new Customer(11,"swathi","hyd",6000);
	Customer c6 = new Customer(11,"pooja","bglr",45000);
    ArrayList<Customer> custList = new ArrayList<Customer>();
    custList.add(c1);
    custList.add(c2);
    custList.add(c3);
    custList.add(c4);
    custList.add(c5);
    custList.add(c6);
    
   // Collections.sort(custList);
    custList.sort(new CityComparator().thenComparing(new OrderCostComparator()));
    custList.forEach(cust->System.out.println(cust));
   
    
 }}
