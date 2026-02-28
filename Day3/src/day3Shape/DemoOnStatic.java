package day3Shape;

public class DemoOnStatic {
  //   static {
   // 	 System.out.println("first staic block")
    // }
     //static {
    	// System.out.println("second staic block")
    // }
	private String name;
	public void printName() {
		System.out.println("name");
	}
     public static void main(String args[]) {
    	 System.out.println("inside main");
    	 DemoOnStatic dos = new DemoOnStatic();
    	 dos.printName();
     }
     static {
    	 System.out.println("static block");
     }
}
