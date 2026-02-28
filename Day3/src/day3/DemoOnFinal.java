package day3;

public class DemoOnFinal {
protected final String name="swapna";
public void printDetails() {
	System.out.println(this.name);
}
public static void main(String args[]) {
	DemoOnFinal dof= new DemoOnFinal();
	dof.printDetails();
}
}
