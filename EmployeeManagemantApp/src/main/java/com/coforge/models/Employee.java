package com.coforge.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
  private long  eid;
  private String ename;
  private double salary;
  private String email;
  private String mobile;
  private LocalDate doj;
  private LocalDate dob;
  public Employee(String ename, double salary, String email, String mobile, LocalDate doj, LocalDate dob) {
	super();
	this.ename = ename;
	this.salary = salary;
	this.email = email;
	this.mobile = mobile;
	this.doj = doj;
	this.dob = dob;
  }
  
   
  
  
}
