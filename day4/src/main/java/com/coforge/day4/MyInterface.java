package com.coforge.day4;

public interface MyInterface {
     public void display();
     public default void printDetails() {
    	 System.out.println("my default method is invoked");
     }
}
