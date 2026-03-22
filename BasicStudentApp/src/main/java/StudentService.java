package com.coforge.services;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.entities.Student;
import com.coforge.exceptions.InvalidDobFormatException;
import com.coforge.exceptions.StudentNotFoundException;
import com.coforge.dao.StudentDao;
//import com.coforge.exceptions.StudentNotFoundException;

@Service
public class StudentService implements StudentServiceInterface {
@Autowired     
StudentDao dao;

public LocalDate parseDob(String dobStr) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    try {
        return LocalDate.parse(dobStr, formatter);
    } catch (DateTimeParseException ex) {
        throw new InvalidDobFormatException("Invalid DOB format! Use yyyy-MM-dd (Example: 2003-12-12)");
    }
}
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.getAllStudent();
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub

		 LocalDate parsedDob = parseDob(student.getDob());  // now date is validated
		    student.setDob(parsedDob.toString());              // storing back as String or save LocalDate if field changed

		return dao.saveStudent(student);
	}

	@Override
	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
		
		return dao.getStudentById(id).orElseThrow(()-> new StudentNotFoundException("no student found with this id"+id));
	}

	@Override
	public Student updateStudent(Student student, long id) {
		// TODO Auto-generated method stub
		Student exStudent=dao.getStudentById(id).orElseThrow(()->new RuntimeException());
		if(exStudent!=null) {
			exStudent.setSname(student.getSname());
			exStudent.setCourse(student.getCourse());
			exStudent.setAddress(student.getAddress());
			exStudent.setDob(student.getDob());
		    return dao.updateStudent(exStudent);
		}
		return null;
	}

	@Override
	public void deleteStudent(long id) {
		// TODO Auto-generated method stub
		Student exCustomer=dao.getStudentById(id).orElseThrow(()-> new RuntimeException());
        if(exCustomer!=null) {
        	dao.deleteStudent(id);
        	System.out.println("Student deleted successfully");
        }
        else {
        	System.out.println("no customer present");
        }
	}

}
