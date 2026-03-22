package com.coforge.dao;

import java.util.List;
import java.util.Optional;

import com.coforge.entities.Student;

public interface StudentDaoInterface {
 public List<Student> getAllStudent();
 public Student saveStudent(Student student);
 public Optional <Student> getStudentById(long id);
 public Student updateStudent(Student student);
 public void deleteStudent(long id);
}
