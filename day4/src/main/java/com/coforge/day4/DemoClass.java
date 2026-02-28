package com.coforge.day4;

public class DemoClass implements MyInterface
{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.print("the display method");
		System.out.println("hi");
	}
	@Override
    public void  printDetails(){
    	System.out.println("the democlass");
    }
}
