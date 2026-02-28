package day3Shape;

public class Employee {
          private String name;
           private int id;
           static String companyName="coforge";
           private double bSalary;
           
           public Employee() {
        	   super();
           }
           public Employee(String name,int id,String companyName) {
        	   super();
        	   this.name=name;
        	   this.id=id;
        	   this.companyName=companyName;
           }  
          public String getName() {
        	   return name;
        	   
}
          public String getid() {
       	   return name;
       	   
          }
           public void setName(String name) {
        	   this.name=name;
           }
           public void setid(int id) {
        	   this.id=id;
           }
           publc void calSalary() { 
        	   double netSal;
        	   if(this.bSalary>50000) {
        		   double hra=0.10;
        		   double da=0.10;
        		   netSal=bSalary+bSalary+hra+bSalary*da;
        		   
        	   }
        	   else {
        		    netSal=bSalary;
        	   }
        	   System.out.println(netSal);
           }}

