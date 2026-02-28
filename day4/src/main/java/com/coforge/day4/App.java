package com.coforge.day4;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {  MyInterface mi= new DemoClass();
    mi.display();
    mi.printDetails();
    mi=new Hello();
    mi.display();
    mi.printDetails();
    
        System.out.println( "Hello World!" );
    }
}
