package com.coforge.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.coforge.entities.Student;

@ControllerAdvice
public class GlobalExceptionHandlerClass {
   
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException e){
		
	 return new ResponseEntity<>(e.getMessage() ,HttpStatus.NOT_FOUND);
	}

    @ExceptionHandler(InvalidDobFormatException.class)
    public ResponseEntity<String> handleDobFormat(InvalidDobFormatException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
