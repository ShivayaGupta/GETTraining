package day6Assignment;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
 	  static Set<Employee> empSet = new HashSet<Employee>();
      static Scanner sc = new Scanner(System.in);
	 static {
   	  empSet.add(new Employee(14,"swapna",80000));
   	  empSet.add(new Employee(24,"swapna",80000));
   	  empSet.add(new Employee(1,"swapna",80000));
   	  empSet.add(new Employee(4,"swapna",80000));

     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
          empSet.forEach(e->System.out.println(e));
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter employee details empId,empName,salary");
          Employee emp= new Employee(sc.nextLong(),sc.next(),sc.nextDouble());
          empSet.add(emp);
          while(true){
        	  System.out.println("\n1.Insert 2.Read 3.Update 4.Delete 5.Exit ");
              int choice = sc.nextInt();
               switch(choice) {    
               case 1: insertEmployee(); break;
               case 2: getEmployeeById();break;
               case 3: updateEmployee();break;
               case 4: deleteEmployee();break;
               case 5: System.exit(0);
               }
          }}
          static void insertEmployee() {
        	  System.out.println("Enter id,name,salary:");
        	  Employee emp = new Employee(sc.nextLong(),sc.next(),sc.nextDouble());
        	  empSet.add(emp);
        	  System.out.println("Employee added");
          }
          static void getEmployeeById() {
        	  System.out.println("enter employee id:");
        	  long id= sc.nextLong();
        	  for(Employee emp:empSet) {
        		  if(emp.getEmpId()==id) {
        			  System.out.println(emp);
        			  return;
        		  }
        	  }
        	  System.out.println("employee not found");
         
          
	}
          static void updateEmployee() {
        	  System.out.println("enter employee id to update");
        	  long id =sc.nextLong();
        	  
        	  for(Employee emp :empSet) {
        		  if(emp.getEmpId()==id) {
        			  System.out.println("enter new name and salary");
        			  emp.setEmpName(sc.next());
        			  emp.setSalary(sc.nextDouble());
        			  System.out.println("updated successfully");
        			  return;
        		  }
        	  }
        	  System.out.println("Employee Not found");
        	  
          }
          static void deleteEmployee() {
        	  System.out.println("enter employee id to delete");
        	  long id = sc.nextLong();
        	  
        	  Employee temp = null;
        	  for(Employee e : empSet) {
        		if(e.getEmpId()==id) {  
        	      temp=e;
        	      break;}}
        	  if(temp!=null) {
        		  empSet.remove(temp);
        		  System.out.println("Employee deleted successfully");
        	  }
        	  
        	  else {
        		  System.out.println("employee not found");
        	  }
          }

}

