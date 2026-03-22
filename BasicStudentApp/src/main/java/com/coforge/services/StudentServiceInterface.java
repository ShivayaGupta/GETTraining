package com.coforge.services;

import java.util.List;

import com.coforge.entities.Student;

public interface StudentServiceInterface {
	public List<Student> getAllStudent();
	 public Student saveStudent(Student student);
	 public Student getStudentById(long id);
	 public Student updateStudent(Student student,long id);
	 public void deleteStudent(long id);
}

