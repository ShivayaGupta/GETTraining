package com.coforge.services;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.coforge.entities.Student;

public interface StudentServiceInterface {
 
	
 public List<Student> getAll();
 public String save(Student student);
 public Student getById(long sid);
  
 
}
