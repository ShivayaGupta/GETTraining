package day3Shape;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Employee e1 = new Employee("Swapna",123,"coforge");
      Employee e2 = new Employee("Amit",124,"coforge");
      Employee e3 = new Employee("Swathi",125,"coforge");
      e1.setCompanyName("coforge technologies");
      System.out.println(e1);
      System.out.println(e2);
      System.out.println(e3);
      
      e1.calSalary();
      e2.calSalary();
      e3.calSalary();
      
      Employee.printCompanyName();

	}

}
