package day3Shape;

import java.util.Scanner;

public class ShapeMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t;
		Shape sh;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the type of shape");
		t=sc.next();
		if(t.equals("Circle")) {
			
			System.out.println("Enter the value of radius");
			double radius=sc.nextDouble();
		      sh = new Circle(radius);
		      sh.area();
		      sh.circum();
		     
			
		}
		else if(t.equals("Square")) {
			
			System.out.println("Enter the value of side");
			double side=sc.nextDouble();
		      sh = new Square((int) side);
		      sh.area();
		      sh.circum();
			
		}
		
		else {
			System.out.println("Invalid Shape");
		}
      //Circle c = new Circle(22);
     // c.area();
    //  c.circum();
     // Square s = new Square(22);
      //s.area();
      //s.circum();
	}

}
