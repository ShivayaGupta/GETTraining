package com.coforge.entities;



//import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long sid;
	private String sname;
	private String course;
	private String address;
	private String dob;
	public Student(String sname, String course, String address,String dob) {
		super();
		this.sname = sname;
		this.course = course;
		this.dob = dob;
		
	}
	
	//private String email;
}
