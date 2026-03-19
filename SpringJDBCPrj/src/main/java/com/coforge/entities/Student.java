package com.coforge.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
	
private long sid;
private String sname;
private String course;
private String address;
public Student(String sname, String course, String address) {
	super();
	this.sname = sname;
	this.course = course;
	this.address = address;
}

}


