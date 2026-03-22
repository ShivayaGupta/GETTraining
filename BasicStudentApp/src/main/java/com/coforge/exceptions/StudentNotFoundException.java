package com.coforge.exceptions;

public class StudentNotFoundException extends RuntimeException {
     public StudentNotFoundException(String msg) {
    	 super(msg);
     }
}
