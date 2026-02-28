package Day4.com.coforge;
@FunctionalInterface

public interface MyInterface {
	  public void display();
	     public default void printDetails() {
	    	 System.out.println("my default method is invoked");
	     }
	     public static void useParking(String corpName) {
	    	 System.out.println(corpName+"using parking area");
	     }
}
