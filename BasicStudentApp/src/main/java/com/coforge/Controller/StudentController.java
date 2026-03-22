package com.coforge.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.entities.Student;

import com.coforge.services.StudentService;

@RestController
@ResponseBody
public class StudentController {
	@Autowired
   private StudentService service;
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getAllStudent() {
		return new ResponseEntity<>(service.getAllStudent(),HttpStatus.OK) ;
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {


    //Student student = new Student();
   
    //student.setDob(service.parseDob(student.getDob())); // manual DOB parsing

		return new ResponseEntity<Student>(service.saveStudent(student),HttpStatus.CREATED);
	}
	@GetMapping("/student/{cid}")
	public ResponseEntity<Student> getStudentById(@PathVariable("cid")long cid) {
		return new ResponseEntity<Student>(service.getStudentById(cid),HttpStatus.OK);
	}
	@PutMapping("/student/{cid}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student ,@PathVariable("cid")long cid) {
		return new ResponseEntity<>(service.updateStudent(student,cid),HttpStatus.OK);
	
	
}
	@DeleteMapping("/student/{cid}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("cid") long cid) {
	  
		service.deleteStudent(cid);
		return new ResponseEntity<>("Student deleted successfully",HttpStatus.OK);
	}
}
