package Day4.cars.management;

public interface AddOns {
  public default void audioSystem() {
	  System.out.println("Audio system with default 2 speakers");
  }
  public default void roofOpen() {
	  System.out.println("my default roof system is disabled ");
	 
  }
  public static void warrantyPolicy() {
	  System.out.println("warranty period ");
  }
}
