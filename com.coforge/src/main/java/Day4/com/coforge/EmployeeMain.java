package Day4.com.coforge;
import java.util.function.*;
public class EmployeeMain {
  public static void main(String[] args) {

	Employee e1= new Employee("Swapna",123,80000);
	Employee e2= new Employee("abc",125,60000);
	Employee e3= new Employee("Swa",13,90000);
	Employee e4= new Employee("Swap",23,50000);
	Employee e5= new Employee("Swapn",124,80000);
	Employee empArr[]= {e1,e2,e3,e4,e5};
	empArr[0]=e1;
	empArr[1]=e2;
	for(Employee emp:empArr) {
		System.out.println(emp);
	}
	Consumer<Employee[]> empConsumer=(empArr1)->{
		double max=empArr1[0].getSalary();
		for(Employee emp:empArr) {
			System.out.println(emp.getEname());
			if(emp.getSalary()>max) {
				max=emp.getSalary();
			}}
		System.out.println(max);
		};
		empConsumer.accept(empArr);
		
	}
}

