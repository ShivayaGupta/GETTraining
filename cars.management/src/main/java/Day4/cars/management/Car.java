package Day4.cars.management;

public abstract class Car {
 private String model;
 public Car() {
	 super();
	 
 }
 public Car(String model) {
	 super();
	 this.model =model;
	 
 }
 public abstract void engineType();
 public void showModel() {
	 System.out.println("model:"+this.model);
 }
 public void showWarrantyPolicy() {
	 AddOns.warrantyPolicy();
 }
 
}
